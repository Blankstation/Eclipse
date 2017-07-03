package com.cn.easybuy.dao;

import java.util.List;

import com.cn.easybuy.entity.News;

/**
 *********************************************
 * @类名 NewsDao
 * @时间 2017年6月27日 下午4:46:57
 * @作者 guyan
 * @描述 新闻接口
 *********************************************
 */
public interface NewsDao {
	public List<News> getAllNews();// 查询所有新闻

	public boolean addNews(News news);// 添加新闻

	public int deleteNews(int newsid);// 删除新闻

	public int updateNews(News news);// 修改新闻

	public News getNews(int newsid); //

	// 产品总记录数
	public int getCount();

	// 得到数据
	public List<News> getList(int pageIndex, int pageSize);
}
