package _0525_._02_processesExecution;
import static java.lang.System.out;
public class Test_processesExecution {

	public static void main(String[] args) {
		
		out.println("({3, 4, 5, 6}, 3) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {3, 4, 5, 6}, 3));
		
		out.println("({3, 10, 3, 4}, 3) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {3, 10, 3, 4}, 3));
		
		out.println("({4, 5, 4, 5, 4, 3}, 22) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {4, 5, 4, 5, 4, 3}, 2));
		
		out.println("({1000, 1, 2, 3}, 2) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {1000, 1, 2, 3}, 2));
		
		out.println("({100, 257, 157, 399, 15, 74}, 3) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {100, 257, 157, 399, 15, 74}, 3));
		
		out.println("({100, 257, 157, 399, 15, 74}, 2) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {100, 257, 157, 399, 15, 74}, 2));
		
		out.println("({100, 257, 157, 399, 15, 74}, 4) -> ans = " 
				+ ProcessesExecutor.minimumTaskHours(new Integer[] {100, 257, 157, 399, 15, 74}, 4));
	}

}


