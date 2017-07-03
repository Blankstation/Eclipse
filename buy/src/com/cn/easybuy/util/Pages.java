package com.cn.easybuy.util;
/**
************************************************
* @类名			Pages
* @时间  			2017年6月26日 下午11:52:59
* @作者  			lisir
* @版本			ver 1.0
* @描述 
************************************************ 
*/

public class Pages {
	private int pageIndex;
	private int pageSize;
	private int pageCount;
	private int pageTotal;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		if(pageCount>0){
			this.pageCount = pageCount;
			
			this.pageTotal = this.pageCount%this.pageSize==0?this.pageCount/this.pageSize:this.pageCount/this.pageSize+1;
		}
		this.pageCount = pageCount;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
}
