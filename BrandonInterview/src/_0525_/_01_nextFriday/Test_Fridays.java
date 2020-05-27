package _0525_._01_nextFriday;
import static java.lang.System.out;

import java.text.ParseException;
public class Test_Fridays {

	public static void main(String[] args) throws ParseException {
		
		String[] dateStrings = {"20191218", "20191201", "20200618", "20200120"};
		Fridays fridays;
		
		for(String dateString: dateStrings) {
			fridays = new Fridays(dateString);
			out.println("Today= " + fridays.getCalStr());
			out.println("Weekly contract= " + fridays.getImminentFridayStr());
			out.println("Bi-Weekly contract= " + fridays.getNextFridayStr());
			out.println("Quarterly contract= " + fridays.getLastFridayInQuarterYearStr());
			out.println();
			
		}
		
	}

}


