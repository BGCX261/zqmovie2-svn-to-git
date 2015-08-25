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
					int id=Integer.parseInt(idstr);//��ȡ�û�id
					String[] values=request.getParameterValues("AUTH");//��ȡȨ��
					String privilege="AUTH_USER;";
					for(int i=0;i<values.length;i++){
						privilege+=values[i]+";";
					}
					System.out.println(privilege);
					if(id>0){
						if(getMovieService().updateUserPrivilege(id, privilege)){
							return (new ActionForward(mapping.findForward("success")));
						}else{//�޸�Ȩ��ʧ��
							return (new ActionForward(mapping.findForward("failure")));
						}
					}else{//�������Ϸ�
						return (new ActionForward(mapping.getInput()));
					}
				}catch(NumberFormatException e){
					e.printStackTrace();
					return (new ActionForward(mapping.getInput()));
				}
			}else{//û���û������Ȩ��
				return (new ActionForward(mapping.findForward("notauth")));
			}
	}
}	
