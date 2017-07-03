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
</head>
<body>
在线人数：${OnLineCount }
	<c:if test="${user!=null }">
		欢迎:${user.uname } &nbsp;&nbsp;<a href="#">购物车</a>
		<a href="<%=basePath%>userAction_logOut.action">退出</a>
		<c:if test="${user.role == '1' }">
			<a href="<%=basePath%>bookAdminAction_addBookGet.action">后台</a>
		</c:if>
	</c:if>
	<c:if test="${user==null }">
		<a href="<%=basePath%>userAction_loginGet.action">登录</a>
		<a href="<%=basePath%>userAction_registerGet.action">注册</a>
	</c:if>
</body>
</html>