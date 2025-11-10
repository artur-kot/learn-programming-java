/**
 * Rectangle class - now with draw() implementation!
 *
 * Your task: Implement the draw() method
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // TODO: Implement the draw() method from Drawable interface
    // Return a String like: "Drawing a rectangle with width X.X and height Y.Y"
    // Use @Override annotation

}
