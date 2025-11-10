/**
 * Abstract Shape class - now with interfaces!
 *
 * This class now implements Comparable and Drawable, making all shapes
 * comparable by area and drawable.
 *
 * Your task: Make Shape implement both Comparable<Shape> and Drawable interfaces
 */
// TODO: Add "implements Comparable<Shape>, Drawable" to the class declaration
public abstract class Shape {

    // Existing abstract methods from previous exercises
    public abstract double getArea();

    public abstract double getPerimeter();

    // TODO: Implement the compareTo method from Comparable<Shape>
    // Compare shapes based on their area
    // Return negative if this shape is smaller, positive if larger, 0 if equal
    // Hint: Use Double.compare(this.getArea(), other.getArea())
    // Don't forget @Override annotation!

    // TODO: Declare draw() as abstract so each shape implements it differently
    // Since Shape is abstract, we can make draw() abstract too
    // Each concrete shape will provide its own implementation

}
