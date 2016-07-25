<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addFile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function addUploadCount(){
			var div=document.getElementById("div");
			div.innerHTML+="<div><input type='file' name='f'><button onclick='removeUploadCount(this)'>移除</button><div>";
		}
		function removeUploadCount(bt){
			var div=document.getElementById("div");
			div.removeChild(bt.parentNode);
		}
	</script>
  </head>
  
  <body>
    <center>
    <button onclick="addUploadCount()">添加</button>
    	<form action="${pageContext.request.contextPath }/addFile" method="post" enctype="multipart/form-data">
    		<input type="file" name="f">
    		<div class="div"></div>
    	</form>
    </center>
  </body>
</html>
