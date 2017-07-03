package com.cn.easybuy.entity;

import java.util.Date;

/**
*********************************************
*@类名   News
*@时间   2017年6月27日 下午4:36:41
*@作者   guyan
*@描述        新闻实体类
*********************************************
*/
public class News {
	private int enId;//新闻编号
	private String enTiTle;//新闻标题
	private String enContent;//新闻内容
	private Date enCreateTime;//新闻创建时间
	public int getEnId() {
		return enId;
	}
	public void setEnId(int enId) {
		this.enId = enId;
	}
	public String getEnTiTle() {
		return enTiTle;
	}
	public void setEnTiTle(String enTiTle) {
		this.enTiTle = enTiTle;
	}
	public String getEnContent() {
		return enContent;
	}
	public void setEnContent(String enContent) {
		this.enContent = enContent;
	}
	public Date getEnCreateTime() {
		return enCreateTime;
	}
	public void setEnCreateTime(Date enCreateTime) {
		this.enCreateTime = enCreateTime;
	}
}
