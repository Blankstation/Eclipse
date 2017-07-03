package com.cn.easybuy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 ********************************
 *@类名  BaseDao
 *@时间 2017年6月27日上午11:22:09
 *@作者 lmy
 *@描述   对数据库增删改的封装类
 ********************************
 */

public class BaseDao {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/buy?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER="root";
	private static final String PWD="000000";
	
	//连接数据库
	protected Connection connection=null;
	//执行SQL命令
	protected PreparedStatement pstmt=null;
	//得到查询的结果集
	protected ResultSet rs=null;
	
	/**
	 *创建连接方法
	 */
	public void getConnection(){
		try {
			//加载驱动
			Class.forName(DRIVER);
			//创建连接对象
			connection=DriverManager.getConnection(URL,USER,PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭连接方法
	 */
	public void closeAll(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询方法
	 */
	public ResultSet executeQuery(String sql,Object...params){
		try {
			getConnection();
			pstmt=connection.prepareStatement(sql);
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((i+1), params[i]);
				}
			}
			rs=pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 增删改方法
	 */
	public int executeUpdate(String sql,Object...params){
		int result=0;
		try {
			getConnection();
			pstmt=connection.prepareStatement(sql);	
			if(params!=null){
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject((i+1), params[i]);
				}
			}
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
