# Exercise 019: Age Checker - Basic

## Overview

Create a program that takes a user's age as input and determines what privileges or restrictions apply based on their age. This exercise combines checking ages against multiple thresholds, validating input, and using chained conditional statements.

## What You're Learning

**Relational Operators** compare two values and return true or false:
- `>` greater than
- `<` less than
- `>=` greater than or equal to
- `<=` less than or equal to
- `==` equal to
- `!=` not equal to

**Chained if/else if/else statements** allow you to check multiple conditions in sequence. Only the first condition that is true will execute; all others are skipped:

```java
if (firstCondition) {
  // runs if firstCondition is true
} else if (secondCondition) {
  // runs if firstCondition is false AND secondCondition is true
} else if (thirdCondition) {
  // runs if first two are false AND this is true
} else {
  // runs if all previous conditions are false
}
```

**Input Validation** means checking that user input makes sense before using it. For age, we typically validate that it's not negative and not unreasonably high.

## Challenge Description

Write a program that:

1. **Prompts the user** for their age
2. **Validates the input** - rejects ages less than 0 or greater than 120
3. **Checks age against these categories:**
   - Age is 0: Display "Newborn"
   - Age between 1-12 (inclusive): Display "Child"
   - Age between 13-19 (inclusive): Display "Teenager"
   - Age between 20-64 (inclusive): Display "Adult"
   - Age 65 or older: Display "Senior"
4. **Handle invalid input:** Display error message and exit cleanly

### Example Run (Valid Input)

```
Enter your age: 25
Age category: Adult
Recommendation: Time to build your career and independence!
```

### Example Run (Another Valid Input)

```
Enter your age: 7
Age category: Child
Recommendation: Focus on learning and having fun!
```

### Example Run (Invalid Input)

```
Enter your age: 150
Invalid age! Age must be between 0 and 120
```

## Requirements

- [ ] Use `Scanner` to read user input
- [ ] Accept age as an integer
- [ ] Validate that age is >= 0 AND <= 120
- [ ] **Option A (if/else if/else):** Use if/else if/else statements to determine age category (at least 5 branches)
- [ ] **Option B (switch statement):** Alternatively, implement using a switch statement
- [ ] Display the age category with "Age category: " prefix
- [ ] Display an appropriate recommendation for each age group
- [ ] Handle invalid input with error message and exit cleanly
- [ ] Program compiles without errors
- [ ] All tests pass

## Requirements

- [ ] Use `Scanner` to read user input
- [ ] Accept age as an integer
- [ ] Validate that age is >= 0 AND <= 120
- [ ] Use if/else if/else statements to determine age category (at least 5 branches)
- [ ] Display the age category
- [ ] Handle invalid input with an error message
- [ ] Clean exit after invalid input
- [ ] Program compiles without errors
- [ ] All tests pass

## Two Approaches: if/else if vs switch

You can solve this exercise using **two different approaches**:

### Approach 1: if/else if/else Statements

This is the most straightforward approach for this problem:

```java
if (age < 0 || age > 120) {
    System.out.println("Invalid age! Age must be between 0 and 120");
    return;
}

if (age == 0) {
    System.out.println("Age category: Newborn");
    // ... recommendation
} else if (age >= 1 && age <= 12) {
    System.out.println("Age category: Child");
    // ... recommendation
} else if (age >= 13 && age <= 19) {
    System.out.println("Age category: Teenager");
    // ... recommendation
}
// ... and so on
```

**Best for:** Checking ranges and conditions with complex logic

### Approach 2: switch Statement

Switch statements work best when checking exact values, but you can also use them here by creating "buckets":

```java
if (age < 0 || age > 120) {
    System.out.println("Invalid age! Age must be between 0 and 120");
    return;
}

// Convert age into a category index
int ageGroup;
if (age == 0) ageGroup = 0;           // Newborn
else if (age <= 12) ageGroup = 1;     // Child
else if (age <= 19) ageGroup = 2;     // Teenager
else if (age <= 64) ageGroup = 3;     // Adult
else ageGroup = 4;                    // Senior

switch (ageGroup) {
    case 0:
        System.out.println("Age category: Newborn");
        System.out.println("Recommendation: Take care and enjoy early development!");
        break;
    case 1:
        System.out.println("Age category: Child");
        System.out.println("Recommendation: Focus on learning and having fun!");
        break;
    // ... cases 2, 3, 4
    default:
        break;
}
```

**Best for:** When you have many exact values to check

**Tip:** Try implementing the solution with **Approach 1 first** (if/else if), then refactor it using **Approach 2 (switch)** to see the difference!

## Hints

<details>
<summary>Hint 1: Getting Started</summary>

Start by getting the age input from the user and storing it in an integer variable. Don't worry about validation yet—just get it working.

</details>

<details>
<summary>Hint 2: Validation Check</summary>

After reading the age, check if it's valid (>= 0 AND <= 120) before checking categories. If invalid, print an error and exit.

</details>

<details>
<summary>Hint 3: Building the Chain</summary>

Use if/else if/else to check each age range. Remember: the first condition that's true executes, so order matters. Start with the youngest ages first.

</details>

<details>
<summary>Hint 4: Age Boundaries</summary>

When checking "between 13 and 19", use: `age >= 13 && age <= 19`. The `&&` means "AND" - both conditions must be true.

</details>

## Expected Behavior

Your program should:
- Accept any integer input (even negative or huge)
- Reject ages outside 0-120 with a clear error message
- Categorize valid ages correctly
- Display category
- Exit cleanly after processing

## Testing Instructions

**Compile and run:**
```bash
cd exercises/019-age-checker-basic
mvn clean compile
mvn exec:java -Dexec.mainClass="AgeCheckerBasic" -Dexec.args="0"
```

**Run tests:**
```bash
cd exercises/019-age-checker-basic
mvn test
```

**Manual testing:**
```bash
cd exercises/019-age-checker-basic
mvn compile
java -cp target/classes AgeCheckerBasic
# Then type test values: 0, 5, 15, 30, 70, -1, 150
```

## Reflection Questions

After completing this exercise, think about:

1. Why is input validation important? What could go wrong without it?
2. How would your code change if you had 10 age categories instead of 5?
3. What if you wanted to check multiple conditions at the same time (e.g., "teenager AND can drive")? How would that work?
4. Can you think of other real-world scenarios where you'd use similar age-based logic (voting, renting cars, movie ratings, etc.)?

## Next Steps

- Extend this program to handle decimal ages (like 5.5 years)
- Add more categories with more specific ranges
- Combine this with Exercise 020 to add complex permissions logic
- Use arrays or switch statements to organize your categories

## Read More

- [Java Relational Operators](https://www.w3schools.com/java/java_operators.asp)
- [If...Else Statements](https://www.w3schools.com/java/java_conditions.asp)
- [Logical Operators (AND, OR)](https://www.w3schools.com/java/java_operators_logical.asp)
- [Input Validation Patterns](https://www.baeldung.com/java-input-validation)
