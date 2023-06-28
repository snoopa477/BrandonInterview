package _202306._01_dice;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_ForgottenDices {
	
	
	private static int MIN_DICE_VALUE = 1;
	private static int MAX_DICE_VALUE = 6;
	
	
	public static void main(String[] args) {
		
		out.println( possibleCombinationOfForgottenDices(Arrays.asList(3,2,4,3), 2, 4) );
		out.println( possibleCombinationOfForgottenDices(Arrays.asList(1,5,6), 4, 3) );
		out.println( possibleCombinationOfForgottenDices(Arrays.asList(1,2,3,4), 4, 6) );
		out.println( possibleCombinationOfForgottenDices(Arrays.asList(6,1), 1, 1) );
		
		
		out.println( possibleCombination(3, 3) );
		out.println( possibleCombination(3, 7) );
		out.println( possibleCombination(3, 19) );
		out.println( possibleCombination(3, 2) );
		out.println( possibleCombination(3, 16) );
		
	}
	
	
	public static List<List<Integer>> possibleCombinationOfForgottenDices( List<Integer> knownDiceValues, int numberOfUnknownDices, int mean){
		
		int totalNumberOfDices = knownDiceValues.size() + numberOfUnknownDices;
		//DETAIL: knownDiceValues.stream().reduce(0,  (a, b) -> a + b) means the accumulated value of all elements in this list
		int totalValueOfTheUnknowns = mean * totalNumberOfDices - knownDiceValues.stream().reduce(0,  (a, b) -> a + b);
		
		List<List<Integer>> result = possibleCombination( numberOfUnknownDices, totalValueOfTheUnknowns );
		if( result.size() == 0 ) {
			result.add( new ArrayList<>( Arrays.asList(0) ) );
		}
		
		return result;
	}

	
	
	private static List<List<Integer>> possibleCombination(int numberOfDices, int totalValue) {
		
		List<List<Integer>> allCombinations = new ArrayList<>();
		List<Integer> partialCombination = new ArrayList<>();
		
		possibleCombination( allCombinations, numberOfDices, totalValue, 0, partialCombination);
		
		return allCombinations;
	}



	private static void possibleCombination(
		List<List<Integer>> allCombinations, int diceCounter, int remainingValue, int lastDiceValue, List<Integer> partialCombination) {
		
		/*
		 * if the remaining value is impossible to reach for the rest of dices, quit trying
		 * e.g. 
		 * 2 dices aiming for value 1 or 13, which is impossible
		 * */
		if( remainingValue < diceCounter * MIN_DICE_VALUE || remainingValue > diceCounter * MAX_DICE_VALUE ) {
			return;
		}
		
		
		/* When using up all dices, see if the accumulated dice value equals to our desired goal? if so, add the partialCombination to our answer
		 */
		if( diceCounter == 0 && remainingValue == 0 ) {
			allCombinations.add( new ArrayList<>( partialCombination ) );
			return;
		}
		
		
		for( int diceValue = MIN_DICE_VALUE; diceValue <= MAX_DICE_VALUE; diceValue++ ) {
			
			/*REASONING: we only consider combination. to do so consider diceValue that is larger than last time 
			 e.g. combination [1,2,3]. among all permutation of [1,2,3] would be [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]. we take the increasing one [1,2,3] as our combination
			 */
			if( diceValue >= lastDiceValue ) {
				//we don't know if ultimately the accumulated dice value would equal to desired value. add this current dice value as our new try to the combination anyway  
				partialCombination.add( diceValue );
				//dice thrown. subtract the dice value from desired value, and we still have   diceCounter - 1 times to try the remaining dice throwing
				possibleCombination(allCombinations, diceCounter -1 , remainingValue -diceValue, diceValue, partialCombination);
				//done trying. whether accumulated dice value equal to goal or not, restore to the state as if we didn't add this current dice value as new try
				partialCombination.remove( partialCombination.size() -1 );
			}
			
		}
		
	}

}


