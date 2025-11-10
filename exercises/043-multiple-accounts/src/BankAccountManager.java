import java.util.ArrayList;

/**
 * BankAccountManager - Manages multiple bank accounts
 *
 * Your task: Create a manager class that handles a collection of BankAccount objects
 *
 * Concepts you'll practice:
 * - Collections of objects (ArrayList<BankAccount>)
 * - Object references
 * - Searching through collections
 * - Aggregating data from multiple objects
 */
public class BankAccountManager {

    // TODO: Declare private field accounts (ArrayList<BankAccount>)


    // TODO: Create constructor that initializes the ArrayList


    // TODO: Implement addAccount method
    // - Takes owner (String) and initialBalance (double) as parameters
    // - Creates a new BankAccount
    // - Adds it to the accounts list


    // TODO: Implement findAccountByOwner method
    // - Takes owner name (String) as parameter
    // - Returns BankAccount if found, null if not found
    // - Use a loop to search through accounts
    // - Compare using .equals() for strings


    // TODO: Implement findAccountByNumber method
    // - Takes account number (String) as parameter
    // - Returns BankAccount if found, null if not found
    // - Similar to findAccountByOwner


    // TODO: Implement getTotalBalance method
    // - Returns double (sum of all account balances)
    // - Loop through all accounts and sum their balances


    // TODO: Implement displayAllAccounts method
    // - Prints information for all accounts
    // - Loop through accounts and call displayAccountInfo on each
    // - Add blank line between accounts for readability


    // TODO: Implement getAccountCount method
    // - Returns int (number of accounts in this manager)
    // - Use ArrayList's size() method


    // Main method for testing
    public static void main(String[] args) {
        BankAccountManager manager = new BankAccountManager();

        System.out.println("Initial count: " + BankAccount.getAccountCount());

        manager.addAccount("Alice Johnson", 1000.0);
        manager.addAccount("Bob Smith", 1500.0);
        manager.addAccount("Charlie Brown", 500.0);

        System.out.println("\nAll accounts:");
        manager.displayAllAccounts();

        System.out.println("\nSearching for Bob Smith:");
        BankAccount found = manager.findAccountByOwner("Bob Smith");
        if (found != null) {
            System.out.println("Found: " + found.getAccountNumber() + " - $" + found.getBalance());
        }

        System.out.println("\nTotal balance: $" + manager.getTotalBalance());
        System.out.println("Accounts in manager: " + manager.getAccountCount());
        System.out.println("Total accounts created: " + BankAccount.getAccountCount());
    }
}
