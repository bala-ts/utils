package com.tsb.calc;

import com.tsb.util.NumUtil;

public class InterestCalcRun {
	static final int  TERMS = 5;
	static final float PO = 6.7f;
	static final float ROI = PO;
	
	
	static final Integer L = 100000;
	static InterestCalc ic = new InterestCalc();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterestCalc.SYSOUT_LEVEL = 0;
		
		
		//PostOffic
	//	System.out.println(ic.calculateCI(12*L, 15, ROI));
		
	
		//Calculate profift after sold
		System.out.println(ic.findCI(19.5f * L, 33 * L, 9.5f, 1));
		
	
		 //formatAmount(ic.calculateCI(12*L, 12, ROI));
		
		//Ground Padapai1 , 9/2022 30L
		NumUtil.formatAmount(ic.calculateCI(15.5f * L, "2012-09-11", ROI));
	
		
		//Ground Padapai2, 9/2022 35.64L
		//NumUtil.formatAmount(ic.calculateCI(19.5f*L, "2013-06-09", ROI));
		
		//rent(115);
		
		//ic.calculateRD();
	
	}
	
	//5776421 - 
	

	
	static void rent(float amountInL) {
		float v = amountInL * L;
		float ipm = Math.round(( ic.calculateCI(v, TERMS, ROI) - v ) / TERMS /12);
		System.out.println("For " + amountInL + "L " + ipm + " Interest PM") ;
	}

}
