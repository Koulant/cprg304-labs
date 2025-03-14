package school;

/**
 * Created on August 23, 2019
 *
 * @author kitty
 * @version 1.0
 * 
 */

import java.util.ArrayList;

// ? is the wildcard type parameter, meaning Course can be any type
// but since the Course class had been defined with <T extends Student>
// we can just allow that bound to restrict the type here for the
// Program class to have the correct Student types
public class Program<T extends Course<?>>
{
	private String name;
	private ArrayList<T> courses = new ArrayList<>();
	
	public Program( String name )
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void addCourse( T course )
	{
		courses.add( course );
	}
	
	public void printCourseList()
	{
		System.out.println( this.name + ":" );
		for( T t : courses )
		{
			System.out.println( "\t" + t.getCourseCode() );
		}
	}
	
}
