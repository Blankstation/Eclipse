package com.cn.easybuy.entity;
/**
******************************
*@类名 Product_category
*@时间 2017年6月28日上午9:21:41
*@作者 lmy
*@描述 
******************************
*/
public class Product_category {
	private int epcId;
	private String epcName;
	private int epcParentId;
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpcName() {
		return epcName;
	}
	public void setEpcName(String epcName) {
		this.epcName = epcName;
	}
	public int getEpcParentId() {
		return epcParentId;
	}
	public void setEpcParentId(int epcParentId) {
		this.epcParentId = epcParentId;
	}
}
