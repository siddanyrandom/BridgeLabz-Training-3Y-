/**
 * A class to represent a Circle with a radius.
 * This file demonstrates constructor chaining in Java.
 */
public class Circle {

    // The radius attribute of the circle.
    private double radius;

    /**
     * The default constructor.
     * It uses constructor chaining to call the parameterized constructor,
     * initializing the radius to a default value of 1.0.
     */
    public Circle() {
        // Calls the single-argument constructor to initialize the radius
        this(1.0); 
    }

    /**
     * The parameterized constructor.
     * Initializes the circle with a user-provided radius.
     * @param radius The radius of the circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates and returns the area of the circle.
     * @return The area of the circle.
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates and returns the circumference of the circle.
     * @return The circumference of the circle.
     */
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Provides a string representation of the Circle object.
     * @return A formatted string with the circle's radius, area, and circumference.
     */
    @Override
    public String toString() {
        return "Circle{" +
               "radius=" + String.format("%.2f", radius) +
               ", area=" + String.format("%.2f", getArea()) +
               ", circumference=" + String.format("%.2f", getCircumference()) +
               '}';
    }

    /**
     * Main method to demonstrate the functionality of the Circle class.
     */
    public static void main(String[] args) {
        // Create a circle using the default constructor (no arguments)
        Circle circle1 = new Circle();
        System.out.println("Circle created with default constructor:");
        System.out.println(circle1);
        System.out.println("--------------------");

        // Create a circle using the parameterized constructor
        Circle circle2 = new Circle(5.0);
        System.out.println("Circle created with parameterized constructor:");
        System.out.println(circle2);
    }
}
