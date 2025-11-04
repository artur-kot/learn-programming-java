# Exercise 006: Profile - Store Info

## Introduction

Welcome to Series 2! In this series, you'll build a Profile Card App that manages personal information. Think of it like creating a digital business card or social media profile. In this first exercise, you'll learn how to store different types of information using **variables**.

## What You're Learning

**Data Types:**
Different kinds of information need different types of storage. Java has several built-in data types:

- **`String`** - Text (words, sentences, emails). Must be in quotes: `"Hello"`
- **`int`** - Whole numbers (age, count, year): `25`, `-10`, `2024`
- **`double`** - Decimal numbers (prices, measurements): `3.14`, `99.99`
- **`boolean`** - True or false values: `true`, `false`
- **`char`** - Single character: `'A'`, `'5'`, `'@'`

**Variable Declaration:**
Creating a variable has this pattern:
```
dataType variableName = value;
```

Examples:
```
String name = "Alice";
int age = 25;
boolean isStudent = true;
```

**Why Data Types Matter:**
Using the right type ensures your program:
- Uses memory efficiently
- Performs correct operations (you can't multiply strings!)
- Catches errors early (compiler checks types)

**Variable Names:**
Good variable names are:
- Descriptive: `age` not `a`
- camelCase: `firstName` not `firstname` or `first_name`
- Meaningful: `isStudent` not `x`

## Challenge

Your task: **Create variables to store a person's profile information, then print it out.**

You need to store:
- A name (String)
- An age (int)
- An email address (String)
- Student status (boolean)

## Requirements

Your solution must:
- Declare four variables with appropriate data types
- Assign values to each variable
- Print all four pieces of information
- Use descriptive variable names
- Each piece of info should be visible in the output

## Hints

<details>
<summary>Hint 1: Variable Declaration Pattern</summary>

Remember the pattern:
```
String variableName = "value";
int variableName = 123;
boolean variableName = true;
```

</details>

<details>
<summary>Hint 2: Example Variables</summary>

Here's how to create a name variable:
```
String name = "Alice";
```

An age variable:
```
int age = 25;
```

</details>

<details>
<summary>Hint 3: Printing Variables</summary>

You can print labels and variables together:
```
System.out.println("Name: " + name);
System.out.println("Age: " + age);
```

</details>

<details>
<summary>Hint 4: Complete Example Structure</summary>

Your code might look like:
```
String name = "Your Name";
int age = 25;
String email = "your.email@example.com";
boolean isStudent = true;

System.out.println("Name: " + name);
System.out.println("Age: " + age);
System.out.println("Email: " + email);
System.out.println("Student: " + isStudent);
```

</details>

## Expected Behavior

When you run your program, it should output something like:
```
Name: Alice
Age: 25
Email: alice@example.com
Student: true
```

Use your own information!

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/006-profile-store-info
mvn test
```

**Manual Testing:**
```bash
cd exercises/006-profile-store-info/src
javac ProfileStoreInfo.java
java ProfileStoreInfo
```

## Reflection Questions

1. **Why do we need different data types?** What would happen if everything was a String?
2. **Can you store age as a String?** What are the pros and cons?
3. **What happens if you try to assign "twenty-five" to an int variable?**
4. **Why is `boolean` useful?** What kinds of questions can it answer?
5. **Can you change variable values after creating them?** Try it!

## Next Steps

You've learned how to store information in variables! In the next exercise, you'll make your profile interactive by **asking the user to input their own information** instead of hardcoding it.

## Read More

- [Java Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Variables in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
- [Primitive Data Types](https://www.baeldung.com/java-primitives)
