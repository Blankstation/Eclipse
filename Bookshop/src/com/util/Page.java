package com.util;
/**
*********************************************
*@类名   Page
*@时间   2017年6月9日 上午9:41:37
*@作者   guyan
*@描述
*********************************************
*/
public class Page {
	private int currentPageNo; //当前页
	private int pageSize;     //每页记录数
	private int allCount;	 //总记录数
	private int pageAllCount;    //总页数
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getAllCount() {
		return allCount;
	}
	public void setAllCount(int allCount) {
		if(allCount>0){
			this.allCount = allCount;
		}
		this.pageAllCount=allCount%pageSize!=0?allCount/pageSize+1:allCount/pageSize;
	}
	public int getPageAllCount() {
		return pageAllCount;
	}
	//没用
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}

}
