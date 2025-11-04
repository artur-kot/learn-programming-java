# Exercise 008: Profile - Format Output

## Introduction

You've collected the data, now let's make it look amazing! In this exercise, you'll transform plain console output into a beautiful, professional-looking profile card using Java's powerful formatting features.

## What You're Learning

**Advanced printf Formatting:**
Beyond basic `printf`, you can control:
- **Field width**: How much space a value takes
- **Alignment**: Left or right aligned
- **Padding**: Fill empty space with characters

Examples:
```
System.out.printf("%-15s %s%n", "Name:", "Alice");     // Left-aligned, 15 chars wide
System.out.printf("Age:        %d years%n", 25);        // Number formatting
System.out.printf("Email:      %s%n", "alice@ex.com"); // String formatting
```

**Escape Sequences for Layout:**
- `\n` or `%n` - New line
- `\t` - Tab (indentation)
- `\\` - Backslash
- `\"` - Quote mark

**Format Specifiers Review:**
- `%s` - String
- `%d` - Integer (decimal)
- `%f` - Floating-point (use `%.2f` for 2 decimal places)
- `%b` - Boolean
- `%%` - Literal percent sign

**Field Width and Alignment:**
```
%10s   - Right-aligned string in 10-character field
%-10s  - Left-aligned string in 10-character field
%5d    - Right-aligned integer in 5-character field
```

## Challenge

Your task: **Create a beautifully formatted profile card that displays all user information in an organized, professional layout.**

The code already collects the data. Your job is to display it in an attractive format using `printf`.

## Requirements

Your solution must:
- Use `printf` for formatting (not just `println`)
- Display all five pieces of information (name, age, email, city, student status)
- Include visual elements like borders, headers, or dividers
- Use proper spacing and alignment
- Make the output look professional and easy to read
- Use format specifiers appropriately for different data types

## Hints

<details>
<summary>Hint 1: Creating Borders</summary>

You can create visual separators:
```
System.out.println("================================");
System.out.println("       PROFILE CARD");
System.out.println("================================");
```

</details>

<details>
<summary>Hint 2: Aligned Fields</summary>

Use field width to align labels and values:
```
System.out.printf("%-12s %s%n", "Name:", name);
System.out.printf("%-12s %d years%n", "Age:", age);
System.out.printf("%-12s %s%n", "Email:", email);
```

The `%-12s` creates a left-aligned 12-character field for the label.

</details>

<details>
<summary>Hint 3: Boolean Display</summary>

Convert boolean to readable text:
```
String studentStatus = isStudent ? "Yes" : "No";
System.out.printf("%-12s %s%n", "Student:", studentStatus);
```

</details>

<details>
<summary>Hint 4: Complete Card Example</summary>

```
System.out.println("\n================================");
System.out.println("        PROFILE CARD");
System.out.println("================================");
System.out.printf("%-12s %s%n", "Name:", name);
System.out.printf("%-12s %d years%n", "Age:", age);
System.out.printf("%-12s %s%n", "Email:", email);
System.out.printf("%-12s %s%n", "City:", city);
System.out.printf("%-12s %s%n", "Student:", isStudent ? "Yes" : "No");
System.out.println("================================");
```

</details>

## Expected Behavior

When you run your program with sample input, it should look like:
```
Enter your name: Alice Johnson
Enter your age: 25
Enter your email: alice@example.com
Enter your city: New York
Are you a student? (true/false): true

================================
        PROFILE CARD
================================
Name:        Alice Johnson
Age:         25 years
Email:       alice@example.com
City:        New York
Student:     Yes
================================
```

Get creative with your formatting!

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/008-profile-format-output
mvn test
```

**Manual Testing:**
```bash
cd exercises/008-profile-format-output/src
javac ProfileFormatOutput.java
java ProfileFormatOutput
```

## Reflection Questions

1. **Why is formatted output important?** How does it affect user experience?
2. **What's the advantage of using field widths?** Try removing them and see what happens.
3. **Can you create different card styles?** Try a minimalist design vs. a decorative one.
4. **How would you handle very long names or emails?** What happens to your formatting?
5. **Could you add more visual elements?** (ASCII art, colors in terminals that support them?)

## Next Steps

Your profile card looks great! In the next exercise, you'll add **validation** to ensure the email address is properly formatted before accepting it.

## Read More

- [Java printf Format Specifiers](https://docs.oracle.com/javase/tutorial/essential/io/formatting.html)
- [PrintStream printf Documentation](https://docs.oracle.com/javase/10/docs/api/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...))
- [Format String Syntax](https://docs.oracle.com/javase/10/docs/api/java/util/Formatter.html#syntax)
