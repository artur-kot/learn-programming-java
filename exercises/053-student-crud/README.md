# Exercise 053: Student Class & CRUD Operations

## Introduction

Imagine you're tasked with building a student records system for a small classroom. Teachers need to keep track of students and their grades, and they need an easy way to add new students, remove them when they transfer, and search for specific students. This is a common real-world scenario that perfectly demonstrates the power of object-oriented programming combined with collections.

## What You're Learning

**Object-Oriented Modeling:**
When we model real-world entities in code, we create classes that represent those entities. A `Student` class represents a real student with properties like an ID, name, and grades. This approach helps organize complex data and makes your code more intuitive and maintainable.

**CRUD Operations:**
CRUD stands for Create, Read, Update, and Delete—the four basic operations you can perform on data. In this exercise, you'll implement:
- **Create**: Adding new students to your system
- **Read**: Viewing and searching for students
- **Update**: Modifying student information (like adding grades)
- **Delete**: Removing students from the system

**Collections in Practice:**
You'll use `ArrayList` to store multiple students and multiple grades for each student. This demonstrates how collections can hold both primitive data and custom objects, making them incredibly versatile.

**Encapsulation:**
By using private fields with public methods (getters/setters), you protect the data inside your objects. This prevents accidental corruption and allows you to add validation logic when data changes.

## Challenge

Build a student management system with two classes:

1. **Student class** - represents a single student with ID, name, and grades
2. **StudentManager class** - manages a collection of students and provides CRUD operations

Your system should allow teachers to add students, remove them, search for specific students, and view all students in the classroom.

## Requirements

### Student Class
- Private fields: `id` (int), `name` (String), `grades` (ArrayList&lt;Double&gt;)
- Constructor that accepts id and name (initialize grades as empty ArrayList)
- Getter methods for all fields
- `addGrade(double grade)` method to add a grade to the student's list
- `toString()` method that returns a formatted string representation

### StudentManager Class
- Private field: `students` (ArrayList&lt;Student&gt;)
- Constructor that initializes the students list
- `addStudent(Student student)` - adds a student to the collection
- `removeStudent(int id)` - removes a student by their ID, returns true if found and removed
- `findStudent(int id)` - searches for and returns a student by ID (or null if not found)
- `listAllStudents()` - prints all students in a formatted list

## Hints

<details>
<summary>Hint 1: Student Class Structure</summary>

Your Student class needs three private fields and should initialize the grades ArrayList in the constructor:
```java
private int id;
private String name;
private ArrayList<Double> grades;

public Student(int id, String name) {
    this.id = id;
    this.name = name;
    this.grades = new ArrayList<>();
}
```

</details>

<details>
<summary>Hint 2: Finding a Student</summary>

To find a student by ID, loop through the ArrayList and compare each student's ID:
```java
for (Student student : students) {
    if (student.getId() == id) {
        return student;
    }
}
return null;  // Not found
```

</details>

<details>
<summary>Hint 3: Removing a Student</summary>

Use the `findStudent()` method you already created, then use ArrayList's `remove()` method. Return true if the student was found and removed, false otherwise.

</details>

## Expected Behavior

**Adding and listing students:**
```
Added students to the system...

All Students:
1. Student{id=101, name='Alice Johnson', grades=[95.0, 88.5, 92.0]}
2. Student{id=102, name='Bob Smith', grades=[78.0, 85.5]}
3. Student{id=103, name='Charlie Davis', grades=[]}
```

**Finding a student:**
```
Found: Student{id=102, name='Bob Smith', grades=[78.0, 85.5]}
```

**Removing a student:**
```
Student with ID 102 removed successfully
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/053-student-crud
mvn test
```

**Manual Testing:**
```bash
cd exercises/053-student-crud/src
javac StudentManager.java Student.java
java StudentManager
```

## Reflection Questions

1. **Why use a class?** What are the advantages of using a `Student` class instead of just storing student data in separate ArrayLists (one for IDs, one for names, one for grades)?

2. **Encapsulation benefits:** How does making fields private and providing getter/setter methods help protect your data?

3. **Object references:** When you add a Student to the ArrayList in StudentManager, are you storing a copy of the student or a reference to the original object? What's the difference?

4. **Search efficiency:** The current search method loops through all students. For a large school with thousands of students, would this be efficient? What data structure could improve search performance?

## Next Steps

Congratulations! You've built a working CRUD system for managing students. In the next exercise, you'll enhance this system by adding statistical analysis—calculating averages, finding top students, and generating reports. The Student and StudentManager classes you built here will be your foundation!

## Read More

- [Oracle Java Tutorial: Classes and Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
- [ArrayList in Java](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Encapsulation in Java](https://www.baeldung.com/java-encapsulation)
- [CRUD Operations Explained](https://www.codecademy.com/article/what-is-crud)
