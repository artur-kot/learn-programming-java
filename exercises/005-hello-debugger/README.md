# Exercise 005: Hello Debugger - Fix the Errors

## Introduction

Every programmer makes mistakes—even experts! The difference is that experienced developers know how to **find and fix them quickly**. In this exercise, you'll become a bug hunter! The provided code has intentional syntax errors, and your job is to read the error messages and fix them one by one.

## What You're Learning

**Compiler Error Messages:**
When Java can't compile your code, it tells you exactly what's wrong. Error messages might look scary, but they're actually your friend—they're trying to help!

A typical error message tells you:
- The file and line number where the error is
- What's wrong
- Suggestions for fixing it

**Common Syntax Errors:**
- Missing semicolons (`;`)
- Mismatched or missing quotes
- Incorrect method names (typos)
- Missing or mismatched parentheses
- Wrong bracket types

**Debugging Strategy:**
1. Run the compiler
2. Read the first error message carefully
3. Find and fix that error
4. Run the compiler again
5. Repeat until no errors remain

## Challenge

Your task: **Find and fix all 5 syntax errors in the provided code.**

The code has hints in comments showing where errors are. Use the compiler error messages to guide you.

## Requirements

Your solution must:
- Fix all syntax errors so the code compiles
- The program should run without crashing
- The output should display three messages:
  - "Hello, Debug World!"
  - Something with the word "Debugger"
  - A welcome message for debugging

## Hints

<details>
<summary>Hint 1: Start at the Top</summary>

Compiler errors are often reported from the top of the file downward. Fix the first error, then recompile.

</details>

<details>
<summary>Hint 2: Read the Error Line Carefully</summary>

When it says "error on line X", look at that exact line. Often the error is at the end of the line (missing semicolon) or involves quotes.

</details>

<details>
<summary>Hint 3: Common Fixes</summary>

Look for:
- Semicolons at the end of statements
- Matching quotes (both open and close)
- Correct method names
- Matching parentheses
- Matching curly braces

</details>

<details>
<summary>Hint 4: The Five Errors</summary>

The code comments mention specific types of errors:
- Missing opening quote
- Missing semicolon
- Incorrect method name
- Missing closing parenthesis
- Wrong quote type

Find and fix each one!

</details>

## Expected Behavior

When you run the corrected program, it should output:
```
Hello, Debug World!
Welcome to debugging, Debugger!
Let's find all the errors!
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/005-hello-debugger
mvn test
```

**Manual Testing:**
```bash
cd exercises/005-hello-debugger/src
javac HelloDebugger.java
java HelloDebugger
```

If you see errors, read them carefully and fix them one by one!

## Reflection Questions

1. **What was your process for debugging?** Did you fix errors in order?
2. **What did the error messages tell you?** Were they helpful in finding the problems?
3. **Did you encounter any "cascade" errors?** (Where one error causes multiple error messages?)
4. **Can you think of why good error messages are important?** How would it feel with no error messages?
5. **What's a strategy for avoiding these mistakes in the future?**

## Next Steps

Congratulations! You've completed Series 1: Hello Java! 🎉

You've learned:
- Printing to the console
- String concatenation
- User input with Scanner
- Formatted output with printf
- Debugging syntax errors

These are the **fundamental building blocks** of Java programming. In the next series, you'll build on these skills to create a **Profile Card App** that manages multiple pieces of information about a person.

## Read More

- [Java Compiler Error Messages](https://docs.oracle.com/javase/tutorial/getStarted/cupojava/problems.html)
- [Common Java Mistakes](https://www.baeldung.com/java-common-mistakes)
- [Debug Your Code](https://docs.oracle.com/javase/tutorial/getStarted/debugging/)
