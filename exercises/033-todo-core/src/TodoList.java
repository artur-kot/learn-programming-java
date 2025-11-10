import java.util.ArrayList;

/**
 * Exercise 033: To-Do List - Core Functionality
 *
 * Build a simple to-do list manager with add, view, remove, and count operations.
 *
 * Concepts you'll practice:
 * - ArrayList operations (add, remove, get, size)
 * - Indexed output and display formatting
 * - Input validation and error handling
 * - CRUD operations (Create, Read, Delete)
 */
public class TodoList {

    /**
     * Add a new task to the list
     *
     * @param tasks The ArrayList to add the task to
     * @param task The task description to add
     *
     * TODO: Implement this method
     * - Check if task is null or empty (use task.isEmpty())
     * - If valid, add the task to the ArrayList
     * - Use ArrayList's add() method
     */
    public void addTask(ArrayList<String> tasks, String task) {
        // Your code here
    }

    /**
     * Display all tasks with numbered list (1, 2, 3...)
     *
     * @param tasks The ArrayList of tasks to display
     *
     * TODO: Implement this method
     * - Check if the list is empty
     * - If empty, print "No tasks to display."
     * - Otherwise, loop through tasks and print each with a number
     * - Format: "1. Task description"
     * - Numbers should start at 1 (not 0)
     * - Use tasks.get(index) to access each task
     */
    public void viewTasks(ArrayList<String> tasks) {
        // Your code here
    }

    /**
     * Remove a task at the specified index
     *
     * @param tasks The ArrayList to remove from
     * @param index The index of the task to remove (0-based)
     *
     * TODO: Implement this method
     * - Validate the index first (must be >= 0 and < tasks.size())
     * - If invalid, print "Invalid index."
     * - If valid, remove the task using tasks.remove(index)
     */
    public void removeTask(ArrayList<String> tasks, int index) {
        // Your code here
    }

    /**
     * Get the total number of tasks
     *
     * @param tasks The ArrayList to count
     * @return The number of tasks in the list
     *
     * TODO: Implement this method
     * - Check if tasks is null, return 0 if so
     * - Otherwise, return tasks.size()
     */
    public int getTaskCount(ArrayList<String> tasks) {
        // Your code here
        return 0;
    }

    /**
     * Main method - optional integration test
     * You can use this to manually test your implementation
     */
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        ArrayList<String> myTasks = new ArrayList<>();

        // Test your implementation here
        System.out.println("=== To-Do List Manager ===");

        // Add some tasks
        todoList.addTask(myTasks, "Buy groceries");
        todoList.addTask(myTasks, "Study Java");
        todoList.addTask(myTasks, "Call dentist");

        // View all tasks
        System.out.println("\nYour tasks:");
        todoList.viewTasks(myTasks);

        // Show count
        System.out.println("\nTotal tasks: " + todoList.getTaskCount(myTasks));

        // Remove a task
        System.out.println("\nRemoving task at index 1...");
        todoList.removeTask(myTasks, 1);

        // View tasks again
        System.out.println("\nUpdated tasks:");
        todoList.viewTasks(myTasks);

        // Try invalid removal
        System.out.println("\nTrying to remove invalid index 10...");
        todoList.removeTask(myTasks, 10);
    }
}
