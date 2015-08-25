/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;
/*
* 转换相关的类
* 作者：谭孟泷 
* 最后更新日期： 14-Mar-07
* 描述： 转换类。
*/
import java.io.*;

public class Filters{

	/**
	 * 判断子字符串是否在父字符串中出现，忽略大小写.
	 * @param subString 子字符串
	 * @param supString 父字符串
	 * @return boolean
	 */
	public static boolean isChildIgnoreCase(String subString,String supString){
		if((supString.toLowerCase()).indexOf(subString.toLowerCase())==-1){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 判断子字符串是否在父字符串中出现.
	 * @param subString 子字符串
	 * @param supString 父字符串
	 * @return boolean
	 */
	public static boolean isChild(String subString,String supString){
		if(supString.indexOf(subString)==-1){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 将字符串的字符集由ISO8859_1转为GB2312.
	 * @param strSrc 待转换的字符串
	 * @return 
	 */
	public static String convertToGB2312(String strSrc){
		try{
			if(strSrc==null)
				return null;
			strSrc=new String(strSrc.getBytes("ISO8859_1"),"gb2312");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return strSrc;
	}

	/**
	 * 转换字符串的字符集.
	 * @param strSrc 待转换的字符串
	 * @param oldCharset 原字符集
	 * @param newCharset 新字符集
	 * @return
	 */
	public static String convertCharset(String strSrc,String oldCharset,String newCharset){
		try{
			if(strSrc==null)
				return null;
			strSrc=new String(strSrc.getBytes(oldCharset),newCharset);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return strSrc;
	}

	/**
	 * 截取一个字符串中开头到指定长度的字符串
	 * @param full 完整的字符串
	 * @param start 新字符串开始的位置
	 * @param end 新字符串结束的位置
	 * @return
	 */
	public static String cutSentence(String full,int start,int end,String endStr){
		try{
			if(end>=full.length()){
				return full;
			}else{
				return full.substring(start, end+1)+endStr;
			}
		}catch(IndexOutOfBoundsException e1){
			return null;
		}
	}

	/**
	 * 截取一个字符串中开头到指定长度的字符串
	 * @param full 完整的字符串
	 * @param end 新字符串的长度
	 * @return
	 */
	public static String cutString(String full,int end,String endStr){
		try{
			if(end>=full.length()){
				return full;
			}else{
				return full.substring(0, end)+endStr;
			}
		}catch(IndexOutOfBoundsException e){
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 替换字符串中所有的指定字符
	 * @param originalString 待处理的字符串
	 * @param oldChar 待处理的字符
	 * @param newChar 新的字符
	 * @return
	 */
	public static String replaceChar(String originalString, char oldChar, char newChar) {
		return originalString.replace(oldChar, newChar) ;
	}
}
