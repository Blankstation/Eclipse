package com.cn.easybuy.dao;
/**
************************************
*@类名	CartDao
*@时间	2017年6月30日 上午9:31:05
*@作者	rou
*@描述
************************************
*/
public interface CartDao {
public boolean queryCart(String uname,int epid);//根据用户名和商品ID查询购物车表中是否有购买记录
public int addCart(String uname,int epid);//添加购物车
public int updateCart(String uname,int epid);//更新购物车

}
