package com.littleqworks.commons.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoSuchAction implements Action {
	private String name="";
	public NoSuchAction(){
		
	}
	
	public NoSuchAction(String name){
		this.name=name;
	}

	public ModelAndView process(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		ModelAndView mv=new ModelAndView();
		mv.setMsg("This is no such action named "+name);
		return mv;
	}

}
