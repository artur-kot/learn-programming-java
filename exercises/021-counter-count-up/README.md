# Exercise 021: Counter - Count Up and Down

## Overview

Your task is to print numbers in two ways: first counting up from 1 to 10, then counting down from 10 to 1. This exercise teaches you how to use for loops and modify their behavior.

## What You're Learning

### For Loops

A **for loop** repeats a block of code a specific number of times. The basic syntax is:

```java
for (initialization; condition; increment) {
    // Code to repeat
}
```

Breaking this down:
- **Initialization**: Sets up the loop variable (e.g., `int i = 1`)
- **Condition**: Checks if the loop should continue (e.g., `i <= 10`)
- **Increment**: Updates the loop variable after each iteration (e.g., `i++` or `i--`)
- **Body**: The code that runs each iteration

### Counting Up

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

This will print:
```
1
2
...
10
```

### Counting Down

To count backwards, modify the loop:
- Start from 10 instead of 1
- Use `>=` instead of `<=`
- Use `i--` instead of `i++`

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

This will print:
```
10
9
...
1
```

## Your Task

Write a Java program that:

1. **First loop**: Counts from 1 to 10 using a for loop with `i++`
2. **Second loop**: Counts from 10 to 1 using a for loop with `i--`
3. **Prints each number** on a new line
4. **Does not ask for user input**
5. **Uses `System.out.println()` to print each number**

## Example Output

```
1
2
3
4
5
6
7
8
9
10
10
9
8
7
6
5
4
3
2
1
```

## Tips

For the first loop:
- Start with `int i = 1`
- Use `i <= 10` as your condition
- Use `i++` to increment

For the second loop:
- Start with `int i = 10`
- Use `i >= 1` as your condition
- Use `i--` to decrement

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

## Next Steps

After completing this exercise, you'll extend it in Exercise 022 by calculating a sum of numbers using an accumulator pattern!
