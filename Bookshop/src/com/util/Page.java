package com.util;
/**
*********************************************
*@����   Page
*@ʱ��   2017��6��9�� ����9:41:37
*@����   guyan
*@����
*********************************************
*/
public class Page {
	private int currentPageNo; //��ǰҳ
	private int pageSize;     //ÿҳ��¼��
	private int allCount;	 //�ܼ�¼��
	private int pageAllCount;    //��ҳ��
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
	//û��
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}

}
