/**
 * BankAccount - Enhanced with static members for account tracking
 *
 * Your task: Add static members to auto-generate account numbers
 * and track total accounts created
 *
 * This builds on Exercise 42. Copy your solution and enhance it!
 *
 * Concepts you'll practice:
 * - Static variables (class variables)
 * - Static methods
 * - Auto-incrementing IDs
 * - Tracking class-level data
 */
public class BankAccount {

    // TODO: Add static variable nextAccountNumber (int) - initialize to 1001
    // This will be used to auto-generate account numbers


    // TODO: Add static variable accountCount (int) - initialize to 0
    // This will track total accounts created


    // TODO: Declare three private instance fields:
    // - owner (String)
    // - balance (double)
    // - accountNumber (String)


    // TODO: Modify constructor to take only owner and initialBalance
    // - Auto-generate accountNumber using "ACC" + nextAccountNumber
    // - Increment nextAccountNumber after assignment
    // - Increment accountCount
    // - Initialize owner and balance


    // TODO: Implement deposit method (from Exercise 42)
    // - Takes a double amount as parameter
    // - Returns boolean (true if successful, false if not)
    // - Only allow positive amounts
    // - Add amount to balance if valid


    // TODO: Implement withdraw method (from Exercise 42)
    // - Takes a double amount as parameter
    // - Returns boolean (true if successful, false if not)
    // - Only allow positive amounts
    // - Only allow if balance is sufficient
    // - Subtract amount from balance if valid


    // TODO: Implement getBalance method (from Exercise 42)


    // TODO: Implement getOwner method (from Exercise 42)


    // TODO: Implement getAccountNumber method (from Exercise 42)


    // TODO: Implement displayAccountInfo method (from Exercise 42)


    // TODO: Implement STATIC method getAccountCount
    // - Returns the total number of accounts created
    // - This is a class method, not an instance method!


    // Main method for testing
    public static void main(String[] args) {
        // Test static method before creating any accounts
        System.out.println("Accounts created: " + BankAccount.getAccountCount());

        BankAccount account1 = new BankAccount("Alice", 1000);
        BankAccount account2 = new BankAccount("Bob", 1500);

        account1.displayAccountInfo();
        System.out.println();
        account2.displayAccountInfo();

        System.out.println("\nTotal accounts: " + BankAccount.getAccountCount());
    }
}
