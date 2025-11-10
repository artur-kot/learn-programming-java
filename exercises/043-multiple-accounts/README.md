# Exercise 043: Multiple Accounts Management

## Introduction

You've built a single bank account with proper encapsulation. But real banks manage thousands or millions of accounts! How do they track them all? How do they generate unique account numbers automatically?

In this exercise, you'll learn about **static members** - data and behavior that belongs to the class itself rather than individual objects. You'll use this to create an auto-incrementing account number system and build a manager class to handle multiple accounts.

## What You're Learning

**Static vs Instance Members:**

So far, everything you've created belongs to individual objects (instances). But some data should be shared across ALL objects of a class:

**Instance members** (what you've used so far):
- Each object has its own copy
- Accessed through an object: `account.getBalance()`
- Different for each instance

**Static members** (new concept):
- One copy shared by ALL objects of the class
- Accessed through the class name: `BankAccount.getAccountCount()`
- Same for all instances
- Exists even before creating any objects

Think of it this way:
- Instance variable: "My balance" (each account has different balance)
- Static variable: "How many accounts exist?" (shared information)

**Static Variables (Class Variables):**

A static variable belongs to the class, not to individual objects:

```java
public class BankAccount {
    private static int nextAccountNumber = 1001; // Shared across all accounts
    private String accountNumber; // Each account has its own

    public BankAccount(String owner, double initialBalance) {
        this.accountNumber = "ACC" + nextAccountNumber;
        nextAccountNumber++; // Increment for next account
    }
}
```

Every time you create a new `BankAccount`, `nextAccountNumber` increments. This ensures unique account numbers!

**Static Methods:**

Static methods belong to the class and can be called without creating an object:

```java
public class BankAccount {
    private static int accountCount = 0;

    public BankAccount(...) {
        accountCount++; // Increment each time an account is created
    }

    public static int getAccountCount() {
        return accountCount; // Can access static variables
    }
}

// Usage - no object needed:
int total = BankAccount.getAccountCount();
```

**Important rules for static methods:**
- Can only access static variables (not instance variables)
- Cannot use `this` keyword (no instance exists)
- Often used for utility functions or tracking class-level data

**Collections of Objects:**

Just like you can have an `ArrayList<String>`, you can have an `ArrayList<BankAccount>`:

```java
ArrayList<BankAccount> accounts = new ArrayList<>();
accounts.add(new BankAccount("Alice", 1000));
accounts.add(new BankAccount("Bob", 500));

for (BankAccount account : accounts) {
    System.out.println(account.getOwner() + ": $" + account.getBalance());
}
```

This lets you manage multiple objects together, search through them, and perform operations on collections.

**When to Use Static:**
- Counters (how many objects created?)
- Configuration values shared by all instances
- Utility methods that don't need object state
- Factory methods that create objects
- Constants (with `final static`)

**When NOT to Use Static:**
- Data specific to individual objects (balance, name, etc.)
- Methods that need to access instance data

## Challenge

Your task: **Enhance the BankAccount class with static members for auto-incrementing account numbers, and create a BankAccountManager class to manage multiple accounts.**

This builds on Exercise 42. The solution from Exercise 42 is your starting point - you'll enhance it with new features!

## Requirements

**Part 1: Enhance BankAccount class**

Add to your existing BankAccount class:

**Static field:**
- `nextAccountNumber` (static int, private) - starts at 1001
- `accountCount` (static int, private) - tracks total accounts created

**Modified constructor:**
- Remove accountNumber parameter
- Auto-generate account number using format "ACC" + nextAccountNumber
- Increment nextAccountNumber after each account creation
- Increment accountCount

**Static method:**
- `getAccountCount()` - returns total number of accounts created

**Part 2: Create BankAccountManager class**

Create a new class to manage multiple accounts:

**Private field:**
- `accounts` (ArrayList<BankAccount>) - stores all accounts

**Methods:**
- `addAccount(String owner, double initialBalance)` - creates and adds new account
- `findAccountByOwner(String owner)` - returns BankAccount or null if not found
- `findAccountByNumber(String accountNumber)` - returns BankAccount or null if not found
- `getTotalBalance()` - returns sum of all account balances
- `displayAllAccounts()` - prints info for all accounts
- `getAccountCount()` - returns number of accounts in this manager

## Hints

<details>
<summary>Hint 1: Static Variable Declaration</summary>

Declare static variables at the class level:
```java
public class BankAccount {
    private static int nextAccountNumber = 1001;
    private static int accountCount = 0;

    private String owner;
    private double balance;
    private String accountNumber;
}
```

Note: static variables are typically declared before instance variables.

</details>

<details>
<summary>Hint 2: Auto-generating Account Numbers</summary>

In constructor, use and increment the static variable:
```java
public BankAccount(String owner, double initialBalance) {
    this.owner = owner;
    this.balance = initialBalance;
    this.accountNumber = "ACC" + nextAccountNumber;
    nextAccountNumber++;
    accountCount++;
}
```

</details>

<details>
<summary>Hint 3: Static Method Pattern</summary>

Static methods use the `static` keyword:
```java
public static int getAccountCount() {
    return accountCount;
}
```

Call it with: `BankAccount.getAccountCount()`

</details>

<details>
<summary>Hint 4: ArrayList of Objects</summary>

Create ArrayList to store BankAccount objects:
```java
public class BankAccountManager {
    private ArrayList<BankAccount> accounts;

    public BankAccountManager() {
        accounts = new ArrayList<>();
    }

    public void addAccount(String owner, double initialBalance) {
        BankAccount account = new BankAccount(owner, initialBalance);
        accounts.add(account);
    }
}
```

</details>

<details>
<summary>Hint 5: Searching Through Objects</summary>

Use a loop to search:
```java
public BankAccount findAccountByOwner(String owner) {
    for (BankAccount account : accounts) {
        if (account.getOwner().equals(owner)) {
            return account;
        }
    }
    return null; // Not found
}
```

</details>

<details>
<summary>Hint 6: Calculating Total Balance</summary>

Iterate through all accounts and sum balances:
```java
public double getTotalBalance() {
    double total = 0;
    for (BankAccount account : accounts) {
        total += account.getBalance();
    }
    return total;
}
```

</details>

## Expected Behavior

Example usage:
```java
// Static method works without objects
System.out.println("Accounts created: " + BankAccount.getAccountCount());
// Output: Accounts created: 0

BankAccountManager manager = new BankAccountManager();

manager.addAccount("Alice Johnson", 1000.0);
manager.addAccount("Bob Smith", 1500.0);
manager.addAccount("Charlie Brown", 500.0);

System.out.println("Total accounts: " + BankAccount.getAccountCount());
// Output: Total accounts: 3

manager.displayAllAccounts();
// Output:
// Account Number: ACC1001
// Owner: Alice Johnson
// Balance: $1000.00
//
// Account Number: ACC1002
// Owner: Bob Smith
// Balance: $1500.00
//
// Account Number: ACC1003
// Owner: Charlie Brown
// Balance: $500.00

BankAccount found = manager.findAccountByOwner("Bob Smith");
if (found != null) {
    System.out.println("Found: " + found.getAccountNumber());
}
// Output: Found: ACC1002

double total = manager.getTotalBalance();
System.out.println("Total balance across all accounts: $" + total);
// Output: Total balance across all accounts: $3000.0
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/043-multiple-accounts
mvn test
```

**Manual Testing:**
```bash
cd exercises/043-multiple-accounts/src
javac BankAccount.java BankAccountManager.java
# Test in main methods
```

## Reflection Questions

1. **Why is nextAccountNumber static?** What would happen if it was an instance variable?
2. **Can a static method access instance variables?** Why or why not? Try it!
3. **Why don't we need to create a BankAccount object to call getAccountCount()?**
4. **What's the difference between manager.getAccountCount() and BankAccount.getAccountCount()?**
5. **Could multiple managers share the same static counter?** Is this good or bad?
6. **What happens if you create accounts without a manager?** Does the counter still work?
7. **When would you use a static constant?** (Hint: `private static final`)

## Next Steps

Excellent work! You now understand the difference between instance and class-level data. In the next exercise, you'll implement **advanced banking operations**: transferring money between accounts, tracking transaction history with an **inner class**, and calculating interest. This will teach you about object references and composition!

## Read More

- [Static Members in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)
- [When to Use Static](https://www.baeldung.com/java-static)
- [Static vs Instance](https://www.geeksforgeeks.org/static-vs-instance-variables-java/)
- [Collections of Objects](https://docs.oracle.com/javase/tutorial/collections/)
