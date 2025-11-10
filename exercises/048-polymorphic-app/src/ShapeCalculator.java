import java.util.ArrayList;

/**
 * ShapeCalculator - a utility class demonstrating practical polymorphism.
 *
 * This class contains static methods that work with collections of shapes,
 * using polymorphism, type checking (instanceof), and type casting.
 *
 * Your task: Implement all four methods
 */
public class ShapeCalculator {

    // TODO: Implement getTotalArea
    // Calculate and return the sum of all shape areas in the list
    // Use a loop to iterate through shapes polymorphically
    // Each shape's getArea() will be called correctly based on its actual type
    public static double getTotalArea(ArrayList<Shape> shapes) {
        // Your code here
        return 0.0;  // Replace with actual calculation
    }

    // TODO: Implement findLargestShape
    // Find and return the shape with the largest area
    // Return null if the list is empty
    // Use compareTo() method or direct area comparison
    // Hint: Keep track of the largest shape as you iterate
    public static Shape findLargestShape(ArrayList<Shape> shapes) {
        // Your code here
        return null;  // Replace with actual logic
    }

    // TODO: Implement filterByType
    // Filter shapes by type and return a new ArrayList containing only matching shapes
    // Parameters:
    //   - shapes: the list to filter
    //   - type: the shape type as a string ("Circle", "Rectangle", "Square")
    // Type matching should be case-insensitive
    // Use instanceof to check each shape's type
    // Hint: shape instanceof Circle checks if shape is a Circle
    public static ArrayList<Shape> filterByType(ArrayList<Shape> shapes, String type) {
        // Your code here
        return null;  // Replace with actual filtered list
    }

    // TODO: Implement getRadiusFromShape
    // Check if the shape is a Circle, and if so, return its radius
    // Return -1.0 if the shape is not a Circle
    // This demonstrates downcasting - accessing subclass-specific methods
    // Steps:
    //   1. Check if shape instanceof Circle
    //   2. If yes, cast to Circle: Circle circle = (Circle) shape;
    //   3. Call circle.getRadius() and return it
    //   4. If no, return -1.0
    public static double getRadiusFromShape(Shape shape) {
        // Your code here
        return 0.0;  // Replace with actual logic
    }
}
