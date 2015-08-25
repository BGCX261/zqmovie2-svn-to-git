/*
* 版权所有 (C) 2000-2007 谭孟泷 <TanMenglong@gmail.com>
* 
* 此代码遵循Mozilla Public Licene1.1协议发布，具体协议条款请参照以下地址
* http://www.mozilla.org/MPL/MPL-1.1.html
*/

package com.littleqworks.webGuard.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.littleqworks.webGuard.UserBase;
import com.littleqworks.commons.util.*;

public class NotAuthenticated implements Filter{
	private FilterConfig filterCOnfig=null;
	private String sessionAttributeName=null;
	private String loginUrl=null;
	private String errUrl=null;
	private String privilege=null;
	
	public void doFilter(ServletRequest request2,
							ServletResponse response2,
							FilterChain chain)throws IOException,ServletException{
		HttpServletRequest request=(HttpServletRequest)request2;
		HttpServletResponse response=(HttpServletResponse)response2;
		HttpSession session=request.getSession();
		if(session.getAttribute(sessionAttributeName)==null){
			response.sendRedirect(request.getContextPath()+loginUrl);
		}else{
			UserBase user=(UserBase)session.getAttribute(sessionAttributeName);
			if(Filters.isChildIgnoreCase(privilege,user.getPrivilege())){
				System.out.println("Authentication passed:"+privilege+"="+user.getPrivilege());
				chain.doFilter(request2, response2);
			}else{
				response.sendRedirect(request.getContextPath()+errUrl);
			}
		}
		
	}
	
	public void destroy(){}
	public void init(FilterConfig filterConfig){
		this.filterCOnfig=filterConfig;
		this.sessionAttributeName=filterConfig.getInitParameter("sessionAttributeName");
		this.loginUrl=filterConfig.getInitParameter("loginUrl");
		this.errUrl=filterConfig.getInitParameter("errUrl");
		this.privilege=filterConfig.getInitParameter("privilege");
	}
}
