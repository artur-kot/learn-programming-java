# Exercise 034: To-Do List - Enhanced Features

## Introduction

Your basic to-do list works great, but real to-do apps need more power. Think about how you use tasks in real life: some are urgent (high priority), some are already done (completed), and you often want to see just your unfinished work or generate a quick summary of your progress.

In this exercise, you'll enhance your to-do list with advanced features that make it truly useful: marking tasks complete, assigning priority levels, filtering by status, and generating summary reports.

This builds directly on Exercise 033, so you'll use everything you learned about ArrayList operations and expand it with more sophisticated state management and data manipulation.

## What You're Learning

### State Management with String Encoding

Each task now has **state** - information beyond just the description. Tasks can be completed or incomplete, high priority or low priority. We need to store this state somehow.

One approach is using **string encoding** - embedding state information directly in the task string:

```java
"[DONE] Buy milk"           // Completed task
"Buy milk"                  // Incomplete task
"[HIGH] Study for exam"     // High priority task
"[LOW] Water plants"        // Low priority task
```

The prefix indicates the state. Your code must:
- **Add** prefixes when creating tasks
- **Check** prefixes when filtering
- **Update** prefixes when marking complete
- **Parse** the actual task description from the formatted string

### Conditional Updates

Unlike simple additions or removals, **updating** requires finding the right item and modifying it in place:

```java
tasks.set(index, newValue);  // Replace item at index
```

When marking a task complete, you're not removing it - you're changing its state. This is the **U** (Update) in CRUD operations.

### Filtering and Data Presentation

**Filtering** means creating a subset of data that matches certain criteria:

```java
// From: ["Buy milk", "[DONE] Study", "Exercise", "[DONE] Call mom"]
// Get only completed: ["[DONE] Study", "[DONE] Call mom"]
// Get only incomplete: ["Buy milk", "Exercise"]
```

You'll create new lists containing only items that meet your filter conditions. This doesn't modify the original list - it creates a filtered view.

### Data Aggregation and Reporting

**Aggregation** means analyzing data to produce summary statistics. Your summary report should answer:
- How many tasks total?
- How many completed?
- How many remaining?
- What percentage is done?

This helps users understand their progress at a glance.

## Challenge

Enhance your to-do list by implementing five advanced methods. You'll work with tasks that can be marked complete and assigned priority levels.

Your `TodoEnhanced` class should implement all methods from Exercise 033 (add, view, remove, count) **plus** these new capabilities:

1. **Mark tasks complete** - toggle completion status
2. **Add tasks with priority** - assign HIGH, MEDIUM, or LOW priority
3. **Filter by status** - get only completed or incomplete tasks
4. **Count completed tasks** - track progress
5. **Generate summary report** - show overview statistics

## Requirements

Implement these methods in `TodoEnhanced.java`:

### 1. `void markComplete(ArrayList<String> tasks, int index)`
- Toggle the completion status of the task at the given index
- If task starts with "[DONE] ", remove that prefix (mark incomplete)
- Otherwise, add "[DONE] " prefix (mark complete)
- Validate index first (same as removeTask)
- If invalid, print: `Invalid index.`

**Example:**
```java
tasks = ["Buy milk", "[DONE] Study"];
markComplete(tasks, 0);  // Now: ["[DONE] Buy milk", "[DONE] Study"]
markComplete(tasks, 0);  // Now: ["Buy milk", "[DONE] Study"]
```

### 2. `void addTaskWithPriority(ArrayList<String> tasks, String task, String priority)`
- Add a task with a priority prefix
- Priority should be "HIGH", "MEDIUM", or "LOW"
- Format: `[HIGH] Task description`
- If priority is invalid, default to MEDIUM
- Validate that task is not null or empty

**Example:**
```java
addTaskWithPriority(tasks, "Study for exam", "HIGH");
// Adds: "[HIGH] Study for exam"
```

### 3. `ArrayList<String> filterByStatus(ArrayList<String> tasks, boolean completed)`
- Return a new ArrayList containing only tasks matching the status
- If `completed` is true, return only tasks starting with "[DONE] "
- If `completed` is false, return only tasks NOT starting with "[DONE] "
- Original list should not be modified

**Example:**
```java
tasks = ["Buy milk", "[DONE] Study", "Exercise"];
filterByStatus(tasks, true);   // Returns: ["[DONE] Study"]
filterByStatus(tasks, false);  // Returns: ["Buy milk", "Exercise"]
```

### 4. `int getCompletedCount(ArrayList<String> tasks)`
- Return the number of tasks marked as complete
- Count tasks that start with "[DONE] "
- Return 0 if list is null or empty

**Example:**
```java
tasks = ["Buy milk", "[DONE] Study", "[DONE] Exercise"];
getCompletedCount(tasks);  // Returns: 2
```

