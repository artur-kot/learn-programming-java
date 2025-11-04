# Exercise 009: Profile - Validate Email

## Introduction

Real programs need to check user input before accepting it. In this exercise, you'll add your first **validation logic** to ensure the email address looks reasonable before storing it in the profile.

## What You're Learning

**String Methods:**
Java strings have many built-in methods for checking content:

- **`contains(String)`** - Returns true if the string contains the specified substring
  ```
  "hello@world.com".contains("@")  // returns true
  "helloworld.com".contains("@")   // returns false
  ```

- **`startsWith(String)`** - Checks if string starts with specified text
- **`endsWith(String)`** - Checks if string ends with specified text
- **`isEmpty()`** - Returns true if the string has no characters
- **`length()`** - Returns the number of characters

**Conditional Statements:**
Make decisions in your code using `if/else`:

```
if (condition) {
    // Code runs if condition is true
} else {
    // Code runs if condition is false
}
```

**Input Validation Pattern:**
1. Get user input
2. Check if it meets requirements
3. If valid: proceed normally
4. If invalid: show error and don't use the data

**Boolean Variables:**
You can store the result of a condition:
```
boolean isValid = email.contains("@");
if (isValid) {
    // ...
}
```

## Challenge

Your task: **Validate that the email address contains an "@" symbol. Only display the profile card if the email is valid.**

The code already collects the data. Add validation logic to check the email and provide feedback.

## Requirements

Your solution must:
- Use `email.contains("@")` to check for the @ symbol
- Use an if/else statement to handle valid vs invalid cases
- Display an error message if the email is invalid
- Only show the full profile card if the email is valid
- Continue asking for city even if email is invalid (collect all data first)
- Give clear feedback to the user about what's wrong

## Hints

<details>
<summary>Hint 1: Basic Validation</summary>

Check if email contains "@":
```
if (email.contains("@")) {
    System.out.println("Email is valid!");
} else {
    System.out.println("Error: Email must contain '@'");
}
```

</details>

<details>
<summary>Hint 2: Storing Validity</summary>

Use a boolean to track if email is valid:
```
boolean isValidEmail = email.contains("@");

if (isValidEmail) {
    // Display success message
} else {
    // Display error message
}
```

</details>

<details>
<summary>Hint 3: Conditional Profile Display</summary>

Only show the profile if email is valid:
```
boolean isValidEmail = email.contains("@");

if (!isValidEmail) {
    System.out.println("Error: Invalid email address. Email must contain '@'.");
} else {
    // Print the formatted profile card here
    System.out.println("\n=== PROFILE CARD ===");
    // ... rest of profile
}
```

</details>

<details>
<summary>Hint 4: Complete Flow</summary>

```
// After collecting all input...
boolean isValidEmail = email.contains("@");

if (isValidEmail) {
    System.out.println("\n================================");
    System.out.println("        PROFILE CARD");
    System.out.println("================================");
    System.out.printf("%-12s %s%n", "Name:", name);
    System.out.printf("%-12s %d years%n", "Age:", age);
    System.out.printf("%-12s %s%n", "Email:", email);
    System.out.printf("%-12s %s%n", "City:", city);
    System.out.println("================================");
} else {
    System.out.println("\nError: Invalid email address!");
    System.out.println("Email must contain the '@' symbol.");
}
```

</details>

## Expected Behavior

**With valid email:**
```
Enter your name: Alice Johnson
Enter your age: 25
Enter your email: alice@example.com
Enter your city: New York

================================
        PROFILE CARD
================================
Name:        Alice Johnson
Age:         25 years
Email:       alice@example.com
City:        New York
================================
```

**With invalid email:**
```
Enter your name: Bob Smith
Enter your age: 30
Enter your email: bobexample.com
Enter your city: Boston

Error: Invalid email address!
Email must contain the '@' symbol.
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/009-profile-validate-email
mvn test
```

**Manual Testing:**
```bash
cd exercises/009-profile-validate-email/src
javac ProfileValidateEmail.java
java ProfileValidateEmail
```

Try both valid and invalid emails!

## Reflection Questions

1. **Why validate user input?** What could go wrong without validation?
2. **Is checking for "@" enough for email validation?** What else might you check?
3. **Should you still ask for city if email is invalid?** Why or why not?
4. **How would you validate other fields?** (age > 0, name not empty, etc.)
5. **What about multiple validation errors?** How could you report them all at once?

## Next Steps

You've added validation! In the final exercise of this series, you'll learn how to **clean up user input** by trimming whitespace and adjusting capitalization to make the profile look professional.

## Read More

- [String contains() Method](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html#contains(java.lang.CharSequence))
- [Java if/else Statements](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html)
- [Email Validation in Java](https://www.baeldung.com/java-email-validation)
