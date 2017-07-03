package com.cn.easybuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.easybuy.dao.CartDao;
import com.cn.easybuy.dao.impl.CartDaoImpl;

/**
************************************
*@类名	addCart
*@时间	2017年6月30日 上午9:23:59
*@作者	rou
*@描述
************************************
*/
public class addCart extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	HttpSession session=request.getSession();
	//接收传递过来的参数  epid商品编号
	int epid=Integer.valueOf(request.getParameter("epid"));
	//String uname=(String)session.getAttribute("uname");//获得用户名
	String uname="sherry";
	//调用业务方法
	CartDao cart=new CartDaoImpl();
	boolean flag=cart.queryCart(uname, epid);//产讯是否购物车有数据
	if(flag){
		cart.updateCart(uname, epid);
	}else{
		cart.addCart(uname, epid);
	}
	response.sendRedirect("shopping.html?uname="+uname);//跳转购物车页面
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
