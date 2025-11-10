import java.io.*;
import java.util.ArrayList;

/**
 * Person class to hold structured data
 */
class Person {
    // TODO: Add fields for name (String), age (int), and email (String)
    String name;
    int age;
    String email;

    // TODO: Create constructor that takes name, age, and email parameters
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // TODO: Implement toCSV() method that returns this person as a CSV line
    // Format: "name,age,email"
    // Example: "John Doe,30,john@email.com"
    public String toCSV() {
        // TODO: Return CSV format: name + "," + age + "," + email
        return "";
    }
}

/**
 * Data Persistence with CSV
 *
 * Your task: Save and load Person objects using CSV format.
 *
 * Concepts you'll practice:
 * - CSV format and data serialization
 * - String.split() for parsing
 * - Converting strings to objects
 * - ArrayList for collections
 * - Error handling for parsing errors
 * - Structured I/O operations
 */
public class DataPersistence {

    // TODO: Implement the saveToCSV method
    // Method signature: public static void saveToCSV(ArrayList<Person> people, String filename)
    // This method should:
    // 1. Use try-with-resources with FileWriter
    // 2. Loop through each Person in the ArrayList
    // 3. Write each person's CSV line to the file (use toCSV() method)
    // 4. Add a newline after each person
    // 5. Catch and handle IOException

    public static void saveToCSV(ArrayList<Person> people, String filename) {
        // TODO: Create FileWriter and write each person's CSV line
        try (FileWriter writer = new FileWriter(filename)) {
            // TODO: Loop through people and write each one
            for (Person person : people) {
                // TODO: Write person's CSV line + newline ("\n")
            }
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }

    // TODO: Implement the parseCSVLine method
    // Method signature: public static Person parseCSVLine(String line)
    // This method should:
    // 1. Split the line by comma using split(",")
    // 2. Check if you have exactly 3 parts (name, age, email)
    // 3. Try to parse the age as an integer
    // 4. Create and return a new Person object
    // 5. Return null if anything goes wrong (wrong format, bad number, etc.)
    // Use try-catch for NumberFormatException

    public static Person parseCSVLine(String line) {
        try {
            // TODO: Split the line by comma
            String[] parts = line.split(",");

            // TODO: Check if we have exactly 3 parts
            if (parts.length != 3) {
                return null;
            }

            // TODO: Extract fields from parts array (parts[0], parts[1], parts[2])
            String name = "";  // TODO
            int age = 0;  // TODO: Use Integer.parseInt(parts[?])
            String email = "";  // TODO

            // TODO: Create and return Person object with extracted fields
            return null;

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in line: " + line);
            return null;
        }
    }

    // TODO: Implement the loadFromCSV method
    // Method signature: public static ArrayList<Person> loadFromCSV(String filename)
    // This method should:
    // 1. Create an empty ArrayList<Person>
    // 2. Use try-with-resources with BufferedReader
    // 3. Read each line from the file
    // 4. Parse each line using parseCSVLine()
    // 5. Add valid Person objects to the list (skip null results)
    // 6. Return the ArrayList
    // 7. Catch IOException and return empty list if file doesn't exist

    public static ArrayList<Person> loadFromCSV(String filename) {
        ArrayList<Person> people = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // TODO: Read lines in a loop (readLine() returns null when done)
            while ((line = reader.readLine()) != null) {
                // TODO: Parse the line using parseCSVLine()
                Person person = parseCSVLine(line);

                // TODO: Add to list if valid (check if person is not null)
                if (person != null) {
                    // TODO: Add person to people ArrayList
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading from CSV: " + e.getMessage());
        }

        return people;
    }

    public static void main(String[] args) {
        // TODO: Demonstrate CSV data persistence
        // Example workflow:
        // 1. Create ArrayList of Person objects
        // 2. Save to CSV file
        // 3. Load from CSV file
        // 4. Display loaded data

        System.out.println("CSV Data Persistence Demo");
        System.out.println("=========================");

        // Example:
        // ArrayList<Person> people = new ArrayList<>();
        // people.add(new Person("Alice", 28, "alice@email.com"));
        // people.add(new Person("Bob", 35, "bob@email.com"));
        //
        // saveToCSV(people, "people.csv");
        //
        // ArrayList<Person> loaded = loadFromCSV("people.csv");
        // for (Person p : loaded) {
        //     System.out.println(p.name + " - " + p.age + " - " + p.email);
        // }
    }
}
