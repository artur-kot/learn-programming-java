# Exercise 025: Methods Basics - Email Validation & String Reversal

## Overview

You've already learned method syntax. Now it's time to apply that knowledge to **real-world problems**. In this exercise, you'll create two practical utility methods that solve actual programming tasks: validating an email address and reversing a string.

## What You're Learning

### From Syntax to Practice

You now know:
- How to define methods with parameters
- How to work with return values  
- When to use `void` vs returning a value

But **syntax is just the beginning**. Real developers design methods around:

1. **Clear Purpose** - Each method does ONE thing well
2. **Reusability** - Methods are called multiple times with different inputs
3. **Correctness** - Edge cases matter (empty strings, missing characters, etc.)
4. **Testing** - Methods that return values are easier to test than methods that print
5. **Flexibility** - Methods that return values let the caller decide what to do with the result

## Challenge Description

You need to create **2 methods** from scratch (you decide the names, parameters, and return types):

1. **Email Validator** - Checks if an email address is properly formatted (contains both '@' and '.')
2. **String Reverser** - Takes a string and returns it reversed

No method signatures are provided—you must figure out:
- What should the method be named?
- What parameter(s) should it accept?
- What should it return?

## Requirements

- Create **exactly 2 methods** (from scratch, no starter signatures)
- Each method must have a **clear, single purpose**
- Each method should use a `return` statement to send a value back
- Method names should be descriptive (match the test expectations)
- Test your methods in `main()` by calling them with different inputs
- Your `main()` method should demonstrate both methods working correctly

## Hints

### Hint 1: Email Validation
What makes a valid email? The simplest check: does it contain both '@' and '.'?

Think about:
- What parameter does the method need? (the email string to validate)
- What should it return? (true if valid, false if not)
- What's the method name? (should be clear what it does)

### Hint 2: String Reversal
You can reverse a string by building it backward. Remember:
- Strings have a `.charAt(index)` method to get individual characters
- Strings have a `.length()` method
- You can loop backward: `for (int i = text.length() - 1; i >= 0; i--)`

Think about:
- What parameter does the method need? (the string to reverse)
- What should it return? (the reversed string)
- What's the method name? (should be clear what it does)

## Expected Behavior

When you test your code:
```
isValidEmail("alice@example.com") → true
isValidEmail("notanemail") → false

reverseString("hello") → "olleh"
reverseString("") → ""
```

Price: $100 with 20% off -> $80.0

Text: "Programming" -> Vowels: 3


## Testing Instructions

Run your tests:
```bash
mvn test
```

Your methods should pass all 8 test cases. Tests verify:
- Email validation with various inputs (@, ., edge cases)
- String reversal correctness (including empty strings and single characters)

If a test fails:
1. Check your method names match exactly: `isValidEmail` and `reverseString`
2. Verify you're returning the correct type (boolean for email, String for reversal)
3. Test edge cases: empty strings, single characters, multiple dots or @ symbols

## Reflection Questions

After completing this exercise, think about:

1. **Why return a value instead of printing?** How does that make your methods more reusable?
2. **What edge cases did you miss initially?** (empty string, single character, multiple @ symbols?)
3. **Could your email validation be improved?** What other checks could make it better?
4. **Where would these methods be useful?** Name 3 real programs that might use them.

## Next Steps

- **Exercise 026** teaches **method overloading**—creating multiple methods with the same name but different parameters
- After that, **Exercise 027** shows you how to refactor messy code by extracting it into well-organized methods

## Read More

- [Oracle Java Tutorials - Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- String methods in Java: `.contains()`, `.charAt()`, `.length()`
- Using return values from methods
```

## Testing Instructions

Run your tests:
```bash
mvn test
```

Your methods should pass all test cases. Tests verify:
- Email validation logic
- String reversal correctness
- Discount calculations
- Vowel counting
- State abbreviation mapping

If a test fails, check:
1. Are you returning the correct type?
2. Are you handling edge cases (empty strings, special characters)?
3. Are your conditions correct?

## Reflection Questions

After completing this exercise, think about:

1. **Why did you return values instead of printing?** How does that make your methods more flexible?
2. **Could you combine any of these methods?** For example, could `reverseString()` be useful inside another method?
3. **What happens if someone passes `null` to your method?** How would you handle that?
4. **If you needed these methods in 5 different programs, why is it better to have them in a library than rewriting them each time?**

## Next Steps

- **Exercise 026** teaches **method overloading**—creating multiple methods with the same name but different parameters
- After that, **Exercise 027** shows you how to refactor messy code by extracting it into well-organized methods

## Read More

- [Oracle Java Tutorials - Defining Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)
- String methods in Java: `.charAt()`, `.length()`, `.toUpperCase()`, `.toLowerCase()`
- Return values: How to use the result of a method call in your code
