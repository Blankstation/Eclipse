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
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
	    //int enId=Integer.parseInt(request.getParameter("enId"));
	    String enTiTle=request.getParameter("enTiTle");
	    String enContent=request.getParameter("enContent");
		String enCreateTime=request.getParameter("enCreateTime");
	    News news=new News();
	    //news.setEnId(enId);
	    news.setEnTiTle(enTiTle);
	    news.setEnContent(enContent);
	    //news.setEnCreateTime(enCreateTime);
	    NewsDao newsdao=new NewsDaoImpl();
	    boolean flag=newsdao.addNews(news);
	    if(flag){
	    	response.sendRedirect("manage/news.jsp");
	    }else{
	    	request.getRequestDispatcher("news-add.jsp").forward(request,response);
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
