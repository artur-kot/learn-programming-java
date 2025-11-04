# Exercise 011: Calculator - Basic Operations

## Introduction

Welcome to Series 3! In this series, you'll build a Calculator app that performs mathematical operations. This first exercise focuses on the **foundation of any calculator: basic arithmetic operations**. You'll learn how to use Java's operators to add, subtract, multiply, and divide numbers.

## What You're Learning

**Arithmetic Operators:**
Java provides several operators for performing mathematical calculations:

- **Addition `+`**: Combines two numbers: `5 + 3` = `8`
- **Subtraction `-`**: Finds the difference: `10 - 4` = `6`
- **Multiplication `*`**: Multiplies numbers: `7 * 6` = `42`
- **Division `/`**: Divides numbers: `20 / 4` = `5`

**Important Notes:**
- When dividing **integers** (whole numbers), the result is also an integer. For example: `7 / 2` = `3` (not `3.5`!)
- To get decimal results, use **double** (numbers with decimal points): `7.0 / 2.0` = `3.5`
- Order matters with subtraction and division: `10 - 5` is different from `5 - 10`

**Expression Evaluation:**
Java follows standard mathematical rules (called **operator precedence**):
- Multiplication and division are performed before addition and subtraction
- Parentheses change the order: `(5 + 3) * 2` = `16` but `5 + 3 * 2` = `11`

**Variable Assignment:**
You can store the result of a calculation in a variable:
```java
int result = 10 + 5;  // result now holds 15
double answer = 20.0 / 4.0;  // answer now holds 5.0
```

## Challenge

Your task: **Implement four methods in the `CalculatorBasic` class that perform basic arithmetic operations.**

Create methods that:
1. **`add(int a, int b)`** - Returns the sum of two numbers
2. **`subtract(int a, int b)`** - Returns the difference of two numbers
3. **`multiply(int a, int b)`** - Returns the product of two numbers
4. **`divide(double a, double b)`** - Returns the result of dividing `a` by `b`

## Requirements

- All methods must be `public static`
- Methods must take the correct parameter types (int for first three, double for divide)
- Methods must return the correct result type
- Each method should perform only one arithmetic operation
- The `main` method should demonstrate each operation with example values

## Hints

**Hint 1:** Think about the pattern. Each method is simple: take two parameters and apply one operator.

**Hint 2:** Remember to use the correct data type for division. Using `int` for division will lose the decimal part!

**Hint 3:** Test your methods by calling them from `main()` with different numbers and printing the results.

## Expected Behavior

When you run your program, you should see output similar to:
```
10 + 5 = 15
20 - 8 = 12
7 * 6 = 42
15.0 / 3.0 = 5.0
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/011-calculator-basic-operations
mvn test
```

All tests should pass. If any fail, read the error message to understand what needs to be fixed.

## Reflection Questions

After completing this exercise, think about:

1. Why do we need to use `double` for division instead of `int`?
2. What would happen if you tried to divide two `int` values? Would the result be accurate?
3. Can you think of a real-world scenario where each operation would be useful?
4. What happens if you divide by zero? (Don't try it yet - we'll handle that in a later exercise!)

## Next Steps

In the next exercise, you'll learn how to get these numbers from **user input** instead of hardcoding them. This will make your calculator interactive!

## Read More

- [Java Arithmetic Operators](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Operator Precedence in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Integer vs Double in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
