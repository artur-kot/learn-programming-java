
import java.util.ArrayList;

/**
 * Expense Analytics - Advanced Data Analysis
 *
 * This class provides analytical functions for expense data including:
 * - Filtering expenses by category
 * - Finding highest and lowest expenses
 * - Calculating average expenses
 * - Budget checking and warnings
 * - Generating comprehensive reports
 *
 * IMPORTANT: This exercise builds on Exercise 035. You'll need the same
 * expense format: "Category:Amount" (e.g., "Food:25.50")
 */
public class ExpenseAnalytics {

    /**
     * Filter expenses by category.
     *
     * Return a new ArrayList containing only expenses that match the given category.
     *
     * @param expenses The list of all expenses
     * @param category The category to filter by
     * @return A new list with only matching expenses
     */
    public static ArrayList<String> filterByCategory(ArrayList<String> expenses, String category) {
        // TODO: Create a new ArrayList to store filtered results
        // TODO: Loop through all expenses
        // TODO: For each expense, parse the category (split by ":")
        // TODO: If category matches, add to filtered list
        // TODO: Return the filtered list
        return null;
    }

    /**
     * Find the highest expense amount.
     *
     * @param expenses The list of expenses
     * @return The amount of the highest expense (0.0 if list is empty)
     */
    public static double findHighestExpense(ArrayList<String> expenses) {
        // TODO: Handle empty list case (return 0.0)
        // TODO: Initialize max to 0 or first expense amount
        // TODO: Loop through expenses
        // TODO: Parse amount from each expense
        // TODO: If amount > max, update max
        // TODO: Return max
        return 0.0;
    }

    /**
     * Find the lowest expense amount.
     *
     * @param expenses The list of expenses
     * @return The amount of the lowest expense (0.0 if list is empty)
     */
    public static double findLowestExpense(ArrayList<String> expenses) {
        // TODO: Handle empty list case (return 0.0)
        // TODO: Initialize min to a very large number or first expense amount
        // TODO: Loop through expenses
        // TODO: Parse amount from each expense
        // TODO: If amount < min, update min
        // TODO: Return min
        return 0.0;
    }

    /**
     * Calculate the average expense amount.
     *
     * @param expenses The list of expenses
     * @return The average expense (0.0 if list is empty)
     */
    public static double getAverageExpense(ArrayList<String> expenses) {
        // TODO: Handle empty list case (return 0.0)
        // TODO: Calculate total (sum all amounts)
        // TODO: Get count of expenses
        // TODO: Return total / count
        // Hint: Be careful with integer division - use double!
        return 0.0;
    }

    /**
     * Check if expenses are within budget and return a message.
     *
     * If over budget: "Warning: You are $X.XX over budget!"
     * If under budget: "Good job! You are $X.XX under budget."
     *
     * @param expenses The list of expenses
     * @param budget The budget amount
     * @return A message indicating budget status
     */
    public static String checkBudget(ArrayList<String> expenses, double budget) {
        // TODO: Calculate total expenses (sum all amounts)
        // TODO: Calculate difference (total - budget)
        // TODO: If total > budget, return over-budget warning
        // TODO: Otherwise, return under-budget success message
        // Hint: Use String.format("%.2f", amount) for 2 decimal places
        return "";
    }

    /**
     * Generate a comprehensive expense report.
     *
     * Display:
     * - Total expenses
     * - Number of items
     * - Average expense
     * - Highest expense
     * - Lowest expense
     *
     * @param expenses The list of expenses
     */
    public static void generateReport(ArrayList<String> expenses) {
        // TODO: Print report header
        // TODO: Calculate all statistics (total, count, average, max, min)
        // TODO: Format and display each statistic
        // TODO: Use printf for aligned formatting
        // Hint: Use %.2f for currency formatting
    }

    /**
     * Helper method to get total expenses (copied from Exercise 035).
     * You may need this for calculating totals.
     *
     * @param expenses The list of expenses
     * @return The sum of all expenses
     */
    public static double getTotalExpenses(ArrayList<String> expenses) {
        double total = 0.0;
        for (String expense : expenses) {
            String[] parts = expense.split(":");
            double amount = Double.parseDouble(parts[1]);
            total += amount;
        }
        return total;
    }

    /**
     * Main method for testing your implementation.
     */
    public static void main(String[] args) {
        ArrayList<String> expenses = new ArrayList<>();

        // Build sample data
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");
        expenses.add("Entertainment:40.00");
        expenses.add("Food:30.00");
        expenses.add("Transport:8.50");

        // Test filtering
        System.out.println("=== Filter Test ===");
        ArrayList<String> foodExpenses = filterByCategory(expenses, "Food");
        System.out.println("Food expenses count: " + foodExpenses.size());

        // Test min/max
        System.out.println("\n=== Min/Max Test ===");
        System.out.println("Highest: $" + findHighestExpense(expenses));
        System.out.println("Lowest: $" + findLowestExpense(expenses));

        // Test average
        System.out.println("\n=== Average Test ===");
        System.out.printf("Average: $%.2f\n", getAverageExpense(expenses));

        // Test budget check
        System.out.println("\n=== Budget Check ===");
        System.out.println(checkBudget(expenses, 100.00));

        // Test report generation
        System.out.println("\n=== Full Report ===");
        generateReport(expenses);
    }
}
