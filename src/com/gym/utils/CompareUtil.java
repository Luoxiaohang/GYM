package com.gym.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 比较器工具类
 * 
 * @author Feng
 * 
 */
public class CompareUtil {

	/**
	 * 比较时间日期先后 格式例子：2012-12-30 11:30
	 * 
	 * @param begin
	 * @param end
	 * @return begin在end前返回负数；begin在end后返回正数；格式错误或时间相等返回0
	 */
	public long compareDateTime(String begin, String end, String format) {

		DateFormat df = new SimpleDateFormat(format);
		try {
			Date d1 = df.parse(begin);
			Date d2 = df.parse(end);
			long diff = d1.getTime() - d2.getTime();

			return diff;

		} catch (Exception e) {
		}

		return 0;

	}

	public static void main(String[] args) {
		System.out.println(new CompareUtil().compareDateTime(
				"2012-12-30 11:30", "2012-12-30 11:31", "yyyy-MM-dd HH:mm"));
	}

}
