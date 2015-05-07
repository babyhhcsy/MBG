package com.thero.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;




public class DateHelper {
	private static DateHelper instance = new DateHelper();

	public static DateHelper getInstance() {
		return instance;
	}

	/**
	 * 日期标值枚举
	 * 
	 * @author SuZhongQing
	 */
	public enum DateRangeFlag {
		THIS_DAY, THIS_WEEK, THIS_MONTH
	}

	/**
	 * 根据指定格式的日期字符串获得日期
	 * 
	 * @param dateStr 日期字符串 格式如：(yyyy-MM-dd)
	 * @return 日期
	 */
	public static Date getDateByString(String dateStr) {
		String[] elements = dateStr.split("-");
		if (elements.length != 3) {
			return new Date();
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(elements[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(elements[1]) - 1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(elements[2]));

		return cal.getTime();
	}

	/**
	 * 根据日期，返回指定格式的日期字符串"yyyy-MM-dd"
	 * 
	 * @param date
	 * @return 指定格式的日期字符串
	 */
	public static String getFormatString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return date == null ? "" : sdf.format(date);
	}
	public static String getFormatStringyyyyMMdd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return date == null ? "" : sdf.format(date);
	}
	public static String getFormatStringyyyyMMddHHmmss(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return date == null ? "" : sdf.format(date);
	}
	public static String getFormatStringHHmmss(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return date == null ? "" : sdf.format(date);
	}

	public static Date getFormatDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(d);
			return date;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 方法名：getFullFormateString 方法描述：获取包含小时、分钟、秒的时间字符串 "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getFullFormateString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date == null ? "" : sdf.format(date);
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
	 * 根据指定的日期范围标值，返回指定的开始日期和结束日期
	 * 
	 * @param date 日期
	 * @param flag 日期范围标值
	 * @return 日期数组，第一个元素为开始日期，第二个元素为结束日期
	 */
	public static Date[] getDatesByFlag(Date date, DateRangeFlag flag) {
		Date[] dates = new Date[2];
		Calendar beginCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		beginCal.setTime(date);
		endCal.setTime(date);

		switch (flag) {
			case THIS_DAY :
				beginCal.set(Calendar.DAY_OF_MONTH, beginCal.get(Calendar.DAY_OF_MONTH) - 1);
				beginCal.set(Calendar.HOUR_OF_DAY, 0);
				beginCal.set(Calendar.MINUTE, 0);
				beginCal.set(Calendar.SECOND, 0);

				endCal.set(Calendar.DAY_OF_MONTH, endCal.get(Calendar.DAY_OF_MONTH) - 1);
				endCal.set(Calendar.HOUR_OF_DAY, 23);
				endCal.set(Calendar.MINUTE, 59);
				endCal.set(Calendar.SECOND, 59);
				dates[0] = beginCal.getTime();
				dates[1] = endCal.getTime();
				break;

			case THIS_WEEK :
				beginCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				beginCal.set(beginCal.get(Calendar.YEAR), beginCal.get(Calendar.MONTH), beginCal.get(Calendar.DAY_OF_MONTH) - 7);
				beginCal.set(Calendar.HOUR_OF_DAY, 0);
				beginCal.set(Calendar.MINUTE, 0);
				beginCal.set(Calendar.SECOND, 0);

				endCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				endCal.set(endCal.get(Calendar.YEAR), endCal.get(Calendar.MONTH), endCal.get(Calendar.DAY_OF_MONTH) - 1);
				endCal.set(Calendar.HOUR_OF_DAY, 23);
				endCal.set(Calendar.MINUTE, 59);
				endCal.set(Calendar.SECOND, 59);

				dates[0] = beginCal.getTime();
				dates[1] = endCal.getTime();
				break;

			case THIS_MONTH :
				beginCal.set(Calendar.MONTH, beginCal.get(Calendar.MONTH) - 1);
				beginCal.set(beginCal.get(Calendar.YEAR), beginCal.get(Calendar.MONTH), 1);
				beginCal.set(Calendar.HOUR_OF_DAY, 0);
				beginCal.set(Calendar.MINUTE, 0);
				beginCal.set(Calendar.SECOND, 0);

				endCal.set(Calendar.MONTH, endCal.get(Calendar.MONTH));
				endCal.set(Calendar.DAY_OF_MONTH, -1);
				endCal.set(Calendar.HOUR_OF_DAY, 23);
				endCal.set(Calendar.MINUTE, 59);
				endCal.set(Calendar.SECOND, 59);

				dates[0] = beginCal.getTime();
				dates[1] = endCal.getTime();
				break;
		}
		return dates;
	}

