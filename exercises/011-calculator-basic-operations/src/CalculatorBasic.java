
/**
 * Exercise 011: Calculator - Basic Operations
 *
 * Your task: Implement four methods for basic arithmetic operations.
 *
 * Concepts you'll practice:
 * - Arithmetic operators (+, -, *, /)
 * - Data types (int and double)
 * - Method implementation
 * - Method parameters and return values
 */
public class CalculatorBasic {

    // TODO: Implement the add method (Done for you)
    // Method signature: public static int add(int a, int b)
    // This method should return the sum of a and b
    public static int add(int a, int b) {
        return a + b;
    }

    // TODO: Implement the subtract method
    // Method signature: public static int subtract(int a, int b)
    // This method should return a minus b


    // TODO: Implement the multiply method
    // Method signature: public static int multiply(int a, int b)
    // This method should return the product of a and b


    // TODO: Implement the divide method
    // Method signature: public static double divide(double a, double b)
    // This method should return a divided by b
    public static double divide(double a, double b) {
        if (b == 0) {
            // Handle division by zero
            return Double.NaN;
        }
        /* TODO: Return the division result */
    }

    public static void main(String[] args) {
        // TODO: Call each method with example values and print the results
        // Example:
        // System.out.println("10 + 5 = " + add(10, 5));
        // System.out.println("20 - 8 = " + subtract(20, 8));
        // System.out.println("7 * 6 = " + multiply(7, 6));
        // System.out.println("15.0 / 3.0 = " + divide(15.0, 3.0));
    }
}
