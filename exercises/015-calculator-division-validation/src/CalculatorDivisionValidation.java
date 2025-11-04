
/**
 * Exercise 015: Calculator - Division Validation
 *
 * Your task: Create a safe division method that validates inputs and prevents errors.
 *
 * Concepts you'll practice:
 * - Input validation
 * - Error checking
 * - Defensive programming
 * - Handling edge cases
 * - Boolean logic
 */
public class CalculatorDivisionValidation {

    // TODO: Implement the isValidDivisor method
    // Method signature: public static boolean isValidDivisor(double divisor)
    // This method should return true if divisor is not zero, false otherwise
    // TODO: Implement the safeDivide method
    // Method signature: public static double safeDivide(double dividend, double divisor)
    // This method should return dividend / divisor if divisor is not zero
    // If divisor is zero, return Double.NaN
    // TODO: Implement the divideSafe method
    // Method signature: public static void divideSafe(double dividend, double divisor)
    // This method should print "dividend / divisor = result" if divisor is valid
    // If divisor is zero, print "Error: Cannot divide by zero!"
    // TODO: Implement the validateAndCalculate method
    // Method signature: public static String validateAndCalculate(int a, int b)
    // This method should return a string:
    // - "a / b = result" if b is not zero
    // - "Error: Cannot divide by zero!" if b is zero
    public static void main(String[] args) {
        // TODO: Demonstrate safe division with various inputs
        // Include:
        // - Normal division (10 / 2)
        // - Division by zero (10 / 0)
        // - Division with zero dividend (0 / 5)
        // - Negative numbers

        // Example:
        // divideSafe(10, 2);      // Prints: 10.0 / 2.0 = 5.0
        // divideSafe(10, 0);      // Prints: Error: Cannot divide by zero!
        // System.out.println(validateAndCalculate(15, 3));  // Prints: 15 / 3 = 5.0
    }
}
