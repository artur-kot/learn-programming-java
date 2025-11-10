/**
 * Circle class - now with draw() implementation!
 *
 * Your task: Implement the draw() method
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // TODO: Implement the draw() method from Drawable interface
    // Return a String like: "Drawing a circle with radius X.X"
    // Use @Override annotation
    // Hint: return "Drawing a circle with radius " + radius;

}
