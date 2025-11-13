//:  Scratch.java

/**
 * This is a demonstration class showcasing various JavaDoc features and annotations.
 *
 * <p>This class is designed to illustrate how to properly document Java code using
 * JavaDoc comments. It covers all major JavaDoc tags and their usage patterns.</p>
 *
 * @author John Developer
 * @version 2.0
 * @since 1.0
 *
 * @see Student
 * @see <a href="https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html">
 *      Official JavaDoc Guide</a>
 */
public class Scratch {

    /**
     * Calculates the sum of two integers.
     *
     * <p>This is a simple utility method that adds two numbers together.
     * For more complex mathematical operations, see {@link MathUtils}.</p>
     *
     * @param a the first integer value
     * @param b the second integer value
     * @return the sum of a and b
     *
     * @see #subtract(int, int)
     * @see #multiply(int, int)
     * @since 1.0
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Calculates the difference between two integers.
     *
     * @param a the first integer value (minuend)
     * @param b the second integer value (subtrahend)
     * @return the difference (a - b)
     *
     * @see #add(int, int)
     * @since 1.0
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Calculates the product of two integers.
     *
     * @param a the first integer value
     * @param b the second integer value
     * @return the product of a and b
     *
     * @see #add(int, int)
     * @see #divide(int, int)
     * @since 1.0
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second integer.
     *
     * <p>This method performs integer division. For floating-point division,
     * please refer to {@link Calculator#divideFloat(float, float)}.</p>
     *
     * @param a the dividend (numerator)
     * @param b the divisor (denominator)
     * @return the integer quotient of a divided by b
     *
     * @throws IllegalArgumentException if b is zero, as division by zero is not allowed
     * @throws NumberFormatException if arguments cannot be parsed as integers
     *
     * @see #multiply(int, int)
     * @since 1.0
     */
    public int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }

    /**
     * Parses a string representation of a number.
     *
     * <p>Converts the string argument to an integer value. The radix is assumed to be 10.
     * This is a wrapper around {@link Integer#parseInt(String)}.</p>
     *
     * @param str the {@code String} containing the integer representation to be parsed
     * @return the integer value represented by the string argument
     *
     * @throws NumberFormatException if the string does not contain a parsable integer
     * @throws NullPointerException if str is null
     *
     * @since 1.5
     */
    public int parseNumber(String str) throws NumberFormatException, NullPointerException {
        return Integer.parseInt(str);
    }

    /**
     * Determines if a number is positive.
     *
     * @param number the number to check
     * @return true if the number is positive, false otherwise
     *
     * @since 2.0
     */
    public boolean isPositive(int number) {
        return number > 0;
    }

    /**
     * @deprecated As of version 2.0, use {@link #modernMethod()} instead.
     *             This method will be removed in version 3.0.
     *             The new implementation is more efficient and thread-safe.
     *
     * This method performs the old calculation that is no longer recommended.
     *
     * @return the calculated value using the deprecated algorithm
     *
     * @see #modernMethod()
     * @since 1.0
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public int legacyCalculation() {
        return 42;
    }

    /**
     * Modern replacement for the deprecated {@link #legacyCalculation()} method.
     *
     * <p>This method implements an improved algorithm with better performance
     * and thread safety. It is the recommended way to perform calculations.</p>
     *
     * @return the calculated value using the modern algorithm
     *
     * @see #legacyCalculation()
     * @since 2.0
     */
    public int modernMethod() {
        return 99;
    }

    /**
     * Processes student information.
     *
     * <p>This method handles the core logic for student data processing.
     * For related classes and methods, see {@link Student},
     * {@link StudentProcessor}, and the package documentation at {@docRoot}.</p>
     *
     * @param studentName the name of the student to process
     * @param studentId the unique identifier for the student
     * @param grade the academic grade of the student
     *
     * @return true if the student was processed successfully, false otherwise
     *
     * @throws NullPointerException if studentName is null
     * @throws IllegalArgumentException if studentId is negative or grade is invalid
     *
     * @see Student
     * @see StudentProcessor
     * @since 1.0
     */
    public boolean processStudent(String studentName, int studentId, char grade)
            throws NullPointerException, IllegalArgumentException {
        if (studentName == null) {
            throw new NullPointerException("Student name cannot be null");
        }
        if (studentId < 0) {
            throw new IllegalArgumentException("Student ID cannot be negative");
        }
        return true;
    }
}

