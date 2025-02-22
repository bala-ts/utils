package com.tsb.app.notes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tsb.html.WebpageReader;

public class CurrencyMatcher {
	
	private static String DATES = "resources/dates.txt";
	private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyy");
	private static String DDMM = "resources/currency-ddmm.txt";
	private static String MMDD = "resources/currency-mmdd.txt";
	public static void main(String s[]) {

		CurrencyMatcher cm = new CurrencyMatcher();
//		cm.match();
		//cm.match("080180");
//		cm.sort();
		cm.searchddmm();
//		cm.searchmmdd();
	}
	
	private void searchddmm() {
		WebpageReader wr = new WebpageReader();
		ArrayList<String> dates = loadFileToArrayList(DDMM);
		 for (String date : dates) { 
			 if (date.length() == 6) wr.search(date);
					 
		 }
	}
	
	private void searchmmdd() {
		WebpageReader wr = new WebpageReader();
		ArrayList<String> dates = loadFileToArrayList(MMDD);
		 for (String date : dates) { 
			 if (date.length() == 6) wr.search(convertDate(date));
					 
		 }
	}
	
	private LocalDate getFormatedDate(String s) {
		LocalDate date = null;
		try {
			 date = LocalDate.parse(s, DATE_FORMATTER);
			return date;
		} catch (Exception e ) {
			System.out.print(s+" ");
		}
		return date;
	}

	public void sort() {
		
		List<String> lines = loadFileToArrayList(DATES);
        // Convert the strings to LocalDate objects
        List<LocalDate> dates = new ArrayList<>();
        for (String line : lines) {
        	LocalDate date = getFormatedDate(getDate(line));
        	dates.add(date);
        	System.out.println(date);
        }
        
        
		
	}
	public void match() {
		match(null);
	
	}
	
	public void match(String sno) {
		 List<String> currencyddmm;
		 
		 List<String> currencymmdd;
		if (sno == null) {
			 currencyddmm = loadFileToArrayList(DDMM);
			 currencymmdd = loadFileToArrayList(MMDD);
		} else {
			 currencyddmm = new ArrayList<>(Arrays.asList(sno));
			 currencymmdd = new ArrayList<>(Arrays.asList(sno));
		}
			
		ArrayList<String> dates = loadFileToArrayList(DATES);
        // Print the lines (Optional)
		String date=null;
		System.out.println("ddmmyy");
        for (String line : dates) { 	
        	date = getDate(line);
        	if (currencyddmm.contains(date) )
        		System.out.println(line);   	
        }
        
        System.out.println("\nmmddyy");
        for (String line : dates) { 	
        	date = getDate(line);
        	date = convertDate(date);
        	if (currencymmdd.contains(date)) 
        		System.out.println(line + " : " + date);
        }
	}
	

	private String getDate(String line) {
		line = line.trim();
		line = line.substring(line.length()-6);
		//System.out.println(line);
		return line;
		
	}
	
	private  ArrayList<String> loadFileToArrayList(String filePath) {
	    ArrayList<String> list = new ArrayList<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            list.add(line);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	public static String convertDate(String date) {
		if (date.length() == 6 )
			return date.substring(2, 4) + date.substring(0, 2)+ date.substring(4, 6); 
		else	
			return "";
    }

}

//
//private  void process() {
//	ArrayList<String> temp = loadFileToArrayList("resources/temp.txt");
//
//	String  o;
//	 for (String t : temp) { 
//		 t = t.trim();
//		 o = t;
//		 if (t .contains("/")) {
//			 t = t.replace("/","");
//			
//			t = convertDate(t);
//		 } else {
//			 t = t.replace("-", "").replace(".", "");
//			 if (t.length() == 10)
//					 t = t.substring(0, 5) + t.substring(8);
//		 }
//		 
//		 
//		 
//		 System.out.println( " - " +  t);
//	 }
//}
