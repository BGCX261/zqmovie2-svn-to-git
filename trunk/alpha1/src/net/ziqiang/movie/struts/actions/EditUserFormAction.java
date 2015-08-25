package net.ziqiang.movie.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.struts.Constants;
import net.ziqiang.movie.struts.forms.EditUserForm;
import com.littleqworks.commons.util.Filters;
public class EditUserFormAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user=(User)request.getSession().getAttribute("currentUser");
		if(Filters.isChildIgnoreCase(Constants.MANAGE, user.getPrivilege())){
			request.getSession().removeAttribute("editUserForm");
			String idStr=request.getParameter("id");
			int id;
			try{
				id=Integer.parseInt(idStr);
			}catch(Exception e){//参数不合法
				return (new ActionForward(mapping.getInput()));
			}	
			User editUser=getMovieService().getUserById(id);
			EditUserForm editUserForm=new EditUserForm();
			if(editUserForm.getUser()==null){
				editUserForm.setUser(editUser);
			}
			request.getSession().setAttribute("editUserForm", editUserForm);
			return (new ActionForward(mapping.findForward("success")));			
		}else{//没有用户管理的权限
			return (new ActionForward(mapping.findForward("notauth")));
		}
	}
}
