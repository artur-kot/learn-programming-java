# Exercise 023: Multiplication Table - Nested Loops

## Overview

Remember times tables from math class? Let's build them with code! You'll create a program that can show any number's multiplication table (like "5 × 1 = 5, 5 × 2 = 10...") and even print a complete grid showing all tables from 1 to 10.

This is your introduction to **nested loops** - loops inside loops. Think of them like a grid: the outer loop picks a row, and the inner loop fills in all the columns for that row.

## What You're Learning

### Nested Loops

A **nested loop** is simply a loop inside another loop. Imagine you're organizing books on shelves:
- The outer loop says "for each shelf..."
- The inner loop says "...place each book"

When one loop is inside another:
1. The outer loop runs once
2. The inner loop runs completely (all its iterations)
3. The outer loop moves to its next iteration
4. The inner loop runs completely again
5. This repeats until the outer loop finishes

**Think about it:** If you have 3 shelves and 4 books per shelf, how many books do you place total? That's 3 × 4 = 12 placements. The same math applies to nested loops!

### The Challenge

In this exercise, you'll use nested loops to:
- Generate rows and columns of a multiplication table
- Calculate products for each position in the grid
- Format output so numbers align nicely

The outer loop will control which multiplication table you're on (1s, 2s, 3s, etc.), while the inner loop will multiply that number by 1, 2, 3... up to 10.

## Your Task

Complete two methods in `MultiplicationTable.java`:

### Part 1: printSingleTable(int number)
Create a method that prints the multiplication table for ONE number.

Example: If the number is 5, print:
```
5 * 1 = 5
5 * 2 = 10
5 * 3 = 15
...up to...
5 * 10 = 50
```

You'll need:
- A loop that counts from 1 to 10
- To calculate `number * i` for each iteration
- To print the result on each line

### Part 2: printFullGrid()
Create a method that prints a complete 10×10 multiplication table showing all products from 1×1 to 10×10.

This is where nested loops come in! You need:
- An outer loop for rows (numbers 1-10)
- An inner loop for columns (numbers 1-10)
- To print `row * column` for each position
- To start a new line after each row is complete

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

## Requirements

Your implementation should:
- Print exactly 10 lines for a single table (one for each multiplier 1-10)
- Print exactly 10 rows for the full grid (one for each number 1-10)
- Each row in the full grid should contain 10 products
- Format output so it's readable (use spaces, tabs, or formatting)
- All multiplication calculations should be correct

## Testing Your Solution

Compile and run your program:
```bash
javac src/MultiplicationTable.java
java -cp src MultiplicationTable
```

Run the automated tests:
```bash
mvn test
```

The tests verify:
- Your single table prints 10 lines
- Your full grid has 10 rows
- Key values appear in the output (like 100 for 10×10)
- The math is correct

## Hints

<details>
<summary>Hint 1: Starting with Part 1</summary>

For Part 1, you only need ONE loop. Think about it:
- You have a fixed number (like 5)
- You need to multiply it by 1, then 2, then 3... up to 10
- That's a loop counting from 1 to 10!

Inside the loop, calculate `number * i` where `i` is your loop variable.
</details>

<details>
<summary>Hint 2: Understanding Nested Loops</summary>

For Part 2, imagine you're filling in a grid on paper:
1. You start at row 1, then fill in columns 1, 2, 3... 10
2. Then move to row 2, and fill in columns 1, 2, 3... 10 again
3. Continue until you've done all 10 rows

In code:
```java
for (outer loop - rows) {
    for (inner loop - columns) {
        // Calculate and print row * column
    }
    // After inner loop finishes, start a new line
}
```
</details>

<details>
<summary>Hint 3: Formatting Output</summary>

To make columns align nicely in the full grid, you can:
- Use tab characters: `System.out.print(value + "\t");`
- Or use printf: `System.out.printf("%4d", value);` (prints in a 4-character wide field)

Don't forget to print a newline after each row: `System.out.println();`
</details>

<details>
<summary>Hint 4: Print vs Println</summary>

Pay attention to when you use:
- `System.out.print()` - prints without moving to the next line (use within a row)
- `System.out.println()` - prints and moves to the next line (use at the end of a row)
</details>

## Reflection Questions

After completing this exercise, think about:

1. **Execution count**: In the full 10×10 grid, how many times does the innermost multiplication happen? Can you explain why?

2. **Loop relationship**: What happens if you swap the outer and inner loops? Would the output be the same or different?

3. **Patterns**: Look at the diagonal of the full grid (1×1, 2×2, 3×3... 10×10). What pattern do you notice?

4. **Real-world nested loops**: Where else might you use nested loops? Think about grids, tables, or repeating patterns in everyday life.

## Next Steps

Great job mastering nested loops! This is a fundamental pattern you'll use throughout programming:
- Creating 2D game boards
- Processing images (rows and columns of pixels)
- Working with spreadsheet data
- Generating reports and tables

Up next, you'll apply these loop skills to build interactive programs and work with collections of data.

## Read More

Want to dive deeper? Check out these resources:

- [Oracle Java Tutorials - Control Flow](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html)
- [GeeksforGeeks - Nested Loops in Java](https://www.geeksforgeeks.org/nested-loops-in-java/)
- [W3Schools - Java For Loop](https://www.w3schools.com/java/java_for_loop.asp)
