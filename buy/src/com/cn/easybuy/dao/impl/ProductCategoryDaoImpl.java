package com.cn.easybuy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cn.easybuy.dao.ProductCategoryDao;
import com.cn.easybuy.entity.Product_category;
import com.cn.easybuy.entity.Product_parent;
import com.cn.easybuy.util.BaseDao;

/**
******************************
*@类名 ProductCategoryDaoImpl
*@时间 2017年6月28日上午9:27:53
*@作者 lmy
*@描述 
******************************
*/
public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {

	@Override
	public List<Product_category> getAllProductCategory() {
		List<Product_category> list = new ArrayList<Product_category>();
		try {
			String sql = "SELECT epc_id, epc_name, epc_parent_id FROM easybuy_product_category";
			rs = executeQuery(sql);
			while(rs.next()){
				Product_category category = new Product_category();
				category.setEpcId(rs.getInt("epc_id"));
				category.setEpcName(rs.getString("epc_name"));
				category.setEpcParentId(rs.getInt("epc_parent_id"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return list;
	}

	
	public boolean queryProductCatagory(String cname, int parentid) {
		boolean result = false;
		try {
			String sql = "SELECT * FROM easybuy_product_category WHERE epc_name=? AND epc_parent_id=?";
			Object[] params = {cname, parentid};
			rs = executeQuery(sql, params);
			while(rs.next()){
				 result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}

	
	public int addCategory(String cname, int parentid) {
		int result=0;
		try {
			String sql = "INSERT INTO easybuy_product_category (epc_name,epc_parent_id) VALUES (?,?)";
			Object[] params = {cname, parentid};
			result += executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}


	@Override
	public int Updatecategory(int cid, String cname) {
		int result=0;
		try {
			String sql = "UPDATE easybuy_product_category SET epc_name=? WHERE epc_id=?";
			Object[] params={cname,cid};
			result=executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}


	@Override
	public int deleCategory(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete from easybuy_product_category where epc_id=?";
		Object[] params = {id};
		result = executeUpdate(sql, params);
		return result;
	}
	
	
	@Override
	public int deleCategory2(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete from easybuy_product_category where epc_parent_id=?";
		Object[] params = {id};
		result = executeUpdate(sql, params);
		return result;
	}


	@Override
	public int getCount() {
		int result= 0;
		try {
			String sql="select count(1) as num from easybuy_product_category";
			rs = executeQuery(sql);
			if(rs.next()) {
				result=rs.getInt("num");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return result;
	}


	@Override
	public List<Product_category> getList(int pageIndex, int pageSize) {
		List<Product_category> list = new ArrayList<Product_category>();
		try{
		String sql="SELECT epc_id,epc_name,epc_parent_id FROM easybuy_product_category LIMIT ?,?";	//(公式：(pageIndex-1)*pageSize)
		Object[] params ={(pageIndex-1)*pageSize,pageSize};
		rs=executeQuery(sql,params);
		while(rs.next()){
			Product_category category = new Product_category();
			category.setEpcId(rs.getInt("epc_id"));
			category.setEpcName(rs.getString("epc_name"));
			category.setEpcParentId(rs.getInt("epc_parent_id"));
			list.add(category);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}	
		return list;
	}
	
}
