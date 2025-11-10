# Exercise 028: Array Operations - Advanced Manipulation

## Overview

Now that you understand array basics, it's time to level up! Real-world programming often requires transforming arrays: reversing them, combining them, searching for specific values, removing duplicates, and filtering data.

In this exercise, you'll implement methods that manipulate arrays in more sophisticated ways, building skills you'll use constantly in real applications.

## What You're Learning

### Beyond Simple Iteration

In the previous exercise, you learned to read and aggregate array data. Now you'll learn to:
- **Create new arrays** based on existing ones
- **Transform data** by reversing, merging, or filtering
- **Search efficiently** for specific values
- **Remove duplicates** from datasets
- **Sort arrays** to organize data

### Key Concepts

**Array Creation**: You can create new arrays dynamically:
```java
int[] newArray = new int[5]; // Creates array with 5 elements (all zeros)
```

**Array Copying**: Creating new arrays from existing ones without modifying the original:
```java
int[] copy = new int[original.length];
for (int i = 0; i < original.length; i++) {
    copy[i] = original[i];
}
```

**Transformation Patterns**: Many array operations follow a common pattern:
1. Count how many elements meet a criteria
2. Create a new array of that size
3. Copy matching elements to the new array

**Searching**: Linear search checks each element until finding a match (or reaching the end).

**Sorting**: Arranging elements in order (you can use `Arrays.sort()` or implement simple sorting).

## Challenge Description

You'll implement a class called `ArrayOperations` with six methods that perform advanced array manipulations. Each builds on concepts from the previous exercise while introducing new techniques.

Complete the methods marked with `// TODO` comments.

## Requirements

Implement these methods in the `ArrayOperations` class:

1. **`reverseArray(int[] arr)`** - Return a new array with elements in reverse order
2. **`mergeArrays(int[] arr1, int[] arr2)`** - Combine two arrays into one new array
3. **`removeDuplicates(int[] arr)`** - Return a new array with only unique values
4. **`contains(int[] arr, int value)`** - Check if value exists in array
5. **`sortArray(int[] arr)`** - Return a new sorted array (ascending order)
6. **`filterEven(int[] arr)`** - Return a new array containing only even numbers

## Hints

<details>
<summary>Hint 1: Reversing an Array</summary>

Create a new array, then copy elements in reverse order:

```java
int[] reversed = new int[arr.length];
for (int i = 0; i < arr.length; i++) {
    reversed[i] = arr[arr.length - 1 - i];
}
return reversed;
```

Think about why `arr.length - 1 - i` gives you the reverse index.
</details>

<details>
<summary>Hint 2: Merging Arrays</summary>

Create a new array big enough for both, then copy elements:

```java
int[] merged = new int[arr1.length + arr2.length];
// Copy all elements from arr1 into merged
// Then copy all elements from arr2 into merged (starting after arr1's elements)
```

You'll need two separate loops or careful index management.
</details>

<details>
<summary>Hint 3: Removing Duplicates</summary>

This is a two-step process:
1. Count how many unique values exist
2. Create array of that size and fill with unique values

```java
// First pass: count unique values
int uniqueCount = 0;
for (int i = 0; i < arr.length; i++) {
    boolean isDuplicate = false;
    // Check if arr[i] appeared earlier in the array
    // If not, increment uniqueCount
}

// Second pass: create new array and fill with unique values
```
</details>

<details>
<summary>Hint 4: Searching with contains()</summary>

Loop through the array and compare each element:

```java
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == value) {
        return true; // Found it!
    }
}
return false; // Not found after checking all elements
```
</details>

<details>
<summary>Hint 5: Sorting an Array</summary>

You can use Java's built-in sort:

```java
import java.util.Arrays;

int[] sorted = Arrays.copyOf(arr, arr.length); // Make a copy first!
Arrays.sort(sorted);
return sorted;
```

Or implement bubble sort if you want practice with nested loops!
</details>

<details>
<summary>Hint 6: Filtering Even Numbers</summary>

Use the transformation pattern:

```java
// Count how many even numbers exist
int evenCount = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] % 2 == 0) {
        evenCount++;
    }
}

// Create array of that size and fill it
int[] evens = new int[evenCount];
int index = 0;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] % 2 == 0) {
        evens[index] = arr[i];
        index++;
    }
}
return evens;
```
</details>

## Expected Behavior

When your implementation is correct:

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {4, 5, 6};

reverseArray(arr1);           // Returns: {3, 2, 1}
mergeArrays(arr1, arr2);      // Returns: {1, 2, 3, 4, 5, 6}

int[] arr3 = {1, 2, 2, 3, 1, 4};
removeDuplicates(arr3);       // Returns: {1, 2, 3, 4}

int[] arr4 = {5, 10, 15, 20};
contains(arr4, 15);           // Returns: true
contains(arr4, 7);            // Returns: false

int[] arr5 = {5, 2, 8, 1, 9};
sortArray(arr5);              // Returns: {1, 2, 5, 8, 9}

int[] arr6 = {1, 2, 3, 4, 5, 6};
filterEven(arr6);             // Returns: {2, 4, 6}
```

## Testing Instructions

Run the tests to verify your implementation:

```bash
cd exercises/028-array-operations
mvn test
```

The tests will check:
- Correct array reversal without modifying original
- Proper merging of two arrays
- Duplicate removal while preserving order
- Accurate searching with contains()
- Correct sorting in ascending order
- Proper filtering of even numbers

If tests fail:
1. Make sure you're creating NEW arrays, not modifying originals
2. Check array size calculations (especially for filtering/duplicates)
3. Verify loop conditions and index calculations
4. Test each method independently with small arrays
5. Remember: don't go out of bounds (`index < arr.length`)

## Reflection Questions

After completing this exercise, think about:

1. **Why create new arrays instead of modifying originals?** When might you want to modify in-place instead?
2. **What's the time complexity of removeDuplicates()?** How many times do you check each element?
3. **How would you modify filterEven() to accept any condition?** (e.g., filter numbers > 10)
4. **What's the difference between `Arrays.sort()` and implementing your own sort?** When would you use each?
5. **How could you make contains() faster if the array was sorted?** (Hint: binary search)

## Next Steps

- **Exercise 029** will teach you about working with arrays of strings
- You'll apply similar techniques to text manipulation and analysis
- Later exercises combine arrays with objects to build more complex data structures

## Read More

- [Oracle Java Tutorials - Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Arrays class documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Arrays.html) - useful utility methods
- Array algorithms: searching, sorting, filtering
- [Array copying techniques in Java](https://www.geeksforgeeks.org/array-copy-in-java/)
