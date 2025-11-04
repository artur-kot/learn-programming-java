/**
 * Exercise 005: Hello Debugger - Fix the Errors
 * 
 * Your task: Find and fix the syntax errors in this code
 * 
 * Concepts you'll practice:
 * - Reading compiler error messages
 * - Identifying syntax errors
 * - Debugging and problem-solving
 * 
 * HINT: There are 5 syntax errors. Can you find them all?
 */
public class HelloDebugger {
    
    public static void main(String[] args) {
        // Error 1: Missing opening quote
        String message = "Hello, Debug World!;
        
        // Error 2: Missing semicolon
        String name = "Debugger"
        
        // Error 3: Incorrect method name (should be println)
        System.out.printlin(message);
        
        // Error 4: Missing closing parenthesis
        System.out.println("Welcome to debugging, " + name;
        
        // Error 5: Wrong quote type (curly quotes instead of straight quotes)
        System.out.println("Let's find all the errors!");
    }
}
