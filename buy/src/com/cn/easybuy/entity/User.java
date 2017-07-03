package com.cn.easybuy.entity;

import java.util.Date;

/**
************************************************
* @类名			User
* @时间  			2017年6月26日 下午11:52:33
* @作者  			lisir
* @版本			ver 1.0
* @描述 
************************************************ 
*/
public class User {
	private int euUserId;
 	private String euUserName;
	private String euName;
	private String euPassword;
	private String euSex;
	private Date euBirthday;
	private String euIdentityCode;
	private String euEmail;
	private String euMobile;
 	private String euAddress;
	private int euLogin;   //是否登录
	private int euStatus;  //状态
	
	public int getEuUserId() {
		return euUserId;
	}
	public void setEuUserId(int euUserId) {
		this.euUserId = euUserId;
	}
	public String getEuUserName() {
		return euUserName;
	}
	public void setEuUserName(String euUserName) {
		this.euUserName = euUserName;
	}
	
	public String getEuName() {
		return euName;
	}
	public void setEuName(String euName) {
		this.euName = euName;
	}
	public String getEuPassword() {
		return euPassword;
	}
	public void setEuPassword(String euPassword) {
		this.euPassword = euPassword;
	}
	public String getEuSex() {
		return euSex;
	}
	public void setEuSex(String euSex) {
		this.euSex = euSex;
	}
	public Date getEuBirthday() {
		return euBirthday;
	}
	public void setEuBirthday(Date euBirthday) {
		this.euBirthday = euBirthday;
	}
	public String getEuIdentityCode() {
		return euIdentityCode;
	}
	public void setEuIdentityCode(String euIdentityCode) {
		this.euIdentityCode = euIdentityCode;
	}
	public String getEuEmail() {
		return euEmail;
	}
	public void setEuEmail(String euEmail) {
		this.euEmail = euEmail;
	}
	public String getEuMobile() {
		return euMobile;
	}
	public void setEuMobile(String euMobile) {
		this.euMobile = euMobile;
	}
	public String getEuAddress() {
		return euAddress;
	}
	public void setEuAddress(String euAddress) {
		this.euAddress = euAddress;
	}
	public int getEuLogin() {
		return euLogin;
	}
	public void setEuLogin(int euLogin) {
		this.euLogin = euLogin;
	}
	public int getEuStatus() {
		return euStatus;
	}
	public void setEuStatus(int euStatus) {
		this.euStatus = euStatus;
	}
	

}
