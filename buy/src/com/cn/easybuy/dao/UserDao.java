package com.cn.easybuy.dao;

import java.util.List;

import com.cn.easybuy.entity.News;
import com.cn.easybuy.entity.User;

/**
************************************************
* @类名			UserDao
* @时间  			2017年6月26日 下午11:50:56
* @作者  			lisir
* @版本			ver 1.0
* @描述 
************************************************ 
*/

public interface UserDao {
	public int modifyUser(User user); //用户修改
	public int saveUser(User user);  //用户注册
	public int deleUser(int id);
	public int queryUser(User user);
	public boolean queryUserByName(String name);
	public User queryUserByID(int id);
	public List<User> getAllUser();
	// 产品总记录数
		public int getCount();

		// 得到数据
		public List<User> getList(int pageIndex, int pageSize);
}
