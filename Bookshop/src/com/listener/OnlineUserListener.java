package com.listener;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.model.User;

/**
*********************************************
*@����   OnlineUserListener
*@ʱ��   2017��6��1�� ����10:14:27
*@����   guyan
*@����        ������  ��¼��������
*********************************************
*/
public class OnlineUserListener implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hs) {
		// TODO Auto-generated method stub
		Map<String, User> users; // StringΪSession id
		Object obj = hs.getSession().getServletContext().getAttribute("OnlineUsers");
		if (obj == null) {
			users = new HashMap<String, User>();
			users.put(hs.getSession().getId(), (User) hs.getSession().getAttribute("user"));
			hs.getSession().getServletContext().setAttribute("OnlineUsers", users);
		} else {
			users = (Map<String, User>) obj;
			users.put(hs.getSession().getId(), (User) hs.getSession().getAttribute("user"));
		}
		hs.getSession().getServletContext().setAttribute("OnLineCount", users.size());
		//hs.getSession().setMaxInactiveInterval(5);
	}

	public void sessionDestroyed(HttpSessionEvent hs) {
		// TODO Auto-generated method stub
		Map<String, User> users = (Map<String, User>) hs.getSession().getServletContext().getAttribute("OnlineUsers");
		users.remove(hs.getSession().getId());
		hs.getSession().getServletContext().setAttribute("OnLineCount", users.size());
	}

}
