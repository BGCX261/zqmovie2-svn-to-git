package net.ziqiang.movie.struts.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ziqiang.movie.service.MovieService;
import net.ziqiang.movie.service.MovieServiceFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.littleqworks.commons.web.util.NavigationBar3Parameters;

public class ShowMovieListAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{	
		int status=(request.getParameter("status")==null)?-1:Integer.parseInt(request.getParameter("status"));
		int pag=(request.getParameter("pag")==null)?1:Integer.parseInt(request.getParameter("pag"));		
		int bid=(request.getParameter("bid")==null)?-1:Integer.parseInt(request.getParameter("bid"));
		if(bid!=-1&&status==-1){
			request.setAttribute("count", getMovieService().getCountByBid(bid));
		}
		else if(bid>0&&pag>0&&status>=0){
			int count=getMovieService().getCountByBidStatus(bid, status);
			NavigationBar3Parameters navBar=new NavigationBar3Parameters();
			navBar.init(bid, pag, status, "show_movielist.do", 20, count);
			request.setAttribute("movieLi", getMovieService().getMovieByBidStatus(bid, status, navBar.getRecordStartNumber(), 20));
			request.setAttribute("navigationBar", navBar.getNavigationBar());
		}
		return (mapping.findForward("success"));
	}
}
