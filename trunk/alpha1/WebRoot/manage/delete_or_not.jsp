<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%@ page import="net.ziqiang.movie.service.*" %>
<%
	String path=request.getContextPath();
	MovieService movieService=MovieServiceFactory.getMovieService();
 %>
<html>
	<head>
		<title>确定删除</title>
	</head>
	<body>
	<%
		int id=(request.getParameter("id")==null)?-1:Integer.parseInt(request.getParameter("id"));
	 %>
		确实要删除<font color="blue"><%=movieService.getMovieNameById(id)%></font>吗<br>
		<a href="<%=path%>/delete_movie.do?id=${param.id}">确定</a>
	</body>
</html>