package _0525_._01_nextFriday;
//import static java.lang.System.out;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Fridays {

	private static final SimpleDateFormat SDF_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	private static final int FRIDAY	= Calendar.FRIDAY;
	private static final int DAY_OF_WEEK = Calendar.DAY_OF_WEEK;
	private static final int WEEK_OF_MONTH = Calendar.WEEK_OF_MONTH;
	private static final int YEAR = Calendar.YEAR;
	
	private Calendar cal;
	private Calendar imminentFriday;
	private Calendar nextFriday;
	private Calendar lastFridayInQuarterYear;
	
	public Fridays(String yyyyMMdd) throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		//clear minutes, seconds, and milli-seconds
		cal.clear();
		cal.setTime( SDF_YYYYMMDD.parse(yyyyMMdd) );
		this.cal = cal;
		imminentFriday = getImminentFriday(cal);
		nextFriday = getNextFriday(cal);
		lastFridayInQuarterYear = getLastFridayInQuarterYear(cal);
	}
	
	
	public String getCalStr() {
		return SDF_YYYYMMDD.format(cal.getTime());
	}
	
	
	public String getImminentFridayStr() {
		return SDF_YYYYMMDD.format(imminentFriday.getTime());
	}
	
	
	public String getNextFridayStr() {
		return SDF_YYYYMMDD.format(nextFriday.getTime());
	}
	
	
	public String getLastFridayInQuarterYearStr() {
		return SDF_YYYYMMDD.format(lastFridayInQuarterYear.getTime());
	}
	
	
	private Calendar getImminentFriday(Calendar cal) {
		
		if(imminentFriday != null) {
			return (Calendar)imminentFriday.clone();
		}
		
		Calendar resultCal = (Calendar)cal.clone();
		
		if( resultCal.get(DAY_OF_WEEK) >= FRIDAY) {
			resultCal.add(WEEK_OF_MONTH, 1);
		}
		resultCal.set(DAY_OF_WEEK, FRIDAY);
		
		return resultCal;
	}
	
	
	private Calendar getNextFriday(Calendar cal) {
		
		if( nextFriday != null) {
			return nextFriday;
		}
		
		Calendar resultCal  = getImminentFriday(cal); 
		resultCal.add(WEEK_OF_MONTH, 1);
		return resultCal;
	
	}
	
	
	private Calendar getLastFridayInQuarterYear(Calendar cal) {
		
		if(lastFridayInQuarterYear !=null) {
			return lastFridayInQuarterYear;
		}
		
		Calendar lastFridayOfMar = getLastFriday(cal.get(YEAR), Calendar.MARCH);
		Calendar lastFridayOfJun = getLastFriday(cal.get(YEAR), Calendar.JUNE);
		Calendar lastFridayOfSep = getLastFriday(cal.get(YEAR), Calendar.SEPTEMBER);
		Calendar lastFridayOfDec = getLastFriday(cal.get(YEAR), Calendar.DECEMBER);
		Calendar nextYearlastFridayOfMar = getLastFriday(cal.get(YEAR) + 1, Calendar.MARCH);
		
		if(cal.before(lastFridayOfMar) && nextFriday.before(lastFridayOfMar)) {
			return lastFridayOfMar;
		}
		else if(cal.before(lastFridayOfJun) && nextFriday.before(lastFridayOfJun)) {
			return lastFridayOfJun;
		}
		else if(cal.before(lastFridayOfSep) && nextFriday.before(lastFridayOfSep)) {
			return lastFridayOfSep;
		}
		else if(cal.before(lastFridayOfDec) && nextFriday.before(lastFridayOfDec)){
			return lastFridayOfDec;
		}
		else {
			return nextYearlastFridayOfMar;
		}
	}
	
	
	private Calendar getLastFriday(int year, int field_month) {
		
		Calendar resultCalendar = Calendar.getInstance();
		resultCalendar.clear();
		resultCalendar.set(year, field_month + 1, 1);
		resultCalendar.add(Calendar.DAY_OF_MONTH, -1);
		
		 if( resultCalendar.get(Calendar.DAY_OF_WEEK) < Calendar.FRIDAY ) {
			 resultCalendar.add(Calendar.WEEK_OF_MONTH, -1);
		 }
		 resultCalendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		
		return resultCalendar;
	}
}


