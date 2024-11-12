package Jhiron_Maven;
import Jhiron_Maven.Rectangle;

/**
 * Represents a quadtree data structure for efficient spatial indexing and search of rectangles.
 */
public class QuadTree {
    private node root;

    /**
     * Constructs a new QuadTree with a root node that covers a 100x100 area
     * centered at (0, 0).
     */
    public QuadTree() {
        
        root = new LeafNode(-50, -50, 100, 100);
    }

    /**
     * Inserts a rectangle into the quadtree.
     * 
     * @param x      The x-coordinate of the rectangle's bottom-left corner.
     * @param y      The y-coordinate of the rectangle's bottom-left corner.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public void insert(double x, double y, double width, double height) {
        root.insert(new Rectangle(x, y, width, height));
    }

    /**
     * Deletes a rectangle at the specified position from the quadtree.
     * 
     * @param x The x-coordinate of the rectangle's bottom-left corner.
     * @param y The y-coordinate of the rectangle's bottom-left corner.
     */
    public void delete(double x, double y) {
        root.delete(x, y);
    }

    /**
     * Finds a rectangle at the specified position in the quadtree.
     * 
     * @param x The x-coordinate of the rectangle's bottom-left corner.
     * @param y The y-coordinate of the rectangle's bottom-left corner.
     * @return  The rectangle found at the specified position, or null if not found.
     */
    public Rectangle find(double x, double y) {
        return root.find(x, y);
    }

    /**
     * Dumps the structure and contents of the quadtree to the console.
     */
    public void dump() {
        root.dump("");
    }
}
