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

/**
 * Servlet implementation class UpdateProduct
 */

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ep_id = Integer.parseInt( request.getParameter("id"));
		 String ep_name = request.getParameter("productName");
		 String ep_description = request.getParameter("productDes");
		 int epc_id = Integer.parseInt( request.getParameter("parentId"));
		 double productPrice = Double.valueOf(request.getParameter("productPrice"));
		 int productStock = Integer.parseInt( request.getParameter("productStock"));		
		 String photo = request.getParameter("photo");
		 
		 Product p = new Product();
		 p.setEpId(ep_id);
		 p.setEpName(ep_name);
		 p.setEpDescription(ep_description);
		 p.setEpcId(epc_id);
		 p.setEpPrice(productPrice);
		 p.setEpStock(productStock);
		 p.setEpFileName(photo);
		 
		 ProductDao pd = new ProductDaoImpl();
		 int result = pd.updateProduct(p);
		 if(result > 0)
		 response.sendRedirect("manage/manage-product-del-result.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
