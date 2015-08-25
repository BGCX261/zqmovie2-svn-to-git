<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@page import="com.littleqworks.commons.util.Filters"%>
<%@ page import="net.ziqiang.movie.domain.User" %>
<%@page import="net.ziqiang.movie.struts.Constants"%>
<%@ page import="net.ziqiang.movie.service.*" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%
	String path=request.getContextPath();
	User user=(User)session.getAttribute("currentUser");
	MovieService movieService=null;
	try{
		movieService=MovieServiceFactory.getMovieService();
		if(movieService==null){
			out.println("�Ƿ�������");
			return;
		}
	}catch(Exception e){
		out.println("������Ϣ��"+e.getMessage());
		return;
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>��Ӱ����</title>
	<link href="styles/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
		<%
			int bid=(request.getParameter("bid")==null)?-1:Integer.parseInt(request.getParameter("bid"));
			int status=(request.getParameter("status")==null)?0:Integer.parseInt(request.getParameter("status"));
		 %>	
	<div>
			<a href="insertMovieForm.do">����µ�Ӱ</a>
	</div>
	<br>
	<div>
		��ǿ��Ӱ ><a href="show_movielist.do?bid=<%=bid%>&status=0" target="main"><%=movieService.getCategoryNameById(bid)%></a>
	</div>
	<br>
	<div>
		<a href="show_movielist.do?bid=<%=bid%>&status=0">δ���</a>
		<a href="show_movielist.do?bid=<%=bid%>&status=2">�����</a>
		<br>
	</div>
	<div id="newslist">
		<table>
			<tr>
				<td width="50">ID</td>
				<td width="340">��Ӱ</td>
				<td width="240">����</td>
			</tr>
			<c:forEach var="movie" items="${requestScope.movieLi}">
				<tr>
					<td>${movie.id}</td>
					<td>${movie.name}</td>
					<td>
					<%if((status<2)&&(Filters.isChildIgnoreCase(Constants.VERIFY,user.getPrivilege()))){%>
						<a href="verify_movie.do?id=${movie.id}">���</a>
					<%} %>
					<%if(Filters.isChildIgnoreCase(Constants.EDIT,user.getPrivilege())){%>
						<a href="editMovieForm.do?id=${movie.id}">�༭</a>
					<%} %>
					<%if((Filters.isChildIgnoreCase(Constants.DELETE,user.getPrivilege()))){%>
						<a href="<%=path%>/manage/delete_or_not.jsp?id=${movie.id}">����ɾ��</a>
					<%} %> 				
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2"><c:out value="${requestScope.navigationBar}" escapeXml="false"/></td>
			</tr>
		</table>
	</div>
</body>
</html>