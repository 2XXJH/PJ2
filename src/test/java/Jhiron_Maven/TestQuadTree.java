package Jhiron_Maven;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuadTree class.
 */
public class TestQuadTree {

    private QuadTree quadTree;

    @BeforeEach
    public void setUp() {
        
        quadTree = new QuadTree();
    }

    /**
     * Test for inserting a rectangle.
     */
    @Test
    public void testInsert() {
        
        quadTree.insert(10, 20, 5, 5);
        Rectangle found = quadTree.find(10, 20);
        assertNotNull(found, "Rectangle should be found after insertion");
        assertEquals(10, found.getX(), "X coordinate should match");
        assertEquals(20, found.getY(), "Y coordinate should match");
        assertEquals(5, found.getWidth(), "Width should match");
        assertEquals(5, found.getHeight(), "Height should match");
    }

    /**
     * Test for finding a rectangle.
     */
    @Test
    public void testFind() {
        
        quadTree.insert(15, 25, 6, 6);
        Rectangle found = quadTree.find(15, 25);
        assertNotNull(found, "Rectangle should be found at the given coordinates");
        assertEquals(6, found.getWidth(), "Width should match");
        assertEquals(6, found.getHeight(), "Height should match");

        
        Rectangle notFound = quadTree.find(30, 30);
        assertNull(notFound, "No rectangle should be found at the non-existent coordinates");
    }

    /**
     * Test for deleting a rectangle.
     */
    @Test
    public void testDelete() {
       
        quadTree.insert(5, 5, 3, 3);
        Rectangle found = quadTree.find(5, 5);
        assertNotNull(found, "Rectangle should be found before deletion");

        quadTree.delete(5, 5);
        Rectangle deleted = quadTree.find(5, 5);
        assertNull(deleted, "Rectangle should be deleted and not found afterward");
    }

    /**
     * Test for dumping the quadtree.
     * This test won't assert output but ensures the dump method doesn't throw exceptions.
     */
    @Test
    public void testDump() {
        quadTree.insert(10, 10, 5, 5);
        quadTree.insert(20, 20, 6, 6);
        quadTree.dump();  
    }
}

