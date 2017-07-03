<%@page import="com.cn.easybuy.entity.Product_category"%>
<%@page import="com.cn.easybuy.dao.impl.ProductCategoryDaoImpl"%>
<%@page import="com.cn.easybuy.dao.impl.ProductParentDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductCategoryDao"%>
<%@page import="com.cn.easybuy.entity.Product_parent"%>
<%@page import="com.cn.easybuy.dao.ProductParentDao"%>
<%@page import="com.cn.easybuy.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.cn.easybuy.dao.impl.ProductDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div id="logo">
			<img src="../images/logo.gif" />
		</div>
		<div class="help">
			<a href="../index.html">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="index.html">首页</a></li>
				<li><a href="user.html">用户</a></li>
				<li class="current"><a href="product.html">商品</a></li>
				<li><a href="order.html">订单</a></li>
				<li><a href="guestbook.html">留言</a></li>
				<li><a href="news.html">新闻</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<a href="user.jsp">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="productClass-add.jsp">新增</a></em><a
							href="productClass.jsp">分类管理</a>
					</dd>
					<dd>
						<em><a href="product-add.jsp">新增</a></em><a href="product.jsp">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="order.jsp">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="guestbook.jsp">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="news-add.jsp">新增</a></em><a href="news.jsp">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>修改商品</h2>
			<div class="manage">
				<form action="../UpdateProduct" method="get">
					<table class="form">
						<%
							int pid = Integer.valueOf(request.getParameter("pid"));
							ProductDao productDao = new ProductDaoImpl();
							List<Product> product = productDao.getAllProduct(pid); 
							for (Product p : product) {
						%>
						<tr>
							<td class="field">商品名称(*)：</td>
							<td><input type="text" class="text" name="productName"
								value="<%=p.getEpName()%>" /></td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td><input type="text" class="text" name="productDes"
								value="<%=p.getEpDescription()%>" /></td>
						</tr>
						<tr>
							<td class="field">所属分类：</td>
							<td><select name="parentId">
									<%
										ProductParentDao productparentDao = new ProductParentDaoImpl();
										List<Product_parent> parent = productparentDao.queryProductParent();
										ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();
										List<Product_category> category = productCategoryDao.getAllProductCategory();

										for (Product_parent pp : parent) {
									%>
									<option value="<%=pp.getParentId()%>"><%=pp.getPartentName()%></option>
									<%
											for (Product_category c : category) {
													if (c.getEpcParentId() == pp.getParentId()) {
									%>
									<option value="<%=c.getEpcParentId()%>">├
										<%=c.getEpcName()%></option>
									<%
													}
											}
										}
									%>
							</select></td>
						</tr>
						<tr>
							<td class="field">商品价格(*)：</td>
							<td><input type="text" class="text tiny" name="productPrice" value="<%=p.getEpPrice()%>"/>元</td>
						</tr>

						<tr>
							<td class="field">库存(*)：</td>
							<td><input type="text" class="text tiny" name="productStock" value="<%=p.getEpStock()%>"/></td>
						</tr>
						<tr>
							<td class="field">商品图片：</td>
							<td><input type="file" class="text" name="photo" value="<%=p.getEpFileName()%>"/></td>
						</tr>
						<tr>
							<input type="hidden" name="id" value="<%=pid %>"></input>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="确定" /></label></td>
						</tr>
						<%
						}
						%>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
