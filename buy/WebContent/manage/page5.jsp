<%@page import="com.cn.easybuy.entity.User"%>
<%@page import="com.cn.easybuy.dao.impl.UserDaoImpl"%>
<%@page import="com.cn.easybuy.dao.UserDao"%>
<%@page import="com.cn.easybuy.dao.impl.MessageDaoImpl"%>
<%@page import="com.cn.easybuy.dao.MessageDao"%>
<%@page import="com.cn.easybuy.entity.Message"%>
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
      pages.setPageSize(7);
      //调用业务方法实现得到总记录数
      MessageDao message=new MessageDaoImpl();
      int pageCount=message.getCount();//总记录数
      pages.setPageCount(pageCount);
      //得到相应页面数据
      UserDao dao=new UserDaoImpl();
      List<User>list= dao.getList(pageIndex,pages.getPageSize());
      session.setAttribute("pages5", pages);//分页参数
    //  session.setAttribute("list1", list);//分页数据
      response.sendRedirect("user.jsp");
    %>
