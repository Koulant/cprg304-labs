package people;

/**
 * Created on August 23, 2019
 *
 * @author kitty
 * @version 1.0
 * 
 */

public abstract class Student
{
	private String name;
	
	public Student( String name )
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

}
