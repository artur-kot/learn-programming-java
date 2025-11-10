# Exercise 037: Define a Class

## Overview

You're about to take your first step into Object-Oriented Programming! Instead of working with simple variables scattered throughout your code, you'll create a **User** class that bundles related data together. Think of a class as a blueprint for creating objects - like a cookie cutter that defines the shape of cookies.

## What You're Learning

### Classes and Objects

A **class** is a template that defines what data (fields) and behaviors (methods) objects of that type will have. An **object** is a specific instance created from that class.

Think of it like this:
- **Class** = Blueprint for a house (defines what a house has: rooms, doors, windows)
- **Object** = An actual house built from that blueprint

In Java, a basic class looks like this:

```java
public class ClassName {
    // Fields (data the object stores)
    // Constructor (how to create the object)
    // Methods (what the object can do)
}
```

### Fields (Instance Variables)

Fields are variables that belong to each object. Every object created from the class gets its own copy of these fields.

```java
public class Book {
    String title;    // Each Book object has its own title
    int pages;       // Each Book object has its own page count
}
```

### Constructors

A **constructor** is a special method that runs when you create a new object. It initializes the object's fields with values.

```java
public class Book {
    String title;
    int pages;

    // Constructor - same name as class, no return type
    public Book(String bookTitle, int pageCount) {
        title = bookTitle;
        pages = pageCount;
    }
}
```

### The `this` Keyword

When constructor parameter names match field names, use `this` to distinguish them:

```java
public Book(String title, int pages) {
    this.title = title;  // this.title = field, title = parameter
    this.pages = pages;  // this.pages = field, pages = parameter
}
```

`this` refers to "this current object" - the object being created or worked with.

### Creating Objects

Once you have a class, you create objects using the `new` keyword:

```java
Book myBook = new Book("Harry Potter", 300);
// Creates a Book object with title "Harry Potter" and 300 pages
```

### Accessing Fields and Methods

Use the dot (`.`) operator to access an object's fields and methods:

```java
System.out.println(myBook.title);    // Access field
System.out.println(myBook.getPages()); // Call method
```

## Your Challenge

Create a `User` class that represents a user in a system. Your class should:

1. **Have two fields**:
   - `name` (String) - the user's name
   - `age` (int) - the user's age

2. **Have a constructor** that:
   - Accepts two parameters: name and age
   - Uses the `this` keyword to assign parameters to fields

3. **Have getter methods**:
   - `getName()` - returns the user's name
   - `getAge()` - returns the user's age

4. **Have a `displayInfo()` method** that:
   - Prints the user's information in the format: "Name: [name], Age: [age]"

## Requirements

- Fields should be public (we'll learn about private fields in the next exercise)
- Constructor must use `this` keyword when parameter names match field names
- All methods must be public
- `displayInfo()` should use `System.out.println()`

## Expected Behavior

```java
User user1 = new User("Alice", 25);
user1.displayInfo();  // Output: Name: Alice, Age: 25

User user2 = new User("Bob", 30);
System.out.println(user2.getName());  // Output: Bob
System.out.println(user2.getAge());   // Output: 30
```

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

The tests will check:
- Constructor properly initializes fields
- Getter methods return correct values
- `displayInfo()` prints the correct format
- Multiple User objects can be created independently

## Hints

<details>
<summary>Hint 1: Class Structure</summary>

Start with the class declaration and fields:
```java
public class User {
    // Declare two fields here: name and age
}
```
</details>

<details>
<summary>Hint 2: Constructor</summary>

The constructor has the same name as the class and no return type:
```java
public User(String name, int age) {
    // Use this.fieldName = parameterName;
}
```
</details>

<details>
<summary>Hint 3: Getter Methods</summary>

Getters simply return the value of a field:
```java
public String getName() {
    return name;  // or return this.name;
}
```
</details>

<details>
<summary>Hint 4: displayInfo() Method</summary>

Use string concatenation or formatted printing:
```java
public void displayInfo() {
    System.out.println("Name: " + name + ", Age: " + age);
}
```
</details>

## Reflection Questions

After completing this exercise, consider:

1. Why is bundling related data (name and age) into a class better than using separate variables?
2. What happens if you create two User objects with different values? Do they share the same data or have their own copies?
3. Why do we need the `this` keyword when parameter names match field names?
4. How is a constructor different from a regular method?

## Next Steps

In the next exercise, you'll learn about **encapsulation** - making fields private and controlling access through getters and setters. This is a crucial principle of Object-Oriented Programming that protects your data from invalid values!

## Read More

- [Oracle Java Tutorial - Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [Oracle Java Tutorial - Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)
- [Oracle Java Tutorial - Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Understanding the `this` keyword](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html)
