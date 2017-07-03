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
      pages.setPageSize(8);
      //调用业务方法实现得到总记录数
      NewsDao news=new NewsDaoImpl();
      int pageCount=news.getCount();//总记录数
      pages.setPageCount(pageCount);
      //得到相应页面数据
      NewsDao dao=new NewsDaoImpl();
      List<News>list= dao.getList(pageIndex,pages.getPageSize());
      session.setAttribute("pages1", pages);//分页参数
    //  session.setAttribute("list1", list);//分页数据
      response.sendRedirect("news.jsp");
    %>
