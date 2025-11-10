# Exercise 057: Library Operations

## Introduction

You've built the foundation of your library system with Book, Member, and Library classes. But right now, borrowing a book requires manually calling several methods: `book.setBorrowed(true)`, then `member.addBorrowedBook(book)`. What if you forget one step? What if someone tries to borrow a book that's already borrowed? What if a member tries to return a book they never borrowed?

Real applications need **business logic** - rules that ensure operations happen correctly and safely. In this exercise, you'll implement the core operations that make your library system functional: borrowing and returning books with full validation, searching through the collection in multiple ways, and tracking which books are overdue.

## What You're Learning

### State Management

**State** is the current condition of your data. When you borrow a book, multiple states change simultaneously:
- Book's `isBorrowed` becomes true
- Book is added to member's `borrowedBooks` list
- Book might need a `borrowDate` recorded

**State management** means keeping all related states synchronized. If one changes, all must change together. Otherwise, your data becomes inconsistent (a book marked as borrowed but not in anyone's list).

### Business Rules and Validation

**Business rules** are the requirements of your application. For a library:
- Can't borrow a book that's already borrowed
- Can't return a book you don't have
- Members might have borrowing limits
- Books might have rental periods

**Validation** checks these rules before performing operations:

```java
if (book.isBorrowed()) {
    System.out.println("Book is already borrowed");
    return false;  // Operation fails
}
// Proceed with borrowing...
```

This prevents invalid states and provides clear feedback.

### Searching Algorithms

Real users don't remember ISBNs - they search by title or author. **Search algorithms** find items matching criteria:

- **Linear search**: Check each item one by one (simple, works for any condition)
- **Partial matching**: Does the title contain the search term?
- **Case-insensitive**: Make searches work regardless of capitalization

These techniques make your application user-friendly.

### Date Handling in Java

Libraries track when books were borrowed to identify overdue items. Java provides `LocalDate` for working with dates:

```java
LocalDate today = LocalDate.now();
LocalDate borrowDate = LocalDate.of(2025, 11, 1);
long daysAgo = ChronoUnit.DAYS.between(borrowDate, today);
```

Understanding dates is crucial for scheduling, tracking, and reporting features.

## Challenge

Enhance your library system with automated borrow/return operations, comprehensive search capabilities, and overdue tracking.

Building on Exercise 056's classes, you'll:
1. **Automate borrowing** - handle all state changes and validation
2. **Automate returns** - verify and update all related data
3. **Implement search** - find books by title, author, or ISBN
4. **Track overdues** - identify books borrowed too long

## Requirements

### Setup

Copy your completed Book, Member, and Library classes from Exercise 056 into this exercise's `src` folder. You'll be extending them with new functionality.

### 1. Enhance Book Class

Add to your `Book.java`:

**New field:**
- `LocalDate borrowDate` - when the book was borrowed (null if not borrowed)

**New methods:**
- `void setBorrowDate(LocalDate date)` - set the borrow date
- `LocalDate getBorrowDate()` - get the borrow date
- `boolean isOverdue(int maxDays)` - return true if borrowed more than maxDays ago

### 2. Enhance Library Class

Add these methods to your `Library.java`:

#### Borrow/Return Operations

**`boolean borrowBook(Member member, Book book)`**
- Validate: book exists in library, book is not already borrowed
- If valid:
  - Set book as borrowed
  - Set today's date as borrow date
  - Add book to member's borrowed list
  - Return true
- If invalid: print error message and return false

**`boolean returnBook(Member member, Book book)`**
- Validate: member has this book in their borrowed list
- If valid:
  - Set book as not borrowed
  - Clear borrow date (set to null)
  - Remove book from member's borrowed list
  - Return true
- If invalid: print error message and return false

#### Search Operations

**`ArrayList<Book> searchByTitle(String title)`**
- Find all books whose title contains the search term (case-insensitive)
- Return list of matching books (empty list if none found)

**`ArrayList<Book> searchByAuthor(String author)`**
- Find all books whose author name contains the search term (case-insensitive)
- Return list of matching books

**`Book searchByIsbn(String isbn)`**
- Find the exact book with this ISBN
- Return the book or null if not found
- (This might be similar to your existing findBookByIsbn method)

#### Overdue Tracking

**`ArrayList<Book> getOverdueBooks(int maxDays)`**
- Find all books borrowed more than maxDays ago
- Return list of overdue books

## Expected Behavior

Here's how the enhanced system works:

```java
Library library = new Library();

// Setup
Book book1 = new Book("1984", "George Orwell", "978-0451524935");
Book book2 = new Book("Animal Farm", "George Orwell", "978-0451526342");
library.addBook(book1);
library.addBook(book2);

Member member = new Member("Alice Johnson", "M001");
library.addMember(member);

// Borrow a book
boolean success = library.borrowBook(member, book1);
System.out.println(success);  // true
System.out.println(book1.isBorrowed());  // true
System.out.println(member.getBorrowedCount());  // 1

// Try to borrow same book again
success = library.borrowBook(member, book1);  // Prints error message
System.out.println(success);  // false

// Search by author
ArrayList<Book> orwellBooks = library.searchByAuthor("Orwell");
System.out.println(orwellBooks.size());  // 2 (both books by Orwell)

// Search by title
ArrayList<Book> results = library.searchByTitle("animal");  // Case-insensitive
System.out.println(results.size());  // 1 (Animal Farm)

// Return a book
success = library.returnBook(member, book1);
System.out.println(success);  // true
System.out.println(book1.isBorrowed());  // false
System.out.println(member.getBorrowedCount());  // 0

// Check for overdue books
ArrayList<Book> overdueBooks = library.getOverdueBooks(14);  // Books out > 14 days
System.out.println(overdueBooks.size());  // Depends on borrow dates
```

## Hints

<details>
<summary>Hint 1: Adding Date Field to Book</summary>

Import the date classes and add the field:

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
    private LocalDate borrowDate;  // Add this field

    public void setBorrowDate(LocalDate date) {
        this.borrowDate = date;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}
```

</details>

<details>
<summary>Hint 2: Implementing borrowBook</summary>

Check all conditions before making changes:

```java
public boolean borrowBook(Member member, Book book) {
    // Validation
    if (!books.contains(book)) {
        System.out.println("Book not found in library");
        return false;
    }
    if (book.isBorrowed()) {
        System.out.println("Book is already borrowed");
        return false;
    }

    // Update all states together
    book.setBorrowed(true);
    book.setBorrowDate(LocalDate.now());
    member.addBorrowedBook(book);
    return true;
}
```

</details>

<details>
<summary>Hint 3: Case-Insensitive Search</summary>

Convert both strings to lowercase for comparison:

```java
public ArrayList<Book> searchByTitle(String title) {
    ArrayList<Book> results = new ArrayList<>();
    String searchLower = title.toLowerCase();

    for (Book book : books) {
        if (book.getTitle().toLowerCase().contains(searchLower)) {
            results.add(book);
        }
    }

    return results;
}
```

</details>

<details>
<summary>Hint 4: Checking Overdue Books</summary>

Calculate days between dates:

```java
public boolean isOverdue(int maxDays) {
    if (borrowDate == null || !isBorrowed) {
        return false;  // Not borrowed, can't be overdue
    }

    LocalDate today = LocalDate.now();
    long daysBorrowed = ChronoUnit.DAYS.between(borrowDate, today);
    return daysBorrowed > maxDays;
}
```

</details>

## How to Test Your Solution

**Compile and run:**
```bash
cd exercises/057-library-operations
javac src/*.java
```

**Run tests with Maven:**
```bash
cd exercises/057-library-operations
mvn test
```

The tests verify:
- Borrowing books updates all states correctly
- Validation prevents invalid borrows
- Returning books updates all states correctly
- Validation prevents invalid returns
- Search by title finds matches (case-insensitive)
- Search by author finds matches
- Search by ISBN works correctly
- Overdue tracking calculates correctly

## Reflection Questions

After completing this exercise, consider:

1. **Why validate before performing operations?** What could go wrong without validation?
2. **Why update multiple states together?** What happens if you update some but not others?
3. **Why return boolean from borrow/return methods?** How does the caller know if the operation succeeded?
4. **Why use case-insensitive search?** How does this improve user experience?
5. **What edge cases exist for overdue tracking?** What if a book is returned late and borrowed again?

## Next Steps

Excellent work! You now have a fully functional library system with safe operations. In Exercise 058, you'll complete the project by adding:
- File persistence (save/load data)
- Interactive menu interface
- Reporting features (popular books, member activity)
- Complete application integration

This final exercise brings everything together into a professional application!

## Useful Prompts

- How does LocalDate handle leap years and month boundaries?
- What's the difference between contains() and equals() for lists?
- How would you add a borrowing limit (max books per member)?
- What are the trade-offs between returning null vs. throwing exceptions?

## Read More

- [Java LocalDate Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDate.html)
- [Working with Dates in Java](https://www.baeldung.com/java-8-date-time-intro)
- [String Methods in Java](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
- [ArrayList Search and Filter](https://www.baeldung.com/java-stream-filter-lambda)
