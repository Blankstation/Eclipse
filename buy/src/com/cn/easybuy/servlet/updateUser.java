package com.cn.easybuy.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.UserDao;
import com.cn.easybuy.dao.impl.UserDaoImpl;
import com.cn.easybuy.entity.User;

public class updateUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String name = request.getParameter("name");
		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		Date birth = new Date();
		birth.setYear(Integer.parseInt(birthyear));
		birth.setMonth(Integer.parseInt(birthmonth));
		birth.setDate(Integer.parseInt(birthday));
	
		User user = new User();
		
		user.setEuUserId(Integer.parseInt(id));
		user.setEuName(userName);
		user.setEuName(name);
		user.setEuPassword(passWord);
		user.setEuSex(sex);
		user.setEuBirthday(birth);
		user.setEuMobile(mobile);
		user.setEuAddress(address);
		
		UserDao userDao = new UserDaoImpl();
		userDao.modifyUser(user);
		
		response.sendRedirect("manage/manage-result.html");
		
		
	}
	
}
