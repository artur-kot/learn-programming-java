# Exercise 015: Calculator - Command-Line Arguments

## Introduction

So far, you've learned to get data from the user via **Scanner** (typing into the console). But there's another way to pass data to a Java program: **command-line arguments**! When you run a program, you can add values right after the program name, and they'll be automatically passed to your `main()` method. This is how professional command-line tools work.

## What You're Learning

**Command-Line Arguments Basics:**
When you run a Java program, you can pass arguments like this:

```bash
java CalculatorArgs 10 5 add
```

These arguments (`10`, `5`, `add`) are received by your program in the `args[]` array inside the `main()` method:

```java
public static void main(String[] args) {
    // args[0] is "10"
    // args[1] is "5"
    // args[2] is "add"
}
```

**The args[] Array:**
- `args` is an array of Strings (text)
- Each argument is separated by spaces when you run the program
- `args.length` tells you how many arguments were passed
- If no arguments are passed, `args.length` is 0

**Accessing Arguments:**
```java
String first = args[0];      // Get the first argument
String second = args[1];     // Get the second argument
int num = Integer.parseInt(args[0]);  // Convert string to int
double decimal = Double.parseDouble(args[1]);  // Convert string to double
```

**Why Command-Line Arguments Matter:**
- **Scripts and Automation**: Tools can run your program with different data without user interaction
- **Batch Processing**: Process many files with a single command
- **Professional CLI Tools**: Tools like `git`, `npm`, `javac` all use command-line arguments
- **Testing**: Easy to test with different inputs without typing each time

**Important Notes:**
- Arguments are always passed as **Strings**, so you must convert them to numbers if needed
- If you pass too few arguments, your program will crash with an `ArrayIndexOutOfBoundsException`
- You should always validate how many arguments you received before using them

## Challenge

Your task: **Create a calculator that accepts two numbers and an operation as command-line arguments.**

Your calculator should:
1. Accept two numbers as arguments (e.g., `10` and `5`)
2. Accept an operation as an argument (e.g., `add`, `subtract`, `multiply`, `divide`)
3. Perform the calculation
4. Display the result
5. Handle errors gracefully (missing arguments, invalid operation, invalid numbers)

## Requirements

- Implement a `main()` method that processes command-line arguments
- Create methods for each operation: `add()`, `subtract()`, `multiply()`, `divide()`
- Validate that exactly 3 arguments are provided
- Validate that the first two arguments are valid numbers
- Validate that the operation is one of: `add`, `subtract`, `multiply`, `divide`
- Display helpful error messages if arguments are invalid
- Display the result in a clear format: "10 + 5 = 15"

## Hints

**Hint 1:** Use `args.length` to check how many arguments were provided. You need exactly 3.

**Hint 2:** Use `Integer.parseInt()` or `Double.parseDouble()` to convert strings to numbers.

**Hint 3:** Use `if` statements or a `switch` statement to determine which operation to perform.

**Hint 4:** Put validation logic early in `main()` to catch errors before doing calculations.

## Expected Behavior

Running your program with correct arguments:
```bash
java CalculatorCommandLineArgs 10 5 add
Output: 10 + 5 = 15

java CalculatorCommandLineArgs 20 4 divide
Output: 20 / 4 = 5.0

java CalculatorCommandLineArgs 7 3 multiply
Output: 7 * 3 = 21
```

Running your program with errors:
```bash
java CalculatorCommandLineArgs 10 5
Output: Error: Expected 3 arguments, got 2

java CalculatorCommandLineArgs 10 abc add
Output: Error: Invalid number: abc

java CalculatorCommandLineArgs 10 5 power
Output: Error: Unknown operation: power
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/015-calculator-command-line-args
mvn test
```

All tests should pass. Tests verify argument parsing, operations, and error handling.

## Reflection Questions

After completing this exercise, think about:

1. Why is command-line argument processing useful?
2. What happens if you don't validate the arguments before using them?
3. How would you handle floating-point vs. integer arguments?
4. Can you think of real-world tools that use command-line arguments? (Hint: Many!)

## Next Steps

Congratulations! You've completed Series 3 (Simple Calculator). You've learned:
- Basic arithmetic operations
- User input handling (Scanner)
- Advanced math operations
- Result formatting
- **Command-line argument processing**

In the next series, you'll apply these calculator skills to build **temperature converters** with multiple input methods!

## Read More

- [Command-Line Arguments in Java](https://docs.oracle.com/javase/tutorial/java/application/index.html)
- [Integer.parseInt() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String))
- [Double.parseDouble() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Double.html#parseDouble(java.lang.String))
- [Arrays in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
