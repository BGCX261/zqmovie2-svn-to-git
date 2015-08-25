<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@page import="com.littleqworks.commons.util.Filters"%>
<%@ page import="net.ziqiang.movie.domain.User" %>
<%@page import="net.ziqiang.movie.struts.Constants;"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%
	String path=request.getContextPath();
	User user=(User)session.getAttribute("currentUser");
 %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>用户管理</title>
	<link href="styles/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table>
		<tr>
			<td width="50">ID</td>
			<td width="340">用户名</td>
			<td width="240">操作</td>
		</tr>	
		<c:forEach var="user" items="${requestScope.userLi}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>
					<%if(Filters.isChildIgnoreCase(Constants.MANAGE,user.getPrivilege())){%>
						<a href="editUserForm.do?&id=${user.id}">编辑</a>
					<%} %>				
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="2"><c:out value="${requestScope.navigationBar}" escapeXml="false"/></td>
			</tr>				
		<c:out value="${requestScope.navigationBar}" escapeXml="false"/>
	</table>
</body>
</html>