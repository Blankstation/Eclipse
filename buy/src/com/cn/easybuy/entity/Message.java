package com.cn.easybuy.entity;

import java.util.Date;

/**
************************************
*@类名	Message
*@时间	2017年6月29日 上午10:50:34
*@作者	rou
*@描述
************************************
*/
public class Message {
private int ecId;
private String ecContent;
private Date ecCreateTime;
private String ecReply;
private Date ecreplyTime;
private String ecNickName;
public int getEcId() {
	return ecId;
}
public void setEcId(int ecId) {
	this.ecId = ecId;
}
public String getEcContent() {
	return ecContent;
}
public void setEcContent(String ecContent) {
	this.ecContent = ecContent;
}
public Date getEcCreateTime() {
	return ecCreateTime;
}
public void setEcCreateTime(Date ecCreateTime) {
	this.ecCreateTime = ecCreateTime;
}
public String getEcReply() {
	return ecReply;
}
public void setEcReply(String ecReply) {
	this.ecReply = ecReply;
}
public Date getEcreplyTime() {
	return ecreplyTime;
}
public void setEcreplyTime(Date ecreplyTime) {
	this.ecreplyTime = ecreplyTime;
}
public String getEcNickName() {
	return ecNickName;
}
public void setEcNickName(String ecNickName) {
	this.ecNickName = ecNickName;
}

}
