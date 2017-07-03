package com.cn.easybuy.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cn.easybuy.dao.NewsDao;
import com.cn.easybuy.entity.News;
import com.cn.easybuy.util.BaseDao;

/**
*********************************************
*@类名   NewsDaoImpl
*@时间   2017年6月27日 下午4:57:55
*@作者   guyan
*@描述        新闻类操作
*********************************************
*/
public class NewsDaoImpl extends BaseDao implements NewsDao {
    //查询所有新闻
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		List<News> list=new ArrayList<News>();
		try{
			//第一步sql语句
			String sql="SELECT en_id,en_title,en_content,en_create_time FROM easybuy_news order by en_create_time desc ";
			rs=executeQuery(sql);
			while(rs.next()){
				News news=new News();
				news.setEnId(rs.getInt("en_id"));
				news.setEnTiTle(rs.getString("en_title"));
				list.add(news);
			}
			
		}catch(Exception e){
			
		}finally{
			this.closeAll();//关闭连接
		}
		return list;
	}
	//添加新闻
	public boolean addNews(News news){
		// TODO Auto-generated method stub
		boolean flag=false;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date time=null;
try{
	time=format.parse(format.format(date));
	String sql="insert into easybuy_news (en_title,en_content,en_create_time) values (?,?,?) ";
	Object[] params={news.getEnTiTle(),news.getEnContent(),time};
	int i=this.executeUpdate(sql,params);
	if(i>0){
	System.out.println("添加新闻成功");
	}
	flag=true;
		}catch(Exception e){
			
		}finally{
			this.closeAll();//关闭连接
		}
		return flag;
	}
	//删除新闻
	public int deleteNews(int newsid) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			String sql="delete from easybuy_news where en_id=?";
			Object[] params= {newsid};
			result=executeUpdate(sql, params);
		}catch (Exception e) {
			// TODO: handle exception
		    this.closeAll();
		}finally {
			
		}
		return result;
	}
	
	//分页数据
		public List<News> getList(int pageIndex,int pageSize){
			List<News> list = new ArrayList<News>();
			try{
			String sql="SELECT en_id,en_title,en_content,en_create_time FROM easybuy_news LIMIT ?,?";	//(公式：(pageIndex-1)*pageSize)
			Object[] params ={(pageIndex-1)*pageSize,pageSize};
			rs=executeQuery(sql,params);
			while(rs.next()){
				News news = new News();
				news.setEnId(rs.getInt("en_id"));
				news.setEnTiTle(rs.getString("en_title"));
				news.setEnContent(rs.getString("en_content"));
				news.setEnCreateTime(rs.getDate("en_create_time"));
				list.add(news);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}	
		return list;		
		}

	
	
//更新新闻
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		int result=0;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date time=null;
		try {
			time=format.parse(format.format(date));
			String sql="UPDATE easybuy_news SET en_title=?,en_content=?,en_create_time=? WHERE en_id=?";
			Object[] params={news.getEnTiTle(),news.getEnContent(),time,news.getEnId()};
			result=executeUpdate(sql, params);
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					this.closeAll();
				}
				return result;
	}
	public News getNews(int newsid) {
		News news =null;
		try{
			//第一步sql语句
			String sql="SELECT en_id,en_title,en_content,en_create_time FROM easybuy_news where en_id=?";
			Object[] params = {newsid};
			rs=executeQuery(sql,params);
			while(rs.next()){
				 news=new News();
				news.setEnId(rs.getInt("en_id"));
				news.setEnTiTle(rs.getString("en_title"));
				news.setEnContent(rs.getString("en_content"));
				news.setEnCreateTime(rs.getDate("en_creat_time"));


			}
			
		}catch(Exception e){
			
		}finally{
			this.closeAll();//关闭连接
		}
		return news;
	}
	public int getCount() {
		int result= 0;
		try {
			String sql="select count(1) as num from easybuy_news";
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

}
