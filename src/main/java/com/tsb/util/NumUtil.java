package com.tsb.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumUtil {
	
	public static void formatAmount(double d) { 
		Locale locale = new Locale("en","IN");
	    DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
	    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
	    dfs.setCurrencySymbol("\u20B9");
	    decimalFormat.setDecimalFormatSymbols(dfs);
	    System.out.println(decimalFormat.format(d));
	}
	
	
}
