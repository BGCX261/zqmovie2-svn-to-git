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
		<title>ȷ��ɾ��</title>
	</head>
	<body>
	<%
		int id=(request.getParameter("id")==null)?-1:Integer.parseInt(request.getParameter("id"));
	 %>
		ȷʵҪɾ��<font color="blue"><%=movieService.getMovieNameById(id)%></font>��<br>
		<a href="<%=path%>/delete_movie.do?id=${param.id}">ȷ��</a>
	</body>
</html>