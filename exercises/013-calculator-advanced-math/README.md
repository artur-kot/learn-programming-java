# Exercise 013: Calculator - Advanced Math

## Introduction

Your calculator is getting more powerful! In this exercise, you'll expand it beyond basic operations to include **advanced mathematical operations** using Java's `Math` library. You'll learn about modulo, exponentiation, and square roots—operations that are essential in many real-world programs.

## What You're Learning

**The Math Library:**
Java provides a built-in `Math` class with useful mathematical methods. No import needed—it's part of `java.lang` which is automatically available:

```java
Math.pow(base, exponent)      // Power: 2^3 = 8
Math.sqrt(number)             // Square root: √16 = 4.0
Math.abs(number)              // Absolute value: |-5| = 5
Math.max(a, b)                // Maximum of two numbers
Math.min(a, b)                // Minimum of two numbers
```

**Modulo Operator (`%`):**
The modulo operator returns the **remainder** after division. This is useful for checking if numbers are even or odd:

```java
10 % 3 = 1      // 10 divided by 3 leaves remainder 1
10 % 2 = 0      // 10 divided by 2 leaves remainder 0 (even)
7 % 2 = 1       // 7 divided by 2 leaves remainder 1 (odd)
```

**Power (Exponentiation):**
`Math.pow(base, exponent)` raises a number to a power:

```java
Math.pow(2, 3) = 8.0        // 2 × 2 × 2
Math.pow(5, 2) = 25.0       // 5 × 5
Math.pow(10, 0) = 1.0       // Any number to the 0 power is 1
```

**Square Root:**
`Math.sqrt(number)` finds the square root:

```java
Math.sqrt(16) = 4.0         // √16 = 4
Math.sqrt(25) = 5.0         // √25 = 5
Math.sqrt(2) ≈ 1.414        // √2 (irrational number)
```

**Important Note on Return Types:**
Methods in the `Math` library return `double` values, even if you give them integers.

## Challenge

Your task: **Implement methods for three advanced mathematical operations: modulo, power, and square root.**

Create methods:
1. **`modulo(int a, int b)`** - Returns the remainder when `a` is divided by `b`
2. **`power(double base, double exponent)`** - Returns `base` raised to the `exponent` power
3. **`squareRoot(double number)`** - Returns the square root of a number

## Requirements

- Implement all three methods in the `CalculatorAdvancedMath` class
- All methods must be `public static`
- Use the `Math` library methods where appropriate
- Modulo takes `int` parameters; power and square root take `double` parameters
- The `main` method should demonstrate each operation with example values
- Handle the case where the number might be negative (for square root)

## Hints

**Hint 1:** For modulo, remember it's an operator (like `+` or `-`), not a method call.

**Hint 2:** To use `Math.pow()` and `Math.sqrt()`, simply write them as `Math.methodName()`.

**Hint 3:** Test edge cases like modulo by zero, negative exponents, and negative square roots.

## Expected Behavior

When you run your program, you should see output similar to:
```
10 % 3 = 1
2 ^ 3 = 8.0
√16 = 4.0
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/013-calculator-advanced-math
mvn test
```

All tests should pass. The tests include edge cases with negative and decimal numbers.

## Reflection Questions

After completing this exercise, think about:

1. Why does `Math.pow()` return a `double` even when you pass integers?
2. What happens when you try to find the square root of a negative number in Java? (Hint: Try it!)
3. When would you use modulo in a real program? (Hint: Checking even/odd, cycling through values...)
4. How is modulo different from division?

## Next Steps

In the next exercise, you'll learn how to **format decimal numbers** to show a specific number of digits, making your calculator output more professional and readable.

## Read More

- [Math Class Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Math.html)
- [Modulo Operator in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)
- [Powers and Square Roots](https://www.geeksforgeeks.org/power-and-square-root-in-java/)
