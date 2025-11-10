# Exercise 058: Complete Library System

## Introduction

You've built the foundation (core classes) and implemented the operations (borrow/return/search). Now it's time to create a complete, professional application that a real library could use. This means adding three crucial components:

1. **Persistence**: Save data to files so it survives when the program closes
2. **User Interface**: An interactive menu that lets users perform all operations
3. **Reporting**: Analytics showing popular books and member activity

This is your capstone project - the culmination of everything you've learned. You'll integrate file I/O, menu-driven design, data analysis, and object-oriented programming into one cohesive application. When you're done, you'll have built something genuinely useful and impressive.

## What You're Learning

### File I/O and Data Persistence

Applications need to save data between runs. **File I/O** (Input/Output) lets you write data to files and read it back:

```java
// Writing
FileWriter writer = new FileWriter("library.txt");
writer.write("978-0451524935,1984,George Orwell,false\n");
writer.close();

// Reading
BufferedReader reader = new BufferedReader(new FileReader("library.txt"));
String line = reader.readLine();  // "978-0451524935,1984,George Orwell,false"
```

**Data serialization** means converting objects to text (saving) and back to objects (loading). You'll need to design a file format and implement both save and load operations.

### Menu-Driven Design

Professional applications need user interfaces. A **menu-driven** interface presents options and handles user choices:

```
=== Library Management System ===
1. Add Book
2. Add Member
3. Borrow Book
4. Return Book
5. Search Books
6. View Reports
7. Save & Exit
Enter choice:
```

This requires:
- Loop to keep showing menu until exit
- Input validation
- Calling appropriate methods based on choice
- Error handling for invalid input

### Data Reporting

**Reporting** means analyzing data to provide insights. For a library:
- Which books are most popular (borrowed most often)?
- How active is each member (how many books borrowed)?
- What's the current status of the library?

This involves counting, sorting, filtering, and presenting data in useful ways.

### Complete Application Integration

Real applications integrate many components:
- Data model (your classes)
- Business logic (operations)
- Data persistence (file I/O)
- User interface (menu)
- Reporting (analytics)

You'll learn to organize code, handle errors gracefully, and create a smooth user experience.

## Challenge

Transform your library system into a complete, interactive application with file persistence, a menu interface, and comprehensive reporting features.

Building on Exercises 056 and 057, you'll:
1. **Add file persistence** - save/load all library data
2. **Create interactive menu** - user-friendly interface for all operations
3. **Implement reporting** - popular books and member activity analysis
4. **Integrate everything** - a polished, complete application

## Requirements

### Setup

Copy your completed Book, Member, and Library classes from Exercise 057 into this exercise's `src` folder. You'll be extending Library with new features and creating a new main application class.

### 1. Enhance Library Class - File Persistence

Add these methods to `Library.java`:

**`void saveToFile(String filename)`**
- Save all books and members to a file
- File format (CSV-style):
  ```
  BOOKS
  isbn,title,author,isBorrowed,borrowDate
  978-0451524935,1984,George Orwell,false,
  978-0060850524,Brave New World,Aldous Huxley,true,2025-11-01
  MEMBERS
  memberId,name,borrowedBooksIsbns
  M001,Alice Johnson,978-0060850524
  M002,Bob Smith,
  ```
- Use try-catch to handle IOExceptions
- Print success or error message

**`void loadFromFile(String filename)`**
- Read file and recreate all books and members
- Parse each line to reconstruct objects
- Handle borrowed books relationships
- Use try-catch to handle file not found and parsing errors
- Print success or error message

### 2. Enhance Library Class - Reporting

Add these methods to `Library.java`:

**`ArrayList<Book> getMostPopularBooks(int limit)`**
- Return top N books by borrow count
- You'll need to track how many times each book has been borrowed (add field to Book)
- Sort books by borrow count (highest first)
- Return at most 'limit' books

**`void displayMemberActivity(Member member)`**
- Print summary of member's borrowing activity:
  - Current borrowed books count
  - List of currently borrowed books
  - Total books borrowed all-time (if tracked)

**`void displayLibraryStatus()`**
- Print comprehensive library statistics:
  - Total books in library
  - Books currently borrowed
  - Books available
  - Total members
  - Members with borrowed books

### 3. Create Main Application Class - LibraryApp

Create `LibraryApp.java` with interactive menu:

**Main menu options:**
1. Add Book (prompt for title, author, ISBN)
2. Add Member (prompt for name, member ID)
3. Borrow Book (prompt for member ID and ISBN)
4. Return Book (prompt for member ID and ISBN)
5. Search Books (submenu: by title, author, or ISBN)
6. View Reports (submenu: library status, popular books, member activity)
7. Save Data
8. Load Data
9. Exit

**Implementation requirements:**
- Use Scanner for input
- Loop until user chooses Exit
- Call appropriate Library methods for each operation
- Validate all user input
- Handle errors gracefully with try-catch
- Display clear feedback for all operations

### 4. Enhance Book Class - Borrow Tracking

Add to `Book.java`:
- `int borrowCount` field - tracks total times borrowed
- `void incrementBorrowCount()` - increment when borrowed
- `int getBorrowCount()` - return borrow count

## Expected Behavior

Here's what the complete application looks like in action:

