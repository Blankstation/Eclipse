package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Message;
import com.util.DBUtil;

public class MessageDaoImpl implements MessageDao {
	
	DBUtil dbUtil = new DBUtil();
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	public int writing(Message message, String username) {
		int rows=0;
		try {
			connection=dbUtil.getConnexction();
			String sql="insert into message (name,content) values (?,?) ";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, message.getName());
			preparedStatement.setString(2, message.getContent());
			rows=preparedStatement.executeUpdate();
			dbUtil.closeDBResources(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}


	public List<Message> fetchAllmoodinfo() {
		List<Message> messageList=null;
		try {
			connection=dbUtil.getConnexction();
			String sql="select * from message ";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			messageList=new ArrayList<Message>();
			while (resultSet.next()) {
				Message message=new Message();
				message.setName(resultSet.getString("name"));	
				message.setContent(resultSet.getString("content"));				
				messageList.add(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return messageList;
	
	}


}
