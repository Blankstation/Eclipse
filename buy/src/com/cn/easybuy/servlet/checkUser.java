package com.cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.cn.easybuy.dao.UserDao;
import com.cn.easybuy.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class checkUser
 */

public class checkUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//获得数据
		String uname=request.getParameter("uname");
		//调用业务方法
		UserDao userDao=new UserDaoImpl();
		boolean flag=userDao.queryUserByName(uname);
		if(uname==null||uname.equals("")){
			out.print("");
		}else{
			if(flag){
				out.print("用户名存在");
			}else{
				out.print("可以注册");
			}
		}
	}

}
