/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;

/**
 * ������ʽƥ��ĳ�����
 * @author ̷����
 * @description ������ʽƥ��ĳ�����
 * @version 0.01
 */

import java.util.regex.*;

public class RegExUtils {
	//TODO ���������ʽ
	private static String USERNAME_REGEX="";
	private static String EMAIL_REGEX="";
	private static String TEL_REGEX="";
	private static String MOBILE_REGEX="";
	
	public static boolean isMatch(String str,String regEx){
		Pattern pattern=Pattern.compile(regEx);
		Matcher matcher=pattern.matcher(str);
		return matcher.matches();
	}
	
	public static boolean isUsername(String username){
		return isMatch(username,USERNAME_REGEX);
	}

	public static boolean isEmail(String email){
		return isMatch(email,EMAIL_REGEX);
	}
	
	public static boolean isTelphone(String tel){
		return isMatch(tel,TEL_REGEX);
	}
	
	public static boolean isMobile(String mobile){
		return isMatch(mobile,MOBILE_REGEX);
	}
}
