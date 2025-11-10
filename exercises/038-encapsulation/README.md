# Exercise 038: Encapsulation

## Overview

In the previous exercise, you created a User class with public fields. But there's a problem: anyone can change a user's age to -5 or set their name to an empty string! In this exercise, you'll learn **encapsulation** - one of the most important principles in Object-Oriented Programming that protects your data from invalid values.

## What You're Learning

### Encapsulation

**Encapsulation** means hiding an object's internal data and only allowing controlled access through methods. Think of it like a vending machine:
- You can't reach inside and grab items directly (private fields)
- You interact through buttons and coin slots (public methods)
- The machine validates your input (money, selection) before giving you anything

### Access Modifiers

Java provides keywords to control who can access fields and methods:

- **`private`**: Only accessible within the same class
- **`public`**: Accessible from anywhere

```java
public class BankAccount {
    private double balance;  // Can't access from outside the class

    public double getBalance() {  // Can call from anywhere
        return balance;
    }
}
```

### Why Make Fields Private?

Public fields allow anyone to change data without validation:

```java
public class User {
    public int age;  // Public - anyone can change it!
}

User user = new User();
user.age = -100;  // PROBLEM: This is invalid but Java allows it!
```

Private fields with setters allow validation:

```java
public class User {
    private int age;  // Private - can't change directly

    public void setAge(int age) {
        if (age > 0) {  // VALIDATION!
            this.age = age;
        }
    }
}

User user = new User();
user.setAge(-100);  // Setter rejects invalid value!
```

### Getters and Setters

**Getters** (accessors) return the value of private fields:

```java
public String getName() {
    return name;
}
```

**Setters** (mutators) change the value of private fields with validation:

```java
public void setName(String name) {
    if (name != null && !name.isEmpty()) {
        this.name = name;
    }
}
```

### Data Hiding

By making fields private and exposing only necessary methods, you:
- **Protect data** from invalid values
- **Control how data is changed** through validation logic
- **Hide implementation details** - you can change how data is stored internally without breaking code that uses your class

## Your Challenge

Improve the `User` class by adding encapsulation and validation:

1. **Make fields private**:
   - Change `name` and `age` to `private`

2. **Keep the constructor** but add validation:
   - If name is null or empty, set it to "Unknown"
   - If age is less than 0, set it to 0

3. **Add setters with validation**:
   - `setName(String name)` - reject null or empty strings (don't change the field if invalid)
   - `setAge(int age)` - reject negative ages (don't change the field if invalid)

4. **Keep the existing methods**:
   - `getName()` - return the name
   - `getAge()` - return the age
   - `displayInfo()` - print user information

## Requirements

- Fields must be `private`
- Constructor must validate inputs before setting fields
- Setters must validate inputs before changing fields
- Getters return field values
- Invalid data should be rejected silently (no error messages needed)

## Expected Behavior

```java
// Valid user
User user1 = new User("Alice", 25);
System.out.println(user1.getName());  // Output: Alice
System.out.println(user1.getAge());   // Output: 25

// Invalid constructor inputs are corrected
User user2 = new User("", -5);
System.out.println(user2.getName());  // Output: Unknown (empty name corrected)
System.out.println(user2.getAge());   // Output: 0 (negative age corrected)

// Setters validate input
User user3 = new User("Bob", 30);
user3.setAge(-10);  // Rejected - age stays 30
user3.setName("");  // Rejected - name stays Bob
System.out.println(user3.getAge());   // Output: 30
System.out.println(user3.getName());  // Output: Bob

// Valid setter calls work
user3.setAge(35);
user3.setName("Robert");
System.out.println(user3.getAge());   // Output: 35
System.out.println(user3.getName());  // Output: Robert
```

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

The tests will check:
- Fields are private (cannot be accessed directly)
- Constructor validates inputs correctly
- Setters reject invalid values
- Setters accept valid values
- Getters work correctly

## Hints

<details>
<summary>Hint 1: Making Fields Private</summary>

Change the field declarations:
```java
private String name;
private int age;
```

Now these fields can only be accessed from within the User class itself.
</details>

<details>
<summary>Hint 2: Constructor Validation</summary>

```java
public User(String name, int age) {
    if (name == null || name.isEmpty()) {
        this.name = "Unknown";
    } else {
        this.name = name;
    }

    if (age < 0) {
        this.age = 0;
    } else {
        this.age = age;
    }
}
```
</details>

<details>
<summary>Hint 3: Setter Validation</summary>

Only update the field if the input is valid:
```java
public void setName(String name) {
    if (name != null && !name.isEmpty()) {
        this.name = name;
    }
    // If invalid, do nothing - field keeps its current value
}
```
</details>

<details>
<summary>Hint 4: Validating Age</summary>

```java
public void setAge(int age) {
    if (age >= 0) {
        this.age = age;
    }
}
```
</details>

## Reflection Questions

After completing this exercise, consider:

1. Why is it better to have private fields with getters/setters instead of public fields?
2. What would happen if someone tried to directly access `user.age` when age is private?
3. How does encapsulation make your code more maintainable and safer?
4. Why do we validate in both the constructor and the setters?

## Next Steps

In the next exercise, you'll learn to override important methods from Java's `Object` class - `toString()` and `equals()`. These methods allow your objects to print nicely and be compared properly!

## Read More

- [Oracle Java Tutorial - Controlling Access](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Encapsulation in Java](https://docs.oracle.com/javase/tutorial/java/concepts/object.html)
- [Why Encapsulation Matters](https://docs.oracle.com/javase/tutorial/java/javaOO/variables.html)
