package com.cn.easybuy.dao;

import java.util.List;

import com.cn.easybuy.entity.Product_category;
import com.cn.easybuy.entity.Product_parent;

/**
******************************
*@类名 ProductCategoryDao
*@时间 2017年6月28日上午9:24:33
*@作者 lmy
*@描述 
******************************
*/
public interface ProductCategoryDao {
	public List<Product_category> getAllProductCategory();
	public boolean queryProductCatagory(String cname,int parentid);
	public int addCategory(String cname,int parentid);
	public int Updatecategory(int cid, String cname);
	
	public int deleCategory(int id);
	int deleCategory2(int id);
	// 产品总记录数
			public int getCount();

			// 得到数据
			public List<Product_category> getList(int pageIndex, int pageSize);
}
