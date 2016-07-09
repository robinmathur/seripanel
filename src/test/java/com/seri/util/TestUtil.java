package com.seri.util;

import org.junit.Test;

import com.seri.web.utils.PropertyUtil;

public class TestUtil {
	
	@Test
	public void testProp(){
		String value = PropertyUtil.getProperty("HOME_WORK");
		System.out.println(value);
	}

}
