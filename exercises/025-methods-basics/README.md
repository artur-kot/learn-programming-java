# Exercise 025: Methods Basics - Define, Parameters & Return Values

## Overview

Master the fundamentals of methods by learning to define simple methods, add parameters to customize behavior, and return values from methods. Methods are the building blocks of reusable code - they let you organize logic into named, reusable functions.

## What You're Learning

### Part 1: Simple Method Definition

A **method** is a reusable block of code that performs a specific task. Basic syntax:

```java
public static void greet() {
    System.out.println("Hello, World!");
}
```

Breaking this down:
- `public` - accessible from anywhere
- `static` - belongs to the class (not an object instance)
- `void` - the method doesn't return a value
- `greet()` - the method name
- `{ ... }` - the method body

### Calling a Method

```java
public static void main(String[] args) {
    greet();  // Call the method
    greet();  // Can call it multiple times
}
```

Output:
```
Hello, World!
Hello, World!
```

### Part 2: Methods with Parameters

**Parameters** are variables that a method accepts to customize its behavior:

```java
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}
```

Calling with arguments:
```java
greet("Alice");  // Prints: Hello, Alice!
greet("Bob");    // Prints: Hello, Bob!
```

Multiple parameters:

```java
public static void add(int a, int b) {
    int sum = a + b;
    System.out.println(a + " + " + b + " = " + sum);
}
```

### Part 3: Methods with Return Values

A **return value** lets a method send data back to the caller:

```java
public static int multiply(int a, int b) {
    return a * b;  // Return the result
}
```

Using the return value:

```java
int result = multiply(5, 3);  // result = 15
System.out.println(result);   // Prints: 15
```

Key differences:
- `void` methods do NOT return a value
- Value-returning methods specify a return type (`int`, `double`, `String`, etc.)
- Use `return` keyword to send value back to caller

## Your Task

Create a program demonstrating all three method types:

### Part 1: Simple Methods (No Parameters, No Return)
- `printWelcome()` - Print a welcome message
- `printBoundary()` - Print a line of dashes for formatting

### Part 2: Methods with Parameters
- `greet(String name)` - Greet a person by name
- `printMultipleTimes(String message, int times)` - Print a message N times
- `calculateArea(double length, double width)` - Calculate and print rectangle area

### Part 3: Methods with Return Values
- `add(int a, int b)` - Return the sum
- `subtract(int a, int b)` - Return the difference
- `multiply(int a, int b)` - Return the product
- `divide(int a, int b)` - Return the quotient (watch for zero!)
- `getFullName(String firstName, String lastName)` - Return combined name

## Example Output

```
==================================
        Welcome to Methods!
==================================

--- Simple Methods ---
Hello from method!

--- Methods with Parameters ---
Hello, Alice!
Hello, Bob!

The area of 5 x 3 is: 15 square units.
Message printed 4 times:
* Learn Java!
* Learn Java!
* Learn Java!
* Learn Java!

--- Methods with Return Values ---
5 + 3 = 8
10 - 2 = 8
4 * 6 = 24
20 / 4 = 5

Full name: Alice Johnson
```

## Algorithm

1. **Part 1**: Create void methods that print output
2. **Part 2**: Add parameters to methods to make them flexible
3. **Part 3**: Create methods that return values instead of printing
4. **Main**: Call all methods from main() to demonstrate usage

## Method Syntax Reference

```java
// Void method (no return)
public static void methodName() {
    // Code here
}

// Void method with parameters
public static void methodName(type param1, type param2) {
    // Use param1 and param2
}

// Method with return value
public static returnType methodName() {
    // Do work
    return value;  // Must match returnType
}

// Method with parameters and return value
public static returnType methodName(type param1, type param2) {
    // Do work with parameters
    return value;  // Must match returnType
}
```

## Tips

- **Method names** should describe what they do (verb + noun is common)
- **Parameters** should have meaningful names
- **Return type** must match the value you return
- **void** methods don't need (and shouldn't use) return statements
- **Call methods** from main() to use them
- Methods make code **reusable** - define once, use many times

## Starter Code

```java
public class MethodsBasics {
    
    /**
     * Part 1: Simple methods with no parameters or return values
     */
    
    public static void printWelcome() {
        // TODO: Print a welcome message
    }
    
    public static void printBoundary() {
        // TODO: Print a line of dashes (==============)
    }
    
    /**
     * Part 2: Methods with parameters (but no return values)
     */
    
    public static void greet(String name) {
        // TODO: Print "Hello, [name]!"
    }
    
    public static void printMultipleTimes(String message, int times) {
        // TODO: Use a loop to print the message 'times' times
        // Hint: for (int i = 0; i < times; i++)
    }
    
    public static void calculateArea(double length, double width) {
        // TODO: Calculate area and print "The area of [length] x [width] is: [area] square units."
    }
    
    /**
     * Part 3: Methods with return values
     */
    
    public static int add(int a, int b) {
        // TODO: Return a + b
        return 0;  // Placeholder
    }
    
    public static int subtract(int a, int b) {
        // TODO: Return a - b
        return 0;  // Placeholder
    }
    
    public static int multiply(int a, int b) {
        // TODO: Return a * b
        return 0;  // Placeholder
    }
    
    public static int divide(int a, int b) {
        // TODO: Return a / b (watch out for division by zero!)
        // For now, assume b is never 0
        return 0;  // Placeholder
    }
    
    public static String getFullName(String firstName, String lastName) {
        // TODO: Return firstName + " " + lastName
        return "";  // Placeholder
    }
    
    /**
     * Main method - demonstrates all method types
     */
    public static void main(String[] args) {
        // TODO: Call all the methods above to demonstrate how they work
        
        // Example structure:
        // 1. Call printWelcome() and printBoundary()
        // 2. Call greet() with a few different names
        // 3. Call printMultipleTimes()
        // 4. Call calculateArea()
        // 5. Use the return values from add(), subtract(), multiply(), divide()
        //    Store results and print them
        // 6. Call getFullName() and print the result
    }
}
```

## Testing Hints

The test file will verify:
- Each method is accessible and callable
- Methods with parameters accept correct argument types
- Return value methods return correct values
- add/subtract/multiply/divide produce correct math results
- String methods concatenate correctly
- Methods print expected output
