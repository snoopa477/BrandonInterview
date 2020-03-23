package _0317_BrandonInterview._02_maxApples._01_greedyAlgorithm;

public class QuickSort {

	
	public static void quickSort(int[] array) {
		quickSort(array, 0 , array.length-1);
	}
	
	public static void quickSort(int[] array, int low, int high) {
		
		if( low < high == false) {
			return;
		}
		
		int right_start = partition(array, low, high);
		int left_end = right_start -1;
		
		if( low < left_end ) {
			quickSort(array, low, left_end);
		}
		
		if(right_start < high) {
			quickSort(array, right_start, high);
		}
		
	}

	private static int partition(int[] array, int low, int high) {
		
		int pivot = array[low + (high - low) /2];
		while(low <= high) {
			
			while(low <= high ) {
				
				while(array[low] < pivot) {
					low++;
				}
				
				while(array[high] > pivot) {
					high--;
				}
				
				if( low <= high ) {
					swap(array, low, high);
					low++;
					high--;
				}
			}
		}
		
		int right_start = low;
		return right_start;
		
	}
	
	private static void swap(int[] array, int a, int b) {
		
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
}
