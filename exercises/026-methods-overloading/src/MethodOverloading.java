
public class MethodOverloading {

    /**
     * Part 1: Calculations with different types
     */
    public static int calculate(int a, int b) {
        // TODO: Return a + b
        return 0;
    }

    public static double calculate(double a, double b) {
        // TODO: Return a + b
        return 0.0;
    }

    public static double calculate(int a, double b) {
        // TODO: Return a + b as double
        return 0.0;
    }

    public static String calculate(String a, String b) {
        // TODO: Return a + b (concatenation)
        return "";
    }

    /**
     * Part 2: Information display with different parameter counts
     */
    public static void displayInfo(String name) {
        // TODO: Print "Name: [name]"
    }

    public static void displayInfo(String name, int age) {
        // TODO: Print "Name: [name], Age: [age]"
    }

    public static void displayInfo(String name, int age, String city) {
        // TODO: Print "Name: [name], Age: [age], City: [city]"
    }

    /**
     * Part 3: Flexible sum operations
     */
    public static int sum(int a, int b) {
        // TODO: Return a + b
        return 0;
    }

    public static int sum(int a, int b, int c) {
        // TODO: Return a + b + c
        return 0;
    }

    public static double sum(double a, double b) {
        // TODO: Return a + b
        return 0.0;
    }

    public static double sum(double a, double b, double c) {
        // TODO: Return a + b + c
        return 0.0;
    }

    /**
     * Part 4: Advanced formatting with overloading
     */
    public static String format(int value) {
        // TODO: Return "Value: [value]"
        return "";
    }

    public static String format(double value) {
        // TODO: Return "Value: [value]" formatted as double
        return "";
    }

    public static String format(int value, int width) {
        // TODO: Return value right-aligned to width
        // Example: format(42, 6) = "    42"
        // Hint: Use String.format("%"+width+"d", value)
        return "";
    }

    public static String format(double value, int decimalPlaces) {
        // TODO: Return double formatted to N decimal places
        // Example: format(3.14159, 2) = "3.14"
        // Hint: Use String.format("%."+decimalPlaces+"f", value)
        return "";
    }

    public static String format(String label, Object value) {
        // TODO: Return "[label]: [value]"
        // Object is the parent type of all Java objects
        return "";
    }

    /**
     * Main - demonstrate all overloading scenarios
     */
    public static void main(String[] args) {
        // TODO: Call all overloaded methods to demonstrate polymorphism

        System.out.println("=== Part 1: Calculations ===");
        System.out.println("calculate(5, 3) = " + calculate(5, 3));
        System.out.println("calculate(5.5, 3.2) = " + calculate(5.5, 3.2));
        System.out.println("calculate(5, 3.2) = " + calculate(5, 3.2));
        System.out.println("calculate(\"Hello\", \"World\") = " + calculate("Hello", "World"));

        System.out.println("\n=== Part 2: Information Display ===");
        displayInfo("Alice");
        displayInfo("Bob", 30);
        displayInfo("Charlie", 25, "Boston");

        System.out.println("\n=== Part 3: Flexible Sum ===");
        System.out.println("sum(5, 3) = " + sum(5, 3));
        System.out.println("sum(5, 3, 2) = " + sum(5, 3, 2));
        System.out.println("sum(5.5, 3.2) = " + sum(5.5, 3.2));
        System.out.println("sum(5.5, 3.2, 1.8) = " + sum(5.5, 3.2, 1.8));

        System.out.println("\n=== Part 4: Advanced Formatting ===");
        System.out.println(format(42));
        System.out.println(format(3.14));
        System.out.println(format(42, 6));
        System.out.println(format(3.14159, 2));
        System.out.println(format("Temperature", 72));
    }
}
