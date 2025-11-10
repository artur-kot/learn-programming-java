# Exercise 031: Shopping List Manager

## Overview

You're organizing your grocery shopping, but keeping track of items on paper is messy. What if you could build a digital shopping list that lets you add items, remove things you've already bought, search for specific products, and see how many times you've added the same item? That's exactly what you'll create in this exercise.

---

## What You're Learning

### Understanding ArrayList

An **ArrayList** is like a flexible container that can grow or shrink as needed. Unlike regular arrays that have a fixed size, ArrayLists automatically adjust their capacity when you add or remove items.

Think of it like a shopping list on a piece of paper:
- With a regular array, you'd need to know exactly how many items you're buying before you start
- With an ArrayList, you can keep adding items as you think of them, and cross them off when you're done

ArrayLists are part of Java's Collections Framework and provide many built-in methods that make working with lists of data much easier than using regular arrays.

**Key ArrayList Characteristics:**
- **Dynamic sizing** - grows and shrinks automatically
- **Generics** - you specify what type of data it holds (like `ArrayList<String>` for text)
- **Rich API** - built-in methods for common operations (add, remove, search, etc.)
- **Index-based access** - access elements by position (0, 1, 2, ...)

**Why ArrayLists Matter:**

In real-world programming, you rarely know exactly how much data you'll be working with ahead of time. User input, database queries, API responses - these all produce varying amounts of data. ArrayList is one of the most commonly used data structures because it handles this uncertainty elegantly.

---

## Your Task

Build a shopping list manager by implementing five methods that work with ArrayLists. Each method receives an ArrayList as a parameter and performs a specific operation.

### Method 1: Add Item to List
**`void addItem(ArrayList<String> list, String item)`**

Add a new item to the shopping list.
- Use ArrayList's add method
- The item should be added to the end of the list
- Example: Adding "Milk" to an empty list results in ["Milk"]

### Method 2: Remove Item from List
**`void removeItem(ArrayList<String> list, String item)`**

Remove a specific item from the shopping list.
- Search for the item and remove it if found
- If the item doesn't exist, the list remains unchanged
- Example: Removing "Milk" from ["Bread", "Milk", "Eggs"] results in ["Bread", "Eggs"]

### Method 3: Search for Item
**`int searchItem(ArrayList<String> list, String item)`**

Find the position of an item in the list.
- Return the index (position) where the item is found
- Return -1 if the item doesn't exist in the list
- Remember: ArrayList indices start at 0
- Example: Searching for "Eggs" in ["Bread", "Milk", "Eggs"] returns 2

### Method 4: Count Item Occurrences
**`int countOccurrences(ArrayList<String> list, String item)`**

Count how many times a specific item appears in the list.
- Loop through the entire list
- Count matches (use .equals() to compare strings)
- Return the total count
- Example: In ["Milk", "Bread", "Milk", "Eggs"], counting "Milk" returns 2

### Method 5: Display List
**`void displayList(ArrayList<String> list)`**

Print all items in the shopping list to the console.
- Print each item on its own line
- Use a loop to go through the list
- If the list is empty, print "Shopping list is empty"
- Example output:
```
1. Bread
2. Milk
3. Eggs
```

---

## Requirements

- All methods should work with the ArrayList passed as a parameter
- Use ArrayList methods like `add()`, `remove()`, `indexOf()`, `size()`, and `get()`
- Handle empty lists gracefully
- Use proper string comparison with `.equals()` (not `==`)

---

## Testing Your Code

**Compile and run:**
```bash
cd exercises/031-shopping-list
javac src/ShoppingList.java
java -cp src ShoppingList
```

**Run the test suite:**
```bash
cd exercises/031-shopping-list
mvn test
```

The tests will verify:
- Adding items increases list size correctly
- Removing items works for existing and non-existing items
- Search returns correct indices and -1 for missing items
- Count accurately tallies occurrences including zero
- Display handles empty and populated lists

---

## Hints

<details>
<summary>Hint 1: Adding Items</summary>

The ArrayList class has an `add()` method that appends an item to the end. You don't need to check the size or manage capacity - ArrayList handles that automatically.

</details>

<details>
<summary>Hint 2: Removing Items</summary>

You can use the `remove()` method with the item itself (not the index). ArrayList will search for the item and remove the first occurrence. It returns true if successful, false if the item wasn't found.

</details>

<details>
<summary>Hint 3: Searching</summary>

The `indexOf()` method does exactly what you need - it searches for an item and returns its position. If not found, it returns -1. This is a one-line solution.

</details>

<details>
<summary>Hint 4: Counting Occurrences</summary>

You'll need to manually loop through the list since ArrayList doesn't have a built-in count method. Use a for loop, compare each element with `.equals()`, and increment a counter when you find a match.

</details>

<details>
<summary>Hint 5: Displaying the List</summary>

Loop through the list using either a traditional for loop with indices or an enhanced for-each loop. Print each item with its position (starting from 1 for user-friendliness, even though indices start at 0).

</details>

---

## Expected Behavior

**Example Usage:**
```java
ArrayList<String> groceries = new ArrayList<>();

addItem(groceries, "Bread");
addItem(groceries, "Milk");
addItem(groceries, "Eggs");
displayList(groceries);
// Output:
// 1. Bread
// 2. Milk
// 3. Eggs

int position = searchItem(groceries, "Milk");
System.out.println("Milk is at position: " + position); // Output: 1

removeItem(groceries, "Milk");
displayList(groceries);
// Output:
// 1. Bread
// 2. Eggs

addItem(groceries, "Bread");
int count = countOccurrences(groceries, "Bread");
System.out.println("Bread appears " + count + " times"); // Output: 2
```

---

## Reflection Questions

After completing the exercise, consider:

1. **What makes ArrayList different from a regular array?** How does this flexibility change what programs you can build?

2. **When would you use indexOf() vs manually looping?** What are the trade-offs?

3. **Why does Java use generics (`ArrayList<String>`) instead of just `ArrayList`?** What problems does this solve?

4. **What happens if you remove an item that appears multiple times?** Does it remove all occurrences or just one?

5. **How would you modify countOccurrences to be case-insensitive?** What would need to change?

---

## Next Steps

After mastering basic ArrayList operations, you'll be ready to:
- Work with ArrayLists of different types (Integer, custom objects)
- Sort and filter lists using the Collections utility class
- Combine multiple lists and remove duplicates
- Build more complex data structures like lists of lists

---

## Read More

- [Oracle Java ArrayList Tutorial](https://docs.oracle.com/javase/tutorial/collections/implementations/list.html)
- [Java ArrayList Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html)
- [Understanding Java Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [Collections Framework Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
