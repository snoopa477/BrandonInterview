package _202306._03_triangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoDotsInTriangle_02_Sort {
	
	private static class Coord implements Comparable<Coord> {
		
		public int index;
		public int x;
		public int y;
		
		
		public Coord(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}


		//DETAIL: this is called by Collections.sort( dots );
		@Override
		public int compareTo(Coord o) {
			
			if( this.x != o.x ) { 
				return this.x - o.x;
			}
			else { 
				return this.y - o.y;
			}
		}
	}
	
	
	
	public static List<Integer> isAnyTriangleHavingNoDotsWithin( List<Integer> rows, List<Integer> cols ){
		
		if( rows.size() != cols.size() ) {
			return null;
		}
		
		
		if( rows.size() < 2 ) {
			return null;
		}
		
		
		if( rows.size() == 3 ) {
			return Arrays.asList(0, 1, 2);
		}
		
		
		List<Coord> dots = getDots( rows, cols );
		
		/*
		 REASONING: 
		 given a triangle 3 corner coordinations are (x1, y2), ( x2, y2), (x3, y3) respectively
		 the necessary condition for a dot to lie within a triangle is to have such x, such that is larger than x1 and smaller than x2, 
		 where x1 and x2 are two of triangle corner's x coordination
		 
		 Therefore, we sorted all dots by x increasingly
		 pick three 3 dots with least x value as corners of a triangle; then there will NO other dots can lie within a triangle, 
		 because the necessary condition mentioned above is not met
		 */
		Collections.sort( dots );
		
		List<Integer> triangleIndeces = Arrays.asList( dots.get(0).index, dots.get(1).index, dots.get(2).index );
		
		return triangleIndeces;
	}
	
	
	
	private static List<Coord> getDots( List<Integer> rows, List<Integer> cols ){
		
		List<Coord> dots = new ArrayList<>();
		for( int i = 0; i < rows.size(); i++ ) {
			dots.add( new Coord(i, rows.get(i), cols.get(i)) );
		}
		return dots;
	}
	
	
	

}


