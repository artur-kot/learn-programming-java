import java.util.Scanner;

/**
 * Exercise 014: Calculator - Input Validation with Exception Handling
 *
 * Your task: Create a calculator that safely handles invalid user input using try...catch blocks.
 *
 * Concepts you'll practice:
 * - Try...catch blocks for exception handling
 * - NumberFormatException handling
 * - Input validation loops
 * - User-friendly error messages
 * - Safe user input processing
 */
public class CalculatorInputValidation {
    // TODO: Implement the readInteger method
    // Method signature: public static int readInteger(Scanner scanner, String prompt)
    // This method should:
    // 1. Display the prompt
    // 2. Use a while(true) loop to keep asking
    // 3. Try to parse the user input as an integer
    // 4. Catch NumberFormatException and display error message
    // 5. Break from loop on successful parse and return the integer (use "break;" to break loop)

    public static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = /* TODO */;
            try {
                // Parse and return the integer
                return Integer./* TODO */(input);
            } catch (/* TODO */ e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    // TODO: Implement the readDouble method
    // Method signature: public static double readDouble(Scanner scanner, String prompt)
    // Similar to readInteger but parses as a double


    
    public static double add(double a, double b) {
        return a + b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }
    
    // TODO: Implement the calculateWithValidation method
    // Method signature: public static void calculateWithValidation()
    // This method should:
    // 1. Create a Scanner
    // 2. Use readInteger or readDouble to safely get first number
    // 3. Use readInteger or readDouble to safely get second number
    // 4. Perform a calculation (add or divide)
    // 5. Display the result

    public static void calculateWithValidation() {
        try (Scanner scanner = new Scanner(System.in)) {
            double num1 = readDouble(/* TODO */);
            double num2 = readDouble(/* TODO */);
            
            double sum = add(num1, num2);
            System.out.println("Sum: " + sum);
            
            double quotient = divide(num1, num2);
            if (!Double.isNaN(quotient)) {
                System.out.println("Quotient: " + quotient);
            }
        }
    }
    

    public static void main(String[] args) {
        // TODO: Demonstrate safe input handling
        // Call calculateWithValidation() to show the exception handling in action
        // The user will see prompts that keep asking if they enter invalid data
    }
}
