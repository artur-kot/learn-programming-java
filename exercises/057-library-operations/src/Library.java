import java.util.ArrayList;
import java.time.LocalDate;

public class Library {
    // TODO: Copy your Library class from Exercise 056

    // TODO: Add borrowBook method
    // boolean borrowBook(Member member, Book book)
    // Validate:
    //   - Book exists in library (use books.contains(book))
    //   - Book is not already borrowed
    // If valid:
    //   - Set book as borrowed: book.setBorrowed(true)
    //   - Set borrow date: book.setBorrowDate(LocalDate.now())
    //   - Add to member's list: member.addBorrowedBook(book)
    //   - Return true
    // If invalid:
    //   - Print appropriate error message
    //   - Return false

    // TODO: Add returnBook method
    // boolean returnBook(Member member, Book book)
    // Validate:
    //   - Member has this book in their borrowed list
    // If valid:
    //   - Set book as not borrowed: book.setBorrowed(false)
    //   - Clear borrow date: book.setBorrowDate(null)
    //   - Remove from member's list: member.removeBorrowedBook(book)
    //   - Return true
    // If invalid:
    //   - Print error message
    //   - Return false

    // TODO: Add searchByTitle method
    // ArrayList<Book> searchByTitle(String title)
    // Find all books where title contains the search term (case-insensitive)
    // Use toLowerCase() for both title and search term
    // Return ArrayList of matching books (empty if none found)

    // TODO: Add searchByAuthor method
    // ArrayList<Book> searchByAuthor(String author)
    // Find all books where author name contains search term (case-insensitive)
    // Return ArrayList of matching books

    // TODO: Add searchByIsbn method
    // Book searchByIsbn(String isbn)
    // Find exact book with this ISBN
    // Return book or null if not found

    // TODO: Add getOverdueBooks method
    // ArrayList<Book> getOverdueBooks(int maxDays)
    // Find all books where isOverdue(maxDays) returns true
    // Return ArrayList of overdue books
}
