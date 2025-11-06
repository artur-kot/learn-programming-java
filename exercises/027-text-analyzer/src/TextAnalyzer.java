
import java.io.File;
import java.util.Scanner;

/**
 * REFACTORING EXERCISE: Text Analyzer Tool
 *
 * This text analyzer works, but the code is poorly organized! All logic is
 * crammed into the main() method.
 *
 * YOUR TASK: Refactor this code by extracting methods for: 1. File I/O
 * operations (reading files) 2. Text analysis methods (counting words, lines,
 * sentences, characters) 3. Input validation (file path validation) 4. Display
 * and formatting 5. Main analysis coordination logic
 *
 * The functionality should NOT change - just reorganize the code! This is
 * called REFACTORING - improving code without changing behavior.
 */
public class TextAnalyzer {

    // TODO: Add file validation methods here (isValidFile)
    // TODO: Add input methods here (getFilePath, readFile)
    // TODO: Add analysis methods here (countWords, countLines, countSentences, countCharacters)
    // TODO: Add display methods here (displayResults, analyzeFile)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      Welcome to Text Analyzer!");
        System.out.println("========================================\n");

        // MONOLITHIC CODE - NEEDS REFACTORING!
        // All logic is here in main() - this is BAD DESIGN!
        // You should extract this into multiple methods.
        boolean running = true;

        while (running) {
            // GET FILE PATH - WITH VALIDATION (REPEATED CODE!)
            String filePath = "";
            boolean validPath = false;

            while (!validPath) {
                System.out.print("\nEnter file path (or 'exit' to quit): ");
                filePath = scanner.nextLine().trim();

                if (filePath.equalsIgnoreCase("exit")) {
                    running = false;
                    validPath = true;
                    break;
                }

                File file = new File(filePath);
                if (file.exists() && file.isFile()) {
                    validPath = true;
                } else {
                    System.out.println("Invalid file! File does not exist or is not a regular file.");
                }
            }

            if (!running) {
                break;
            }

            // READ FILE
            String content = "";
            try {
                // During debugging, you can use "sample.txt" as a test file
                File file = new File(filePath);
                StringBuilder sb;
                try (Scanner fileScanner = new Scanner(file)) {
                    sb = new StringBuilder();
                    while (fileScanner.hasNextLine()) {
                        sb.append(fileScanner.nextLine()).append("\n");
                    }
                }
                content = sb.toString();

                if (content.isEmpty()) {
                    System.out.println("File is empty!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error reading file: " + e.getMessage());
                continue;
            }

            // ANALYZE TEXT - MESSY LOGIC (REPEATED PATTERNS!)
            // Count lines
            int lineCount = 0;
            String[] lines = content.split("\n");
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    lineCount++;
                }
            }

            // Count characters
            int charCount = 0;
            for (char c : content.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                    charCount++;
                }
            }

            // Count words
            int wordCount = 0;
            String[] words = content.trim().split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount++;
                }
            }

            // Count sentences (split by . ! ?)
            int sentenceCount = 0;
            String[] sentences = content.split("[.!?]+");
            for (String sentence : sentences) {
                if (!sentence.trim().isEmpty()) {
                    sentenceCount++;
                }
            }

            // DISPLAY RESULTS
            System.out.println("\n========================================");
            System.out.println("         Analysis Results");
            System.out.println("========================================");
            System.out.println("File: " + filePath);
            System.out.println("----------------------------------------");
            System.out.println("Lines:      " + lineCount);
            System.out.println("Words:      " + wordCount);
            System.out.println("Sentences:  " + sentenceCount);
            System.out.println("Characters: " + charCount);
            System.out.println("========================================");

            // Calculate some statistics
            if (wordCount > 0) {
                double avgCharsPerWord = (double) charCount / wordCount;
                System.out.printf("Avg chars/word: %.2f\n", avgCharsPerWord);
            }

            if (sentenceCount > 0) {
                double avgWordsPerSentence = (double) wordCount / sentenceCount;
                System.out.printf("Avg words/sentence: %.2f\n", avgWordsPerSentence);
            }
        }

        System.out.println("\nThanks for using Text Analyzer!");
    }
}
