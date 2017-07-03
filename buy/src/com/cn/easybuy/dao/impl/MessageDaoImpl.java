package com.cn.easybuy.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cn.easybuy.dao.MessageDao;
import com.cn.easybuy.entity.Message;
import com.cn.easybuy.entity.News;
import com.cn.easybuy.util.BaseDao;

/**
************************************
*@类名	MessageDaoImpl
*@时间	2017年6月30日 下午3:42:18
*@作者	rou
*@描述
************************************
*/
public class MessageDaoImpl extends BaseDao implements MessageDao {

	@Override
	public List<Message> getAllMessage() {
		List<Message> list=new ArrayList<Message>();
		try {
			String sql="SELECT ec_id,ec_content,ec_create_time,ec_reply,ec_reply_time,ec_nick_name FROM easybuy_comment order by ec_create_time desc";
			rs=executeQuery(sql);
			while(rs.next()){
				Message msg=new Message();
				msg.setEcId(rs.getInt("ec_id"));
				msg.setEcContent(rs.getString("ec_content"));
				msg.setEcNickName(rs.getString("ec_nick_name"));
				msg.setEcCreateTime(rs.getDate("ec_create_time"));
				msg.setEcReply(rs.getString("ec_reply"));
				msg.setEcreplyTime(rs.getDate("ec_reply_time"));
				list.add(msg);
			}
		} catch (Exception e) {
			
		}finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int addMessage(Message msg) {
		int result=0;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date time=null;
		try {

			time=format.parse(format.format(date));
			String sql="insert into easybuy_comment (ec_content,ec_create_time,ec_nick_name) values (?,?,?) ";
			Object[] params={msg.getEcContent(),time,msg.getEcNickName()};
			result= executeUpdate(sql, params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
		
	}

	@Override
	public int deleteMessage(int msgId) {
		int result=0;
		try {
			String sql="delete from easybuy_comment where ec_id=?";
			Object[] params= {msgId};
			result=executeUpdate(sql, params);
		}catch (Exception e) {
			// TODO: handle exception
		    this.closeAll();
		}finally {
			
		}
		return result;
	}

	@Override
	public int updateMessage(Message msg) {
		// TODO Auto-generated method stub
		int result=0;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date time=null;
		try {
			time=format.parse(format.format(date));
			String sql="UPDATE easybuy_comment SET ec_reply=?,ec_reply_time=? WHERE ec_id=?";
			Object[] params={msg.getEcReply(),time,msg.getEcId()};
			result=executeUpdate(sql, params);
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					this.closeAll();
				}
				return result;
	}
	public Message getMessage(int msgid) {
		Message msg =null;
		try{
			//第一步sql语句
			String sql="SELECT ec_id,ec_content,ec_create_time,ec_reply,ec_reply_time,ec_nick_name FROM easybuy_comment where ec_id=?";
			Object[] params = {msgid};
			rs=executeQuery(sql,params);
			while(rs.next()){
				 msg=new Message();
				msg.setEcId(rs.getInt("ec_id"));
				msg.setEcContent(rs.getString("ec_content"));
				msg.setEcCreateTime(rs.getDate("ec_create_time"));
				msg.setEcReply(rs.getString("ec_reply"));
				msg.setEcreplyTime(rs.getDate("ec_reply_time"));
				msg.setEcNickName(rs.getString("ec_nick_name"));
			}
			
		}catch(Exception e){
			
		}finally{
			this.closeAll();//关闭连接
		}
		return msg;
	}

	@Override
	public int getCount() {
		int result= 0;
		try {
			String sql="select count(1) as num from easybuy_comment";
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
	public List<Message> getList(int pageIndex, int pageSize) {
		List<Message> list = new ArrayList<Message>();
		try{
		String sql="SELECT ec_id,ec_content,ec_create_time,ec_reply,ec_nick_name FROM easybuy_comment LIMIT ?,?";	//(公式：(pageIndex-1)*pageSize)
		Object[] params ={(pageIndex-1)*pageSize,pageSize};
		rs=executeQuery(sql,params);
		while(rs.next()){
			Message msg=new Message();
			msg.setEcId(rs.getInt("ec_id"));
			msg.setEcContent(rs.getString("ec_content"));
			msg.setEcNickName(rs.getString("ec_nick_name"));
			msg.setEcCreateTime(rs.getDate("ec_create_time"));
			msg.setEcReply(rs.getString("ec_reply"));
			list.add(msg);
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		this.closeAll();
	}	
	return list;		
	
	}
}
