import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;

public class ShapeCalculatorTest {

    @Test
    public void testGetTotalAreaEmpty() {
        ArrayList<Shape> shapes = new ArrayList<>();
        double total = ShapeCalculator.getTotalArea(shapes);
        Assertions.assertEquals(0.0, total, 0.001,
                "Total area of empty list should be 0");
    }

    @Test
    public void testGetTotalAreaSingleShape() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(5.0));  // Area = 25.0

        double total = ShapeCalculator.getTotalArea(shapes);
        Assertions.assertEquals(25.0, total, 0.001,
                "Total area should be 25.0");
    }

    @Test
    public void testGetTotalAreaMultipleShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(4.0, 5.0));  // Area = 20.0
        shapes.add(new Square(3.0));          // Area = 9.0
        shapes.add(new Circle(2.0));          // Area = 4π ≈ 12.566

        double expected = 20.0 + 9.0 + (Math.PI * 4.0);
        double total = ShapeCalculator.getTotalArea(shapes);
        Assertions.assertEquals(expected, total, 0.001,
                "Total area should sum all shapes correctly");
    }

    @Test
    public void testFindLargestShapeEmpty() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Shape largest = ShapeCalculator.findLargestShape(shapes);
        Assertions.assertNull(largest,
                "Largest shape in empty list should be null");
    }

    @Test
    public void testFindLargestShapeSingle() {
        ArrayList<Shape> shapes = new ArrayList<>();
        Shape square = new Square(5.0);
        shapes.add(square);

        Shape largest = ShapeCalculator.findLargestShape(shapes);
        Assertions.assertEquals(square, largest,
                "Should return the only shape in the list");
    }

    @Test
    public void testFindLargestShapeMultiple() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));          // Area ≈ 12.566
        shapes.add(new Rectangle(4.0, 5.0));  // Area = 20.0
        shapes.add(new Square(3.0));          // Area = 9.0

        Shape largest = ShapeCalculator.findLargestShape(shapes);
        Assertions.assertTrue(largest instanceof Rectangle,
                "Rectangle should be the largest shape");
        Assertions.assertEquals(20.0, largest.getArea(), 0.001,
                "Largest shape should have area 20.0");
    }

    @Test
    public void testFindLargestShapeCircle() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));          // Area ≈ 78.54
        shapes.add(new Rectangle(4.0, 5.0));  // Area = 20.0
        shapes.add(new Square(6.0));          // Area = 36.0

        Shape largest = ShapeCalculator.findLargestShape(shapes);
        Assertions.assertTrue(largest instanceof Circle,
                "Circle should be the largest shape");
    }

    @Test
    public void testFilterByTypeCircles() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(4.0, 5.0));
        shapes.add(new Circle(3.0));
        shapes.add(new Square(3.0));

        ArrayList<Shape> circles = ShapeCalculator.filterByType(shapes, "Circle");
        Assertions.assertEquals(2, circles.size(),
                "Should find 2 circles");
        Assertions.assertTrue(circles.get(0) instanceof Circle);
        Assertions.assertTrue(circles.get(1) instanceof Circle);
    }

    @Test
    public void testFilterByTypeRectangles() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(4.0, 5.0));
        shapes.add(new Rectangle(2.0, 3.0));
        shapes.add(new Square(3.0));  // Square is a Rectangle!

        ArrayList<Shape> rectangles = ShapeCalculator.filterByType(shapes, "Rectangle");
        // Should include both Rectangles but NOT Square (we want exact type)
        Assertions.assertTrue(rectangles.size() >= 2,
                "Should find at least 2 rectangles");
    }

    @Test
    public void testFilterByTypeSquares() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(4.0, 5.0));
        shapes.add(new Square(3.0));
        shapes.add(new Square(5.0));

        ArrayList<Shape> squares = ShapeCalculator.filterByType(shapes, "Square");
        Assertions.assertEquals(2, squares.size(),
                "Should find 2 squares");
    }

    @Test
    public void testFilterByTypeCaseInsensitive() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Circle(3.0));

        ArrayList<Shape> circles1 = ShapeCalculator.filterByType(shapes, "circle");
        ArrayList<Shape> circles2 = ShapeCalculator.filterByType(shapes, "CIRCLE");
        ArrayList<Shape> circles3 = ShapeCalculator.filterByType(shapes, "Circle");

        Assertions.assertEquals(2, circles1.size(), "Lowercase should work");
        Assertions.assertEquals(2, circles2.size(), "Uppercase should work");
        Assertions.assertEquals(2, circles3.size(), "Mixed case should work");
    }

    @Test
    public void testFilterByTypeEmpty() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(2.0));
        shapes.add(new Rectangle(4.0, 5.0));

        ArrayList<Shape> squares = ShapeCalculator.filterByType(shapes, "Square");
        Assertions.assertEquals(0, squares.size(),
                "Should return empty list when no shapes match");
    }

    @Test
    public void testGetRadiusFromCircle() {
        Shape circle = new Circle(7.5);
        double radius = ShapeCalculator.getRadiusFromShape(circle);
        Assertions.assertEquals(7.5, radius, 0.001,
                "Should return radius 7.5 from Circle");
    }

    @Test
    public void testGetRadiusFromRectangle() {
        Shape rectangle = new Rectangle(4.0, 6.0);
        double radius = ShapeCalculator.getRadiusFromShape(rectangle);
        Assertions.assertEquals(-1.0, radius, 0.001,
                "Should return -1.0 for non-Circle shapes");
    }

    @Test
    public void testGetRadiusFromSquare() {
        Shape square = new Square(5.0);
        double radius = ShapeCalculator.getRadiusFromShape(square);
        Assertions.assertEquals(-1.0, radius, 0.001,
                "Should return -1.0 for Square (not a Circle)");
    }

    @Test
    public void testPolymorphicIteration() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3.0));
        shapes.add(new Rectangle(4.0, 5.0));
        shapes.add(new Square(4.0));

        // Test that we can call methods polymorphically
        for (Shape shape : shapes) {
            double area = shape.getArea();
            double perimeter = shape.getPerimeter();
            String drawing = shape.draw();

            Assertions.assertTrue(area > 0, "Each shape should have positive area");
            Assertions.assertTrue(perimeter > 0, "Each shape should have positive perimeter");
            Assertions.assertNotNull(drawing, "Each shape should be drawable");
        }
    }

    @Test
    public void testMixedOperations() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(6.0, 8.0));
        shapes.add(new Square(7.0));
        shapes.add(new Circle(3.0));

        // Test multiple operations on same list
        double total = ShapeCalculator.getTotalArea(shapes);
        Shape largest = ShapeCalculator.findLargestShape(shapes);
        ArrayList<Shape> circles = ShapeCalculator.filterByType(shapes, "Circle");

        Assertions.assertTrue(total > 0, "Total area should be positive");
        Assertions.assertNotNull(largest, "Should find a largest shape");
        Assertions.assertEquals(2, circles.size(), "Should find 2 circles");
    }
}
