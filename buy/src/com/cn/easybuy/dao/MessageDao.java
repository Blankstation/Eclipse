package com.cn.easybuy.dao;

import java.util.List;
import com.cn.easybuy.entity.Message;
import com.cn.easybuy.entity.News;

/**
 ************************************
 * @类名 MessageDao
 * @时间 2017年6月29日 上午10:58:06
 * @作者 rou
 * @描述
 ************************************
 */
public interface MessageDao {

	public List<Message> getAllMessage();

	public int addMessage(Message msg);

	public int deleteMessage(int magId);

	public int updateMessage(Message msg);

	public Message getMessage(int msgid);

	// 产品总记录数
	public int getCount();

	// 得到数据
	public List<Message> getList(int pageIndex, int pageSize);
}
