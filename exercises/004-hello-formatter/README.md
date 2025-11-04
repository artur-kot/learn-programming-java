# Exercise 004: Hello Formatter - Clean Output

## Introduction

Have you ever wanted to make your output look really polished and professional? In this exercise, you'll learn the powerful `printf` method that lets you create beautifully formatted messages with precise control over spacing, alignment, and data types.

## What You're Learning

**The printf Method:**
While `println` just dumps text on the screen, `printf` (print formatted) gives you fine control over how data is displayed. It's like having a text formatting expert at your fingertips!

**Format Specifiers:**
Format specifiers are special codes that tell `printf` what type of data to insert and how to format it:
- `%s` - String (text)
- `%d` - Integer (whole numbers)
- `%f` - Floating-point (decimal numbers)
- `%n` - Newline (move to next line)

**Escape Sequences:**
Special characters that create formatting effects:
- `\n` - Newline
- `\t` - Tab (indent)
- `\\` - Backslash
- `\"` - Quote

**Example:**
```
System.out.printf("Hello, %s! You are %d years old.%n", name, age);
```

This prints: `Hello, Alice! You are 25 years old.`

## Challenge

Your task: **Use `printf` to create a nicely formatted greeting that includes the user's name and age.**

You have:
- Code that already gets the name and age from the user
- A TODO showing where to add the formatted output

Create a multi-line greeting using `printf` with format specifiers.

## Requirements

Your solution must:
- Use `System.out.printf()` (not println)
- Include at least one `%s` for the name
- Include at least one `%d` for the age
- Have multiple lines of output using `%n`
- Use proper spacing and indentation to make it look professional
- Include both the name and age from the variables

## Hints

<details>
<summary>Hint 1: Basic Syntax</summary>

The pattern for printf is:
```
System.out.printf("format string", value1, value2, ...);
```

The format string contains the text and format specifiers. The values fill in the specifiers in order.

</details>

<details>
<summary>Hint 2: Format Specifiers</summary>

Remember:
- `%s` is replaced with a string variable
- `%d` is replaced with an integer variable
- `%n` creates a newline

So: `System.out.printf("Name: %s, Age: %d%n", name, age);`

</details>

<details>
<summary>Hint 3: Multi-line Example</summary>

You could create something like:
```
System.out.printf("===== GREETING CARD =====%n");
System.out.printf("Hello, %s!%n", name);
System.out.printf("You are %d years old.%n", age);
System.out.printf("Welcome to Java!%n");
```

</details>

## Expected Behavior

When you run your program with input "Grace" and "27", it might output:

```
Welcome to the Greeting Formatter!
Enter your name: Grace
Enter your age: 27
===== GREETING CARD =====
Hello, Grace!
You are 27 years old.
Welcome to Java!
```

The exact format is up to you!

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/004-hello-formatter
mvn test
```

**Manual Testing:**
```bash
cd exercises/004-hello-formatter/src
javac HelloFormatter.java
java HelloFormatter
```

## Reflection Questions

1. **What's the difference between printf and println?** When would you use each one?
2. **What happens if you use the wrong format specifier?** (e.g., `%d` for a string?)
3. **Can you use printf multiple times?** Do you have to put everything in one printf call?
4. **Why is formatting output important?** When would a user care about nice formatting?
5. **Can you align numbers or pad strings?** (Advanced: research printf field widths!)

## Next Steps

You've mastered formatted output! Now it's time to learn how to **debug** your code when things go wrong. In the final exercise of this series, you'll see intentional errors and learn how to fix them.

## Read More

- [System.out.printf() Documentation](https://docs.oracle.com/javase/10/docs/api/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...))
- [Java Format Specifiers](https://docs.oracle.com/javase/tutorial/i18n/resbundle/prepare.html)
- [Escape Sequences in Java](https://docs.oracle.com/javase/tutorial/java/data/characters.html)
