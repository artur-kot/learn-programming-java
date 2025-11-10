# Exercise 027: Array Basics - Declare, Print & Sum

## Overview

You're about to discover one of programming's most powerful tools: the array. Arrays let you store multiple values under a single name, making it easy to work with collections of data like test scores, temperatures, or player scores.

In this exercise, you'll implement methods that perform essential array operations that every programmer needs to know.

## What You're Learning

### Understanding Arrays

An **array** is a container that holds multiple values of the same type. Think of it like a row of boxes, each numbered starting from 0:

```
Index:  [0]  [1]  [2]  [3]  [4]
Value:  [10] [25] [17] [42] [33]
```

Key concepts:
- **Declaration**: Creating an array to hold values
- **Indexing**: Accessing individual elements using their position (starting at 0)
- **Length**: Every array has a `.length` property telling you how many elements it contains
- **Iteration**: Using loops to process every element in the array

### Why Arrays Matter

Without arrays, storing 100 numbers would require 100 separate variables! Arrays make it possible to:
- Store collections of related data
- Process multiple values with loops
- Perform calculations on entire datasets
- Build more complex data structures

### Working with Arrays

You'll practice these fundamental operations:

1. **Accessing elements**: `arr[0]` gets the first element, `arr[1]` gets the second, etc.
2. **Iterating with loops**: Processing each element one by one
3. **Aggregating data**: Combining all values (sum, average, min, max)

## Challenge Description

You'll implement a class called `ArrayBasics` with five methods that work with integer arrays. Each method performs a specific operation on an array.

Your task is to complete the methods marked with `// TODO` comments.

## Requirements

Implement these methods in the `ArrayBasics` class:

1. **`printArray(int[] arr)`** - Print each element on a new line
2. **`sum(int[] arr)`** - Return the sum of all elements
3. **`average(int[] arr)`** - Return the average of all elements as a double
4. **`findMin(int[] arr)`** - Return the smallest element
5. **`findMax(int[] arr)`** - Return the largest element

## Hints

<details>
<summary>Hint 1: Accessing Array Length</summary>

Use `arr.length` (NOT a method call - no parentheses) to get how many elements are in the array.

```java
int[] numbers = {10, 20, 30};
System.out.println(numbers.length); // Prints: 3
```
</details>

<details>
<summary>Hint 2: Iterating Through Arrays</summary>

Use a for loop to visit each element:

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]); // Access element at index i
}
```

Remember: indices go from 0 to `arr.length - 1`.
</details>

<details>
<summary>Hint 3: Calculating Sum</summary>

Create a variable to accumulate the total, then add each element in a loop:

```java
int total = 0;
for (int i = 0; i < arr.length; i++) {
    total = total + arr[i]; // or: total += arr[i];
}
return total;
```
</details>

<details>
<summary>Hint 4: Finding Minimum</summary>

Start by assuming the first element is the smallest, then compare with every other element:

```java
int min = arr[0]; // Start with first element
for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i]; // Found a smaller value
    }
}
return min;
```
</details>

<details>
<summary>Hint 5: Calculating Average</summary>

Average = sum divided by count. Make sure to return a `double`:

```java
int total = sum(arr); // Reuse your sum method!
return (double) total / arr.length; // Cast to double for decimal result
```
</details>

## Expected Behavior

When your implementation is correct, your code should work like this:

```java
int[] numbers = {5, 12, 3, 18, 7};

printArray(numbers);
// Output:
// 5
// 12
// 3
// 18
// 7

sum(numbers);        // Returns: 45
average(numbers);    // Returns: 9.0
findMin(numbers);    // Returns: 3
findMax(numbers);    // Returns: 18
```

## Testing Instructions

Run the tests to verify your implementation:

```bash
cd exercises/027-array-basics
mvn test
```

The tests will check:
- Correct sum calculation with various arrays
- Accurate average computation (as double)
- Finding minimum values correctly
- Finding maximum values correctly
- Handling edge cases (single element, negative numbers)

If tests fail:
1. Check array indexing (remember arrays start at 0)
2. Verify loop conditions (should be `i < arr.length`, not `i <= arr.length`)
3. Make sure average returns a double, not an int
4. Test your code with small arrays manually to debug

## Reflection Questions

After completing this exercise, consider:

1. **Why does array indexing start at 0?** How does this affect your loop conditions?
2. **What would happen if you tried to access `arr[arr.length]`?** Why?
3. **How would you modify `findMin()` to also return the index where the minimum occurs?**
4. **Could you write `findMax()` using `findMin()`?** What transformation would you need?
5. **What happens when you calculate average of integers?** Why do we cast to double?

## Next Steps

- **Exercise 028** introduces advanced array operations: merging, reversing, searching, sorting, and filtering
- You'll learn how to create new arrays, copy data, and transform array contents
- These skills build the foundation for working with collections and data structures

## Read More

- [Oracle Java Tutorials - Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Array Basics - GeeksforGeeks](https://www.geeksforgeeks.org/arrays-in-java/)
- Understanding array iteration and the for loop
- Common array algorithms: sum, average, min, max
