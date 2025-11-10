/**
 * Abstract Shape class - solution from previous exercise.
 */
public abstract class Shape implements Comparable<Shape>, Drawable {

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getArea(), other.getArea());
    }

    @Override
    public abstract String draw();
}
