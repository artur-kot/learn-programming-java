# Exercise 039: Object Methods

## Overview

Every class you create in Java automatically inherits from a special class called `Object`. This means your classes come with built-in methods that often don't work well by default. In this exercise, you'll learn to override two critical methods - `toString()` and `equals()` - to make your User objects print nicely and compare correctly. You'll also add custom instance methods that use object data.

## What You're Learning

### The Object Class

Every class in Java automatically extends the `Object` class, even if you don't explicitly write it. The `Object` class provides several methods that all objects inherit:
- `toString()` - converts object to string representation
- `equals()` - compares objects for equality
- `hashCode()` - generates a hash code for the object
- And several others

### The toString() Method

By default, `toString()` returns something unhelpful like `User@4e25154f`. You can override it to return something meaningful:

```java
@Override
public String toString() {
    return "User[name=" + name + ", age=" + age + "]";
}
```

This method is automatically called when you:
- Print an object: `System.out.println(user)`
- Concatenate with string: `"User: " + user`
- Use in string formatting

### The @Override Annotation

`@Override` tells Java you're intentionally replacing a method from a parent class. It helps catch mistakes:

```java
@Override
public String toString() {  // Compiler checks this matches Object.toString()
    return "...";
}
```

If you misspell the method name, the compiler will warn you.

### The equals() Method

By default, `equals()` checks if two references point to the same object in memory (reference equality). Often you want to check if two objects have the same data (value equality):

```java
User user1 = new User("Alice", 25);
User user2 = new User("Alice", 25);

// Without overriding equals():
user1.equals(user2);  // false - different objects in memory

// With proper equals() override:
user1.equals(user2);  // true - same name and age
```

### Overriding equals()

The pattern for overriding `equals()`:

```java
@Override
public boolean equals(Object obj) {
    // 1. Check if comparing to itself
    if (this == obj) return true;

    // 2. Check if other object is null or different class
    if (obj == null || getClass() != obj.getClass()) return false;

    // 3. Cast to your class type
    User other = (User) obj;

    // 4. Compare fields
    return age == other.age &&
           name.equals(other.name);
}
```

### Instance Methods

Instance methods are methods that operate on an object's data. They can access the object's fields and provide useful functionality:

```java
public boolean isAdult() {
    return age >= 18;
}

public int getBirthYear() {
    return 2024 - age;  // Using the object's age field
}
```

## Your Challenge

Enhance the `User` class with object methods:

1. **Keep the encapsulated design** from the previous exercise:
   - Private fields: `name` and `age`
   - Constructor with validation
   - Getters and setters

2. **Override toString()**:
   - Return format: `"User[name=Alice, age=25]"`
   - Use the exact format shown (tests will check this)

3. **Override equals()**:
   - Two Users are equal if both name and age are the same
   - Handle null and type checking properly
   - Follow the standard equals() pattern

4. **Add custom instance methods**:
   - `isAdult()` - returns true if age >= 18
   - `getBirthYear()` - returns estimated birth year (2024 - age)
   - `canVote()` - returns true if age >= 18

## Requirements

- Fields must remain private
- Constructor and setters must still validate inputs
- `toString()` must return exact format: `"User[name=..., age=...]"`
- `equals()` must compare both name and age
- Custom methods must use the object's data (fields)
- All methods must have `@Override` annotation where appropriate

## Expected Behavior

```java
// toString() demonstration
User user1 = new User("Alice", 25);
System.out.println(user1);  // Output: User[name=Alice, age=25]
String info = "Info: " + user1;  // "Info: User[name=Alice, age=25]"

// equals() demonstration
User user2 = new User("Alice", 25);
User user3 = new User("Bob", 25);
System.out.println(user1.equals(user2));  // true (same name and age)
System.out.println(user1.equals(user3));  // false (different names)

// Custom methods
User youngUser = new User("Charlie", 16);
System.out.println(youngUser.isAdult());     // false
System.out.println(youngUser.canVote());     // false
System.out.println(youngUser.getBirthYear()); // 2008

User adultUser = new User("Diana", 30);
System.out.println(adultUser.isAdult());     // true
System.out.println(adultUser.canVote());     // true
System.out.println(adultUser.getBirthYear()); // 1994
```

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

The tests will check:
- `toString()` returns correct format
- `equals()` compares objects correctly
- `equals()` handles null and different types
- Custom methods return correct values
- Encapsulation is maintained

## Hints

<details>
<summary>Hint 1: toString() Format</summary>

Return a string with the exact format:
```java
@Override
public String toString() {
    return "User[name=" + name + ", age=" + age + "]";
}
```
</details>

<details>
<summary>Hint 2: equals() Structure</summary>

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    User other = (User) obj;
    return age == other.age && name.equals(other.name);
}
```
</details>

<details>
<summary>Hint 3: isAdult() and canVote()</summary>

Both methods check if age is at least 18:
```java
public boolean isAdult() {
    return age >= 18;
}

public boolean canVote() {
    return age >= 18;
}
```
</details>

<details>
<summary>Hint 4: getBirthYear()</summary>

Subtract age from current year:
```java
public int getBirthYear() {
    return 2024 - age;
}
```
</details>

## Reflection Questions

After completing this exercise, consider:

1. Why is it useful to override `toString()` instead of creating a custom method like `printDetails()`?
2. What's the difference between `==` and `equals()` when comparing objects?
3. Why does `equals()` take an `Object` parameter instead of a `User` parameter?
4. How do instance methods like `isAdult()` differ from static methods?

## Next Steps

In the next exercise, you'll work with collections of User objects! You'll store multiple users in an ArrayList and perform operations like searching, filtering, and finding the oldest user.

## Read More

- [Oracle Java Tutorial - Object Class](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)
- [Overriding toString()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--)
- [Overriding equals()](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#equals-java.lang.Object-)
- [Method Overriding](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
