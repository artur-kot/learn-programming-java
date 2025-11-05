
import java.util.Scanner;

/**
 * BMI Calculator - Advanced
 *
 * Build on previous exercise to add BMI category interpretation and support
 * multiple calculations in one session.
 *
 * Concepts you'll practice: - Reusing code from previous exercises - Multiple
 * conditional branches (if/else/else if) - String comparison and manipulation -
 * Loop-based menu design - Method composition
 */
public class BMICalculatorAdvanced {
    // Reuse calculateBMI from Exercise 017 - no placeholder needed
    // You can copy the implementation from BMICalculator.java

    public static double calculateBMI(double weight, double height) {
        // COPY THE IMPLEMENTATION FROM EXERCISE 017
        // This method should already work - just paste your code here
        // TODO: Implement BMI calculation: weight / (height * height)
        return 0.0; // TODO
    }

    public static String interpretBMI(double bmi) {
        // TODO: NEW - Implement BMI category interpretation
        // Return category based on value:
        // - BMI < 18.5: "Underweight"
        // - 18.5 <= BMI < 25: "Normal weight"
        // - 25 <= BMI < 30: "Overweight"
        // - BMI >= 30: "Obese"
        // Use if/else/else if structure
        return ""; // TODO
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Advanced BMI Calculator!");

            // TODO: NEW - Implement loop for multiple calculations
            // Structure:
            // 1. Create a boolean flag to control the loop (e.g., continueCalculation)
            // 2. Create a while loop that continues while flag is true
            // 3. Inside loop:
            //    - Get weight input (copy logic from "BMI Calculator Basics" exercise)
            //    - Get height input (copy logic from "BMI Calculator Basics" exercise)
            //    - Calculate BMI (call calculateBMI())
            //    - NEW: Get BMI interpretation (call interpretBMI())
            //    - Display BMI and category
            //    - NEW: Ask "Enter another calculation? (yes/no): "
            //    - NEW: Update flag based on user response (case-insensitive comparison)
            System.out.println("Thank you for using BMI Calculator!");
        }
    }
}
