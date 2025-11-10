import java.util.Scanner;

/**
 * Calculator Refactor Exercise
 *
 * This calculator works perfectly, but the code is a MESS!
 * All the logic is crammed into the main() method, making it:
 * - Hard to read
 * - Hard to maintain
 * - Hard to test
 * - Hard to reuse
 *
 * Your mission: REFACTOR this messy code by extracting logical pieces
 * into well-organized, reusable methods.
 *
 * IMPORTANT: The calculator must work EXACTLY the same after refactoring!
 * You're improving the CODE STRUCTURE, not changing functionality.
 */
public class CalculatorRefactor {

    // TODO: Extract these methods from the messy main() code below:
    //
    // 1. public static double add(double a, double b)
    //    - Returns the sum of a and b
    //
    // 2. public static double subtract(double a, double b)
    //    - Returns the difference (a - b)
    //
    // 3. public static double multiply(double a, double b)
    //    - Returns the product (a * b)
    //
    // 4. public static double divide(double a, double b)
    //    - Returns the quotient (a / b)
    //    - Returns 0.0 if b is zero (with error message)
    //
    // 5. public static void displayMenu()
    //    - Prints the calculator menu
    //
    // 6. public static double getNumberInput(String prompt)
    //    - Prints "Enter [prompt] number: "
    //    - Reads and returns a double from user
    //
    // 7. public static void performOperation(int choice, double a, double b)
    //    - Takes the user's choice and two numbers
    //    - Calls the appropriate math method (add, subtract, multiply, divide)
    //    - Prints the result in format: "Result: a [op] b = result"

    // TODO: Create your extracted methods here









    /**
     * MESSY CODE BELOW - This all needs to be refactored!
     *
     * Notice how everything is jumbled together in one giant method.
     * It works, but it's hard to understand and maintain.
     *
     * Your job: Extract the logical pieces into the methods listed above.
     */
    public static void main(String[] args) {
        // This is the MESSY version - all logic crammed in one place
        // After refactoring, this should be SHORT and CLEAN

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            // Menu display - could be extracted to displayMenu()
            System.out.println("\n=== Simple Calculator ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

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

            // Getting first number - could be extracted to getNumberInput()
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            // Getting second number - could be extracted to getNumberInput()
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            // Operation logic - could be extracted to performOperation()
            // Math operations could be extracted to add(), subtract(), multiply(), divide()
            double result = 0;
            String operator = "";
            boolean validOperation = true;

            if (choice == 1) {
                // Addition logic - extract to add()
                result = num1 + num2;
                operator = "+";
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            } else if (choice == 2) {
                // Subtraction logic - extract to subtract()
                result = num1 - num2;
                operator = "-";
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            } else if (choice == 3) {
                // Multiplication logic - extract to multiply()
                result = num1 * num2;
                operator = "*";
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            } else if (choice == 4) {
                // Division logic - extract to divide()
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                    validOperation = false;
                } else {
                    result = num1 / num2;
                    operator = "/";
                    System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
                }
            }
        }

        scanner.close();

        // TODO: After refactoring, your main() should look something like this:
        //
        // Scanner scanner = new Scanner(System.in);
        // boolean keepRunning = true;
        //
        // while (keepRunning) {
        //     displayMenu();
        //     int choice = scanner.nextInt();
        //
        //     if (choice == 5) {
        //         keepRunning = false;
        //         System.out.println("Thank you for using the calculator!");
        //         continue;
        //     }
        //
        //     if (choice < 1 || choice > 5) {
        //         System.out.println("Invalid choice! Please enter 1-5.");
        //         continue;
        //     }
        //
        //     double num1 = getNumberInput("first");
        //     double num2 = getNumberInput("second");
        //
        //     performOperation(choice, num1, num2);
        // }
        //
        // scanner.close();
    }
}
