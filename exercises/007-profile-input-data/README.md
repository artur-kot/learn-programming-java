# Exercise 007: Profile - Input Data

## Introduction

In the last exercise, you hardcoded profile information. Now it's time to make it truly interactive! You'll ask the user to enter their own information, including different types of data like numbers and true/false values.

## What You're Learning

**Scanner Methods for Different Types:**
The `Scanner` class has different methods for reading different data types:

- **`nextLine()`** - Reads a full line of text (String)
- **`next()`** - Reads a single word (String)
- **`nextInt()`** - Reads an integer number
- **`nextDouble()`** - Reads a decimal number
- **`nextBoolean()`** - Reads true or false

**Input Buffer Management:**
Here's an important gotcha: After reading numbers with `nextInt()` or `nextDouble()`, there's often a leftover newline character in the input buffer. You need to clear it with an extra `nextLine()` call.

Example:
```
int age = scanner.nextInt();
scanner.nextLine();  // Clear the buffer!
String email = scanner.nextLine();
```

**Type Matching:**
The input type must match what the method expects:
- `nextInt()` expects whole numbers: `25` ✓, `"twenty-five"` ✗
- `nextBoolean()` expects: `true` or `false` (case-insensitive)

## Challenge

Your task: **Create an interactive profile builder that asks for name, age, email, and student status, then displays all the information.**

Building on exercise 006, now get the data from user input instead of hardcoding it.

## Requirements

Your solution must:
- Prompt for each piece of information with a clear message
- Read the name using an appropriate Scanner method
- Read the age as an integer
- Read the email address
- Read the student status as a boolean
- Handle the input buffer correctly between different input types
- Display a summary of all collected information

## Hints

<details>
<summary>Hint 1: Reading Different Types</summary>

```
System.out.print("Enter your name: ");
String name = scanner.nextLine();

System.out.print("Enter your age: ");
int age = scanner.nextInt();
```

</details>

<details>
<summary>Hint 2: Buffer Clearing</summary>

After `nextInt()` or `nextBoolean()`, call `nextLine()` to clear the buffer:
```
int age = scanner.nextInt();
scanner.nextLine();  // Don't forget this!
```

</details>

<details>
<summary>Hint 3: Reading Boolean</summary>

To read a boolean value:
```
System.out.print("Are you a student? (true/false): ");
boolean isStudent = scanner.nextBoolean();
```

</details>

## Expected Behavior

When you run your program, it should look like:
```
Enter your name: Alice Johnson
Enter your age: 25
Enter your email: alice@example.com
Are you a student? (true/false): true

--- Profile Summary ---
Name: Alice Johnson
Age: 25
Email: alice@example.com
Student: true
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/007-profile-input-data
mvn test
```

**Manual Testing:**
```bash
cd exercises/007-profile-input-data/src
javac ProfileInputData.java
java ProfileInputData
```

## Reflection Questions

1. **What happens if you enter text when it expects a number?** Try it!
2. **Why do we need to clear the buffer after nextInt()?** What happens if you forget?
3. **Can you use nextLine() for everything?** What would you need to do differently?
4. **What's the advantage of reading different types?** Why not read everything as strings?
5. **How would you handle invalid input gracefully?** (We'll cover this in later exercises!)

## Next Steps

You've created an interactive profile builder! In the next exercise, you'll learn how to **format the output beautifully** using `printf` to make your profile card look professional.

## Read More

- [Scanner Class Documentation](https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html)
- [Reading Input in Java](https://www.baeldung.com/java-scanner)
- [Scanner Input Buffer Issues](https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo)
