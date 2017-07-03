package com.cn.easybuy.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.cn.easybuy.dao.ProductCategoryDao;
import com.cn.easybuy.dao.ProductDao;
import com.cn.easybuy.entity.Product;
import com.cn.easybuy.util.BaseDao;

/**
*************************************************
*@类名       ProductDaoImpl
*@时间       2017年6月29日下午9:45:48
*@作者       z
*@描述
*************************************************
*/
public class ProductDaoImpl extends BaseDao implements ProductDao{
	public int getCount() {
		int result=0;
		try{
			String sql="SELECT COUNT(1) as num FROM easybuy_product";
			rs=executeQuery(sql);
			if(rs.next()){
				result=rs.getInt("num");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return result;
	}
	//分页数据
	public List<Product> getList(int pageIndex,int pageSize){
		List<Product> list = new ArrayList<Product>();
		try{
		String sql="SELECT ep_id,ep_name,ep_price,epc_id,ep_file_name FROM easybuy_product LIMIT ?,?";	//(公式：(pageIndex-1)*pageSize)
		Object[] params ={(pageIndex-1)*pageSize,pageSize};
		rs=executeQuery(sql,params);
		while(rs.next()){
			Product product = new Product();
			product.setEpId(rs.getInt("ep_id"));
			product.setEpcId(rs.getInt("epc_id"));
			product.setEpName(rs.getString("ep_name"));
			product.setEpPrice(rs.getDouble("ep_price"));
			product.setEpFileName(rs.getString("ep_file_name"));
			list.add(product);
		}

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		this.closeAll();
	}	
	return list;		
	}
	@Override
	public List<Product> getAllProduct(int pid) {
		List<Product> list = new ArrayList<Product>();
		try{
			String sql="SELECT ep_name,ep_description,ep_price,ep_stock,epc_id,ep_file_name FROM easybuy_product WHERE ep_id=?";	//(公式：(pageIndex-1)*pageSize)
			Object [] params = {pid}; 
			rs=executeQuery(sql,params);
			while(rs.next()){
				Product product = new Product();
				
				product.setEpName(rs.getString("ep_name"));
				product.setEpDescription(rs.getString("ep_description"));
				product.setEpPrice(rs.getDouble("ep_price"));
				product.setEpStock(rs.getInt("ep_stock"));
				product.setEpcId(rs.getInt("epc_id"));
				product.setEpFileName(rs.getString("ep_file_name"));
				list.add(product);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	public List<Product> queryProduct() {
		List<Product> list = new ArrayList<Product>();
		try{
			String sql="SELECT ep_id,ep_name,ep_price,ep_file_name FROM easybuy_product";	//(公式：(pageIndex-1)*pageSize)
			rs=executeQuery(sql);
			while(rs.next()){
				Product product = new Product();
				product.setEpId(rs.getInt("ep_id"));
				product.setEpName(rs.getString("ep_name"));
				product.setEpPrice(rs.getDouble("ep_price"));
				product.setEpFileName(rs.getString("ep_file_name"));
				list.add(product);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	@Override
	public int addProduct(Product product) {
		int result =0;
		try {
			String sql = "INSERT INTO easybuy_product (ep_name,ep_description,ep_price,ep_stock,epc_id,ep_file_name) VALUES (?,?,?,?,?,?)";
			Object[] params = {product.getEpName(),product.getEpDescription(),product.getEpPrice(),product.getEpStock(),
					product.getEpcId(),product.getEpFileName()};
			result += executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return result;
	}
	@Override
	public int updateProduct(Product p) {
		int result = 0;
		String sql = "UPDATE easybuy_product SET ep_name = ?, ep_description=?,"
				+ " ep_price=?, ep_stock=?,epc_id=?,ep_file_name=? where ep_id = ?";
		Object[] params = {p.getEpName(), p.getEpDescription(),p.getEpPrice(),
				p.getEpStock(),p.getEpcId(),p.getEpFileName(),p.getEpId()};
		
		result = executeUpdate(sql, params);
		return result;
	}
	@Override
	public int deleteProduct(int id) {
		int result = 0;
		String sql = "delete from easybuy_product where ep_id=?";
		Object[] params = {id};
		result = executeUpdate(sql, params);
		return result;

	}

}
