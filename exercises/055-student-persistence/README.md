# Exercise 055: Data Persistence

## Introduction

You've built an impressive student management system with analytics capabilities—but there's one critical problem. When your program ends, all the data disappears! Every time you restart, you have to re-enter all the student information. This is where data persistence comes in. By saving data to files and loading it back, you can ensure your work survives between sessions.

Think about the apps you use every day—they all save your data somewhere. Your contacts app, your notes, your game progress—all persisted to storage. In this exercise, you'll learn the fundamental skill of reading and writing data to files, a cornerstone of real-world application development.

## What You're Learning

**File I/O (Input/Output):**
File I/O is how programs interact with the file system—reading data from files and writing data to them. Java provides several classes for file operations, and you'll learn to use them safely and effectively.

**Data Serialization:**
Serialization is the process of converting data structures (like your ArrayList of Student objects) into a format that can be stored in a file and later reconstructed. You'll learn about CSV (Comma-Separated Values), a simple and widely-used text format for structured data.

**CSV Format:**
CSV is a universal format for storing tabular data. Each line represents a record, and fields are separated by commas. It's human-readable and supported by virtually every data tool, from Excel to databases.

**Error Handling:**
File operations can fail for many reasons—files might not exist, you might not have permission to write, the disk might be full. You'll learn to handle these errors gracefully using try-catch blocks and provide meaningful feedback to users.

**Persistence Layer:**
A persistence layer separates your data storage logic from your business logic. This is a fundamental architecture pattern that makes your code more modular and easier to maintain.

## Challenge

Extend your student management system with file persistence capabilities. You'll add the ability to save all student data to a CSV file and load it back, effectively creating a simple database system.

This exercise builds on Exercises 053 and 054—you'll use the same `Student`, `StudentManager`, and `StudentStats` classes.

## Requirements

### StudentPersistence Class
Create a new class with these static methods:

- `saveToFile(StudentManager manager, String filename)` - saves all students to a CSV file
- `loadFromFile(String filename)` - loads students from a CSV file and returns a StudentManager
- Handle file errors gracefully with appropriate error messages

### CSV Format
Each line in the file represents one student:
```
id,name,grade1;grade2;grade3
```

Example file content:
```
101,Alice Johnson,95.0;88.5;92.0
102,Bob Smith,78.0;85.5
103,Charlie Davis
```

Note: Students with no grades should have no grades listed after their name.

## Hints

<details>
<summary>Hint 1: Writing to a File</summary>

Use `FileWriter` and `BufferedWriter` for writing:
```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
    writer.write("line of text");
    writer.newLine();
} catch (IOException e) {
    System.out.println("Error writing file: " + e.getMessage());
}
```

The try-with-resources syntax automatically closes the file.

</details>

<details>
<summary>Hint 2: Reading from a File</summary>

Use `FileReader` and `BufferedReader` for reading:
```java
try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
    String line;
    while ((line = reader.readLine()) != null) {
        // Process each line
    }
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}
```

</details>

<details>
<summary>Hint 3: Parsing CSV Lines</summary>

Use `String.split()` to break lines into parts:
```java
String[] parts = line.split(",");
int id = Integer.parseInt(parts[0]);
String name = parts[1];

if (parts.length > 2 && !parts[2].isEmpty()) {
    String[] gradeStrings = parts[2].split(";");
    // Convert each grade string to double
}
```

</details>

<details>
<summary>Hint 4: Formatting Grades for CSV</summary>

To create the grades string (e.g., "95.0;88.5;92.0"):
```java
String gradesString = String.join(";",
    student.getGrades().stream()
           .map(String::valueOf)
           .collect(Collectors.toList())
);
```

Or use a loop:
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < grades.size(); i++) {
    sb.append(grades.get(i));
    if (i < grades.size() - 1) sb.append(";");
}
```

</details>

## Expected Behavior

**Saving students to file:**
```
Saving 3 students to students.csv...
Successfully saved 3 students to students.csv
```

**File content (students.csv):**
```
101,Alice Johnson,95.0;88.5;92.0
102,Bob Smith,78.0;85.5
103,Charlie Davis
```

**Loading students from file:**
```
Loading students from students.csv...
Successfully loaded 3 students from students.csv

Loaded Students:
1. Student{id=101, name='Alice Johnson', grades=[95.0, 88.5, 92.0]}
2. Student{id=102, name='Bob Smith', grades=[78.0, 85.5]}
3. Student{id=103, name='Charlie Davis', grades=[]}
```

**Error handling:**
```
Error loading file: students.csv (The system cannot find the file specified)
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/055-student-persistence
mvn test
```

**Manual Testing:**
```bash
cd exercises/055-student-persistence/src
javac Student.java StudentManager.java StudentStats.java StudentPersistence.java
java StudentPersistence
```

## Reflection Questions

1. **Why CSV?** What are the advantages of using a text-based format like CSV versus a binary format? When might you choose one over the other?

2. **Data integrity:** What could go wrong if a user manually edits the CSV file and makes a mistake? How could you make your parser more robust?

3. **File permissions:** What happens if you try to save to a location where you don't have write permission? How does your error handling address this?

4. **Scalability:** For a school with 10,000 students, would this CSV approach still work well? What limitations might you encounter?

5. **Alternative formats:** You've used CSV here. What other data formats could you use (JSON, XML, databases)? What would be the trade-offs?

## Next Steps

Congratulations! You've built a complete, production-quality student management system with CRUD operations, analytics, and data persistence. This is a significant achievement that demonstrates your mastery of:
- Object-oriented programming
- Collections and data structures
- Algorithms and data processing
- File I/O and error handling
- Software architecture patterns

This system could actually be used in a real classroom setting! You now have the foundational skills to build much more complex applications.

## Read More

- [Java File I/O Tutorial](https://docs.oracle.com/javase/tutorial/essential/io/)
- [BufferedReader and BufferedWriter](https://www.baeldung.com/java-buffered-reader)
- [CSV Format Specification](https://tools.ietf.org/html/rfc4180)
- [Try-with-Resources Statement](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [Exception Handling Best Practices](https://www.baeldung.com/java-exceptions)
