package it.unical.classmanager.utils;

import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author Aloisius92
 * This is a utility class for get some temporal values.
 */
public class DateTimeFactory {
	private static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static int startYear = 1970;
	private static Random random = new Random();
		
	public static Calendar getRandomDate(){
		int month = random.nextInt(12);
		int day = random.nextInt(daysInMonth[month]);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int year = startYear + random.nextInt(currentYear-startYear);
		return new GregorianCalendar(year, month, day);
	}	
	
	public static Calendar getRandomDate(int year){
		int month = random.nextInt(12);
		int day = random.nextInt(daysInMonth[month]);
		
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		System.out.println("Created Date: "+date.getTime());
		
		return date;
	}	
	
	public static Calendar getRandomDateLessThanYear(int year){
		int month = random.nextInt(12);
		int day = random.nextInt(daysInMonth[month]);
		int randomYear = startYear + random.nextInt(year-startYear);
		return new GregorianCalendar(randomYear, month, day);
	}	
	
	public static Calendar getRandomDate(int year, int month){
		month = month >= 12 ? 11 : month;
		month = month < 0 ? 0 : month;		
		int day = random.nextInt(daysInMonth[month]);
		return new GregorianCalendar(year, month, day);
	}
	
	public static Calendar getDate(int year, int month, int day){
		return new GregorianCalendar(year, month, day);
	}
	
	public static Calendar getRandomDateBetweenMonths(int beginMonth, int endMonth){	
		int month;
		if(beginMonth>endMonth){	
			int diff = daysInMonth.length-beginMonth;
			beginMonth = (beginMonth+diff)%daysInMonth.length;
			endMonth = (endMonth+diff)%daysInMonth.length;
			
			month = random.nextInt(endMonth);
			month = (month-diff)%daysInMonth.length;
			month = month < 0 ? daysInMonth.length+month : month;
		} else {
			month = beginMonth + random.nextInt(endMonth-beginMonth);		
		}
		int day = random.nextInt(daysInMonth[month]);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int year = startYear + random.nextInt(currentYear-startYear);
		return new GregorianCalendar(year, month, day);
	}
	
	public static Calendar getRandomDateBetweenMonths(int year, int beginMonth, int endMonth){
		int month;
		if(beginMonth>endMonth){	
			int diff = daysInMonth.length-beginMonth;
			beginMonth = (beginMonth+diff)%daysInMonth.length;
			endMonth = (endMonth+diff)%daysInMonth.length;
			
			month = random.nextInt(endMonth);
			month = (month-diff)%daysInMonth.length;
			month = month < 0 ? daysInMonth.length+month : month;
		} else {
			month = beginMonth + random.nextInt(endMonth-beginMonth);		
		}
		month = beginMonth + random.nextInt(endMonth-beginMonth);
		int day = random.nextInt(daysInMonth[month]);
		
		GregorianCalendar date = new GregorianCalendar(year, month, day);
		System.out.println("Created Date: "+date.getTime());	
		
		return date;
	}
	
	public static int getRandomYear(){
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int randomYear = startYear + random.nextInt(currentYear-startYear);
		System.out.println("Random Year: "+randomYear);
		return startYear + random.nextInt(currentYear-startYear);
	}
	
	public static int getRandomYearBetween(int beginYear, int endYear){
		int diff = Math.abs(endYear - beginYear);
		int randomYear = beginYear + random.nextInt(diff);
		System.out.println("Random Year Between ("+beginYear+","+endYear+"): "+randomYear);			
		return randomYear;
	}
	
	@SuppressWarnings("deprecation")
	public static Time getRandomTime(){
		return new Time(random.nextInt(24), random.nextInt(60), random.nextInt(60));
	}
	
	public static Time getRandomTimeBetween(Time beginTime, Time endTime){
		long diff = endTime.getTime()-beginTime.getTime();
		return new Time(diff);
	}
}
