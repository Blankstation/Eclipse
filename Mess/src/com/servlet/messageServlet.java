package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Message;
import com.dao.MessageDao;
import com.dao.MessageDaoImpl;



/**
 * Servlet implementation class messageServlet
 */
public class messageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**`
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mess = request.getParameter("content");
		String name	= request.getParameter("username");
		MessageDao messageDao = new MessageDaoImpl();
		if (mess == null || mess.equals("")) {
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			Message message=new Message();
			message.setName(name);
			message.setContent(mess);
			int rows = messageDao.writing(message,name);
			if (rows==1) {
				request.setAttribute("msg", "发表成功");
				request.getRequestDispatcher("FetchMessageServlet").forward(request, response);
			
			} else {
				request.setAttribute("msg", "发表失败");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
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
