package _0317_BrandonInterview._03_bitwiseOperation;

public class BitwiseOperation {

	public static int shfitRightHexDigit(int num) {
		return num >> 4;
	}
	
	public static int getLeastSignificantHexDigit(int num) {
		return num & 0b1111  ;
	}
}
