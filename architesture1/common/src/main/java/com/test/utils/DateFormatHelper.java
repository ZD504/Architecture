package com.test.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.support.StaticApplicationContext;

public class DateFormatHelper {
	private DateFormatHelper() {}
	private final static String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
	
	//long transfer to string 
	public static String  long2str(long time) {
		Date date = new Date(time);
		
		DateFormat df = new SimpleDateFormat(FORMAT_STR);
		return df.format(date);
	}
	
//	//String convert to long time format
//	public  static long str2long(String str) {
//		
//	}
}
