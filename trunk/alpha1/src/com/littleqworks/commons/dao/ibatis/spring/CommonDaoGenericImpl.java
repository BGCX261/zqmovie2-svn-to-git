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
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	
	public boolean update(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.update(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
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
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	
	public boolean delete(String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}
	
	public <P> boolean deleteByParameter(P parameter,String sqlType) throws DataAccessException{
		try{
			sqlMapClientTemplate.delete(sqlType, parameter);
		}catch(DataAccessException e){
			e.printStackTrace();//���������Ϣ������̨
			return false;
		}
		return true;
	}

}
