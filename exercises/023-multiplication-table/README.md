# Exercise 023: Multiplication Table - Nested Loops

## Overview

Master **nested loops** by building multiplication tables. This exercise progresses from printing a single number's multiplication table to creating a complete 1–10 multiplication grid. You'll combine loops with formatted output to create aligned, readable tables.

## What You're Learning

### Nested Loops

A **nested loop** is a loop inside another loop. The outer loop controls one dimension, and the inner loop controls another.

```java
for (int i = 1; i <= 3; i++) {           // Outer loop
    for (int j = 1; j <= 3; j++) {       // Inner loop
        System.out.print(i * j + " ");   // Runs 9 times total
    }
    System.out.println();                // New line after each outer iteration
}
```

**Execution flow:**
- Outer loop iteration 1 → Inner loop runs 3 times
- Outer loop iteration 2 → Inner loop runs 3 times
- Outer loop iteration 3 → Inner loop runs 3 times
- **Total inner iterations: 3 × 3 = 9**

### Single Number Multiplication Table

To print the multiplication table for a single number (e.g., 5):

```java
int n = 5;
for (int i = 1; i <= 10; i++) {
    System.out.println(n + " × " + i + " = " + (n * i));
}
```

Output:
```
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
...
5 * 10 = 50
```

### Full Multiplication Grid (1–10)

To print a complete grid, use nested loops:

```java
for (int i = 1; i <= 10; i++) {          // Rows (1-10)
    for (int j = 1; j <= 10; j++) {      // Columns (1-10)
        System.out.print((i * j) + "\t");  // Tab for alignment
    }
    System.out.println();                // New line after each row
}
```

### Formatting Tables

Use formatting to align output:

```java
// Using printf for fixed-width columns
System.out.printf("%4d", value);  // Right-align in 4-character field
```

Or use escape sequences:
```java
System.out.print(value + "\t");  // Tab character
System.out.println();             // Newline
```

## Your Task

Create a program that:

### Part 1: Single Number Multiplication Table
- **Ask the user** for a number (1-10)
- **Print the multiplication table** for that number (1-10)
- **Format each line** clearly (e.g., "5 × 3 = 15")
- **Validate input** (must be 1-10, handle invalid input)

### Part 2: Full Multiplication Grid (1–10)
- **Print a complete 10×10 multiplication table**
- **Align columns** so numbers line up nicely
- **Use a header row and column** (optional but nice)
- **Make it readable** with proper spacing

## Example Output

### Part 1 - Single Table

```
Enter a number (1-10): 7
Multiplication table for 7:
7 * 1 = 7
7 * 2 = 14
7 * 3 = 21
7 * 4 = 28
7 * 5 = 35
7 * 6 = 42
7 * 7 = 49
7 * 8 = 56
7 * 9 = 63
7 * 10 = 70
```

### Part 2 - Full Grid

```
  1   2   3   4   5   6   7   8   9  10
  2   4   6   8  10  12  14  16  18  20
  3   6   9  12  15  18  21  24  27  30
  4   8  12  16  20  24  28  32  36  40
  5  10  15  20  25  30  35  40  45  50
  6  12  18  24  30  36  42  48  54  60
  7  14  21  28  35  42  49  56  63  70
  8  16  24  32  40  48  56  64  72  80
  9  18  27  36  45  54  63  72  81  90
 10  20  30  40  50  60  70  80  90 100
```

## Algorithm

### Part 1 - Single Table:
1. Get user input for the number
2. Validate that it's between 1 and 10
3. Use a for loop from 1 to 10
4. For each i, calculate and print `number × i = result`

### Part 2 - Full Grid:
1. Create an outer loop for rows (1 to 10)
2. Inside, create an inner loop for columns (1 to 10)
3. Print the product of row × column
4. Use tabs or printf formatting for alignment
5. Print a newline after each row

## Tips

- **Outer vs Inner**: The outer loop controls rows, the inner loop controls columns
- **Formatting**: Use `\t` for tabs or `printf("%4d", value)` for fixed-width columns
- **Readability**: Add clear spacing and labels for users
- **Iteration count**: A 10×10 table requires 100 multiplications (10 outer × 10 inner iterations)

## Starter Code

```java
import java.util.Scanner;

public class MultiplicationTable {
    
    public static void printSingleTable(int number) {
        // TODO: Print multiplication table for the given number
    }
    
    public static void printFullGrid() {
        // TODO: Print the complete 10x10 multiplication table
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Part 1: Single table
        System.out.println("=== Part 1: Single Multiplication Table ===");
        // TODO: Get user input and call printSingleTable()
        
        // Part 2: Full grid
        System.out.println("\n=== Part 2: Full 1-10 Multiplication Grid ===");
        // TODO: Call printFullGrid()
    }
}
```

## Testing Hints

The test file will verify:
- Single table generates correct output for a given number
- Full grid has correct dimensions (10×10)
- All multiplication results are accurate
- Output is properly formatted
- Input validation works correctly
