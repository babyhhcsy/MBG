package com.thero.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
@SuppressWarnings("all")
public class DateUtility {

	public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
	public static final String yyyyMMddHHmmss1 = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMddHHmmss2 = "yyyyMMddHHmmss";

	/**
	 * 判断 传入的时间 是不是大于当前时间 大于返回TRUE 小于返回FALSE
	 * 
	 * @param myDate 日期
	 * @return Boolean
	 */
	public static Boolean isThanNowTime(Date myDate) {
		if(StringTool.isBlank(myDate)){
			return true;
		}
		long bbl = myDate.getTime() - new Date().getTime();
		if (bbl > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 大于number小时限制时间 返回TRUE 小于返回FALSE
	 * 
	 * @param firsttime
	 * @param endtime
	 * @return
	 * @throws GenericBusinessException
	 * @throws Exception
	 */
	public static boolean isThanLowTime(Date firsttime, Date currtime, String number) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(firsttime);
		c1.add(Calendar.HOUR_OF_DAY, Integer.parseInt(number));
		c2.setTime(currtime);
		// System.out.println(DateUtility.formatDateToString(c1.getTime(),"yyyyMMddHHmmss")+"=before--now="+DateUtility.formatDateToString(c2.getTime(),"yyyyMMddHHmmss"));
		int result = c1.compareTo(c2);
		if (result < 0) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * 大于number分钟限制时间 返回TRUE 小于返回FALSE
	 * 
	 * @param firsttime
	 * @param endtime
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static boolean isThanLowTimeByMinute(Date firsttime, Date currtime, String Minute) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(firsttime);
		c1.add(Calendar.MINUTE, Integer.parseInt(Minute));
		c2.setTime(currtime);
		// System.out.println(DateUtility.formatDateToString(c1.getTime(),"yyyyMMddHHmmss")+"=before--now="+DateUtility.formatDateToString(c2.getTime(),"yyyyMMddHHmmss"));
		int result = c1.compareTo(c2);
		if (result < 0) {
			return true;
		} else {
			return false;
		}

	}
	/**
	 * 得到两个日期的分钟之差
	 * 
	 * @param firstDate 开始日期
	 * @param lastDate 结束日期
	 * @return 分钟之差
	 */
	public static Long getMinutes(Date firstDate, Date lastDate) {

		return (lastDate.getTime() - firstDate.getTime()) % (1000 * 60);
	}

	/**
	 * 得到两个日期的小时之差
	 * 
	 * @param firstDate 开始日期
	 * @param lastDate 结束日期
	 * @return 小时之差
	 */
	public static Long getHours(Date firstDate, Date lastDate) {

		return (lastDate.getTime() - firstDate.getTime()) % (1000 * 60 * 60);
	}

	/**
	 * 得到两个日期的天数之差
	 * 
	 * @param firstDate 开始日期
	 * @param lastDate 结束日期
	 * @return 天数之差
	 */
	public static Long getDays(Date firstDate, Date lastDate) {

		return (lastDate.getTime() - firstDate.getTime()) % (1000 * 60 * 60 * 24);
	}

	/**
	 * 返回当前日期,类型为格式"yyyy-mm-dd"的字符串
	 * 
	 * @return
	 */
	public static String getDate() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}
	
