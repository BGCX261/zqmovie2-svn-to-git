package net.ziqiang.movie.service;

import java.util.*;
import com.littleqworks.commons.dao.ibatis.spring.*;

import net.ziqiang.movie.domain.*;

public class PassportService {
	private CommonDaoGenericImpl commonDao;

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public User getUserByUsername(String username){
		return commonDao.getByParamter(username, "getUserByUsername");
	}
	
	public String getRealnameById(int id){
		return commonDao.getByParamter(id, "getRealnameById");
	}	
}
