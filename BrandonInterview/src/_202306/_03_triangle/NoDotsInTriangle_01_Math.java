package _202306._03_triangle;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class NoDotsInTriangle_01_Math {
	
	
	/*
	 REFERENCE:
	 https://web.ntnu.edu.tw/~49440326/T3260b/T3260b.htm
	 https://medium.com/@a0976840931/%E2%91%A0%E5%88%A4%E6%96%B7%E9%BB%9E%E6%98%AF%E5%90%A6%E5%9C%A8%E4%B8%89%E8%A7%92%E5%BD%A2%E5%85%A7%E9%83%A8-%E5%90%8C%E5%81%B4%E6%B3%95-15a28b3bfca3
	 * */
	
	public static boolean IS_DEBUG = false;
	
	private static class Coord{
		public int x;
		public int y;
		
		
		public Coord(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}


		@Override
		public String toString() {
			return "Coord [x=" + x + ", y=" + y + "]";
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
		
		for( int i = 0; i < dots.size(); i++ ) {
			for( int j = i + 1; j < dots.size(); j ++ ) {
				for( int k = j + 1; k < dots.size(); k++ ) {
					
					// x is the tested point
					boolean isIJKpickOK = true;
					for( int x = 0; x < dots.size(); x++ ) {
						//if( x != i || x != j || x != k ) {
						if( x != i && x != j && x != k ) {
							
							Coord dot_i = dots.get(i);
							Coord dot_j = dots.get(j);
							Coord dot_k = dots.get(k);
							Coord dot_x = dots.get(x);
							
//							int result_ij = isAboveTheLineFormedByTwoDots( dot_i, dot_j, dot_x);
//							int result_jk = isAboveTheLineFormedByTwoDots( dot_j, dot_k, dot_x);
//							int result_ki = isAboveTheLineFormedByTwoDots( dot_k, dot_i, dot_x);
							
							int result_ij = crossProduct( dot_i, dot_j, dot_x);
							int result_jk = crossProduct( dot_j, dot_k, dot_x);
							int result_ki = crossProduct( dot_k, dot_i, dot_x);
							
//							if( !( result_ij > 0 && result_jk >0 && result_ki > 0 )
//									&& !( result_ij < 0 && result_jk < 0 && result_ki < 0 )) {
							
							
							if( IS_DEBUG ) { 
								out.println( "(i,j,k,x)" + " " + i + " " + j + " " + k + " " + x );
								out.println( result_ij + " " + result_jk + " " + result_ki ); 
							}
							
							if( ( result_ij >= 0 && result_jk >= 0 && result_ki >= 0 )
								|| ( result_ij <= 0 && result_jk <= 0 && result_ki <= 0 )) {
								
								isIJKpickOK = false;
								break;
							}
						}
					}
					
					if( isIJKpickOK ) {
						return Arrays.asList(i, j, k);
					}
					
				}
			}
		}
		
		
		
		return null;
	}
	
	
	private static List<Coord> getDots( List<Integer> rows, List<Integer> cols ){
		
		List<Coord> dots = new ArrayList<>();
		for( int i = 0; i < rows.size(); i++ ) {
			dots.add( new Coord(rows.get(i), cols.get(i)) );
		}
		return dots;
	}
	
	
	//WRONG:
	private static int isAboveTheLineFormedByTwoDots( Coord dot1, Coord dot2, Coord dot3 ) {
		
		int x1 = dot1.x;
		int y1 = dot1.y;
		
		int x2 = dot2.x;
		int y2 = dot2.y;
		
		int x3 = dot3.x;
		int y3 = dot3.y;
		
		//return y3 * ( x1 - x2 ) - y1 * ( x1 - x2 )  - x3 * ( y1 - y2 ) + x1 * ( y1 - y2 ) > 0;
		return y3 * ( x1 - x2 ) - y1 * ( x1 - x2 )  - x3 * ( y1 - y2 ) + x1 * ( y1 - y2 );
	}
	
	
	
	private static int crossProduct( Coord dot1, Coord dot2, Coord dot3 ) {
		
		int x1 = dot1.x;
		int y1 = dot1.y;
		
		int x2 = dot2.x;
		int y2 = dot2.y;
		
		int x3 = dot3.x;
		int y3 = dot3.y;
		
		int vector_12_x = x2 - x1;
		int vector_12_y = y2 - y1;
		
		int vector_13_x = x3 - x1;
		int vector_13_y = y3 - y1;
		
		
		
	
		return vector_12_x * vector_13_y - vector_13_x * vector_12_y;
	}
	
	

}


