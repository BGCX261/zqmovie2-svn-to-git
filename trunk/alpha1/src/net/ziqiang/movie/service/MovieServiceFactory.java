package net.ziqiang.movie.service;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;

import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.domain.movie.*;
import net.ziqiang.movie.service.*;

public class MovieServiceFactory{
	private static MovieService movieService;
	public static MovieService getMovieService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/movie/dao/ibatis/movie/conf/movie-dao.xml"});
		movieService=(MovieService)ac.getBean("movieService");
		return movieService;
	}
	
	public static void main(String[] args){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/movie/dao/ibatis/movie/conf/movie-dao.xml"});
				movieService=getMovieService();
				//System.out.println(movieService.getSomeUsers(0, 2).iterator().next().getId());
				/*List<Category> categoryLi=movieService.getCategory();
				Iterator<Category> it=categoryLi.iterator();
				ArrayList CATEGORIES =new ArrayList();
				while(it.hasNext()){
					Category cate=it.next();
					HashMap hashmap=new HashMap();
					hashmap.put("value",cate.getCategoryId());
					hashmap.put("label",cate.getName());
					 CATEGORIES.add(hashmap);
				}
				System.out.println(CATEGORIES);
				*/
				
	}
}
