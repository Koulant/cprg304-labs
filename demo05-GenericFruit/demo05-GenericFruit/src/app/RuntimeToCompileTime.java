package app;

import java.util.ArrayList;

public class RuntimeToCompileTime {
	
	public static void main(String args[])
	{
		// runtime error
		ArrayList stuff = new ArrayList();
		stuff.add("Kitty");
		stuff.add(28);
		for( int i = 0; i < stuff.size(); i++ ) {
			Integer age = (Integer) stuff.get(i);
		}
		if( stuff.get(0).equals( stuff.get(1) ) )
		{
			// what the heck are we comparing???
		}
				
		// compile time error
		ArrayList<String> names = new ArrayList<>();
		names.add("Kitty");
//		names.add(28);
		
	}
	
}
