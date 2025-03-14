/**
 * Created on May 31, 2011
 * Modified on September 30, 2013
 *
 * Project: demo08-ComplexityAnalysisOfStringConcatenation
 */
package complexityStrings;

/**
 * Concat.java
 *
 * @author dwatson, kitty
 * @version 1.1
 * 
 * Class Definition: Class to demonstrate the performance differences between
 * String, StringBuffer and StringBuilder when appending characters to a
 * string.
 */
public class Concat
{
	public static final int	TEST_SIZE = 1000;
	
	//Attributes
	private String			str;
	private StringBuffer	sBuf;
	private StringBuilder   sBuild;
	private int				size;
	
	//Constructors
	public Concat()
	{
	}

	/**
	 * @param size
	 */
	public Concat(int size)
	{
		this.size = size;
	}


	//Operational Methods
	/**
	 * Concats characters to a String object.
	 * @return the time required to perform this operation.
	 */
	public long stringTime()
	{
		char			letter;
		int				i;
		long			start, stop;
		
		start = System.currentTimeMillis();
		
		for(letter = 'a', i = 0; i < size; i++, letter++)
		{
			str = str + letter;
			if(i % 25 == 0)
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}
	
	/**
	 * Concats characters to a StringBuffer object.
	 * @return the time required to perform this operation.
	 */
	public long stringBufferTime()
	{
		char 			letter;
		int				i;
		long			start,stop;
		sBuf = new StringBuffer(size);
		
		start = System.currentTimeMillis();
		
		for(letter = 'a', i = 0; i < size; i++, letter++)
		{
			sBuf.append(letter);
			if(i % 25 == 0)
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}
	
	/**
	 * Concats characters to a StringBuilder object.
	 * @return the time required to perform this operation.
	 */
	public long stringBuilderTime()
	{
		char 			letter;
		int				i;
		long			start,stop;
		sBuild = new StringBuilder(size);
		
		start = System.currentTimeMillis();
		
		for(letter = 'a', i = 0; i < size; i++, letter++)
		{
			sBuild.append(letter);
			if(i % 25 == 0)
			{
				letter = 'a';
			}
		}
		stop = System.currentTimeMillis();
		return stop - start;
	}
	
	/**
	 * Main to run application
	 * @param args
	 */
	public static void main(String[] args)
	{
		Concat cs = new Concat(TEST_SIZE);
		
		System.out.println("This is time for string: "+cs.stringTime());
		System.out.println("This is time for StringBuffer: "+cs.stringBufferTime());
		System.out.println("This is time for StringBuilder: "+cs.stringBuilderTime());
	}
}
