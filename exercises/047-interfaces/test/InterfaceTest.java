import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class InterfaceTest {

    @Test
    public void testDrawableInterface() {
        Assertions.assertTrue(Drawable.class.isInterface(),
                "Drawable should be an interface");
    }

    @Test
    public void testShapeImplementsComparable() {
        Assertions.assertTrue(Comparable.class.isAssignableFrom(Shape.class),
                "Shape should implement Comparable");
    }

    @Test
    public void testShapeImplementsDrawable() {
        Assertions.assertTrue(Drawable.class.isAssignableFrom(Shape.class),
                "Shape should implement Drawable");
    }

    @Test
    public void testCircleDraw() {
        Circle circle = new Circle(5.0);
        String result = circle.draw();
        Assertions.assertNotNull(result, "draw() should return a non-null string");
        Assertions.assertTrue(result.toLowerCase().contains("circle"),
                "Circle's draw() should mention 'circle'");
        Assertions.assertTrue(result.contains("5"),
                "Circle's draw() should include the radius value");
    }

    @Test
    public void testRectangleDraw() {
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        String result = rectangle.draw();
        Assertions.assertNotNull(result, "draw() should return a non-null string");
        Assertions.assertTrue(result.toLowerCase().contains("rectangle"),
                "Rectangle's draw() should mention 'rectangle'");
    }

    @Test
    public void testSquareDraw() {
        Square square = new Square(5.0);
        String result = square.draw();
        Assertions.assertNotNull(result, "draw() should return a non-null string");
        Assertions.assertTrue(result.toLowerCase().contains("square"),
                "Square's draw() should mention 'square'");
        Assertions.assertTrue(result.contains("5"),
                "Square's draw() should include the side length");
    }

    @Test
    public void testCompareToDifferentAreas() {
        Shape circle = new Circle(5.0);  // Area ~78.54
        Shape rectangle = new Rectangle(4.0, 6.0);  // Area 24.0

        Assertions.assertTrue(circle.compareTo(rectangle) > 0,
                "Circle with larger area should be greater than rectangle");
        Assertions.assertTrue(rectangle.compareTo(circle) < 0,
                "Rectangle with smaller area should be less than circle");
    }

    @Test
    public void testCompareToSameArea() {
        Shape square1 = new Square(5.0);  // Area 25.0
        Shape square2 = new Square(5.0);  // Area 25.0

        Assertions.assertEquals(0, square1.compareTo(square2),
                "Shapes with same area should compare as equal");
    }

    @Test
    public void testCompareToSelf() {
        Shape circle = new Circle(3.0);
        Assertions.assertEquals(0, circle.compareTo(circle),
                "Shape compared to itself should return 0");
    }

    @Test
    public void testPolymorphismWithDrawable() {
        Drawable circle = new Circle(3.0);
        Drawable rectangle = new Rectangle(2.0, 4.0);
        Drawable square = new Square(3.0);

        // All should work as Drawable
        Assertions.assertNotNull(circle.draw());
        Assertions.assertNotNull(rectangle.draw());
        Assertions.assertNotNull(square.draw());
    }

    @Test
    public void testPolymorphismWithComparable() {
        Comparable<Shape> shape1 = new Circle(5.0);
        Comparable<Shape> shape2 = new Rectangle(4.0, 6.0);

        Assertions.assertNotNull(shape1);
        Assertions.assertNotNull(shape2);
    }

    @Test
    public void testDrawableArray() {
        Drawable[] drawables = {
            new Circle(3.0),
            new Rectangle(2.0, 4.0),
            new Square(3.0)
        };

        for (Drawable d : drawables) {
            String drawing = d.draw();
            Assertions.assertNotNull(drawing, "Each drawable should produce a non-null string");
            Assertions.assertFalse(drawing.isEmpty(), "Draw output should not be empty");
        }
    }

    @Test
    public void testCompareCircleToSquare() {
        Shape circle = new Circle(3.0);  // Area ~28.27
        Shape square = new Square(5.0);  // Area 25.0

        Assertions.assertTrue(circle.compareTo(square) > 0,
                "Circle with area ~28.27 should be greater than square with area 25");
    }

    @Test
    public void testCompareRectangleToSquare() {
        Shape rectangle = new Rectangle(3.0, 4.0);  // Area 12.0
        Shape square = new Square(4.0);  // Area 16.0

        Assertions.assertTrue(rectangle.compareTo(square) < 0,
                "Rectangle with area 12 should be less than square with area 16");
    }
}
