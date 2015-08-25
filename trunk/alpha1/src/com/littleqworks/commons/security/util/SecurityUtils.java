/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э�����������һ�µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.security.util;

public class SecurityUtils{
	public static boolean isSqlInjectionAttack(String str){
		str=str.toLowerCase();
		String injStr = "'|and|exec|insert|select|delete|update|union|count|*|%|chr|mid|master|where|=|truncate|char|declare|;|or|-|+|,";
		String[] injStra = injStr.split("\\|");

		int j=injStra.length;
	
		for(int i=0;i<j;i++){
			String new1=injStra[i];
			
			if(str.indexOf(new1)>=0){
				return true;
			}
		}
		return false;
	}

	public static String javascriptFilter(String src){
	    return src.replaceAll("script", "�������");
	}
}