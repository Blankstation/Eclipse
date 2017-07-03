<%@page import="com.cn.easybuy.entity.Product_parent"%>
<%@page import="com.cn.easybuy.dao.impl.ProductParentDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductParentDao"%>
<%@page import="com.cn.easybuy.dao.impl.ProductCategoryDaoImpl"%>
<%@page import="com.cn.easybuy.dao.ProductCategoryDao"%>
<%@page import="com.cn.easybuy.entity.Product_category"%>
<%@page import="com.cn.easybuy.entity.News"%>
<%@page import="com.cn.easybuy.dao.impl.NewsDaoImpl"%>
<%@page import="com.cn.easybuy.dao.NewsDao"%>
<%@page import="java.util.List"%>
<%@page import="com.cn.easybuy.util.Pages"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
      request.setCharacterEncoding("utf-8");
      
      int pageIndex=1;
      String pageNo=request.getParameter("pageIndex");
      if(pageNo==null){
    	  pageIndex=1;
      }else{
    	  pageIndex=Integer.valueOf(pageNo);//点击上/下一页
      }
      //创建pages类对象
      Pages pages=new Pages();
      pages.setPageIndex(pageIndex);
      pages.setPageSize(5);
      //调用业务方法实现得到总记录数
      NewsDao news=new NewsDaoImpl();
      int pageCount=news.getCount();//总记录数
      pages.setPageCount(pageCount);
      //得到相应页面数据 
      ProductCategoryDao dao=new ProductCategoryDaoImpl();
      List<Product_category>list= dao.getList(pageIndex,pages.getPageSize());
      session.setAttribute("pages4", pages);//分页参数
    //  session.setAttribute("list1", list);//分页数据
      response.sendRedirect("productClass.jsp");
    %>
