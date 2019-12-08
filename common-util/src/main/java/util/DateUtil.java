package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

	// 根据日期算年龄
	public static int getAge(String birthday) {
		String[] d = birthday.trim().split("-");
		int birthYear = Integer.parseInt(d[0]);
		int birthMonth = Integer.parseInt(d[1]);
		int birthDay = Integer.parseInt(d[2]);

		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowMonth = c.get(Calendar.MONTH);
		int nowDay = c.get(Calendar.DAY_OF_MONTH);
		
		int age = nowYear - birthYear;
		if (birthMonth > nowMonth) {
			age--;
		}
		if (birthMonth == nowMonth && birthDay > nowDay) {
			age--;
		}

		return age;
	}

	// 求未来日期离今天还剩的天数
	public static int getDay(String birthday) {
		String[] d = birthday.trim().split("-");
		int birthYear = Integer.parseInt(d[0]);
		int birthMonth = Integer.parseInt(d[1]);
		int birthDay = Integer.parseInt(d[2]);

		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowMonth = c.get(Calendar.MONTH) + 1;
		int nowDay = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(nowMonth + "55555");

		int day1 = birthYear * 365 + birthMonth * 30 + birthDay;
		System.out.println(birthMonth * 30);
		int day2 = nowYear * 365 + nowMonth * 30 + nowDay;
		System.out.println(nowMonth * 30);
		int day = day2 - day1;

		return day;
	}

	// 判断给定的日期是否为今天
	public static boolean isToday(Date date) {

		String s1 = sf.format(date);

		Date date2 = new Date();
		String s2 = sf.format(date2);
		System.out.println(s1 + "*******" + s2);
		return s1.equals(s2);
	}

	// 判断给定的日期是否在本周之内
	public static boolean isInWeek(String str) throws ParseException {
		Date d = sf.parse(str);
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowWeek = c.get(Calendar.WEEK_OF_YEAR);
		c.setTime(d);
		int theYear = c.get(Calendar.YEAR);
		int theWeek = c.get(Calendar.WEEK_OF_YEAR);

		return nowYear == theYear && nowWeek == theWeek;
	}

	// 给定时间对象，初始化到该月初的1月1日0时0分0秒0毫秒
	public static Date changeFirst(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	// 给定时间对象，设定到该月最一天的23时59分59秒999毫秒
	public static Date changeLast(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		Date d = changeFirst(c.getTime());
		c.setTime(d);
		c.set(Calendar.SECOND, -1);

		return c.getTime();
	}

	// 时间比较时间比较
	public static int comparDate(Date date1, Date date2) {
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		if (l1 == l2) {
			return 0;
		}
		if (l1 > l2) {
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) throws ParseException {
		// System.out.println(getAge("2018-12-04"));
		// System.out.println(getDay("2019-12-04"));

		/*
		 * Date d1=sf.parse("2019-12-06"); System.out.println(isToday(d1));
		 */

		// System.out.println(isInWeek("2019-12-08"));
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String rizi = "2019-02-06";
		sf.parse(rizi);
		// System.out.println(changeFirst(sf.parse(rizi)).toLocaleString());
		System.out.println(changeLast(sf.parse(rizi)).toLocaleString());
		/*Date d1 = sf.parse("2019-12-06");
		Date d2 = sf.parse("2019-11-06");
		System.out.println(comparDate(d1, d2));*/
	}

}
