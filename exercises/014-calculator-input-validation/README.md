# Exercise 014: Calculator - Input Validation with Exception Handling

## Introduction

Your calculator has been working well, but what happens when a user types "abc" when the program asks for a number? The program crashes! In this exercise, you'll learn how to **handle invalid input gracefully** using **try...catch blocks** and **exception handling**. You'll also learn how to keep asking the user until they provide valid input.

## What You're Learning

**What Are Exceptions?**
An exception is an error that occurs while a program is running. Examples include:
- `NumberFormatException` - when you try to convert a non-numeric string to a number
- `InputMismatchException` - when Scanner gets unexpected input type
- `ArrayIndexOutOfBoundsException` - when you access an array index that doesn't exist

When an exception occurs, the program crashes unless you **catch** it and handle it gracefully.

**The Try...Catch Block:**
The try...catch block lets you handle errors without crashing:

```java
try {
    // Code that might throw an exception
    int number = Integer.parseInt("abc");  // This will throw NumberFormatException
} catch (NumberFormatException e) {
    // Code that runs if an exception occurred
    System.out.println("Error: That's not a valid number!");
}
System.out.println("Program continues...");  // This runs either way
```

**Multiple Catch Blocks:**
You can handle different types of exceptions differently:

```java
try {
    int number = Integer.parseInt(input);
    int result = 10 / number;
} catch (NumberFormatException e) {
    System.out.println("Error: Invalid number format!");
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero!");
}
```

**Using Loops for Validation:**
Combine try...catch with a loop to keep asking until valid input is received:

```java
int number = -1;  // Initialize with invalid value
while (true) {
    try {
        System.out.print("Enter a number: ");
        number = Integer.parseInt(scanner.nextLine());
        break;  // Exit loop on success
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number.");
    }
}
```

**The finally Block (Optional):**
Code in a `finally` block always runs, whether an exception occurred or not:

```java
try {
    // Some code
} catch (Exception e) {
    // Handle error
} finally {
    System.out.println("This always runs!");
}
```

**Why Exception Handling Matters:**
- **User Experience**: Programs don't crash; users get helpful error messages
- **Robustness**: Professional software handles unexpected input gracefully
- **Debugging**: You control what happens when errors occur
- **Trust**: Users trust software that handles errors well

## Challenge

Your task: **Create a calculator that safely reads user input and handles invalid numbers with try...catch blocks.**

Create methods:
1. **`readInteger(Scanner scanner, String prompt)`** - Asks user for an integer; keeps asking until valid input is provided
2. **`readDouble(Scanner scanner, String prompt)`** - Asks user for a double; keeps asking until valid input is provided
3. **`calculateWithValidation()`** - Reads two numbers from the user safely and performs a calculation
4. **`add(double a, double b)`** - Returns the sum
5. **`divide(double a, double b)`** - Returns the quotient (or handles division by zero)

## Requirements

- All methods must be `public static`
- `readInteger()` and `readDouble()` must use try...catch to handle `NumberFormatException`
- Use a loop to keep asking until valid input is provided
- Display clear error messages when invalid input occurs
- Display helpful prompts to guide the user
- The `main()` method should demonstrate reading two numbers and performing calculations
- Handle division by zero gracefully (return special value or print error)

## Hints

**Hint 1:** Use `scanner.nextLine()` to read the entire line as a string, then parse it. This makes it easier to re-prompt on error.

**Hint 2:** Use `Integer.parseInt()` or `Double.parseDouble()` inside the try block. These throw `NumberFormatException` for invalid input.

**Hint 3:** Use a `while (true)` loop with `break` to keep asking until valid input is received.

**Hint 4:** Always catch the specific exception type (`NumberFormatException`) to handle it appropriately.

## Expected Behavior

When you run your program, you should see interaction similar to:
```
Enter first number: abc
Invalid input. Please enter a valid number.
Enter first number: 10
Enter second number: 5
10 + 5 = 15.0

Enter first number: xyz
Invalid input. Please enter a valid number.
Enter first number: 20
Enter second number: hello
Invalid input. Please enter a valid number.
Enter second number: 4
20 / 4 = 5.0
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/014-calculator-format-results
mvn test
```

All tests should pass. Tests verify that methods handle both valid and invalid input correctly.

## Reflection Questions

After completing this exercise, think about:

1. Why is exception handling important for user input?
2. What other types of exceptions might occur in a calculator program?
3. When would you use a try...catch block vs. input validation with if statements?
4. How does using a loop for validation improve user experience?

## Next Steps

In the next exercise, you'll learn about **formatting decimal numbers** to display results professionally, and then move on to **command-line argument processing** to make your calculator work with different input methods!

## Read More

- [Exception Handling in Java](https://docs.oracle.com/javase/tutorial/essential/exceptions/)
- [Try-Catch Blocks](https://docs.oracle.com/javase/tutorial/essential/exceptions/try.html)
- [NumberFormatException Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/NumberFormatException.html)
- [Scanner nextLine() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/util/Scanner.html#nextLine())
