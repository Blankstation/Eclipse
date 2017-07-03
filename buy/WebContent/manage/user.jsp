<%@page import="com.cn.easybuy.util.Pages"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cn.easybuy.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.cn.easybuy.dao.impl.UserDaoImpl"%>
<%@page import="com.cn.easybuy.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClass.jsp">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<%-- <%
					UserDao userDao = new UserDaoImpl();
					List<User> list = new ArrayList<User>();
					list = userDao.getAllUser();
					for(User user:list){
				%> --%>
				<%
					Pages pages=(Pages)session.getAttribute("pages5");
					if(pages==null){
					response.sendRedirect("page5.jsp");
					return;
					}else{
					int pageIndex = pages.getPageIndex();
					int pageTotal = pages.getPageTotal();
					UserDao userDao=new UserDaoImpl();
					List<User> user=userDao.getList(pageIndex,pages.getPageSize());
					for(User u:user){

					%>
				
				<tr>
					<td class="first w4 c"><%=u.getEuUserName() %></td>
					<td class="w1 c"><%=u.getEuName() %></td>
					<td class="w2 c"><%=u.getEuSex() %></td>
					<td><%=u.getEuEmail() %></td>
					<td class="w4 c"><%=u.getEuMobile() %></td>
					<td class="w1 c">
					<% String userID =  "" + u.getEuUserId();
					 %>
					 <%String testString = "user-modify.jsp?id="+userID ;%>
					<a href="<%=testString%>" >修改</a> <a class="manageDel" href="user-delete.jsp?id=<%=u.getEuUserId()%>">删除</a></td>
					
				</tr>
				<%} }%>
			</table>
		</div>
	</div>
	<div class="clear"></div>
     <div id="page">

[当前：<%=pages.getPageIndex() %>页/共<%=pages.getPageTotal() %> 页]
<%
if(pages.getPageIndex()>1){
%>

<a href="page5.jsp?pageIndex=1">首页</a>
<a href="page5.jsp?pageIndex=<%=pages.getPageIndex()-1 %>">上一页</a>
<%
}if(pages.getPageIndex()<pages.getPageTotal()){ %>
<a href="page5.jsp?pageIndex=<%=pages.getPageIndex()+1 %>">下一页</a>
<a href="page5.jsp?pageIndex=<%=pages.getPageTotal() %>">尾页</a>
<%} %>
</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
