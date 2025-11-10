import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InheritanceTest {

    @Test
    public void testSquareExtendsRectangle() {
        Assertions.assertTrue(Rectangle.class.isAssignableFrom(Square.class),
                "Square should extend Rectangle");
    }

    @Test
    public void testSquareIsShape() {
        Assertions.assertTrue(Shape.class.isAssignableFrom(Square.class),
                "Square should be a Shape (through Rectangle)");
    }

    @Test
    public void testSquareArea() {
        Square square = new Square(5.0);
        double area = square.getArea();
        Assertions.assertEquals(25.0, area, 0.001,
                "Square with side 5 should have area 25");
    }

    @Test
    public void testSquarePerimeter() {
        Square square = new Square(5.0);
        double perimeter = square.getPerimeter();
        Assertions.assertEquals(20.0, perimeter, 0.001,
                "Square with side 5 should have perimeter 20");
    }

    @Test
    public void testSquareAreaSmall() {
        Square square = new Square(3.0);
        double area = square.getArea();
        Assertions.assertEquals(9.0, area, 0.001,
                "Square with side 3 should have area 9");
    }

    @Test
    public void testSquarePerimeterSmall() {
        Square square = new Square(3.0);
        double perimeter = square.getPerimeter();
        Assertions.assertEquals(12.0, perimeter, 0.001,
                "Square with side 3 should have perimeter 12");
    }

    @Test
    public void testSquareAsRectangle() {
        Rectangle rect = new Square(4.0);
        Assertions.assertEquals(16.0, rect.getArea(), 0.001,
                "Square should work when treated as Rectangle");
        Assertions.assertEquals(16.0, rect.getPerimeter(), 0.001,
                "Square perimeter should work when treated as Rectangle");
    }

    @Test
    public void testSquareAsShape() {
        Shape shape = new Square(6.0);
        Assertions.assertEquals(36.0, shape.getArea(), 0.001,
                "Square should work when treated as Shape");
        Assertions.assertEquals(24.0, shape.getPerimeter(), 0.001,
                "Square perimeter should work when treated as Shape");
    }

    @Test
    public void testPolymorphicArray() {
        Shape[] shapes = {
            new Circle(2.0),
            new Rectangle(3.0, 4.0),
            new Square(5.0)
        };

        // Verify we can call methods on all shapes
        for (Shape shape : shapes) {
            double area = shape.getArea();
            double perimeter = shape.getPerimeter();
            Assertions.assertTrue(area > 0, "Each shape should have positive area");
            Assertions.assertTrue(perimeter > 0, "Each shape should have positive perimeter");
        }
    }

    @Test
    public void testSquareWithDecimals() {
        Square square = new Square(2.5);
        Assertions.assertEquals(6.25, square.getArea(), 0.001,
                "Square should handle decimal side lengths");
        Assertions.assertEquals(10.0, square.getPerimeter(), 0.001,
                "Square perimeter should work with decimals");
    }

    @Test
    public void testRectangleNotEqualDimensions() {
        Rectangle rect = new Rectangle(3.0, 5.0);
        Assertions.assertEquals(15.0, rect.getArea(), 0.001,
                "Rectangle with different dimensions should work");
        Assertions.assertEquals(16.0, rect.getPerimeter(), 0.001,
                "Rectangle perimeter with different dimensions should work");
    }

    @Test
    public void testInheritanceChain() {
        Square square = new Square(7.0);

        // Square is a Rectangle
        Assertions.assertTrue(square instanceof Rectangle,
                "Square should be instanceof Rectangle");

        // Square is a Shape
        Assertions.assertTrue(square instanceof Shape,
                "Square should be instanceof Shape");
    }
}
