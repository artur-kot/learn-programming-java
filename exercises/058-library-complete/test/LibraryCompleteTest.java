import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;

public class LibraryCompleteTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Member member1;
    private Member member2;
    private static final String TEST_FILE = "test_library.txt";

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

    @AfterEach
    public void cleanup() {
        // Clean up test file
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    // Borrow count tests
    @Test
    public void testBorrowCountIncrement() {
        assertEquals(0, book1.getBorrowCount(), "New book should have 0 borrow count");
        library.borrowBook(member1, book1);
        assertEquals(1, book1.getBorrowCount(), "Borrow count should increment");
    }

    @Test
    public void testBorrowCountMultipleBorrows() {
        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);
        library.borrowBook(member2, book1);
        assertEquals(2, book1.getBorrowCount(), "Count should track all borrows");
    }

    // File I/O tests
    @Test
    public void testSaveToFile() {
        library.borrowBook(member1, book1);
        library.saveToFile(TEST_FILE);

        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should be created");
        assertTrue(file.length() > 0, "File should not be empty");
    }

    @Test
    public void testLoadFromFile() {
        // Setup and save
        library.borrowBook(member1, book1);
        library.saveToFile(TEST_FILE);

        // Create new library and load
        Library newLibrary = new Library();
        newLibrary.loadFromFile(TEST_FILE);

        assertEquals(3, newLibrary.getTotalBooks(), "Should load all books");
        assertEquals(2, newLibrary.getTotalMembers(), "Should load all members");

        // Verify book loaded correctly
        Book loadedBook = newLibrary.findBookByIsbn("978-0451524935");
        assertNotNull(loadedBook);
        assertEquals("1984", loadedBook.getTitle());
        assertTrue(loadedBook.isBorrowed(), "Borrowed status should be preserved");
    }

    @Test
    public void testSaveAndLoadPreservesBorrowCount() {
        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);
        library.borrowBook(member2, book1);

        library.saveToFile(TEST_FILE);

        Library newLibrary = new Library();
        newLibrary.loadFromFile(TEST_FILE);

        Book loadedBook = newLibrary.findBookByIsbn("978-0451524935");
        assertEquals(2, loadedBook.getBorrowCount(), "Borrow count should be preserved");
    }

    @Test
    public void testSaveAndLoadBorrowedBookRelationships() {
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(member2, book3);

        library.saveToFile(TEST_FILE);

        Library newLibrary = new Library();
        newLibrary.loadFromFile(TEST_FILE);

        Member loadedMember1 = newLibrary.findMemberById("M001");
        assertEquals(2, loadedMember1.getBorrowedCount(), "Member should have borrowed books");

        Member loadedMember2 = newLibrary.findMemberById("M002");
        assertEquals(1, loadedMember2.getBorrowedCount());
    }

    @Test
    public void testLoadFromNonExistentFile() {
        // Should handle gracefully without crashing
        assertDoesNotThrow(() -> library.loadFromFile("nonexistent_file.txt"));
    }

    // Reporting tests
    @Test
    public void testGetMostPopularBooksEmpty() {
        ArrayList<Book> popular = library.getMostPopularBooks(3);
        assertNotNull(popular);
        assertEquals(3, popular.size(), "Should return books even with 0 borrows");
    }

    @Test
    public void testGetMostPopularBooksOrdering() {
        // Book1: 3 borrows
        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);
        library.borrowBook(member2, book1);
        library.returnBook(member2, book1);
        library.borrowBook(member1, book1);

        // Book2: 1 borrow
        library.borrowBook(member2, book2);

        // Book3: 0 borrows

        ArrayList<Book> popular = library.getMostPopularBooks(3);
        assertEquals("1984", popular.get(0).getTitle(), "Most borrowed should be first");
        assertEquals(3, popular.get(0).getBorrowCount());
        assertEquals("Animal Farm", popular.get(1).getTitle());
        assertEquals(1, popular.get(1).getBorrowCount());
    }

    @Test
    public void testGetMostPopularBooksLimit() {
        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        ArrayList<Book> popular = library.getMostPopularBooks(2);
        assertEquals(2, popular.size(), "Should respect limit");
    }

    @Test
    public void testDisplayLibraryStatusOutput() {
        // Borrow some books
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        library.displayLibraryStatus();

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(output.contains("3") || output.contains("Total"), "Should show total books");
        assertTrue(output.contains("2") || output.contains("Borrowed"), "Should show borrowed count");
    }

    @Test
    public void testDisplayMemberActivityOutput() {
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);

        // Capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        library.displayMemberActivity(member1);

        System.setOut(originalOut);
        String output = outContent.toString();

        assertTrue(output.contains("Alice Johnson") || output.contains("M001"));
        assertTrue(output.contains("2") || output.contains("1984") || output.contains("Animal Farm"));
    }

    // Integration tests
    @Test
    public void testCompleteWorkflow() {
        // Add and borrow books
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(member2, book3);

        // Get popular books
        ArrayList<Book> popular = library.getMostPopularBooks(3);
        assertEquals(3, popular.size());

        // Save to file
        library.saveToFile(TEST_FILE);

        // Load into new library
        Library newLibrary = new Library();
        newLibrary.loadFromFile(TEST_FILE);

        // Verify everything
        assertEquals(3, newLibrary.getTotalBooks());
        assertEquals(2, newLibrary.getTotalMembers());

        Member loadedMember = newLibrary.findMemberById("M001");
        assertEquals(2, loadedMember.getBorrowedCount());

        Book loadedBook = newLibrary.findBookByIsbn("978-0451524935");
        assertTrue(loadedBook.isBorrowed());
        assertEquals(1, loadedBook.getBorrowCount());
    }

    @Test
    public void testLibraryStatusCalculations() {
        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        // Should have:
        // - 3 total books
        // - 2 borrowed
        // - 1 available
        // - 2 total members
        // - 2 active members

        // We verify this indirectly through the display
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.displayLibraryStatus();

        System.setOut(System.out);
        String output = outContent.toString();

        // Should contain relevant numbers
        assertTrue(output.contains("3") || output.contains("Total"));
    }

    @Test
    public void testEmptyLibrarySaveLoad() {
        Library emptyLibrary = new Library();
        emptyLibrary.saveToFile(TEST_FILE);

        Library newLibrary = new Library();
        newLibrary.loadFromFile(TEST_FILE);

        assertEquals(0, newLibrary.getTotalBooks());
        assertEquals(0, newLibrary.getTotalMembers());
    }
}
