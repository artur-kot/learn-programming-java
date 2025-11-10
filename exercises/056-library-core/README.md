# Exercise 056: Library Core Classes

## Introduction

Think about your local library. It has thousands of books, hundreds of members, and countless transactions happening every day. But at its core, a library system is built on just three fundamental concepts: books (what's available), members (who can borrow), and the library itself (which manages everything). Before you can track what's borrowed or search for books, you need to define these building blocks.

In this capstone exercise, you'll design the foundation of a complete library management system by creating three interconnected classes. This is your first step toward building a professional-grade application that demonstrates everything you've learned in this course.

## What You're Learning

### Object-Oriented Design

Real-world applications are built from multiple classes working together, not single isolated classes. **Object-oriented design** is about:

- **Identifying entities**: What are the "things" in your system? (Books, Members, Library)
- **Defining responsibilities**: What does each entity do and know?
- **Establishing relationships**: How do entities interact with each other?
- **Encapsulation**: Keeping data private and controlled through methods

In a library system, Books exist independently, Members have identities, and the Library manages collections of both. Each has its own data and behaviors.

### Class Relationships

Classes don't exist in isolation. They form **relationships**:

- **Composition**: A Library "has" Books and Members (contains them in lists)
- **Association**: A Member can be associated with multiple Books
- **Dependency**: Operations on one class may depend on another class

Understanding these relationships is crucial for designing maintainable systems.

### Multi-Class Architecture

A well-designed application separates concerns:

- **Book class**: Represents a single book with its properties
- **Member class**: Represents a library member with their information
- **Library class**: Manages collections and high-level operations

Each class has a single, clear purpose. This makes code easier to understand, test, and modify.

### Full Encapsulation

**Encapsulation** means making fields private and controlling access through public methods:

```java
private String title;  // Private field - can't be accessed directly

public String getTitle() {     // Public getter - controlled read access
    return title;
}

public void setTitle(String title) {  // Public setter - controlled write access
    this.title = title;
}
```

This protects data integrity. You can add validation in setters, change internal implementation later, and control how data is accessed.

## Challenge

Build the core architecture for a library management system by creating three fully encapsulated classes with proper relationships.

Your system consists of:
1. **Book** - represents a single book
2. **Member** - represents a library member
3. **Library** - manages collections of books and members

## Requirements

### 1. Book Class (`Book.java`)

Create a `Book` class with:

**Private fields:**
- `String title` - the book's title
- `String author` - the book's author
- `String isbn` - unique book identifier (International Standard Book Number)
- `boolean isBorrowed` - whether the book is currently borrowed

**Constructors:**
- `Book(String title, String author, String isbn)` - creates a new book (not borrowed by default)

**Public methods:**
- Getters for all fields: `getTitle()`, `getAuthor()`, `getIsbn()`, `isBorrowed()`
- Setter for borrowed status: `setBorrowed(boolean borrowed)`
- `String toString()` - return formatted string: `"[ISBN] Title by Author (Available/Borrowed)"`

**Example:**
```java
Book book = new Book("1984", "George Orwell", "978-0451524935");
System.out.println(book);  // "978-0451524935: 1984 by George Orwell (Available)"
book.setBorrowed(true);
System.out.println(book.isBorrowed());  // true
```

### 2. Member Class (`Member.java`)

Create a `Member` class with:

**Private fields:**
- `String name` - member's full name
- `String memberId` - unique member identifier
- `ArrayList<Book> borrowedBooks` - list of books currently borrowed by this member

**Constructors:**
- `Member(String name, String memberId)` - creates a new member with empty borrowed books list

**Public methods:**
- Getters: `getName()`, `getMemberId()`, `getBorrowedBooks()`
- `void addBorrowedBook(Book book)` - add a book to borrowed list
- `void removeBorrowedBook(Book book)` - remove a book from borrowed list
- `int getBorrowedCount()` - return number of books borrowed
- `String toString()` - return formatted string: `"Member: Name (ID: memberId) - X books borrowed"`

**Example:**
```java
Member member = new Member("Alice Johnson", "M001");
Book book = new Book("1984", "George Orwell", "978-0451524935");
member.addBorrowedBook(book);
System.out.println(member);  // "Member: Alice Johnson (ID: M001) - 1 books borrowed"
```

### 3. Library Class (`Library.java`)

Create a `Library` class with:

**Private fields:**
- `ArrayList<Book> books` - collection of all books in the library
- `ArrayList<Member> members` - collection of all registered members

**Constructors:**
- `Library()` - creates a library with empty collections

**Public methods:**
- `void addBook(Book book)` - add a book to the library
- `void addMember(Member member)` - add a member to the library
- `Book findBookByIsbn(String isbn)` - find and return book by ISBN, or null if not found
- `Member findMemberById(String memberId)` - find and return member by ID, or null if not found
- `ArrayList<Book> getAllBooks()` - return list of all books
- `ArrayList<Member> getAllMembers()` - return list of all members
- `int getTotalBooks()` - return count of books in library
- `int getTotalMembers()` - return count of members

**Example:**
```java
Library library = new Library();

Book book1 = new Book("1984", "George Orwell", "978-0451524935");
Book book2 = new Book("Brave New World", "Aldous Huxley", "978-0060850524");
library.addBook(book1);
library.addBook(book2);

Member member = new Member("Alice Johnson", "M001");
library.addMember(member);

System.out.println(library.getTotalBooks());   // 2
System.out.println(library.getTotalMembers()); // 1

Book found = library.findBookByIsbn("978-0451524935");
System.out.println(found.getTitle());  // "1984"
```

## Expected Behavior

Here's how all three classes work together:

```java
// Create library
Library library = new Library();

// Add books
Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084");
library.addBook(book1);
library.addBook(book2);

// Add members
Member member1 = new Member("Bob Smith", "M001");
Member member2 = new Member("Carol White", "M002");
library.addMember(member1);
library.addMember(member2);

// Simulate borrowing (done manually for now - next exercise adds automation)
book1.setBorrowed(true);
member1.addBorrowedBook(book1);

// Check status
System.out.println(library.getTotalBooks());      // 2
System.out.println(library.getTotalMembers());    // 2
System.out.println(member1.getBorrowedCount());   // 1
System.out.println(book1.isBorrowed());           // true

// Find entities
Book found = library.findBookByIsbn("978-0743273565");
System.out.println(found.getTitle());  // "The Great Gatsby"

Member foundMember = library.findMemberById("M002");
System.out.println(foundMember.getName());  // "Carol White"
```

## Hints

<details>
<summary>Hint 1: Class Structure and Fields</summary>

Start with private fields and constructor:

```java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;  // Books start as available
    }
}
```

Follow the same pattern for Member and Library classes.

</details>

<details>
<summary>Hint 2: ArrayList Initialization</summary>

Initialize ArrayList fields in the constructor:

```java
public class Member {
    private ArrayList<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();  // Initialize empty list
    }
}
```

Don't forget to import ArrayList: `import java.util.ArrayList;`

</details>

<details>
<summary>Hint 3: Finding Items in Lists</summary>

To find a book by ISBN, loop through the books list:

```java
public Book findBookByIsbn(String isbn) {
    for (Book book : books) {
        if (book.getIsbn().equals(isbn)) {
            return book;  // Found it!
        }
    }
    return null;  // Not found
}
```

Use the same approach for finding members by ID.

</details>

<details>
<summary>Hint 4: toString() Method</summary>

Format the output string carefully:

```java
public String toString() {
    String status = isBorrowed ? "Borrowed" : "Available";
    return isbn + ": " + title + " by " + author + " (" + status + ")";
}
```

Use ternary operator for concise conditional strings.

</details>

## How to Test Your Solution

**Compile and run:**
```bash
cd exercises/056-library-core
javac src/*.java
java -cp src Book  # Run any class with main method for manual testing
```

**Run tests with Maven:**
```bash
cd exercises/056-library-core
mvn test
```

The tests verify:
- Book class encapsulation and methods
- Member class with borrowed books management
- Library class with collections
- Finding books by ISBN
- Finding members by ID
- toString() implementations
- All getters and setters

## Reflection Questions

After completing this exercise, consider:

1. **Why make fields private instead of public?** What problems does encapsulation prevent?
2. **Why does Library contain ArrayLists of Books and Members?** What relationship is this?
3. **How does the Member class reference Book objects?** What happens when you add a book to borrowedBooks?
4. **What would happen if you removed the isbn uniqueness requirement?** How would searching work?
5. **Why return null from find methods instead of throwing an exception?** What are the trade-offs?

## Next Steps

Congratulations! You've built the foundation of a library system. In Exercise 057, you'll add the exciting functionality:
- Automated borrow/return system
- Searching books by title, author, and ISBN
- Overdue tracking with dates
- Business rule validation (borrow limits, availability checks)

These operations will bring your core classes to life!

## Useful Prompts

- What's the difference between composition and inheritance?
- How do ArrayList references work when objects are shared between classes?
- What are the benefits of having separate find methods vs. one generic find method?
- How would you add validation to setters (e.g., ensuring ISBN format is correct)?

## Read More

- [Java OOP Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/)
- [Class Design Best Practices](https://www.baeldung.com/java-classes-objects)
- [Encapsulation in Java](https://www.geeksforgeeks.org/encapsulation-in-java/)
- [ArrayList with Custom Objects](https://www.baeldung.com/java-arraylist)
