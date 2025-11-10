# Exercise 054: Statistics & Reporting

## Introduction

You've built a system to manage student records—now it's time to extract insights from that data! Teachers don't just need to store student information; they need to analyze it. Who are the top performers? What's the class average? How is each student doing individually? These are the kinds of questions that turn raw data into actionable information.

## What You're Learning

**Data Aggregation:**
Aggregation means combining multiple pieces of data to produce a summary. When you calculate an average grade, you're aggregating all the individual grades into a single meaningful number. This is a fundamental concept in data processing and analytics.

**Sorting and Comparisons:**
To find the top students, you need to sort your data. Java provides powerful comparison tools, but understanding how to compare custom objects (like students based on their grades) is a crucial skill. You'll learn about comparators and how to order data in meaningful ways.

**Algorithm Design:**
You'll implement algorithms to process collections of data—calculating averages, finding maximums and minimums, and filtering data based on criteria. These are building blocks for more complex data processing tasks.

**Reporting:**
Transforming data into human-readable reports is an essential skill. Good reports present information clearly, format numbers appropriately, and tell a story with the data.

## Challenge

Extend the student management system from Exercise 053 with statistical analysis and reporting capabilities. You'll add methods to calculate averages, identify top performers, and generate comprehensive reports for both individual students and entire classes.

This exercise builds directly on Exercise 053—you'll use the same `Student` and `StudentManager` classes as your foundation.

## Requirements

### StudentStats Class
Create a new class with these static methods:

- `getAverageGrade(Student student)` - calculates and returns the average of a student's grades
- `getTopStudents(StudentManager manager, int n)` - returns an ArrayList of the top N students sorted by average grade (highest first)
- `getClassAverage(StudentManager manager)` - calculates the average grade across all students in the class
- `generateStudentReport(Student student)` - prints a formatted report for an individual student
- `generateClassReport(StudentManager manager)` - prints comprehensive statistics for the entire class

## Hints

<details>
<summary>Hint 1: Calculating Average</summary>

To calculate an average, sum all grades and divide by the count:
```java
double sum = 0;
for (double grade : student.getGrades()) {
    sum += grade;
}
double average = sum / student.getGrades().size();
```

Handle the edge case where a student has no grades (avoid division by zero).

</details>

<details>
<summary>Hint 2: Sorting Students</summary>

You can use a loop to find the student with the highest average, add them to your result list, then repeat for the next highest. Or create a temporary list and use `Collections.sort()` with a custom comparator.

</details>

<details>
<summary>Hint 3: Class Average</summary>

Calculate the average grade for each student, sum those averages, then divide by the number of students. Or calculate the total of all grades from all students and divide by the total number of grades.

</details>

<details>
<summary>Hint 4: Formatting Reports</summary>

Use `System.out.printf()` for nice formatting:
```java
System.out.printf("Average: %.2f%n", average);
```

This displays the average with 2 decimal places.

</details>

## Expected Behavior

**Getting student average:**
```
Student: Alice Johnson
Average Grade: 91.83
```

**Top students:**
```
Top 3 Students:
1. Alice Johnson - Average: 91.83
2. Bob Smith - Average: 81.75
3. Charlie Davis - Average: 79.50
```

**Individual student report:**
```
========================================
Student Report: Alice Johnson (ID: 101)
========================================
Grades: [95.0, 88.5, 92.0]
Number of Grades: 3
Average Grade: 91.83
Status: Excellent
========================================
```

**Class report:**
```
========================================
Class Statistics Report
========================================
Total Students: 5
Class Average: 84.25
Highest Average: 91.83 (Alice Johnson)
Lowest Average: 72.50 (Eva Williams)
Students with A average (90+): 2
Students with B average (80-89): 1
Students with C average (70-79): 2
========================================
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/054-student-stats
mvn test
```

**Manual Testing:**
```bash
cd exercises/054-student-stats/src
javac Student.java StudentManager.java StudentStats.java
java StudentStats
```

## Reflection Questions

1. **Edge cases:** What happens if a student has no grades? How should you handle calculating an average in this case? Should it return 0, or something else?

2. **Efficiency:** If you need to get the top students multiple times, would it be more efficient to sort the list once and reuse it, or sort each time? What are the trade-offs?

3. **Data integrity:** Notice that these methods don't modify the original data—they only read it. Why is this good practice?

4. **Design patterns:** The methods in StudentStats are static. What does this mean, and why might it be a good choice for utility functions like these?

## Next Steps

Excellent work! You've transformed your student management system into an analytics tool that provides real insights. In the next exercise, you'll add the final piece—data persistence. You'll learn to save your student data to files and load it back, ensuring that your hard work isn't lost when the program ends!

## Read More

- [Java Stream API for Data Processing](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)
- [Comparator and Comparable in Java](https://www.baeldung.com/java-comparator-comparable)
- [String Formatting in Java](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html)
- [Data Aggregation Patterns](https://en.wikipedia.org/wiki/Aggregate_function)
