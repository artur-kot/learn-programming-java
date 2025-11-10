# Exercise 049: Exception Basics

## Introduction

Imagine you're building a file reader that asks users for a filename. What happens if the file doesn't exist? Or a calculator where users enter "five" instead of "5"? Without proper error handling, your program crashes with scary red error messages. In this exercise, you'll learn how to catch and handle these errors gracefully, making your programs robust and user-friendly.

## What You're Learning

**Understanding Exceptions**

An exception is an event that disrupts the normal flow of your program. When something unexpected happens - like dividing by zero, accessing a missing file, or parsing invalid input - Java throws an exception. If you don't catch it, your program terminates abruptly.

**The Exception Hierarchy**

All exceptions in Java inherit from the `Throwable` class. The two main branches are:
- **Exception**: Checked exceptions you should handle (IOException, SQLException)
- **RuntimeException**: Unchecked exceptions (ArithmeticException, NullPointerException, NumberFormatException)

Common exception types you'll encounter:
- `ArithmeticException` - mathematical errors like division by zero
- `NumberFormatException` - parsing invalid number strings
- `IOException` - file reading/writing errors
- `NullPointerException` - accessing methods/fields on null objects
- `ArrayIndexOutOfBoundsException` - accessing invalid array indices

**The Try-Catch-Finally Structure**

The try-catch-finally block lets you handle errors without crashing:

```java
try {
    // Code that might throw an exception
    int result = 10 / 0;
} catch (ArithmeticException e) {
    // Code that runs if the exception occurs
    System.out.println("Cannot divide by zero!");
} finally {
    // Code that ALWAYS runs, whether exception occurred or not
    System.out.println("Calculation attempted.");
}
```

**Multiple Catch Blocks**

You can handle different exceptions differently by using multiple catch blocks:

```java
try {
    String text = "abc";
    int number = Integer.parseInt(text);
    int result = 100 / number;
} catch (NumberFormatException e) {
    System.out.println("Invalid number format: " + e.getMessage());
} catch (ArithmeticException e) {
    System.out.println("Math error: " + e.getMessage());
}
```

Catch blocks are checked in order from top to bottom. More specific exceptions should come before more general ones.

**The Exception Object**

When you catch an exception, you receive an exception object with useful information:
- `e.getMessage()` - returns the error message
- `e.printStackTrace()` - prints the full error stack trace
- `e.toString()` - returns exception class name and message

**The Finally Block**

The finally block is optional but powerful. It executes regardless of whether an exception was thrown or caught. This is perfect for cleanup operations like closing files or releasing resources:

```java
Scanner scanner = null;
try {
    scanner = new Scanner(new File("data.txt"));
    // Read from file
} catch (FileNotFoundException e) {
    System.out.println("File not found!");
} finally {
    if (scanner != null) {
        scanner.close(); // Always close resources
    }
}
```

**Try-With-Resources (Modern Approach)**

Java 7 introduced a cleaner way to handle resources that automatically closes them:

```java
try (Scanner scanner = new Scanner(new File("data.txt"))) {
    // Read from file
} catch (FileNotFoundException e) {
    System.out.println("File not found!");
}
// Scanner automatically closed, no finally block needed!
```

**Why Exception Handling Matters**

- **Robustness**: Programs handle errors gracefully instead of crashing
- **User Experience**: Display friendly error messages instead of stack traces
- **Debugging**: Control what happens when errors occur
- **Resource Management**: Ensure files, connections, and resources are properly closed
- **Professional Code**: All production software requires proper error handling

## Challenge

Your task is to implement methods that demonstrate safe exception handling in various scenarios.

You'll create methods that:
1. Handle division by zero using try-catch
2. Parse strings to integers with error handling
3. Read file contents with proper resource management
4. Demonstrate the finally block execution pattern

## Requirements

- Implement `safeDivide(int a, int b)` - returns the division result or 0 if division by zero
- Implement `parseIntSafely(String str)` - returns the parsed integer or 0 if invalid
- Implement `readFileContent(String filename)` - returns file content or error message
- Implement `demonstrateFinally()` - shows finally block execution in different scenarios
- All methods must use appropriate try-catch blocks
- Use try-with-resources for file reading
- Handle exceptions gracefully with informative messages
- Use multiple catch blocks where appropriate

## Hints

<details>
<summary>Hint 1: Division by Zero</summary>

When you divide by zero, Java throws an `ArithmeticException`. Wrap the division in a try-catch block and catch this specific exception type.
</details>

<details>
<summary>Hint 2: Parsing Strings</summary>

`Integer.parseInt()` throws `NumberFormatException` when the string isn't a valid number. Catch this exception and return a default value.
</details>

<details>
<summary>Hint 3: Reading Files</summary>

Use try-with-resources to automatically close the file reader:
```java
try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    // Read file
} catch (IOException e) {
    // Handle error
}
```
</details>

<details>
<summary>Hint 4: Finally Block Demonstration</summary>

Create multiple scenarios: one that throws an exception, one that doesn't, and one that returns early. Show that finally always executes.
</details>

## Expected Behavior

Your methods should handle errors gracefully:

```
safeDivide(10, 2) returns 5
safeDivide(10, 0) returns 0 and prints "Error: Cannot divide by zero"

parseIntSafely("42") returns 42
parseIntSafely("abc") returns 0 and prints "Error: Invalid number format"

readFileContent("existing.txt") returns the file contents
readFileContent("missing.txt") returns "Error: File not found - missing.txt"

demonstrateFinally() shows finally block executing in all scenarios
```

## Testing Instructions

Run the tests to verify your implementation:

```bash
cd exercises/049-exception-basics
mvn test
```

All tests should pass, demonstrating proper exception handling in various scenarios.

## Reflection Questions

After completing this exercise, consider:

1. What's the difference between checked and unchecked exceptions?
2. Why is the order of catch blocks important?
3. When would you use try-with-resources vs try-catch-finally?
4. How does proper exception handling improve user experience?
5. What happens if you don't catch an exception?

## Next Steps

In the next exercise, you'll learn to create your own custom exception classes to represent specific error conditions in your applications!

## Read More

- [Exception Handling in Java](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [The try-with-resources Statement](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [Unchecked Exceptions — The Controversy](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)
- [Exception Class Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Exception.html)
