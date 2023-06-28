package _202306._03_triangle;
import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_NoDotsInTriangle {

	public static void main(String[] args) {
		
//		NoDotsInTriangle_01_Math.IS_DEBUG = true;
		
		{
			List<Integer> X = Arrays.asList(1, 4, 3, 2, 3);
			List<Integer> Y = Arrays.asList(4, 3, 1, 1, 2);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(0);
			List<Integer> Y = Arrays.asList(0);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(0, 1, 2, 4, 4, 5, 6);
			List<Integer> Y = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(0, 1, 3, 0, 0, 2);
			List<Integer> Y = Arrays.asList(3, 0, 0, 1, 2, 0);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(0, 1, 2, 2, 3);
			List<Integer> Y = Arrays.asList(3, 0, 1, 0, 2);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(-2, 0, 0, 2);
			List<Integer> Y = Arrays.asList(-2, 1, -1, -1);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		{
			List<Integer> X = Arrays.asList(-2, 0, 2, 3, 3);
			List<Integer> Y = Arrays.asList(-2, -1, 0, 3, -2);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
		
		{
			List<Integer> X = Arrays.asList(-2, 0, 2 );
			List<Integer> Y = Arrays.asList(-2, -1, 0);
			out.println();
			out.println( NoDotsInTriangle_02_Sort.isAnyTriangleHavingNoDotsWithin(X, Y) );
			out.println( NoDotsInTriangle_01_Math.isAnyTriangleHavingNoDotsWithin(X, Y) );
			
		}
		
	}

}


