/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.util;
/*
* ת����ص���
* ���ߣ�̷���� 
* ���������ڣ� 14-Mar-07
* ������ ת���ࡣ
*/
import java.io.*;

public class Filters{

	/**
	 * �ж����ַ����Ƿ��ڸ��ַ����г��֣����Դ�Сд.
	 * @param subString ���ַ���
	 * @param supString ���ַ���
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
	 * �ж����ַ����Ƿ��ڸ��ַ����г���.
	 * @param subString ���ַ���
	 * @param supString ���ַ���
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
	 * ���ַ������ַ�����ISO8859_1תΪGB2312.
	 * @param strSrc ��ת�����ַ���
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
	 * ת���ַ������ַ���.
	 * @param strSrc ��ת�����ַ���
	 * @param oldCharset ԭ�ַ���
	 * @param newCharset ���ַ���
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
	 * ��ȡһ���ַ����п�ͷ��ָ�����ȵ��ַ���
	 * @param full �������ַ���
	 * @param start ���ַ�����ʼ��λ��
	 * @param end ���ַ���������λ��
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
	 * ��ȡһ���ַ����п�ͷ��ָ�����ȵ��ַ���
	 * @param full �������ַ���
	 * @param end ���ַ����ĳ���
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
	 * �滻�ַ��������е�ָ���ַ�
	 * @param originalString ��������ַ���
	 * @param oldChar ��������ַ�
	 * @param newChar �µ��ַ�
	 * @return
	 */
	public static String replaceChar(String originalString, char oldChar, char newChar) {
		return originalString.replace(oldChar, newChar) ;
	}
}
