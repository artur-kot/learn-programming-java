# Exercise 015: Calculator - Division Validation

## Introduction

What happens if someone tries to divide by zero? Try it on your calculator and watch it break! In this final calculator exercise, you'll learn how to **validate user input** and **prevent errors** before they crash your program. This is the cornerstone of writing robust, professional software.

## What You're Learning

**The Division by Zero Problem:**
Dividing by zero is mathematically undefined and causes a runtime error in Java:

```java
double result = 10 / 0;  // ArithmeticException!
```

Java will throw an `ArithmeticException` and crash your program. A professional calculator should never crash—it should gracefully handle the error.

**Validation Pattern:**
Before performing a dangerous operation, **check if it's safe**:

```java
if (divisor == 0) {
    System.out.println("Error: Cannot divide by zero!");
    return;  // Exit the method without performing the division
}
// Safe to divide
double result = dividend / divisor;
```

**Defensive Programming:**
This is a key principle: **assume user input might be invalid** and check before using it.

**Other Edge Cases:**
While division by zero is the primary concern, you might also consider:
- Very large numbers that could cause overflow
- Negative divisors (mathematically valid, but check business logic)
- Zero dividend (dividing zero by a number is fine: `0 / 5 = 0`)

**Return Values and Error States:**
When a method detects an error, it needs to communicate this to the caller. Options include:
- **Return a special value**: Return -1 or `Double.NaN` to indicate error
- **Return boolean**: Use a separate method to check validity first
- **Print error message**: Display an error and exit gracefully
- **Use exceptions** (more advanced): Throw an exception to signal an error

For now, we'll focus on simple approaches: validation checks and error messages.

## Challenge

Your task: **Create a safe division method that validates inputs and prevents division by zero errors.**

Create methods:
1. **`isValidDivisor(double divisor)`** - Returns `true` if the divisor is not zero, `false` otherwise
2. **`safeDivide(double dividend, double divisor)`** - Performs division only if divisor is valid, otherwise returns a special value (like `Double.NaN` or -1)
3. **`divideSafe(double dividend, double divisor)`** - Performs division with validation and prints error message if divisor is zero
4. **`validateAndCalculate(int a, int b)`** - Takes two integers, validates before division, and returns formatted result or error message

## Requirements

- All validation methods must be `public static`
- `isValidDivisor()` should return a boolean
- `safeDivide()` should return `Double.NaN` if divisor is zero, otherwise return the division result
- `divideSafe()` should print an error message to console if divisor is zero
- `validateAndCalculate()` should return a meaningful string result or error message
- The `main()` method should demonstrate safe division with various inputs including edge cases

## Hints

**Hint 1:** Use `if (divisor == 0)` to check for zero.

**Hint 2:** `Double.NaN` is a special value meaning "Not a Number"—use it to indicate an error in `safeDivide()`.

**Hint 3:** Always validate before dividing. Think of it like checking your mirrors before turning while driving!

## Expected Behavior

When you run your program, you should see output similar to:
```
10 / 2 = 5.0
10 / 0 = Error: Cannot divide by zero!
0 / 5 = 0.0
Result: 15.0 / 3.0 = 5.0
Error: 20.0 / 0.0 = Cannot divide by zero!
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/015-calculator-division-validation
mvn test
```

All tests should pass. Tests verify both valid divisions and error cases.

## Reflection Questions

After completing this exercise, think about:

1. Why is input validation important in real-world software?
2. What other operations might need validation beyond division?
3. How would you handle errors if you were building a GUI calculator app?
4. What's the difference between preventing an error and handling an error after it occurs?

## Next Steps

Congratulations! You've completed Series 3 (Simple Calculator). You've learned:
- Basic arithmetic operations
- User input handling
- Advanced math operations
- Result formatting
- Error prevention

In the next series, you'll build on these skills to create **temperature converters** and other practical applications!

## Read More

- [Input Validation Best Practices](https://www.geeksforgeeks.org/input-validation-in-java/)
- [Defensive Programming](https://www.geeksforgeeks.org/defensive-programming/)
- [Double.NaN Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Double.html#NaN)
- [Exception Handling (Preview)](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
