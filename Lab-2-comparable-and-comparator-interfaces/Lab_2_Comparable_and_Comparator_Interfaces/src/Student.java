
public class Student implements Comparable<Student> {
	private String name;
	private int age;
	
	public Student(String n, int a) {
		this.name = n;
		this.age = a;
	}
	
	/*Return the name */
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Student o) {
		return this.name.toLowerCase().compareTo(o.getName().toLowerCase()); //Sorts by name (natural order)
		
		/*
		if(this.age > o.getAge()) {
			return 1;
		}
		else if(this.age < o.getAge()){
			return -1;
		}
		else {
			return 0; 
		}
		*/
	}
	
	
}
