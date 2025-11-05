# Exercise 026: Method Overloading - Advanced

## Overview

Master **method overloading** - the ability to create multiple methods with the same name but different parameters. This is a form of polymorphism that makes your code more flexible and intuitive. Learn to handle different types and quantities of data with the same method name.

## What You're Learning

### Method Overloading Basics

**Overloading** means creating multiple methods with the same name but different parameter lists. Java determines which method to call based on the arguments you pass.

```java
public static void print(int value) {
    System.out.println("Integer: " + value);
}

public static void print(double value) {
    System.out.println("Double: " + value);
}

public static void print(String value) {
    System.out.println("String: " + value);
}
```

Usage:
```java
print(42);         // Calls print(int)
print(3.14);       // Calls print(double)
print("Hello");    // Calls print(String)
```

### Rules for Overloading

Methods must differ by:
1. **Number of parameters** - `add(2)` vs `add(2, 3)`
2. **Type of parameters** - `add(int, int)` vs `add(double, double)`
3. **Order of parameters** - `compare(int, String)` vs `compare(String, int)`

**Cannot overload by:**
- Return type alone (not enough for Java to distinguish)

### Real-World Example: Flexible Addition

```java
public static int add(int a, int b) {
    return a + b;
}

public static double add(double a, double b) {
    return a + b;
}

public static String add(String a, String b) {
    return a + b;  // Concatenation
}

public static int add(int a, int b, int c) {
    return a + b + c;  // Three parameters
}
```

Usage:
```java
add(5, 3);              // 8 (int + int)
add(5.5, 3.2);          // 8.7 (double + double)
add("Hello", "World");  // "HelloWorld" (concatenation)
add(5, 3, 2);           // 10 (three ints)
```

### Type Compatibility

Sometimes Java needs to decide between overloads:

```java
print(5);     // Exact match: print(int)
print(5.0);   // Exact match: print(double)
print(5L);    // Exact match: print(long)
```

## Your Task

Create a program demonstrating method overloading with multiple scenarios:

### Part 1: Calculation Methods (Different Types)
- `calculate(int a, int b)` - Add two integers
- `calculate(double a, double b)` - Add two doubles
- `calculate(int a, double b)` - Add mixed types (return double)
- `calculate(String a, String b)` - Concatenate strings

### Part 2: Information Display (Different Types)
- `displayInfo(String name)` - Display person's name
- `displayInfo(String name, int age)` - Display name and age
- `displayInfo(String name, int age, String city)` - Display all three

### Part 3: Flexible Operations (Different Counts)
- `sum(int a, int b)` - Sum two numbers
- `sum(int a, int b, int c)` - Sum three numbers
- `sum(double a, double b)` - Sum two doubles
- `sum(double a, double b, double c)` - Sum three doubles

### Part 4: Advanced Formatting (Type Variations)
- `format(int value)` - Format as integer: "Value: 42"
- `format(double value)` - Format as decimal: "Value: 3.14"
- `format(int value, int width)` - Right-align to width
- `format(double value, int decimalPlaces)` - Control decimal places
- `format(String label, Object value)` - Generic formatting

## Example Output

```
=== Part 1: Calculations ===
add(5, 3) = 8
add(5.5, 3.2) = 8.7
add(5, 3.2) = 8.2
add("Hello", "World") = HelloWorld

=== Part 2: Information Display ===
Name: Alice
Name: Alice, Age: 25
Name: Alice, Age: 25, City: New York

=== Part 3: Flexible Sum ===
sum(5, 3) = 8
sum(5, 3, 2) = 10
sum(5.5, 3.2) = 8.7
sum(5.5, 3.2, 1.8) = 10.5

=== Part 4: Advanced Formatting ===
Value: 42
Value: 3.14
      42 (width 6)
3.14 (2 decimals)
Temperature: 72
```

## Algorithm

1. **Create multiple methods** with same name but different parameters
2. **Implement each version** to handle its specific type(s)
3. **Call all versions** from main() to demonstrate polymorphism
4. **Show how Java selects** the appropriate method based on arguments

## Key Concepts

