# Exercise 002: Hello You - Personal Greeting

## Introduction

Now that you've mastered printing a simple message, let's personalize it! In this exercise, you'll learn how to combine text and variables together—a technique called **string concatenation**. This is a fundamental skill you'll use constantly in programming.

## What You're Learning

**String Concatenation:**
In Java, you can combine (concatenate) strings using the `+` operator. Think of it like putting words together to form a sentence.

Example:
```
"Hello" + ", " + "World" = "Hello, World"
```

**Variables:**
A variable is a named container that stores a value. You can use it later in your program. Variables have:
- A **type** (like `String`, `int`, `double`)
- A **name** (like `name`, `age`, `message`)
- A **value** (the data stored in it)

In this exercise, the variable `name` will store your name as a `String`. You can then use this variable in your print statement.

**String Concatenation with Variables:**
You can combine variables and string literals using `+`:
```
String name = "Artur";
System.out.println("Hello, " + name + "!");  // Output: Hello, Artur!
```

## Challenge

Your task: **Create a personalized greeting that combines the `name` variable with a greeting message.**

You have:
- A `name` variable that's already declared
- A TODO comment showing where to print

Combine the greeting message with the name variable using `+` and print the result.

## Requirements

Your solution must:
- Use the `name` variable in your greeting
- Use the `+` operator to concatenate strings
- Print a complete message that includes both "Hello" and the name
- The output should be personalized and welcoming

## Hints

<details>
<summary>Hint 1: The Pattern</summary>

The basic pattern for string concatenation is:
```
"string part 1" + variable + "string part 2"
```

You can combine as many parts as you need!

</details>

<details>
<summary>Hint 2: Example Structure</summary>

Your print statement might look like:
```
System.out.println("Hello, " + name + "!");
```

This combines three parts: the greeting, the variable, and punctuation.

</details>

<details>
<summary>Hint 3: Making It Personal</summary>

Try adding extra information to make it warmer:
```
System.out.println("Hello, " + name + "! Welcome to Java!");
```

This creates a more complete greeting!

</details>

## Expected Behavior

When you run your program, it should display something like:
```
Hello, Artur! Welcome to Java!
```

The exact message is up to you, but it should include the name and feel like a genuine greeting.

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/002-hello-you
mvn test
```

**Manual Testing:**
```bash
cd exercises/002-hello-you/src
javac HelloYou.java
java HelloYou
```

## Reflection Questions

1. **What did the `+` operator do?** Why is it useful for combining strings?
2. **What happens if you remove the variable?** Can you still create the message with just string literals?
3. **Can you change the name?** What happens when you modify the `name` variable to a different name?
4. **How many times can you use `+` in one statement?** Can you combine more than two parts?

## Next Steps

You've now learned string concatenation! In the next exercise, you'll learn how to make your program **interactive** by asking the user to input their own name instead of hardcoding it.

## Read More

- [String Concatenation in Java](https://www.baeldung.com/java-string-concatenation)
- [Java Variables Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
- [String Operations](https://docs.oracle.com/javase/tutorial/java/data/manipulating.html)
