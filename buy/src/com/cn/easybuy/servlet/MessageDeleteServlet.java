package com.cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.MessageDao;
import com.cn.easybuy.dao.impl.MessageDaoImpl;
import com.cn.easybuy.entity.Message;

/**
 ************************************
 * @类名 MessageDeleteServlet
 * @时间 2017年7月1日 上午11:30:04
 * @作者 rou
 * @描述
 ************************************
 */
public class MessageDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html; charset=utf-8");
		int ecid = Integer.valueOf(request.getParameter("mess"));

		Message msg = new Message();
		msg.setEcId(ecid);
		MessageDao msgdao = new MessageDaoImpl();
		int result = msgdao.deleteMessage(ecid);
		if (result != 0) {
			response.sendRedirect("guestbook.jsp");
		} else {
			out.print("<script>alert('删除失败')</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
