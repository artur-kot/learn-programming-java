# Exercise 042: Bank Account Class

## Introduction

Welcome to Series 18! You've learned the basics of classes and objects. Now it's time to build something more realistic - a banking system! In this series, you'll create classes that model real-world banking operations with proper validation, security, and business logic.

In this first exercise, you'll build a **BankAccount** class that protects sensitive data and validates operations - just like a real bank does.

## What You're Learning

**Encapsulation:**
Encapsulation is one of the four pillars of Object-Oriented Programming. It means hiding the internal state of an object and requiring all interaction to happen through methods. Think of it like a real bank account: you can't directly access the vault and change your balance - you must go through proper procedures (deposit, withdraw).

Why encapsulation matters:
- **Data protection:** No one can directly change sensitive values
- **Validation:** Every change goes through validation logic
- **Flexibility:** You can change internal implementation without breaking code that uses your class
- **Control:** You decide exactly what operations are allowed

**Access Modifiers:**
Java provides keywords to control who can access your class members:

- **`private`** - Only accessible within the class itself. Use for sensitive data.
- **`public`** - Accessible from anywhere. Use for methods that should be available to others.
- **`protected`** - Accessible within the package and subclasses (you'll learn this later)
- **default (no modifier)** - Accessible within the package

Best practice: Make fields private, provide public methods (getters/setters) for controlled access.

**Constructors:**
Constructors are special methods that run when you create a new object. They initialize the object's state.

```java
public class BankAccount {
    private String owner;
    private double balance;

    // Constructor
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }
}
```

**Getters:**
Getter methods provide read-only access to private fields:

```java
public String getOwner() {
    return owner;
}

public double getBalance() {
    return balance;
}
```

**Validation:**
Business logic often requires validation. For banking:
- Can't deposit negative amounts
- Can't withdraw more than the balance
- Balance must start at zero or positive

Validation protects data integrity and prevents bugs.

**Method Logic:**
Methods can modify object state, but they should do so carefully with proper checks:

```java
public void deposit(double amount) {
    if (amount > 0) {
        balance += amount;
    }
}
```

## Challenge

Your task: **Build a BankAccount class that safely manages money with proper encapsulation and validation.**

A real bank account has:
- An owner name
- An account number (for identification)
- A balance (how much money is in the account)
- Operations: deposit money, withdraw money, check balance

Your class must protect this data and validate all operations.

## Requirements

Your `BankAccount` class must have:

**Private Fields:**
- `owner` (String) - account owner's name
- `balance` (double) - current balance
- `accountNumber` (String) - unique account identifier

**Constructor:**
- `BankAccount(String owner, String accountNumber, double initialBalance)`
- Should initialize all fields
- Initial balance must be 0 or positive

**Methods:**
- `deposit(double amount)` - Add money to account
  - Only allow positive amounts
  - Update balance if valid
  - Return true if successful, false if invalid

- `withdraw(double amount)` - Remove money from account
  - Only allow positive amounts
  - Only allow if sufficient balance
  - Update balance if valid
  - Return true if successful, false if invalid

- `getBalance()` - Return current balance

- `getOwner()` - Return owner name

- `getAccountNumber()` - Return account number

- `displayAccountInfo()` - Print formatted account information

## Hints

<details>
<summary>Hint 1: Class Structure</summary>

Start with the class declaration and private fields:
```java
public class BankAccount {
    private String owner;
    private double balance;
    private String accountNumber;

    // Constructor and methods go here
}
```

Remember: `private` means only this class can access these fields directly.

</details>

<details>
<summary>Hint 2: Constructor Pattern</summary>

Constructor initializes all fields:
```java
public BankAccount(String owner, String accountNumber, double initialBalance) {
    this.owner = owner;
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
}
```

Use `this.` to distinguish field names from parameter names.

</details>

<details>
<summary>Hint 3: Deposit Method with Validation</summary>

Check if amount is positive before updating balance:
```java
public boolean deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        return true;
    }
    return false;
}
```

</details>

<details>
<summary>Hint 4: Withdraw Method with Multiple Checks</summary>

Withdraw must check TWO conditions:
1. Amount must be positive
2. Balance must be sufficient

```java
public boolean withdraw(double amount) {
    if (amount > 0 && balance >= amount) {
        balance -= amount;
        return true;
    }
    return false;
}
```

</details>

<details>
<summary>Hint 5: Display Method Formatting</summary>

Use `printf` or `println` for clean output:
```java
public void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Owner: " + owner);
    System.out.printf("Balance: $%.2f%n", balance);
}
```

`%.2f` formats the double to 2 decimal places.

</details>

## Expected Behavior

Example usage:
```java
BankAccount account = new BankAccount("Alice Johnson", "ACC001", 1000.0);

account.displayAccountInfo();
// Output:
// Account Number: ACC001
// Owner: Alice Johnson
// Balance: $1000.00

account.deposit(500.0);
System.out.println("Balance after deposit: $" + account.getBalance());
// Output: Balance after deposit: $1500.0

account.withdraw(200.0);
System.out.println("Balance after withdrawal: $" + account.getBalance());
// Output: Balance after withdrawal: $1300.0

boolean success = account.withdraw(5000.0);
System.out.println("Large withdrawal successful? " + success);
// Output: Large withdrawal successful? false

boolean invalidDeposit = account.deposit(-100.0);
System.out.println("Negative deposit successful? " + invalidDeposit);
// Output: Negative deposit successful? false
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/042-bank-account
mvn test
```

**Manual Testing:**
```bash
cd exercises/042-bank-account/src
javac BankAccount.java
# Create a test file or use jshell to interact with the class
```

## Reflection Questions

1. **Why make fields private?** What problems could occur if `balance` was public?
2. **Why return boolean from deposit/withdraw?** How does the caller know if the operation succeeded?
3. **What happens if you try to access `account.balance` directly from outside the class?** Try it!
4. **Could you add a setter for balance?** Should you? Why or why not?
5. **What other validations might a real bank add?** Think about daily limits, transaction fees, etc.
6. **Why does the constructor take initialBalance instead of starting at 0?** What use cases does this support?

## Next Steps

Great job building your first encapsulated class! In the next exercise, you'll manage **multiple bank accounts** using collections, and you'll learn about **static members** - data that belongs to the class itself rather than individual objects. You'll implement an auto-incrementing account number system!

## Read More

- [Encapsulation in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)
- [Understanding Encapsulation](https://www.baeldung.com/java-encapsulation)
- [Java Constructors](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)
- [Access Modifiers](https://www.baeldung.com/java-access-modifiers)
