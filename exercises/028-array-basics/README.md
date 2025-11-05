# Exercise 028: Array Basics - Declare, Print & Sum

## Overview

Arrays are one of the most fundamental data structures in programming. This exercise teaches you how to:
- Declare and initialize arrays
- Access individual elements
- Iterate through all elements
- Perform basic aggregations (sum, average, min, max)

You'll work with the `ArrayBasics` class to implement all the necessary methods.

---

## Your Task

### Part 1: Declare and Print Arrays

Create methods that work with arrays:

**`void printArray(int[] numbers)`** - Print all elements
- Iterate through the array and print each element
- Print one number per line
- Example: If array is `{1, 2, 3}`, print:
  ```
  1
  2
  3
  ```

**`void printArrayInline(int[] numbers)`** - Print in one line
- Print all elements separated by commas and spaces
- Example: If array is `{1, 2, 3}`, print: `1, 2, 3`

**`void printArrayWithIndex(int[] numbers)`** - Print with index
- Print each element with its index
- Example format: `Index 0: 1`, `Index 1: 2`, `Index 2: 3`

---

### Part 2: Array Aggregation

**`int calculateSum(int[] numbers)`** - Return sum
- Add all elements together
- Example: Sum of `{1, 2, 3}` is `6`

**`double calculateAverage(int[] numbers)`** - Return average
- Calculate average of all elements
- Return as double
- Example: Average of `{1, 2, 3}` is `2.0`

**`int findMin(int[] numbers)`** - Return minimum value
- Find the smallest element
- Example: Min of `{5, 2, 8}` is `2`

**`int findMax(int[] numbers)`** - Return maximum value
- Find the largest element
- Example: Max of `{5, 2, 8}` is `8`

---

### Part 3: Array Count

**`int countEven(int[] numbers)`** - Count even numbers
- Count how many elements are even (divisible by 2)
- Example: In `{1, 2, 3, 4}`, there are 2 even numbers

**`int countOdd(int[] numbers)`** - Count odd numbers
- Count how many elements are odd
- Example: In `{1, 2, 3, 4}`, there are 2 odd numbers

**`int countGreaterThan(int[] numbers, int threshold)`** - Count elements above threshold
- Count how many elements are greater than the given threshold
- Example: In `{1, 5, 3, 8}` with threshold 4, count is 2 (5 and 8)

---

## Tips

✅ Use `array.length` to get the number of elements
✅ Remember array indices start at 0
✅ Use for loops to iterate: `for (int i = 0; i < array.length; i++)`
✅ Test edge cases like empty arrays or single-element arrays

---

## Learning Outcomes

By completing this exercise, you will:
- ✨ Understand array declaration and initialization
- ✨ Master array indexing and iteration
- ✨ Implement basic aggregation operations
- ✨ Write loops that work with collections
- ✨ Apply conditional logic within loops
