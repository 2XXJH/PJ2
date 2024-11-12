package Jhiron_Maven;
import Jhiron_Maven.Rectangle;

/**
 * Abstract base class representing a node in a quadtree.
 * Stores the position and size of the node's space.
 */
public abstract class node {
    protected double x, y;  
    protected double width, height;  

    /**
     * Constructs a new node with the specified position and size.
     * 
     * @param x      The x-coordinate of the node's bottom-left corner.
     * @param y      The y-coordinate of the node's bottom-left corner.
     * @param width  The width of the node's space.
     * @param height The height of the node's space.
     */
    public node(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if a point (px, py) is contained within this node's space.
     * 
     * @param px The x-coordinate of the point.
     * @param py The y-coordinate of the point.
     * @return   True if the point is within the node's space, false otherwise.
     */
    protected boolean contains(double px, double py) {
        return px >= x && py >= y && px < x + width && py < y + height;
    }

    /**
     * Inserts a rectangle into the quadtree.
     * 
     * @param rectangle The rectangle to be inserted.
     */
    public abstract void insert(Rectangle rectangle);

    /**
     * Deletes a rectangle at the specified position from the quadtree.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     */
    public abstract void delete(double x, double y);

    /**
     * Finds a rectangle at the specified position in the quadtree.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @return  The rectangle found at the specified position, or null if not found.
     */
    public abstract Rectangle find(double x, double y);

    /**
     * Dumps the contents of the quadtree for visualization.
     * 
     * @param indent The indentation to apply to the output for tree visualization.
     */
    public abstract void dump(String indent);
}
