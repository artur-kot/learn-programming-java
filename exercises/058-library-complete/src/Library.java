import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class Library {
    // TODO: Copy your Library class from Exercise 057

    // TODO: Modify borrowBook to call book.incrementBorrowCount() when borrowing

    // TODO: Add saveToFile method
    // void saveToFile(String filename)
    // Write all books and members to file in CSV format
    // Format:
    //   BOOKS
    //   isbn,title,author,isBorrowed,borrowDate,borrowCount
    //   MEMBERS
    //   memberId,name,borrowedBookIsbns (comma-separated if multiple)
    // Use try-catch to handle IOException

    // TODO: Add loadFromFile method
    // void loadFromFile(String filename)
    // Read file and recreate all books and members
    // Parse each line with split(",")
    // Reconstruct borrowed book relationships
    // Use try-catch to handle FileNotFoundException and IOException

    // TODO: Add getMostPopularBooks method
    // ArrayList<Book> getMostPopularBooks(int limit)
    // Sort books by borrowCount (highest first)
    // Return top 'limit' books
    // Use ArrayList.sort() with lambda: (b1, b2) -> b2.getBorrowCount() - b1.getBorrowCount()

    // TODO: Add displayMemberActivity method
    // void displayMemberActivity(Member member)
    // Print:
    //   - Member name and ID
    //   - Number of currently borrowed books
    //   - List of currently borrowed books (titles)

    // TODO: Add displayLibraryStatus method
    // void displayLibraryStatus()
    // Print:
    //   - Total books in library
    //   - Books currently borrowed (count books where isBorrowed() is true)
    //   - Books available (total - borrowed)
    //   - Total members
    //   - Active members (members with borrowedCount > 0)
}
