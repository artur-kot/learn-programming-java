# Exercise 001: Hello Java! - Print Your First Message

## Introduction

Your journey as a Java programmer starts here! In this exercise, you'll write your first program that prints a message to the console. This is the traditional "Hello World" program that programmers have created for decades when learning a new language.

## What You're Learning

**Console Output in Java:**
In Java, when you want to display text or information to the user, you send it to the console (the command-line window where your program runs). The most common way to do this is using `System.out.println()`.

Think of it like this:
- `System` is a built-in Java class that lets you interact with your computer
- `out` is a channel that connects to your console display
- `println()` is a method (a reusable command) that prints a line of text

**Strings:**
A "string" in programming is just a sequence of characters (letters, numbers, symbols) enclosed in double quotes. Examples: `"Hello"`, `"Java World!"`, `"12345"`.

**The main Method:**
Every Java program needs a special method called `main()`. This is where your program starts executing. It's the entry point—like opening a door to start your program's journey.

## Challenge

Your task is straightforward: **Make your program print the message "Hello, Java World!" to the console.**

You have a file called `HelloJava.java` with a basic skeleton. Your job is to fill in the TODO section with the correct code.

## Requirements

Your solution must:
- Use `System.out.println()` to print the message
- Print exactly the message: `Hello, Java World!`
- Include this code inside the `main()` method
- The program should run without errors

## Hints

<details>
<summary>Hint 1: Getting Started</summary>

The message you need to print is: `"Hello, Java World!"` (with quotes in your code, but they won't print).

</details>

<details>
<summary>Hint 2: The Pattern</summary>

The basic pattern for printing in Java is:
```
System.out.println(YOUR_MESSAGE_HERE);
```

Replace `YOUR_MESSAGE_HERE` with the message you want to print.

</details>

<details>
<summary>Hint 3: Full Example</summary>

To print "Hello, Java World!", you would write:
```
System.out.println("Hello, Java World!");
```

This line goes inside the `main()` method between the curly braces `{ }`.

</details>

## Expected Behavior

When you run your program, it should display:
```
Hello, Java World!
```

That's it! Just one line of text.

## How to Test Your Solution

**Option 1: Using Maven (Recommended)**
```bash
cd exercises/001-hello-java
mvn test
```

**Option 2: Manual Compilation and Execution**
```bash
cd exercises/001-hello-java/src
javac HelloJava.java
java HelloJava
```

If you see `Hello, Java World!` printed to the console, your solution works!

## Reflection Questions

After completing this exercise, ask yourself:

1. **What did System.out.println() do?** Why do you think it's called "println" instead of just "print"?
2. **Why do we need quotes around the message?** What would happen if we removed them?
3. **Where does the program start executing?** What role does the `main()` method play?
4. **Can you modify the message?** Try changing it to print your name instead. Does the program still work?

## Next Steps

Once you've completed this exercise, you're ready to move on to the next challenge where you'll learn how to **customize your greeting with your own name**. But first, take a moment to celebrate—you've written and run your first Java program! 🎉

## Useful prompts
- Why do Java programs have .java and .class files?
- What is Java Virtual Machine (JVM)?
- How does Java achieve platform independence?
- What is Java bytecode?

## Read More

- [Oracle Java Tutorial: Your First Cup of Java](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/)
- [System.out.println() Documentation](https://docs.oracle.com/javase/10/docs/api/java/lang/System.html#out)
- [Understanding Java's Main Method](https://www.baeldung.com/java-main-method)
