package net.ziqiang.movie.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionServlet;

public class MyActionServlet extends ActionServlet{
	protected void process(HttpServletRequest request,HttpServletResponse response)throws java.io.IOException,javax.servlet.ServletException{
		request.setCharacterEncoding("GB2312");
		super.process(request, response);
	}

}
