# Exercise 020: Age Checker - Advanced

## Overview

Extend Exercise 019 to check age-based permissions for various activities. This exercise combines nested conditions, logical operators, and multi-criteria decision making to determine what activities a person can do based on their age.

## What You're Learning

- **Do-While Loops** execute at least once before checking a condition. This is useful for user input validation or menu-driven programs:

```java
do {
  System.out.println("Enter your age: ");
  age = scanner.nextInt();
} while (age < 0 || age > 150); // Keeps asking until valid
```

Unlike a regular while loop, a do-while loop guarantees the code runs at least one time, making it perfect for "Check another person?" prompts where you want to ask first, then decide whether to repeat.

**Nested Conditionals** place if/else statements inside other if/else blocks. This lets you make more complex decisions that consider multiple related factors:

```java
if (age >= 18) {
  if (age >= 21) {
    // Can do activity X
  } else {
    // Can do activity Y but not X
  }
} else {
  // Too young for both
}
```

**Logical Operators** combine multiple conditions:
- `&&` (AND): Both conditions must be true
- `||` (OR): At least one condition must be true
- `!` (NOT): Reverses a condition

Example:
```java
if (age >= 18 && age < 65) {
  // Adult working age
}

if (hasLicense || age >= 18) {
  // Can drive if licensed OR is an adult
}
```

**Permission Systems** in real applications often check multiple criteria together. For example, you might be allowed to drive if (age >= 16) AND (hasLicense == true).

## Challenge Description

Extend your Exercise 019 program to determine what activities a person can do based on their age:

1. **Use the age categories from Exercise 019**
2. **For each activity, check age-based permissions:**
   - **Vote**: Age must be >= 18
   - **Drive**: Age must be >= 16 (add option to skip this check)
   - **Drink alcohol** (age-appropriate message): Age must be >= 21
   - **Work**: Age must be >= 14 (can still go to school)
   - **Adult responsibilities**: Age must be >= 18
3. **Display appropriate messages** based on which activities are allowed
4. **Use nested if/else statements** to check related permissions together
5. **Allow checking multiple people** in one session (loop)

### Example Run

```
=== Age Checker - Advanced ===

Enter your age: 16
Age category: Teenager

Your permissions:
✓ Work (if allowed by law)
✗ Vote (must be 18+)
✗ Drive (must be 16+ with license) - Would need valid license
✓ Drink alcohol message: (informational - must be 21+)
✗ Sign contracts without parental consent (must be 18+)

Check another person? (yes/no): no
```

### Example Run (Adult)

```
=== Age Checker - Advanced ===

Enter your age: 25
Age category: Adult

Your permissions:
✓ Work full-time
✓ Vote in elections
✓ Drive (with valid license)
✓ Legally drink alcohol
✓ Sign contracts independently
✓ Serve on jury (21+)

Check another person? (yes/no): no
```

### Example Run (Child)

```
=== Age Checker - Advanced ===

Enter your age: 10
Age category: Child

Your permissions:
✗ Work (too young)
✗ Vote (must be 18+)
✗ Drive (must be 16+)
✗ Legally drink alcohol (must be 21+)
✗ Sign contracts alone (must be 18+)
→ Can participate in school and recreational activities

Check another person? (yes/no): no
```

## Requirements

- [ ] Reuse the age validation from Exercise 019
- [ ] Use if/else if/else from Exercise 019 for categorization
- [ ] Add nested conditions to check permissions for each activity
- [ ] Use logical operators (&&) to combine multiple criteria
- [ ] Check at least 4 different permission types
- [ ] Provide clear output showing allowed/disallowed activities
- [ ] Use symbols or text to indicate permissions (✓/✗ or Yes/No)
- [ ] Support checking multiple people with a menu loop
- [ ] Handle invalid input gracefully
- [ ] Program compiles without errors
- [ ] All tests pass

## Hints

<details>
<summary>Hint 1: Reuse Your Code</summary>

Copy the age validation and categorization logic from Exercise 019. Don't rewrite it—reuse works!

</details>

<details>
<summary>Hint 2: Permission Structure</summary>

After determining the age category, use nested if statements to check each permission. For example:

```java
if (age >= 18) {
  System.out.println("Can vote: YES");
} else {
  System.out.println("Can vote: NO");
}
```

</details>

<details>
<summary>Hint 3: Using Logical AND</summary>

If a permission requires multiple conditions (like "must work at least 16 hours per week AND be 18+"), use:

```java
if (age >= 18 && hoursPerWeek >= 16) {
  // Permission granted
}
```

</details>

<details>
<summary>Hint 4: Loop for Multiple People</summary>

Wrap your entire age checking logic in a while loop that continues while the user answers "yes" to checking another person.

</details>

## Expected Behavior

Your program should:
- Accept ages and validate them (using Exercise 019 logic)
- Display the age category
- Show permissions for each activity (at least 4)
- Use clear formatting to show what's allowed/disallowed
- Allow looping through multiple ages
- Exit cleanly on invalid input or user request

## Testing Instructions

**Compile and run:**
```bash
cd exercises/020-age-checker-advanced
mvn clean compile
java -cp target/classes AgeCheckerAdvanced
```

**Run tests:**
```bash
cd exercises/020-age-checker-advanced
mvn test
```

**Manual testing scenarios:**
```bash
# Test with various ages to verify permissions:
# 10 (child - no permissions)
# 14 (can work but not vote/drive)
# 16 (can drive and work)
# 18 (can vote and work)
# 21 (can drink)
# 65+ (senior)
```

## Reflection Questions

After completing this exercise:

1. Why are nested conditionals useful? When would you NOT want to nest them?
2. How would your code change if you needed to check 10 different permissions instead of 4?
3. What real-world systems use similar nested permission logic? (think: banking, social media, etc.)
4. Can you think of cases where using `||` (OR) would be better than `&&` (AND)?
5. How could you simplify your code if you had many similar age thresholds?

## Next Steps

- Create a more complex permission system (e.g., based on both age AND location)
- Add a database or file to store people and their permissions
- Build a method-based version to organize permission checks
- Explore switch statements as an alternative to chained if/else

## Read More

- [Java Nested If Statements](https://www.w3schools.com/java/java_conditions_nested.asp)
- [Logical Operators (&&, ||, !)](https://www.w3schools.com/java/java_operators_logical.asp)
- [Complex Boolean Expressions](https://www.baeldung.com/java-boolean)
- [Real-world Permission Systems](https://en.wikipedia.org/wiki/Access_control)
