import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class LibraryOperationsTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Member member1;
    private Member member2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1984", "George Orwell", "978-0451524935");
        book2 = new Book("Animal Farm", "George Orwell", "978-0451526342");
        book3 = new Book("Brave New World", "Aldous Huxley", "978-0060850524");
        member1 = new Member("Alice Johnson", "M001");
        member2 = new Member("Bob Smith", "M002");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addMember(member1);
        library.addMember(member2);
    }

    // Borrow/Return tests
    @Test
    public void testBorrowBookSuccess() {
        boolean result = library.borrowBook(member1, book1);
        assertTrue(result, "Borrowing available book should succeed");
        assertTrue(book1.isBorrowed(), "Book should be marked as borrowed");
        assertEquals(1, member1.getBorrowedCount(), "Member should have 1 borrowed book");
        assertNotNull(book1.getBorrowDate(), "Borrow date should be set");
    }

    @Test
    public void testBorrowBookAlreadyBorrowed() {
        library.borrowBook(member1, book1);
        boolean result = library.borrowBook(member2, book1);
        assertFalse(result, "Cannot borrow already borrowed book");
        assertEquals(0, member2.getBorrowedCount(), "Second member should have 0 books");
    }

    @Test
    public void testBorrowMultipleBooks() {
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        assertEquals(2, member1.getBorrowedCount());
        assertTrue(book1.isBorrowed());
        assertTrue(book2.isBorrowed());
    }

    @Test
    public void testReturnBookSuccess() {
        library.borrowBook(member1, book1);
        boolean result = library.returnBook(member1, book1);
        assertTrue(result, "Returning borrowed book should succeed");
        assertFalse(book1.isBorrowed(), "Book should not be marked as borrowed");
        assertEquals(0, member1.getBorrowedCount(), "Member should have 0 borrowed books");
        assertNull(book1.getBorrowDate(), "Borrow date should be cleared");
    }

    @Test
    public void testReturnBookNotBorrowed() {
        boolean result = library.returnBook(member1, book1);
        assertFalse(result, "Cannot return book not borrowed by this member");
    }

    @Test
    public void testReturnBookBorrowedByDifferentMember() {
        library.borrowBook(member1, book1);
        boolean result = library.returnBook(member2, book1);
        assertFalse(result, "Cannot return book borrowed by different member");
        assertTrue(book1.isBorrowed(), "Book should still be borrowed");
    }

    // Search tests
    @Test
    public void testSearchByTitleExactMatch() {
        ArrayList<Book> results = library.searchByTitle("1984");
        assertEquals(1, results.size());
        assertEquals("1984", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitlePartialMatch() {
        ArrayList<Book> results = library.searchByTitle("Farm");
        assertEquals(1, results.size());
        assertEquals("Animal Farm", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitleCaseInsensitive() {
        ArrayList<Book> results = library.searchByTitle("animal farm");
        assertEquals(1, results.size());
        assertEquals("Animal Farm", results.get(0).getTitle());
    }

    @Test
    public void testSearchByTitleNoMatch() {
        ArrayList<Book> results = library.searchByTitle("Harry Potter");
        assertEquals(0, results.size());
    }

    @Test
    public void testSearchByAuthorSingleMatch() {
        ArrayList<Book> results = library.searchByAuthor("Huxley");
        assertEquals(1, results.size());
        assertEquals("Brave New World", results.get(0).getTitle());
    }

    @Test
    public void testSearchByAuthorMultipleMatches() {
        ArrayList<Book> results = library.searchByAuthor("Orwell");
        assertEquals(2, results.size());
        // Check both books are present
        boolean has1984 = results.stream().anyMatch(b -> b.getTitle().equals("1984"));
        boolean hasAnimalFarm = results.stream().anyMatch(b -> b.getTitle().equals("Animal Farm"));
        assertTrue(has1984 && hasAnimalFarm);
    }

    @Test
    public void testSearchByAuthorCaseInsensitive() {
        ArrayList<Book> results = library.searchByAuthor("george orwell");
        assertEquals(2, results.size());
    }

    @Test
    public void testSearchByIsbnFound() {
        Book result = library.searchByIsbn("978-0451524935");
        assertNotNull(result);
        assertEquals("1984", result.getTitle());
    }

    @Test
    public void testSearchByIsbnNotFound() {
        Book result = library.searchByIsbn("999-9999999999");
        assertNull(result);
    }

    // Overdue tests
    @Test
    public void testIsOverdueNewBook() {
        library.borrowBook(member1, book1);
        assertFalse(book1.isOverdue(14), "Newly borrowed book should not be overdue");
    }

    @Test
    public void testIsOverdueOldDate() {
        book1.setBorrowed(true);
        book1.setBorrowDate(LocalDate.now().minusDays(20));
        assertTrue(book1.isOverdue(14), "Book borrowed 20 days ago should be overdue (limit 14)");
    }

    @Test
    public void testIsOverdueNotBorrowed() {
        assertFalse(book1.isOverdue(14), "Book not borrowed cannot be overdue");
    }

    @Test
    public void testGetOverdueBooks() {
        // Borrow book1 recently
        library.borrowBook(member1, book1);

        // Make book2 overdue by setting old date
        book2.setBorrowed(true);
        book2.setBorrowDate(LocalDate.now().minusDays(20));
        member1.addBorrowedBook(book2);

        ArrayList<Book> overdueBooks = library.getOverdueBooks(14);
        assertEquals(1, overdueBooks.size());
        assertEquals("Animal Farm", overdueBooks.get(0).getTitle());
    }

    @Test
    public void testGetOverdueBooksNone() {
        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);
        ArrayList<Book> overdueBooks = library.getOverdueBooks(30);
        assertEquals(0, overdueBooks.size());
    }

    // Integration tests
    @Test
    public void testCompleteWorkflow() {
        // Borrow multiple books
        assertTrue(library.borrowBook(member1, book1));
        assertTrue(library.borrowBook(member1, book2));
        assertTrue(library.borrowBook(member2, book3));

        // Search for books
        ArrayList<Book> orwellBooks = library.searchByAuthor("Orwell");
        assertEquals(2, orwellBooks.size());

        // Return one book
        assertTrue(library.returnBook(member1, book1));
        assertEquals(1, member1.getBorrowedCount());

        // Verify book can be borrowed again
        assertTrue(library.borrowBook(member2, book1));
        assertTrue(book1.isBorrowed());
    }

    @Test
    public void testDatePersistenceThroughBorrowReturn() {
        // Borrow
        library.borrowBook(member1, book1);
        LocalDate borrowDate = book1.getBorrowDate();
        assertNotNull(borrowDate);

        // Return
        library.returnBook(member1, book1);
        assertNull(book1.getBorrowDate(), "Date should be cleared on return");

        // Borrow again
        library.borrowBook(member2, book1);
        assertNotNull(book1.getBorrowDate());
        assertNotEquals(borrowDate, book1.getBorrowDate(), "Should be a new borrow date");
    }
}
