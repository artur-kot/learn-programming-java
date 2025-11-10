# Exercise 032: Data Operations - Advanced List Manipulation

## Overview

You've mastered basic ArrayList operations - now it's time to level up. Real-world applications constantly need to sort data, filter out unwanted values, combine multiple datasets, and remove duplicates. These operations are the backbone of data processing, whether you're building a music playlist app, analyzing sales data, or managing user accounts.

In this exercise, you'll learn to use Java's Collections utility class - a powerful toolkit that provides algorithms for working with lists.

---

## What You're Learning

### The Collections Utility Class

While ArrayList gives you a container for your data, the **Collections class** provides algorithms to manipulate that data. Think of ArrayList as a toolbox and Collections as the power tools inside it.

Collections is a static utility class (meaning you don't create instances of it). You simply call its methods directly, like `Collections.sort(myList)`.

**Key Collections Methods:**

- **`Collections.sort(list)`** - Sorts a list in natural order (ascending for numbers, alphabetical for strings)
- **`Collections.reverse(list)`** - Reverses the order of elements
- **`Collections.max(list)`** - Finds the maximum value
- **`Collections.min(list)`** - Finds the minimum value
- **`Collections.frequency(list, item)`** - Counts how many times an item appears

**Important Difference from Arrays.sort():**

With regular arrays, you use `Arrays.sort(array)`. With ArrayLists, you use `Collections.sort(list)`. Both sort data, but they work with different data structures.

### Data Manipulation Concepts

**Sorting** - Arranging data in a specific order (ascending/descending). Essential for making data readable and searchable.

**Filtering** - Selecting only elements that meet certain criteria. Like using a strainer to keep pasta and let water pass through.

**Merging** - Combining multiple datasets into one. Common when aggregating data from different sources.

**Deduplication** - Removing duplicate values to ensure each item appears only once. Critical for data integrity and avoiding double-counting.

**Statistical Operations** - Calculating min, max, average, and other metrics to understand your data.

These operations form the foundation of data processing in virtually every application you'll build.

---

## Your Task

Implement five methods that perform advanced list operations. Each method demonstrates essential data manipulation techniques you'll use throughout your programming career.

### Method 1: Sort List
**`void sortList(ArrayList<Integer> list)`**

Sort the list in ascending order (smallest to largest).
- Use `Collections.sort()` to sort in place
- The original list should be modified
- Example: [3, 1, 4, 1, 5] becomes [1, 1, 3, 4, 5]

### Method 2: Filter Greater Than
**`ArrayList<Integer> filterGreaterThan(ArrayList<Integer> list, int threshold)`**

Create a new list containing only values greater than the threshold.
- Loop through the original list
- Add values that are greater than threshold to new list
- Return the filtered list
- Original list remains unchanged
- Example: Filter [1, 5, 3, 8, 2] with threshold 3 returns [5, 8]

### Method 3: Merge Lists
**`ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2)`**

Combine two lists into a single new list.
- Add all elements from list1
- Add all elements from list2
- Return the merged list
- Original lists remain unchanged
- Example: [1, 2, 3] + [4, 5] = [1, 2, 3, 4, 5]

### Method 4: Remove Duplicates
**`ArrayList<Integer> removeDuplicates(ArrayList<Integer> list)`**

Create a new list with duplicate values removed.
- Keep only the first occurrence of each value
- Preserve the original order
- Return the deduplicated list
- Example: [1, 2, 2, 3, 1, 4] becomes [1, 2, 3, 4]

### Method 5: Get Statistics
**`String getStatistics(ArrayList<Integer> list)`**

Calculate and return statistics about the list.
- Find minimum value (use Collections.min())
- Find maximum value (use Collections.max())
- Calculate average (sum all values and divide by count)
- Return formatted string: "Min: X, Max: Y, Average: Z"
- Handle empty lists by returning "No data"
- Example: [1, 2, 3, 4, 5] returns "Min: 1, Max: 5, Average: 3.0"

---

## Requirements

- Use `Collections.sort()` for sorting operations
- Create new lists when operations should not modify originals
- Handle empty lists gracefully in all methods
- Round averages to one decimal place
- Use `Collections.min()` and `Collections.max()` for statistics

---

## Testing Your Code

**Compile and run:**
```bash
cd exercises/032-data-operations
javac src/DataOperations.java
java -cp src DataOperations
```

**Run the test suite:**
```bash
cd exercises/032-data-operations
mvn test
```

The tests will verify:
- Sorting modifies the original list correctly
- Filtering returns correct values without modifying original
- Merging combines lists in the right order
- Duplicate removal preserves order and keeps first occurrences
- Statistics calculation is accurate for various datasets

---

## Hints

<details>
<summary>Hint 1: Sorting Lists</summary>

The Collections.sort() method sorts a list in place (modifying the original). Simply call it with your list as the parameter. No need to return anything since the list is modified directly.

</details>

<details>
<summary>Hint 2: Filtering</summary>

Create a new ArrayList to hold filtered results. Loop through the original list, and for each element, check if it's greater than the threshold. If yes, add it to your new list. Return the new list at the end.

</details>

<details>
<summary>Hint 3: Merging Lists</summary>

Create a new ArrayList and use the `addAll()` method twice - once for each list. This is more efficient than manually looping and adding individual elements.

</details>

<details>
<summary>Hint 4: Removing Duplicates</summary>

Create a new ArrayList for results. For each element in the original list, check if it's already in your results list using `contains()`. If not, add it. This keeps first occurrences and maintains order.

</details>

<details>
<summary>Hint 5: Statistics</summary>

First check if the list is empty. If not, use Collections.min() and Collections.max() for min/max. For average, sum all values in a loop, then divide by list.size(). Use String.format() to round to one decimal place.

</details>

---

## Expected Behavior

**Example Usage:**
```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(3);
numbers.add(1);
numbers.add(4);
numbers.add(1);
numbers.add(5);

sortList(numbers);
System.out.println(numbers); // [1, 1, 3, 4, 5]

ArrayList<Integer> filtered = filterGreaterThan(numbers, 2);
System.out.println(filtered); // [3, 4, 5]

ArrayList<Integer> list1 = new ArrayList<>();
list1.add(1);
list1.add(2);

ArrayList<Integer> list2 = new ArrayList<>();
list2.add(3);
list2.add(4);

ArrayList<Integer> merged = mergeLists(list1, list2);
System.out.println(merged); // [1, 2, 3, 4]

ArrayList<Integer> withDupes = new ArrayList<>();
withDupes.add(1);
withDupes.add(2);
withDupes.add(2);
withDupes.add(3);

ArrayList<Integer> unique = removeDuplicates(withDupes);
System.out.println(unique); // [1, 2, 3]

ArrayList<Integer> data = new ArrayList<>();
data.add(10);
data.add(20);
data.add(30);

String stats = getStatistics(data);
System.out.println(stats); // "Min: 10, Max: 30, Average: 20.0"
```

---

## Reflection Questions

After completing the exercise, consider:

1. **Why does Collections.sort() modify the list in place instead of returning a new list?** What are the performance implications?

2. **When would you want to filter data vs just sorting it?** Can you think of real-world examples?

3. **Why is removing duplicates computationally expensive?** How does the algorithm's efficiency change as the list grows?

4. **What's the difference between Collections and Collection?** Why is one plural?

5. **How would you sort a list in descending order?** What Collections method would help?

---

## Next Steps

After mastering these data operations, you'll be ready to:
- Work with ArrayLists of custom objects (not just Integers)
- Implement custom sorting with Comparators
- Use Java Streams for more concise data manipulation
- Handle more complex data structures like Maps and Sets
- Build real-world applications that process and analyze data

---

## Read More

- [Collections Framework Guide](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [Collections Class Documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html)
- [ArrayList vs Arrays](https://docs.oracle.com/javase/tutorial/collections/implementations/list.html)
- [Sorting in Java](https://docs.oracle.com/javase/tutorial/collections/algorithms/index.html)
