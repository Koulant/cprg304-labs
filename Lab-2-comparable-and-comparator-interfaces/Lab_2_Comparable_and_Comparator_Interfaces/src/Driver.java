import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
	
	//Exercise 1

	/* Create an array of students */ 
	
	ArrayList<Student> students = new ArrayList<Student>();

	Student s1 = new Student("John", 22);
	Student s2 = new Student("Bart", 35);
	Student s3 = new Student("Sara", 25);
	Student s4 = new Student("Anton", 25);
	
	students.add(s1);
	students.add(s2);
	students.add(s3);
	students.add(s4);
	
	System.out.println("\nInitial list:");
	for (Student s: students) {
		System.out.println("Name: " + s.getName());
		System.out.println("Age: " + s.getAge());
	}
	
	Collections.sort(students);
	
	System.out.println("\nSorted list based on Name:");
	for (Student s: students) {
		System.out.println("Name: " + s.getName());
		System.out.println("Age: " + s.getAge());
	}
	
	
	
	System.out.println("\nSorted list based on Age:");
	
	StudentComp sc = new StudentComp();
	
	Collections.sort(students, sc);
	
	for (Student s: students) {
		System.out.println("Name: " + s.getName());
		System.out.println("Age: " + s.getAge());
	}	
	
	}
}
