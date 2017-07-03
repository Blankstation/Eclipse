package com.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.UserDao;
import com.model.BuyInfo;
import com.model.User;
import com.util.Log;
import com.util.Page;

/**
*********************************************
*@����   UserBiz
*@ʱ��   2017��6��1�� ����9:38:40
*@����   guyan
*@����        �û���ҵ���߼�������
*********************************************
*/
public class UserBiz {
	public boolean validUserName(String uname){
		boolean flag = false;
		UserDao dao = new UserDao();
		try {
			flag=dao.validUserName(uname);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
		return flag;
	}
	public User login(String uname,String pwd){
		User user=null;
		UserDao dao = new UserDao();
		try {
			user = dao.login(uname, pwd);			
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
		return user;
	}
	public void register(User user){
		UserDao dao = new UserDao();
		try {
			dao.register(user);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
	}
	public List<BuyInfo> getBuyInfoList(String uname,Date bDate,Date eDate,Page pages){
		List<BuyInfo> list=new ArrayList<BuyInfo>();
		UserDao dao = new UserDao();
		try {
			list=dao.getBuyInfoList(uname,bDate,eDate,pages);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
		return list;
	}

}
