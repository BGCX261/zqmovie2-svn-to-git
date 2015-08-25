/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;

/**
 * 正则表达式匹配的常用类
 * @author 谭孟泷
 * @description 正则表达式匹配的常用类
 * @version 0.01
 */

import java.util.regex.*;

public class RegExUtils {
	//TODO 添加正则表达式
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
