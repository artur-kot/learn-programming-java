import java.util.Scanner;
import java.util.ArrayList;

public class LibraryApp {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO: Implement main menu loop
        // Keep showing menu until user chooses Exit
        // Use switch statement to handle each menu option

        // Menu structure:
        // 1. Add Book
        // 2. Add Member
        // 3. Borrow Book
        // 4. Return Book
        // 5. Search Books
        // 6. View Reports
        // 7. Save Data
        // 8. Load Data
        // 9. Exit
    }

    private static void displayMainMenu() {
        // TODO: Print main menu options
        System.out.println("\n=== Library Management System ===");
        // ... print all options
    }

    private static void addBook() {
        // TODO: Prompt for book details (title, author, ISBN)
        // Create new Book object
        // Add to library
        // Print success message
    }

    private static void addMember() {
        // TODO: Prompt for member details (name, member ID)
        // Create new Member object
        // Add to library
        // Print success message
    }

    private static void borrowBook() {
        // TODO: Prompt for member ID and book ISBN
        // Find member and book using library methods
        // If found, call library.borrowBook()
        // Print result message
    }

    private static void returnBook() {
        // TODO: Prompt for member ID and book ISBN
        // Find member and book
        // If found, call library.returnBook()
        // Print result message
    }

    private static void searchBooks() {
        // TODO: Show search submenu
        // 1. Search by Title
        // 2. Search by Author
        // 3. Search by ISBN
        // 4. Back
        // Call appropriate library search method
        // Display results
    }

    private static void viewReports() {
        // TODO: Show reports submenu
        // 1. Library Status
        // 2. Popular Books
        // 3. Member Activity
        // 4. Back
        // Call appropriate library report method
    }

    private static void saveData() {
        // TODO: Prompt for filename
        // Call library.saveToFile(filename)
    }

    private static void loadData() {
        // TODO: Prompt for filename
        // Call library.loadFromFile(filename)
    }
}
