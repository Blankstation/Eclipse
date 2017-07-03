package com.cn.easybuy.entity;
/**
************************************
*@类名	Cart
*@时间	2017年6月30日 上午9:16:15
*@作者	rou
*@描述	购物车
************************************
*/
public class Cart {
private int id;
private String euUserid;
private int epId;
private int epQuantity;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEuUserid() {
	return euUserid;
}
public void setEuUserid(String euUserid) {
	this.euUserid = euUserid;
}
public int getEpId() {
	return epId;
}
public void setEpId(int epId) {
	this.epId = epId;
}
public int getEpQuantity() {
	return epQuantity;
}
public void setEpQuantity(int epQuantity) {
	this.epQuantity = epQuantity;
}
}
