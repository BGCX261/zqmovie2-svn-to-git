/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis.spring;

/*
 * DAOͨ�÷������ϵ�iBatisʵ�� - Spring��
 * ���ߣ�̷����
 * �汾��0.002
 * ����޸����ڣ�20070929
 * ������DAOͨ�÷������ϵ�iBatisʵ�֡�
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
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean insertByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean insertByString(String str,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, str);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean insertByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.insert(sqlType, map);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}

	public boolean update(String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean updateObject(Object obj,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType, obj);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean updateByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType, new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean updateByString(String str, String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType,new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean updateByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.update(sqlType,map);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}

	public boolean delete(String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean deleteByInt(int integer,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,new Integer(integer));
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean deleteByString(String str,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,new String(str));
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	public boolean deleteByMap(HashMap map,String sqlType){
		try{
			sqlMapClientTemplate.delete(sqlType,map);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
}
