# Exercise 031: String Transformation

## Overview

Text transformation is everywhere - from reversing usernames in games, to detecting palindromes in puzzles, to creating acronyms for long phrases. This exercise teaches you how to manipulate strings at the character level, transform their case, and build new strings from existing ones.

---

## What You're Learning

### Character-Level String Operations

Strings are sequences of characters that you can access individually, reverse, and transform:

**Accessing Characters:**
```java
String word = "Hello";
char first = word.charAt(0);    // 'H'
char last = word.charAt(4);     // 'o'
```

**Looping Through Characters:**
```java
String word = "cat";
for (int i = 0; i < word.length(); i++) {
    char c = word.charAt(i);
    // Process each character
}
```

**Building Strings:**
You can build new strings character by character or word by word:
```java
String result = "";
result = result + "a";  // "a"
result = result + "b";  // "ab"
result = result + "c";  // "abc"
```

**Character Case:**
```java
char lower = 'a';
char upper = Character.toUpperCase(lower);  // 'A'

String text = "hello";
String upperText = text.toUpperCase();  // "HELLO"
String lowerText = text.toLowerCase();  // "hello"
```

### Key Concepts

- **charAt(index)**: Access individual characters in a string
- **Reverse iteration**: Loop backwards through a string
- **String building**: Create new strings by combining characters
- **Case conversion**: Transform between uppercase and lowercase
- **Character checking**: Identify vowels, consonants, spaces, etc.
- **String comparison**: Check if strings match (for palindromes)

---

## Your Task

Create string transformation methods in the `StringTransformation` class. Each method transforms or analyzes strings in different ways.

### Part 1: Reversing Strings

**`String reverseString(String str)`**
- Return a new string with characters in reverse order
- Example: `reverseString("hello")` returns `"olleh"`
- Example: `reverseString("Java")` returns `"avaJ"`

---

### Part 2: Palindrome Detection

**`boolean isPalindrome(String str)`**
- Check if a string reads the same forwards and backwards
- Ignore case (treat 'A' and 'a' as the same)
- Example: `isPalindrome("racecar")` returns `true`
- Example: `isPalindrome("hello")` returns `false`
- Example: `isPalindrome("Madam")` returns `true` (case-insensitive)

---

### Part 3: Acronym Creation

**`String createAcronym(String phrase)`**
- Take the first letter of each word to create an acronym
- Return uppercase letters
- Words are separated by spaces
- Example: `createAcronym("Hello World")` returns `"HW"`
- Example: `createAcronym("as soon as possible")` returns `"ASAP"`
- Example: `createAcronym("Java Programming Language")` returns `"JPL"`

---

### Part 4: Title Case Conversion

**`String toTitleCase(String str)`**
- Capitalize the first letter of each word
- Make all other letters lowercase
- Words are separated by spaces
- Example: `toTitleCase("hello world")` returns `"Hello World"`
- Example: `toTitleCase("JAVA programming")` returns `"Java Programming"`

---

### Part 5: Vowel Counting

**`int countVowels(String str)`**
- Count how many vowels (a, e, i, o, u) are in the string
- Count both uppercase and lowercase vowels
- Example: `countVowels("hello")` returns `2` (e, o)
- Example: `countVowels("programming")` returns `3` (o, a, i)
- Example: `countVowels("AEIOU")` returns `5`

---

## Expected Behavior

```java
StringTransformation transformer = new StringTransformation();

// Reversing
System.out.println(transformer.reverseString("hello"));  // "olleh"
System.out.println(transformer.reverseString("Java"));   // "avaJ"

// Palindrome checking
System.out.println(transformer.isPalindrome("racecar"));  // true
System.out.println(transformer.isPalindrome("hello"));    // false
System.out.println(transformer.isPalindrome("Madam"));    // true

// Acronyms
System.out.println(transformer.createAcronym("Hello World"));              // "HW"
System.out.println(transformer.createAcronym("as soon as possible"));      // "ASAP"

// Title case
System.out.println(transformer.toTitleCase("hello world"));       // "Hello World"
System.out.println(transformer.toTitleCase("JAVA programming"));  // "Java Programming"

// Vowel counting
System.out.println(transformer.countVowels("hello"));       // 2
System.out.println(transformer.countVowels("programming")); // 3
```

---

## Testing Instructions

Compile and run your code:
```bash
cd exercises/031-string-transformation
javac src/StringTransformation.java
```

Run the tests to verify your implementation:
```bash
mvn test
```

All tests should pass when your methods are correctly implemented.

---

## Tips

- For reversing, loop backwards from the last character to the first
- For palindromes, compare the string with its reverse (after converting to same case)
- For acronyms, split by spaces and take the first character of each word
- For title case, process each word separately
- For vowel counting, check if each character is in the set {a, e, i, o, u, A, E, I, O, U}
- Remember: charAt(0) is the first character, charAt(length-1) is the last
- Use toUpperCase() and toLowerCase() for case conversions

---

## Reflection Questions

After completing this exercise, think about:

1. What's the difference between forward and backward iteration through a string?
2. Why do we need to ignore case when checking for palindromes?
3. How would you handle multiple spaces between words in the acronym method?
4. What happens if you pass an empty string to these methods?
5. How could you optimize the palindrome check without creating a reversed copy?

---

## Next Steps

You've now mastered both array-based string operations and character-level transformations! Next, you can explore more advanced string manipulation like pattern matching, regular expressions, and text parsing.

---

## Read More

- [Java String charAt() method](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#charAt(int))
- [Java Character class](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Character.html)
- [String case conversion methods](https://www.w3schools.com/java/ref_string_touppercase.asp)
- [What is a palindrome?](https://en.wikipedia.org/wiki/Palindrome)
- [String manipulation tutorial](https://www.baeldung.com/java-string-operations)
