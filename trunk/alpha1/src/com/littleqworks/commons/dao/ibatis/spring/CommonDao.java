/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis.spring;

/*
 * DAO通用方法集合接口 - Spring版
 * 作者：谭孟泷
 * 版本：0.001
 * 最后修改日期：20070928
 * 描述：DAO通用方法集合接口，具体的数据库通用操作方法类必须实现此接口。
 */

import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public interface CommonDao {
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate);
	
	public int getInt(String sqlType) throws DataAccessException;
	public int getIntByInt(int integer,String sqlType) throws DataAccessException;
	public int getIntByString(String str,String sqlType) throws DataAccessException;
	public int getIntByMap(HashMap map,String sqlType) throws DataAccessException;
	
	public String getString(String sqlType) throws DataAccessException;
	public String getStringByInt(int integer,String sqlType) throws DataAccessException;
	public String getStringByString(String str,String sqlType) throws DataAccessException;
	public String getStringByMap(HashMap map,String sqlType) throws DataAccessException;
	
	public Object getObject(String sqlType) throws DataAccessException;
	public Object getObjectByInt(int integer,String sqlType) throws DataAccessException;
	public Object getObjectByString(String str,String sqlType) throws DataAccessException;
	public Object getObjectByMap(HashMap map,String sqlType) throws DataAccessException;

	public List getList(String sqlType) throws DataAccessException;
	public List getListByInt(int integer,String sqlType) throws DataAccessException;
	public List getListByString(String str,String sqlType) throws DataAccessException;
	public List getListByMap(HashMap map,String sqlType) throws DataAccessException;

	public boolean insert(String sqlType);
	public boolean insertObject(Object obj,String sqlType);
	public boolean insertByInt(int integer,String sqlType);
	public boolean insertByString(String str,String sqlType);
	public boolean insertByMap(HashMap map,String sqlType);
	
	public boolean update(String sqlType);
	public boolean updateObject(Object obj,String sqlType);
	public boolean updateByInt(int integer,String sqlType);
	public boolean updateByString(String str, String sqlType);
	public boolean updateByMap(HashMap map,String sqlType);
	
	public boolean delete(String sqlType);
	public boolean deleteByInt(int integer,String sqlType);
	public boolean deleteByString(String str,String sqlType);
	public boolean deleteByMap(HashMap map,String sqlType);

}
