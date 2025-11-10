# Exercise 052: Data Persistence with CSV

## Introduction

In the previous exercise, you learned to read and write plain text files. But what if you need to save **structured data** - like a list of people with names, ages, and emails? This exercise teaches you how to save and load objects using **CSV (Comma-Separated Values)** format, one of the most common ways to store structured data.

## What You're Learning

**What Is CSV Format?**
CSV stands for "Comma-Separated Values" - it's a simple way to store tabular data in plain text. Each line represents one record, and commas separate the fields within each record.

Example CSV file storing people:
```
John Doe,30,john@email.com
Jane Smith,25,jane@email.com
Bob Johnson,35,bob@email.com
```

Each line has three fields: name, age, and email, separated by commas.

**Why CSV Matters:**
- **Universal**: Nearly every program can read/write CSV (Excel, databases, Python, etc.)
- **Human-readable**: You can open and edit CSV files in any text editor
- **Simple**: Easy to parse and generate programmatically
- **Practical**: Real applications use CSV for data import/export, backups, and data exchange

**Saving Objects to CSV:**
To save a list of objects as CSV, you need to:
1. Convert each object to a CSV line (format fields with commas)
2. Write each line to the file

Example:
```java
Person person = new Person("John", 30, "john@email.com");
String csvLine = person.name + "," + person.age + "," + person.email;
// Result: "John,30,john@email.com"
```

**Loading Objects from CSV:**
To load objects from CSV, you need to:
1. Read each line from the file
2. Split the line by commas
3. Parse the fields and create objects

Example:
```java
String csvLine = "John,30,john@email.com";
String[] parts = csvLine.split(",");  // ["John", "30", "john@email.com"]
String name = parts[0];
int age = Integer.parseInt(parts[1]);
String email = parts[2];
Person person = new Person(name, age, email);
```

**The String.split() Method:**
`split()` divides a string into parts based on a separator:
```java
"apple,banana,cherry".split(",")  // Returns: ["apple", "banana", "cherry"]
"10:30:45".split(":")             // Returns: ["10", "30", "45"]
```

**Error Handling in CSV Parsing:**
CSV parsing can fail for many reasons:
- File doesn't exist
- Line has wrong number of fields
- Number parsing fails (age is not a number)
- Empty or malformed data

Always use try-catch to handle these cases gracefully.

**Data Serialization:**
Converting objects to text format (like CSV) is called **serialization**. Converting text back to objects is called **deserialization**. This is fundamental to saving and loading data in any application.

**Why This Matters:**
CSV is the backbone of data exchange between systems. Learning it teaches you how to persist data structures, not just simple text. This skill applies to databases, JSON, XML, and other data formats you'll encounter.

## Challenge

Your task: **Create a system to save and load Person objects using CSV format.**

First, create a simple `Person` class to hold data:
- Fields: `name` (String), `age` (int), `email` (String)
- Constructor to initialize all fields
- A method to convert the person to a CSV line

Then implement these methods:
1. **`saveToCSV(ArrayList<Person> people, String filename)`** - Saves list of people to CSV file
2. **`loadFromCSV(String filename)`** - Reads CSV file and returns ArrayList of Person objects
3. **`parseCSVLine(String line)`** - Parses one CSV line and returns a Person object (or null if invalid)

## Requirements

- Create a `Person` class with fields: `name`, `age`, `email`
- Add a constructor that takes all three fields
- Add a method `toCSV()` that returns the person as a CSV string
- All CSV methods must be `public static`
- Use try-with-resources for file operations
- Handle `IOException` and parsing errors appropriately
- `parseCSVLine()` should return `null` if the line is invalid (wrong format, bad numbers, etc.)
- `loadFromCSV()` should skip invalid lines and continue processing
- Use `ArrayList<Person>` to store collections of people

## Hints

**Hint 1:** For `toCSV()`, concatenate fields with commas: `name + "," + age + "," + email`

**Hint 2:** For `saveToCSV()`, loop through the ArrayList and write each person's CSV line to the file.

**Hint 3:** For `parseCSVLine()`, use `split(",")` to divide the line, then check if you have exactly 3 parts.

**Hint 4:** Use `Integer.parseInt()` to convert the age string to an int. Wrap this in try-catch to handle invalid numbers.

**Hint 5:** For `loadFromCSV()`, read lines with BufferedReader, parse each line, and add valid Person objects to an ArrayList.

## Expected Behavior

When you run your program, you should be able to:

```java
// Create some people
ArrayList<Person> people = new ArrayList<>();
people.add(new Person("Alice", 28, "alice@email.com"));
people.add(new Person("Bob", 35, "bob@email.com"));
people.add(new Person("Charlie", 42, "charlie@email.com"));

// Save to CSV
saveToCSV(people, "people.csv");

// Load back from CSV
ArrayList<Person> loadedPeople = loadFromCSV("people.csv");

// Verify
for (Person p : loadedPeople) {
    System.out.println(p.name + " is " + p.age + " years old");
}
// Prints:
// Alice is 28 years old
// Bob is 35 years old
// Charlie is 42 years old
```

The `people.csv` file will contain:
```
Alice,28,alice@email.com
Bob,35,bob@email.com
Charlie,42,charlie@email.com
```

## Testing Instructions

Run your tests to verify your implementation:
```bash
cd exercises/052-data-persistence
mvn test
```

All tests should pass. The tests verify CSV serialization, deserialization, parsing, and error handling.

## Reflection Questions

After completing this exercise, think about:

1. Why is CSV a popular format for data exchange?
2. What are the limitations of CSV compared to other formats?
3. How would you handle commas within data fields (e.g., "Smith, Jr.")?
4. What other data formats have you heard of (JSON, XML)?
5. How is this different from storing data in memory with ArrayList?

## Next Steps

You now have the foundational skills for data persistence! In future exercises, you'll combine file I/O with larger applications - like saving a student management system or library catalog. You'll also explore more advanced formats like JSON.

## Read More

- [CSV Format Specification](https://tools.ietf.org/html/rfc4180)
- [String.split() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/String.html#split(java.lang.String))
- [Integer.parseInt() Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String))
- [ArrayList Documentation](https://docs.oracle.com/javase/11/docs/api/java.base/java/util/ArrayList.html)
