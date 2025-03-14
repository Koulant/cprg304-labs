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

public class UntypedCourse
{
	private String courseCode;
	private ArrayList<Student> students = new ArrayList<>();
	
	public UntypedCourse( String courseCode )
	{
		this.courseCode = courseCode;
	}
	
	public String getCourseCode()
	{
		return this.courseCode;
	}
	
	public void addStudent( Student student )
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
		for( Student s : students )
		{
			System.out.println( "\t" + s.getName() );
		}
	}
	
}
