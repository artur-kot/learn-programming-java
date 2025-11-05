# Exercise 018: BMI Calculator - Advanced

## Overview

Extend the BMI calculator from Exercise 017 to add features:
- BMI interpretation (underweight, normal weight, overweight, obese)
- BMI categories according to WHO standards
- Multiple conversions in one session
- Formatted output with interpretation

## The Challenge

Write a program that:

1. **Takes weight and height input** (same as Exercise 017)

2. **Calculates BMI** using the formula:
   ```
   BMI = weight / (height * height)
   ```

3. **Interprets BMI** using these categories:
   - BMI < 18.5: Underweight
   - 18.5 ≤ BMI < 25: Normal weight
   - 25 ≤ BMI < 30: Overweight
   - BMI ≥ 30: Obese

4. **Displays results** with both BMI and interpretation

5. **Allows multiple conversions** with a menu loop

### Example Run

```
Welcome to Advanced BMI Calculator!

Enter your weight (kg): 70
Enter your height (m): 1.75
Your BMI is: 22.9
Category: Normal weight

Enter another conversion? (yes/no): yes

Enter your weight (kg): 95
Enter your height (m): 1.75
Your BMI is: 31.0
Category: Obese

Enter another conversion? (yes/no): no
Thank you for using BMI Calculator!
```

## Required Methods

Implement the following methods in `BMICalculatorAdvanced.java`:

### `public static double calculateBMI(double weight, double height)`
- Takes weight in kg and height in meters
- Returns BMI as a double
- Throws `IllegalArgumentException` if weight ≤ 0 or height ≤ 0

### `public static String interpretBMI(double bmi)`
- Takes BMI value
- Returns one of: "Underweight", "Normal weight", "Overweight", "Obese"
- Exact strings are important for testing!

### `public static void main(String[] args)`
- Loop that allows multiple conversions
- For each iteration:
  - Prompts for weight and height
  - Uses try...catch for invalid input
  - Calls `calculateBMI()` to compute value
  - Calls `interpretBMI()` to get category
  - Displays both value (1 decimal place) and category
  - Asks if user wants another conversion
- Continues until user chooses to exit

## Hints

- Reuse the `calculateBMI()` method from Exercise 017
- Use if/else statements in `interpretBMI()` to determine category
- Use a while loop for multiple conversions
- Read "yes"/"no" response as a String and check with `.equalsIgnoreCase()`
- Wrap the entire calculation in try...catch for input errors

## Concepts You'll Practice

- Reusing code from previous exercises
- Multiple conditional branches (if/else/else if)
- String comparison
- Loop control with menu options
- Method composition (calling multiple methods)
- Input validation and error handling

## Testing

Your code will be tested with:
- Various BMI values in each category
- Boundary values (18.5, 25, 30)
- Multiple calculation sequences
- Invalid inputs
- Case-insensitive yes/no responses

---

**Checkpoint:** This exercise builds directly on Exercise 017. Make sure that one works before starting here!
