# Exercise 027: Calculator Refactor - Modular Design & Method Organization

## Overview

This exercise teaches **refactoring** - transforming working code into better-organized, maintainable code. You are provided with a **fully functional calculator application that is poorly organized** (all logic crammed into `main()`). Your task is to refactor it by extracting methods to improve design, eliminate duplication, and enhance readability. This is a realistic software development task: learning to improve code without changing its behavior.

**IMPORTANT:** The calculator already works perfectly! Your job is to reorganize the code, not fix bugs.

## What You're Learning

### Code Smells vs. Good Design

**Monolithic Code** (Bad):
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Calculator");
    
    // All logic crammed into main()
    System.out.print("Enter first number: ");
    double num1 = scanner.nextDouble();
    System.out.print("Enter second number: ");
    double num2 = scanner.nextDouble();
    
    // Repeated validation
    if (num1 < 0 || num2 < 0) {
        System.out.println("Invalid input");
        return;
    }
    
    // Repeated validation again
    if (num1 > 1000 || num2 > 1000) {
        System.out.println("Invalid input");
        return;
    }
    
    // Many more operations...
}
```

**Refactored Code** (Good):
```java
public static boolean isValidNumber(double num) {
    return num >= 0 && num <= 1000;
}

public static double getNumber(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextDouble();
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    runCalculator(scanner);
}

public static void runCalculator(Scanner scanner) {
    // Clean, readable, uses helper methods
}
```

### Refactoring Principles

1. **DRY (Don't Repeat Yourself)**: Extract repeated code into methods
2. **Separation of Concerns**: Each method does one thing well
3. **Readability**: Method names explain what happens
4. **Reusability**: Methods can be used in different contexts
5. **Testability**: Methods can be tested independently

## Your Task

You are provided with a **working calculator application** that is poorly organized. Your task is to refactor it by extracting logic into methods. The application already works - you just need to clean it up!

**Key Problems in Current Code:**
1. ❌ All logic is in `main()` - 130+ lines of code in one method!
2. ❌ Validation code is repeated THREE times (for operation, num1, num2)
3. ❌ Operation logic is a messy if/else chain
4. ❌ Hard to test individual pieces
5. ❌ Hard to extend with new features
6. ❌ Difficult to read and understand

### Part 1: Extract Operation Methods
Create separate methods for each calculation:
- `add(double a, double b)` - Return sum
- `subtract(double a, double b)` - Return difference
- `multiply(double a, double b)` - Return product
- `divide(double a, double b)` - Return quotient (handle division by zero)

### Part 2: Extract Validation Method
- `isValidNumber(double num)` - Check if number is in acceptable range
- `isValidOperation(String op)` - Check if operation is recognized

### Part 3: Extract Input Methods
- `getNumber(Scanner scanner, String prompt)` - Get and return a number from user
- `getOperation(Scanner scanner)` - Get and return operation choice from user

### Part 4: Build Menu System
- `displayMenu()` - Show available operations
- `performOperation(double a, double b, String operation)` - Execute operation and return result
- `runCalculator()` - Main loop that uses all helper methods

### Part 5: Main Flow (Already Mostly There)
- Initialize Scanner
- Show welcome message
- Loop to allow multiple calculations
- Use the refactored methods

## Example Output

```
========================================
        Welcome to Calculator!
========================================

Menu:
  1. Add
  2. Subtract
  3. Multiply
  4. Divide
  5. Exit

Enter operation (1-5): 1
Enter first number: 10
Enter second number: 5
Result: 10.0 + 5.0 = 15.0

Menu:
  1. Add
  2. Subtract
  3. Multiply
  4. Divide
  5. Exit

Enter operation (1-5): 3
Enter first number: 4
Enter second number: 8
Result: 4.0 * 8.0 = 32.0

Menu:
  1. Add
  2. Subtract
  3. Multiply
  4. Divide
  5. Exit

