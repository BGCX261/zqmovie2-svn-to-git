package net.ziqiang.movie.struts.actions;
import javax.servlet.ServletContext;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionServlet;

import net.ziqiang.movie.service.*;
public class BaseAction extends Action{
	private MovieService movieService;
	private PassportService passportService;
	public void setServlet(ActionServlet actionServlet){
		super.setServlet(actionServlet);
		if(actionServlet !=null){
			this.movieService=MovieServiceFactory.getMovieService();
			this.passportService=PassportServiceFactory.getPassportService();
		}
	}
	
	protected MovieService getMovieService(){
		return movieService;
	}
	
	protected PassportService getPassportService(){
		return passportService;
	}	
}
