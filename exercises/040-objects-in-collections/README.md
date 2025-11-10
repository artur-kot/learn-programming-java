# Exercise 040: Objects in Collections

## Overview

So far you've created individual User objects. But real applications work with many objects at once - lists of users, collections of products, groups of students. In this exercise, you'll learn to store User objects in an ArrayList and perform common operations like searching, filtering, and finding extremes. This is where Object-Oriented Programming really shines!

## What You're Learning

### Collections of Objects

An `ArrayList` can store not just primitive values or strings, but also objects:

```java
ArrayList<User> users = new ArrayList<>();
users.add(new User("Alice", 25));
users.add(new User("Bob", 30));
```

Each element in the list is a complete object with its own data and methods.

### Generic Types

The `<User>` in `ArrayList<User>` is a **generic type parameter**. It tells Java:
- This ArrayList stores User objects
- You can only add User objects to it
- When you get elements, they're automatically User type (no casting needed)

```java
ArrayList<User> users = new ArrayList<>();  // Can only hold Users
users.add(new User("Alice", 25));  // OK
users.add("Bob");  // COMPILE ERROR - not a User!

User firstUser = users.get(0);  // No casting needed
```

### Iterating Through Object Collections

You can loop through objects just like any other ArrayList:

```java
for (User user : users) {
    System.out.println(user.getName());  // Call methods on each user
    System.out.println(user.getAge());
}
```

### Searching for Objects

To find an object, you typically loop through and compare:

```java
public User findByName(String name) {
    for (User user : users) {
        if (user.getName().equals(name)) {
            return user;  // Found it!
        }
    }
    return null;  // Not found
}
```

### Filtering Collections

Create a new list containing only objects that match criteria:

```java
public ArrayList<User> filterByAge(int minAge, int maxAge) {
    ArrayList<User> filtered = new ArrayList<>();
    for (User user : users) {
        if (user.getAge() >= minAge && user.getAge() <= maxAge) {
            filtered.add(user);
        }
    }
    return filtered;
}
```

### Finding Extremes

To find the "biggest" or "smallest" object, track the best one seen so far:

```java
public User getOldest() {
    if (users.isEmpty()) return null;

    User oldest = users.get(0);  // Start with first user
    for (User user : users) {
        if (user.getAge() > oldest.getAge()) {
            oldest = user;  // Found an older user
        }
    }
    return oldest;
}
```

## Your Challenge

Create a `UserManager` class that manages a collection of User objects:

1. **Field**:
   - `users` - an ArrayList of User objects (private)

2. **Constructor**:
   - Initialize the empty ArrayList

3. **addUser(User user)** method:
   - Add a user to the collection
   - Don't add if user is null

4. **findByName(String name)** method:
   - Search for a user by exact name match
   - Return the User object if found, null otherwise

5. **filterByAgeRange(int minAge, int maxAge)** method:
   - Return ArrayList of users whose age is between minAge and maxAge (inclusive)
   - Return empty list if none match

6. **getOldestUser()** method:
   - Return the user with the highest age
   - Return null if list is empty

7. **getYoungestUser()** method:
   - Return the user with the lowest age
   - Return null if list is empty

8. **getAllUsers()** method:
   - Return the ArrayList of all users

9. **getUserCount()** method:
   - Return the number of users in the collection

## Requirements

- `users` field must be private
- Use ArrayList<User> for storage
- Methods must not modify the original user objects
- Handle empty collections gracefully (return null or empty lists)
- `findByName()` should do exact name matching

## Expected Behavior

```java
UserManager manager = new UserManager();

// Add users
manager.addUser(new User("Alice", 25));
manager.addUser(new User("Bob", 30));
manager.addUser(new User("Charlie", 20));
manager.addUser(new User("Diana", 35));

// Search by name
User found = manager.findByName("Bob");
System.out.println(found.getAge());  // 30

User notFound = manager.findByName("Eve");
System.out.println(notFound);  // null

// Filter by age range
ArrayList<User> youngAdults = manager.filterByAgeRange(20, 30);
System.out.println(youngAdults.size());  // 3 (Alice, Bob, Charlie)

// Find extremes
User oldest = manager.getOldestUser();
System.out.println(oldest.getName());  // Diana (age 35)

User youngest = manager.getYoungestUser();
System.out.println(youngest.getName());  // Charlie (age 20)

// Get count
System.out.println(manager.getUserCount());  // 4
```

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

The tests will check:
- Users can be added and retrieved
- Search finds correct users
- Filtering returns correct subset
- Oldest/youngest users are found correctly
- Empty collections are handled properly

## Hints

<details>
<summary>Hint 1: Class Structure</summary>

```java
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
    }
}
```
</details>

<details>
<summary>Hint 2: Finding by Name</summary>

```java
public User findByName(String name) {
    for (User user : users) {
        if (user.getName().equals(name)) {
            return user;
        }
    }
    return null;  // Not found
}
```
</details>

<details>
<summary>Hint 3: Filtering by Age Range</summary>

```java
public ArrayList<User> filterByAgeRange(int minAge, int maxAge) {
    ArrayList<User> filtered = new ArrayList<>();
    for (User user : users) {
        if (user.getAge() >= minAge && user.getAge() <= maxAge) {
            filtered.add(user);
        }
    }
    return filtered;
}
```
</details>

<details>
<summary>Hint 4: Finding Oldest User</summary>

```java
public User getOldestUser() {
    if (users.isEmpty()) {
        return null;
    }

    User oldest = users.get(0);
    for (User user : users) {
        if (user.getAge() > oldest.getAge()) {
            oldest = user;
        }
    }
    return oldest;
}
```
</details>

## Reflection Questions

After completing this exercise, consider:

1. Why is it useful to store objects in collections rather than having separate variables for each object?
2. What would happen if you tried to add a null user to the collection? How should your code handle it?
3. Why do we return a new ArrayList in `filterByAgeRange()` instead of modifying the original list?
4. How does the `equals()` method you implemented in the previous exercise affect object comparison?

## Next Steps

In the next exercise, you'll work with multiple classes that interact with each other! You'll create Student and Course classes where students can enroll in courses and courses track their students - a real-world multi-class design.

## Read More

- [Oracle Java Tutorial - Collections](https://docs.oracle.com/javase/tutorial/collections/index.html)
- [ArrayList Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Generics in Java](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
- [Enhanced For Loop](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
