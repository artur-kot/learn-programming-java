import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountManagerTest {

    private BankAccountManager manager;

    @BeforeEach
    public void setUp() {
        manager = new BankAccountManager();
    }

    @Test
    public void testAddAccount() {
        manager.addAccount("Alice", 1000.0);
        assertEquals(1, manager.getAccountCount(),
            "Manager should have 1 account after adding");

        manager.addAccount("Bob", 500.0);
        assertEquals(2, manager.getAccountCount(),
            "Manager should have 2 accounts after adding");
    }

    @Test
    public void testGetAccountCount() {
        assertEquals(0, manager.getAccountCount(),
            "New manager should have 0 accounts");

        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);
        manager.addAccount("Charlie", 750.0);

        assertEquals(3, manager.getAccountCount(),
            "Manager should track number of accounts");
    }

    @Test
    public void testFindAccountByOwner() {
        manager.addAccount("Alice Johnson", 1000.0);
        manager.addAccount("Bob Smith", 500.0);

        BankAccount found = manager.findAccountByOwner("Alice Johnson");
        assertNotNull(found, "Should find account by owner name");
        assertEquals("Alice Johnson", found.getOwner(),
            "Found account should have correct owner");
        assertEquals(1000.0, found.getBalance(), 0.01,
            "Found account should have correct balance");
    }

    @Test
    public void testFindAccountByOwnerNotFound() {
        manager.addAccount("Alice", 1000.0);

        BankAccount found = manager.findAccountByOwner("Bob");
        assertNull(found, "Should return null for non-existent owner");
    }

    @Test
    public void testFindAccountByNumber() {
        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);

        // Get the account number from one of the accounts
        BankAccount alice = manager.findAccountByOwner("Alice");
        String accountNumber = alice.getAccountNumber();

        BankAccount found = manager.findAccountByNumber(accountNumber);
        assertNotNull(found, "Should find account by account number");
        assertEquals("Alice", found.getOwner(),
            "Found account should have correct owner");
    }

    @Test
    public void testFindAccountByNumberNotFound() {
        manager.addAccount("Alice", 1000.0);

        BankAccount found = manager.findAccountByNumber("ACC9999");
        assertNull(found, "Should return null for non-existent account number");
    }

    @Test
    public void testGetTotalBalance() {
        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);
        manager.addAccount("Charlie", 750.0);

        double total = manager.getTotalBalance();
        assertEquals(2250.0, total, 0.01,
            "Total balance should be sum of all accounts");
    }

    @Test
    public void testGetTotalBalanceEmpty() {
        double total = manager.getTotalBalance();
        assertEquals(0.0, total, 0.01,
            "Total balance should be 0 for empty manager");
    }

    @Test
    public void testGetTotalBalanceAfterTransactions() {
        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);

        BankAccount alice = manager.findAccountByOwner("Alice");
        alice.deposit(500.0); // Alice now has 1500
        alice.withdraw(200.0); // Alice now has 1300

        BankAccount bob = manager.findAccountByOwner("Bob");
        bob.deposit(100.0); // Bob now has 600

        double total = manager.getTotalBalance();
        assertEquals(1900.0, total, 0.01,
            "Total should reflect transactions");
    }

    @Test
    public void testDisplayAllAccounts() {
        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);

        assertDoesNotThrow(() -> manager.displayAllAccounts(),
            "displayAllAccounts should not throw exception");
    }

    @Test
    public void testFindAccountModifiesOriginal() {
        manager.addAccount("Alice", 1000.0);

        BankAccount found = manager.findAccountByOwner("Alice");
        found.deposit(500.0);

        // Find again and check balance
        BankAccount foundAgain = manager.findAccountByOwner("Alice");
        assertEquals(1500.0, foundAgain.getBalance(), 0.01,
            "Modifications through found reference should affect original");
    }

    @Test
    public void testMultipleAccountsHaveUniqueNumbers() {
        manager.addAccount("Alice", 1000.0);
        manager.addAccount("Bob", 500.0);
        manager.addAccount("Charlie", 750.0);

        BankAccount alice = manager.findAccountByOwner("Alice");
        BankAccount bob = manager.findAccountByOwner("Bob");
        BankAccount charlie = manager.findAccountByOwner("Charlie");

        assertNotEquals(alice.getAccountNumber(), bob.getAccountNumber(),
            "Each account should have unique number");
        assertNotEquals(alice.getAccountNumber(), charlie.getAccountNumber(),
            "Each account should have unique number");
        assertNotEquals(bob.getAccountNumber(), charlie.getAccountNumber(),
            "Each account should have unique number");
    }
}
