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

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class CommonDaoGenericImpl implements CommonDaoGeneric{
	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	public <R> R get(String sqlType) throws DataAccessException{
		try{
			return (R)sqlMapClientTemplate.queryForObject(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public <R,P> R getByParamter(P parameter,String sqlType) throws DataAccessException{
		try{
			return (R)sqlMapClientTemplate.queryForObject(sqlType,parameter);
		}catch(DataAccessException e){
			e.printStackTrace();
			throw e;
		}
	}

	public boolean insert(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.insert(sqlType);
		}catch(DataAccessException e){
			return false;
		}
		return true;
	}
	
	public <P> boolean insertByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.insert(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public boolean update(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <R> List<R> getList(String sqlType) throws DataAccessException {
		try {
			return sqlMapClientTemplate.queryForList(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <R, P> List<R> getListByParameter(P parameter, String sqlType)
			throws DataAccessException {
		try {
			return sqlMapClientTemplate.queryForList(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <P> boolean updateByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public boolean delete(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}
	
	public <P> boolean deleteByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//输出调试信息到控制台
			return false;
		}
		return true;
	}

}
