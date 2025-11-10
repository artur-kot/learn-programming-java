# Exercise 046: Inheritance Hierarchy

## Introduction

You've learned about abstract classes and basic inheritance. But what happens when you want to create a more specific version of a class? A square is really just a special type of rectangle where all sides are equal. Instead of writing a completely new Square class from scratch, you can **extend Rectangle** and reuse its code!

This exercise teaches you about **inheritance hierarchies** and **constructor chaining** - powerful techniques for building on existing code.

## What You're Learning

**Inheritance Hierarchy:**
Classes can form a family tree of relationships:
```
Shape (abstract)
  ├── Circle
  └── Rectangle
        └── Square (extends Rectangle)
```

Each level adds specificity:
- Shape: Most general - any 2D shape
- Rectangle: More specific - has width and height
- Square: Most specific - width equals height

**The IS-A Relationship:**
Inheritance represents an "IS-A" relationship:
- Circle IS-A Shape ✓
- Rectangle IS-A Shape ✓
- Square IS-A Rectangle ✓
- Therefore, Square IS-A Shape ✓ (transitivity!)

**Constructor Chaining with super():**
When a subclass is created, it must initialize its parent class first. Use `super()` to call the parent constructor:

```java
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class Square extends Rectangle {
    public Square(double side) {
        // Call parent (Rectangle) constructor with equal width and height
        super(side, side);
    }
}
```

**Why use super()?**
- Reuses parent initialization logic (DRY principle)
- Must be the first statement in the constructor
- Ensures the parent is properly initialized before the child
- Avoids duplicate code

**Method Overriding in Deeper Hierarchies:**
Classes can override methods from any ancestor:
```java
class Shape {
    public String describe() {
        return "I am a shape";
    }
}

class Rectangle extends Shape {
    @Override
    public String describe() {
        return "I am a rectangle";
    }
}

class Square extends Rectangle {
    @Override
    public String describe() {
        return "I am a square";  // Overrides Rectangle's version
    }
}
```

**Code Reuse Benefits:**
By extending Rectangle, Square automatically gets:
- All Rectangle's fields (width, height)
- All Rectangle's methods (getArea, getPerimeter)
- The ability to be treated as a Rectangle OR a Shape

## Challenge

Your task: **Build on the previous exercise by creating a Square class that extends Rectangle, demonstrating inheritance hierarchy and constructor chaining.**

Starting from your previous Shape/Rectangle/Circle solution, add a Square class that:
- Extends Rectangle (not Shape directly)
- Has only one dimension (side length)
- Uses `super()` to call Rectangle's constructor
- Optionally overrides `toString()` to identify itself as a "Square"

## Requirements

Your solution must include:

**Copy from previous exercise:**
- `Shape.java` (abstract class)
- `Circle.java` (extends Shape)
- `Rectangle.java` (extends Shape)

**New Square class:**
- `Square extends Rectangle`
- Constructor: `Square(double side)` that calls `super(side, side)`
- Optional: Override `toString()` to return a string like "Square with side: 5.0"

**Implementation requirements:**
- Square must NOT reimplement getArea() or getPerimeter() - inherit from Rectangle!
- Constructor must use `super()` as the first statement
- Square should be usable anywhere Rectangle is used (polymorphism)

## Hints

<details>
<summary>Hint 1: Class Declaration</summary>

To extend a class, use the `extends` keyword:
```java
public class Square extends Rectangle {
    // Square-specific code here
}
```

Square now inherits everything from Rectangle!

</details>

<details>
<summary>Hint 2: Constructor with super()</summary>

The constructor takes one parameter but calls parent with two:
```java
public Square(double side) {
    super(side, side);  // Pass side to both width and height
}
```

Note: `super()` must be the first statement in the constructor.

</details>

<details>
<summary>Hint 3: You Don't Need to Override Methods</summary>

Square doesn't need getArea() or getPerimeter() methods - it inherits them from Rectangle! Since a square with side `s` is the same as a rectangle with width `s` and height `s`, Rectangle's formulas work perfectly.

</details>

<details>
<summary>Hint 4: Optional toString() Override</summary>

If you want Square to identify itself:
```java
@Override
public String toString() {
    return "Square with side: " + /* how to get side length? */;
}
```

Hint: You'll need a getter method in Rectangle to access width/height!

</details>

## Expected Behavior

**Example usage:**
```java
// Square is a Rectangle, which is a Shape
Shape square = new Square(5.0);
System.out.println(square.getArea());       // 25.0
System.out.println(square.getPerimeter());  // 20.0

// Can treat it as Rectangle too
Rectangle rect = new Square(4.0);
System.out.println(rect.getArea());  // 16.0

// All three in an array - polymorphism!
Shape[] shapes = {
    new Circle(3.0),
    new Rectangle(4.0, 5.0),
    new Square(4.0)
};

for (Shape shape : shapes) {
    System.out.println(shape.getArea());
}
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/046-inheritance-hierarchy
mvn test
```

**Manual Testing:**
```bash
cd exercises/046-inheritance-hierarchy/src
javac Shape.java Circle.java Rectangle.java Square.java
# Verify compilation succeeds
```

The tests will verify:
- Square extends Rectangle (not Shape directly)
- Square constructor properly initializes via super()
- Inherited methods work correctly
- Polymorphism works at multiple levels

## Reflection Questions

1. **Why extend Rectangle instead of Shape?** What code do you save?
2. **What happens if you don't call super()?** Try removing it and compiling.
3. **Can you override getArea() in Square?** Should you? Why or why not?
4. **How many classes is Square inheriting from?** (Think about the full chain)
5. **Could a Rectangle be a Square?** Why is this relationship one-way?
6. **What's the difference between IS-A and HAS-A relationships?** Which is inheritance?

## Next Steps

You've mastered inheritance hierarchies and constructor chaining! In the next exercise, you'll learn about **interfaces** - a way to define behavior that classes can implement, allowing for multiple inheritance of behavior.

## Read More

- [Inheritance in Java](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Using the super Keyword](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)
- [Inheritance vs Composition](https://www.baeldung.com/java-inheritance-composition)
