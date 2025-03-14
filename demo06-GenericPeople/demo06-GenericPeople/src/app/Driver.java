package app;

/**
 * Created on August 23, 2019
 *
 * @author kitty
 * @version 1.2
 * 
 */

import school.Program;
import school.UntypedCourse;
import school.Course;
import people.CSStudent;
import people.SDStudent;

public class Driver
{

	public static void main(String[] args)
	{
		UntypedCourse rc = new UntypedCourse("Untyped Course");
		SDStudent link = new SDStudent("Link");
		SDStudent zelda = new SDStudent("Zelda");
		CSStudent ganon = new CSStudent("Ganon");
		rc.addStudent(link);
		rc.addStudent(zelda);
		// the following is allowed because RawCourse allows any type of student and
		// generates no errors or warnings
		rc.addStudent(ganon); 
		rc.printStudentList();
		
		Program<Course<SDStudent>> SD = new Program<>("ITSD");
		Program<Course<CSStudent>> CS = new Program<>("ITCS");
		
		Course<SDStudent> cprg311 = new Course<>("CPRG311");
		Course<SDStudent> cprg307 = new Course<>("CPRG307");
		Course<CSStudent> cmps254 = new Course<>("CMPS254");
		
		SD.addCourse(cprg311);
		SD.addCourse(cprg307);
		// the following is not allowed due to program only allowing course of CS students
//		SD.addCourse(cmps254);
		CS.addCourse(cmps254);
		
		cprg311.addStudent(link);
		cprg311.addStudent(zelda);
		// the following is not allowed due to course only allowing CS students
//		cprg311.addStudent(ganon);
		cmps254.addStudent(ganon);
		
		// these generate an unchecked warning for raw types and allows for any 
		// student to be added to the course
		Course rawCourse = new Course("Raw Course");
		rawCourse.addStudent(link);
		rawCourse.addStudent(ganon);
		
		// these generate an unchecked warning for raw types and allows for any 
		// course to be added to the program
		Program rawProgram = new Program("Raw Program");
		rawProgram.addCourse(cprg311);
		rawProgram.addCourse(cmps254);
		rawProgram.addCourse(rawCourse);
		
		Program<Course> halfRaw = new Program<>("Half Raw");
		halfRaw.addCourse(cprg311);	// no warning?!?!
		halfRaw.addCourse(cmps254); // no warning?!?!
		
	}

}
