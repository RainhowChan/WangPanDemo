<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.loginDiv{
			display:inline-block;
			width:auto;
			border: red solid 1px;
			padding:10px;
		}
	</style>
  </head>
  
  <body>
    <center>
    <div class="loginDiv" align="left">
   	<h3>用户登录</h3>
    <form action="${pageContext.request.contextPath }/login" method="post" id="form1">
    		昵称：<input type="text" name="username" onblur="checkInputName(this.value)"><br><br>
    		密码：<input type="password" name="password" onblur="checkInputPassword(this.value)"><br><br>
    		性别：<input type="radio" name="gender" value="0" checked="checked">男<input type="radio" name="gender" value="1">女<br><br>
    		描述：<textarea rows="5" cols="50"></textarea><br><br>
    		<input type="button" value="登录" onclick="onSubmit()">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">	
    	</form>
    </div>
    	
    </center>
  </body>
  <script type="text/javascript">
  	var flag=false;
  	function checkInputName(name){
  		if(name.length<2){
  			alert("昵称不能少于2位");
  			name="";
  			flag=false;
  		}else{
  			flag=true;
  		}
  	}
  	
  	function checkInputPassword(password){
  		if(password.length<6||password.length>15){
  			alert("密码长度不符合规范！");
  			password="";
  			flag=false;	
  		}else{
  			flag=true;
  		}
  			
  	}
  	
  	function onSubmit(){
  		if(getFlag()){
  			document.getElementById("form1").submit();
  		}
  	}
  	
  	function getFlag(){
  		return flag;
  	}
  </script>
</html>
