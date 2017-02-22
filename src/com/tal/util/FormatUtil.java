package com.tal.util;

import java.text.DecimalFormat;

public class FormatUtil {
	
	public static String formatAmount(Double amount){
		DecimalFormat df=new DecimalFormat("0.00");
		return df.format(amount);
	}

}
