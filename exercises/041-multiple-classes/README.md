# Exercise 041: Multiple Classes Interaction

## Overview

Real-world applications rarely involve just one class. Objects need to work together - students enroll in courses, customers place orders, players join teams. In this exercise, you'll create two classes that interact: `Student` and `Course`. Students can enroll in courses, and courses track their enrolled students. This introduces you to **bidirectional relationships** and multi-class design.

## What You're Learning

### Class Relationships

When classes interact, they form relationships:

**One-to-Many Relationship**: One course has many students
```java
class Course {
    private ArrayList<Student> students;  // Course knows about students
}
```

**Many-to-Many Relationship**: Students can enroll in multiple courses, courses have multiple students
```java
class Student {
    private ArrayList<Course> courses;  // Student knows about courses
}

class Course {
    private ArrayList<Student> students;  // Course knows about students
}
```

### Object References

Objects can store references to other objects:

```java
Student alice = new Student("Alice", "S001");
Course java = new Course("Java Programming", "CS101");

// Course stores reference to Student
java.enrollStudent(alice);

// Now the course "knows about" Alice
```

### Bidirectional Updates

When objects interact, you often need to update both sides:

```java
public void enrollStudent(Student student) {
    // Add student to course's list
    this.students.add(student);

    // Add course to student's list (bidirectional)
    student.addCourse(this);
}
```

### Avoiding Duplicate Enrollments

Before adding, check if already exists:

```java
public void enrollStudent(Student student) {
    if (!students.contains(student)) {  // Check for duplicate
        students.add(student);
        student.addCourse(this);
    }
}
```

### Working with Multiple Classes

Each class should:
- **Encapsulate its own data** (private fields)
- **Provide methods** for interaction
- **Validate inputs** before making changes
- **Maintain consistent state** (if Student is in Course's list, Course should be in Student's list)

## Your Challenge

Create two classes that work together:

### Class 1: Student

**Fields** (private):
- `name` (String) - student's name
- `studentId` (String) - unique ID
- `enrolledCourses` (ArrayList<Course>) - courses student is enrolled in

**Constructor**:
- `Student(String name, String studentId)`
- Validate: name not null/empty (use "Unknown" as default)
- Validate: studentId not null/empty (use "ID000" as default)
- Initialize empty enrolledCourses ArrayList

**Methods**:
- `getName()` - return name
- `getStudentId()` - return studentId
- `getEnrolledCourses()` - return list of courses
- `addCourse(Course course)` - add course to student's list (don't add if null or already enrolled)
- `getCourseCount()` - return number of enrolled courses
- `isEnrolledIn(Course course)` - return true if student is enrolled in the course
- `toString()` - return "Student[name=..., id=...]"

### Class 2: Course

**Fields** (private):
- `courseName` (String) - name of the course
- `courseCode` (String) - course code
- `enrolledStudents` (ArrayList<Student>) - students enrolled in this course

**Constructor**:
- `Course(String courseName, String courseCode)`
- Validate: courseName not null/empty (use "Untitled Course" as default)
- Validate: courseCode not null/empty (use "CODE000" as default)
- Initialize empty enrolledStudents ArrayList

**Methods**:
- `getCourseName()` - return course name
- `getCourseCode()` - return course code
- `getEnrolledStudents()` - return list of students
- `enrollStudent(Student student)` - enroll student in course (bidirectional - add course to student too!)
- `getStudentCount()` - return number of enrolled students
- `isStudentEnrolled(Student student)` - return true if student is enrolled
- `toString()` - return "Course[name=..., code=...]"

## Requirements

- All fields must be private
- Constructors must validate inputs
- `enrollStudent()` must update both Course and Student (bidirectional)
- Prevent duplicate enrollments (student enrolled in same course twice)
- Handle null inputs gracefully (don't add null objects)
- Both classes need `toString()` methods

## Expected Behavior

```java
// Create students
Student alice = new Student("Alice", "S001");
Student bob = new Student("Bob", "S002");

// Create courses
Course java = new Course("Java Programming", "CS101");
Course python = new Course("Python Basics", "CS102");

// Enroll students in courses
java.enrollStudent(alice);
java.enrollStudent(bob);
python.enrollStudent(alice);

// Check enrollments from Course perspective
System.out.println(java.getStudentCount());  // 2
System.out.println(python.getStudentCount()); // 1
System.out.println(java.isStudentEnrolled(alice));  // true

// Check enrollments from Student perspective
System.out.println(alice.getCourseCount());  // 2 (Java and Python)
System.out.println(bob.getCourseCount());    // 1 (Java only)
System.out.println(alice.isEnrolledIn(java));  // true

// Get lists
ArrayList<Student> javaStudents = java.getEnrolledStudents();
System.out.println(javaStudents.size());  // 2

ArrayList<Course> aliceCourses = alice.getEnrolledCourses();
System.out.println(aliceCourses.size());  // 2

// Test toString
System.out.println(alice);  // Student[name=Alice, id=S001]
System.out.println(java);   // Course[name=Java Programming, code=CS101]
```

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

The tests will check:
- Both classes properly encapsulate data
- Constructors validate inputs
- `enrollStudent()` creates bidirectional relationship
- Duplicate enrollments are prevented
- All getter methods work correctly
- `toString()` methods return correct format

## Hints

<details>
<summary>Hint 1: Student Class Structure</summary>

```java
import java.util.ArrayList;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> enrolledCourses;

    public Student(String name, String studentId) {
        // Validate and set fields
        // Initialize ArrayList
    }
}
```
</details>

<details>
<summary>Hint 2: Course enrollStudent() Method</summary>

```java
public void enrollStudent(Student student) {
    if (student == null) return;

    if (!enrolledStudents.contains(student)) {
        enrolledStudents.add(student);
        student.addCourse(this);  // Bidirectional update!
    }
}
```
</details>

<details>
<summary>Hint 3: Student addCourse() Method</summary>

```java
public void addCourse(Course course) {
    if (course == null) return;

    if (!enrolledCourses.contains(course)) {
        enrolledCourses.add(course);
    }
}
```

Note: This method doesn't call `course.enrollStudent()` to avoid infinite loop!
</details>

<details>
<summary>Hint 4: Checking Enrollment</summary>

```java
public boolean isEnrolledIn(Course course) {
    return enrolledCourses.contains(course);
}
```
</details>

## Reflection Questions

After completing this exercise, consider:

1. Why do we need to update both objects when enrolling a student in a course?
2. What would happen if `enrollStudent()` called `student.addCourse()`, which then called `course.enrollStudent()` again?
3. How does the `contains()` method know if a Student/Course is already in the list? (Hint: What method does it use?)
4. Why is it important to prevent duplicate enrollments?
5. How would you extend this design to track grades for each student in each course?

## Next Steps

Congratulations! You've completed the Object-Oriented Programming fundamentals series. You now understand:
- Classes and objects
- Encapsulation and data hiding
- Object methods and overriding
- Collections of objects
- Multi-class interactions

In the next series, you'll apply these OOP concepts to build a complete Bank Account system with account management, transactions, and more!

## Read More

- [Oracle Java Tutorial - Relationships Between Objects](https://docs.oracle.com/javase/tutorial/java/concepts/object.html)
- [Object Composition](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
- [Designing Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classdecl.html)
- [ArrayList contains() Method](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#contains-java.lang.Object-)