```
=== Library Management System ===
1. Add Book
2. Add Member
3. Borrow Book
4. Return Book
5. Search Books
6. View Reports
7. Save Data
8. Load Data
9. Exit
Enter choice: 1

Enter book title: 1984
Enter author: George Orwell
Enter ISBN: 978-0451524935
Book added successfully!

Enter choice: 2

Enter member name: Alice Johnson
Enter member ID: M001
Member added successfully!

Enter choice: 3

Enter member ID: M001
Enter ISBN: 978-0451524935
Book borrowed successfully!

Enter choice: 6

=== Reports Menu ===
1. Library Status
2. Popular Books
3. Member Activity
4. Back to Main Menu
Enter choice: 1

=== Library Status ===
Total Books: 1
Books Borrowed: 1
Books Available: 0
Total Members: 1
Active Members: 1

Enter choice: 7

Enter filename to save: library.txt
Data saved successfully!

Enter choice: 9
Goodbye!
```

## Hints

<details>
<summary>Hint 1: Writing CSV Format</summary>

Use comma-separated values and newlines:

```java
public void saveToFile(String filename) {
    try (FileWriter writer = new FileWriter(filename)) {
        // Write books section
        writer.write("BOOKS\n");
        for (Book book : books) {
            String borrowDate = book.getBorrowDate() != null ?
                book.getBorrowDate().toString() : "";
            writer.write(String.format("%s,%s,%s,%b,%s\n",
                book.getIsbn(), book.getTitle(), book.getAuthor(),
                book.isBorrowed(), borrowDate));
        }
        // Write members section...
        System.out.println("Data saved successfully");
    } catch (IOException e) {
        System.out.println("Error saving data: " + e.getMessage());
    }
}
```

</details>

<details>
<summary>Hint 2: Reading and Parsing Files</summary>

Read line by line and split by comma:

```java
public void loadFromFile(String filename) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        String section = "";

        while ((line = reader.readLine()) != null) {
            if (line.equals("BOOKS")) {
                section = "BOOKS";
                continue;
            }
            if (line.equals("MEMBERS")) {
                section = "MEMBERS";
                continue;
            }

            if (section.equals("BOOKS")) {
                String[] parts = line.split(",");
                String isbn = parts[0];
                String title = parts[1];
                String author = parts[2];
                boolean borrowed = Boolean.parseBoolean(parts[3]);
                // Create book and add to library...
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}
```

</details>

<details>
<summary>Hint 3: Menu Loop Structure</summary>

Use a loop with switch statement:

```java
public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        displayMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addBook(library, scanner);
                break;
            case 2:
                addMember(library, scanner);
                break;
            // ... more cases
            case 9:
                running = false;
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
```

</details>

<details>
<summary>Hint 4: Sorting for Popular Books</summary>

Create a list and sort by borrow count:

```java
public ArrayList<Book> getMostPopularBooks(int limit) {
    ArrayList<Book> sortedBooks = new ArrayList<>(books);

    // Sort by borrow count (descending)
    sortedBooks.sort((b1, b2) -> b2.getBorrowCount() - b1.getBorrowCount());

    // Return first 'limit' books
    if (sortedBooks.size() > limit) {
        return new ArrayList<>(sortedBooks.subList(0, limit));
    }
    return sortedBooks;
}
```

</details>

## How to Test Your Solution

**Run the application:**
```bash
cd exercises/058-library-complete
javac src/*.java
java -cp src LibraryApp
```

**Run tests with Maven:**
```bash
cd exercises/058-library-complete
mvn test
```

The tests verify:
- File saving creates correct format
- File loading reconstructs objects correctly
- Borrowed book relationships are preserved
- Popular books sorting works
- Member activity reporting works
- Library status calculations are correct
- Menu operations integrate properly

## Reflection Questions

After completing this capstone exercise, consider:

1. **Why separate file I/O from business logic?** How does this make testing easier?
2. **What happens if the file format changes?** How would you handle version compatibility?
3. **Why use try-with-resources for file operations?** What problem does it solve?
4. **How would you handle concurrent access?** What if two users modify the library simultaneously?
5. **What security concerns exist with file persistence?** How could you protect sensitive data?
6. **How would you extend this to a database?** What would change and what would stay the same?

## Next Steps

Congratulations! You've completed a comprehensive capstone project demonstrating mastery of:
- Object-oriented design and programming
- Collections and data structures
- File I/O and data persistence
- User interface design
- Error handling
- Data analysis and reporting

This is a portfolio-worthy project! Consider enhancing it further:
- Add authentication (library staff login)
- Implement book reservations
- Add fines for overdue books
- Create a graphical interface (JavaFX or Swing)
- Store data in SQLite database instead of text files
- Generate reports as PDF files
- Add book categories and filtering
- Implement book recommendations

You're now ready to tackle real-world Java applications!

## Useful Prompts

- How would you implement undo/redo functionality?
- What design patterns apply to this application (MVC, Repository, etc.)?
- How would you add logging to track all operations?
- What unit tests would make this more robust?
- How could you make this multi-user (client-server architecture)?

## Read More

- [File I/O in Java](https://docs.oracle.com/javase/tutorial/essential/io/)
- [Try-with-resources](https://www.baeldung.com/java-try-with-resources)
- [CSV Parsing in Java](https://www.baeldung.com/java-csv)
- [Comparator and Comparable](https://www.baeldung.com/java-comparator-comparable)
- [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
- [Scanner Class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html)
