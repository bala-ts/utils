package com.tsb.app.notes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CurrencyMatcher {
	
	public static void main(String s[]) {

		CurrencyMatcher cm = new CurrencyMatcher();
		cm.run();
	}

	public void run() {
	
		ArrayList<String> currencyddmm = loadFileToArrayList("resources/currency-ddmm.txt");
		ArrayList<String> currencymmdd = loadFileToArrayList("resources/currency-mmdd.txt");
		ArrayList<String> dates = loadFileToArrayList("resources/dates.txt");
        // Print the lines (Optional)
		String date=null;
		System.out.println("ddmmyy");
        for (String line : dates) { 	
        	date = getDate(line);
        	if (currencyddmm.contains(date) )
        		System.out.println(line);   	
        }
        
        System.out.println("mmddyy");
        for (String line : dates) { 	
        	date = getDate(line);
        	date = convertDate(date);
        	if (currencymmdd.contains(date)) 
        		System.out.println(line);
        }
	}
	

	private String getDate(String line) {
		String s[] = line.split(" - ");
		return (s.length == 2) ? s[1] : "";
		
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



//ArrayList<String> temp = loadFileToArrayList("resources/temp.txt");
//String s;
// for (String t : temp) { 
//	 //s = t.replace("/", "").replace(".", "").replace("-", "");
//	
//	 System.out.println( t.substring(0, 7));
// }
//