package com.cn.easybuy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.easybuy.dao.NewsDao;
import com.cn.easybuy.dao.impl.NewsDaoImpl;
import com.cn.easybuy.entity.News;

/**
 * Servlet implementation class NewsDeleteServlet
 */
public class NewsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8");
	    int enid =Integer.valueOf(request.getParameter("newsid")) ;
	    News news=new News();
	    news.setEnId(enid);
	    NewsDao newsdao=new NewsDaoImpl();
	    int result=newsdao.deleteNews(enid);
	    if(result!=0){
	    	response.sendRedirect("manage/news.jsp");
	    }else{
	    	System.out.println("删除失败");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
