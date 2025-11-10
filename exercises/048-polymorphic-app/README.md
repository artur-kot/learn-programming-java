# Exercise 048: Polymorphic Application

## Introduction

You've learned all the core OOP concepts: abstract classes, inheritance, interfaces, and polymorphism. Now it's time to put them all together in a practical application!

In this capstone exercise, you'll build a **Shape Calculator** that demonstrates the true power of polymorphism. You'll work with collections of different shapes, treating them uniformly while leveraging their specific behaviors. This is where OOP really shines!

## What You're Learning

**Polymorphic Collections:**
One of the most powerful features of OOP is storing different types in a single collection:

```java
ArrayList<Shape> shapes = new ArrayList<>();
shapes.add(new Circle(5));
shapes.add(new Rectangle(4, 6));
shapes.add(new Square(3));

// Iterate uniformly, but behavior is specific to each type!
for (Shape shape : shapes) {
    System.out.println(shape.getArea());  // Calls correct implementation
}
```

**Dynamic Binding (Runtime Polymorphism):**
The JVM determines which method to call at runtime based on the actual object type, not the reference type:
```java
Shape shape = new Circle(5);  // Reference type: Shape, Object type: Circle
shape.getArea();  // Calls Circle's getArea(), not Shape's!
```

This is called **dynamic binding** or **late binding** - the method binding happens at runtime.

**The instanceof Operator:**
Sometimes you need to check the actual type of an object:
```java
if (shape instanceof Circle) {
    System.out.println("This is a circle!");
}
```

**Type Casting (Downcasting):**
When you need to access subclass-specific methods:
```java
Shape shape = new Circle(5);
// shape.getRadius();  // ERROR! Shape doesn't have getRadius()

if (shape instanceof Circle) {
    Circle circle = (Circle) shape;  // Cast to Circle
    double radius = circle.getRadius();  // Now we can access Circle methods!
}
```

**Pattern Matching (Java 16+):**
Modern Java combines instanceof and casting:
```java
if (shape instanceof Circle circle) {
    // 'circle' variable is automatically available and cast!
    double radius = circle.getRadius();
}
```

**Practical OOP Design:**
Real applications combine these concepts:
- Collections hold polymorphic types
- Methods work on base types but leverage specific implementations
- Type checking enables special handling when needed
- Interfaces enable flexible sorting, comparing, and organizing

## Challenge

Your task: **Build a ShapeCalculator class that performs various operations on collections of shapes using polymorphism, instanceof, and type casting.**

Create a utility class with static methods that:
1. Calculate total area of all shapes in a collection
2. Find the largest shape (by area)
3. Filter shapes by type (e.g., all circles)
4. Extract specific properties with type casting (e.g., get radius from Circle)

## Requirements

Your solution must include:

**Copy from previous exercise:**
- `Drawable.java` interface
- `Shape.java` (abstract, implements Comparable and Drawable)
- `Circle.java`, `Rectangle.java`, `Square.java` (all complete implementations)

**New ShapeCalculator class:**

**Method 1: `getTotalArea(ArrayList<Shape> shapes)`**
- Returns: `double` - sum of all shape areas
- Uses polymorphic iteration

**Method 2: `findLargestShape(ArrayList<Shape> shapes)`**
- Returns: `Shape` - the shape with the largest area
- Returns `null` if list is empty
- Uses the `compareTo()` method or direct area comparison

**Method 3: `filterByType(ArrayList<Shape> shapes, String type)`**
- Parameters: list of shapes, type name ("Circle", "Rectangle", "Square")
- Returns: `ArrayList<Shape>` containing only shapes of the specified type
- Uses `instanceof` to check types
- Type matching should be case-insensitive

**Method 4: `getRadiusFromShape(Shape shape)`**
- Returns: `double` - the radius if shape is a Circle, or -1.0 if not
- Uses `instanceof` to check if shape is a Circle
- Uses casting to access Circle's specific properties
- Demonstrates downcasting

**All methods should be static** (utility class pattern)

## Hints

<details>
<summary>Hint 1: Total Area with Polymorphism</summary>

Iterate through shapes and sum their areas:
```java
public static double getTotalArea(ArrayList<Shape> shapes) {
    double total = 0;
    for (Shape shape : shapes) {
        total += shape.getArea();  // Polymorphic call!
    }
    return total;
}
```

