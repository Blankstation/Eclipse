<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<tr>
	<td align="right">管理员：${user.uname } <a href="<%=basePath%>userAction_logOut.action">退出</a></td>
</tr>
<tr>
<td align=center>
    <a href="bookAdminAction_addBookGet.action">新书上架</a> &nbsp; <a href="<%=basePath%>buyInfoAction_buyInfo.action">用户购买记录</a>
</td>
</tr>