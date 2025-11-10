import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Custom Exceptions Tests")
public class CustomExceptionsTest {

    @Test
    @DisplayName("InsufficientFundsException can be created and thrown")
    public void testInsufficientFundsException() {
        InsufficientFundsException exception = new InsufficientFundsException("Test message");
        assertEquals("Test message", exception.getMessage());
        assertTrue(exception instanceof Exception);
    }

    @Test
    @DisplayName("InvalidAccountException can be created and thrown")
    public void testInvalidAccountException() {
        InvalidAccountException exception = new InvalidAccountException("Invalid account");
        assertEquals("Invalid account", exception.getMessage());
        assertTrue(exception instanceof Exception);
    }

    @Test
    @DisplayName("TransactionFailedException can be created and thrown")
    public void testTransactionFailedException() {
        TransactionFailedException exception = new TransactionFailedException("Transaction failed");
        assertEquals("Transaction failed", exception.getMessage());
        assertTrue(exception instanceof Exception);
    }

    @Test
    @DisplayName("BankAccount can be created with valid data")
    public void testBankAccountCreation() throws InvalidAccountException, TransactionFailedException {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);

        assertEquals("12345678", account.getAccountNumber());
        assertEquals("John Doe", account.getOwnerName());
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for null account number")
    public void testNullAccountNumber() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount(null, "John Doe", 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for empty account number")
    public void testEmptyAccountNumber() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount("", "John Doe", 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for short account number")
    public void testShortAccountNumber() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount("123", "John Doe", 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for long account number")
    public void testLongAccountNumber() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount("123456789", "John Doe", 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for null owner name")
    public void testNullOwnerName() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount("12345678", null, 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws InvalidAccountException for empty owner name")
    public void testEmptyOwnerName() {
        assertThrows(InvalidAccountException.class, () -> {
            new BankAccount("12345678", "", 1000.0);
        });
    }

    @Test
    @DisplayName("BankAccount throws TransactionFailedException for negative initial balance")
    public void testNegativeInitialBalance() {
        assertThrows(TransactionFailedException.class, () -> {
            new BankAccount("12345678", "John Doe", -100.0);
        });
    }

    @Test
    @DisplayName("withdraw() reduces balance correctly")
    public void testWithdrawSuccess() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);
        account.withdraw(300.0);

        assertEquals(700.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("withdraw() throws InsufficientFundsException when balance is too low")
    public void testWithdrawInsufficientFunds() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 100.0);

        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(200.0);
        });

        assertTrue(exception.getMessage().contains("Insufficient") ||
                   exception.getMessage().contains("insufficient"));
    }

    @Test
    @DisplayName("withdraw() throws TransactionFailedException for negative amount")
    public void testWithdrawNegativeAmount() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);

        assertThrows(TransactionFailedException.class, () -> {
            account.withdraw(-50.0);
        });
    }

    @Test
    @DisplayName("withdraw() throws TransactionFailedException for zero amount")
    public void testWithdrawZeroAmount() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);

        assertThrows(TransactionFailedException.class, () -> {
            account.withdraw(0);
        });
    }

    @Test
    @DisplayName("deposit() increases balance correctly")
    public void testDepositSuccess() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);
        account.deposit(500.0);

        assertEquals(1500.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("deposit() throws TransactionFailedException for negative amount")
    public void testDepositNegativeAmount() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);

        TransactionFailedException exception = assertThrows(TransactionFailedException.class, () -> {
            account.deposit(-100.0);
        });

        assertTrue(exception.getMessage().contains("positive") ||
                   exception.getMessage().contains("negative"));
    }

    @Test
    @DisplayName("deposit() throws TransactionFailedException for zero amount")
    public void testDepositZeroAmount() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);

        assertThrows(TransactionFailedException.class, () -> {
            account.deposit(0);
        });
    }

    @Test
    @DisplayName("validateAccount() accepts valid account number")
    public void testValidateAccountValid() {
        assertDoesNotThrow(() -> {
            BankAccount.validateAccount("12345678");
        });
    }

    @Test
    @DisplayName("validateAccount() throws for null")
    public void testValidateAccountNull() {
        assertThrows(InvalidAccountException.class, () -> {
            BankAccount.validateAccount(null);
        });
    }

    @Test
    @DisplayName("validateAccount() throws for empty string")
    public void testValidateAccountEmpty() {
        assertThrows(InvalidAccountException.class, () -> {
            BankAccount.validateAccount("");
        });
    }

    @Test
    @DisplayName("validateAccount() throws for wrong length")
    public void testValidateAccountWrongLength() {
        assertThrows(InvalidAccountException.class, () -> {
            BankAccount.validateAccount("12345");
        });
    }

    @Test
    @DisplayName("toString() returns correct format")
    public void testToString() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 1500.50);
        String str = account.toString();

        assertTrue(str.contains("12345678"));
        assertTrue(str.contains("John Doe"));
        assertTrue(str.contains("1500.50") || str.contains("1500.5"));
    }

    @Test
    @DisplayName("Multiple transactions work correctly")
    public void testMultipleTransactions() throws Exception {
        BankAccount account = new BankAccount("12345678", "Jane Smith", 500.0);

        account.deposit(200.0);
        assertEquals(700.0, account.getBalance(), 0.01);

        account.withdraw(150.0);
        assertEquals(550.0, account.getBalance(), 0.01);

        account.deposit(50.0);
        assertEquals(600.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Balance doesn't change after failed withdrawal")
    public void testFailedWithdrawalDoesntChangeBalance() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 100.0);

        try {
            account.withdraw(200.0);
        } catch (InsufficientFundsException e) {
            // Expected
        }

        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Balance doesn't change after failed deposit")
    public void testFailedDepositDoesntChangeBalance() throws Exception {
        BankAccount account = new BankAccount("12345678", "John Doe", 100.0);

        try {
            account.deposit(-50.0);
        } catch (TransactionFailedException e) {
            // Expected
        }

        assertEquals(100.0, account.getBalance(), 0.01);
    }
}
