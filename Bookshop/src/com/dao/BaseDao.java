package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.DbInfo;
/**
*********************************************
*@����   BaseDao
*@ʱ��   2017��6��1�� ����10:44:44
*@����   guyan
*@����        ִ�����ݿ�����ĸ�����
*********************************************
*/
public class BaseDao {
	/*private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://172.16.100.31:3306/easybuy";
	private static final String USER="root";
	private static final String PWD="123456";*/
	
	//�������ݿ�
	protected Connection connection=null;
	//ִ��SQL����
	protected PreparedStatement pstmt=null;
	//�õ���ѯ�Ľ����
	protected ResultSet rs=null;
	
	/**
	 *�������ӷ���
	 */
	public void getConnection(){
		try {
			if(connection == null || connection.isClosed()){
				DbInfo db = DbInfo.newInstance();
				//��������
				Class.forName(db.getDriver());
				//�������Ӷ���
				connection=DriverManager.getConnection(db.getUrl(),db.getName(),db.getPwd());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ر����ӷ���
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
	 * ��ѯ����
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
	 * ��ɾ�ķ���
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
	 * ��������
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
