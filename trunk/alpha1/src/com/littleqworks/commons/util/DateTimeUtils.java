/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;

/**
 * MyDate.java
 * @author ̷����
 * @version 0.03
 * Last Date: 28-Apr-07
 * Description: ���ع涨��ʽ��ʱ���ַ�����
 * ��ʽ�ַ���������ο�JavaAPI�ĵ���java.text.SimpleDateFormat�½ڡ�
 */

import java.util.*;
import java.text.SimpleDateFormat;


public class DateTimeUtils {
	private static Calendar cal=Calendar.getInstance();
	private static SimpleDateFormat sdf= new SimpleDateFormat();
	
	/**
	 * ��ȡģʽ��ʽ(yyyy-MM-dd)��ʱ���ַ���.
	 * @return ����String������
	 */
	public static String getDate(){
		sdf.applyPattern("yyyy-MM-dd");
		String date=sdf.format(cal.getTime());
		return date;
	}

	/**
	 * ���ָ����ʽ��ʱ���ַ���.
	 * @param patten ��ʽ�ַ���
	 * @return ����String������
	 */
	public static String getDate(String patten){
		sdf.applyPattern(patten);
		String date=sdf.format(cal.getTime());
		return date;
	}
	
	/**
	 * ��õ�ǰ������ʱ���
	 * @return
	 */
	public static String getTimestamp(){
		return getDate("yyyy-MM-dd HH:mm:ss");
	}
}
