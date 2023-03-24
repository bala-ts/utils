package com.tsb.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {

	

	public static float yearsDiff(String startDate, String endDate)   
    {   

		LocalDate sdate = LocalDate.parse(startDate);
		LocalDate pdate = LocalDate.parse(endDate);

		LocalDate ssdate = LocalDate.of(sdate.getYear(), sdate.getMonth(), sdate.getDayOfMonth());
		LocalDate ppdate = LocalDate.of(pdate.getYear(), pdate.getMonth(), pdate.getDayOfMonth());

		Period period = Period.between(ssdate, ppdate);
		System.out.println("Difference: " + period.getYears() + " years " 
		                                  + period.getMonths() + " months "
		                                  + period.getDays() + " days ");
		float f = (period.getMonths()*30 + period.getDays());
		f/=365;
		return period.getYears() + f;
    }
	
}