	/**
	 * 返回当前日期,类型为格式"yyyy-mm-dd"的字符串
	 * 
	 * @return
	 */
	public static String getDateInfo() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date +" 00:00:00 000";
	}

	/**
	 * 返回当前日期第二天,类型为格式"yyyy-mm-dd"的字符串
	 * 
	 * @return
	 */
	public static String getTomorrowDate() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyy-MM-dd");
		java.util.Date nowdate = new java.util.Date();
		DateUtility date = new DateUtility();
		nowdate = date.addMinute(1440);
		String str_date = d.format(nowdate);
		return str_date;
	}

	/**
	 * 返回当前日期第二天,类型为格式"yyyy-mm-dd"的字符串
	 * 
	 * @return
	 */
	public static String getLastMonth() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyyMM");
		java.util.Date nowdate = new java.util.Date();
		DateUtility date = new DateUtility();
		nowdate = date.addDate(-30);
		String str_date = d.format(nowdate);
		return str_date;
	}

	/**
	 * 返回类型为格式"yyyyMMddHHmmss"的字符串
	 * 
	 * @return
	 */
	public static String getNowTimeYMDHMS() {
		java.text.SimpleDateFormat d = new java.text.SimpleDateFormat();
		d.applyPattern("yyyyMMddHHmmss");
		java.util.Date nowdate = new java.util.Date();
		String str_date = d.format(nowdate);
		return str_date;
	}

	/**
	 * 根据自定义格式格式化字符串为yyyyMMddHHmmss Date
	 * 
	 * @param dateString
	 * @param datePattern
	 * @return
	 * @throws GenericBusinessException
	 */
	public static Date getStrToDateYMDHMS(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			return format.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回当前日期字符串 精确到秒
	 * 
	 * @return
	 */
	public static String getNow_Time() {
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now_time = simpledateformat.format(date);
		return now_time;
	}

	/**
	 * 返回当前日期字符串 精确到分钟
	 * 
	 * @return
	 */
	public static String getNow_Minute() {
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String now_time = simpledateformat.format(date);
		return now_time;
	}

	/**
	 * 根据自定义格式返回时间字符串
	 * 
	 * @param date
	 * @param datePattern
	 * @return
	 */
	public static String formatDateToString(Date date, String datePattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(datePattern);
			return format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据自定义格式格式化字符串为Date
	 * 
	 * @param dateString
	 * @param datePattern
	 * @return
	 */
	public static Date formatStringToDate(String dateString, String datePattern) {
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		try {
			return format.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 相对当前时间，增加多少分钟
	 * 
	 * @param num
	 * @return
	 */
	public static Date addMinute(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, num);

		return calendar.getTime();
	}
	
	/**
	 * 相对当前时间，增加多少年
	 * 
	 * @param num
	 * @return
	 */
	public static Date addYear(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, num);

		return calendar.getTime();
	}

	/**
	 * 相对当前时间，增加多少天
	 * 
	 * @param num
	 * @return
	 */
	public static Date addDate(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num);

		return calendar.getTime();
	}
	/**
	 * 相对当前时间，增加或减少多少天 负数为减少
	 * 
	 * @param num
	 * @return
	 */
	public static Date addHOUR(int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, num);
		return calendar.getTime();
	}

	/**
	 * 根据自定义格式格式化字符串为Date
	 * 
	 * @param dateString
	 * @param datePattern
	 * @return
	 */
	public static String formatStringDate(String dateString) throws Exception {
		dateString = dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6, 8);
		try {

			if (valid(dateString)) {
				return dateString;
			} else {
				throw new Exception("请输入正确的日期格式");
			}

		} catch (Exception e) {

			throw new Exception("请输入正确的日期格式.");
		}
	}

	/**
	 * 
	 * 方法描述：获取当前日期包含小时、分钟、秒的时间字符串 "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getNowFullFormateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean valid(String str) {
		try {
			Date date = (Date) formatter.parse(str);
			return str.equals(formatter.format(date));
		} catch (Exception e) {
			try {
				Date date1 = (Date) formatter1.parse(str);
				return str.equals(formatter1.format(date1));
			} catch (Exception e2) {
				return false;
			}
		}
	}

	public static String splitTime(String time) {
		String str = "";
		if (time != null && time.length() == 4) {
			str = time.substring(0, 2) + ":" + time.substring(2, 4);
		}
		return str;
	}
	public static void main(String[] args) {
		// System.out.println(getNowMs());
		/*
		 * String s="username#ERRORNUM#FIRSTERRORTIME#LASTTIME#IP"; List<String>
		 * list=Arrays.asList(s.split("#")); for(String ss:list) {
		 * System.out.println(ss); }
		 */

		// isThanLowTime(new Date(),new Date(),3);
		/*try {
			// System.out.println(getStrToDateYMDHMS("2012-01-05 11:28:50"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(format.format(new Date()));
			// System.out.println(getStrToDateYMDHMS(format.format(new
			// Date())));
			String date1 = "2010-07-28 09:12:09";
			String date2 = "2010-07-28 09:12:09";
			// System.out.println(getStrToDateYMDHMS(date1)+"===date1");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();

			try {
				c1.setTime(df.parse(date1));
				c1.add(Calendar.HOUR_OF_DAY, 5);
				c2.setTime(df.parse(date2));
				System.out.println(format.format(c1.getTime()));

			} catch (Exception e) {
				System.err.println("日期格式不一致！");
			}
			int result = c1.compareTo(c2);
			if (result == 0)
				System.out.println("c1相等c2");
			else if (result < 0)
				System.out.println("c1小于c2");
			else
				System.out.println("c1大于c2");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println(getDateInfo());
	}

}
