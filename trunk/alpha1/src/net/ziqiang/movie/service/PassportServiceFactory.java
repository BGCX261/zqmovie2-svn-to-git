package net.ziqiang.movie.service;

import javax.servlet.http.*;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.*;

import net.ziqiang.movie.domain.*;
import net.ziqiang.movie.service.*;

public class PassportServiceFactory{
	private static PassportService passportService;
	public static PassportService getPassportService(){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/movie/dao/ibatis/passport/conf/passport-dao.xml"});
		passportService=(PassportService)ac.getBean("passportService");
		return passportService;
	}
	
	public static void main(String[] args){
		ApplicationContext ac=new ClassPathXmlApplicationContext(
				new String[]{"/net/ziqiang/movie/dao/ibatis/passport/conf/passport-dao.xml"});
		
	}
}
