package Jhiron_Maven;
import Jhiron_Maven.Rectangle;

/**
 * Represents an internal node in the quadtree, containing four child nodes.
 */
public class InternalNode extends node {
    private node[] children;  

    /**
     * Constructs a new internal node and splits it into four quadrants.
     * 
     * @param x      The x-coordinate of the node's bottom-left corner.
     * @param y      The y-coordinate of the node's bottom-left corner.
     * @param width  The width of the node's space.
     * @param height The height of the node's space.
     */
    public InternalNode(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.children = new node[4];  
        split();
    }

    /**
     * Splits this internal node into four child leaf nodes, representing quadrants.
     */
    private void split() {
        children[0] = new LeafNode(x + width / 2, y + height / 2, width / 2, height / 2);
        children[1] = new LeafNode(x, y + height / 2, width / 2, height / 2);
        children[2] = new LeafNode(x, y, width / 2, height / 2);
        children[3] = new LeafNode(x + width / 2, y, width / 2, height / 2);
    }

    @Override
    public void insert(Rectangle rectangle) {
        for (node child : children) {
            if (child.contains(rectangle.getX(), rectangle.getY())) {
                child.insert(rectangle);
                return;
            }
        }
    }

    @Override
    public void delete(double x, double y) {
        for (node child : children) {
            if (child.contains(x, y)) {
                child.delete(x, y);
                return;
            }
        }
    }

    @Override
    public Rectangle find(double x, double y) {
        for (node child : children) {
            if (child.contains(x, y)) {
                return child.find(x, y);
            }
        }
        return null;
    }

    @Override
    public void dump(String indent) {
        System.out.println(indent + "InternalNode at (" + x + ", " + y + "): " + width + "x" + height);
        for (node child : children) {
            child.dump(indent + "\t");
        }
    }

    /**
     * Checks if the rectangle is contained within this node's space.
     * 
     * @param rect The rectangle to check.
     * @return     True if the rectangle's bottom-left corner is within the node's space, false otherwise.
     */
    private boolean contains(Rectangle rect) {
        return rect.getX() >= x && rect.getY() >= y && rect.getX() < x + width && rect.getY() < y + height;
    }

    @Override
    protected boolean contains(double px, double py) {
        return super.contains(px, py);
    }
}
