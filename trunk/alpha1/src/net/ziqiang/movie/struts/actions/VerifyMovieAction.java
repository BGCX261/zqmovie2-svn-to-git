package net.ziqiang.movie.struts.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.struts.Constants;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.littleqworks.commons.util.Filters;

public class VerifyMovieAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{	
		User user=(User)request.getSession().getAttribute("currentUser");
			if(Filters.isChildIgnoreCase(Constants.VERIFY, user.getPrivilege())){
				int id=(request.getParameter("id")==null)?-1:Integer.parseInt(request.getParameter("id"));
				if(id>0){
					if(getMovieService().verifyMovie(id, 2)){
						return (new ActionForward(mapping.findForward("success")));
					}else{//操作失败
						return (new ActionForward(mapping.findForward("failure")));
					}
				}else{//参数不合法,返回首页
					return (new ActionForward(mapping.findForward("index")));
				}				
			}else{//没有审核权限
				return(new ActionForward(mapping.findForward("notauth")));
			}
		
	}
}
