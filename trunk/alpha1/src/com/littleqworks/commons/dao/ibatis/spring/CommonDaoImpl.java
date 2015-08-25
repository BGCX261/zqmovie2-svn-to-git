/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis.spring;

/*
 * DAO通用方法集合的iBatis实现 - Spring版
 * 作者：谭孟泷
 * 版本：0.002
 * 最后修改日期：20070929
 * 描述：DAO通用方法集合的iBatis实现。
 */

import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class CommonDaoImpl implements CommonDao{
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public int getInt(String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt(sqlMapClientTemplate.queryForObject(sqlType).toString());
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public int getIntByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt( sqlMapClientTemplate.queryForObject(sqlType, integer).toString()); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public int getIntByString(String str,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt( sqlMapClientTemplate.queryForObject(sqlType, new String(str)).toString()); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public int getIntByMap(HashMap map,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt( sqlMapClientTemplate.queryForObject(sqlType, map).toString()); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}

	public String getString(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType).toString();
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public String getStringByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, integer).toString(); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public String getStringByString(String str,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, new String(str)).toString(); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public String getStringByMap(HashMap map,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, map).toString(); 
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}

	public Object getObject(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public Object getObjectByInt(int integer, String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public Object getObjectByString(String str, String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public Object getObjectByMap(HashMap map, String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForObject(sqlType, map);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public List getList(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForList(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public List getListByInt(int integer, String sqlType) throws DataAccessException{
		try{
			return sqlMapClientTemplate.queryForList(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public List getListByString(String str, String sqlType) throws DataAccessException{
		try{
			return  sqlMapClientTemplate.queryForList(sqlType, new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	public List getListByMap(HashMap map, String sqlType) throws DataAccessException{
		try{
			return  sqlMapClientTemplate.queryForList(sqlType, map);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}

	public boolean insert(String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType);
		}catch(DataAccessException e){
			return false;
		}
		return true;
	}
	public boolean insertObject(Object obj,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, obj);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean insertByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean insertByString(String str,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, str);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean insertByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, map);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}

	public boolean update(String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean updateObject(Object obj,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType, obj);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean updateByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean updateByString(String str, String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType,new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean updateByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType,map);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}

	public boolean delete(String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean deleteByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean deleteByString(String str,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	public boolean deleteByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,map);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
}
