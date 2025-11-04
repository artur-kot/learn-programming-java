# Exercise 012: Calculator - User Input

## Introduction

Now that you know how to implement basic arithmetic operations, it's time to make your calculator **interactive**! In this exercise, you'll learn how to accept numbers from the user and use them with the calculator methods you built in the previous exercise.

## What You're Learning

**Scanner for User Input:**
To read data from the user, you use the `Scanner` class from Java's `java.util` package:

```java
import java.util.Scanner;
```

Creating a Scanner:
```java
Scanner scanner = new Scanner(System.in);
```

**Reading Different Data Types:**

- **`nextInt()`** - Reads an integer from the user
  ```java
  int number = scanner.nextInt();
  ```

- **`nextDouble()`** - Reads a decimal number from the user
  ```java
  double price = scanner.nextDouble();
  ```

- **`nextLine()`** - Reads an entire line of text
  ```java
  String name = scanner.nextLine();
  ```

**User Prompts:**
Always tell the user what input you expect before reading:
```java
System.out.print("Enter first number: ");
int num1 = scanner.nextInt();
System.out.print("Enter second number: ");
int num2 = scanner.nextInt();
```

**Important Notes:**
- `System.out.print()` doesn't add a newline, so the user types on the same line
- `System.out.println()` adds a newline after the text
- The program waits for the user to type and press Enter before continuing

## Challenge

Your task: **Create an interactive calculator that asks the user for two numbers, performs basic operations, and displays the results.**

Your calculator should:
1. Ask the user to enter the first number
2. Ask the user to enter the second number
3. Perform all four operations (add, subtract, multiply, divide) using methods from the previous exercise
4. Display each result clearly

## Requirements

- Use the `CalculatorUserInput` class with a `main()` method
- Use `Scanner` to read user input
- Reuse the calculator methods from exercise 011 (or implement them here if needed)
- Display clear prompts so the user knows what to enter
- Show each operation result with a label (e.g., "10 + 5 = 15")
- Handle `double` values for division to preserve decimals

## Hints

**Hint 1:** Remember to import `Scanner` at the top of your file!

**Hint 2:** Create one `Scanner` object at the start of `main()`, use it multiple times, and close it at the end.

**Hint 3:** Test with different numbers to verify each operation works correctly.

## Expected Behavior

When you run the program, it should look like this:

```
Enter first number: 20
Enter second number: 4
20 + 4 = 24
20 - 4 = 16
20 * 4 = 80
20 / 4 = 5.0
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/012-calculator-user-input
mvn test
```

All tests should pass. Pay attention to test names to understand what behavior is expected.

## Reflection Questions

After completing this exercise, think about:

1. What happens if a user enters text instead of a number when the program expects a number?
2. How would you improve the user experience? (Hint: Better prompts? Clearer output formatting?)
3. Why is it important to close the Scanner when you're done using it?

## Next Steps

In the next exercise, you'll expand your calculator with **advanced mathematical operations** like modulo, power, and square root using Java's `Math` library!

## Read More

- [Scanner Class Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/util/Scanner.html)
- [Java Input and Output](https://docs.oracle.com/javase/tutorial/i18n/resbundle/index.html)
- [Getting User Input in Java](https://www.geeksforgeeks.org/how-to-take-input-from-user-in-java/)
