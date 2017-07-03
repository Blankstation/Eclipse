package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
*********************************************
*@类名   BookRecord
*@时间   2017年6月9日 上午9:33:30
*@作者   guyan
*@描述
*********************************************
*/
public class BuyRecord {
	private int bid;
	private Date buyTime;
	private int usid;
	private double allmoney;
	private int allCount;
	private List<BuyDetail> details;

	public BuyRecord() {
		details = new ArrayList<BuyDetail>();
	}

	public List<BuyDetail> getDetails() {
		return details;
	}

	public void setDetails(List<BuyDetail> details) {
		this.details = details;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

	public int getUsid() {
		return usid;
	}

	public void setUsid(int usid) {
		this.usid = usid;
	}

	public double getAllmoney() {
		return allmoney;
	}

	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

}
