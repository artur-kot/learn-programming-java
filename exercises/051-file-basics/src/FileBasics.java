import java.io.*;

/**
 * File Operations Basics
 *
 * Your task: Create methods to write, read, append, and check files using try-with-resources.
 *
 * Concepts you'll practice:
 * - FileWriter for writing text to files
 * - BufferedReader and FileReader for reading files
 * - Try-with-resources for automatic resource management
 * - File modes (overwrite vs append)
 * - IOException handling
 * - File existence checking
 */
public class FileBasics {

    // TODO: Implement the writeToFile method
    // Method signature: public static void writeToFile(String filename, String content)
    // This method should:
    // 1. Use try-with-resources with FileWriter
    // 2. Write the content to the file (overwrite mode)
    // 3. Catch and handle IOException

    public static void writeToFile(String filename, String content) {
        // TODO: Use filename parameter in FileWriter constructor
        try (FileWriter writer = new FileWriter(filename)) {
            // TODO: Write content to file using writer.write()
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // TODO: Implement the readFromFile method
    // Method signature: public static String readFromFile(String filename)
    // This method should:
    // 1. Use try-with-resources with BufferedReader and FileReader
    // 2. Read all lines from the file
    // 3. Return the content as a single String (preserve line breaks with \n)
    // 4. Return empty string if file doesn't exist
    // 5. Catch and handle IOException

    public static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();

        // TODO: Use filename parameter in FileReader constructor
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // TODO: Read lines in a loop using reader.readLine()
            // Use while loop: while ((line = reader.readLine()) != null)
            // Add each line to content using content.append(line)
            // Add newline character between lines: content.append("\n")
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }

        return content.toString();
    }

    // TODO: Implement the appendToFile method
    // Method signature: public static void appendToFile(String filename, String content)
    // This method should:
    // 1. Use try-with-resources with FileWriter in APPEND mode
    // 2. Add content to the end of the file
    // 3. Catch and handle IOException
    // Hint: Use new FileWriter(filename, true) for append mode

    public static void appendToFile(String filename, String content) {
        // TODO: Use FileWriter with append mode (second parameter = true)
        // Example: new FileWriter(filename, true)
        try (FileWriter writer = new FileWriter(filename)) {
            // TODO: Write content to file using writer.write()
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    // TODO: Implement the fileExists method
    // Method signature: public static boolean fileExists(String filename)
    // This method should:
    // 1. Create a File object with the filename
    // 2. Return whether the file exists
    // Hint: Use the File class and its exists() method

    public static boolean fileExists(String filename) {
        // TODO: Create File object and return result of exists() method
        File file = new File(filename);
        return false; // TODO: Replace with file.exists()
    }

    public static void main(String[] args) {
        // TODO: Demonstrate file operations
        // Example workflow:
        // 1. Write some content to a file
        // 2. Read it back and print it
        // 3. Append more content
        // 4. Read again and print
        // 5. Check if the file exists

        System.out.println("File Operations Demo");
        System.out.println("====================");

        // Example:
        // writeToFile("demo.txt", "First line of text");
        // String content = readFromFile("demo.txt");
        // System.out.println("Content: " + content);
    }
}
