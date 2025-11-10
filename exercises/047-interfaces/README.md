# Exercise 047: Interfaces

## Introduction

You've learned about inheritance - the IS-A relationship where one class extends another. But what if a class needs to have multiple behaviors from different sources? Java doesn't allow extending multiple classes (no multiple inheritance), but it does allow **implementing multiple interfaces**!

Think of an interface as a contract: "I promise to provide these specific methods." A Circle can be both a Shape AND be Drawable AND be Comparable - all at once!

## What You're Learning

**Interfaces:**
An interface is a completely abstract contract that defines what methods a class must implement, without specifying how:

```java
public interface Drawable {
    String draw();  // Note: automatically public abstract
}

public class Circle extends Shape implements Drawable {
    // Must implement draw()
    @Override
    public String draw() {
        return "Drawing a circle with radius " + radius;
    }
}
```

**Key Interface Characteristics:**
- All methods are automatically `public abstract` (you can omit these keywords)
- Cannot have instance fields (only constants: `public static final`)
- Cannot have constructors (interfaces aren't instantiated)
- A class can implement multiple interfaces (separated by commas)
- Represents a "CAN-DO" relationship (Drawable, Comparable, Serializable)

**Interfaces vs Abstract Classes:**

| Feature | Interface | Abstract Class |
|---------|-----------|----------------|
| Methods | All abstract (before Java 8) | Can mix abstract and concrete |
| Fields | Only constants | Can have instance fields |
| Inheritance | Can implement many | Can extend only one |
| Purpose | Define capability/behavior | Define core identity |
| Relationship | "CAN-DO" | "IS-A" |

**Multiple Interface Implementation:**
```java
public class Circle extends Shape implements Drawable, Comparable<Shape> {
    // Must implement methods from Drawable AND Comparable
}
```

This is incredibly powerful! A Circle:
- IS-A Shape (inheritance)
- CAN-BE Drawn (Drawable interface)
- CAN-BE Compared (Comparable interface)

**The Comparable Interface:**
Java provides a standard `Comparable<T>` interface for objects that have a natural ordering:

```java
public interface Comparable<Shape> {
    int compareTo(Shape other);
}
```

The `compareTo` method returns:
- Negative number: this object is "less than" the other
- Zero: objects are "equal"
- Positive number: this object is "greater than" the other

This enables sorting and comparison!

**Polymorphism with Interfaces:**
```java
Drawable item = new Circle(5);  // Circle IS a Drawable
item.draw();  // Calls Circle's implementation

Comparable<Shape> shape = new Circle(5);  // Circle IS Comparable
shape.compareTo(otherShape);
```

## Challenge

Your task: **Add two interfaces to your shape hierarchy - Drawable and Comparable - and implement them in all shape classes.**

Build on your previous Shape/Circle/Rectangle/Square classes by:
1. Creating a `Drawable` interface with a `draw()` method
2. Making Shape implement `Comparable<Shape>` to compare by area
3. Implementing both interfaces in all concrete shape classes

## Requirements

Your solution must include:

**Drawable interface:**
- Method: `String draw()` - returns a string description of the shape being drawn

**Shape class (modified):**
- Now implements `Comparable<Shape>`
- Implement `compareTo(Shape other)` to compare shapes by area
- Keep existing abstract methods (getArea, getPerimeter)
- Now also implements `Drawable`

**All shape classes (Circle, Rectangle, Square):**
- Implement `draw()` to return a descriptive string
- Inherit `compareTo()` from Shape (or override if needed)
- Examples:
  - Circle: "Drawing a circle with radius 5.0"
  - Rectangle: "Drawing a rectangle with width 4.0 and height 6.0"
  - Square: "Drawing a square with side 5.0"

**Implementation details:**
- Use `@Override` annotations appropriately
- compareTo should compare by area (use getArea())
- draw() should return informative strings, not just print

## Hints

<details>
<summary>Hint 1: Defining an Interface</summary>

Interfaces are similar to classes but use the `interface` keyword:
```java
public interface Drawable {
    String draw();  // No method body, automatically public abstract
}
```

Create this in its own file: `Drawable.java`

</details>

<details>
<summary>Hint 2: Implementing Interfaces</summary>

Use the `implements` keyword. You can implement multiple interfaces:
```java
public abstract class Shape implements Comparable<Shape>, Drawable {
    // Must provide implementations (or declare them abstract)
}
```

</details>

<details>
<summary>Hint 3: Implementing compareTo</summary>

Compare two shapes by their areas:
```java
@Override
public int compareTo(Shape other) {
    double diff = this.getArea() - other.getArea();
    if (diff < 0) return -1;
    if (diff > 0) return 1;
    return 0;
}
```

Alternatively, use `Double.compare()`:
```java
return Double.compare(this.getArea(), other.getArea());
```

</details>

<details>
<summary>Hint 4: Implementing draw() in Concrete Classes</summary>

Each shape returns a string describing itself:
```java
@Override
public String draw() {
    return "Drawing a circle with radius " + radius;
}
```

You'll need to implement this separately in Circle, Rectangle, and Square.

</details>

## Expected Behavior

**Example usage:**
```java
Shape circle = new Circle(5.0);
Shape rectangle = new Rectangle(4.0, 6.0);

// Using Drawable interface
System.out.println(circle.draw());
// Output: Drawing a circle with radius 5.0

System.out.println(rectangle.draw());
// Output: Drawing a rectangle with width 4.0 and height 6.0

// Using Comparable interface
int comparison = circle.compareTo(rectangle);
if (comparison > 0) {
    System.out.println("Circle has larger area");
} else if (comparison < 0) {
    System.out.println("Rectangle has larger area");
} else {
    System.out.println("Same area");
}

// Polymorphism with interfaces
Drawable[] drawables = {new Circle(3), new Rectangle(2, 4), new Square(3)};
for (Drawable d : drawables) {
    System.out.println(d.draw());
}
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/047-interfaces
mvn test
```

**Manual Testing:**
```bash
cd exercises/047-interfaces/src
javac Drawable.java Shape.java Circle.java Rectangle.java Square.java
# Verify compilation succeeds
```

The tests will verify:
- Drawable interface exists with draw() method
- Shape implements Comparable<Shape>
- All concrete classes implement draw()
- compareTo() correctly compares by area
- Multiple interface implementation works

## Reflection Questions

1. **Why can't we have multiple inheritance but can implement multiple interfaces?** What problem does this solve?
2. **What's the difference between "IS-A" and "CAN-DO" relationships?** Give examples.
3. **Could we make Drawable an abstract class instead?** What would we lose?
4. **Why return a String from draw() instead of just printing?** What's more flexible?
5. **How does Comparable<Shape> enable sorting?** Try putting shapes in an ArrayList and calling Collections.sort().
6. **Can an interface extend another interface?** What would that look like?

## Next Steps

You've mastered interfaces and multiple inheritance of behavior! In the final exercise of this series, you'll build a **polymorphic Shape calculator application** that uses all these OOP concepts together: abstract classes, inheritance, interfaces, polymorphism, instanceof, and type casting.

## Read More

- [Interfaces in Java](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
- [Comparable Interface](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)
- [When to Use Interfaces vs Abstract Classes](https://www.baeldung.com/java-interface-vs-abstract-class)
- [Multiple Inheritance in Java](https://www.javatpoint.com/multiple-inheritance-in-java)
