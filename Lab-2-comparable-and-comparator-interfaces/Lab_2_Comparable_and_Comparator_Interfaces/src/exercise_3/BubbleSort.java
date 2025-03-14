package exercise_3;

public class BubbleSort {

	public static void bubbleSort(int[] unsortedArray) {
		//Each pair of numbers are compared in ascending index order
		for(int i = 0; i < unsortedArray.length - 1; i++) {
			for(int j = 0; j < unsortedArray.length - i - 1; j++) {
				//Each pair of numbers is swapped if one number is less than another within a given pair
				if(unsortedArray[j] > unsortedArray[j+1]) {
					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
				}
			}
		} 
		
	}

}
