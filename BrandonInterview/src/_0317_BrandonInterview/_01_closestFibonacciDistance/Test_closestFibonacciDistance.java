package _0317_BrandonInterview._01_closestFibonacciDistance;

import static java.lang.System.out;


public class Test_closestFibonacciDistance {

	public static void main(String[] args) {
		
		{
			int num = 10000;
			out.println("The smallest Fibonacci that is larger than " 
						+ num + " and its lower Fibonaccis");
			Fibonacci fibonacci = new Fibonacci(num);
			out.println( fibonacci );
		}
		
		{
			out.println("\nTest_closestFibonacciDistance");
			ClosestFibonacciLocator cloesetFibonacciLocator = new ClosestFibonacciLocator();
			
			int[] inputs = { 15, 1, 13, 300, 1000, 10000, 1000000 };
			
			out.println("input : closest distance to Fibonacci");
			for(int input: inputs) {
				out.println( input + " : " +  cloesetFibonacciLocator.getClosestDistanceToFibonacci(input));
			}
		}
		
	}
	
}
