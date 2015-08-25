<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%@ taglib uri="/tags/CheckBox" prefix="checkbox"%>
<%@ page contentType="text/html; charset=gb2312" language="java"%>
<html>
	<head>
		<title>
			自强后台管理_用户权限管理
		</title>
	<link href="<%=request.getContextPath()%>/styles/common.css" rel="stylesheet" type="text/css" />		
	</head>
	<body>
		<html:form action="/editUser">
			<table border="0" width="100%">
				<tr>
					<td align="right">ID:</td>
					<td align="left"><c:out value="${sessionScope.editUserForm.user.id}"/></td>
					<input type="hidden" name="id" value="${sessionScope.editUserForm.user.id}"/>
				</tr>
				<tr>
					<td align="right">用户名:</td>
					<td align="left"><c:out value="${sessionScope.editUserForm.user.username}"/></td>
				</tr>
				<tr>
					<td align="right">用户权限:</td>
					<td align="left">
						<checkbox:privilege/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><html:submit value="确认修改"/></td>
				</tr>
			</table>
		</html:form>
	</body>
</html>