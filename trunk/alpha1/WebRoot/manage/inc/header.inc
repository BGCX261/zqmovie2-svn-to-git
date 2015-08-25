<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ page import="net.ziqiang.movie.domain.*" %>
<%
	User user=(User)session.getAttribute("currentUser");
	if(user==null){
%>
	非法访问,请先<a href="/movie/login.do">登录</a>
<%
	return;
	}
%>