package com.cn.easybuy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cn.easybuy.dao.ProductCategoryDao;
import com.cn.easybuy.dao.ProductParentDao;
import com.cn.easybuy.entity.News;
import com.cn.easybuy.entity.Product_parent;
import com.cn.easybuy.util.BaseDao;

/**
************************************************
* @类名			ProductParentDaoImpl
* @时间  			2017年6月26日 下午11:52:07
* @作者  			lmy
* @描述 
************************************************ 
*/

public class ProductParentDaoImpl extends BaseDao implements ProductParentDao {

	
	public List<Product_parent> queryProductParent() {
		List<Product_parent> list = new ArrayList<Product_parent>();
		try {
			String sql = "SELECT epc_parent_id, epc_parent_name FROM easybuy_product_parent";
			rs = executeQuery(sql);
			while(rs.next()){
				Product_parent parent = new Product_parent();
				parent.setParentId(rs.getInt("epc_parent_id"));
				parent.setPartentName(rs.getString("epc_parent_name"));
				list.add(parent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}

	@Override
	public int Updateparent(int pid, String pname) {
		int result =0;
		try {
			String sql = "UPDATE easybuy_product_parent SET epc_parent_name=? WHERE epc_parent_id=?";
			Object[] params={pname,pid};
			result=executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}

	@Override
	public int deleteParent(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete from easybuy_product_parent where epc_parent_id=?";
		Object[] params = {id};
		result = executeUpdate(sql, params);
		ProductCategoryDao  pcd = new ProductCategoryDaoImpl();
		pcd.deleCategory2(id);
		return result;
	}

	

	

}
