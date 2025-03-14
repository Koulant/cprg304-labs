package powerAlgorithms;

import utilities.Debug;

public class SmartPowerAlgorithm {

	public void calculate(int base, int power, Debug debug)
	{
		int x = 1;
		int y = base;
		int z = power;
		
		while(z > 0)
		{
			if(z%2 == 1) x *= y;
			z /= 2;
			y *= y;
			debug.output(3, "Smart -- " + x);
		}
		
		debug.output(2, "Smart answer is: " + x);
	}
}
