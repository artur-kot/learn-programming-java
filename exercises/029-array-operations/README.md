# Exercise 029: Array Operations - Advanced Manipulation

## Overview

Working with arrays goes beyond simple printing and summing. Real-world programming requires manipulating arrays—merging them, reversing them, removing duplicates, and searching through them efficiently. This exercise teaches advanced array techniques.

---

## Your Task

### Part 1: Array Merging

**`int[] mergeArrays(int[] arr1, int[] arr2)`** - Merge two arrays
- Combine two arrays into a single new array
- Order: all elements from arr1, then all from arr2
- Example: `{1, 2}` + `{3, 4}` = `{1, 2, 3, 4}`

**`int[] mergeArraysSorted(int[] arr1, int[] arr2)`** - Merge and sort
- Merge two arrays and sort the result
- Example: `{3, 1}` + `{4, 2}` = `{1, 2, 3, 4}`

---

### Part 2: Array Reversal & Copying

**`int[] reverseArray(int[] numbers)`** - Return reversed copy
- Create a new array with elements in reverse order
- Do NOT modify the original array
- Example: `{1, 2, 3}` becomes `{3, 2, 1}`

**`void reverseArrayInPlace(int[] numbers)`** - Reverse in place
- Reverse the array directly (modify the original)
- Use two pointers: start and end
- Swap elements as you move inward
- Example: `{1, 2, 3, 4, 5}` becomes `{5, 4, 3, 2, 1}`

**`int[] copyArray(int[] numbers)`** - Create independent copy
- Return a new array with the same values
- Modifying the copy should not affect original
- Example: Copy of `{1, 2, 3}` is a new array `{1, 2, 3}`

---

### Part 3: Duplicate Removal

**`int[] removeDuplicates(int[] numbers)`** - Return array without duplicates
- Create a new array keeping only unique values
- Preserve first occurrence order
- Example: `{1, 2, 2, 3, 1}` becomes `{1, 2, 3}`

**`boolean containsDuplicates(int[] numbers)`** - Check for duplicates
- Return true if array has any duplicate values
- Return false if all values are unique
- Example: `{1, 2, 3}` returns false, `{1, 2, 1}` returns true

---

### Part 4: Searching & Filtering

**`int indexOf(int[] numbers, int target)`** - Find first occurrence
- Return the index of first occurrence of target
- Return -1 if not found
- Example: In `{5, 2, 8, 2}`, indexOf 2 returns 1

**`boolean contains(int[] numbers, int target)`** - Check if exists
- Return true if target is in array
- Return false otherwise
- Example: `{1, 2, 3}` contains 2 is true

**`int[] filterEven(int[] numbers)`** - Keep only even numbers
- Create new array with only even elements
- Preserve order
- Example: `{1, 2, 3, 4}` becomes `{2, 4}`

**`int[] filterOdd(int[] numbers)`** - Keep only odd numbers
- Create new array with only odd elements
- Preserve order
- Example: `{1, 2, 3, 4}` becomes `{1, 3}`

---

### Part 5: Array Sorting & Transformation

**`int[] sortAscending(int[] numbers)`** - Sort in ascending order
- Return new sorted array (smallest to largest)
- Do NOT modify original
- Example: `{3, 1, 4, 1, 5}` becomes `{1, 1, 3, 4, 5}`

**`int[] sortDescending(int[] numbers)`** - Sort in descending order
- Return new sorted array (largest to smallest)
- Do NOT modify original
- Example: `{3, 1, 4, 1, 5}` becomes `{5, 4, 3, 1, 1}`

**`int[] multiplyAll(int[] numbers, int factor)`** - Transform all elements
- Create new array with each element multiplied by factor
- Example: `{1, 2, 3}` × 2 = `{2, 4, 6}`

---

## Tips

✅ Use `System.arraycopy()` or manually copy elements for array copying
✅ For sorting, use nested loops to compare elements (bubble sort) or `java.util.Arrays.sort()`
✅ When creating new arrays with filtered content, count matching elements first
✅ Remember that -1 is a common return value for "not found"
✅ Be careful with off-by-one errors when working with indices

---

## Learning Outcomes

By completing this exercise, you will:
- ✨ Master array merging and combination
- ✨ Understand in-place vs. non-destructive array operations
- ✨ Remove duplicates efficiently
- ✨ Search and filter arrays
- ✨ Sort arrays using algorithms
- ✨ Apply advanced looping techniques
- ✨ Transform and manipulate array data
