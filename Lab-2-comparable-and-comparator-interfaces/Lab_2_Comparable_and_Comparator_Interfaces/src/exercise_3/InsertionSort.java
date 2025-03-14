package exercise_3;

public class InsertionSort {

	public static void insertionSort(int[] unsortedArray) {
		//Each number in the array is compared with the number to the left 
		for(int i = 1; i < unsortedArray.length; i++) {
			int temp = unsortedArray[i];
			int j = i - 1;
			//If the number to the left is greater than the number stored in temp,
			// all of the numbers to the left, are moved to the right of the number stored in temp
			while(j >= 0 && unsortedArray[j] > temp) {
				unsortedArray[j + 1] = unsortedArray[j];
				j--;
			}
			unsortedArray[j+1] = temp;
		}
		
	}

}
