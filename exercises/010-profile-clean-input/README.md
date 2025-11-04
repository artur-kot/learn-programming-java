# Exercise 010: Profile - Clean Input

## Introduction

Welcome to the final exercise in the Profile Card series! Real-world programs need to handle messy user input gracefully. People add extra spaces, use inconsistent capitalization, or make other formatting mistakes. In this exercise, you'll learn how to **clean and normalize** user input to make it consistent and professional.

## What You're Learning

**String Manipulation Methods:**

Java strings have powerful methods for cleaning and transforming text:

- **`trim()`** - Removes leading and trailing whitespace
  ```
  "  hello  ".trim()  // Returns "hello"
  ```

- **`toLowerCase()`** - Converts entire string to lowercase
  ```
  "HELLO".toLowerCase()  // Returns "hello"
  ```

- **`toUpperCase()`** - Converts entire string to uppercase
  ```
  "hello".toUpperCase()  // Returns "HELLO"
  ```

- **`substring(start, end)`** - Extracts part of a string
  ```
  "hello".substring(0, 1)  // Returns "h"
  "hello".substring(1)     // Returns "ello"
  ```

**Capitalizing First Letter:**
To capitalize just the first letter:
```
String name = "john";
String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
// Result: "John"
```

**Method Chaining:**
You can chain multiple string methods together:
```
String cleaned = rawInput.trim().toLowerCase();
```

**Why Clean Input:**
- **Consistency**: "john" and "  John  " should be treated the same
- **Validation**: Check data after cleaning
- **Storage**: Save normalized data
- **Comparison**: "ALICE" == "alice" when both lowercase

## Challenge

Your task: **Clean all user input by trimming whitespace and applying appropriate capitalization. Show both the original and cleaned versions.**

The code collects data. Your job is to clean it using string methods before displaying.

## Requirements

Your solution must:
- Trim whitespace from all string inputs
- Capitalize first and last names properly (First letter uppercase, rest lowercase)
- Convert email to all lowercase
- Convert country code to all UPPERCASE
- Validate the email AFTER cleaning
- Display both original and cleaned values to show the transformation
- Only show full profile if cleaned email is valid

## Hints

<details>
<summary>Hint 1: Cleaning Names</summary>

```
firstName = firstName.trim();
firstName = firstName.substring(0, 1).toUpperCase() + 
            firstName.substring(1).toLowerCase();
```

This trims spaces, then capitalizes the first letter and lowercases the rest.

</details>

<details>
<summary>Hint 2: Cleaning Email</summary>

```
email = email.trim().toLowerCase();
```

Chain methods to trim and lowercase in one step.

</details>

<details>
<summary>Hint 3: Cleaning Country Code</summary>

```
countryCode = countryCode.trim().toUpperCase();
```

</details>

<details>
<summary>Hint 4: Showing Before and After</summary>

Store original values before cleaning:
```
String originalEmail = email;
email = email.trim().toLowerCase();

System.out.println("Original email: " + originalEmail);
System.out.println("Cleaned email:  " + email);
```

</details>

<details>
<summary>Hint 5: Complete Cleaning Flow</summary>

```
// Store originals for comparison
String originalFirst = firstName;
String originalLast = lastName;
String originalEmail = email;

// Clean first name
firstName = firstName.trim();
firstName = firstName.substring(0, 1).toUpperCase() + 
            firstName.substring(1).toLowerCase();

// Clean last name
lastName = lastName.trim();
lastName = lastName.substring(0, 1).toUpperCase() + 
           lastName.substring(1).toLowerCase();

// Clean email
email = email.trim().toLowerCase();

// Clean country code
countryCode = countryCode.trim().toUpperCase();

// Validate cleaned email
boolean isValidEmail = email.contains("@");

if (isValidEmail) {
    System.out.println("\n--- Data Cleaning Summary ---");
    System.out.println("First Name:  \"" + originalFirst + "\" -> \"" + firstName + "\"");
    System.out.println("Last Name:   \"" + originalLast + "\" -> \"" + lastName + "\"");
    System.out.println("Email:       \"" + originalEmail + "\" -> \"" + email + "\"");
    
    System.out.println("\n=== PROFILE CARD ===");
    System.out.printf("Name:    %s %s%n", firstName, lastName);
    System.out.printf("Age:     %d%n", age);
    System.out.printf("Email:   %s%n", email);
    System.out.printf("Country: %s%n", countryCode);
} else {
    System.out.println("\nError: Invalid email after cleaning!");
}
```

</details>

## Expected Behavior

When you run your program with messy input:
```
Enter your first name:   jOHN  
Enter your last name:  sMITH   
Enter your age: 30
Enter your email (may have extra spaces):   JOHN@Example.COM  
Enter your country code (e.g., us, uk, ca):  us  

--- Data Cleaning Summary ---
First Name:  "  jOHN  " -> "John"
Last Name:   " sMITH   " -> "Smith"
Email:       "  JOHN@Example.COM  " -> "john@example.com"

=== PROFILE CARD ===
Name:    John Smith
Age:     30
Email:   john@example.com
Country: US
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/010-profile-clean-input
mvn test
```

**Manual Testing:**
```bash
cd exercises/010-profile-clean-input/src
javac ProfileCleanInput.java
java ProfileCleanInput
```

Try entering messy data with extra spaces and weird capitalization!

## Reflection Questions

1. **Why is data cleaning important?** What problems does it solve?
2. **Should you clean data before or after validation?** Why?
3. **What other cleaning might be useful?** (removing special characters, etc.)
4. **Can you clean data too much?** When might trimming or changing case be wrong?
5. **How would you handle names with multiple capitals?** (McDonald, O'Brien, etc.)

## Next Steps

Congratulations! You've completed Series 2: Profile Card App! 🎉

You've learned:
- Variable declaration and data types
- Reading different input types with Scanner
- Formatted output with printf
- Input validation with conditionals
- String manipulation for data cleaning

In the next series, you'll move on to **working with numbers** by building a Simple Calculator App that performs arithmetic operations.

## Read More

- [String Class Documentation](https://docs.oracle.com/javase/10/docs/api/java/lang/String.html)
- [String Methods Guide](https://www.baeldung.com/java-string-manipulation)
- [Data Validation Best Practices](https://www.baeldung.com/java-validation)
