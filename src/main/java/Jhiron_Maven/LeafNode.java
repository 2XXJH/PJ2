package Jhiron_Maven;
import java.util.ArrayList;
import Jhiron_Maven.Rectangle;

/**
 * Represents a leaf node in the quadtree, which stores a list of rectangles.
 */
public class LeafNode extends node {
    private ArrayList<Rectangle> rectangles;  

    /**
     * Constructs a new leaf node.
     * 
     * @param x      The x-coordinate of the node's bottom-left corner.
     * @param y      The y-coordinate of the node's bottom-left corner.
     * @param width  The width of the node's space.
     * @param height The height of the node's space.
     */
    public LeafNode(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.rectangles = new ArrayList<Rectangle>();
    }

    @Override
    public void insert(Rectangle rectangle) {
        if (rectangles.size() < 5) {
            rectangles.add(rectangle);
        } else {
            InternalNode internalNode = new InternalNode(x, y, width, height);
            for (Rectangle rect : rectangles) {
                internalNode.insert(rect);
            }
            internalNode.insert(rectangle);
        }
    }

    @Override
    public void delete(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                rectangles.remove(rect);
                return;
            }
        }
    }

    @Override
    public Rectangle find(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                return rect;
            }
        }
        return null;
    }

    @Override
    public void dump(String indent) {
        System.out.println(indent + "LeafNode at (" + x + ", " + y + "): " + width + "x" + height);
        for (Rectangle rect : rectangles) {
            System.out.println(indent + "\tRectangle at (" + rect.getX() + ", " + rect.getY() + "): " + rect.getWidth() + "x" + rect.getHeight());
        }
    }
}
