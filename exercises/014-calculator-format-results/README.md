# Exercise 014: Calculator - Format Results

## Introduction

Your calculator works great, but the output isn't always polished. When dividing numbers, you might get results like `3.3333333333333335`—too many decimal places! In this exercise, you'll learn how to **format decimal numbers** to look professional and be easier to read.

## What You're Learning

**Rounding Decimal Numbers:**
Java provides two main ways to handle decimal formatting:

**1. Math.round():**
The `Math.round()` method rounds a number to the nearest integer:

```java
Math.round(3.14) = 3       // 3.14 rounds down to 3
Math.round(3.5) = 4        // 3.5 rounds up to 4
Math.round(3.9) = 4        // 3.9 rounds up to 4
```

**To round to decimal places, multiply and divide by powers of 10:**
```java
double value = 3.14159;
double rounded = Math.round(value * 100.0) / 100.0;  // Result: 3.14
// Multiply by 100 to shift 2 decimal places left
// Round to integer
// Divide by 100 to shift back
```

**2. String.format():**
The `String.format()` method creates formatted text strings:

```java
String.format("%.2f", 3.14159)      // Result: "3.14"
String.format("%.3f", 3.14159)      // Result: "3.142"
String.format("%.1f", 3.14159)      // Result: "3.1"
```

The pattern `"%.2f"` means: "format as a floating-point number with 2 decimal places"

**3. printf() for Direct Printing:**
You can use `System.out.printf()` to print formatted output directly:

```java
System.out.printf("Result: %.2f\n", 3.14159);   // Prints: Result: 3.14
System.out.printf("Pi ≈ %.5f\n", 3.14159);      // Prints: Pi ≈ 3.14159
```

**Why Formatting Matters:**
- **Readability**: `3.14` is clearer than `3.3333333333333335`
- **Consistency**: Users expect a fixed number of decimal places
- **Professionalism**: Formatted output looks polished and intentional
- **Currency**: Prices always show two decimal places ($19.99, not $19.9 or $19.995)

## Challenge

Your task: **Create methods to format decimal results in different ways, and demonstrate a calculator that displays nicely formatted output.**

Create methods:
1. **`roundToDecimals(double number, int places)`** - Rounds a number to a specific number of decimal places using `Math.round()`
2. **`formatToDecimals(double number, int places)`** - Returns a formatted string with a specific number of decimal places using `String.format()`
3. **`divide(int a, int b)`** - Divides two integers and returns a double result
4. **`displayResult(String operation, double result, int decimalPlaces)`** - Prints a formatted calculator result

## Requirements

- All methods must be `public static`
- `roundToDecimals()` and `formatToDecimals()` should handle various decimal place values
- The `displayResult()` method should use `formatToDecimals()` to show clean output
- The `main()` method should demonstrate formatting with different decimal places
- Ensure edge cases like `places = 0` work correctly

## Hints

**Hint 1:** When using `Math.round()` to get decimals, remember the pattern: multiply, round, divide.

**Hint 2:** For `String.format()`, the `%` symbol starts a format specifier, and `.2f` means "2 decimal places for a float."

**Hint 3:** Test your methods with numbers that have many decimal places, like results from division.

## Expected Behavior

When you run your program, you should see output similar to:
```
15 / 7 = 2.14
15 / 7 (3 decimals) = 2.143
15 / 7 (0 decimals) = 2
3.14159 rounded to 2 decimals = 3.14
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/014-calculator-format-results
mvn test
```

All tests should pass. Tests verify both rounding accuracy and string formatting.

## Reflection Questions

After completing this exercise, think about:

1. What's the difference between rounding and truncating (cutting off decimals)?
2. When would you use `roundToDecimals()` vs `formatToDecimals()`?
3. How does rounding affect calculations if you use the rounded result in further calculations?
4. In what real-world scenarios is decimal formatting important? (Hint: Money, measurements, scientific data...)

## Next Steps

In the next exercise, you'll learn about **error handling** and prevent one of the most common calculator errors: **dividing by zero**.

## Read More

- [String.format() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...))
- [Math.round() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Math.html#round(double))
- [DecimalFormat for Advanced Formatting](https://docs.oracle.com/javase/11/docs/api/java.base/java/text/DecimalFormat.html)