- **Method Signature**: Name + parameter list (return type NOT included)
- **Polymorphism**: Ability of methods to take multiple forms
- **Type Safety**: Java checks types at compile time
- **Flexibility**: Same operation name for different data types

## Tips

- Use meaningful names that describe what happens
- Each overload should make logical sense
- Avoid confusing overloads - keep differences clear
- Test that the correct method is called for each argument type
- Return types can differ between overloads (they're not part of the signature)

## Starter Code

```java
public class MethodOverloading {
    
    /**
     * Part 1: Calculations with different types
     */
    
    public static int calculate(int a, int b) {
        // TODO: Return a + b
        return 0;
    }
    
    public static double calculate(double a, double b) {
        // TODO: Return a + b
        return 0.0;
    }
    
    public static double calculate(int a, double b) {
        // TODO: Return a + b as double
        return 0.0;
    }
    
    public static String calculate(String a, String b) {
        // TODO: Return a + b (concatenation)
        return "";
    }
    
    /**
     * Part 2: Information display with different parameter counts
     */
    
    public static void displayInfo(String name) {
        // TODO: Print "Name: [name]"
    }
    
    public static void displayInfo(String name, int age) {
        // TODO: Print "Name: [name], Age: [age]"
    }
    
    public static void displayInfo(String name, int age, String city) {
        // TODO: Print "Name: [name], Age: [age], City: [city]"
    }
    
    /**
     * Part 3: Flexible sum operations
     */
    
    public static int sum(int a, int b) {
        // TODO: Return a + b
        return 0;
    }
    
    public static int sum(int a, int b, int c) {
        // TODO: Return a + b + c
        return 0;
    }
    
    public static double sum(double a, double b) {
        // TODO: Return a + b
        return 0.0;
    }
    
    public static double sum(double a, double b, double c) {
        // TODO: Return a + b + c
        return 0.0;
    }
    
    /**
     * Part 4: Advanced formatting with overloading
     */
    
    public static String format(int value) {
        // TODO: Return "Value: [value]"
        return "";
    }
    
    public static String format(double value) {
        // TODO: Return "Value: [value]" formatted as double
        return "";
    }
    
    public static String format(int value, int width) {
        // TODO: Return value right-aligned to width
        // Example: format(42, 6) = "    42"
        // Hint: Use String.format("%"+width+"d", value)
        return "";
    }
    
    public static String format(double value, int decimalPlaces) {
        // TODO: Return double formatted to N decimal places
        // Example: format(3.14159, 2) = "3.14"
        // Hint: Use String.format("%."+decimalPlaces+"f", value)
        return "";
    }
    
    public static String format(String label, Object value) {
        // TODO: Return "[label]: [value]"
        // Object is the parent type of all Java objects
        return "";
    }
    
    /**
     * Main - demonstrate all overloading scenarios
     */
    public static void main(String[] args) {
        // TODO: Call all overloaded methods to demonstrate polymorphism
        
        System.out.println("=== Part 1: Calculations ===");
        // Call all calculate() methods
        
        System.out.println("\n=== Part 2: Information Display ===");
        // Call all displayInfo() methods
        
        System.out.println("\n=== Part 3: Flexible Sum ===");
        // Call all sum() methods
        
        System.out.println("\n=== Part 4: Advanced Formatting ===");
        // Call all format() methods
    }
}
```

## Challenge

Can you predict which method gets called in each case?

```java
calculate(5, 3);              // Which overload?
calculate(5.0, 3.0);          // Which overload?
calculate(5, 3.0);            // Which overload?
calculate("a", "b");          // Which overload?

sum(5, 3, 2);                 // Which overload?
sum(5.5, 3.2, 1.8);           // Which overload?

format(42);                    // Which overload?
format(3.14);                  // Which overload?
format(42, 6);                 // Which overload?
format(3.14, 2);               // Which overload?
format("Temperature", 72);     // Which overload?
```

## Testing Hints

The test file will verify:
- Each overloaded method is callable
- Correct overload is selected for each argument type
- All calculations produce correct results
- String concatenation works properly
- Display methods format output correctly
- Format methods handle width and decimal places
