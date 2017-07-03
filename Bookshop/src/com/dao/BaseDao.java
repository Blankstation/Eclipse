package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DbInfo;
/**
*********************************************
*@类名   BaseDao
*@时间   2017年6月1日 上午10:44:44
*@作者   guyan
*@描述        执行数据库操作的辅助类
*********************************************
*/
public class BaseDao {
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://172.16.100.31:3306/easybuy";
	private static final String USER="root";
	private static final String PWD="123456";*/
	
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
			if(connection == null || connection.isClosed()){
				DbInfo db = DbInfo.newInstance();
				//加载驱动
				Class.forName(db.getDriver());
				//创建连接对象
				connection=DriverManager.getConnection(db.getUrl(),db.getName(),db.getPwd());
			}
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
	/**
	 * 处理事务
	 */
	public  void beginTransaction() throws Exception{
		getConnection();
		this.connection.setAutoCommit(false);
	}
	public  void commit() throws Exception{
		
		if(this.connection != null)
			this.connection.commit();
		
	}
	
	public void rollback() throws Exception{
		if(this.connection != null){
			this.connection.rollback();
		}		
	}
}
