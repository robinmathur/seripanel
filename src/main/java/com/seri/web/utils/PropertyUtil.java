package com.seri.web.utils;

import java.util.ResourceBundle;

public class PropertyUtil {
	
	private static ResourceBundle  bundle =  ResourceBundle.getBundle("type");
	
	public static String getProperty(String Key){
		return  bundle.getString(Key);
	}

}
