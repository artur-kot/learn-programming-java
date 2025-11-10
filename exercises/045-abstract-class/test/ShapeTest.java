import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.lang.reflect.Modifier;

public class ShapeTest {

    @Test
    public void testShapeIsAbstract() {
        Assertions.assertTrue(Modifier.isAbstract(Shape.class.getModifiers()),
                "Shape class should be abstract");
    }

    @Test
    public void testCircleExtendsShape() {
        Assertions.assertTrue(Shape.class.isAssignableFrom(Circle.class),
                "Circle should extend Shape");
    }

    @Test
    public void testRectangleExtendsShape() {
        Assertions.assertTrue(Shape.class.isAssignableFrom(Rectangle.class),
                "Rectangle should extend Shape");
    }

    @Test
    public void testCircleArea() {
        Shape circle = new Circle(5.0);
        double area = circle.getArea();
        double expected = Math.PI * 25.0;
        Assertions.assertEquals(expected, area, 0.001,
                "Circle area with radius 5 should be π × 25");
    }

    @Test
    public void testCirclePerimeter() {
        Shape circle = new Circle(5.0);
        double perimeter = circle.getPerimeter();
        double expected = 2 * Math.PI * 5.0;
        Assertions.assertEquals(expected, perimeter, 0.001,
                "Circle perimeter with radius 5 should be 2 × π × 5");
    }

    @Test
    public void testCircleAreaSmallRadius() {
        Shape circle = new Circle(1.0);
        double area = circle.getArea();
        double expected = Math.PI;
        Assertions.assertEquals(expected, area, 0.001,
                "Circle area with radius 1 should be π");
    }

    @Test
    public void testRectangleArea() {
        Shape rectangle = new Rectangle(4.0, 6.0);
        double area = rectangle.getArea();
        Assertions.assertEquals(24.0, area, 0.001,
                "Rectangle area with width 4 and height 6 should be 24");
    }

    @Test
    public void testRectanglePerimeter() {
        Shape rectangle = new Rectangle(4.0, 6.0);
        double perimeter = rectangle.getPerimeter();
        Assertions.assertEquals(20.0, perimeter, 0.001,
                "Rectangle perimeter with width 4 and height 6 should be 20");
    }

    @Test
    public void testRectangleSquare() {
        Shape square = new Rectangle(5.0, 5.0);
        double area = square.getArea();
        Assertions.assertEquals(25.0, area, 0.001,
                "Rectangle with equal sides should calculate area correctly");
    }

    @Test
    public void testPolymorphism() {
        Shape shape1 = new Circle(3.0);
        Shape shape2 = new Rectangle(3.0, 4.0);

        Assertions.assertNotNull(shape1.getArea(),
                "Should be able to call getArea() on Shape reference to Circle");
        Assertions.assertNotNull(shape2.getArea(),
                "Should be able to call getArea() on Shape reference to Rectangle");
    }

    @Test
    public void testRectangleDecimalValues() {
        Shape rectangle = new Rectangle(2.5, 3.5);
        double area = rectangle.getArea();
        Assertions.assertEquals(8.75, area, 0.001,
                "Rectangle should handle decimal dimensions correctly");
    }

    @Test
    public void testCircleAreaLargeRadius() {
        Shape circle = new Circle(10.0);
        double area = circle.getArea();
        double expected = Math.PI * 100.0;
        Assertions.assertEquals(expected, area, 0.001,
                "Circle area with radius 10 should be π × 100");
    }
}
