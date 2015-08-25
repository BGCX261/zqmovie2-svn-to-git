/*
* Copyright (C) 2000-2007 Tan Menglong <TanMenglong@gmail.com>
* 
* This code is distributed under Mozilla Public Licene1.1, please visit the URL below for details: 
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.commons.dao.ibatis;

/*
 * iBatis通用泛型方法集合接口
 * 作者：谭孟泷
 * 版本：0.02
 * 最后修改日期：20071020
 * 描述：iBatis通用方法集合接口，具体的数据库通用泛型操作方法类必须实现此接口。
 */

import java.util.*;

/**
 * CommonDao
 * @author 谭孟泷
 * @version 0.02
 * Last Date: 20-Oct-07
 * Description: iBatis通用泛型方法接口.
 */

public interface CommonDaoGeneric {
	public void setSqlMapTemplateFactory(SqlMapClientFactory sqlMapTemplateFactory);

	public <R> R get(String sqlType);
	public <R,P> R getByParameter(P parameter,String sqlType);

	public <R> List<R> getList(String sqlType);
	public <R,P> List<R> getListByParameter(P parameter,String sqlType);
	
	public boolean insert(String sqlType);
	public <P> boolean insertByParameter(P parameter,String sqlType);
	
	public boolean update(String sqlType);
	public <P> boolean updateByParameter(P parameter,String sqlType);
	
	public boolean delete(String sqlType);
	public <P> boolean deleteByParameter(P parameter,String sqlType);
}
