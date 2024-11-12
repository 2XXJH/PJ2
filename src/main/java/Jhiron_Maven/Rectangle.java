package Jhiron_Maven;
import Jhiron_Maven.Rectangle;

/**
 * Represents a rectangle with a position and dimensions.
 */
public class Rectangle {
    private double x, y, width, height;

    /**
     * Constructs a new rectangle.
     * 
     * @param x      The x-coordinate of the rectangle's bottom-left corner.
     * @param y      The y-coordinate of the rectangle's bottom-left corner.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * @return The x-coordinate of the rectangle's bottom-left corner.
     */
    public double getX() {
        return x;
    }

    /**
     * @return The y-coordinate of the rectangle's bottom-left corner.
     */
    public double getY() {
        return y;
    }

    /**
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + "): " + width + "x" + height;
    }
}
