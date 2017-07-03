package com.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.BookBiz;
import com.util.Log;


/**
*********************************************
*@类名   ImgSvl
*@时间   2017年6月2日 上午11:05:23
*@作者   guyan
*@描述
*********************************************
*/
public class ImgSvl extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String isbn=request.getParameter("isbn");
		 if(isbn!=null){
			 BookBiz biz =new BookBiz();
			 try {
				byte[] pic =biz.getPic(isbn);
				if(pic !=null){
					ServletOutputStream os =response.getOutputStream();
					os.write(pic);
					os.flush();
					os.close();
				}
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}
		 }
		 
	}

}
