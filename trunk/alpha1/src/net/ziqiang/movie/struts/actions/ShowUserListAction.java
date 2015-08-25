package net.ziqiang.movie.struts.actions;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.struts.Constants;

import com.littleqworks.commons.util.Filters;
import com.littleqworks.commons.web.util.NavigationBarNoParameter;
public class ShowUserListAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{	
		User user=(User)request.getSession().getAttribute("currentUser");
		if(Filters.isChildIgnoreCase(Constants.MANAGE, user.getPrivilege())){
			int count=getMovieService().getUserCount();
			int pag=(request.getParameter("pag")==null)?1:Integer.parseInt(request.getParameter("pag"));
			if(pag>=0){
				NavigationBarNoParameter nav=new NavigationBarNoParameter();
				nav.init(pag, "show_userlist", 20, count);
				request.setAttribute("userLi", getMovieService().getSomeUsers(nav.getRecordStartNumber(), 20));
				request.setAttribute("navigationBar",nav.getNavigationBar());
				return (new ActionForward(mapping.findForward("success")));
			}else{//参数不合法
				return (new ActionForward(mapping.getInput()));
			}
		}else{//没有用户管理的权限
			return (new ActionForward(mapping.findForward("notauth")));
		}
	}
}
