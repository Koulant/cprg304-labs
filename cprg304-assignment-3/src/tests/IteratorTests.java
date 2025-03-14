package tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import utilities.BSTree;
import utilities.Iterator;
import java.util.NoSuchElementException;

/**
 * JUnit tests for the Iterator class nested inside of the BSTree class.
 */
public class IteratorTests {

    private Iterator<Integer> iterator;

    @Before
    public void setUp() {
        // You should replace this with your implementation of Iterator
        iterator = new BSTree<>(3).inorderIterator();  // Use your specific iterator
    }

    @Test
    public void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext() {
        assertEquals(Integer.valueOf(3), iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextWithException() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
        // This should throw NoSuchElementException
        iterator.next();
    }

}
