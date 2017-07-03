<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();//当前项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";//http://localhost:8080/Bookshop
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkInput(){
	var uname = document.getElementById("uname").value;
	var pwd=document.getElementById("pwd").value;
	if(uname==null||uname==""){
		document.getElementById("umsg").innerHTML="用户名不能为空";
		return false;
	}
	else if(pwd==null||pwd==""){
		document.getElementById("pmsg").innerHTML="密码不能为空";
		return false;
	}
	else{
		return true;
	}
	
}	
</script>
</head>
<body>
<center>
	<form action="<%=basePath %>userAction_login.action" method="post" onsubmit="return checkInput()">
		<table width="50%" border="0">
			<tr>
				<td>用户名</td> 
				<td><input type="text" id="uname" name="uname" /><span id="umsg" style="color:red;"></span>${msg }</td> 
			</tr>
			<tr>
				<td>密码</td> 
				<td><input type="password" id="pwd" name="pwd" /><span id="pmsg" style="color:red;"></span></td> 
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"/></td> 
			</tr>
		</table>
	</form>
	</center>
</body>
</html>