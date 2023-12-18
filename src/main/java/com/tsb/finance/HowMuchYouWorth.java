package com.tsb.finance;

import java.text.DecimalFormat;

public class HowMuchYouWorth {

	public static void main(String s[]) {
		printworth(36.45);
	}

	public static void printworth(double ctc) {
		int noOfDays = 365;
		ctc = ctc * 100000;
		int leaves = 12 + 22;
		int holidays = 10;
		int weekends = 52 * 2;
		float workHours = 9;
		int workingDays = noOfDays - leaves - holidays - weekends;
		double workingHours = workingDays * workHours;
		double perDay = ctc / workingDays;
		double perHour = perDay / workHours;
		double perMin = perHour / 60;
		double perSec = perMin / 60;
		// • weekends;
		System.out.println("Working Days " + workingDays + 
				"\nWorking Hours " + workingHours  + 
				"\nPer Day : Rs." + toAmount(perDay) + 
				"\nPer Hour Rs. " + toAmount(perHour) + 
				"\nPer Min: Rs. " + toAmount(perMin) + 
				"\nPer Sec: Rs." + toAmount(perSec) + 
				"\n1 Rs per "	+ toAmount(60 / perMin) + "second (s)");
	}

	private static String toAmount(double value) {
		DecimalFormat df = new DecimalFormat("####0.00");
		return df.format(value);
	}
	
}
