package it.unical.classmanager.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFactory {
	
	public static Calendar getRandomDate(){
		Calendar date = new GregorianCalendar(2011, Calendar.JULY, 3);
	    date.add(Calendar.DAY_OF_MONTH, -7);
	    return date;
	}	
}
