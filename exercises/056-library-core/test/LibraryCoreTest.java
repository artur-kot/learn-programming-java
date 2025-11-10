import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LibraryCoreTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Member member1;
    private Member member2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("1984", "George Orwell", "978-0451524935");
        book2 = new Book("Brave New World", "Aldous Huxley", "978-0060850524");
        member1 = new Member("Alice Johnson", "M001");
        member2 = new Member("Bob Smith", "M002");
    }

    // Book class tests
    @Test
    public void testBookCreation() {
        assertEquals("1984", book1.getTitle());
        assertEquals("George Orwell", book1.getAuthor());
        assertEquals("978-0451524935", book1.getIsbn());
        assertFalse(book1.isBorrowed(), "New book should not be borrowed");
    }

    @Test
    public void testBookSetBorrowed() {
        book1.setBorrowed(true);
        assertTrue(book1.isBorrowed());
        book1.setBorrowed(false);
        assertFalse(book1.isBorrowed());
    }

    @Test
    public void testBookToString() {
        String result = book1.toString();
        assertTrue(result.contains("978-0451524935"));
        assertTrue(result.contains("1984"));
        assertTrue(result.contains("George Orwell"));
        assertTrue(result.contains("Available") || result.contains("available"));
    }

    @Test
    public void testBookToStringBorrowed() {
        book1.setBorrowed(true);
        String result = book1.toString();
        assertTrue(result.contains("Borrowed") || result.contains("borrowed"));
    }

    // Member class tests
    @Test
    public void testMemberCreation() {
        assertEquals("Alice Johnson", member1.getName());
        assertEquals("M001", member1.getMemberId());
        assertEquals(0, member1.getBorrowedCount(), "New member should have 0 borrowed books");
    }

    @Test
    public void testMemberAddBorrowedBook() {
        member1.addBorrowedBook(book1);
        assertEquals(1, member1.getBorrowedCount());
        assertTrue(member1.getBorrowedBooks().contains(book1));
    }

    @Test
    public void testMemberAddMultipleBorrowedBooks() {
        member1.addBorrowedBook(book1);
        member1.addBorrowedBook(book2);
        assertEquals(2, member1.getBorrowedCount());
        assertTrue(member1.getBorrowedBooks().contains(book1));
        assertTrue(member1.getBorrowedBooks().contains(book2));
    }

    @Test
    public void testMemberRemoveBorrowedBook() {
        member1.addBorrowedBook(book1);
        member1.addBorrowedBook(book2);
        member1.removeBorrowedBook(book1);
        assertEquals(1, member1.getBorrowedCount());
        assertFalse(member1.getBorrowedBooks().contains(book1));
        assertTrue(member1.getBorrowedBooks().contains(book2));
    }

    @Test
    public void testMemberToString() {
        String result = member1.toString();
        assertTrue(result.contains("Alice Johnson"));
        assertTrue(result.contains("M001"));
        assertTrue(result.contains("0") || result.contains("zero"));
    }

    @Test
    public void testMemberToStringWithBooks() {
        member1.addBorrowedBook(book1);
        member1.addBorrowedBook(book2);
        String result = member1.toString();
        assertTrue(result.contains("2"));
    }

    // Library class tests
    @Test
    public void testLibraryCreation() {
        assertEquals(0, library.getTotalBooks());
        assertEquals(0, library.getTotalMembers());
    }

    @Test
    public void testLibraryAddBook() {
        library.addBook(book1);
        assertEquals(1, library.getTotalBooks());
        assertTrue(library.getAllBooks().contains(book1));
    }

    @Test
    public void testLibraryAddMultipleBooks() {
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.getTotalBooks());
        assertTrue(library.getAllBooks().contains(book1));
        assertTrue(library.getAllBooks().contains(book2));
    }

    @Test
    public void testLibraryAddMember() {
        library.addMember(member1);
        assertEquals(1, library.getTotalMembers());
        assertTrue(library.getAllMembers().contains(member1));
    }

    @Test
    public void testLibraryAddMultipleMembers() {
        library.addMember(member1);
        library.addMember(member2);
        assertEquals(2, library.getTotalMembers());
        assertTrue(library.getAllMembers().contains(member1));
        assertTrue(library.getAllMembers().contains(member2));
    }

    @Test
    public void testLibraryFindBookByIsbn() {
        library.addBook(book1);
        library.addBook(book2);
        Book found = library.findBookByIsbn("978-0451524935");
        assertNotNull(found);
        assertEquals("1984", found.getTitle());
    }

    @Test
    public void testLibraryFindBookByIsbnNotFound() {
        library.addBook(book1);
        Book found = library.findBookByIsbn("999-9999999999");
        assertNull(found);
    }

    @Test
    public void testLibraryFindMemberById() {
        library.addMember(member1);
        library.addMember(member2);
        Member found = library.findMemberById("M001");
        assertNotNull(found);
        assertEquals("Alice Johnson", found.getName());
    }

    @Test
    public void testLibraryFindMemberByIdNotFound() {
        library.addMember(member1);
        Member found = library.findMemberById("M999");
        assertNull(found);
    }

    @Test
    public void testLibraryGetAllBooks() {
        library.addBook(book1);
        library.addBook(book2);
        ArrayList<Book> books = library.getAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testLibraryGetAllMembers() {
        library.addMember(member1);
        library.addMember(member2);
        ArrayList<Member> members = library.getAllMembers();
        assertEquals(2, members.size());
    }

    @Test
    public void testCompleteWorkflow() {
        // Setup library
        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member1);
        library.addMember(member2);

        // Simulate borrowing
        book1.setBorrowed(true);
        member1.addBorrowedBook(book1);

        // Verify state
        assertEquals(2, library.getTotalBooks());
        assertEquals(2, library.getTotalMembers());
        assertTrue(book1.isBorrowed());
        assertEquals(1, member1.getBorrowedCount());

        // Find and verify
        Book foundBook = library.findBookByIsbn("978-0451524935");
        assertEquals("1984", foundBook.getTitle());
        assertTrue(foundBook.isBorrowed());

        Member foundMember = library.findMemberById("M001");
        assertEquals(1, foundMember.getBorrowedCount());
    }
}
