# Exercise 025: Methods Basics - Define, Parameters & Return Values

## Introduction

Imagine you're writing the same code over and over again. Tedious, right? Methods solve this problem. They let you write code once and reuse it many times with different inputs. Think of methods as mini-programs within your program—each designed to do one specific job really well.

## What You're Learning

**What is a Method?**

A method is a block of code that performs a specific task. You've already been using methods! `System.out.println()` is a method that prints to the console. `main()` is a special method where your program starts.

Now it's time to create your own methods.

**Method Anatomy:**

Every method has these parts:

```java
public static int add(int a, int b) {
    return a + b;
}
```

Breaking it down:
- `public static` - modifiers (we'll keep these simple for now)
- `int` - **return type** (what type of value this method gives back)
- `add` - **method name** (what we call it)
- `(int a, int b)` - **parameters** (inputs the method needs)
- `return a + b;` - **return statement** (sends the result back)

**Two Types of Methods:**

1. **Void methods** - Do something but don't return a value
   ```java
   public static void printGreeting() {
       System.out.println("Hello!");
   }
   ```

2. **Value-returning methods** - Do something AND return a result
   ```java
   public static int add(int a, int b) {
       return a + b;
   }
   ```

**Parameters vs Arguments:**

- **Parameters** are the variables in the method definition (placeholders)
- **Arguments** are the actual values you pass when calling the method

```java
// 'name' is a parameter
public static void greet(String name) {
    System.out.println("Hello, " + name);
}

// "Alice" is an argument
greet("Alice");
```

**Why Methods Matter:**

- **Reusability** - Write once, use many times
- **Organization** - Break complex problems into smaller pieces
- **Readability** - Good method names explain what the code does
- **Testing** - Easier to test small, focused methods

## Challenge Description

You will implement **6 different methods** that demonstrate the variety of method types. Some print output (void), some return values, some take parameters, and some do both.

Your job is to complete the TODO sections in the `MethodsBasics.java` file. Each method has a clear purpose and specific requirements.

## Requirements

Implement these 6 methods:

1. **printGreeting()** - A void method with no parameters that prints "Welcome to Java Methods!"
2. **greet(String name)** - A void method with a parameter that prints a personalized greeting
3. **add(int a, int b)** - Returns the sum of two numbers
4. **multiply(int a, int b)** - Returns the product of two numbers
5. **isEven(int number)** - Returns true if the number is even, false otherwise
6. **getFullName(String firstName, String lastName)** - Returns the full name by combining first and last names

Each method must:
- Follow the exact signature provided in the TODO comments
- Perform the specific task described
- Use `return` for non-void methods
- NOT print anything for non-void methods (only return values)

## Hints

<details>
<summary>Hint 1: Void vs Return</summary>

**Void methods** use `System.out.println()` to display output:
```java
public static void printSomething() {
    System.out.println("Hello!");
}
```

**Return methods** use `return` to send back a value:
```java
public static int getSomething() {
    return 42;
}
```

Never use `return` in a void method. Never use `System.out.println()` in a return method (the caller decides what to do with the value).

</details>

<details>
<summary>Hint 2: Parameters</summary>

Parameters go in the parentheses when you define the method:
```java
public static void greet(String name) {
    System.out.println("Hello, " + name);
}
```

When calling the method, pass the actual values:
```java
greet("Alice");  // "Alice" is the argument
```

</details>

<details>
<summary>Hint 3: Even Number Check</summary>

A number is even if dividing by 2 leaves no remainder. Use the modulo operator `%`:
```java
if (number % 2 == 0) {
    // It's even
}
```

</details>

<details>
<summary>Hint 4: String Concatenation</summary>

To combine strings, use the `+` operator:
```java
String full = firstName + " " + lastName;
```

Don't forget the space between first and last name!

</details>

## Expected Behavior

When you run your `main()` method, you should see output demonstrating all methods working:

```
Welcome to Java Methods!
Hello, Alice!
Sum: 15
Product: 24
Is 7 even? false
Is 10 even? true
Full name: John Doe
```

Your methods should behave like this when tested:

```java
printGreeting();              // Prints: Welcome to Java Methods!
greet("Alice");               // Prints: Hello, Alice!
add(10, 5);                   // Returns: 15
multiply(6, 4);               // Returns: 24
isEven(7);                    // Returns: false
isEven(10);                   // Returns: true
getFullName("John", "Doe");   // Returns: "John Doe"
```

## Testing Instructions

**Run the tests:**
```bash
cd exercises/025-methods-basics
mvn test
```

**Run your program:**
```bash
mvn compile exec:java
```

The tests verify:
- Each method has the correct signature (name, parameters, return type)
- Void methods produce the expected output
- Return methods return the correct values
- Methods handle different inputs correctly
- Edge cases work (like checking even/odd for negative numbers)

If a test fails:
1. Check your method name matches exactly (including capitalization)
2. Verify parameter types and count
3. Ensure void methods print, return methods return
4. Test your logic with the example inputs

## Reflection Questions

After completing this exercise, think about:

1. **Why separate void from return methods?** When would you choose one over the other?
2. **How do parameters make methods flexible?** What if `greet()` didn't take a name parameter?
3. **Can you call one method from inside another?** Try it—call `add()` from inside `main()`.
4. **What makes a good method name?** Compare "a()" vs "add()" vs "addTwoNumbers()".
5. **How would you modify `add()` to work with three numbers?** What would change?

## Next Steps

Now that you understand basic method structure:
- **Exercise 026 - Method Overloading** teaches you how to create multiple methods with the same name but different parameters
- **Exercise 027 - Text Analyzer** shows you how to organize a real program using methods

Methods are fundamental building blocks. You'll use them in every program you write from now on!

## Read More

- [Oracle Java Tutorial: Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- [Oracle Java Tutorial: Passing Information to a Method](https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html)
- [Oracle Java Tutorial: Return Values](https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html)
- [Method Naming Conventions in Java](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html)
