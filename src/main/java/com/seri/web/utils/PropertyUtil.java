package com.seri.web.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class PropertyUtil {
	
	private static ResourceBundle  bundle =  ResourceBundle.getBundle("type");
	
	public static String getProperty(String Key){
		String value="";
		try{
			value = bundle.getString(Key);
		}catch(MissingResourceException e){
		}
		return value;
	}

}
