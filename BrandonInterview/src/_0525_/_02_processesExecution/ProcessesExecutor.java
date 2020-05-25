package _0525_._02_processesExecution;
import java.util.Arrays;
public class ProcessesExecutor {

	public static int minimumTaskHours(Integer[] taskHours, int serverNumber) {
		
		Integer[] sortedDescHours = Arrays.copyOf(taskHours, taskHours.length);
		Arrays.sort(sortedDescHours, (e1, e2) -> e2 - e1);
		
		int[] serverProcessHours = new int[serverNumber];
		
		for(int i = 0; i < sortedDescHours.length; i++) {
			int indexToMinValue = indexToMinimumValue(serverProcessHours);
			serverProcessHours[indexToMinValue] += sortedDescHours[i];
		}
		
		return  maxValue(serverProcessHours);
	}
	
	private static int indexToMinimumValue( int[] arr ) {
		
		int minValue = Integer.MAX_VALUE;
		int index = -1;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] < minValue) {
				index = i;
				minValue = arr[i];
			}
		}
		
		return index;
	}
	
	private static int maxValue(int[] arr) {
		int maxValue = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		
		return maxValue;
	}
	
}


