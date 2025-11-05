#!/usr/bin/env pwsh
<#
.SYNOPSIS
ROADMAP Renumbering Utility (PowerShell)

.DESCRIPTION
Automatically renumbers all exercise items in ROADMAP.md to ensure they are
in sequential order (1, 2, 3, ..., n) without gaps.

.PARAMETER FilePath
Path to ROADMAP.md file. Defaults to ROADMAP.md in current directory.

.PARAMETER CheckOnly
If specified, only checks for gaps without modifying the file.

.PARAMETER NoBackup
If specified, does not create a backup of the original file.

.EXAMPLE
./roadmap_utility.ps1
# Checks ROADMAP.md and auto-fixes gaps

.EXAMPLE
./roadmap_utility.ps1 -CheckOnly
# Only reports gaps, doesn't fix

.EXAMPLE
./roadmap_utility.ps1 -FilePath "C:\path\to\ROADMAP.md" -NoBackup
# Process specific file without backup
#>

param(
    [Parameter(Mandatory = $false)]
    [string]$FilePath = "ROADMAP.md",
    
    [Parameter(Mandatory = $false)]
    [switch]$CheckOnly,
    
    [Parameter(Mandatory = $false)]
    [switch]$NoBackup
)

# Check if file exists
if (-not (Test-Path $FilePath)) {
    Write-Error "File not found: $FilePath"
    exit 1
}

# Read file
$content = Get-Content $FilePath -Raw -Encoding UTF8
$lines = $content -split "`n"

# Find all exercises with pattern: "N. - [x/space] **Title**"
$exercisePattern = '^\d+\.\s+-\s+\[[x\s]\]\s+\*\*(.+?)\*\*'
$exercises = @()

for ($i = 0; $i -lt $lines.Count; $i++) {
    if ($lines[$i] -match $exercisePattern) {
        $currentNum = [int]($lines[$i] -replace '(\d+)\..*', '$1')
        $title = $matches[1]
        $exercises += @{
            CurrentNum = $currentNum
            Title      = $title
            LineNum    = $i
        }
    }
}

if ($exercises.Count -eq 0) {
    Write-Host "No exercises found in $FilePath"
    exit 0
}

# Check for gaps
Write-Host "Checking numbering..." -ForegroundColor Cyan
$gaps = @()
$expected = 1

foreach ($exercise in $exercises) {
    if ($exercise.CurrentNum -ne $expected) {
        $gaps += "Line $($exercise.LineNum + 1): Expected $expected, found $($exercise.CurrentNum) ($($exercise.Title))"
    }
    $expected++
}

if ($gaps.Count -gt 0) {
    Write-Host "Found $($gaps.Count) gap(s):" -ForegroundColor Yellow
    $gaps | ForEach-Object { Write-Host "  $_" -ForegroundColor Yellow }
    
    if ($CheckOnly) {
        exit 1
    }
    
    Write-Host "`nRenumbering exercises..." -ForegroundColor Cyan
    
    # Renumber
    $newNum = 1
    $changes = @()
    
    foreach ($exercise in $exercises) {
        if ($exercise.CurrentNum -ne $newNum) {
            $oldLine = $lines[$exercise.LineNum]
            $newLine = $oldLine -replace '^\d+\.', "$newNum."
            $lines[$exercise.LineNum] = $newLine
            $changes += "Line $($exercise.LineNum + 1): $($exercise.CurrentNum) → $newNum ($($exercise.Title))"
        }
        $newNum++
    }
    
    Write-Host "✓ Renumbered $($changes.Count) exercise(s):" -ForegroundColor Green
    $changes | ForEach-Object { Write-Host "  $_" }
    
    # Save with backup
    if (-not $NoBackup) {
        $backupPath = "$FilePath.backup"
        Copy-Item $FilePath $backupPath
        Write-Host "Backup saved to: $backupPath" -ForegroundColor Green
    }
    
    # Write back
    $newContent = $lines -join "`n"
    Set-Content $FilePath $newContent -Encoding UTF8
    Write-Host "✓ File saved: $FilePath" -ForegroundColor Green
}
else {
    Write-Host "✓ All $($exercises.Count) exercises are numbered sequentially (1-$($exercises.Count))" -ForegroundColor Green
}

# Summary
Write-Host "`nSummary:" -ForegroundColor Cyan
Write-Host "Total exercises: $($exercises.Count)"
Write-Host "Range: 1 - $($exercises.Count)"
