<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%@ page import="java.util.*" %>
<%@ page import="com.littleqworks.commons.util.*" %>
<%@ page import="com.littleqworks.commons.web.util.*" %>
<%@ page import="net.ziqiang.movie.service.*" %>
<%@ page import="net.ziqiang.movie.domain.movie.*" %>
<%@ page import="net.ziqiang.movie.domain.*" %>
<%
	String path=request.getContextPath();
	MovieService movieService=null;
	try{
		movieService=MovieServiceFactory.getMovieService();
		if(movieService==null){
			out.println("非法操作。");
			return;
		}
	}catch(Exception e){
		out.println("错误信息："+e.getMessage());
		return;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Navigation</title>
<link href="<%=path%>/styles/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table>
		<tr>
			<td></td>
			<td>
				<c:if test="${!empty sessionScope.currentUser.username}">
					欢迎您,<c:out value="${sessionScope.currentUser.username}"/>
				</c:if>
				<c:if test="${empty sessionScope.currentUser.username}">
					您还没有<a href="<%=path %>/loginForm.do" target=_parent>登录</a>
				</c:if>				
			</td>
		</tr>
		<tr>
			<td colspan="2">系统管理</td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;</td>
			<td><a href="<%=path %>/show_userlist.do" target="main">用户管理</a></td>
		</tr>
		<tr>
			<td colspan="2">内容管理</td>
		</tr>
		<%
				List<Category> categoryLi=movieService.getCategory();
				for(Category category:categoryLi){
		%>
		<tr>
			<td>&nbsp;&nbsp;</td>
			<td><a href="<%=path %>/show_movielist.do?bid=<%=category.getCategoryId() %>&status=0" target="main"><%=category.getName() %>(<%=movieService.getCountByBid(category.getCategoryId())%>)</a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="2"><a href="<%=path %>/logout.do" target="_main">注销</a></td>
		</tr>
	</table>
</body>
</html>