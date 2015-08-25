package net.ziqiang.movie.service;

import java.util.*;

import com.littleqworks.commons.dao.ibatis.spring.*;

import net.ziqiang.movie.domain.*;
import net.ziqiang.movie.domain.movie.*;
import net.ziqiang.movie.domain.User;

public class MovieService {	
	private CommonDaoGenericImpl commonDao;

	public CommonDaoGenericImpl getCommonDao() {
		return commonDao;
	}

	public void setCommonDao(CommonDaoGenericImpl commonDao) {
		this.commonDao = commonDao;
	}
	
	public boolean insertMovie(Movie movie){
		return commonDao.insertByParameter(movie, "insertMovie");
	}

	public Category getCategoryById(int id){
		return commonDao.getByParamter(id, "getCategoryById");
	}
	
	public List<Category> getCategory(){
		return commonDao.getList("getCategory");
	}
	
	public List<Movie> getMovieByBidStatus(int bid,int status,int offset,int count){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("bid",bid);
		hashmap.put("status", status);
		hashmap.put("offset", offset);
		hashmap.put("count", count);
		return commonDao.getListByParameter(hashmap, "getMovieByBidStatus");
	}
	
	public int getCountByBidStatus(int bid,int status){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("bid",bid);
		hashmap.put("status", status);
		return commonDao.getByParamter(hashmap, "getCountByBidStatus");
	}
	
	public int getCountByBid(int bid){
		return commonDao.getByParamter(bid, "getCountByBid");
	}
	
	public boolean deleteMovie(int id){
		return commonDao.deleteByParameter(id, "deleteMovie");
	}
	
	public Movie getMovieById(int id){
		return commonDao.getByParamter(id, "getMovieById");
	}
	
	public boolean updateMovie(Movie movie){
		return commonDao.updateByParameter(movie, "updateMovie");
	}
	
	public String getCategoryNameById(int categoryId){
		return commonDao.getByParamter(categoryId, "getCategoryNameById");
	}
	
	public User getUserByUsername(String username){
		return commonDao.getByParamter(username, "getUserByUsername");
	}
	
	public boolean insertUser(User user){
		return commonDao.insertByParameter(user, "insertUser");
	}	
	
	public boolean verifyMovie(int id,int status){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("id", id);
		hashmap.put("status", status);
		return commonDao.updateByParameter(hashmap,"verifyMovie");
	}
	
	public int getUserCount(){
		return commonDao.get("getUserCount");
	}
	
	public boolean updateUserPrivilege(int id,String privilege){
		HashMap hashmap=new HashMap();
		hashmap.put("id", id);
		hashmap.put("privilege", privilege);		
		return commonDao.updateByParameter(hashmap, "updateUserPrivilege");
	}
	
	public List<User> getUsers(){
		return commonDao.get("getUsers");
	}
	
	public List<User> getSomeUsers(int offset,int count){
		HashMap<String,Integer> hashmap=new HashMap<String,Integer>();
		hashmap.put("offset", offset);
		hashmap.put("count", count);		
		return commonDao.getListByParameter(hashmap, "getSomeUsers");
	}
	
	public User getUserById(int id){
		return commonDao.getByParamter(id, "getUserById");
	}
	
	public String getMovieNameById(int id){
		return commonDao.getByParamter(id, "getMovieNameById");
	}
}
