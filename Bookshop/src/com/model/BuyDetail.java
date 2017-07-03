package com.model;
/**
*********************************************
*@类名   BuyDetail
*@时间   2017年6月9日 上午9:34:24
*@作者   
*@描述
*********************************************
*/
public class BuyDetail {
	private int id;
	private String isbn;
	private int buyid;
	private int count;
	private double dprice;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getBuyid() {
		return buyid;
	}
	public void setBuyid(int buyid) {
		this.buyid = buyid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}

}
