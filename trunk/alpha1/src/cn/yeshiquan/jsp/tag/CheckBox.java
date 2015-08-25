package cn.yeshiquan.jsp.tag;
import java.io.IOException;
import java.util.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Properties;
import com.littleqworks.commons.util.Filters;
import net.ziqiang.movie.struts.forms.EditUserForm;

public class CheckBox extends TagSupport{
	public int doStartTag() throws JspException{
		String privilege=((EditUserForm)pageContext.getSession().getAttribute("editUserForm")).getUser().getPrivilege();
		Properties pro=new Properties();
		JspWriter out=pageContext.getOut();
		try{
			InputStream in=new BufferedInputStream(new FileInputStream("/opt/java/apache-tomcat-5.5.25/webapps/movie2/WEB-INF/privilege.properties"));
			pro.load(in);
			Enumeration<?> enu=pro.propertyNames();
			while(enu.hasMoreElements()){
				String key=enu.nextElement().toString();
				if(Filters.isChildIgnoreCase(key, privilege)){
					out.println("<input type=\"checkbox\" name=\"AUTH\" value=\""+key+"\" checked />"+Filters.convertToGB2312(pro.getProperty(key))+"&nbsp;&nbsp;");
				}else{
					out.println("<input type=\"checkbox\" name=\"AUTH\" value=\""+key+"\"/>"+Filters.convertToGB2312(pro.getProperty(key))+"&nbsp;&nbsp;");
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		return EVAL_PAGE;
	}
}
