# Exercise 016: Temperature Converter - Switch Statements

## Introduction

Welcome to Series 4! You've mastered the basics of calculator development—now it's time to apply those skills to a **real-world problem: temperature conversion**. In this exercise, you'll build a comprehensive temperature converter that teaches you about **switch statements**, a powerful way to make decisions based on multiple choices. You'll create a program that converts between Celsius, Fahrenheit, and Kelvin, and uses a menu-driven interface powered by switch statements.

## What You're Learning

**The Switch Statement:**
A `switch` statement evaluates an expression once and executes code based on matching cases. It's ideal when you have many possible values to check:

```java
switch (choice) {
    case 1:
        System.out.println("You chose option 1");
        break;
    case 2:
        System.out.println("You chose option 2");
        break;
    default:
        System.out.println("Invalid choice");
}
```

**Why Switch Over If-Else?**
- **Cleaner**: Easier to read when checking one value against many options
- **More Efficient**: Faster than multiple if-else statements
- **Organized**: All cases are clearly listed in one block
- **Less Error-Prone**: Break statements prevent fall-through errors

**The Break Statement:**
Each case must end with `break;` to prevent "fall-through" to the next case:

```java
case 1:
    result = celsiusToFahrenheit(temp);
    break;  // Don't forget this!
case 2:
    result = celsiusToKelvin(temp);
    break;  // Without break, case 2 code runs after case 1
```

**The Default Case:**
The `default` case is like an "else" for switch—it runs if no other cases match:

```java
switch (operation) {
    case "add":
        // ...
        break;
    case "subtract":
        // ...
        break;
    default:
        System.out.println("Unknown operation!");
}
```

**Temperature Conversion Formulas:**
- **Celsius to Fahrenheit**: $F = (C \times 9/5) + 32$
- **Fahrenheit to Celsius**: $C = (F - 32) \times 5/9$
- **Celsius to Kelvin**: $K = C + 273.15$
- **Kelvin to Celsius**: $C = K - 273.15$
- **Fahrenheit to Kelvin**: $K = (F - 32) \times 5/9 + 273.15$
- **Kelvin to Fahrenheit**: $F = (K - 273.15) \times 9/5 + 32$

**Input Validation with Switch:**
You can use switch to validate menu choices and handle errors gracefully:

```java
switch (userChoice) {
    case 1:
    case 2:
    case 3:
        // Valid choices
        break;
    default:
        System.out.println("Error: Invalid menu choice!");
}
```

## Challenge

Your task: **Create a comprehensive temperature converter with a menu-driven interface using switch statements.**

The program should:
1. Display a menu of temperature conversion options
2. Accept user input for which conversion to perform
3. Accept the temperature value to convert
4. Use a **switch statement** to route to the correct conversion method
5. Perform the conversion with validation
6. Display the result with proper formatting
7. Allow the user to perform multiple conversions in a loop

## Requirements

- Implement conversion methods:
  - `celsiusToFahrenheit(double celsius)` - Convert C to F
  - `fahrenheitToCelsius(double fahrenheit)` - Convert F to C
  - `celsiusToKelvin(double celsius)` - Convert C to K
  - `kelvinToCelsius(double kelvin)` - Convert K to C
  - `fahrenheitToKelvin(double fahrenheit)` - Convert F to K
  - `kelvinToFahrenheit(double kelvin)` - Convert K to F

- Implement menu system:
  - `displayMenu()` - Shows conversion options
  - `validateChoice(int choice)` - Validates menu selection
  - `performConversion(int choice, double temp)` - Uses switch to route conversions

- Use **switch statement** in the main menu logic
- All conversion methods must be `public static`
- Validate user input (temperature values and menu choices)
- Use try...catch for handling invalid number input
- Format results to 2 decimal places
- Display helpful error messages for invalid input
- The main() method should allow multiple conversions in a loop

## Hints

**Hint 1:** Use a switch statement with 6 cases for the 6 possible conversions.

**Hint 2:** Remember to include `break;` after each case to prevent fall-through.

**Hint 3:** Use the `default` case to catch invalid menu choices and display an error message.

**Hint 4:** Combine your temperature converter with the input validation skills from Exercise 014 (try...catch blocks).

**Hint 5:** Use a `while` loop in main() to allow the user to perform multiple conversions without restarting the program.

## Expected Behavior

When you run your program:
```
=== Temperature Converter ===
1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
3. Celsius to Kelvin
4. Kelvin to Celsius
5. Fahrenheit to Kelvin
6. Kelvin to Fahrenheit
0. Exit

Choose an option: 1
Enter temperature: 0
0.00°C = 32.00°F

Choose an option: 3
Enter temperature: 25
25.00°C = 298.15K

Choose an option: 7
Error: Invalid choice. Please select 1-6 or 0 to exit.

Choose an option: 0
Thank you for using the Temperature Converter!
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/016-temperature-converter-switch
mvn test
```

All tests should pass. Tests verify:
- Correct temperature conversion formulas
- Switch statement routing
- Input validation
- Menu choice validation
- Error handling

## Reflection Questions

After completing this exercise, think about:

1. Why is the switch statement more effective than multiple if-else statements in this program?
2. What would happen if you forgot to include `break;` in a case?
3. How does the default case help with error handling?
4. When would you use if-else instead of switch?
5. How could you extend this program to handle more temperature scales (like Rankine or Réaumur)?

## Next Steps

You've successfully completed Series 4! You've learned:
- Temperature conversion formulas
- Switch statements for decision making
- Menu-driven program design
- Input validation and error handling
- Looping for repeated operations

In the next series, you'll combine these skills with conditional logic to create a **BMI Calculator** that classifies health metrics!

## Read More

- [Switch Statements in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html)
- [Temperature Conversion Formulas](https://en.wikipedia.org/wiki/Conversion_of_scales_of_temperature)
- [Menu-Driven Programs](https://www.geeksforgeeks.org/menu-driven-program-using-switch-case-in-java/)
- [Best Practices for Switch Statements](https://www.oracle.com/technical-resources/articles/java/java-switch-statement.html)
