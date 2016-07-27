<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'wangpan.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
	<h3>网&nbsp;&nbsp;盘</h3>
	<c:if test="${resources.size()==0 }">
		<a href="${pageContext.servletContext.contextPath }/addFile.jsp">网盘空空如也，点击上传文件吧！</a>
	</c:if>
	<c:if test="${resources.size()!=0 }">	
		<div>
			<table width="70%" border="1" id="table">
				<tr>
					<td></td>
					<td>文件名</td>
					<td>保存位置</td>
					<td>上传时间</td>
					<td>描述</td>
					<td>操作<td>
				</tr>
				<c:forEach items="${resources }" var="rs">
					<tr>
						<td><input type="checkbox" name="ck" value="${rs.uuidname }"></td>
						<td>${rs.realname }</td>
						<td>${rs.savepath }</td>
						<td>${rs.uploadtime }</td>
						<td>${rs.description }</td>
						<td>
							<a href="${pageContext.request.contextPath }/download?uuidname=${rs.uuidname }">下载</a>&nbsp;&nbsp; 
							<a href="${pageContext.request.contextPath }/delete?uuidname=${rs.uuidname }">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="${pageContext.servletContext.contextPath }/addFile.jsp">点击上传文件</a>
	</c:if>
	</center>
</body>
</html>
