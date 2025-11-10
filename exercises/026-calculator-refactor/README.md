# Exercise 026: Calculator Refactor - Modular Design & Method Organization

## Overview

You're inheriting a working calculator application, but there's a problem: the code is a mess! All the logic is crammed into one giant method, making it hard to read, understand, and maintain. Your mission is to **refactor** this messy code by extracting logical pieces into well-organized, reusable methods.

This is what real programmers do every day - taking working but poorly organized code and making it clean, modular, and maintainable.

## What You're Learning

### What is Refactoring?

**Refactoring** means improving code structure without changing what it does. The calculator works perfectly right now - your job is to make the code better organized, more readable, and easier to maintain.

Think of it like organizing a messy room: everything is there and functional, but scattered everywhere. After organizing, everything has its proper place and you can find what you need quickly.

### Why Extract Methods?

Breaking large chunks of code into smaller methods provides several benefits:

**Before (Messy):**
```java
public static void main(String[] args) {
    // 150 lines of tangled logic all in one place
    // Hard to read, hard to understand, hard to fix bugs
}
```

**After (Clean):**
```java
public static void main(String[] args) {
    displayMenu();
    int choice = getUserChoice();
    double num1 = getNumberInput("first");
    double num2 = getNumberInput("second");
    performOperation(choice, num1, num2);
}
```

Each method now has a **single, clear responsibility**.

### The DRY Principle

**DRY = Don't Repeat Yourself**

If you're writing the same code multiple times, extract it into a method and call that method instead. This makes your code:
- Easier to maintain (fix bugs in one place, not five)
- More consistent (same behavior everywhere)
- More readable (clear method names explain what's happening)

### Modular Architecture

**Modular design** means building your program from small, focused pieces that work together. Each piece (method) should:
- Do one thing well
- Have a clear, descriptive name
- Be reusable in different contexts
- Be easy to test and debug

## Your Task

You'll receive a working calculator with all logic jumbled in the `main()` method. Your job is to **refactor** it by extracting methods for each logical operation.

### Methods to Extract

Create these methods to organize the code:

1. **`add(double a, double b)`** - Returns the sum of two numbers
2. **`subtract(double a, double b)`** - Returns the difference
3. **`multiply(double a, double b)`** - Returns the product
4. **`divide(double a, double b)`** - Returns the quotient (handles division by zero)
5. **`displayMenu()`** - Shows the calculator menu to the user
6. **`getNumberInput(String prompt)`** - Gets a number from the user with error handling
7. **`performOperation(int choice, double a, double b)`** - Executes the chosen operation

## Requirements

- Extract all 7 methods from the messy code
- Each method must have a **single, clear purpose**
- The calculator must work exactly the same as before (same input/output)
- Maintain proper error handling (division by zero, invalid input)
- Use descriptive method names that explain what they do
- Your `main()` method should be short and clean, calling the extracted methods

## Expected Behavior

Your refactored calculator should work identically to the original:

```
=== Simple Calculator ===
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit
Enter your choice (1-5): 1
Enter first number: 10
Enter second number: 5
Result: 10.0 + 5.0 = 15.0

Enter your choice (1-5): 4
Enter first number: 10
Enter second number: 0
Error: Cannot divide by zero!

Enter your choice (1-5): 5
Thank you for using the calculator!
```

## Testing Instructions

Compile and run your refactored code:
```bash
cd exercises/026-calculator-refactor
javac src/CalculatorRefactor.java
java -cp src CalculatorRefactor
```

Run the test suite:
```bash
mvn test
```

The tests verify:
- Each extracted method exists and works correctly
- Addition, subtraction, multiplication, and division produce correct results
- Division by zero is handled properly (returns 0.0)
- The overall calculator flow works as expected

## Hints

### Hint 1: Start with the Math Operations
The easiest methods to extract are the math operations. Look for code that does:
- `a + b` (extract to `add` method)
- `a - b` (extract to `subtract` method)
- `a * b` (extract to `multiply` method)
- `a / b` (extract to `divide` method)

### Hint 2: Extract the Menu Display
Find the code that prints the menu options. Move all those `System.out.println()` statements into a `displayMenu()` method.

### Hint 3: Extract Input Collection
Look for code that asks the user for numbers. Create a `getNumberInput(String prompt)` method that:
- Prints a prompt like "Enter [prompt] number: "
- Reads and returns a double
- You can start simple without error handling, then enhance it later

### Hint 4: Extract Operation Logic
Find the switch/if-else that decides which operation to perform. Move this into `performOperation(int choice, double a, double b)` that:
- Takes the user's choice and two numbers
- Calls the appropriate math method
- Prints the result

### Hint 5: Keep main() Clean
After extraction, your `main()` should be very short - just calling the methods in the right order:
```java
displayMenu();
// get user input
// perform operation
// repeat until exit
```

## Reflection Questions

After completing this exercise, consider:

1. **Which version is easier to understand?** The messy original or your refactored version? Why?

2. **What if you need to add a new operation?** (like square root or exponentiation) Would it be easier in the messy or refactored version?

3. **What if there's a bug in the division logic?** Where would you look in the messy version vs. refactored version?

4. **Can you reuse these methods elsewhere?** Imagine building a scientific calculator - could you reuse your `add()`, `subtract()`, etc. methods?

5. **How does naming affect readability?** Would `doMath()` be as clear as `performOperation()`?

## Next Steps

- **Exercise 027** introduces arrays, where you'll store multiple values and perform operations on them
- Try refactoring other code you've written in previous exercises
- Practice identifying "code smells" - signs that code needs refactoring

## Read More

- [Refactoring - Martin Fowler](https://refactoring.com/)
- [Clean Code - Robert C. Martin](https://www.oreilly.com/library/view/clean-code-a/9780136083238/)
- Oracle Java Tutorials - Methods: [Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- DRY Principle: [Don't Repeat Yourself](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)
- Single Responsibility Principle: [SRP](https://en.wikipedia.org/wiki/Single-responsibility_principle)
