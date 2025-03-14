package school;

/**
 * Created on August 23, 2019
 *
 * @author kitty
 * @version 1.0
 * 
 */

import java.util.ArrayList;
import people.Student;

// if we had declared Course<T> then any type can be instantiated with Course
// e.g. Course<String> which doesn't make much sense
// So we want to restrict the types that can be used:
// e.g. <T extends Student> = upperbound of Student class, type parameter
// must be a subclass of Student
// bounds can be a class or interface, you can also declared multiple bounds
// e.g. <T extends ClassA & InterfaceA & InterfaceB>
// but only one class and must be listed first
public class Course<T extends Student>
{
	private String courseCode;
	private ArrayList<T> students = new ArrayList<>();
	
	public Course( String courseCode )
	{
		this.courseCode = courseCode;
	}
	
	public String getCourseCode()
	{
		return this.courseCode;
	}
	
	public void addStudent( T student )
	{
		students.add( student );
	}
	
	public int numStudents()
	{
		return this.students.size();
	}
	
	public void printStudentList()
	{
		System.out.println( this.courseCode + ":" );
		for( T t : students )
		{
			System.out.println( "\t" + t.getName() );
		}
	}
	
}
