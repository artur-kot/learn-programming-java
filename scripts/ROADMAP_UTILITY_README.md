# ROADMAP Utility Scripts

Automated scripts to clean up and renumber exercise items in ROADMAP.md files.

## Overview

These scripts automatically detect and fix numbering gaps in your ROADMAP.md file. They ensure all exercises are numbered sequentially (1, 2, 3, ..., n) without gaps.

## Features

✓ Automatic gap detection  
✓ Sequential renumbering  
✓ Preserves all formatting and content  
✓ Creates automatic backups  
✓ Check-only mode for safe inspection  
✓ Detailed reporting  

## Quick Start

### PowerShell (Windows - Recommended)

```powershell
# Check for gaps and auto-fix
.\roadmap_utility.ps1

# Check only (no modifications)
.\roadmap_utility.ps1 -CheckOnly

# Process specific file without backup
.\roadmap_utility.ps1 -FilePath "C:\path\to\ROADMAP.md" -NoBackup

# Show help
Get-Help .\roadmap_utility.ps1
```

### Python (Cross-platform)

```bash
# Check for gaps and auto-fix
python3 roadmap_utility.py

# Check only (no modifications)
python3 roadmap_utility.py --check

# Process specific file
python3 roadmap_utility.py /path/to/ROADMAP.md

# Show help
python3 roadmap_utility.py --help
```

## What It Does

### Detection
Finds all exercise items with pattern:
```
N. - [x] **Exercise Title**
```

### Validation
Checks if numbers are sequential (1, 2, 3, ..., n)

### Reporting
Shows any gaps found:
```
Line 45: Expected 16, found 17 (Temperature Converter - Switch Statements)
Line 50: Expected 17, found 19 (BMI - Get Weight and Height)
```

### Renumbering
Automatically fixes all gaps:
```
Line 45: 17 → 16 (Temperature Converter - Switch Statements)
Line 50: 19 → 17 (BMI - Get Weight and Height)
```

### Backup
Creates `ROADMAP.md.backup` before making changes

## Examples

### Before
```markdown
15. - [x] **Calculator - Command-Line Arguments**
16. - [ ] **Temperature Converter - Switch Statements**
20. - [ ] **BMI - Get Weight and Height**           # Gap!
21. - [ ] **BMI - Compute BMI**
```

### After Running Script
```
Found 1 gap(s):
  Line 51: Expected 18, found 20 (BMI - Get Weight and Height)

Renumbering exercises...
✓ Renumbered 2 exercise(s):
  Line 51: 20 → 18 (BMI - Get Weight and Height)
  Line 52: 21 → 19 (BMI - Compute BMI)

✓ File saved: ROADMAP.md (backup saved to ROADMAP.md.backup)
```

### Result
```markdown
15. - [x] **Calculator - Command-Line Arguments**
16. - [ ] **Temperature Converter - Switch Statements**
18. - [ ] **BMI - Get Weight and Height**           # Fixed!
19. - [ ] **BMI - Compute BMI**
```

## Command Reference

### PowerShell Parameters

| Parameter | Description |
|-----------|-------------|
| `-FilePath` | Path to ROADMAP.md (default: current dir) |
| `-CheckOnly` | Report gaps without modifying file |
| `-NoBackup` | Don't create backup file |

### Python Arguments

| Argument | Description |
|----------|-------------|
| (none) | Process ROADMAP.md in current directory |
| `path/to/file` | Process specific file |
| `--check` | Report gaps without modifying file |
| `--help` | Show help message |

## When to Use

Run this utility after:
- Creating new exercise directories
- Replacing or removing exercises
- Reorganizing series structure
- Manual edits to ROADMAP.md

## Safety

- **Backup Creation**: Both scripts create automatic backups before modifying
- **Check-Only Mode**: Use `-CheckOnly` or `--check` to inspect without changes
- **Reversible**: Original state preserved in `.backup` file

## Troubleshooting

### PowerShell Execution Policy Error
If you see "cannot be loaded because running scripts is disabled":

```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

Then retry the command.

### File Encoding Issues
If you see encoding errors:

**PowerShell**: Already handles UTF-8 correctly  
**Python**: Explicitly uses UTF-8 encoding

### Pattern Not Matching
The scripts look for this exact pattern:
```
N. - [x] **Title**    # Checked
N. - [ ] **Title**    # Unchecked
```

Make sure exercises follow this format exactly.

## Development Notes

### Python Version
- Uses regex for robust pattern matching
- Object-oriented design for maintainability
- Detailed type hints
- Comprehensive docstrings

### PowerShell Version
- Native Windows compatibility
- Single file, no dependencies
- Full help documentation
- Detailed progress output with colors

## Future Enhancements

Potential improvements:
- [ ] Validate exercise.json and pom.xml consistency
- [ ] Check for duplicate series numbers
- [ ] Generate statistics by phase
- [ ] Interactive mode for selective fixing
- [ ] Format verification (spacing, case, etc.)
