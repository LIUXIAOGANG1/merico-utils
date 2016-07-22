package com.meritco.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author liuxiaogang
* @version ����ʱ�䣺2016��6��3�� ����12:26:38
* ��˵��
*/
public class DateUtils {
	private static final String DEFAULTFORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/*
	 * ��yyyy-MM-dd HH:mm:ss ת��Ϊ Date
	 * 
	 * */
	public static Date getDateByString(String time, String format){
		DateFormat fmt = new SimpleDateFormat(format);
		try {
			return fmt.parse(time);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date getDateByString(String time){
		return getDateByString(time, DEFAULTFORMAT);
	}
	
	/*
	 * ��yyyy-MM-dd HH:mm:ss ���Long(������)
	 * 
	 * */
	public static Long getMilliSeconds(String time){
		Date date = getDateByString(time);
		return date.getTime();
	}
	
	/*
	 * ��Long(������) תΪyyyy-MM-dd HH:mm:ss
	 * 
	 * */
	public static String getStringDate(Long seconds, String formate){
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		Date date = new Date(seconds);
		return sdf.format(date);
	}
	
	public static String getStringDate(Long seconds){
		return getStringDate(seconds, DEFAULTFORMAT);
	}
}
