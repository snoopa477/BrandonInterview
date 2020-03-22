package _0317_BrandonInterview._02_maxApples._01_greedyAlgorithm;

public class QuickSort {

	
	public static void quickSort(int[] array) {
		quickSort(array, 0 , array.length-1);
	}
	
	public static void quickSort(int[] array, int low_index, int high_index) {
		
		int right_part_low_index = partition(array, low_index, high_index);
		int left_part_high_index = right_part_low_index -1;
		
		if( low_index < left_part_high_index ) {
			quickSort(array, low_index, left_part_high_index);
		}
		
		if(right_part_low_index < high_index) {
			quickSort(array, right_part_low_index, high_index);
		}
		
	}

	
	private static int partition(int[] array, int low_index, int high_index) {
		
		int pivot_index = low_index + (high_index - low_index) /2;
		int pivot = array[pivot_index];
		
		while(low_index <= high_index) {
			
			while(low_index <= high_index ) {
				
				while(array[low_index] < pivot) {
					low_index++;
				}
				
				while(array[high_index] > pivot) {
					high_index--;
				}
				
				if( low_index <= high_index ) {
					swap(array, low_index, high_index);
					low_index++;
					high_index--;
				}
			}
		}
		
		int right_part_low_index = low_index;
		return right_part_low_index;
		
	}
	
	private static void swap(int[] array, int a_index, int b_index) {
		
		int temp = array[a_index];
		array[a_index] = array[b_index];
		array[b_index] = temp;
	}
	
}
