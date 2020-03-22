package _0317_BrandonInterview._04_studentScores;

import static java.lang.System.out;

import java.util.Arrays;

import _0317_BrandonInterview.Utilities.ArrayHelper;

public class Test_studentScores {

	public static void main(String[] args) {
		
		{
			int[] scores = {1, 6, 3, 4, 3, 5};
			out.println("before changed ");
			ArrayHelper.print(scores);
			changeScores(scores);
			out.println("after changed ");
			ArrayHelper.print(scores);
			
		}
		
		{
			int[] scores = {100, 50, 40, 30};
			out.println("\nbefore changed ");
			ArrayHelper.print(scores);
			changeScores(scores);
			out.println("after changed ");
			ArrayHelper.print(scores);
		}
		
	}
	
	private static void changeScores(int[] scores) {
		
		if(scores.length <=2 ) {
			return;
		}
		
		ScorePerformance[] performances = new ScorePerformance[scores.length];
		
		Arrays.fill(performances, ScorePerformance.NONE);
		
		do {
			evaluatePerformaces(scores, performances);
			updateScoresByPerformances(scores, performances);
		}while( isAnyScoreChanged(performances) );
		
		
	}

	private static boolean isAnyScoreChanged(ScorePerformance[] performances) {
		
		if(performances.length <=2 ) {
			return false;
		}
		
		for(int i = 1; i < performances.length -1 ; i++) {
			if(performances[i] != ScorePerformance.NONE) {
				return true;
			}
		}
		
		return false;
	}
	
	private static void evaluatePerformaces(int[] scores, ScorePerformance[] performances) {
		
		if(scores.length <=2 ) {
			return;
		}
		
		for(int i = 1; i < scores.length -1; i++) {
			if( scores[i-1] > scores[i] && scores[i] < scores[i+1] ) {
				performances[i] = ScorePerformance.INCREASE;
			}
			else if( scores[i-1] < scores[i] && scores[i] > scores[i+1]) {
				performances[i] = ScorePerformance.DECREASE;
			}
			else {
				performances[i] = ScorePerformance.NONE;
			}
		}
	}
	
	private static void updateScoresByPerformances(int[] scores, ScorePerformance[] performances) {
		
		if(scores.length <=2 ) {
			return;
		}
		
		for(int i = 1; i < scores.length-1 ; i ++) {
			switch( performances[i] ) {
				case INCREASE:
					scores[i]++;
					break;
				case DECREASE:
					scores[i]--;
					break;
				case NONE:
					break;
			}
		}
	}

}
