package com.cn.easybuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.MessageDao;
import com.cn.easybuy.dao.impl.MessageDaoImpl;
import com.cn.easybuy.entity.Message;

/**
************************************
*@类名	MessageUpdateServlet
*@时间	2017年7月1日 上午11:23:19
*@作者	rou
*@描述
************************************
*/
public class MessageUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int ecid =Integer.valueOf(request.getParameter("mess")) ;
	    String ecReply=request.getParameter("replyContent");
	   // String ecContent=request.getParameter("ecContent");
	    Message msg=new Message();
	    msg.setEcId(ecid);
	    msg.setEcReply(ecReply);
	  //  msg.setEcContent(ecContent);
	    MessageDao msgdao=new MessageDaoImpl();
	    int result=msgdao.updateMessage(msg);
	    if(result!=0){
	    	response.sendRedirect("guestbook.jsp");
	    }else{
	    	request.getRequestDispatcher("guestbook-modify.jsp").forward(request,response);
	    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