	public static DateRangeFlag getDateRangeEnum(int dateFlag) {
		switch (dateFlag) {
			case 2 :
				return DateRangeFlag.THIS_WEEK;
			case 3 :
				return DateRangeFlag.THIS_MONTH;

			default :
				return DateRangeFlag.THIS_DAY;
		}
	}

	public static Date getBeginDate(Date beginDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getEndDate(Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);

		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 返回当前时间在当年是第几周
	 **/
	public static int getWeekOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_YEAR) - 1;
	}

	/**
	 * @param flag true:返回上周第一天， false：返回上周最后一天 返回上周的开始日期或结束日期
	 **/
	public static String getFirstDateOfPreWeek(boolean flag) {
		Calendar cal = Calendar.getInstance();
		// 获取当前时间
		long today = cal.getTimeInMillis();
		// 设定周一是每周的第一天
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 得到当天处在当周的第几天，周一是当周的第一天
		int dayNum = cal.get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println(dayNum);

		if (dayNum == 0) {
			if (flag) {
				cal.setTimeInMillis(today - (13 - dayNum) * 24 * 60 * 60 * 1000);
			} else {
				cal.setTimeInMillis(today - (7 - dayNum) * 24 * 60 * 60 * 1000);
			}
		} else if (dayNum >= 1 && dayNum < 7) {
			if (flag) {
				cal.setTimeInMillis(today - (dayNum - 1 + 7) * 24 * 60 * 60 * 1000);
			} else {
				cal.setTimeInMillis(today + (7 - dayNum - 7) * 24 * 60 * 60 * 1000);
			}
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * @param flag true:返回上两周第一天， false：返回上两周最后一天 返回上两周的开始日期或结束日期
	 **/
	public static String getFirstDateOfPre2Week(boolean flag) {
		Calendar cal = Calendar.getInstance();
		// 获取当前时间
		long today = cal.getTimeInMillis();
		// 设定周一是每周的第一天
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 得到当天处在当周的第几天，周一是当周的第一天
		int dayNum = cal.get(Calendar.DAY_OF_WEEK) - 1;
		// System.out.println(dayNum);

		if (dayNum == 0) {
			if (flag) {
				cal.setTimeInMillis(today - (20 - dayNum) * 24 * 60 * 60 * 1000);
			} else {
				cal.setTimeInMillis(today - (14 - dayNum) * 24 * 60 * 60 * 1000);
			}
		} else if (dayNum >= 1 && dayNum < 7) {
			if (flag) {
				cal.setTimeInMillis(today - (dayNum - 1 + 14) * 24 * 60 * 60 * 1000);
			} else {
				cal.setTimeInMillis(today + (7 - dayNum - 14) * 24 * 60 * 60 * 1000);
			}
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 返回当前时间的年份
	 **/
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 判断某个年份是否为闰年
	 * 
	 * @return true是闰年，false不是闰年
	 **/
	public static boolean isLeapYear(int yearparam) {
		boolean flag = false;
		if (yearparam % 4 != 0) {
			flag = false;
		} else if (yearparam % 100 != 0) {
			flag = true;
		} else if (yearparam % 400 != 0) {
			flag = false;
		} else {
			flag = true;
		}

		// if(flag == true){
		// System.out.println("是闰年");
		// }else{
		// System.out.println("不是闰年");
		// }

		return flag;
	}

	public static boolean isLeapYear2(int yearparam) {
		Calendar calendar = Calendar.getInstance();
		boolean flag = ((GregorianCalendar) calendar).isLeapYear(yearparam);

		// if(flag == true){
		// System.out.println("是闰年");
		// }else{
		// System.out.println("不是闰年");
		// }

		return flag;
	}

	/**
	 * 返回当前年上月份最大天数
	 **/
	public static int getMaxDayOfPreMonth() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		cal.add(Calendar.DAY_OF_MONTH, -1);
		// 输出上月最后一天日期
		// System.out.println("上月最大天数：" + cal.get(Calendar.DAY_OF_MONTH));
		int maxDate = cal.get(Calendar.DAY_OF_MONTH);
		return maxDate;
	}

	/**
	 * 返回某年某月最大天数
	 **/
	public static int getMaxDayOfMonth(int yearparam, int monthparam) {
		int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 平年每月天数
		if (isLeapYear2(yearparam)) { // 判断是否为闰年
			if (monthparam == 2) {
				return 29;
			}
		}

		return daysInMonth[monthparam - 1];
	}

	/**
	 * 返回当前时间的月份
	 **/
	public static int getMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.MONTH);
	}

	/**
	 * 返回当前年当前月份最大天数
	 **/
	public static int getMaxDayOfCurMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1); // 把日期设置为当月第一天
		cal.roll(Calendar.DATE, -1); // 日期回滚一天，也就是最后一天
		int maxDate = cal.get(Calendar.DATE);
		// System.out.println("当月最大天数:" + maxDate);
		return maxDate;
	}

	/**
	 * 返回当前时间是每周的第几天
	 */
	public static int getDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int weekDay = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (weekDay == 0) {
			weekDay = 1;
		}
		return weekDay;
	}
	/**
	 * 返回当前时间是该月份第几天
	 **/
	public static int getDayOfCurMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int day = cal.get(Calendar.DATE);
		return day;
	}
	/**
	 * 
	 * 获取日销售结束时间
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getDayEndTime() {

		return DateHelper.getFullFormateString() + " 23:59:59";
	}

	/**
	 * 
	 * 获取日销售结束时间
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getDayEndTimeMs() {

		return DateHelper.getFullFormateString() + " 23:59:59:999";
	}
	/**
	 * 
	 * 方法描述：获取当前日期包含小时、分钟、秒的时间字符串 "yyyy-MM-dd HH:mm:ss"
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getFullFormateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	/**
	 * 取得月天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 取得月第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 取得月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}
	/**
	 * 取得上个月最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDateOfBeforeMonth(Date date) {
		Calendar c = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		c.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		c.add(Calendar.DAY_OF_MONTH, -1);
		// c.set(Calendar.DAY_OF_MONTH,
		// c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 得到上个月的第一和最后一天带时间
	 * 
	 * @return MAP{prevMonthFD:当前日期上个月的第一天带时间}{prevMonthPD:当前日期上个月的最后一天带时间}
	 */
	private static Map<String, String> findLastMonth() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -1);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00:000");
		day_first_prevM = str.toString();

		calendar.add(cal.MONTH, 1);
		calendar.set(cal.DATE, 1);
		calendar.add(cal.DATE, -1);
		String day_end_prevM = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59:999");
		day_end_prevM = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("prevMonthFD", day_first_prevM);
		map.put("prevMonthPD", day_end_prevM);
		return map;
	}

	/**
	 * 得到上上个月的第一和最后一天带时间
	 * 
	 * @return MAP{prevMonthFD:当前日期上个月的第一天带时间}{prevMonthPD:当前日期上个月的最后一天带时间}
	 */
	private static Map<String, String> findDateBefor2() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.add(Calendar.MONTH, -2);
		Date theDate = calendar.getTime();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first_prevM = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first_prevM).append(" 00:00:00:000");
		day_first_prevM = str.toString();

		calendar.add(cal.MONTH, 1);
		calendar.set(cal.DATE, 1);
		calendar.add(cal.DATE, -1);
		String day_end_prevM = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(" 23:59:59:999");
		day_end_prevM = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("prevMonthFD", day_first_prevM);
		map.put("prevMonthPD", day_end_prevM);
		return map;
	}
	/**
	 * 
	 * 获取日销售开始时间
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getDayBeginTime() {

		return DateHelper.getFullFormateString() + " 00:00:00:000";
	}
	/**
	 * 
	 * 获取日销售开始时间
	 * 
	 * @param date 日期
	 * @return 指定格式的日期字符串
	 */
	public static String getDayBeginTimeMs() {

		return DateHelper.getFullFormateString() + " 00:00:00:000";
	}

	// 用来全局控制 上一周，本周，下一周的周数变化
	private int weeks = 0;
	// 获得本周一的日期
	public String getMondayOFWeek() {
		weeks = 0;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();

		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得相应周的周六的日期
	public String getSaturday() {
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}
	// 获得当前日期与本周日相差的天数
	private int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}
	// 获得上周星期日的日期
	public String getPreviousWeekSunday() {
		weeks = 0;
		weeks--;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得上周星期一的日期
	public String getPreviousWeekday() {
		weeks--;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 * weeks);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得下周星期一的日期
	public String getNextMonday() {
		weeks++;
		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	// 获得下周星期日的日期
	public String getNextSunday() {

		int mondayPlus = this.getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	/**
	 * 本周开始时间
	 * 
	 * @return
	 */
	public static String getThisWeekMondayTime() {

		DateHelper help = new DateHelper();
		String cuurwektimebegin = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			cuurwektimebegin = format.format(DateUtility.formatStringToDate(help.getMondayOFWeek(), "yyyy-MM-dd")) + " 00:00:00:000";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// String cuurwektimeend=help.getDayEndTimeMs();
		// yyyy-MM-dd HH:mm:ss
		// Date begintimedatecurr =
		// DateUtility.formatStringToDate(cuurwektimebegin,"yyyy-MM-dd HH:mm:ss:SSS");
		// Date
		// endtimedatecurr=DateUtility.formatStringToDate(cuurwektimeend,"yyyy-MM-dd HH:mm:ss:SSS");
		return cuurwektimebegin;

	}
	/**
	 * 本周当前结束时间
	 * 
	 * @return
	 */
	public static String getThisNowWeekFullTime() {

		String cuurwektimeend = DateHelper.getDayEndTimeMs();
		// yyyy-MM-dd HH:mm:ss
		// Date begintimedatecurr =
		// DateUtility.formatStringToDate(cuurwektimebegin,"yyyy-MM-dd HH:mm:ss:SSS");
		// Date
		// endtimedatecurr=DateUtility.formatStringToDate(cuurwektimeend,"yyyy-MM-dd HH:mm:ss:SSS");
		return cuurwektimeend;

	}

	/**
	 * 获取今天的前后几天日期格式
	 * 
	 * @param t 把日期往后增加一天.整数往后推,负数往前移动 例如 他为0 是当天 ，t为1是明天，t为-1是昨天，t为-2是前天
	 * @return
	 */
	public static String getDateAround(int t) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, t);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 日期向前后移动几个月
	* @Title: monthMove
	* @Description: TODO   
	* @return String    
	* @throws
	 */
	public static String monthMove(int len){
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		try {
		Calendar cal = Calendar.getInstance();
		   cal.setTime(new Date());
		   cal.add(Calendar.MONTH, len);
		   return sdf.format(cal.getTime())+" 59:59:59:999";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	} 
	
	public static void main(String[] args) {
		System.out.println(monthMove(-3));
	}
}
