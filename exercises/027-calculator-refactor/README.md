# Exercise 027: Text Analyzer Refactor - Modular Design & Method Organization

## Overview

This exercise teaches **refactoring** - transforming working code into better-organized, maintainable code. You are provided with a **fully functional text analyzer application that is poorly organized** (all logic crammed into `main()`). Your task is to refactor it by extracting methods to improve design, eliminate duplication, and enhance readability. This is a realistic software development task: learning to improve code without changing its behavior.

**IMPORTANT:** The text analyzer already works perfectly! Your job is to reorganize the code, not fix bugs.

## What You're Learning

### Code Smells vs. Good Design

**Monolithic Code** (Bad):
```java
public static void main(String[] args) {
    // File validation mixed with main logic
    File file = new File(filePath);
    if (file.exists() && file.isFile()) {
        // File reading mixed in
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            // Analysis logic embedded here
        }
        
        // Counting scattered everywhere
        int wordCount = 0;
        String[] words = content.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        
        // More counting...
        // Even more counting...
    }
}
```

**Refactored Code** (Good):
```java
public static boolean isValidFile(String filePath) {
    File file = new File(filePath);
    return file.exists() && file.isFile();
}

public static String readFile(String filePath) {
    // Handle file reading separately
}

public static int countWords(String filePath) {
    String content = readFile(filePath);
    // Count and return
}

public static void main(String[] args) {
    if (isValidFile(filePath)) {
        analyzeFile(filePath);
    }
}
```

### Refactoring Principles

1. **DRY (Don't Repeat Yourself)**: Extract repeated code into methods
2. **Separation of Concerns**: Each method does one thing well
3. **Readability**: Method names explain what happens
4. **Reusability**: Methods can be used in different contexts
5. **Testability**: Methods can be tested independently

## Your Task

You are provided with a **working text analyzer application** that is poorly organized. Your task is to refactor it by extracting logic into methods. The application already works - you just need to clean it up!

**Key Problems in Current Code:**
1. ❌ All logic is in `main()` - 150+ lines of code in one method!
2. ❌ File validation logic is mixed throughout
3. ❌ File I/O is coupled with analysis logic
4. ❌ Text analysis (counting) code is scattered and complex
5. ❌ Hard to test individual pieces
6. ❌ Hard to extend with new analysis features
7. ❌ Difficult to read and understand

## Extract These Methods

### Part 1: File Validation & I/O
- `isValidFile(String filePath)` - Check if file exists and is readable
- `readFile(String filePath)` - Read entire file content into String
- `getFilePath(Scanner scanner)` - Get file path from user with validation

### Part 2: Text Analysis Methods
- `countWords(String filePath)` - Count total words in file
- `countLines(String filePath)` - Count non-empty lines
- `countSentences(String filePath)` - Count sentences (split by `.!?`)
- `countCharacters(String filePath)` - Count non-whitespace characters

### Part 3: Display & Statistics
- `displayResults(String filePath, int lines, int words, int sentences, int chars)` - Format and display analysis results
- `calculateStatistics(int words, int chars, int sentences)` - Calculate averages

### Part 4: Main Coordination
- `analyzeFile(String filePath)` - Main method that coordinates the analysis
- Keep `main()` simple - just handle the loop and call `analyzeFile()`

## Expected Behavior

The refactored program should work **exactly the same** as the original:

1. User enters file path
2. Program validates the file
3. Program reads and analyzes text
4. Program displays results with statistics
5. User can analyze multiple files
6. User can exit with "exit" command

## Before & After: Key Refactoring Points

### Before (Monolithic):
```java
// File validation scattered
File file = new File(filePath);
if (file.exists() && file.isFile()) {
    // ... do something
}
// Later, validation again
if (file.exists() && file.isFile()) {
    // ... do something else
}
```

### After (Refactored):
```java
private static boolean isValidFile(String filePath) {
    File file = new File(filePath);
    return file.exists() && file.isFile();
}

// Use everywhere:
if (isValidFile(filePath)) { ... }
```

### Before (Monolithic):
```java
// File reading mixed with analysis
Scanner fileScanner = new Scanner(file);
StringBuilder sb = new StringBuilder();
while (fileScanner.hasNextLine()) {
    sb.append(fileScanner.nextLine()).append("\n");
}
String content = sb.toString();
// Now count words in same method
int wordCount = 0;
String[] words = content.split("\\s+");
for (String word : words) {
    if (!word.isEmpty()) wordCount++;
}
```

### After (Refactored):
```java
private static String readFile(String filePath) {
    // Only handles file I/O
}

private static int countWords(String filePath) {
    String content = readFile(filePath);
    // Only handles word counting
}
// Each method has single responsibility
```

## Refactoring Checklist

- [ ] Extract `isValidFile()` - validate file path
- [ ] Extract `readFile()` - read file content
- [ ] Extract `getFilePath()` - get input from user
- [ ] Extract `countWords()` - count words only
- [ ] Extract `countLines()` - count lines only
- [ ] Extract `countSentences()` - count sentences only
- [ ] Extract `countCharacters()` - count characters only
- [ ] Extract `displayResults()` - format and display output
- [ ] Extract `calculateStatistics()` - compute averages
- [ ] Extract `analyzeFile()` - coordinate all analysis
- [ ] Simplify `main()` to just loop and call `analyzeFile()`
- [ ] Remove all duplicated code
- [ ] Test all methods work correctly

## Testing Instructions

Run your tests:
```bash
mvn test
```

Your extracted methods should pass all test cases. Tests verify:
- File validation works correctly
- File reading returns content
- Word counting is accurate
- Line counting is accurate
- Sentence counting is accurate
- Character counting ignores whitespace
- Results display correctly
- Integration works end-to-end

## Tips

- **Start small**: Extract file validation and I/O methods first
- **Then analysis**: Extract each counting method
- **Then display**: Extract display logic
- **Finally coordination**: Extract `analyzeFile()` to coordinate
- **Test incrementally**: Test each method as you extract it
- **Don't change behavior**: Refactoring shouldn't change what the program does
- **Use meaningful names**: Method names should clearly describe what they do

## Challenge Questions

1. What code is duplicated in the original that we eliminated?
2. Why is it better to have separate counting methods instead of one big method?
3. How does extracting `readFile()` make the code more testable?
4. How would adding new analysis features (e.g., count paragraphs) be easier now?
5. Could these methods be reused in other programs?

## Reflection Questions

After completing this exercise, think about:

1. **How much easier is the code to read now?** Compare before and after
2. **Which methods could be reused in other programs?**
3. **How would you add a new analysis feature** (e.g., count paragraphs)?
4. **How would testing be different with vs. without refactoring?**
5. **What other code smells did you notice in the original?**

## Next Steps

After mastering refactoring with this exercise:
- Look for opportunities to refactor your own previous code
- Consider extracting methods in larger programs
- Apply these principles to keep future code clean and organized

## Read More

- [Refactoring Wikipedia](https://en.wikipedia.org/wiki/Code_refactoring)
- Code smell patterns: Long Method, Duplicate Code, Large Class
- Martin Fowler's "Refactoring: Improving the Design of Existing Code"
- Clean Code principles by Robert C. Martin

