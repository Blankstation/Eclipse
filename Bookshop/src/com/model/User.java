package com.model;
/**
*********************************************
*@����   User
*@ʱ��   2017��6��1�� ����10:18:57
*@����   
*@����
*********************************************
*/
public class User {
  private int id;
  private String uname;
  private String pwd;
  private int role;
  private double account;
public  int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public  String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getRole() {
	return role;
}
public void setRole(int role) {
	this.role = role;
}
public double getAccount() {
	return account;
}
public void setAccount(double account) {
	this.account = account;
}
}
