# Exercise 051: File Operations Basics

## Introduction

Until now, all your programs have worked with data that disappears when the program ends. In this exercise, you'll learn how to **save data to files** and **read it back later**. This is how real applications remember things - whether it's saving your game progress, storing notes, or keeping configuration settings.

## What You're Learning

**What Are Files?**
Files are how computers permanently store data on disk. Unlike variables (which exist only while your program runs), files persist even after your program closes. Think of files like notebooks that stay on your shelf - you can write in them, read from them later, and add more content whenever you want.

**Why File I/O Matters:**
- **Persistence**: Data survives after your program ends
- **Sharing**: Other programs (or people) can access the same data
- **Backup**: Important information is saved safely
- **Real-world applications**: Every app that "remembers" something uses files

**Writing to Files:**
To write text to a file in Java, you use `FileWriter`:

```java
import java.io.FileWriter;
import java.io.IOException;

try {
    FileWriter writer = new FileWriter("output.txt");
    writer.write("Hello, file!");
    writer.close();  // Very important - closes the file
} catch (IOException e) {
    System.out.println("Error writing to file");
}
```

**Reading from Files:**
To read text from a file, you use `BufferedReader` with `FileReader`:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

try {
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
    reader.close();
} catch (IOException e) {
    System.out.println("Error reading file");
}
```

**Try-With-Resources:**
Java has a better way to handle files that **automatically closes them** for you:

```java
try (FileWriter writer = new FileWriter("output.txt")) {
    writer.write("Hello!");
    // No need to call close() - it happens automatically!
} catch (IOException e) {
    System.out.println("Error");
}
```

The resources in parentheses after `try` are automatically closed when the block ends, even if an error occurs. This prevents bugs where files stay open accidentally.

**File Modes:**
When creating a FileWriter, you can specify how to open the file:
- `new FileWriter("file.txt")` - **Overwrites** the entire file (default)
- `new FileWriter("file.txt", true)` - **Appends** to the end of the file (keeps existing content)

**Checking If Files Exist:**
Use the `File` class to check if a file exists:

```java
import java.io.File;

File file = new File("data.txt");
if (file.exists()) {
    System.out.println("File exists!");
}
```

**Why This Matters:**
Learning file I/O opens the door to building real applications that store user data, save game states, log events, and much more. Every professional application uses file operations in some form.

## Challenge

Your task: **Create a file utility class that can write, read, append, and check files.**

Implement these methods:
1. **`writeToFile(String filename, String content)`** - Writes content to a file (overwrites if exists)
2. **`readFromFile(String filename)`** - Reads entire file content and returns it as a String
3. **`appendToFile(String filename, String content)`** - Adds content to the end of an existing file
4. **`fileExists(String filename)`** - Returns true if the file exists, false otherwise

## Requirements

- All methods must be `public static`
- Use **try-with-resources** for all file operations (automatic resource management)
- Handle `IOException` appropriately with try-catch blocks
- `readFromFile()` should return an empty string if file doesn't exist
- `readFromFile()` should preserve line breaks when reading multi-line files
- Methods should work with relative file paths (files in the same directory as your program)
- Close all file resources properly (try-with-resources does this automatically)

## Hints

**Hint 1:** For `writeToFile()`, use `FileWriter` without the append parameter (defaults to overwrite mode).

**Hint 2:** For `readFromFile()`, use `BufferedReader` and loop through lines with `readLine()`. Build the result using a `StringBuilder` or string concatenation.

**Hint 3:** For `appendToFile()`, use `new FileWriter(filename, true)` where `true` means append mode.

**Hint 4:** Use the `File` class for `fileExists()` - it has an `exists()` method.

**Hint 5:** The try-with-resources syntax is: `try (Resource r = new Resource()) { ... }`

## Expected Behavior

When you run your program, you should be able to:

```java
// Write to a new file
writeToFile("test.txt", "First line");

// Read it back
String content = readFromFile("test.txt");
System.out.println(content);  // Prints: First line

// Append more content
appendToFile("test.txt", "\nSecond line");

// Read again
content = readFromFile("test.txt");
System.out.println(content);
// Prints:
// First line
// Second line

// Check if file exists
boolean exists = fileExists("test.txt");
System.out.println(exists);  // Prints: true

boolean missing = fileExists("nonexistent.txt");
System.out.println(missing);  // Prints: false
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/051-file-basics
mvn test
```

All tests should pass. The tests verify file writing, reading, appending, and existence checking.

## Reflection Questions

After completing this exercise, think about:

1. Why is it important to close file resources after using them?
2. What are the advantages of try-with-resources over manually calling close()?
3. When would you use append mode instead of overwrite mode?
4. What happens if you try to read a file that doesn't exist?
5. How could file operations fail, and why do we need IOException handling?

## Next Steps

In the next exercise, you'll build on these file operations to save and load **structured data** in CSV format - learning how to store lists of objects like a real database!

## Read More

- [FileWriter Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/io/FileWriter.html)
- [BufferedReader Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/io/BufferedReader.html)
- [Try-With-Resources Tutorial](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
- [File I/O in Java](https://docs.oracle.com/javase/tutorial/essential/io/)
