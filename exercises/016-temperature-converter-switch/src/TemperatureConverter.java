
import java.util.Scanner;

/**
 * Exercise 016: Temperature Converter - Switch Statements
 *
 * Your task: Create a comprehensive temperature converter with a menu-driven
 * interface that uses switch statements to route between different conversion
 * options.
 *
 * Concepts you'll practice: - Switch statements for decision making - Multiple
 * cases and default case - Temperature conversion formulas - Menu-driven
 * program design - Input validation and error handling - Looping for repeated
 * operations
 */
public class TemperatureConverter {

    // Conversion methods - TODO: Implement each with the formula in the comment
    public static double celsiusToFahrenheit(double celsius) {
        // F = (C * 9/5) + 32
        return 0; // TODO
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        // C = (F - 32) * 5/9
        return 0; // TODO
    }

    public static double celsiusToKelvin(double celsius) {
        // K = C + 273.15
        return 0; // TODO
    }

    public static double kelvinToCelsius(double kelvin) {
        // C = K - 273.15
        return 0; // TODO
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        // K = (F - 32) * 5/9 + 273.15
        return 0; // TODO
    }

    public static double kelvinToFahrenheit(double kelvin) {
        // F = (K - 273.15) * 9/5 + 32
        return 0; // TODO
    }

    // Menu and routing methods
    public static void displayMenu() {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public static boolean isValidChoice(int choice) {
        // TODO: Return true if choice is 0-6, false otherwise
        return false;
    }

    public static double performConversion(int choice, double temp) {
        // TODO: Use a SWITCH STATEMENT to route to the appropriate conversion
        // Return Double.NaN for invalid choices
        return Double.NaN;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Temperature Converter!");

        // TODO: Implement menu loop
        // - Display menu
        // - Read user's choice (with try...catch for NumberFormatException)
        // - Validate choice
        // - If 0, break and exit
        // - If invalid, show error and continue
        // - Read temperature
        // - Call performConversion() and display result (2 decimal places)
        System.out.println("Thank you for using Temperature Converter!");
        scanner.close();
    }
}