</details>

<details>
<summary>Hint 2: Finding Largest Shape</summary>

Keep track of the largest shape as you iterate:
```java
public static Shape findLargestShape(ArrayList<Shape> shapes) {
    if (shapes.isEmpty()) return null;

    Shape largest = shapes.get(0);
    for (Shape shape : shapes) {
        if (shape.compareTo(largest) > 0) {
            largest = shape;
        }
    }
    return largest;
}
```

</details>

<details>
<summary>Hint 3: Filtering by Type with instanceof</summary>

Use instanceof to check each shape's type:
```java
public static ArrayList<Shape> filterByType(ArrayList<Shape> shapes, String type) {
    ArrayList<Shape> filtered = new ArrayList<>();

    for (Shape shape : shapes) {
        if (type.equalsIgnoreCase("Circle") && shape instanceof Circle) {
            filtered.add(shape);
        } else if (type.equalsIgnoreCase("Rectangle") && shape instanceof Rectangle) {
            filtered.add(shape);
        }
        // Add more conditions...
    }

    return filtered;
}
```

</details>

<details>
<summary>Hint 4: Type Casting to Access Specific Methods</summary>

Check type first, then cast:
```java
public static double getRadiusFromShape(Shape shape) {
    if (shape instanceof Circle) {
        Circle circle = (Circle) shape;  // Downcast
        return circle.getRadius();
    }
    return -1.0;  // Not a circle
}
```

Note: You'll need to add a `getRadius()` method to the Circle class!

</details>

## Expected Behavior

**Example usage:**
```java
ArrayList<Shape> shapes = new ArrayList<>();
shapes.add(new Circle(5.0));
shapes.add(new Rectangle(4.0, 6.0));
shapes.add(new Square(4.0));
shapes.add(new Circle(3.0));

// Total area
double total = ShapeCalculator.getTotalArea(shapes);
System.out.println("Total area: " + total);  // Sum of all areas

// Find largest
Shape largest = ShapeCalculator.findLargestShape(shapes);
System.out.println("Largest shape area: " + largest.getArea());

// Filter circles
ArrayList<Shape> circles = ShapeCalculator.filterByType(shapes, "Circle");
System.out.println("Number of circles: " + circles.size());  // 2

// Get radius from shape
Shape shape = new Circle(7.0);
double radius = ShapeCalculator.getRadiusFromShape(shape);
System.out.println("Radius: " + radius);  // 7.0

Shape rect = new Rectangle(3, 4);
double notRadius = ShapeCalculator.getRadiusFromShape(rect);
System.out.println("Radius: " + notRadius);  // -1.0 (not a circle)
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/048-polymorphic-app
mvn test
```

**Manual Testing:**
```bash
cd exercises/048-polymorphic-app/src
javac *.java
# Create a main class to test the calculator
```

The tests will verify:
- getTotalArea correctly sums all shape areas
- findLargestShape returns the shape with maximum area
- filterByType correctly filters by shape type (case-insensitive)
- getRadiusFromShape returns radius for circles, -1.0 for others
- All methods work polymorphically with mixed shape collections

## Reflection Questions

1. **Why use Shape reference instead of concrete types in collections?** What flexibility does this provide?
2. **What's the difference between compile-time and runtime type?** Give an example.
3. **When should you use instanceof?** Is it good to use it everywhere?
4. **What happens if you cast incorrectly?** Try casting a Rectangle to Circle.
5. **Could you sort an ArrayList<Shape>?** How would you do it?
6. **How does polymorphism make your code more maintainable?** What if you add a Triangle class?

## Next Steps

Congratulations! You've completed the advanced OOP series and built a sophisticated polymorphic application. You now understand:
- Abstract classes and inheritance
- Constructor chaining
- Interfaces and multiple inheritance
- Polymorphism and dynamic binding
- Type checking and casting
- Practical OOP design patterns

These are the foundation of professional Java development. Next, you'll explore exception handling, file I/O, and build complete applications!

## Read More

- [Polymorphism in Java](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [instanceof Operator](https://www.baeldung.com/java-instanceof)
- [Type Casting in Java](https://www.javatpoint.com/upcasting-and-downcasting-in-java)
- [ArrayList Guide](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [Design Patterns in Java](https://refactoring.guru/design-patterns/java)
