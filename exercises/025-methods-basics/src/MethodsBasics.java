
public class MethodsBasics {

    /**
     * Part 1: Simple methods with no parameters or return values
     */
    public static void printWelcome() {
        // TODO: Print a welcome message like "Welcome to Methods Learning!"
    }

    public static void printBoundary() {
        // TODO: Print a line of equals signs (==================================)
    }

    /**
     * Part 2: Methods with parameters (but no return values)
     */
    public static void greet(String name) {
        // TODO: Print "Hello, [name]!"
    }

    public static void printMultipleTimes(String message, int times) {
        // TODO: Use a loop to print the message 'times' times
        // Hint: for (int i = 0; i < times; i++)
    }

    public static void calculateArea(double length, double width) {
        // TODO: Calculate area (length * width) and print result
        // Format: "The area of [length] x [width] is: [area] square units."
    }

    /**
     * Part 3: Methods with return values
     */
    public static int add(int a, int b) {
        // TODO: Return a + b
        return 0;  // Placeholder
    }

    public static int subtract(int a, int b) {
        // TODO: Return a - b
        return 0;  // Placeholder
    }

    public static int multiply(int a, int b) {
        // TODO: Return a * b
        return 0;  // Placeholder
    }

    public static int divide(int a, int b) {
        // TODO: Return a / b
        // Note: For now, assume b is never 0. In real code, check for this!
        return 0;  // Placeholder
    }

    public static String getFullName(String firstName, String lastName) {
        // TODO: Return firstName + " " + lastName
        return "";  // Placeholder
    }

    /**
     * Main method - demonstrates all method types
     */
    public static void main(String[] args) {
        // TODO: Implement this to call and demonstrate all methods above

        // Suggested structure:
        // 1. Print welcome message and boundary
        // 2. Greet a few people
        // 3. Print a message multiple times
        // 4. Calculate area of a rectangle
        // 5. Demonstrate arithmetic methods (add, subtract, multiply, divide)
        //    Example: System.out.println(5 + " + " + 3 + " = " + add(5, 3));
        // 6. Get and print a full name
        printBoundary();
        printWelcome();
        printBoundary();
        System.out.println();

        // TODO: Add the rest of your main() implementation here
    }
}
