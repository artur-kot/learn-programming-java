# Exercise 003: Hello User - Dynamic Greeting

## Introduction

Ready to make your program interactive? In this exercise, you'll learn how to **ask the user for input** and respond to it. This is what separates a boring program from one that actually engages with people!

## What You're Learning

**The Scanner Class:**
The `Scanner` class is Java's tool for reading user input. It acts like a receiver that listens for what the user types.

Think of it like this:
- You ask the user a question
- The user types an answer
- `Scanner` reads what they typed
- You store it in a variable
- You use that information in your program

**Reading String Input:**
The `nextLine()` method reads everything the user types until they press Enter. This is perfect for names or sentences.

**Interactive Programs:**
An interactive program follows this pattern:
1. Print a prompt (ask the user a question)
2. Read user input
3. Process or respond to that input

Example:
```
System.out.println("What is your name?");
String name = scanner.nextLine();
System.out.println("Hello, " + name + "!");
```

## Challenge

Your task: **Create a program that asks the user for their name, then greets them personally.**

You have:
- A `Scanner` object already created
- A `scanner.close()` call at the end
- Three TODOs showing where to add code

## Requirements

Your solution must:
- Print a prompt asking for the user's name
- Read the user's input using `scanner.nextLine()`
- Store the name in a variable
- Print a personalized greeting using that name
- Close the scanner when done

## Hints

<details>
<summary>Hint 1: The Three Steps</summary>

Your code needs three steps:
1. Ask: `System.out.println("What is your name?");`
2. Read: `String name = scanner.nextLine();`
3. Greet: `System.out.println("Hello, " + name + "!");`

</details>

<details>
<summary>Hint 2: Variable Storage</summary>

The result of `scanner.nextLine()` should be stored in a `String` variable so you can use it later:
```
String name = scanner.nextLine();
```

</details>

<details>
<summary>Hint 3: Complete Example</summary>

Here's what your code might look like:
```
System.out.println("Enter your name: ");
String userName = scanner.nextLine();
System.out.println("Hello, " + userName + "! Nice to meet you!");
```

</details>

## Expected Behavior

When you run your program, it should look like this:

```
Enter your name: 
Alice
Hello, Alice! Nice to meet you!
```

The exact prompt and greeting are up to you!

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/003-hello-user
mvn test
```

**Manual Testing:**
```bash
cd exercises/003-hello-user/src
javac HelloUser.java
java HelloUser
```

Then type your name when prompted and press Enter.

## Reflection Questions

1. **Why do we need to close the scanner?** What resources might it be using?
2. **What happens if you don't store the input in a variable?** Can you still use it?
3. **Can you get different behavior each time you run it?** Why is this different from the previous exercises?
4. **What if the user types multiple words?** Does `nextLine()` handle that?

## Next Steps

You've now created an interactive program! In the next exercise, you'll learn how to **format output** to make it look more professional and organized using `printf`.

## Read More

- [Scanner Class Documentation](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html)
- [Reading User Input in Java](https://www.baeldung.com/java-scanner)
- [Interactive Console Programs](https://docs.oracle.com/javase/tutorial/i18n/resbundle/prepare.html)
