/**
 * Created on Oct 26, 2023
 *
 * Project: demo07 - SLL
 */

package testSLL;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import linkedListImplementation.SLLNode;


/**
 * SLLNodeUnitTest.java
 *
 * @author kitty
 * @version 1.1
 *
 */
public class SLLNodeUnitTest {

	//Attributes
	private SLLNode<Integer> one, two;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		two = new SLLNode<Integer>(2);
		one = new SLLNode<Integer>(1, two);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		one = null;
		two = null;
	}
	
	/**
	 * Test method for {@link linkedListImplementation.SLLNode#SLLNode(java.lang.Object, linkedListImplementation.SLLNode)}.
	 */
	@Test
	public void testSLLNodeESLLNodeOfE() 
	{
		boolean expected = true;
		boolean actual = one != null;
		assertEquals("Node was not created correctly.", expected, actual);
	}

	/**
	 * Test method for {@link linkedListImplementation.SLLNode#SLLNode(java.lang.Object)}.
	 */
	@Test
	public void testSLLNodeE() 
	{
		boolean expected = true;
		boolean actual = two != null;
		assertEquals("Node was not created correctly.", expected, actual);
	}

	/**
	 * Test method for {@link linkedListImplementation.SLLNode#getElement()}.
	 */
	@Test
	public void testGetElement() 
	{
		int expected = 1;
		int actual = one.getElement();
		assertEquals("Element was not retrieved correctly.", expected, actual);
	}

	/**
	 * Test method for {@link linkedListImplementation.SLLNode#setElement(java.lang.Object)}.
	 */
	@Test
	public void testSetElement() 
	{
		int expected = 3;
		one.setElement(3);
		int actual = one.getElement();
		assertEquals("Element was not modified correctly.", expected, actual);

	}

	/**
	 * Test method for {@link linkedListImplementation.SLLNode#getNext()}.
	 */
	@Test
	public void testGetNext() 
	{
		SLLNode<Integer> expected = two;
		SLLNode<Integer> actual = one.getNext();
		assertEquals("Next node was not retrieved correctly.", expected, actual);
	}

	/**
	 * Test method for {@link linkedListImplementation.SLLNode#setNext(linkedListImplementation.SLLNode)}.
	 */
	@Test
	public void testSetNext() 
	{
		SLLNode<Integer> expected = new SLLNode<Integer>(3);
		two.setNext(expected);
		SLLNode<Integer> actual = two.getNext();
		assertEquals("Next node was not modified correctly.", expected, actual);

	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() 
	{
		System.out.println(one.toString());
	}

}
