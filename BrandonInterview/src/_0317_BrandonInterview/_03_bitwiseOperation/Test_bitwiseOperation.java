package _0317_BrandonInterview._03_bitwiseOperation;

import static java.lang.System.out;

public class Test_bitwiseOperation {

	public static void main(String[] args) {
		
		int[] inputs = {257,17,3, 256, 258};
		out.println("decimal number: convertion");
		for(int input : inputs) {
			out.println(input + ": " + convertOneZeroInHexDigits(input));
		}
		
	}
	
	public static String convertOneZeroInHexDigits(int num) {
		
		StringBuilder sb = new StringBuilder();
		
		while( num > 0 ) {
			
			int leastSignificantHexDigit = BitwiseOperation.getLeastSignificantHexDigit(num);
			if( leastSignificantHexDigit > 1 ) {
				return "ERROR";
			}
			
			if( leastSignificantHexDigit == 0 ) {
				sb.append("O");
			}
			else{
				sb.append("I");
			}
			
			num = BitwiseOperation.shfitRightHexDigit(num);
		}
		
		
		
		return sb.reverse().toString();
		
	}

}
