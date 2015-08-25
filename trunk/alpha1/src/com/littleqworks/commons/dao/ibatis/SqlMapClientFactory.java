/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatis SqlMapClient��������
 * ���ߣ�̷����
 * �汾��0.02
 * ����޸����ڣ�20071020
 * ������iBatisͨ�÷������Ͻӿ�ʵ���ࡣ
 */

import java.io.Reader;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

/**
 * SqlMapTemplate.java
 * @author TanMenglong
 * @version 0.02
 * Last Date: 16-Jul-07
 * Description: A class to connect to MySQL server.
 */

public class SqlMapClientFactory {
	private static String resource;
	private static SqlMapClientFactory sqlMapClientFactory;

	public static void setResource(String resourceUri) {
		resource = resourceUri;
	}
	
	public static SqlMapClientFactory getInstance(){
		sqlMapClientFactory.setResource(resource);
		return sqlMapClientFactory;
	}

	public static SqlMapClient getSqlMapClient() throws Exception{
		try{
			Reader reader = Resources.getResourceAsReader (resource); 
			SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			return sqlMapClient;
		}catch(Exception e){
			e.printStackTrace(); 
			throw new RuntimeException ("Error initializing SqlMapClient . Cause: "+e); 
		} 
	}

      

}

