package com.littleqworks.commons.dao.ibatis;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDaoGenericImpl implements CommonDaoGeneric{
	private SqlMapClientFactory sqlMapClientFactory=null;
	private SqlMapClient sqlMapTemplate=null;

	public void setSqlMapTemplateFactory(
			SqlMapClientFactory sqlMapTemplateFactory) {
		this.sqlMapClientFactory=sqlMapTemplateFactory;
		try {
			sqlMapTemplate=sqlMapTemplateFactory.getSqlMapClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean delete(String sqlType) {
		try {
			sqlMapTemplate.delete(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public <P> boolean deleteByParameter(P parameter, String sqlType) {
		try {
			sqlMapTemplate.delete(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public <R> R get(String sqlType){
		try {
			return (R)sqlMapTemplate.queryForObject(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <R, P> R getByParameter(P parameter, String sqlType){
		try {
			return (R)sqlMapTemplate.queryForObject(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <R> List<R> getList(String sqlType) {
		try {
			return sqlMapTemplate.queryForList(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public <R, P> List<R> getListByParameter(P parameter, String sqlType) {
		try {
			return sqlMapTemplate.queryForList(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean insert(String sqlType) {
		try {
			sqlMapTemplate.insert(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public <P> boolean insertByParameter(P parameter, String sqlType) {
		try {
			sqlMapTemplate.insert(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(String sqlType) {
		try {
			sqlMapTemplate.update(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public <P> boolean updateByParameter(P parameter, String sqlType) {
		try {
			sqlMapTemplate.update(sqlType,parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
