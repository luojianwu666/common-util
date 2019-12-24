package com.bawei.luojianwu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	// 根据日期算年龄
	public static int getAge(Date birthDate) {
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		//获得年、月、日
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//设置日历控件为生日的时间
		calendar.setTime(birthDate);
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		//计算年龄
		int age = nowYear-birthYear;
		//如果生日的月份大于当前月份时，年龄-1
		if(birthMonth>nowMonth) {
			age--;
		}
		//如果月份相等，判断日期
		if(birthMonth==nowMonth && nowDay<birthDay) {
			age--;
		}
		return age;
	}
	/**
	 * @Title: getDayNum   
	 * @Description: 获取开始日期和结束日期之间有多少天   
	 * @param: @param startDate
	 * @param: @param endDate
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getDayNum(Date date1,Date date2) {
		//一天有多少毫秒
		Long dayTime = 1000*60*60*24L;
		Long startTime = date1.getTime();
		Long endTime = date2.getTime();

		Double dayNum = Math.abs(((endTime-startTime)/dayTime*1.0));

		return dayNum.intValue()+1;
	}
	

	// 求未来日期离今天还剩的天数
	public static int getDayNum(Date date) {
		Date date2 = new Date();
		return getDayNum(date,date2);
	}
	/**
	 * 根据出生日期计算年龄
	 * @param birthDateStr "2019-11-08"
	 * @return
	 */
	public static int getAge(String birthDateStr) {
		Date birthDate = null;
		try {
			//解析日期字符串为Date对象
			birthDate = dateFormat.parse(birthDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//调用日期计算方法
		return getAge(birthDate);
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
	
	public static int getOddOrEven(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int Day=calendar.get(Calendar.DAY_OF_MONTH);
		return Day%2;
	}
	
	
	 public static int getDayofweek(String date){
		  Calendar cal = Calendar.getInstance();
		//   cal.setTime(new Date(System.currentTimeMillis()));
		  if (date.equals("")) {
		   cal.setTime(new Date(System.currentTimeMillis()));
		  }else {
		   cal.setTime(new Date(StringToDate(date).getTime()));
		  }
		   return cal.get(Calendar.DAY_OF_WEEK);
		 }
	 
	 //将字符串转换成date类型
	 public static Date StringToDate(String dd)
	 {
	 
	  SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	  Date date;
	  try {
	   date = sd.parse(dd);
	  } catch (ParseException e) {
	   date = null;
	   e.printStackTrace();
	  }
	  return date;
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
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		String s= "2011-07-09 "; 
		Date date =  formatter.parse(s);
	}

}
