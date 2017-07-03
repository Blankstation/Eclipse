package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.UserBiz;

public class RegisterSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String uname = request.getParameter("uname");	
		if(uname != null){
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();			
			UserBiz biz = new UserBiz();
			try {				
				boolean bRet = biz.validUserName(uname);				                         
				if(bRet){
					out.println("存在重名的用户，不能使用!");	
				}else{
					if(uname.equals("")){
						out.println("用户名不能为空!");
					}else{
						out.println("输入的名字可以使用!");
					}
				}
								
			} catch (Exception e) {
				String msg = "网络繁忙，请联系运营商";	
				out.println(msg);
			}	
			out.flush();
			out.close();
		}else{
			String msg = "请通过浏览器，正常访问";	
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}		
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
