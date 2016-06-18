package com.seri.web.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	
	
	public static Date addDays(int days){
		Calendar calender = Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, days);
		return calender.getTime();
	}
	

}
