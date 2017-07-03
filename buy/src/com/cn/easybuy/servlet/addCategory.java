package com.cn.easybuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.ProductCategoryDao;
import com.cn.easybuy.dao.impl.ProductCategoryDaoImpl;


public class addCategory extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int parentid = Integer.valueOf(request.getParameter("parentId"));
		String classname = request.getParameter("className");
		
		ProductCategoryDao category = new ProductCategoryDaoImpl();
		boolean flag = category.queryProductCatagory(classname, parentid);
		if(!flag){		
			category.addCategory(classname,parentid);
			response.sendRedirect("manage/manage-result.html");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
