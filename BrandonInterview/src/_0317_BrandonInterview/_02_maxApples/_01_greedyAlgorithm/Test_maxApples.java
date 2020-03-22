package _0317_BrandonInterview._02_maxApples._01_greedyAlgorithm;

import static java.lang.System.out;

import java.util.Arrays;

import _0317_BrandonInterview.Utilities.ArrayHelper;

public class Test_maxApples {

	private static final int MAX_BOX_CAPACITY = 5000;
	
	public static void main(String[] args) {
		
		{
			out.println("quickSort");
			
			int[] inputs = {1,15,89,54,12,79,36};
			out.print("before: ");
			ArrayHelper.print(inputs);
			QuickSort.quickSort(inputs);
			out.print("after : ");
			ArrayHelper.print(inputs);
		}
		
		{
			out.println("\nTest_maxApples");
			{
				int[] inputs = new int[]{4850, 100,30,30,100,50,100};
				out.print("inputs: ");
				ArrayHelper.print(inputs);
				out.println( "max apples " + maxNumApplePicked(inputs) );
			
			}
			{
				int[] inputs = new int[]{4650, 150, 150 ,150 };
				out.print("inputs: ");
				ArrayHelper.print(inputs);
				out.println( "max apples " + maxNumApplePicked(inputs) );
			}
		}
		
	}
	
	 private static int maxNumApplePicked(int[] weights) {
		
		if(weights.length <= 1) {
			return 0;
		}
		
		int maxNumApplePicked = 0;
		
		int otherItemWeight = weights[0];
		int box_capacity = MAX_BOX_CAPACITY - otherItemWeight;
		
		
		int[] appleWeights =  Arrays.copyOfRange(weights, 1, weights.length) ;
		
		QuickSort.quickSort(appleWeights);
		
		for(int i = 0 ; i < appleWeights.length; i++) {
			
			if(box_capacity < 0) {
				break;
			}
			box_capacity -= appleWeights[i];
			i++;
			maxNumApplePicked++;
		}
		
		return maxNumApplePicked;
		
	}
	 
	

}
