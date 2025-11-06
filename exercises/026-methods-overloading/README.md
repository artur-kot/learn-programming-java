# Exercise 026: Method Overloading - Add & Greet

## Overview

Master **method overloading** - the ability to create multiple methods with the same name but different parameters. This is a form of polymorphism that makes your code more flexible and intuitive. In this exercise, you'll create two pairs of overloaded methods to handle different data types.

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

### Real-World Example

Different methods for adding numbers depending on type:

```java
public static int add(int a, int b) {
    return a + b;           // 5 + 3 = 8
}

public static double add(double a, double b) {
    return a + b;           // 5.5 + 3.2 = 8.7
}
```

## Your Task

Create **2 pairs of overloaded methods**:

### Method 1: `add` (Two Overloads)
- `add(int, int)` → Returns sum of two integers
- `add(double, double)` → Returns sum of two doubles

### Method 2: `greet` (Two Overloads)
- `greet(String)` → Returns greeting with name
- `greet(String, int)` → Returns greeting with name and age

No method signatures provided—you must figure out:
- The correct method names (matching test expectations)
- The parameters each version needs
- What each version should return

## Requirements

- Create **exactly 4 methods** (2 method names, each with 2 overloads)
- Each method must have a **clear, single purpose**
- Each version should handle its specific type(s)
- Test your methods in `main()` by calling all versions
- Your `main()` method should demonstrate all 4 methods working correctly

## Example Output

```
## Hints

### Hint 1: Integer Addition
- What should this method be named? (what operation does it do?)
- What parameters? (two integers)
- What should it return? (the sum)
- Example: `add(5, 3)` → `8`

### Hint 2: Double Addition
- Same method name as Hint 1
- What parameters? (two doubles instead)
- What should it return? (the sum as a double)
- Example: `add(5.5, 3.2)` → `8.7`

### Hint 3: Simple Greeting
- What should this method be named? (something that greets)
- What parameters? (just a name)
- What should it return? (a greeting string)
- Example: `greet("Alice")` → `"Hello, Alice!"`

### Hint 4: Greeting with Age
- Same method name as Hint 3
- What parameters? (name and age)
- What should it return? (a greeting string including age)
- Example: `greet("Bob", 30)` → `"Hello, Bob! You are 30 years old."`

## Expected Behavior

When you test your methods:
```
add(5, 3) → 8
add(5.5, 3.2) → 8.7

greet("Alice") → "Hello, Alice!"
greet("Bob", 30) → includes name and age
```

## Testing Instructions

Run your tests:
```bash
mvn test
```

Your methods should pass all 8 test cases (4 for `add`, 4 for `greet`).

If a test fails:
1. Check your method names match: `add` and `greet`
2. Verify you're returning the correct type
3. Test edge cases with negative numbers

## Reflection Questions

After completing this exercise, think about:

1. **Why is overloading useful?** How would the code be different without it?
2. **How does Java know which method to call?** (Hint: it looks at the parameter types)
3. **Can you think of other cases where overloading would be helpful?**
4. **What would happen if you created `add(int, double)` and `add(double, int)`?** Would both work?

## Next Steps

- **Exercise 027** shows you how to refactor messy code by extracting it into well-organized methods
- Consider creating more overloads for other methods you've learned

## Read More

- [Oracle Java Tutorials - Defining Methods: Overloading](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- Method signatures and how Java resolves method calls
- Type compatibility in method selection
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
