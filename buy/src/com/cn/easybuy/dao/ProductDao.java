package com.cn.easybuy.dao;

import java.util.List;

import com.cn.easybuy.entity.Product;

/**
******************************
*@类名 ProductDao
*@时间 2017年6月29日下午3:12:10
*@作者 lmy
*@描述 
******************************
*/
public interface ProductDao {
	//产品总记录数
		public int getCount();
		//得到数据
		public List<Product> getList(int pageIndex,int pageSize);
		
		public List<Product> getAllProduct(int pid);
		
		public List<Product> queryProduct();
		
		public int addProduct(Product product);
		
		public int updateProduct(Product product);
		
		public int deleteProduct(int id);
}
