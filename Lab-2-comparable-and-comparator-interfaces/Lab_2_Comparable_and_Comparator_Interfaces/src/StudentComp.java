import java.util.Comparator;

public class StudentComp implements Comparator<Student> {

	//Remember, this one is based on the age 
	
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getAge() > o2.getAge()) {
			return 1;
		}
		else if (o1.getAge() < o2.getAge()) {
			return -1;
		}
		else {
			return 0; //They are equal
		}
		
	
		
	}
	
}
