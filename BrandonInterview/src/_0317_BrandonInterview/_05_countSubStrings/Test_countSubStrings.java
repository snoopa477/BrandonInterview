package _0317_BrandonInterview._05_countSubStrings;

import static java.lang.System.out;


public class Test_countSubStrings {

	public static void main(String[] args) throws Exception  {
		
		{
			out.println("sigma sequnce: ");
			Sigma sigma = new Sigma();
			
			out.println("sigma(10)" + sigma.getSigma(10));
			out.println("sigma(9)" + sigma.getSigma(9));
		}
		
		{
			out.println("\nTest_countSubStrings");
			String[] inputs = {"zzzyz","zzzzz", "zyyzzyyyyyyy" };
			
			out.println("input: count of sub-strings");
			for(String input: inputs) {
				out.println(input +  " : " + countSubStrings(input));
			}
			
		}
		
	}
	
	static private int countSubStrings(String str) throws Exception {
		
		char[] chars = str.toCharArray();
		
		Sigma sigma = new Sigma();
		
		int counts = 0;
		int frequency = 0;
		for( int i = 0,  prevChar = 0; i < chars.length; i++ ) {
			
			char currentChar = chars[i];
			if( prevChar == 0 || currentChar == prevChar ) {
				frequency++;
			}
			else {
				counts += sigma.getSigma(frequency);
				frequency = 1;
			}
			prevChar = currentChar;
		}
		counts += sigma.getSigma(frequency);
		
		return counts;
	}
	
	
}
