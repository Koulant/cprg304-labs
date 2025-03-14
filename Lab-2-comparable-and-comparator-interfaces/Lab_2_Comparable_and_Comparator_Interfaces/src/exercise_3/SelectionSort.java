package exercise_3;

public class SelectionSort {

	public static void selectionSort(int[] unsortedArray) {
		//Search through every value of an array and keep track of the minimum value
		for(int i = 0; i < unsortedArray.length - 1; i++) {
			int minimum = i;
			for(int j = i + 1; j < unsortedArray.length; j++) {
				if(unsortedArray[minimum] > unsortedArray[j]) {
					minimum = j;
				}
			}
			//Swap variables after each iteration of the for loops
			int temp = unsortedArray[i];
			unsortedArray[i] = unsortedArray[minimum];
			unsortedArray[minimum] = temp;
			
		}	
		
	}

}
