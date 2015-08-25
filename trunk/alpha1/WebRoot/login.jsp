<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%
	String from=request.getParameter("from")==null?"manage/index.html":request.getParameter("from");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  xml:lang="zh-CN" lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>自强电影 - 登录</title>
	<meta name="Keywords" content="自强电影" />
	<meta name="Description" content="自强电影" />
	<meta name="robots" content="index, follow" />
	<meta name="googlebot" content="index, follow" />
	<link href="styles/common.css" rel="stylesheet" type="text/css" />
	<link href="styles/login.css" rel="stylesheet" type="text/css" />
	<link href="styles/newslist.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src='scripts/lib/prototype.js'></script>
</head>
<body>
	<div id="container">
		<div id="main">
			<div id="colum1">
				<div id="image1">
					<img src="images/ziqiangnews.gif"/>
				</div>
				<div id="text1">
					&nbsp;<a href="http://movie.ziqiang.net/">电影中心</a> > 登录
				</div>
			</div>
			
			<div id="colum2">
					<div id="login">
						<html:form action="/login">
							<table border="0">
								<tr>
									<td colspan=2><font style="font-size:16px;">登录</font></td>
								</tr>
								<tr>
									<td>用户名：</td>
									<td>
										<html:text property="username"/>
										<html:errors property="username"/>
										<html:errors property="notexist"/>
									</td>
								</tr>
								<tr>
									<td>密码：</td>
									<td>
										<html:password property="password"/>
										<html:errors property="password"/>
										<html:errors property="invalidate"/>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<input name="from" type="hidden" value="<%=from %>" />
										<html:submit>提交</html:submit>
										<input name="reset" type="reset" value="重置" />
									</td>
								</tr>
							</table>
						</html:form>
					</div>
			</div>
		</div>
	</div>

	<div id="footer">
	</div>
</body>
</html>
