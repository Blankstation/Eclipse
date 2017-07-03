package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.BuyDetail;
import com.model.BuyInfo;
import com.model.BuyRecord;
import com.model.User;
import com.util.Log;
import com.util.Page;


/**
*********************************************
*@类名   UserDao
*@时间   2017年6月1日 上午9:40:10
*@作者   guyan
*@描述        用户的数据访问类
*********************************************
*/
public class UserDao extends BaseDao {
	public User login(String uname,String pwd){
		User user=null;
		try {
			String sql="select uname,pwd,role,account from tuser where uname=? and pwd =?";
			Object[] params ={uname,pwd};			
			rs=executeQuery(sql, params);
			if(rs.next()){
				user=new User();
				user.setUname(rs.getString("uname"));
				user.setPwd(rs.getString("pwd"));
				user.setRole(rs.getInt("role"));
				user.setAccount(rs.getDouble("account"));
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return user;

}
	public void register(User user) {
		try {
			String sql = "insert into tuser(uname,pwd,role,account) values(?,?,?,?)";
			Object[] params = { user.getUname(), user.getPwd(), user.getRole(), user.getAccount() };
			int result = executeUpdate(sql, params);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			this.closeAll();
		}
	}

	// 验证用户名是否存在
	public boolean validUserName(String uname) {
		boolean flag = false;
		try {
			String sql = "select * from tuser where uname = ?";
			Object[] params = { uname };
			rs = executeQuery(sql, params);
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag;
	}
	//帐号结帐扣款
		public void updateAccount(User user,double money){
			try {
				String sql = "update tuser set account =account -? where id=?";
				Object[] params = {money,user.getId()};
				int result = executeUpdate(sql, params);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				this.closeAll();
			}
		}
		//增加购买记录
		public void addBuyRecord(BuyRecord br){
			try {
				String sql="insert into tbuyrecord (buytime,userid,allmoney,allcount) values (now(),?,?,?)";
				Object[] params ={
						//new java.sql.Timestamp(br.getBuyTime().getTime()),
						br.getUsid(),br.getAllmoney(),br.getAllCount()
						};
				executeUpdate(sql, params);
				List<BuyDetail> details = br.getDetails();
				for (BuyDetail buyDetail : details) {
					addBuyDetail(buyDetail);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				this.closeAll();
			}
		}
		//添加购买明细
		public void addBuyDetail(BuyDetail detail) throws Exception{
			try {
				String sql = "insert into TRecordDetail (isbn,buyid,count,discount)  values(?,(select max(id) from tbuyrecord),?,?)";
				Object[] params = {detail.getIsbn(),detail.getCount(),detail.getDprice()};
				executeUpdate(sql, params);
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				this.closeAll();
			}
			BookDao dao = new BookDao();
			dao.updateBookCount(detail.getIsbn(),-detail.getCount());		
		}
		//后台查询购买图书
		public List<BuyInfo> getBuyInfoList(String uname,Date bDate,Date eDate,Page pages){
			List<BuyInfo> list= new ArrayList<BuyInfo>();
			/*String sql = "select u.uname,br.buytime,br.allmoney,br.allcount,d.count,b.bname,b.press,b.author,b.price " +
				    " from tbuyrecord br,tuser u,tbook b,TRECORDDETAIL d " +
				    " where u.id = br.userid and br.id = d.id and b.isbn = d.isbn ";*/
			
			String sql=" SELECT u.uname,br.buytime,br.allmoney,br.allcount,d.count,b.bname,b.press,(d.count*b.price ) subtotal, "+
						" b.author,b.price "+ 
						" from trecorddetail d left join tbuyrecord br on  br.id = d.BUYID "+
						" INNER JOIN tuser u on u.ID = br.USERID INNER JOIN tbook b on b.ISBN=d.ISBN";
			if(uname!=null&&!"".equals(uname)){
				sql += " and u.uname like '%"+uname+"%'";
			}
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			if(bDate!=null){
				sql += " and buytime >= '"+sd.format(bDate)+"'";
			}
			if(eDate!=null){
				sql += " and buytime <= '"+sd.format(eDate)+"'";
			}
			int start = (pages.getCurrentPageNo()-1) * pages.getPageSize();
			int end = pages.getPageSize();
			
			//查询总记录数
			pages.setAllCount(this.getCount(sql));
			if(pages.getCurrentPageNo()>pages.getPageAllCount()){
				pages.setCurrentPageNo(pages.getPageAllCount());
			}
			if(pages.getCurrentPageNo()>0){
				sql += " limit "+start+","+end; 
			}
			try {
				rs = executeQuery(sql);
				while (rs.next()) {
					BuyInfo bi = new BuyInfo();
					bi.setAllcount(rs.getInt("allcount"));
					bi.setAllmoney(rs.getDouble("allmoney"));
					bi.setAuthor(rs.getString("author"));
					bi.setBname(rs.getString("bname"));
					bi.setBuytime(rs.getTimestamp("buytime"));
					bi.setCount(rs.getInt("count"));
					bi.setPress(rs.getString("press"));
					bi.setPrice(rs.getDouble("price"));
					bi.setUname(rs.getString("uname"));	
					bi.setSubtotal(rs.getDouble("subtotal"));
					list.add(bi);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		public int getCount(String sql){
			int result=0;
			try {
				String strSql = "select count(1) as num from ("+sql+") w";
				rs = executeQuery(strSql);
				if(rs.next()){
					result=rs.getInt("num");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
}
