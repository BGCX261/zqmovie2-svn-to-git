package net.ziqiang.movie.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.ziqiang.movie.struts.forms.MovieActionForm;

public class EditMovieFormAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("movieActionForm");
		String idStr=request.getParameter("id");
		int id;
		try{
			id=Integer.parseInt(idStr);
		}catch(NumberFormatException e){
			return (new ActionForward(mapping.getInput()));
		}
		MovieActionForm movieActionForm=new MovieActionForm();
		if(movieActionForm.getMovie()==null){
			movieActionForm.setMovie(getMovieService().getMovieById(id));
		}
		if(movieActionForm.getCategories()==null){
			movieActionForm.setCategories(getMovieService().getCategory());
		}
		request.getSession().setAttribute("movieActionForm",movieActionForm);
		return (mapping.findForward("success"));
	}
}
