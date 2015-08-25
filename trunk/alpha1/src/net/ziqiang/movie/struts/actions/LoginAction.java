package net.ziqiang.movie.struts.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.littleqworks.commons.security.*;


import net.ziqiang.movie.service.PassportService;
import net.ziqiang.movie.service.MovieService;
import net.ziqiang.movie.service.MovieServiceFactory;
import net.ziqiang.movie.service.PassportServiceFactory;
import net.ziqiang.movie.domain.movie.*;
import net.ziqiang.movie.domain.*;
import net.ziqiang.movie.struts.forms.LoginForm;

import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
public class LoginAction extends BaseAction{
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{
		
		ActionMessages errors=new ActionMessages();
		LoginForm loginForm=(LoginForm)form;
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		String forward=(String)request.getSession().getAttribute("forward");//��ȡSecureBaseAction�е�session����forward
		request.getSession().removeAttribute("forward");
		User user=getPassportService().getUserByUsername(username);
		
		if(user==null){//û��ע��,�û���������
			errors.add("notexist",new ActionMessage("username.notexist"));
		}else{
			user.setRealname(getPassportService().getRealnameById(user.getId()));
			if(getMovieService().getUserByUsername(username)==null){
				getMovieService().insertUser(user);//����ǵ�һ�η�����ǿ��Ӱ,������û�
			}
			if(user.getPassword().equals(Encryption.getMD5(password))){
				user=getMovieService().getUserByUsername(user.getUsername());
				request.getSession().setAttribute("currentUser", user);
			}else{//�������
				errors.add("invalidate",new ActionMessage("password.invalidate"));
				System.out.println("password is not validate");
				}
		}
		if(!errors.isEmpty()){
			saveErrors(request,errors);
			return (new ActionForward(mapping.getInput()));
		}
		if(forward==null||forward.length()<1){
			return (mapping.findForward("success"));
		}else{
			response.sendRedirect(forward);//�ص��û��ϴη��ʵ�ҳ��
			return null;
		}
	}
}
		