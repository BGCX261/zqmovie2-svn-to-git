/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;

/**
 * MyDate.java
 * @author 谭孟泷
 * @version 0.03
 * Last Date: 28-Apr-07
 * Description: 返回规定格式的时间字符串。
 * 格式字符串定义请参看JavaAPI文档的java.text.SimpleDateFormat章节。
 */

import java.util.*;
import java.text.SimpleDateFormat;


public class DateTimeUtils {
	private static Calendar cal=Calendar.getInstance();
	private static SimpleDateFormat sdf= new SimpleDateFormat();
	
	/**
	 * 获取模式格式(yyyy-MM-dd)的时间字符串.
	 * @return 返回String型数据
	 */
	public static String getDate(){
		sdf.applyPattern("yyyy-MM-dd");
		String date=sdf.format(cal.getTime());
		return date;
	}

	/**
	 * 获得指定格式的时间字符串.
	 * @param patten 格式字符串
	 * @return 返回String型数据
	 */
	public static String getDate(String patten){
		sdf.applyPattern(patten);
		String date=sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * 获得当前的完整时间戳
	 * @return
	 */
	public static String getTimestamp(){
		return getDate("yyyy-MM-dd HH:mm:ss");
	}
}
