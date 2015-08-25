/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.security;

/**
 * Encrypt.java
 * @author 谭孟泷
 * @version 0.02
 * Last Date: 26-May-07
 * Description: 信息加密类..
 */

import java.security.*;

public class Encryption{

	/**
	 * 取得指定字符的MD5编码.
	 * @param strSrc 源字符串
	 * @return
	 */
	public static final String getMD5(String strSrc){
		return get(strSrc,"MD5");
	}

/**
 * 取得指定字符的SHA-1编码.
 * @param strSrc 源字符串
 */
	public static final String getSHA1(String strSrc){
		return get(strSrc,"SHA-1");
	}

/**
 * 取得指定字符的SHA-256编码.
 * @param strSrc 源字符串
 */
	public static final String getSHA256(String strSrc){
		return get(strSrc,"SHA-256");
	}

	/**
	 * 取得指定字符按照特定规则的编码(MD5,SHA-1,SHA-256).
	 * @param strSrc
	 * @param encName
	 * @return
	 */
	public static final String get(String strSrc,String encName){
	//默认加密方法为MD5
		MessageDigest md=null;
		String strDes=null;
		
		byte[] bt=strSrc.getBytes();
		try{
			if (encName==null||encName.equals("")){
				encName="MD5";
			}
			md=MessageDigest.getInstance(encName);
			md.update(bt);
			strDes=bytes2Hex(md.digest());  //to HexString
		}catch (NoSuchAlgorithmException e1){
			e1.printStackTrace();
			return null;
		}
		return strDes;
}

	private static String bytes2Hex(byte[]bts){
		String des="";
		String tmp=null;
		for(int i=0;i<bts.length;i++){
			tmp=(Integer.toHexString(bts[i] & 0xFF));
			if(tmp.length()==1){
				des+="0";
			}
			des+=tmp;
		}
		return des;
	}
}

