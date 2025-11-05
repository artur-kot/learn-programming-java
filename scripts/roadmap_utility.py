#!/usr/bin/env python3
"""
ROADMAP Renumbering Utility

This script automatically renumbers all exercise items in ROADMAP.md to ensure
they are in sequential order (1, 2, 3, ..., n) without gaps.

Usage:
    python3 roadmap_utility.py                 # Process ROADMAP.md in current directory
    python3 roadmap_utility.py /path/to/ROADMAP.md  # Process specific file
    python3 roadmap_utility.py --check         # Check for gaps without modifying
    python3 roadmap_utility.py --help          # Show this help message

Features:
    - Automatically detects all numbered exercise items
    - Renumbers them sequentially
    - Preserves all formatting and content
    - Creates backup of original file
    - Reports any gaps found
"""

import re
import sys
from pathlib import Path
from typing import List, Tuple


class ROADMAPUtility:
    """Utility for managing and renumbering ROADMAP.md files"""
    
    # Pattern to match exercise items: "123. - [x] or [ ] **Title**"
    EXERCISE_PATTERN = re.compile(r'^(\d+)\.\s+-\s+\[[\sx]\]\s+\*\*(.+?)\*\*', re.MULTILINE)
    
    def __init__(self, filepath: Path):
        """Initialize with path to ROADMAP.md file"""
        self.filepath = filepath
        if not self.filepath.exists():
            raise FileNotFoundError(f"File not found: {self.filepath}")
        
        self.content = self.filepath.read_text(encoding='utf-8')
        self.lines = self.content.split('\n')
    
    def find_exercises(self) -> List[Tuple[int, str, int]]:
        """
        Find all exercise items in the file.
        
        Returns:
            List of (current_number, title, line_number) tuples
        """
        exercises = []
        for line_num, line in enumerate(self.lines):
            match = re.match(r'^(\d+)\.\s+-\s+\[[\sx]\]\s+\*\*(.+?)\*\*', line)
            if match:
                current_num = int(match.group(1))
                title = match.group(2)
                exercises.append((current_num, title, line_num))
        return exercises
    
    def check_gaps(self) -> Tuple[bool, List[str]]:
        """
        Check if exercises are numbered sequentially.
        
        Returns:
            Tuple of (is_valid, messages) where is_valid is True if no gaps
        """
        exercises = self.find_exercises()
        if not exercises:
            return True, ["No exercises found in ROADMAP.md"]
        
        messages = []
        expected = 1
        gaps = []
        
        for current_num, title, line_num in exercises:
            if current_num != expected:
                gaps.append(f"Line {line_num + 1}: Expected {expected}, found {current_num} ({title})")
            expected += 1
        
        if gaps:
            messages.append(f"Found {len(gaps)} numbering gap(s):")
            messages.extend(gaps)
            return False, messages
        else:
            messages.append(f"✓ All {len(exercises)} exercises are numbered sequentially (1-{len(exercises)})")
            return True, messages
    
    def renumber(self) -> Tuple[int, List[str]]:
        """
        Renumber all exercises sequentially.
        
        Returns:
            Tuple of (count_changed, messages)
        """
        exercises = self.find_exercises()
        if not exercises:
            return 0, ["No exercises found to renumber"]
        
        messages = []
        changes = []
        new_lines = self.lines.copy()
        
        for new_num, (old_num, title, line_num) in enumerate(exercises, 1):
            if old_num != new_num:
                old_line = new_lines[line_num]
                # Replace the number, preserving everything else
                new_line = re.sub(r'^\d+\.', f'{new_num}.', old_line)
                new_lines[line_num] = new_line
                changes.append(f"Line {line_num + 1}: {old_num} → {new_num} ({title})")
        
        if changes:
            self.content = '\n'.join(new_lines)
            self.lines = new_lines
            messages.append(f"✓ Renumbered {len(changes)} exercise(s):")
            messages.extend(changes)
        else:
            messages.append("✓ No renumbering needed - all exercises already sequential")
        
        return len(changes), messages
    
    def save(self, backup: bool = True) -> str:
        """
        Save the modified content back to file.
        
        Args:
            backup: If True, create .backup file
            
        Returns:
            Status message
        """
        if backup:
            backup_path = self.filepath.with_suffix('.backup')
            backup_path.write_text(self.filepath.read_text(encoding='utf-8'), encoding='utf-8')
            backup_msg = f" (backup saved to {backup_path.name})"
        else:
            backup_msg = ""
        
        self.filepath.write_text(self.content, encoding='utf-8')
        return f"✓ File saved: {self.filepath}{backup_msg}"
    
    def generate_report(self) -> str:
        """Generate a summary report of the ROADMAP"""
        exercises = self.find_exercises()
        
        if not exercises:
            return "No exercises found"
        
        report = []
        report.append(f"ROADMAP Summary: {len(exercises)} exercises")
        report.append("-" * 50)
        
        # Group by series (every exercise with same "decade" is in same series conceptually)
        current_group = None
        for num, title, _ in exercises:
            if current_group is None or (num - 1) // 5 != (exercises[exercises.index((num, title, _)) - 1][0] - 1) // 5:
                current_group = num
                report.append(f"\n{num}-{num+4}:")
            report.append(f"  {num}. {title}")
        
        return "\n".join(report)


def main():
    """Main entry point"""
    if len(sys.argv) > 1:
        if sys.argv[1] in ['--help', '-h']:
            print(__doc__)
            return 0
        elif sys.argv[1] == '--check':
            filepath = Path('ROADMAP.md')
        else:
            filepath = Path(sys.argv[1])
    else:
        filepath = Path('ROADMAP.md')
    
    try:
        util = ROADMAPUtility(filepath)
        
        # Check for gaps
        is_valid, check_msgs = util.check_gaps()
        print("\n".join(check_msgs))
        
        if not is_valid and '--check' not in sys.argv:
            print("\nRenumbering exercises...")
            count_changed, renumber_msgs = util.renumber()
            print("\n".join(renumber_msgs))
            
            if count_changed > 0:
                save_msg = util.save(backup=True)
                print(save_msg)
                print("\n" + util.generate_report())
            
        return 0
    
    except FileNotFoundError as e:
        print(f"Error: {e}", file=sys.stderr)
        return 1
    except Exception as e:
        print(f"Error: {e}", file=sys.stderr)
        return 1


if __name__ == '__main__':
    sys.exit(main())