### 5. `String generateSummary(ArrayList<String> tasks)`
- Return a formatted summary string with statistics
- Include: total tasks, completed, remaining, completion percentage
- Format:
```
=== To-Do List Summary ===
Total tasks: 5
Completed: 3
Remaining: 2
Progress: 60%
```
- If list is empty, return: `No tasks to summarize.`

## Expected Behavior

Here's how the enhanced features work together:

```java
ArrayList<String> myTasks = new ArrayList<>();
TodoEnhanced todo = new TodoEnhanced();

// Add tasks with priority
todo.addTaskWithPriority(myTasks, "Study for exam", "HIGH");
todo.addTaskWithPriority(myTasks, "Water plants", "LOW");
todo.addTask(myTasks, "Buy groceries");

// Mark one complete
todo.markComplete(myTasks, 0);  // Mark "Study for exam" as done

// View all tasks
todo.viewTasks(myTasks);
// Output:
// 1. [DONE] [HIGH] Study for exam
// 2. [LOW] Water plants
// 3. Buy groceries

// Filter completed
ArrayList<String> completed = todo.filterByStatus(myTasks, true);
// Returns: ["[DONE] [HIGH] Study for exam"]

// Generate summary
System.out.println(todo.generateSummary(myTasks));
// Output:
// === To-Do List Summary ===
// Total tasks: 3
// Completed: 1
// Remaining: 2
// Progress: 33%
```

## Hints

<details>
<summary>Hint 1: Checking String Prefixes</summary>

Use `startsWith()` to check if a string begins with a prefix:

```java
if (task.startsWith("[DONE] ")) {
    // This task is completed
}
```

To remove a prefix, use `substring()`:
```java
String withoutPrefix = task.substring(7);  // Removes "[DONE] "
```

</details>

<details>
<summary>Hint 2: Toggling Completion Status</summary>

Get the current task, check its status, then set a new value:

```java
String task = tasks.get(index);
if (task.startsWith("[DONE] ")) {
    // Remove prefix
    tasks.set(index, task.substring(7));
} else {
    // Add prefix
    tasks.set(index, "[DONE] " + task);
}
```

</details>

<details>
<summary>Hint 3: Filtering Lists</summary>

Create a new ArrayList and add only matching items:

```java
ArrayList<String> filtered = new ArrayList<>();
for (String task : tasks) {
    if (task.startsWith("[DONE] ")) {
        filtered.add(task);
    }
}
return filtered;
```

</details>

<details>
<summary>Hint 4: Calculating Percentage</summary>

Convert to double before dividing to get decimal result:

```java
int total = tasks.size();
int completed = getCompletedCount(tasks);
double percentage = (completed * 100.0) / total;
// Format: (int)percentage + "%"
```

</details>

<details>
<summary>Hint 5: Building Multi-line Strings</summary>

Use string concatenation or StringBuilder:

```java
String summary = "=== To-Do List Summary ===\n";
summary += "Total tasks: " + total + "\n";
summary += "Completed: " + completed + "\n";
// etc.
```

</details>

## How to Test Your Solution

**Using Maven (Recommended):**
```bash
cd exercises/034-todo-enhanced
mvn test
```

The tests verify:
- Tasks can be marked complete and incomplete
- Priority levels are added correctly
- Filtering returns correct subsets
- Completed count is accurate
- Summary report format is correct
- Integration of all features works

## Reflection Questions

After completing this exercise, consider:

1. **Why use string prefixes instead of a separate Task class?** What are the trade-offs?
2. **What happens if a task already has multiple prefixes?** How would you handle "[HIGH] [DONE] Task"?
3. **How does filtering create a new list rather than modifying the original?** Why is this useful?
4. **What would you need to change to add more priority levels** (like URGENT or LOWEST)?
5. **How would you sort tasks by priority or completion status?**

## Next Steps

You've now built a fully functional to-do list application with advanced features! To continue improving:

- Add persistent storage (save tasks to a file)
- Implement due dates and reminders
- Add categories or tags for tasks
- Create a search function to find specific tasks
- Build a user interface with a menu system

These enhancements would make your to-do list even more powerful and user-friendly!

## Useful Prompts

- What are the advantages of using a Task class versus string encoding?
- How would you implement multi-criteria filtering (priority AND completion)?
- What data structures could improve performance for large task lists?
- How would you implement undo/redo functionality?

## Read More

- [String manipulation in Java](https://docs.oracle.com/javase/tutorial/java/data/strings.html)
- [ArrayList advanced operations](https://www.baeldung.com/java-arraylist)
- [State management patterns](https://en.wikipedia.org/wiki/State_pattern)
- [Data filtering and transformation techniques](https://www.baeldung.com/java-stream-filter-lambda)
