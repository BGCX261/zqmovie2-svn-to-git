package net.ziqiang.movie.struts.actions;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.ziqiang.movie.domain.User;

public abstract class SecureBaseAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		if(user==null){
			String path=request.getContextPath();
			String url=request.getServletPath();
			String query=request.getQueryString();
			if(query !=null){
				request.getSession().setAttribute("forward",path+url+"?"+query);
			}else{
				request.getSession().setAttribute("forward",path+url);
			}
			return mapping.findForward("loginForm");
		}else{
			return doExecute(mapping, form, request, response);
		}
	}
	
	protected abstract ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
