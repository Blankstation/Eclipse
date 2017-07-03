package com.cn.easybuy.dao;

import java.util.List;

import com.cn.easybuy.entity.News;
import com.cn.easybuy.entity.Product_parent;

/**
******************************
*@类名 ProductParentDao
*@时间 2017年6月27日上午11:22:09
*@作者 lmy
*@描述 
******************************
*/
public interface ProductParentDao {
	public List<Product_parent> queryProductParent();
	public int Updateparent(int pid, String pname);
	
	public int deleteParent(int id);
	
}
