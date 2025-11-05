# Exercise 017: BMI Calculator - Basics

## Overview

Learn how to build a simple BMI (Body Mass Index) calculator. This exercise focuses on:
- Input validation and parsing
- Mathematical formulas
- Conditional logic with if/else
- Formatting numeric output

## The Challenge

Write a program that:

1. **Gets user input** for weight and height
   - Weight in kilograms (decimal number)
   - Height in meters (decimal number)

2. **Calculates BMI** using the formula:
   ```
   BMI = weight / (height * height)
   ```

3. **Displays the BMI** value formatted to 1 decimal place

### Example Run

```
Enter your weight (kg): 70
Enter your height (m): 1.75
Your BMI is: 22.9
```

## Required Methods

Implement the following methods in `BMICalculator.java`:

### `public static double calculateBMI(double weight, double height)`
- Takes weight in kg and height in meters
- Returns BMI as a double
- Throws `IllegalArgumentException` if weight ≤ 0 or height ≤ 0

### `public static void main(String[] args)`
- Prompts user for weight and height
- Uses try...catch to handle invalid input (NumberFormatException)
- Calls `calculateBMI()` to compute the value
- Displays result formatted to 1 decimal place using `printf`

## Hints

- Use `Scanner.nextDouble()` to read decimal numbers
- Wrap input reading in try...catch blocks
- Use `printf("%.1f")` to format to 1 decimal place
- Validate that weight and height are positive values

## Concepts You'll Practice

- Input validation with try...catch
- Mathematical calculations
- Conditional logic (if/else) for error checking
- Output formatting with printf
- Method design and reusability

## Testing

Your code will be tested with:
- Valid weight and height inputs
- Negative and zero values (should throw IllegalArgumentException)
- Invalid input types (caught by try...catch)
- Formatting verification (1 decimal place)

---

## Read More
- [Throwing Exceptions in Java](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)
- [IllegalArgumentException Documentation](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html)