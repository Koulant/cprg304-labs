package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import utilities.BSTreeNode;

/**
 * JUnit tests for the BSTreeNode class.
 */
public class BSTreeNodeTests {

    private BSTreeNode<Integer> node;

    @Before
    public void setUp() {
        node = new BSTreeNode<>(5);
    }

    @Test
    public void testGetElement() {
        assertEquals(Integer.valueOf(5), node.getElement());
    }

    @Test
    public void testSetElement() {
        node.setElement(10);
        assertEquals(Integer.valueOf(10), node.getElement());
    }

    @Test
    public void testGetLeft() {
        assertNull(node.getLeft());
    }

    @Test
    public void testSetLeft() {
        BSTreeNode<Integer> leftNode = new BSTreeNode<>(3);
        node.setLeft(leftNode);
        assertEquals(leftNode, node.getLeft());
    }

    @Test
    public void testGetRight() {
        assertNull(node.getRight());
    }

    @Test
    public void testSetRight() {
        BSTreeNode<Integer> rightNode = new BSTreeNode<>(7);
        node.setRight(rightNode);
        assertEquals(rightNode, node.getRight());
    }
}
