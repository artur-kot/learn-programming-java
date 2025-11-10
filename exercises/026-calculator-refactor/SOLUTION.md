# Solution: Calculator Refactor

This solution demonstrates how to refactor the messy calculator code into clean, well-organized methods.

## Solution Code

```java
import java.util.Scanner;

public class CalculatorRefactor {

    /**
     * Adds two numbers
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts second number from first
     * @param a First number
     * @param b Second number
     * @return Difference (a - b)
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers
     * @param a First number
     * @param b Second number
     * @return Product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides first number by second
     * @param a First number (numerator)
     * @param b Second number (denominator)
     * @return Quotient (a / b), or 0.0 if b is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0.0;
        }
        return a / b;
    }

    /**
     * Displays the calculator menu
     */
    public static void displayMenu() {
        System.out.println("\n=== Simple Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    /**
     * Gets a number from the user
     * @param prompt Description of which number (e.g., "first", "second")
     * @return The number entered by the user
     */
    public static double getNumberInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + prompt + " number: ");
        return scanner.nextDouble();
    }

    /**
     * Performs the selected operation and displays the result
     * @param choice Operation choice (1=add, 2=subtract, 3=multiply, 4=divide)
     * @param a First number
     * @param b Second number
     */
    public static void performOperation(int choice, double a, double b) {
        double result = 0;
        String operator = "";

        switch (choice) {
            case 1:
                result = add(a, b);
                operator = "+";
                System.out.println("Result: " + a + " " + operator + " " + b + " = " + result);
                break;
            case 2:
                result = subtract(a, b);
                operator = "-";
                System.out.println("Result: " + a + " " + operator + " " + b + " = " + result);
                break;
            case 3:
                result = multiply(a, b);
                operator = "*";
                System.out.println("Result: " + a + " " + operator + " " + b + " = " + result);
                break;
            case 4:
                operator = "/";
                if (b == 0) {
                    divide(a, b); // This will print the error message
                } else {
                    result = divide(a, b);
                    System.out.println("Result: " + a + " " + operator + " " + b + " = " + result);
                }
                break;
        }
    }

    /**
     * Main method - now clean and organized!
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 5) {
                keepRunning = false;
                System.out.println("Thank you for using the calculator!");
                continue;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please enter 1-5.");
                continue;
            }

            double num1 = getNumberInput("first");
            double num2 = getNumberInput("second");

            performOperation(choice, num1, num2);
        }

        scanner.close();
    }
}
```

## Key Improvements

### 1. Single Responsibility Principle
Each method now has ONE clear job:
- `add()` - only adds
- `subtract()` - only subtracts
- `displayMenu()` - only shows the menu
- `performOperation()` - only executes operations

### 2. Code Reuse
The math operations can now be called from anywhere:
```java
double total = add(100, 50);
double difference = subtract(total, 25);
```

### 3. Readability
Compare the main methods:

**Before:**
```java
public static void main(String[] args) {
    // 60+ lines of tangled logic
}
```

**After:**
```java
public static void main(String[] args) {
    // 15 clean, readable lines
    displayMenu();
    // get input
    // perform operation
}
```

### 4. Maintainability
Need to fix a bug in division? Just look at the `divide()` method!
Need to change the menu? Just update `displayMenu()`!

### 5. Testability
Each method can be tested independently:
```java
assertEquals(15.0, add(10.0, 5.0));
assertEquals(5.0, subtract(10.0, 5.0));
```

## Alternative Approach: Better getNumberInput()

You could enhance `getNumberInput()` to accept a Scanner parameter:

```java
public static double getNumberInput(Scanner scanner, String prompt) {
    System.out.print("Enter " + prompt + " number: ");
    return scanner.nextDouble();
}
```

Then in main:
```java
double num1 = getNumberInput(scanner, "first");
double num2 = getNumberInput(scanner, "second");
```

This avoids creating multiple Scanner objects.

## What You Learned

1. **Refactoring** - Improving code structure without changing behavior
2. **Method Extraction** - Breaking large methods into smaller, focused ones
3. **Single Responsibility** - Each method does one thing well
4. **DRY Principle** - Don't Repeat Yourself
5. **Modular Design** - Building programs from reusable components
6. **Clean Code** - Writing code that's easy to read and maintain

## Testing Your Solution

Compile:
```bash
javac src/CalculatorRefactor.java
```

Run:
```bash
java -cp src CalculatorRefactor
```

Test:
```bash
mvn test
```

All 14 tests should pass!
