package counterADT;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

public class CounterTests {
	
	private CounterComplete c1;
	
	@Before
	public void setUp () {
		c1 = new CounterComplete(1);
	}
	
	@Test
	public void testGetCounter() {
		int expected = 1;
		int actual = c1.getCounter();
		
		assertEquals("GetCounter method did not return the correct value!", expected, actual);
	}
	
	@Test 
	public void testIncCounter() {
		int expected1 = 2;
		c1.incCounter();
		
		int actual1 = c1.getCounter();
		
		assertEquals("GetCounter method did not return the correct value!", expected1, actual1);
	}
}
