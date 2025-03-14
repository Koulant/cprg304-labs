package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import utilities.BSTree;
import utilities.BSTreeADT;
import utilities.BSTreeNode;
import utilities.Iterator;
import exceptions.TreeException;

/**
 * JUnit tests for the BSTree class.
 */
public class BSTreeTests {
	
    private BSTreeADT<Integer> bst;

    @Before
    public void setUp() {
        setBst(new BSTree<>());
    }

    @Test
    public void testGetRoot() throws TreeException {
        BSTree<Integer> tree = new BSTree<>();
        assertThrows(TreeException.class, () -> tree.getRoot());

        tree.add(5);
        assertNotNull(tree.getRoot());
        assertEquals(5, (int) tree.getRoot().getElement());
    }

    @Test
    public void testGetHeight() {
        BSTree<Integer> tree = new BSTree<>();
        assertEquals(0, tree.getHeight());

        tree.add(5);
        assertEquals(1, tree.getHeight());

        tree.add(3);
        tree.add(7);
        assertEquals(2, tree.getHeight());

        tree.add(2);
        tree.add(4);
        assertEquals(3, tree.getHeight());
    }

    @Test
    public void testSize() {
        BSTree<String> tree = new BSTree<>();
        assertEquals(0, tree.size());

        tree.add("apple");
        assertEquals(1, tree.size());

        tree.add("orange");
        tree.add("banana");
        assertEquals(3, tree.size());
    }

    @Test
    public void testIsEmpty() {
        BSTree<Character> tree = new BSTree<>();
        assertTrue(tree.isEmpty());

        tree.add('A');
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testClear() throws TreeException {
        BSTree<Double> tree = new BSTree<>();
        tree.add(3.14);
        tree.add(2.71);
        tree.clear();
        assertThrows(TreeException.class, () -> tree.getRoot());
        assertEquals(0, tree.size());
    }

    @Test(expected = TreeException.class)
    public void testGetRootException() throws TreeException {
        BSTree<Integer> tree = new BSTree<>();
        tree.getRoot(); // Should throw TreeException since tree is empty
    }

    @Test
    public void testContains() throws TreeException {
        BSTree<Integer> tree = new BSTree<>();
        assertThrows(TreeException.class, () -> tree.contains(null));

        tree.add(42);
        assertTrue(tree.contains(42));
        assertFalse(tree.contains(24));
    }

    @Test
    public void testSearch() throws TreeException {
        BSTree<String> tree = new BSTree<>();
       
        assertThrows(TreeException.class, () -> tree.search("apple"));

        tree.add("apple");
        BSTreeNode<String> node = tree.search("apple");
        assertNotNull(node);
        assertEquals("apple", node.getElement());

        
        assertNull(tree.search("orange"));
    }

    @Test
    public void testAdd() {
        BSTree<Integer> tree = new BSTree<>();
        assertTrue(tree.add(42));
        assertFalse(tree.add(42)); // Duplicate, should return false
        assertTrue(tree.add(24));
        assertTrue(tree.add(56));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        BSTree<String> tree = new BSTree<>();
        tree.add(null); // Should throw NullPointerException
    }

    @Test
    public void testInorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.inorderIterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPreorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.preorderIterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPostorderIterator() {
        BSTree<Integer> tree = new BSTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        Iterator<Integer> iterator = tree.postorderIterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(7), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(5), iterator.next());
        assertFalse(iterator.hasNext());
    }

	public BSTreeADT<Integer> getBst() {
		return bst;
	}

	public void setBst(BSTreeADT<Integer> bst) {
		this.bst = bst;
	}
    
}
