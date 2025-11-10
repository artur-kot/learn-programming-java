
import java.util.ArrayList;

/**
 * Expense Tracker - Data Management
 *
 * This class provides basic expense tracking functionality including:
 * - Adding expenses to a list
 * - Viewing all expenses
 * - Calculating total expenses
 * - Getting totals by category
 * - Counting expenses
 *
 * Expenses are stored as strings in the format "Category:Amount"
 * Example: "Food:25.50"
 */
public class ExpenseTracker {

    /**
     * Add a new expense to the list.
     *
     * Format the expense as "Category:Amount" and add it to the expenses list.
     * Example: addExpense(expenses, "Food", 25.50) should add "Food:25.50"
     *
     * @param expenses The list to add the expense to
     * @param category The category of the expense (e.g., "Food", "Transport")
     * @param amount The amount spent
     */
    public static void addExpense(ArrayList<String> expenses, String category, double amount) {
        // TODO: Format the expense as "Category:Amount" and add to list
        // Hint: Use String concatenation or String.format()
    }

    /**
     * Display all expenses in a formatted list.
     *
     * Format:
     * Your Expenses:
     * 1. Food: $25.50
     * 2. Transport: $15.00
     *
     * @param expenses The list of expenses to display
     */
    public static void viewExpenses(ArrayList<String> expenses) {
        // TODO: Print "Your Expenses:" header
        // TODO: Loop through expenses with index starting at 1
        // TODO: Parse each expense string and display formatted
        // Hint: Use split(":") to separate category and amount
        // Hint: Use %.2f to format money with 2 decimal places
    }

    /**
     * Calculate the total of all expenses.
     *
     * @param expenses The list of expenses
     * @return The sum of all expense amounts
     */
    public static double getTotalExpenses(ArrayList<String> expenses) {
        // TODO: Use accumulator pattern to sum all amounts
        // TODO: Parse each expense string to extract the amount
        // TODO: Return the total
        // Hint: Initialize a variable to 0, loop through expenses, add each amount
        return 0.0;
    }

    /**
     * Calculate the total expenses for a specific category.
     *
     * @param expenses The list of expenses
     * @param category The category to filter by (e.g., "Food")
     * @return The sum of expenses in that category
     */
    public static double getTotalByCategory(ArrayList<String> expenses, String category) {
        // TODO: Loop through expenses
        // TODO: Parse each expense to get its category and amount
        // TODO: If category matches, add amount to total
        // TODO: Return the category total
        return 0.0;
    }

    /**
     * Get the total number of expenses.
     *
     * @param expenses The list of expenses
     * @return The count of expenses
     */
    public static int getExpenseCount(ArrayList<String> expenses) {
        // TODO: Return the size of the expenses list
        return 0;
    }

    /**
     * Main method for testing your implementation.
     */
    public static void main(String[] args) {
        ArrayList<String> expenses = new ArrayList<>();

        // Test adding expenses
        addExpense(expenses, "Food", 25.50);
        addExpense(expenses, "Transport", 15.00);
        addExpense(expenses, "Entertainment", 40.00);
        addExpense(expenses, "Food", 30.00);

        // Test viewing expenses
        viewExpenses(expenses);

        // Test totals
        System.out.println("\nTotal: $" + getTotalExpenses(expenses));
        System.out.println("Food Total: $" + getTotalByCategory(expenses, "Food"));
        System.out.println("Count: " + getExpenseCount(expenses));
    }
}
