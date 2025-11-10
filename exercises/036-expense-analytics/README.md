# Exercise 036: Expense Tracker - Analytics

## Overview

Now that you can store and manage expense data (Exercise 035), it's time to analyze it! In this exercise, you'll add powerful analytics features: filtering by category, finding the highest and lowest expenses, calculating averages, checking budgets, and generating summary reports. These are the same techniques used in data analysis and business intelligence applications.

## What You're Learning

### Filtering Collections

Filtering means creating a new collection containing only items that match certain criteria:

```java
// Get all "Food" expenses from the full list
ArrayList<String> foodExpenses = filterByCategory(allExpenses, "Food");
```

The pattern:
1. Create a new empty list for results
2. Loop through the original list
3. Check each item against your criteria
4. If it matches, add it to the results list
5. Return the results list

### Finding Maximum and Minimum

Finding the largest or smallest value requires comparing each item:

```java
double max = 0;  // Start with a base value
for (each item) {
    double amount = /* extract amount from item */;
    if (amount > max) {
        max = amount;  // Found a new maximum
    }
}
```

**Important:** Initialize your max to a very small number (or the first item) to handle negative values correctly.

### Calculating Averages

Average = Sum divided by Count

```java
double total = getTotalExpenses(expenses);
int count = getExpenseCount(expenses);
double average = total / count;  // Be careful with division by zero!
```

### Conditional Logic for Business Rules

Business rules are conditions that trigger actions:

```java
if (totalExpenses > budget) {
    return "Warning: Over budget!";
}
```

This is how real applications enforce rules and provide alerts.

### Building Reports

Reports combine multiple data points into a formatted summary:

```java
System.out.println("=== Expense Report ===");
System.out.println("Total: $" + total);
System.out.println("Average: $" + average);
System.out.println("Highest: $" + highest);
```

## Your Task

Building on Exercise 035, implement these analytics methods:

### 1. `filterByCategory(ArrayList<String> expenses, String category)`
Return a new ArrayList containing only expenses from the specified category.

**Example:**
```java
// expenses: ["Food:25.50", "Transport:15.00", "Food:30.00"]
ArrayList<String> foodExpenses = filterByCategory(expenses, "Food");
// foodExpenses: ["Food:25.50", "Food:30.00"]
```

### 2. `findHighestExpense(ArrayList<String> expenses)`
Return the amount of the highest expense.

**Example:**
```java
// expenses: ["Food:25.50", "Transport:15.00", "Entertainment:40.00"]
double highest = findHighestExpense(expenses);
// highest = 40.00
```

### 3. `findLowestExpense(ArrayList<String> expenses)`
Return the amount of the lowest expense.

**Example:**
```java
// expenses: ["Food:25.50", "Transport:15.00", "Entertainment:40.00"]
double lowest = findLowestExpense(expenses);
// lowest = 15.00
```

### 4. `getAverageExpense(ArrayList<String> expenses)`
Calculate and return the average expense amount.

**Example:**
```java
// expenses: ["Food:20.00", "Transport:10.00", "Entertainment:30.00"]
double avg = getAverageExpense(expenses);
// avg = 20.00 (total 60.00 / 3 items)
```

### 5. `checkBudget(ArrayList<String> expenses, double budget)`
Return a warning message if total expenses exceed the budget, otherwise return a success message.

**Example:**
```java
// Total expenses: $110.50, Budget: $100.00
String message = checkBudget(expenses, 100.00);
// message = "Warning: You are $10.50 over budget!"

// Total expenses: $80.00, Budget: $100.00
String message = checkBudget(expenses, 100.00);
// message = "Good job! You are $20.00 under budget."
```

### 6. `generateReport(ArrayList<String> expenses)`
Display a comprehensive summary of all expense statistics.

**Example Output:**
```
========================================
          Expense Report
========================================
Total Expenses:   $110.50
Number of Items:  4
Average Expense:  $27.63
Highest Expense:  $40.00
Lowest Expense:   $15.00
========================================
```

## Requirements

1. All methods should handle empty lists gracefully
2. For empty lists:
   - `filterByCategory` returns empty list
   - `findHighestExpense` and `findLowestExpense` return 0.0
   - `getAverageExpense` returns 0.0
3. Budget checking should format amounts with 2 decimal places
4. Report should use formatted output with aligned columns
5. Category filtering should be case-sensitive

## Expected Behavior

```java
ArrayList<String> expenses = new ArrayList<>();
expenses.add("Food:25.50");
expenses.add("Transport:15.00");
expenses.add("Entertainment:40.00");
expenses.add("Food:30.00");

// Filter by category
ArrayList<String> foodOnly = filterByCategory(expenses, "Food");
System.out.println("Food expenses: " + foodOnly.size());  // 2

// Find extremes
System.out.println("Highest: $" + findHighestExpense(expenses));  // 40.00
System.out.println("Lowest: $" + findLowestExpense(expenses));    // 15.00

// Calculate average
System.out.println("Average: $" + getAverageExpense(expenses));   // 27.625

// Check budget
System.out.println(checkBudget(expenses, 100.00));
// "Warning: You are $10.50 over budget!"

// Generate full report
generateReport(expenses);
```

## Testing Instructions

Run the tests to verify your implementation:
```bash
mvn test
```

The tests will verify:
- Filtering returns correct items
- Min/max finding works for various cases
- Average calculation is accurate
- Budget checking returns proper messages
- Report generates without errors
- Edge cases handled (empty lists, single items, etc.)

## Tips

- **Filtering:** Create a new ArrayList, loop through original, check category, add matches
- **Finding max:** Start with 0 or first item, compare each amount, update if larger
- **Finding min:** Start with a large number or first item, compare each amount, update if smaller
- **Average:** Use your existing `getTotalExpenses()` and `getExpenseCount()` methods
- **Budget check:** Calculate total, compare to budget, use if/else for message
- **Report:** Use `printf` for aligned formatting with `%.2f` for currency
- Remember to reuse methods from Exercise 035 (getTotalExpenses, getExpenseCount)

## Challenge Questions

1. How would you find the category with the highest total spending?
2. Could you modify the report to show a breakdown by category?
3. What if you wanted to find the top 3 highest expenses instead of just the highest?
4. How would you implement a monthly budget tracker that compares spending across different months?

## Reflection Questions

After completing this exercise, think about:

1. **How is filtering different from aggregation?** When would you use each?
2. **Why is it important to handle edge cases** like empty lists?
3. **How could these analytics help with real-world budgeting?**
4. **What other types of reports would be useful** for expense tracking?
5. **How would you extend this to track spending trends over time?**

## Next Steps

After mastering expense analytics:
- Combine both exercises (035 and 036) into a full interactive expense tracker app
- Add file I/O to save and load expenses
- Implement date tracking to analyze spending over time
- Create a menu-driven interface for users

## Read More

- [ArrayList filtering patterns](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- [Finding minimum and maximum in collections](https://www.geeksforgeeks.org/find-the-minimum-and-maximum-value-in-an-arraylist/)
- Statistical aggregation: mean, median, mode
- Business intelligence and data analytics basics
- Budget tracking and financial planning methods
