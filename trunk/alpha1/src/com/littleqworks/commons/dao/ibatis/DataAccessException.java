/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/
package com.littleqworks.commons.dao.ibatis;

public class DataAccessException extends RuntimeException{
	public DataAccessException(String errMsg){
		super("Nested error:"+errMsg);
	}
}
