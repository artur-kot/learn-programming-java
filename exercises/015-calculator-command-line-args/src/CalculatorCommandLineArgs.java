/**
 * Calculator - Command-Line Arguments
 *
 * Your task: Create a calculator that reads two numbers and an operation from command-line arguments.
 *
 * Concepts you'll practice:
 * - Command-line arguments (args[])
 * - String parsing (Integer.parseInt, Double.parseDouble)
 * - Argument validation
 * - Error handling
 * - Conditional logic (if/switch)
 */

// Example usage: java CalculatorCommandLineArgs 10 5 add
// This would output: "10 + 5 = 15"

public class CalculatorCommandLineArgs {

    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        // TODO: Validate that exactly 3 arguments are provided
        // If not, print an error message like:
        // "Error: Expected 3 arguments, got X"
        // where X is the number of arguments actually provided
        
        // TODO: Extract the three arguments
        // Hint: String operation = args[2];
        
        // TODO: Try to parse the first two arguments as numbers
        // Use Integer.parseInt() or Double.parseDouble()
        // If parsing fails, catch the exception and print:
        // "Error: Invalid number: [argument]"
        
        // TODO: Based on the operation string, call the appropriate method
        // Use if/else or switch statement
        // Supported operations: "add", "subtract", "multiply", "divide"
        
        // TODO: Display the result in format: "a op b = result"
        // Example: "10 + 5 = 15"
        
        // TODO: Handle invalid operations by printing:
        // "Error: Unknown operation: [operation]"

        if (args.length != 3) {
            System.out.println("Error: Expected 3 arguments, got " + args.length);
            return;
        }
        
        try {
            // TODO: Parse the first two arguments as doubles
            // Hint: args[0] is the first argument, args[1] is the second argument

            // Get operation from third argument
            String operation = args[2];
            
            double result;
            String symbol;
            
            switch (operation) {
                case "add":
                    result = add(a, b);
                    symbol = "+";
                    break;
                case "subtract":
                    // ** Write your code here **
                case "multiply":
                    // ** Write your code here **
                case "divide":
                    // ** Write your code here **
                default:
                    System.out.println("Error: Unknown operation: " + operation);
                    return;
            }
            
            System.out.println(a + " " + symbol + " " + b + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number: " + e.getMessage());
        }
    }
}
