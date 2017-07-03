<%@page import="com.cn.easybuy.dao.impl.UserDaoImpl"%>
<%@page import="com.cn.easybuy.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	UserDao userDao = new UserDaoImpl();
	userDao.deleUser(id);
	response.sendRedirect("manage-result.html");
%>


</body>
</html>