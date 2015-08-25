/*
* ��Ȩ���� (C) 2000-2007 ̷���� <TanMenglong@gmail.com>
* 
* �˴�����ѭMozilla Public Licene1.1Э�鷢��������Э��������������µ�ַ
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.webGuard.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NotLogin implements Filter{
	private FilterConfig filterCOnfig=null;
	private String sessionAttributeName=null;
	private String errUrl=null;
	
	public void doFilter(ServletRequest request2,
							ServletResponse response2,
							FilterChain chain)throws IOException,ServletException{
		HttpServletRequest request=(HttpServletRequest)request2;
		HttpServletResponse response=(HttpServletResponse)response2;
		HttpSession session=request.getSession();
		if(session.getAttribute(sessionAttributeName)==null){
			response.sendRedirect(request.getContextPath()+errUrl);
		}else{
			chain.doFilter(request2, response2);
		}
		
	}
	
	public void destroy(){}
	public void init(FilterConfig filterConfig){
		this.filterCOnfig=filterConfig;
		this.sessionAttributeName=filterConfig.getInitParameter("sessionAttributeName");
		this.errUrl=filterConfig.getInitParameter("errUrl");
	}
}
