<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ page import="net.ziqiang.movie.domain.*" %>
<%
	User user=(User)session.getAttribute("currentUser");
	if(user==null){
		response.sendRedirect("/msg/please_login.html");
	}
%>
