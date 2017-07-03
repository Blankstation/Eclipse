package com.cn.easybuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.cn.easybuy.dao.UserDao;
import com.cn.easybuy.dao.impl.UserDaoImpl;
import com.cn.easybuy.entity.User;


public class doLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("userId");
		String pwd = request.getParameter("password");
		
		if(username==""||username==null) {
			username="";
		}
		if(pwd==""||pwd==null) {
			pwd="";
		}
		User user = new User();
		UserDao userDao = new UserDaoImpl();
		
		user.setEuUserName(username);
		user.setEuPassword(pwd);
		int flag = userDao.queryUser(user);
		if(flag==1) {
			request.getSession().setAttribute("uname", username);
			response.sendRedirect("index.jsp");
		}else if(flag==2) {
			request.getSession().setAttribute("uname", username);
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
