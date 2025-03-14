package utilities;

/**
 * @author kitty
 *
 */

public class Debug 
{
	//Constants
	//Attributes
	private int appLevel;

	//Constructors
	/**
	 * User defined constructor
	 * @param level - externally defined debug level
	 */
	public Debug(int level) 
	{
		this.appLevel = level;
	}

	//Getter and Setter Methods
	/**
	 * @return the current debug level
	 */
	public int getLevel() 
	{
		return this.appLevel;
	}

	/**
	 * @param level - the current debug level
	 */
	public void setLevel(int level) 
	{
		this.appLevel = level;
	}

	//Operational Methods
	/**
	 * @param msg - the debug output message
	 */
	public void output(int level, String msg) 
	{
		if (level <= this.appLevel)
		{
			System.out.println(msg);
		}
		else // debug == 0
		{
			// do nothing
		}
	}
}
