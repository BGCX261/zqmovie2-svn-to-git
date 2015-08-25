package net.ziqiang.movie.struts.actions;
import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleqworks.commons.util.Filters;

import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.struts.Constants;
import net.ziqiang.movie.struts.forms.EditUserForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class EditUserAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{	
		User user=(User)request.getSession().getAttribute("currentUser");
			if(Filters.isChildIgnoreCase(Constants.MANAGE, user.getPrivilege())){
				String idstr=(String)request.getParameter("id");
				try{
					int id=Integer.parseInt(idstr);//获取用户id
					String[] values=request.getParameterValues("AUTH");//获取权限
					String privilege="AUTH_USER;";
					for(int i=0;i<values.length;i++){
						privilege+=values[i]+";";
					}
					System.out.println(privilege);
					if(id>0){
						if(getMovieService().updateUserPrivilege(id, privilege)){
							return (new ActionForward(mapping.findForward("success")));
						}else{//修改权限失败
							return (new ActionForward(mapping.findForward("failure")));
						}
					}else{//参数不合法
						return (new ActionForward(mapping.getInput()));
					}
				}catch(NumberFormatException e){
					e.printStackTrace();
					return (new ActionForward(mapping.getInput()));
				}
			}else{//没有用户管理的权限
				return (new ActionForward(mapping.findForward("notauth")));
			}
	}
}	