/**
 * Represents a student entity.
 *
 * <p>This class encapsulates student information and provides methods
 * for managing student data. See {@link Scratch} for usage examples.</p>
 *
 * @author Jane Developer
 * @version 1.5
 * @since 1.0
 *
 * @see Scratch
 */
class Student {
    private String name;
    private int id;
    private char grade;

    /**
     * Constructs a Student with the specified details.
     *
     * @param name the name of the student
     * @param id the unique identifier for the student
     * @param grade the academic grade of the student
     *
     * @throws NullPointerException if name is null
     *
     * @since 1.0
     */
    public Student(String name, int id, char grade) throws NullPointerException {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    /**
     * Gets the name of the student.
     *
     * @return the student's name
     *
     * @since 1.0
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the ID of the student.
     *
     * @return the student's unique identifier
     *
     * @since 1.0
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the grade of the student.
     *
     * @return the student's academic grade
     *
     * @since 1.0
     */
    public char getGrade() {
        return grade;
    }
}

/**
 * Utility class for processing student data.
 *
 * <p>This class provides static utility methods for common student operations.
 * For more detailed documentation on student handling, refer to {@link Student}.</p>
 *
 * @author Admin Developer
 * @version 1.0
 * @since 2.0
 *
 * @see Student
 * @see Scratch#processStudent(String, int, char)
 */
class StudentProcessor {

    /**
     * Validates a student's grade.
     *
     * <p>Checks if the provided grade is within the acceptable range.
     * Valid grades are A-F. This method complements the validation in
     * {@link Scratch#processStudent(String, int, char)}.</p>
     *
     * @param grade the character grade to validate
     * @return true if the grade is valid, false otherwise
     *
     * @throws IllegalArgumentException if grade is not a letter
     *
     * @see Student#getGrade()
     * @since 2.0
     */
    public static boolean isValidGrade(char grade) throws IllegalArgumentException {
        return grade >= 'A' && grade <= 'F';
    }
}

/**
 * Advanced mathematics utility class.
 *
 * <p>Provides advanced mathematical operations beyond basic arithmetic.
 * For basic operations, see {@link Scratch} instead.</p>
 *
 * @author Math Developer
 * @version 1.0
 * @since 2.0
 *
 * @see Scratch#divide(int, int)
 * @see <a href="https://en.wikipedia.org/wiki/Mathematics">Mathematics Reference</a>
 */
class MathUtils {

    /**
     * Calculates the power of a number.
     *
     * <p>Computes {@code base} raised to the power of {@code exponent}.
     * For simple multiplication, see {@link Scratch#multiply(int, int)}.</p>
     *
     * @param base the base number
     * @param exponent the exponent (power)
     * @return base raised to the power of exponent
     *
     * @throws IllegalArgumentException if exponent is negative
     *
     * @since 2.0
     */
    public static int power(int base, int exponent) throws IllegalArgumentException {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative");
        }
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}

/**
 * Advanced calculator class with floating-point support.
 *
 * <p>This class extends basic arithmetic operations to support floating-point
 * calculations. For integer operations, use {@link Scratch}.</p>
 *
 * @author Calculator Developer
 * @version 1.0
 * @since 2.0
 *
 * @see Scratch
 * @see Scratch#divide(int, int)
 */
class Calculator {

    /**
     * Divides two floating-point numbers.
     *
     * <p>Performs floating-point division with higher precision than integer division.
     * For integer division, see {@link Scratch#divide(int, int)}.</p>
     *
     * @param dividend the number to be divided
     * @param divisor the number to divide by
     * @return the quotient as a floating-point number
     *
     * @throws IllegalArgumentException if divisor is zero
     *
     * @since 2.0
     */
    public static double divideFloat(float dividend, float divisor)
            throws IllegalArgumentException {
        if (divisor == 0.0f) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return dividend / divisor;
    }
}

