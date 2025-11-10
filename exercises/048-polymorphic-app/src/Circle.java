/**
 * Circle class - solution from previous exercise.
 * Now includes getRadius() method for type casting demonstration.
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

    @Override
    public String draw() {
        return "Drawing a circle with radius " + radius;
    }

    // Getter for radius - needed for type casting exercise
    public double getRadius() {
        return radius;
    }
}
