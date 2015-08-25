<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
	String path=request.getContextPath();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>自强网新闻子网 - 管理后台</title>
</head>
<frameset rows="32,*" cols="*" frameborder="yes" border="1" framespacing="0" scrolling="auto">
  <frame src="<%=path%>/manage/frames/top.html" name="top" scrolling="No" noresize="noresize" id="top" title="top">
  <frameset cols="*,200" frameborder="yes" border="1" framespacing="0" scrolling="auto">
    <frame src="<%=path%>/manage/frames/main.html" name="main" id="main" title="main">
    <frame src="<%=path%>/manage/frames/nav.jsp" name="nav" scrolling="yes" id="nav" title="nav">
  </frameset>
</frameset>
<noframes>
<body>
对不起，您的浏览器不支持框架网页。
</body>
</noframes>
</html>