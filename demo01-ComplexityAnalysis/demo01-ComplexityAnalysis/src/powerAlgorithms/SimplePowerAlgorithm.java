package powerAlgorithms;

import utilities.Debug;

public class SimplePowerAlgorithm {

	public void calculate(int base, int power, Debug debug)
	{
		int x = 1;
		
		for( int i = 0; i < power; i++ )
		{
			x *= base;
			debug.output(3, "Simple -- " + x);
		}
		
		debug.output(2, "Simple answer is: " + x);
	}
}
