/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis.spring;

/*
 * DAO通用方法集合泛型方法接口 - Spring版
 * 作者：谭孟泷
 * 版本：0.001
 * 最后修改日期：20070928
 * 描述：DAO通用方法集合接口，具体的数据库通用操作方法类必须实现此接口。
 */

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

public interface CommonDaoGeneric {
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate);
	
	public <R> R get(String sqlType) throws DataAccessException;
	public <R,P> R getByParamter(P parameter,String sqlType) throws DataAccessException;
	
	public <R> List<R> getList(String sqlType) throws DataAccessException;
	public <R,P> List<R> getListByParameter(P parameter,String sqlType) throws DataAccessException;

	public boolean insert(String sqlType) throws DataAccessException;
	public <P> boolean insertByParameter(P parameter,String sqlType) throws DataAccessException;
	
	public boolean update(String sqlType) throws DataAccessException;
	public <P> boolean updateByParameter(P parameter,String sqlType) throws DataAccessException;
	
	public boolean delete(String sqlType) throws DataAccessException;
	public <P> boolean deleteByParameter(P parameter,String sqlType) throws DataAccessException;
}
