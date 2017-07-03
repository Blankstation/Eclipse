package com.cn.easybuy.entity;
/**
*************************************************
*@类名       Product
*@时间       2017年6月28日上午11:11:31
*@作者       z
*@描述
*************************************************
*/
public class Product {
	private int epId;	//商品编号
	private String epName;	//商品名称
	private String epDescription;	//商品描述
	private Double epPrice;	//商品价格
	private int epStock;	//商品库存
	private int epcId;	//子类标号
	private String epFileName;	//图片名称
	public int getEpId() {
		return epId;
	}
	public void setEpId(int epId) {
		this.epId = epId;
	}
	public String getEpName() {
		return epName;
	}
	public void setEpName(String epName) {
		this.epName = epName;
	}
	public String getEpDescription() {
		return epDescription;
	}
	public void setEpDescription(String epDescription) {
		this.epDescription = epDescription;
	}
	public Double getEpPrice() {
		return epPrice;
	}
	public void setEpPrice(Double epPrice) {
		this.epPrice = epPrice;
	}
	public int getEpStock() {
		return epStock;
	}
	public void setEpStock(int epStock) {
		this.epStock = epStock;
	}
	public int getEpcId() {
		return epcId;
	}
	public void setEpcId(int epcId) {
		this.epcId = epcId;
	}
	public String getEpFileName() {
		return epFileName;
	}
	public void setEpFileName(String epFileName) {
		this.epFileName = epFileName;
	}

}
