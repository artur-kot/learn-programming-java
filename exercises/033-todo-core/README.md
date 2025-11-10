# Exercise 033: To-Do List - Core Functionality

## Introduction

Imagine you have a pile of sticky notes with tasks scattered everywhere. You keep losing them, forgetting what needs to be done, and have no idea what you've already finished. A to-do list application solves this problem by organizing all your tasks in one place where you can add new tasks, view them all at once, remove completed ones, and always know how much you have to do.

In this exercise, you'll build the core functionality of a to-do list manager. You'll work with one of the most important data structures in Java: the **ArrayList** - a flexible list that can grow or shrink as you add or remove items.

## What You're Learning

### ArrayList - Dynamic Lists in Java

Unlike arrays which have fixed sizes, an **ArrayList** is a resizable list that grows automatically as you add elements:

```java
ArrayList<String> tasks = new ArrayList<>();
tasks.add("Buy milk");       // List grows to hold 1 item
tasks.add("Study Java");     // Now holds 2 items
tasks.remove(0);             // Now holds 1 item
```

**Why ArrayList matters:**
- Arrays require knowing the size in advance: `String[] tasks = new String[10]` (what if you need 11?)
- ArrayList grows dynamically - add as many items as you need
- Built-in methods make it easy to add, remove, and access elements
- Essential for managing collections of data in real applications

### CRUD Operations

You'll implement the fundamental operations for managing data - collectively known as **CRUD**:
- **C**reate: Add new tasks
- **R**ead: View existing tasks
- **U**pdate: (Next exercise - modifying tasks)
- **D**elete: Remove tasks

These operations form the foundation of almost every application that manages data - from social media apps to banking systems.

### Indexed Data and Validation

When working with lists, each item has a position (index). Index 0 is the first item, index 1 is the second, and so on:

```
Index:  0           1              2
Tasks: ["Buy milk", "Study Java", "Exercise"]
```

**Validation** means checking that user input is safe and valid before using it. For example:
- Does the task index exist in the list?
- Is the input empty or null?
- Is the index negative?

Always validate before performing operations to prevent crashes and errors.

## Challenge

Build a to-do list manager with four core methods. Each method operates on an ArrayList of tasks (strings).

Your `TodoList` class should implement:

1. **Add tasks** to the list
2. **View all tasks** with numbered display (1, 2, 3...)
3. **Remove tasks** by index with validation
4. **Count tasks** in the list

## Requirements

Implement these methods in `TodoList.java`:

### 1. `void addTask(ArrayList<String> tasks, String task)`
- Add the given task to the end of the list
- Do nothing if task is null or empty

### 2. `void viewTasks(ArrayList<String> tasks)`
- Print each task with a number starting from 1
- Format: `1. Buy milk`
- If list is empty, print: `No tasks to display.`

### 3. `void removeTask(ArrayList<String> tasks, int index)`
- Remove the task at the given index (0-based)
- Validate the index first:
  - Must be >= 0
  - Must be < tasks.size()
- If invalid, print error message: `Invalid index.`

### 4. `int getTaskCount(ArrayList<String> tasks)`
- Return the number of tasks in the list
- Return 0 if list is null

## Expected Behavior

Here's how your methods should work together:

```java
ArrayList<String> myTasks = new ArrayList<>();

// Add tasks
addTask(myTasks, "Buy groceries");
addTask(myTasks, "Study Java");
addTask(myTasks, "Call dentist");

// View tasks
viewTasks(myTasks);
// Output:
// 1. Buy groceries
// 2. Study Java
// 3. Call dentist

// Count tasks
System.out.println(getTaskCount(myTasks)); // 3

// Remove a task
removeTask(myTasks, 1); // Removes "Study Java"
viewTasks(myTasks);
// Output:
// 1. Buy groceries
// 2. Call dentist

// Try invalid removal
removeTask(myTasks, 10); // Prints: Invalid index.
```

## Hints

<details>
<summary>Hint 1: ArrayList Basics</summary>

To add an item to an ArrayList:
```java
tasks.add(item);
```

To get the size:
```java
int count = tasks.size();
```

To remove by index:
```java
tasks.remove(index);
```

To access an item by index:
```java
String task = tasks.get(index);
```

</details>

<details>
<summary>Hint 2: Displaying with Numbers</summary>

Use a loop to iterate through the list. Display numbers starting from 1 (not 0):

```java
for (int i = 0; i < tasks.size(); i++) {
    int displayNumber = i + 1;  // Convert index to display number
    String task = tasks.get(i);
    System.out.println(displayNumber + ". " + task);
}
```

</details>

<details>
<summary>Hint 3: Validating Index</summary>

Before removing, check if the index is valid:

```java
if (index < 0 || index >= tasks.size()) {
    // Invalid - print error
} else {
    // Valid - proceed with removal
}
```

Remember: valid indices are 0 to (size - 1).

</details>

<details>
<summary>Hint 4: Checking Empty Strings</summary>

To check if a string is null or empty:

```java
if (task == null || task.isEmpty()) {
    return; // Don't add it
}
```

</details>

## How to Test Your Solution

**Using Maven (Recommended):**
```bash
cd exercises/033-todo-core
mvn test
```

The tests verify:
- Tasks are added correctly
- Tasks display with proper numbering
- Invalid tasks are rejected
- Tasks are removed correctly
- Invalid indices are handled
- Task count is accurate

## Reflection Questions

After completing this exercise, consider:

1. **Why use ArrayList instead of a regular array?** What advantages does it provide?
2. **Why start display numbers at 1 instead of 0?** Think about user experience.
3. **What happens if you remove an item at index 1?** How do the other indices change?
4. **Why validate the index before removing?** What would happen without validation?
5. **How would you modify this to store task descriptions longer than one line?**

## Next Steps

Once you've completed this exercise, you're ready for Exercise 034 where you'll enhance your to-do list with:
- Marking tasks as complete
- Adding priority levels
- Filtering by completion status
- Generating summary reports

These features build directly on the foundation you've created here!

## Useful Prompts

- How does ArrayList manage memory internally?
- What's the difference between ArrayList and LinkedList?
- What are generics in Java and why do we use ArrayList<String>?
- How does remove() affect the indices of remaining elements?

## Read More

- [ArrayList Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- [Java Collections Framework Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Working with ArrayLists Tutorial](https://www.baeldung.com/java-arraylist)
