# Exercise 035: Expense Tracker - Data Management

## Overview

You're building a personal expense tracker to manage your spending. In this first part, you'll focus on the core data management: storing expenses, viewing them, and calculating totals. This exercise teaches you how to work with structured data in lists and perform aggregation operations.

## What You're Learning

### Storing Structured Data

When you need to track multiple pieces of information together (like a category and an amount), you have several options:

**Option 1: String Encoding**
```java
// Store as "Category:Amount"
String expense = "Food:25.50";
```

To extract data later:
```java
String[] parts = expense.split(":");
String category = parts[0];      // "Food"
double amount = Double.parseDouble(parts[1]);  // 25.50
```

This is simple and perfect for beginners! You encode data into a string format, then parse it when needed.

### Working with ArrayList

ArrayList lets you store a dynamic list of items (unlike arrays which have fixed size):

```java
ArrayList<String> expenses = new ArrayList<>();
expenses.add("Food:25.50");
expenses.add("Transport:15.00");
expenses.add("Food:30.00");

System.out.println(expenses.size());  // 3
```

### Aggregation: Summing Values

Aggregation means combining multiple values into a single result. The most common aggregation is **summing**:

```java
double total = 0;
for (String item : list) {
    // Extract number from item
    // Add to total
    total += number;
}
```

This is the **accumulator pattern** - you've used it before when summing numbers!

### Filtering Data

Filtering means selecting only items that match certain criteria:

```java
// Count only "Food" expenses
int foodCount = 0;
for (String expense : expenses) {
    String category = /* extract category */;
    if (category.equals("Food")) {
        foodCount++;
    }
}
```

## Your Task

Implement an expense tracker with these core methods:

### 1. `addExpense(ArrayList<String> expenses, String category, double amount)`
Add a new expense to the list using the format "Category:Amount".

**Example:**
```java
addExpense(expenses, "Food", 25.50);
addExpense(expenses, "Transport", 15.00);
// expenses now contains: ["Food:25.50", "Transport:15.00"]
```

### 2. `viewExpenses(ArrayList<String> expenses)`
Display all expenses in a readable format.

**Example Output:**
```
Your Expenses:
1. Food: $25.50
2. Transport: $15.00
3. Food: $30.00
```

### 3. `getTotalExpenses(ArrayList<String> expenses)`
Calculate and return the sum of all expenses.

**Example:**
```java
// If expenses are: Food:25.50, Transport:15.00, Food:30.00
double total = getTotalExpenses(expenses);
// total = 70.50
```

### 4. `getTotalByCategory(ArrayList<String> expenses, String category)`
Calculate the sum of all expenses in a specific category.

**Example:**
```java
// If expenses are: Food:25.50, Transport:15.00, Food:30.00
double foodTotal = getTotalByCategory(expenses, "Food");
// foodTotal = 55.50 (25.50 + 30.00)
```

### 5. `getExpenseCount(ArrayList<String> expenses)`
Return the total number of expenses.

**Example:**
```java
int count = getExpenseCount(expenses);
// count = 3
```

## Requirements

1. Use ArrayList<String> to store expenses
2. Format expenses as "Category:Amount" (e.g., "Food:25.50")
3. All methods should handle empty lists gracefully
4. Category matching should be case-sensitive
5. Amounts should support decimal values
6. viewExpenses should display formatted currency with $ symbol

## Expected Behavior

```java
ArrayList<String> expenses = new ArrayList<>();

addExpense(expenses, "Food", 25.50);
addExpense(expenses, "Transport", 15.00);
addExpense(expenses, "Entertainment", 40.00);
addExpense(expenses, "Food", 30.00);

viewExpenses(expenses);
// Output:
// Your Expenses:
// 1. Food: $25.50
// 2. Transport: $15.00
// 3. Entertainment: $40.00
// 4. Food: $30.00

System.out.println("Total: $" + getTotalExpenses(expenses));
// Output: Total: $110.50

System.out.println("Food Total: $" + getTotalByCategory(expenses, "Food"));
// Output: Food Total: $55.50

System.out.println("Count: " + getExpenseCount(expenses));
// Output: Count: 4
```

## Testing Instructions

Run the tests to verify your implementation:
```bash
mvn test
```

The tests will verify:
- Adding expenses stores them correctly
- Viewing displays proper format
- Total calculation is accurate
- Category totals are correct
- Count returns right number
- Edge cases (empty list, single item, etc.)

## Tips

- Start with `addExpense()` - format the string correctly
- For parsing: use `split(":")` to separate category and amount
- Use `Double.parseDouble()` to convert string amounts to numbers
- Remember the accumulator pattern for summing
- For `viewExpenses()`, use a loop with an index starting at 1 for display
- Test with a small main() method as you implement each function

## Challenge Questions

1. What happens if someone adds an expense with a category containing a colon (`:`)? How would you handle this?
2. Could you modify the format to store dates as well? What would the format look like?
3. How would you add validation to ensure amounts are positive?
4. What if you wanted to support multiple currencies?

## Reflection Questions

After completing this exercise, think about:

1. **Why use string encoding instead of separate variables?** What are the trade-offs?
2. **How would you store expenses if you had 10 pieces of information** (category, amount, date, location, payment method, etc.)?
3. **What makes aggregation useful in real applications?** Can you think of other examples?
4. **How would you modify this to track income as well as expenses?**

## Next Steps

After mastering basic expense data management:
- Move to Exercise 036 to add analytics (filtering, finding min/max, reports)
- Consider how you'd save expenses to a file for persistence
- Think about more complex queries you might want to run on your data

## Read More

- [ArrayList Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- [String split() method](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#split(java.lang.String))
- [Double.parseDouble()](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Double.html#parseDouble(java.lang.String))
- Aggregation patterns in programming
- CSV format and structured data storage
