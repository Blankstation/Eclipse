<%@page import="com.cn.easybuy.entity.Product_category"%>
<%@page import="com.cn.easybuy.dao.impl.ProductCategoryDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductCategoryDao"%>
<%@page import="com.cn.easybuy.entity.Product_parent"%>
<%@page import="com.cn.easybuy.dao.impl.ProductParentDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductParentDao"%>
<%@page import="com.cn.easybuy.dao.impl.NewsDaoImpl"%>
<%@page import="com.cn.easybuy.entity.Product"%>
<%@page import="com.cn.easybuy.util.Pages"%>
<%@page import="com.cn.easybuy.entity.News"%>
<%@page import="java.util.List"%>
<%@page import="com.cn.easybuy.dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="welcomeImage">
		<img width="100%" height="150" src="images/banner.jpg" alt="welcome">
	</div>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="shopping.html" id="shoppingBag" class="shopping">购物车X件</a><a
				href="login.jsp"><%=session.getAttribute("uname")%>登录</a><a class="button" id="logout"
				href="javascript:void(0);">注销</a><a href="register.jsp">注册</a><a
				href="guestbook.jsp">留言</a><a href="manage/index.jsp">后台管理</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<div class="box">
				<h2>商品分类</h2>
				<dl>
				
				<%
				ProductParentDao productparentDao = new ProductParentDaoImpl();
				List<Product_parent> parent = productparentDao.queryProductParent();
				ProductCategoryDao productCategoryDao = new ProductCategoryDaoImpl();
				List<Product_category> category = productCategoryDao.getAllProductCategory();
				
				for (Product_parent p : parent) {
				%>
				
					<dt><%=p.getPartentName() %></dt>
					<%
					for (Product_category c : category) {
						if (c.getEpcParentId() == p.getParentId()) {
					%>
					<dd>
						<a href="product-list.jsp?pid=<%=c.getEpcId()%>"><%=c.getEpcName()%></a>
					</dd>
					
				
				<%
						}
					}
				}
				%>
				</dl>
			</div>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
					<dt>
						<img src="images/product/10_small.jpg" />
					</dt>
					<dd>
						<a href="product-view.html" target="_self">利仁2018M福满堂电饼铛 好用实惠</a><a
							href="product-view.html"></a>
					</dd>
					<dt>&nbsp;</dt>
					<dd>&nbsp;</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="price-off">
				<div class="slideBox">
					<ul id="slideBox">
						<li><img src="images/product/banner_1.jpg" /></li>
						<li><img src="images/product/banner_2.jpg" /></li>
						<li><img src="images/product/banner_3.jpg" /></li>
						<li><img src="images/product/banner_4.jpg" /></li>
					</ul>
				</div>
				<h2>商品列表</h2>
				<ul class="product clearfix">
					<%
						Pages pages = (Pages) session.getAttribute("pages");
						if (pages == null) {
							response.sendRedirect("page.jsp");
							return;
						} else {
							int pageIndex = pages.getPageIndex();
							int pageTotal = pages.getPageTotal();
							List<Product> list = (List<Product>) session.getAttribute("list");
							for (Product pp : list) {
					%>
					<li>
						<dl>
							<dt>
								<a href="product-view.jsp?epid=<%=pp.getEpId()%>" target="_self">
									<img src="<%=pp.getEpFileName()%>" />
								</a>
							</dt>
							<dd class="title">
								<a href="product-view.jsp?epid=<%=pp.getEpId()%>" target="_self"><%=pp.getEpName()%></a>
							</dd>
							<dd class="price">
								￥<%=pp.getEpPrice()%></dd>
						</dl>
					</li>
					<%
						}
						}
					%>
				</ul>
				<div id="page">
					[当前：<%=pages.getPageIndex()%>页/共<%=pages.getPageTotal()%>
					页]
					<%
					if (pages.getPageIndex() > 1) {
				%>

					<a href="page.jsp?pageIndex=1">首页</a> <a
						href="page.jsp?pageIndex=<%=pages.getPageIndex() - 1%>">上一页</a>
					<%
						}
						if (pages.getPageIndex() < pages.getPageTotal()) {
					%>
					<a href="page.jsp?pageIndex=<%=pages.getPageIndex() + 1%>">下一页</a>
					<a href="pageIndex=<%=pages.getPageTotal()%>">尾页</a>
					<%
						}
					%>
				</div>
			</div>
			<div class="side">
				<div class="spacer"></div>
				<div class="news-list">
					<h4>新闻动态</h4>
					<ul>
						<%
							NewsDao newsDao = new NewsDaoImpl();
							List<News> news = newsDao.getAllNews();
							for (News n : news) {
						%>
						<li><a href="news-view.jsp?en_id=<%=n.getEnId()%>"
							target="_self"> <%
 	if (n.getEnTiTle().length() >= 14) {
 %> <%=n.getEnTiTle().substring(0, 14) + "..."%> <%
 	} else {
 %> <%=n.getEnTiTle()%>
								<%
									}
								%>
						</a></li>
						<%
							}
						%>
					</ul>




					
				</div>
			</div>
			<div class="spacer clear"></div>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
