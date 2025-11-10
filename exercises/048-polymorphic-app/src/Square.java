/**
 * Square class - solution from previous exercise.
 */
public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public String draw() {
        return "Drawing a square with side " + getWidth();
    }
}
