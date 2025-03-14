package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fruits.*;

// example 1:
public class GatherFruits implements Comparator<List<Fruit>>
// example 2:
//public class GatherFruits implements Comparator<List<Apple>>
// example 3:
//public class GatherFruits implements Comparator<List<? extends Apple>>
// example 4:
//public class GatherFruits implements Comparator<List<? extends Fruit>>
{
	
	public static void main(String args[])
	{
		new GatherFruits().compareFruits();
	}
	
	private void compareFruits()
	{
		// coding to the List interface, not the ArrayList implementation
		// https://stackoverflow.com/questions/383947/what-does-it-mean-to-program-to-an-interface
		List<Fruit> fruitList = new ArrayList<>();
		List<Apple> appleList = new ArrayList<>();
		List<Orange> orangeList = new ArrayList<>();
		List<Gala> galaList = new ArrayList<>();
		List<Fuji> fujiList = new ArrayList<>();

		Apple apple = new Apple(5);
		Orange orange = new Orange(10);
		fruitList.add(apple);
		fruitList.add(orange);
		
		int compare = apple.compareTo(orange);
		System.out.println("Comparing apple to orange: " + compare);

		// using 1st implementation of compare()
		
		// not allowed because List<Apple> and List<Orange> is not
		// actually List<Fruit> (i.e. Fruit superclass has no context of
		// its subclasses
		compare = compare(appleList, orangeList);
		compare = compare(fruitList, appleList);
		
		Gala gala = new Gala(5);
		Fuji fuji = new Fuji(10);
		galaList.add(gala);
		fujiList.add(fuji);

		// now using 2nd implementation of compare() since we shouldn't be
		// comparing apples to oranges anyways! :D
		
		// still not allowed because List<Gala> and List<Fuji> is not
		// List<Apple>!
		compare = compare(galaList, fujiList);
		System.out.println("Comparing gala to fuji: " + compare);
	}
	
	// example 1:
	public int compare(List<Fruit> list1, List<Fruit> list2)
	// example 2:
//	public int compare(List<Apple> list1, List<Apple> list2)
	// example 3:
//	public int compare(List<? extends Apple> list1, List<? extends Apple> list2)
	// example 4:
//	public int compare(List<? extends Fruit> list1, List<? extends Fruit> list2)
	{
		int count = 0;
		for( int i = 0; i < list1.size(); i++ )
		{
			for( int j = 0; j < list2.size(); j++ )
			{
				if( list1.get(i).compareTo(list1.get(i)) < 0 )
					count++;
			}			
		}
		return count;
	}

}
