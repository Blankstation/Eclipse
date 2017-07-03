package com.cn.easybuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.ProductDao;
import com.cn.easybuy.dao.impl.ProductDaoImpl;
import com.cn.easybuy.entity.Product;


public class addProduct extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String pname = request.getParameter("productName");
		String pdetail = request.getParameter("productDetail");
		int parentid = Integer.valueOf(request.getParameter("parentId"));
		Double pprice =Double.valueOf(request.getParameter("productPrice"));
		int pnumber = Integer.valueOf(request.getParameter("productNumber"));
		String pphoto = request.getParameter("photo");
		
		Product product = new Product();
		product.setEpName(pname);
		product.setEpDescription(pdetail);
		product.setEpcId(parentid);
		product.setEpPrice(pprice);
		product.setEpStock(pnumber);
		product.setEpFileName(pphoto);
		ProductDao productDao = new ProductDaoImpl();
		int flag = productDao.addProduct(product);
		response.sendRedirect("manage/product.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
