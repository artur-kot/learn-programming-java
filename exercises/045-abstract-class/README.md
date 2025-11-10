# Exercise 045: Abstract Base Class

## Introduction

You've worked with classes and objects, but now you're ready for a powerful concept: **abstract classes**. Imagine you're designing shapes for a graphics application. All shapes have an area and perimeter, but the calculation is different for each shape. How do you represent this "shared idea" of shapes while requiring each specific shape to implement its own calculations?

Welcome to abstract classes - the blueprint for blueprints!

## What You're Learning

**Abstract Classes:**
An abstract class is like a contract that says "any class that extends me MUST implement these specific methods." You cannot create objects directly from an abstract class - you can only extend it.

Why use abstract classes?
- **Enforce consistency**: All subclasses must implement required methods
- **Share common code**: Abstract classes can have both abstract and concrete methods
- **Model concepts**: Represent ideas that shouldn't be instantiated directly (like "Shape")

**Key Syntax:**
```java
// Abstract class - cannot be instantiated
abstract class Shape {
    // Abstract method - no implementation, subclasses MUST override
    public abstract double getArea();

    // Concrete method - has implementation, can be inherited
    public void display() {
        System.out.println("This is a shape");
    }
}

// Concrete class - must implement all abstract methods
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // MUST implement abstract method
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
```

**Abstract vs Concrete:**
- **Abstract method**: Declared but not implemented (no body). Uses `abstract` keyword.
- **Concrete method**: Has implementation with method body.
- **Abstract class**: Can contain both abstract and concrete methods. Cannot be instantiated.
- **Concrete class**: Fully implemented, can be instantiated.

**Inheritance and Method Overriding:**
When a class extends an abstract class:
1. It MUST implement all abstract methods (or be abstract itself)
2. It inherits all concrete methods
3. It can override concrete methods if needed
4. Use `@Override` annotation to indicate you're overriding a method

**Polymorphism Preview:**
Abstract classes enable polymorphism - you can treat different shapes uniformly:
```java
Shape shape1 = new Circle(5);    // Circle IS-A Shape
Shape shape2 = new Rectangle(4, 6);  // Rectangle IS-A Shape
System.out.println(shape1.getArea());  // Calls Circle's implementation
System.out.println(shape2.getArea());  // Calls Rectangle's implementation
```

## Challenge

Your task: **Create an abstract Shape class and implement two concrete shapes - Circle and Rectangle.**

Build a shape hierarchy where:
- `Shape` is abstract with abstract methods `getArea()` and `getPerimeter()`
- `Circle` extends Shape with radius field
- `Rectangle` extends Shape with width and height fields
- Each concrete class calculates its own area and perimeter

## Requirements

Your solution must include:

**Shape (abstract class):**
- Two abstract methods: `getArea()` and `getPerimeter()` (both return double)
- No fields needed

**Circle class:**
- Private field: `radius` (double)
- Constructor: `Circle(double radius)`
- Implement `getArea()`: π × radius²
- Implement `getPerimeter()`: 2 × π × radius

**Rectangle class:**
- Private fields: `width` and `height` (double)
- Constructor: `Rectangle(double width, double height)`
- Implement `getArea()`: width × height
- Implement `getPerimeter()`: 2 × (width + height)

**All classes must:**
- Use proper encapsulation (private fields)
- Use `@Override` annotation on overridden methods
- Return accurate calculations

## Hints

<details>
<summary>Hint 1: Defining Abstract Class</summary>

An abstract class uses the `abstract` keyword:
```java
abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
}
```

Note: No method bodies for abstract methods!

</details>

<details>
<summary>Hint 2: Extending Abstract Class</summary>

When extending an abstract class, you MUST implement all abstract methods:
```java
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        // Your calculation here
    }

    @Override
    public double getPerimeter() {
        // Your calculation here
    }
}
```

</details>

<details>
<summary>Hint 3: Math Formulas</summary>

**Circle formulas:**
- Area: π × radius²
- Perimeter (circumference): 2 × π × radius
- Use `Math.PI` for π value
- Use `Math.pow(radius, 2)` or `radius * radius` for squaring

**Rectangle formulas:**
- Area: width × height
- Perimeter: 2 × (width + height)

</details>

<details>
<summary>Hint 4: File Organization</summary>

You'll need to create separate files:
- `Shape.java` - abstract class
- `Circle.java` - concrete class
- `Rectangle.java` - concrete class

All in the `src` folder.

</details>

## Expected Behavior

**Example usage:**
```java
Shape circle = new Circle(5.0);
System.out.println(circle.getArea());       // ~78.54
System.out.println(circle.getPerimeter());  // ~31.42

Shape rectangle = new Rectangle(4.0, 6.0);
System.out.println(rectangle.getArea());       // 24.0
System.out.println(rectangle.getPerimeter());  // 20.0
```

**What won't compile:**
```java
Shape shape = new Shape();  // ERROR! Cannot instantiate abstract class
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/045-abstract-class
mvn test
```

**Manual Testing:**
```bash
cd exercises/045-abstract-class/src
javac Shape.java Circle.java Rectangle.java
# Cannot run directly - no main method, but compilation verifies structure
```

The tests will verify:
- Shape is abstract
- Circle and Rectangle extend Shape
- getArea() and getPerimeter() return correct values
- Cannot instantiate Shape directly

## Reflection Questions

1. **Why can't you create a Shape object directly?** What would its area be?
2. **What happens if Circle doesn't implement getArea()?** Try removing it and compiling.
3. **Could you add a concrete method to Shape?** What would it do?
4. **Why use `@Override` annotation?** What protection does it provide?
5. **How is this different from just having three separate classes?** What's the benefit of inheritance here?

## Next Steps

You've mastered abstract classes! In the next exercise, you'll **extend the hierarchy further** by creating a Square class that extends Rectangle, learning about constructor chaining with `super()`.

## Read More

- [Abstract Classes in Java](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
- [Abstract Methods and Classes](https://www.baeldung.com/java-abstract-class)
- [Understanding Polymorphism](https://www.javatpoint.com/runtime-polymorphism-in-java)
