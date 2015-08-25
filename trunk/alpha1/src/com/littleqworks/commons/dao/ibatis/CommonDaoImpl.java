/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatis通用方法集合接口实现类
 * 作者：谭孟泷
 * 版本：0.02
 * 最后修改日期：20071020
 * 描述：iBatis通用方法集合接口实现类。
 */

import java.util.*;

/**
 * CommonPhysical.java
 * @author CrackCell
 * @version 0.01
 * Last Date: 02-May-07
 * Description: iBatis通用方法接口的实现类.
 */

public class CommonDaoImpl implements CommonDao{
	private SqlMapClientFactory sqlMapClientFactory=null;

	public void setSqlMapTemplateFactory(SqlMapClientFactory sqlMapClientFactory) {
		this.sqlMapClientFactory = sqlMapClientFactory.getInstance();
	}

	public int getInt(String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt(sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType).toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public int getIntByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt(sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,integer).toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	public int getIntByString(String str,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt(sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,str).toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public int getIntByMap(HashMap hashMap,String sqlType) throws DataAccessException{
		try{
			return Integer.parseInt(sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,hashMap).toString());
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public String getString(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType).toString();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public String getStringByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,integer).toString();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public String getStringByString(String str,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,str).toString();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public String getStringByMap(HashMap hashMap,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,hashMap).toString();
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public Object getObject(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public Object getObjectByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,integer);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public Object getObjectByString(String str,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,str);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public Object getObjectByMap(HashMap hashMap,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForObject(sqlType,hashMap);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public List getList(String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForList(sqlType);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}
	
	public List getListByInt(int integer,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForList(sqlType,integer);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public List getListByString(String str,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForList(sqlType,str);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public List getListByMap(HashMap hashMap,String sqlType) throws DataAccessException{
		try{
			return sqlMapClientFactory.getSqlMapClient().queryForList(sqlType,hashMap);
		}catch(Exception e){
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	public boolean insert(String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().insert(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertObject(Object obj,String sqlType) throws DataAccessException{
		try {
			sqlMapClientFactory.getSqlMapClient().insert(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean insertByInt(int integer,String sqlType) throws DataAccessException{
		try {
			sqlMapClientFactory.getSqlMapClient().insert(sqlType,integer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertByString(String str,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().insert(sqlType,str);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertByMap(HashMap hashMap,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().insert(sqlType,hashMap);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(String sqlType) throws DataAccessException{
		try {
			sqlMapClientFactory.getSqlMapClient().update(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateObject(Object obj,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().update(sqlType,obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateByInt(int integer,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().update(sqlType,integer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateByString(String str, String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().update(sqlType,str);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateByMap(HashMap hashMap,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().update(sqlType,hashMap);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().delete(sqlType);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteByInt(int integer,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().delete(sqlType,integer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteByString(String str,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().delete(sqlType,str);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteByMap(HashMap hashMap,String sqlType){
		try {
			sqlMapClientFactory.getSqlMapClient().delete(sqlType,hashMap);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
