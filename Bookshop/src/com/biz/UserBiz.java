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
*@类名   UserBiz
*@时间   2017年6月1日 上午9:38:40
*@作者   guyan
*@描述        用户的业务逻辑处理类
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
