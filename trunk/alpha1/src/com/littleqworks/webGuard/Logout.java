package com.littleqworks.webGuard;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

public class Logout extends HttpServlet{
	private ServletConfig servletConfig=null;
	private String successView=null;
	private String failureView=null;
	private String sessionAttributeName=null;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException,ServletException{

		successView=request.getContextPath()+servletConfig.getInitParameter("successView");
		failureView=request.getContextPath()+servletConfig.getInitParameter("failureView");
		sessionAttributeName=servletConfig.getInitParameter("sessionAttributeName");

		String from=request.getParameter("from");

		request.getSession().setAttribute(sessionAttributeName, null);
		response.sendRedirect(from);
		System.out.println("Logout.did: logout.");
		
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig=servletConfig;
	}

}
