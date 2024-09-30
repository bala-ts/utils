package com.tsb.app.notes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrencyMatcher {
	
	public static void main(String s[]) {

		CurrencyMatcher cm = new CurrencyMatcher();
		cm.match();
		//cm.match("080180");
	}

	public void match() {
		match(null);
	
	}
	
	public void match(String sno) {
		 List<String> currencyddmm;
		 
		 List<String> currencymmdd;
		if (sno == null) {
			 currencyddmm = loadFileToArrayList("resources/currency-ddmm.txt");
			 currencymmdd = loadFileToArrayList("resources/currency-mmdd.txt");
		} else {
			 currencyddmm = new ArrayList<>(Arrays.asList(sno));
			 currencymmdd = new ArrayList<>(Arrays.asList(sno));
		}
			
		ArrayList<String> dates = loadFileToArrayList("resources/dates.txt");
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
