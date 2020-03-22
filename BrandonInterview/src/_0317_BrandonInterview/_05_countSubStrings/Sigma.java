package _0317_BrandonInterview._05_countSubStrings;

public class Sigma {

	static final int MAX_INDEX = 100;
	
	private static int[] sigmaSequnce;

	public Sigma() {
		sigmaSequnce = new int[MAX_INDEX];
	}
	
	public int getSigma(int index) throws Exception {
		
		if( index < 0 || index > MAX_INDEX) {
			throw new Exception();
		}
		
		if(index == 0) {
			return 0;
		}
		
		if( sigmaSequnce[index] == 0) {
			sigmaSequnce[index] = index + getSigma( index -1 );
		}
		
		return sigmaSequnce[index];
		
	}
	
}
