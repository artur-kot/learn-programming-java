import java.util.Scanner;

/**
 * Exercise 004: Hello Formatter - Clean Output
 * 
 * Your task: Format a greeting message using printf
 * 
 * Concepts you'll practice:
 * - System.out.printf() for formatted strings
 * - Format specifiers (%s, %d, %n)
 * - Escape sequences
 */
public class HelloFormatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Greeting Formatter!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // TODO: Use printf to print a nicely formatted greeting
        // The greeting should:
        // - Include the name using %s
        // - Include the age using %d
        // - Have multiple lines with proper spacing
        // - End with a newline %n
        
        scanner.close();
    }
}
