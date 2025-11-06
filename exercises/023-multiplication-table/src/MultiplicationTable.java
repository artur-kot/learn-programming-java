
public class MultiplicationTable {

    /**
     * Prints the multiplication table for a single number (1-10 multipliers)
     *
     * @param number The number to create a multiplication table for
     */
    public static void printSingleTable(int number) {
        // TODO: Implement this method
        // Print the multiplication table for the given number
        // Format: "number × i = result" for i from 1 to 10
    }

    /**
     * Prints the complete 10x10 multiplication table grid
     */
    public static void printFullGrid() {
        // TODO: Implement this method
        // Use nested loops to create a 10x10 multiplication table
        // Format with proper alignment (use tabs or printf)
    }

    public static void main(String[] args) {
        // Part 1: Get user input and display single multiplication table
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number to display its multiplication table: ");
        int number = scanner.nextInt();
        printSingleTable(number);

        // Part 2: Display the full 10x10 multiplication grid
        System.out.println("\n=== Part 2: Full 10x10 Multiplication Grid ===");
        printFullGrid();
    }
}
