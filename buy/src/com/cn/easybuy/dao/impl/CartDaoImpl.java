package com.cn.easybuy.dao.impl;

import com.cn.easybuy.dao.CartDao;
import com.cn.easybuy.util.BaseDao;

/**
************************************
*@类名	CartDaoImpl
*@时间	2017年6月30日 上午9:56:47
*@作者	rou
*@描述
************************************
*/
public class CartDaoImpl extends BaseDao implements CartDao {

	public boolean queryCart(String uname, int epid) {
		boolean falg=false;
		try {
			String sql="select * from easybuy_cart where eu_userid=? and ep_id=?";
			Object[] params={uname,epid};
			rs=executeQuery(sql, params);
			if(rs.next()){
				falg=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return falg;
	}
	public int addCart(String uname, int epid) {
		int result=0;
		try {
			String sql="insert into easybuy_cart(eu_userid,ep_id,ep_quantity) values(?,?,?)";
			Object[] params={uname,epid,1};
			result=executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}

	public int updateCart(String uname, int epid) {
		int result=0;
		try {
			String sql="update easybuy_cart set ep_quantity=ep_quantity+1 where eu_uaseid=? and ep_id=?";
			Object[] params={uname,epid};
			result=executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}

}
