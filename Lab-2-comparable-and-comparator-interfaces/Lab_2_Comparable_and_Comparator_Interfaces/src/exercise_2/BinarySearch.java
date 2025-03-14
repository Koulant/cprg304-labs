package exercise_2;

//Exercise 2

public class BinarySearch {
	//Implement a static method binarySearch that takes a sorted list of integer objects and an integer target,
	//and returns the index of the target in the list if it exists, or -1 if it doesn’t.
	
	//Binary search method
	public static int binarySearch(Integer[] sortedArray, int target) {
		int left = 0;
		int right = sortedArray.length - 1;
		
		while (left <= right) {
			int middle = left + (right - left) / 2;
			
			int compareObjects = sortedArray[middle].compareTo(target); //Using compareTo to compare integer objects
			
			if (compareObjects == 0) {
				return middle; //Target acquired
			}
			else if (sortedArray[middle] < target ) {
				left = middle + 1; //Search in the right half of the sorted array 
			}
			else {
				right = middle - 1; //Search in the left half of the sorted array 
			}
		}
		
		return -1; //Target not found
	}
}
