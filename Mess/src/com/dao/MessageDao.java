package com.dao;

import java.util.List;

import com.bean.Message;

public interface MessageDao {
	int writing(Message message, String username);
	List<Message> fetchAllmoodinfo();
}
