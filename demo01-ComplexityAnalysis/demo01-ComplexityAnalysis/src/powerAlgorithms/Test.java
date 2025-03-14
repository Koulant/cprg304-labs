package powerAlgorithms;

/**
 * @author kitty
 *
 */

import utilities.Debug;

public class Test
{
	private static int base;
	private static int power;
	private static int debugLevel;
	
    public static void main(String[] args)
    {
    	long start, stop;
    	
    	new Test().parseArgs( args );
    
    	// this would normally be set outside of the application through args
    	// or read from a configuration file and would include levels such as
    	// verbose, severe, errors, warnings, info or none depending on the 
    	// application, customer needs and industry standards/compliances
    	Debug debug = new Debug(debugLevel);
    	
    	SimplePowerAlgorithm s1 = new SimplePowerAlgorithm();
    	SmartPowerAlgorithm s2 = new SmartPowerAlgorithm();

    	// use args for base and power, then display time to calc
    	// use debug levels to show intermediate results
    	start = System.nanoTime();
    	s1.calculate(base, power, debug);
    	stop = System.nanoTime();
    	debug.output(1, "Time for Simple: " + (stop - start));
    	
    	start = System.nanoTime();
    	s2.calculate(base, power, debug);
    	stop = System.nanoTime();
    	debug.output(1, "Time for Smart: " + (stop - start));
    }
    
    private void parseArgs(String[] args)
    {
    	if( args.length < 3 )
    	{
    		System.out.println("Not enough arguments.");
    		System.out.println("Usage: base power debug_level");
    		return;
    	}
    	
    	// testing: comment out when done?
    	System.out.println("Testing args...");
    	for( int i = 0; i < args.length; i++ )
        {
        	System.out.println(args[i]);       	
        } 
    	System.out.println("Done testing args!\n");
    	
    	this.base = Integer.parseInt(args[0]);
    	this.power = Integer.parseInt(args[1]);
    	this.debugLevel = Integer.parseInt(args[2]);
    }
}
