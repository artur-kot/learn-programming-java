# Solution: Methods Basics - Define, Parameters & Return Values

This file contains the complete solution for Exercise 025. Try to solve the exercise yourself before looking at this solution!

## Complete Solution

```java
/**
 * Exercise 025: Methods Basics - Define, Parameters & Return Values
 *
 * Your task: Implement 6 different methods that demonstrate:
 * - Void methods (no return value)
 * - Methods with parameters
 * - Methods that return values
 * - Different return types (void, int, boolean, String)
 *
 * Concepts you'll practice:
 * - Method definition syntax
 * - Parameters and arguments
 * - Return types and return statements
 * - Void vs value-returning methods
 * - Calling methods from main
 */
public class MethodsBasics {

    /**
     * Prints a greeting message to the console.
     * This is a void method with no parameters.
     */
    public static void printGreeting() {
        System.out.println("Welcome to Java Methods!");
    }

    /**
     * Prints a personalized greeting with the given name.
     * This is a void method with one parameter.
     *
     * @param name The name to greet
     */
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    /**
     * Adds two integers and returns the result.
     * This method demonstrates returning an int value.
     *
     * @param a First number
     * @param b Second number
     * @return The sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Multiplies two integers and returns the result.
     * This method demonstrates basic arithmetic with return value.
     *
     * @param a First number
     * @param b Second number
     * @return The product of a and b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Checks if a number is even.
     * This method demonstrates returning a boolean value.
     *
     * @param number The number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Combines first and last name into a full name.
     * This method demonstrates working with String parameters and return value.
     *
     * @param firstName The first name
     * @param lastName The last name
     * @return The full name with a space between first and last name
     */
    public static String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        // Test all methods
        System.out.println("=== Testing Methods ===\n");

        // Test void method with no parameters
        printGreeting();
        System.out.println();

        // Test void method with parameter
        greet("Alice");
        greet("Bob");
        System.out.println();

        // Test methods that return values
        System.out.println("Sum: " + add(10, 5));
        System.out.println("Product: " + multiply(6, 4));
        System.out.println();

        // Test boolean return
        System.out.println("Is 7 even? " + isEven(7));
        System.out.println("Is 10 even? " + isEven(10));
        System.out.println();

        // Test String return
        System.out.println("Full name: " + getFullName("John", "Doe"));

        // You can also store the returned value in a variable
        String name = getFullName("Jane", "Smith");
        System.out.println("Another name: " + name);

        // And use returned values in calculations
        int sum = add(5, 3);
        int doubledSum = multiply(sum, 2);
        System.out.println("Double of (5+3): " + doubledSum);
    }
}
```

## Explanation

### 1. printGreeting() - Void Method, No Parameters

```java
public static void printGreeting() {
    System.out.println("Welcome to Java Methods!");
}
```

**Key Points:**
- `void` means it doesn't return any value
- No parameters in parentheses `()`
- Uses `System.out.println()` to display output
- Call it like: `printGreeting();`

### 2. greet(String name) - Void Method, With Parameter

```java
public static void greet(String name) {
    System.out.println("Hello, " + name + "!");
}
```

**Key Points:**
- Still `void` (no return value)
- Takes one parameter: `String name`
- Uses the parameter in the output
- Call it like: `greet("Alice");`
- Different arguments produce different output

### 3. add(int a, int b) - Returns int

```java
public static int add(int a, int b) {
    return a + b;
}
```

**Key Points:**
- Return type is `int`
- Takes two `int` parameters
- Uses `return` statement to send back the result
- Call it like: `int sum = add(10, 5);`
- The returned value can be used in other expressions

### 4. multiply(int a, int b) - Returns int

```java
public static int multiply(int a, int b) {
    return a * b;
}
```

**Key Points:**
- Similar structure to `add()`
- Different operation (multiplication)
- Shows how methods can perform various calculations
- The `*` operator multiplies two numbers

### 5. isEven(int number) - Returns boolean

```java
public static boolean isEven(int number) {
    return number % 2 == 0;
}
```

**Key Points:**
- Return type is `boolean` (true or false)
- Takes one parameter
- The expression `number % 2 == 0` evaluates to boolean
- `%` is the modulo operator (remainder after division)
- Even numbers have remainder 0 when divided by 2
- Can be used in if statements: `if (isEven(x)) { ... }`

### 6. getFullName(String firstName, String lastName) - Returns String

```java
public static String getFullName(String firstName, String lastName) {
    return firstName + " " + lastName;
}
```

**Key Points:**
- Return type is `String`
- Takes two `String` parameters
- Concatenates strings with `+` operator
- Don't forget the space: `" "`
- The returned String can be stored or printed

## Common Mistakes to Avoid

1. **Returning in void methods:**
   ```java
   // WRONG
   public static void printGreeting() {
       return "Welcome!";  // Error! void methods don't return values
   }
   ```

2. **Printing in return methods:**
   ```java
   // WRONG (well, it compiles, but defeats the purpose)
   public static int add(int a, int b) {
       System.out.println(a + b);  // Don't print
       // Missing return statement! This won't compile
   }

   // CORRECT
   public static int add(int a, int b) {
       return a + b;  // Return the value
   }
   ```

3. **Forgetting to return a value:**
   ```java
   // WRONG
   public static int add(int a, int b) {
       int sum = a + b;
       // Missing return! This won't compile
   }

   // CORRECT
   public static int add(int a, int b) {
       int sum = a + b;
       return sum;
   }
   ```

4. **Wrong parameter types:**
   ```java
   // If method expects String, you must pass String
   greet(123);  // Error! 123 is int, not String
   greet("123");  // Correct! "123" is a String
   ```

## Key Concepts Review

**Method Signature:**
- Return type + name + parameters
- Example: `public static int add(int a, int b)`

**Void Methods:**
- Don't return a value
- Usually perform actions (like printing)
- Use `return;` (optional) to exit early

**Value-Returning Methods:**
- Must return a value of the declared type
- Use `return` statement
- The returned value can be used by the caller

**Parameters:**
- Allow methods to accept input
- Can have zero or more parameters
- Each parameter needs a type and name

**Why Methods?**
- **Reusability:** Write once, use many times
- **Organization:** Break complex problems into pieces
- **Readability:** Clear names explain what code does
- **Testability:** Easy to test individual methods
