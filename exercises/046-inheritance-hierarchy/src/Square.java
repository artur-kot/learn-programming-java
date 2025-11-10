/**
 * Square class - a special case of Rectangle where all sides are equal.
 *
 * Demonstrates inheritance hierarchy and constructor chaining.
 *
 * Your task: Complete the Square class
 */
public class Square extends Rectangle {

    // TODO: Create a constructor that takes a single parameter 'side' (double)
    // Use super() to call Rectangle's constructor with side for both width and height
    // Remember: super() must be the first statement!

    // OPTIONAL TODO: Override toString() to return a description like "Square with side: 5.0"
    // Use the getWidth() or getHeight() method from Rectangle to get the side length

    // NOTE: You do NOT need to override getArea() or getPerimeter()!
    // Square inherits these from Rectangle and they work perfectly
    // because a square with side S is just a rectangle with width S and height S
}
