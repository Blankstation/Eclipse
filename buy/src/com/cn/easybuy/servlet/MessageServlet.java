package com.cn.easybuy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.MessageDao;
import com.cn.easybuy.dao.impl.MessageDaoImpl;
import com.cn.easybuy.entity.Message;

/**
************************************
*@类名	Message
*@时间	2017年6月30日 下午2:40:48
*@作者	rou
*@描述
************************************
*/
public class MessageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public MessageServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ecContent=request.getParameter("guestContent");
		String ecNickName=request.getParameter("guestName");
		//String ecCreateTime=request.getParameter("ecCreateTime");
		Message msg=new Message();
		msg.setEcContent(ecContent);
		msg.setEcNickName(ecNickName);
		//msg.setEcCreateTime(new Date());
		MessageDao msgdao=new MessageDaoImpl();
		int result= msgdao.addMessage(msg);
		if(result!=0){
			response.sendRedirect("guestbook.jsp");
		}else{
			response.sendRedirect("guestbook.jsp");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest reques, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(reques, response);
	}
	
}
