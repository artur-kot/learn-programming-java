
import java.util.Scanner;

/**
 * REFACTORING EXERCISE: Calculator Mini-App
 *
 * This calculator works, but the code is poorly organized! All logic is crammed
 * into the main() method.
 *
 * YOUR TASK: Refactor this code by extracting methods for: 1. Individual
 * operations (add, subtract, multiply, divide) 2. Input validation 3. User
 * input handling 4. Menu display 5. Operation dispatch logic
 *
 * The functionality should NOT change - just reorganize the code! This is
 * called REFACTORING - improving code without changing behavior.
 */
public class CalculatorRefactor {

    // TODO: Add operation methods here (add, subtract, multiply, divide)
    // TODO: Add validation methods here (isValidNumber, isValidOperation)
    // TODO: Add input methods here (getNumber, getOperation)
    // TODO: Add menu and coordination methods here (displayMenu, performOperation)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("        Welcome to Calculator!");
        System.out.println("========================================\n");

        // MONOLITHIC CODE - NEEDS REFACTORING!
        // All logic is here in main() - this is BAD DESIGN!
        // You should extract this into multiple methods.
        boolean running = true;

        while (running) {
            // DISPLAY MENU
            System.out.println("\nMenu:");
            System.out.println("  1. Add (+)");
            System.out.println("  2. Subtract (-)");
            System.out.println("  3. Multiply (*)");
            System.out.println("  4. Divide (/)");
            System.out.println("  5. Exit");

            // GET OPERATION - WITH VALIDATION (REPEATED CODE!)
            String operation = "";
            boolean validOp = false;
            while (!validOp) {
                System.out.print("Enter operation (1-5): ");
                String choice = scanner.nextLine().trim();

                if (choice.equals("1")) {
                    operation = "+";
                    validOp = true;
                } else if (choice.equals("2")) {
                    operation = "-";
                    validOp = true;
                } else if (choice.equals("3")) {
                    operation = "*";
                    validOp = true;
                } else if (choice.equals("4")) {
                    operation = "/";
                    validOp = true;
                } else if (choice.equals("5")) {
                    operation = "exit";
                    validOp = true;
                } else {
                    System.out.println("Invalid choice! Please enter 1-5.");
                }
            }

            // CHECK FOR EXIT
            if (operation.equals("exit")) {
                running = false;
                break;
            }

            // GET FIRST NUMBER - WITH VALIDATION (REPEATED CODE!)
            double num1 = 0;
            boolean valid1 = false;
            while (!valid1) {
                System.out.print("Enter first number: ");
                try {
                    num1 = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    if (num1 >= 0 && num1 <= 1000000) {
                        valid1 = true;
                    } else {
                        System.out.println("Invalid input! Number must be between 0 and 1000000.");
                    }
                } catch (Exception e) {
                    scanner.nextLine(); // consume invalid input
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }

            // GET SECOND NUMBER - WITH VALIDATION (REPEATED CODE!)
            double num2 = 0;
            boolean valid2 = false;
            while (!valid2) {
                System.out.print("Enter second number: ");
                try {
                    num2 = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    if (num2 >= 0 && num2 <= 1000000) {
                        valid2 = true;
                    } else {
                        System.out.println("Invalid input! Number must be between 0 and 1000000.");
                    }
                } catch (Exception e) {
                    scanner.nextLine(); // consume invalid input
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }

            // PERFORM OPERATION - MESSY IF/ELSE CHAIN
            double result = 0;
            if (operation.equals("+")) {
                result = num1 + num2;
            } else if (operation.equals("-")) {
                result = num1 - num2;
            } else if (operation.equals("*")) {
                result = num1 * num2;
            } else if (operation.equals("/")) {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero!");
                    continue;
                }
                result = num1 / num2;
            }

            // DISPLAY RESULT
            System.out.println("\nResult: " + num1 + " " + operation + " " + num2 + " = " + result);
        }

        System.out.println("\nThanks for using Calculator!");
    }
}
