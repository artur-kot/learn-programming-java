
import java.util.Scanner;

/**
 * BMI Calculator - Basics
 *
 * Calculate Body Mass Index from user input.
 *
 * Concepts you'll practice: - Input parsing and validation - Mathematical
 * formulas - Exception handling (try...catch) - Method design - Output
 * formatting
 * 
 * BMI = weight / (height * height)
 */
public class BMICalculator {

    public static double calculateBMI(double weight, double height) {
        // TODO: Calculate BMI = weight / (height * height)
        // Throw IllegalArgumentException if weight <= 0 or height <= 0

        
        return 0; // TODO, round to 2 decimal places, e.g., 22.86 (hint: multiply by 100, round, then divide by 100)
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to BMI Calculator!");
            // TODO: Get weight input
            // - Prompt: "Enter your weight (kg): "
            // - Use try...catch for NumberFormatException
            // - Store in a double variable

            // TODO: Get height input
            // - Prompt: "Enter your height (m): "
            // - Use try...catch for NumberFormatException
            // - Store in a double variable

            // TODO: Calculate and display BMI
            // - Call calculateBMI()
            // - Display result formatted to 1 decimal place
            // - Example: "Your BMI is: 22.90"
        }
    }
}