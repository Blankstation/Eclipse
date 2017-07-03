package com.cn.easybuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.ProductCategoryDao;
import com.cn.easybuy.dao.ProductParentDao;
import com.cn.easybuy.dao.impl.ProductCategoryDaoImpl;
import com.cn.easybuy.dao.impl.ProductParentDaoImpl;


public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryid = Integer.valueOf(request.getParameter("categoryId"));
		String classname = request.getParameter("className");
		
		ProductCategoryDao category = new ProductCategoryDaoImpl();
				
			category.Updatecategory(categoryid,classname);
			response.sendRedirect("manage/productClass.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
