<%@page import="com.cn.easybuy.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.cn.easybuy.dao.impl.ProductDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductDao"%>
<%@page import="com.cn.easybuy.util.Pages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	int pageIndex=1;
	String pageNo = request.getParameter("pageIndex");
	if(pageNo  == null){
		pageIndex=1;
	}else{
		pageIndex = Integer.valueOf(pageNo); //点击上一页下一页
	}
	//创建pages类的对象
	Pages pages = new Pages();
	pages.setPageIndex(pageIndex);
	pages.setPageSize(8);
	//调用业务方法总记录数
	ProductDao product = new ProductDaoImpl();
	int pageCount = product.getCount();
	pages.setPageCount(pageCount);
	//得到相应页面数据
	ProductDao dao = new ProductDaoImpl();
	List<Product> list = dao.getList(pageIndex,pages.getPageSize()) ;//导包
	session.setAttribute("pages",pages);	//分页的参数
	session.setAttribute("list",list);	//分页数据
	response.sendRedirect("index.jsp");
%>