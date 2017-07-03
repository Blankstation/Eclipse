package com.cn.easybuy.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.UserDao;
import com.cn.easybuy.dao.impl.UserDaoImpl;
import com.cn.easybuy.entity.User;

/**
 * Servlet implementation class doReg
 */

public class doReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防止乱码
		request.setCharacterEncoding("utf-8");
		//接受提交的参数
		String userid = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birth=null;
		try {
			birth = sdf.parse(birthday);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		String identityCode = request.getParameter("identityCode");
		
		String email="";
		if(request.getParameter("email")!=null){
			email = request.getParameter("email");
		}
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//构造user对象
		User user = new User();
		user.setEuUserName(userid);
		user.setEuName(userName);
		user.setEuSex(sex);
		user.setEuPassword(password);
		user.setEuBirthday(birth);
		user.setEuIdentityCode(identityCode);
		user.setEuEmail(email);
		user.setEuMobile(mobile);
		user.setEuAddress(address);
		//调用业务方法
		UserDao userDao = new UserDaoImpl();
		int result = userDao.saveUser(user);
		if(result!=0){
			//注册成功
			response.sendRedirect("reg-result.html");
		}else{
			//注册失败
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