Enter operation (1-5): 5
Thanks for using Calculator!
```

## Before & After: Key Refactoring Points

### Before (Monolithic):
```java
// Validation repeated multiple times
if (num1 < 0 || num1 > 1000) { ... }
// ... later ...
if (num2 < 0 || num2 > 1000) { ... }
```

### After (Refactored):
```java
private static boolean isValidNumber(double num) {
    return num >= 0 && num <= 1000;
}

// Use everywhere:
if (!isValidNumber(num1) || !isValidNumber(num2)) { ... }
```

### Before (Monolithic):
```java
System.out.print("Enter operation: ");
String operation = scanner.next();
if (operation.equals("+")) {
    // Do addition
} else if (operation.equals("-")) {
    // Do subtraction
}
```

### After (Refactored):
```java
private static double performOperation(double a, double b, String op) {
    switch(op) {
        case "+": return add(a, b);
        case "-": return subtract(a, b);
        // ...
    }
}
// Use it:
double result = performOperation(num1, num2, operation);
```

## Refactoring Checklist

- [ ] Extract `add()`, `subtract()`, `multiply()`, `divide()` methods
- [ ] Create `isValidNumber()` validation method
- [ ] Create `getNumber()` input method
- [ ] Create `displayMenu()` method
- [ ] Create `performOperation()` method that uses the operation methods
- [ ] Create `runCalculator()` loop that coordinates everything
- [ ] Remove all duplicated code
- [ ] Ensure main() is clean and calls `runCalculator()`
- [ ] Test all operations work correctly
- [ ] Test invalid input handling

## Starter Code (Already Functional - But Needs Refactoring!)

```java
import java.util.Scanner;

public class CalculatorRefactor {
    
    // TODO: Extract these operation methods from main()
    public static double add(double a, double b) {
        // TODO: Implement
        return 0.0;
    }
    
    public static double subtract(double a, double b) {
        // TODO: Implement
        return 0.0;
    }
    
    public static double multiply(double a, double b) {
        // TODO: Implement
        return 0.0;
    }
    
    public static double divide(double a, double b) {
        // TODO: Implement - Watch for division by zero!
        return 0.0;
    }
    
    // TODO: Extract validation logic
    public static boolean isValidNumber(double num) {
        // TODO: Implement
        return false;
    }
    
    // TODO: Extract input logic
    public static double getNumber(Scanner scanner, String prompt) {
        // TODO: Implement
        return 0.0;
    }
    
    // TODO: Extract menu display
    public static void displayMenu() {
        // TODO: Implement
    }
    
    // TODO: Extract operation dispatch
    public static double performOperation(double a, double b, String operation) {
        // TODO: Implement - Use the operation methods above
        return 0.0;
    }
    
    // TODO: Extract calculator loop
    public static void runCalculator() {
        // TODO: Implement - Main game loop
    }
    
    /**
     * Main entry point - should be very clean after refactoring
     */
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("        Welcome to Calculator!");
        System.out.println("========================================\n");
        
        runCalculator();
        
        System.out.println("\nThanks for using Calculator!");
    }
}
```

## Testing Hints

The test file will verify:
- Each operation method produces correct results
- Validation correctly identifies valid and invalid numbers
- Input methods can retrieve values from Scanner
- Menu displays correctly
- performOperation dispatches to correct operation
- Division by zero is handled
- Calculator loop can handle multiple operations
- Invalid operations are rejected

## Tips

- **Start with simple methods**: Add, subtract, multiply, divide first
- **Then validation**: Extract the validation logic
- **Then input**: Create input helper methods
- **Then menu**: Display menu and get user choice
- **Finally coordination**: Create the main loop that ties it all together
- **Test incrementally**: Test each method as you extract it
- **Don't change behavior**: Refactoring shouldn't change what the program does

## Challenge Questions

1. What code is duplicated in the original that we eliminated?
2. How does `performOperation()` make the menu system cleaner?
3. Why is validation in a separate method better than inline checks?
4. How would adding more operations (like square root) be easier now?
5. Could these methods be reused in other programs?
