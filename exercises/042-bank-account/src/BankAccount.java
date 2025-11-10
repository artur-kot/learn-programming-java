/**
 * BankAccount - A class representing a bank account with encapsulation
 *
 * Your task: Implement a bank account class that safely manages money
 *
 * Concepts you'll practice:
 * - Encapsulation (private fields, public methods)
 * - Constructors
 * - Validation logic
 * - Getters for controlled access
 * - Business logic in methods
 */
public class BankAccount {

    // TODO: Declare three private fields:
    // - owner (String)
    // - balance (double)
    // - accountNumber (String)


    // TODO: Create a constructor that takes owner, accountNumber, and initialBalance
    // Initialize all three fields with the provided values


    // TODO: Implement deposit method
    // - Takes a double amount as parameter
    // - Returns boolean (true if successful, false if not)
    // - Only allow positive amounts
    // - Add amount to balance if valid


    // TODO: Implement withdraw method
    // - Takes a double amount as parameter
    // - Returns boolean (true if successful, false if not)
    // - Only allow positive amounts
    // - Only allow if balance is sufficient
    // - Subtract amount from balance if valid


    // TODO: Implement getBalance method
    // - Returns the current balance (double)


    // TODO: Implement getOwner method
    // - Returns the owner name (String)


    // TODO: Implement getAccountNumber method
    // - Returns the account number (String)


    // TODO: Implement displayAccountInfo method
    // - Prints account information in a formatted way
    // - Should display: account number, owner, and balance
    // - Format balance to 2 decimal places


    // Main method for manual testing (optional)
    public static void main(String[] args) {
        // You can test your class here
        // Example:
        // BankAccount account = new BankAccount("Alice Johnson", "ACC001", 1000.0);
        // account.displayAccountInfo();
        // account.deposit(500.0);
        // System.out.println("New balance: $" + account.getBalance());
    }
}
