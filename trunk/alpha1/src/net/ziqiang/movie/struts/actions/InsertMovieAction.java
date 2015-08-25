package net.ziqiang.movie.struts.actions;

import java.io.IOException;
import java.io.File;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.littleqworks.commons.util.Filters;
import com.littleqworks.commons.file.util.FileUtils;

import net.ziqiang.movie.struts.Constants;
import net.ziqiang.movie.struts.forms.MovieActionForm;
import net.ziqiang.movie.domain.User;
import net.ziqiang.movie.domain.movie.Movie;
import net.ziqiang.movie.service.*;

public class InsertMovieAction extends SecureBaseAction{
	public ActionForward doExecute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
throws IOException,ServletException{
		
		User user=(User)request.getSession().getAttribute("currentUser");
		if(Filters.isChildIgnoreCase(Constants.INSERT, user.getPrivilege())){
			MovieActionForm movieForm=(MovieActionForm)form;
			ActionMessages errors=new ActionMessages();
			String intro=request.getParameter("intro");//获取电影简介
			movieForm.getMovie().setIntro(intro);			
			FormFile file=movieForm.getTheFile();//获取用户上传的文件
			if(file.getFileSize()>0){
				if(file.getFileSize()>500*1000){//文件大小不能超过500 KB
					errors.add("theFile",new ActionMessage("maxLengthExceeded"));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}else if(!(Filters.isChildIgnoreCase(FileUtils.getFileNameSuffix(file.getFileName()),"jpg,jpeg,bmp"))){
					//文件格式只能为jpg,jpeg或bmp
					errors.add("theFile",new ActionMessage("suffix_invalidate"));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));				
				}else{
					String encoding = request.getCharacterEncoding();
					if((encoding != null)&&(encoding.equalsIgnoreCase("utf-8"))){
						response.setContentType("text/html;charset=gb2312");
					}
					try{
						InputStream stream = file.getInputStream();
						String fileName = System.currentTimeMillis()+file.getFileName().hashCode()+"."+FileUtils.getFileNameSuffix(file.getFileName());
						movieForm.getMovie().setPic("pic/"+fileName);//设置pic的路径
						OutputStream bos = new FileOutputStream(Constants.UPLOADPATH+fileName);
						int bytesRead = 0;
						byte[] buffer = new byte[8192];
						while ((bytesRead = stream.read(buffer, 0, 8192)) != -1){
							 bos.write(buffer, 0, bytesRead);//将文件写入服务器
						 }
						 bos.close();
						 stream.close();				
					}catch(Exception e){
						e.printStackTrace();
						return new ActionForward("failure");
					}				
				}				
			}else{
				String pic = movieForm.getMovie().getPic();
				if(pic==null || pic.length()<=0){
					errors.add("movie.pic",new ActionMessage("movie.pic"));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));						
				}
			}
			if(getMovieService().insertMovie(movieForm.getMovie())){
				return (new ActionForward(mapping.findForward("success")));
			}else{//操作失败
				return (new ActionForward(mapping.findForward("failure")));
			}
		}else{//没有删除权限
			return (new ActionForward(mapping.findForward("notauth")));
		}
		
	}
}
