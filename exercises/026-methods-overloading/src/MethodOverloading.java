
public class MethodOverloading {

    // TODO: Create two overloaded "add" methods - one for integers, one for doubles
    // Both should return the sum
    
    
    // TODO: Create two overloaded "greet" methods - one with just name, one with name and age
    // Both should return a greeting string 
    // (e.g., "Hello, Alice!" or "Hello, Bob! You are 30 years old.")

    
    public static void main(String[] args) {
        // Test your overloaded methods here
        // Example: System.out.println(add(5, 3));
        //          System.out.println(add(5.5, 3.2));
        System.out.println(add(5, 3));
        System.out.println(add(5.5, 3.2));
        System.out.println(greet("Alice"));
        System.out.println(greet("Bob", 30));
    }
}
