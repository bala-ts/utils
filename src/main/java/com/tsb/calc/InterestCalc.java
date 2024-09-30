package com.tsb.calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tsb.util.DateUtil;
import com.tsb.util.FileUtil;

public class InterestCalc {
	public static int SYSOUT_LEVEL = 0;
	public static int PRECISION = 2;
	List<Integer> termAmt = new ArrayList<Integer>();

	public double calculateCI(float p, float t, double r, int n) {
		// p - Princliple, t - Number of terms, r - raite of interest in %,
		// n = terms (1 -yearly, 3 - quaterly, 12 - Monthly)
		r = r / 100;
		double amount = p * Math.pow(1 + (r / n), n * t);
		if (SYSOUT_LEVEL > 1)
			System.out.println(
					"After " + t + " Years CI : " + Math.round(amount - p) + " Amount:  " + Math.round(amount));

//		if (SYSOUT_LEVEL > 0) System.out.println(Math.round(amount));
		return Math.round(amount);
	}

	public double calculateCI(float p, float t, double r) {
		return calculateCI(p, t, r, 1); // default as yearly
	}

	public double calculateCI(float p, String purchaseDate, double r) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		String endDate = dtf.format(now);
		float t = DateUtil.yearsDiff(purchaseDate, endDate);
		System.out.println("Years : " + t);

		return calculateCI(p, t, r, 1); // default as yearly
	}
	
	public double calculateCI(float p, String purchaseDate, String endDate, double r) {

		float t = DateUtil.yearsDiff(purchaseDate, endDate);
		System.out.println("Years : " + t);

		return calculateCI(p, t, r, 1); // default as yearly
	}

	public double findCI(float p, int finalAmount, float t, int n) {
		double amount = 0, r = 0, prevR = -1;
		int i, iMax = 100;
		double lowR = 0, hightR = 24;
		for (i = 0; i < iMax; i++) {
			prevR = round(r);
			r = round((lowR + hightR) / 2);
			if (r == prevR)
				break;
			amount = calculateCI(p, t, r, n);
			if (amount < finalAmount)
				lowR = r;
			else
				hightR = r;
			if (SYSOUT_LEVEL > 0)
				System.out.println(i + " " + r + " " + amount + " " + round(r * 12));
			if (Math.round(amount) == finalAmount)
				break;
		}
		return round(r);
	}

	public double findProfit(String fileName, int finalAmount) {
		loadFile(fileName);
		double amount, lowR = 0, highR = 24, r = 0, prevR = -1;
		int i = 0, iMax = 100;
		for (i = 0; i < iMax; i++) {
			prevR = round(r);
			if (r == prevR)
				break;
			amount = calculateProfit(r);
			if (amount < finalAmount)
				lowR = r;
			else
				highR = r;
			if (SYSOUT_LEVEL > 0)
				System.out.println(i + " " + r + " " + amount + " " + round(r * 12));
			if (Math.round(amount) == finalAmount)
				break;

		}
		return round(r);
	}

	public double calculateProfit(String fileName, double interestPA) {
		loadFile(fileName);
		return calculateProfit(interestPA);
	}

	public double calculateProfit(double interestPM) {
		double r = interestPM, sum = 0, interest = 0;
		for (int i = 0; i < termAmt.size(); i++) {
			interest = sum * (r / 100);
			sum += termAmt.get(i);
			sum += interest;
			if (SYSOUT_LEVEL > 1)
				System.out.println(i + " " + sum + " " + interest);

		}
		return round(sum);
	}

	public void loadFile(String fileName) {
		List<String> data = FileUtil.getFileContent(fileName);
		String value = "";
		termAmt = new ArrayList<Integer>();
		for (int i = 0; i < data.size(); i++) {
			value = data.get(i).replace(",", "");
			termAmt.add(Integer.parseInt(value));
		}

	}

	public float calculateRD(int terms, double val, float roi) {
		
		float totalAmt=0, interest=0;
		for (int i=0;i<terms;i++) {
			totalAmt += val;
			interest = totalAmt*((roi/100)/12);
			totalAmt += interest;
			//System.out.println(i + " " + interest + " " + totalAmt);
		}
		return totalAmt;
	}

	public static Double round(Double value) {
		return new BigDecimal(value.toString()).setScale(PRECISION, RoundingMode.HALF_UP).doubleValue();
	}

}
