<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib  prefix="c" uri="/tags/c" %>
<%@ taglib uri="/tags/FCKeditor" prefix="FCK" %>
<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
	String path=request.getContextPath();
 %>
<html>
	<head>
		<title>
			自强后台管理_添加电影
		</title>
	<link href="<%=request.getContextPath()%>/styles/common.css" rel="stylesheet" type="text/css" />		
	<script type="text/javascript">
		function display(){
			var checkBox=document.getElementById("checkbox");
			var picture=document.getElementById("pic");
			
	
		
			if(checkBox.checked){
				
				picture.style.display="";
				
			}
			else{
				
				picture.style.display="none";
				picture.value="";
			}
			
		}
	</script>
	</head>
	<body>
		<html:form action="/insertMovie" enctype="multipart/form-data">
			<table border="0" width="100%">
				<tr>
					<td align="right">电影名字:</td>
					<td align="left">
						<html:text   property="movie.name"/>
						<html:errors property="movie.name"/>
					</td>
				</tr>
				<tr>
					<td align="right">电影分类:</td>
					<td align="left">	
						<html:select  property="movie.categoryId">
							<html:optionsCollection  property="categories" value="value" label="label"/>
						</html:select>
					</td>
				</tr>	
				<tr>
					<td align="right">状态:</td>
					<td align="left">					
						<html:select  property="movie.status">
							<html:optionsCollection  property="status"/>
						</html:select>
					</td>
				</tr>									
				<tr>
					<td align="right">电影类型:</td>
					<td align="left"><Not-Set>
						<html:text  property="movie.lei"/>
						<html:errors property="movie.lei"/>
					</td>
				</tr>			
				<tr>
					<td align="right">文件格式:</td>
					<td align="left">
						<html:text  property="movie.style"/>
						<html:errors property="movie.style"/>
					</td>
				</tr>				
				<tr>
					<td align="right">文件大小(M):</td>
					<td align="left">
						<html:text property="movie.size"/>
						<html:errors property="movie.size"/>
					</td>
				</tr>
				<tr>
					<td align="right">海报地址:</td>
					<td align="left">
						<html:text   property="movie.pic" size="30"/>&nbsp;&nbsp;<input type="checkbox" id="checkbox" name="piccheckbox" onclick="display()"/>显示上传(支持jpg,jpeg,bmp格式)
						<input type="file" name="theFile" style="display:none" id="pic"/>
						<html:errors property="movie.pic"/>
						<html:errors property="theFile"/>
					</td>
				</tr>				
				<tr>
					<td align="right">演员:</td>
					<td align="left">
						<html:text   property="movie.actor" size="50"/>
						<html:errors property="movie.actor"/>
					</td><Not-Set>
				</tr>
				<tr>
					<td align="right">下载主地址:</td>
					<td align="left">
						<html:text  property="movie.dir" size="60"/>
						<html:errors property="movie.dir"/>
					</td>
				</tr>					
				<tr>
					<td align="right">存放地址:</td>
					<td align="left">
						<html:textarea   property="movie.path" rows="5" cols="50"/>
						<html:errors property="movie.path"/>
					</td>
				</tr>
				<tr>
					<td align="right">电影简介:</td>
					<td align="left">
					<c:set var="path" value="<%=path %>" scope="page"/>
				<FCK:editor id="intro" basePath="${pageScope.path}/fckeditor/" width ="600" height ="400"
                                imageBrowserURL="/fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=connectors/jsp/connector"  
                                linkBrowserURL="/fckeditor/editor/filemanager/browser/default/browser.html?Connector=connectors/jsp/connector"  
                                flashBrowserURL="/fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=connectors/jsp/connector"  
                                imageUploadURL="/fckeditor/editor/filemanager/upload/simpleuploader?Type=Image"  
                                linkUploadURL="/fckeditor/editor/filemanager/upload/simpleuploader?Type=File"  
                                flashUploadURL="/fckeditor/editor/filemanager/upload/simpleuploader?Type=Flash">  
				</FCK:editor>
					</td>
				</tr>				
				<tr align="center">
					<td align="right"><html:submit value="提交"/></td>
					<td align="left"></td>
				</tr>				
			</table>
		</html:form>
	</body>
</html>