package net.ziqiang.movie.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.ziqiang.movie.domain.movie.Movie;
import net.ziqiang.movie.struts.forms.MovieActionForm;
import net.ziqiang.movie.service.MovieServiceFactory;

public class InsertMovieFormAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("movieActionForm");//清除上次操作的movieActionForm
		MovieActionForm movieActionForm=new MovieActionForm();
		if(movieActionForm.getMovie()==null){
			movieActionForm.setMovie(new Movie());
		}
		if(movieActionForm.getCategories()==null){
			movieActionForm.setCategories(getMovieService().getCategory());
		}
		request.getSession().setAttribute("movieActionForm",movieActionForm);
		return (mapping.findForward("success"));
	}
}
