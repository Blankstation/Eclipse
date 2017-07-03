package com.cn.easybuy.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cn.easybuy.dao.UserDao;
import com.cn.easybuy.entity.News;
import com.cn.easybuy.entity.User;
import com.cn.easybuy.util.BaseDao;


/**
************************************************
* @类名			UserDaoImpl
* @时间  			2017年6月26日 下午11:52:07
* @作者  			lisir
* @版本			ver 1.0
* @描述 
************************************************ 
*/

public class UserDaoImpl extends BaseDao implements UserDao {
	
	public int modifyUser(User user){
		int result = 0;
		String sql = "UPDATE easybuy_user SET eu_name = ?, eu_password = ?, eu_sex =?, "
				+ "eu_mobile =?, eu_address =?, eu_birthday=? where eu_user_id = ?;";
		Object[] params = {user.getEuName(),user.getEuPassword(), user.getEuSex(),
				user.getEuMobile(), user.getEuAddress(), user.getEuBirthday(),
				user.getEuUserId()};
		result=executeUpdate(sql,params);
		return result;
	}
	

	
	public int saveUser(User user) {
		int result=0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT into easybuy_user (eu_user_name,eu_name,eu_password,");
			sql.append(" eu_sex,eu_birthday,eu_identity_code,eu_email,eu_mobile,eu_address,eu_login) ");
			sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?) ");
			//
			Object[] params ={user.getEuUserName(),user.getEuName(),user.getEuPassword(),
					    user.getEuSex(),user.getEuBirthday(),user.getEuIdentityCode(),user.getEuEmail(),user.getEuMobile(),
					    user.getEuAddress(),user.getEuLogin()};		
			result=executeUpdate(sql.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return result;
	}

	public boolean queryUserByName(String name) {
		boolean flag= false;  //可以注册
		try {
			String sql="select * from easybuy_user where eu_user_name =?";
			Object[] params = {name};
			rs=executeQuery(sql, params);
			if(rs.next()){
				flag=true;  //查到，不能注册
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag;
	}

	public User queryUserByID(int id) {
		User user = new User();
		try {
			String sql="select eu_user_id,eu_user_name,eu_name,eu_sex,eu_birthday,eu_mobile,eu_address,eu_password from easybuy_user where eu_user_id =?";
			Object[] params = {id};
			rs=executeQuery(sql, params);
			if(rs.next()){
				user.setEuUserId(rs.getInt("eu_user_id"));
				user.setEuUserName(rs.getString("eu_user_name"));
				user.setEuName(rs.getString("eu_name"));
				user.setEuSex(rs.getString("eu_sex"));
				user.setEuBirthday(rs.getDate("eu_birthday"));
				user.setEuMobile(rs.getString("eu_mobile"));
				user.setEuAddress(rs.getString("eu_address"));
				user.setEuPassword(rs.getString("eu_password"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return user;
	}
	@Override
	public List<User> getAllUser() {
		List<User> list= new ArrayList<User>();
		try {
		String sql = "SELECT  eu_user_id,eu_user_name,eu_name,eu_sex,eu_email,eu_mobile,eu_password FROM easybuy_user";
		rs = executeQuery(sql);
			while(rs.next()){
				User user = new User();
				user.setEuUserId(rs.getInt("eu_user_id"));
				user.setEuUserName(rs.getString("eu_user_name"));
				user.setEuName(rs.getString("eu_name"));
				user.setEuSex(rs.getString("eu_sex"));
				user.setEuEmail(rs.getString("eu_email"));
				user.setEuMobile(rs.getString("eu_mobile"));
				user.setEuPassword(rs.getString("eu_password"));
				list.add(user);			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		
		return list;
	}



	@Override
	public int deleUser(int id) {
		int result = 0;
		String sql = "delete from easybuy_user where eu_user_id = ?;";
		Object[] params = {id};
		result = executeUpdate(sql, params);
		return result;
	}



	@Override
	public int getCount() {
		int result= 0;
		try {
			String sql="select count(1) as num from easybuy_user";
			rs = executeQuery(sql);
			if(rs.next()) {
				result=rs.getInt("num");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return result;
	}



	@Override
	public List<User> getList(int pageIndex, int pageSize) {
		List<User> list = new ArrayList<User>();
		try{
		String sql="SELECT  eu_user_id,eu_user_name,eu_name,eu_sex,eu_email,eu_mobile,eu_password FROM easybuy_user LIMIT ?,?";	//(公式：(pageIndex-1)*pageSize)
		Object[] params ={(pageIndex-1)*pageSize,pageSize};
		rs=executeQuery(sql,params);
		while(rs.next()){
			User user = new User();
			user.setEuUserId(rs.getInt("eu_user_id"));
			user.setEuUserName(rs.getString("eu_user_name"));
			user.setEuName(rs.getString("eu_name"));
			user.setEuSex(rs.getString("eu_sex"));
			user.setEuEmail(rs.getString("eu_email"));
			user.setEuMobile(rs.getString("eu_mobile"));
			user.setEuPassword(rs.getString("eu_password"));
			list.add(user);
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		this.closeAll();
	}	
	return list;
	}



	public int queryUser(User user) {
		int result = 0;
		try {
			String sql="SELECT eu_user_name,eu_password,eu_login FROM easybuy_user where eu_user_name=? and eu_password=?";
			Object [] params = {user.getEuUserName(),user.getEuPassword()};
			rs = executeQuery(sql, params);
			while(rs.next()) {
				result = 1;
				if(user.getEuLogin()==1) {
					result=2;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		
		return result;
	}

}
