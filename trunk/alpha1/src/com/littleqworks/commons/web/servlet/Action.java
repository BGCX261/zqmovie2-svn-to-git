package com.littleqworks.commons.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ModelAndView process(HttpServletRequest request,
			HttpServletResponse response);
}
