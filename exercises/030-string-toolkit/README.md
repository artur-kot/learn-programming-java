# Exercise 030: String Manipulation Toolkit

## Overview

Imagine you're building a text processing tool that needs to analyze and manipulate collections of words. You need to count characters, find the longest and shortest words, and join words together with separators. This exercise will teach you how to work with arrays of strings and perform common string operations.

---

## What You're Learning

### Working with Strings and String Arrays

In Java, strings are objects that represent sequences of characters. When working with strings, you need to understand:

**String Length:**
```java
String word = "Hello";
int length = word.length();  // Returns 5
```

**Arrays of Strings:**
```java
String[] words = {"apple", "banana", "cherry"};
// Access elements: words[0] is "apple", words[1] is "banana"
// Array length: words.length is 3
```

**Comparing String Lengths:**
To find the longest or shortest string, you need to compare their lengths:
```java
String first = "cat";
String second = "elephant";

if (first.length() > second.length()) {
    // first is longer
} else {
    // second is longer or equal
}
```

**String Concatenation:**
Joining strings together with separators:
```java
String result = "Hello" + ", " + "World";  // "Hello, World"
```

### Key Concepts

- **String.length()**: Returns the number of characters in a string
- **Array iteration**: Loop through arrays to process each element
- **Comparison logic**: Track the best value (longest/shortest) as you iterate
- **String building**: Combine multiple strings with separators
- **Aggregation**: Count or combine values from a collection

---

## Your Task

Create a toolkit of string manipulation methods in the `StringToolkit` class. Each method should solve a specific text processing problem.

### Part 1: Character and Word Counting

**`int countCharacters(String str)`**
- Count the total number of characters in a string
- Example: `countCharacters("Hello")` returns `5`

**`int countWords(String[] words)`**
- Count how many strings are in the array
- Example: `countWords({"cat", "dog", "bird"})` returns `3`

---

### Part 2: Finding Longest and Shortest

**`String findLongest(String[] words)`**
- Find and return the longest string in the array
- If multiple strings have the same longest length, return the first one
- Example: `findLongest({"cat", "elephant", "dog"})` returns `"elephant"`

**`String findShortest(String[] words)`**
- Find and return the shortest string in the array
- If multiple strings have the same shortest length, return the first one
- Example: `findShortest({"cat", "elephant", "dog"})` returns `"cat"` or `"dog"`

---

### Part 3: String Joining

**`String concatenateWords(String[] words, String separator)`**
- Join all words together with the separator between them
- Don't add separator at the beginning or end
- Example: `concatenateWords({"Java", "is", "fun"}, " ")` returns `"Java is fun"`
- Example: `concatenateWords({"red", "green", "blue"}, ", ")` returns `"red, green, blue"`

---

## Expected Behavior

```java
StringToolkit toolkit = new StringToolkit();

// Counting
System.out.println(toolkit.countCharacters("Programming"));  // 11
System.out.println(toolkit.countWords(new String[]{"a", "b", "c"}));  // 3

// Finding
String[] animals = {"cat", "elephant", "dog", "butterfly"};
System.out.println(toolkit.findLongest(animals));   // "butterfly"
System.out.println(toolkit.findShortest(animals));  // "cat" or "dog"

// Joining
String[] colors = {"red", "green", "blue"};
System.out.println(toolkit.concatenateWords(colors, ", "));  // "red, green, blue"
System.out.println(toolkit.concatenateWords(colors, "-"));   // "red-green-blue"
```

---

## Testing Instructions

Compile and run your code:
```bash
cd exercises/030-string-toolkit
javac src/StringToolkit.java
```

Run the tests to verify your implementation:
```bash
mvn test
```

All tests should pass when your methods are correctly implemented.

---

## Tips

- Remember that array indices start at 0
- Use `array.length` to get the number of elements
- Use `string.length()` (with parentheses) to get the number of characters
- For finding longest/shortest, track the best candidate as you loop
- For concatenation, build the result string piece by piece
- Consider edge cases: empty arrays, single-element arrays, empty strings

---

## Reflection Questions

After completing this exercise, think about:

1. What's the difference between `array.length` and `string.length()`?
2. How did you handle the case where multiple strings have the same longest/shortest length?
3. Why is it important to check the array length before accessing elements?
4. How would you modify `concatenateWords` to handle empty strings in the array?
5. What happens if you pass an empty array to `findLongest` or `findShortest`?

---

## Next Steps

Once you've mastered basic string manipulation with arrays, you're ready to explore string transformation operations like reversing strings, checking for palindromes, and creating acronyms in the next exercise!

---

## Read More

- [Java String documentation](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html)
- [Working with Arrays in Java](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [String concatenation best practices](https://www.baeldung.com/java-string-concatenation)
- [Java loops tutorial](https://www.w3schools.com/java/java_for_loop.asp)
