package com.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.biz.BookBiz;
import com.model.Book;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Log;

/**
*********************************************
*@����   bookAdminAction
*@ʱ��   2017��6��9�� ����8:59:04
*@����   guyan
*@����      ��̨���ͼ��
*********************************************
*/
public class bookAdminAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Book book;
	private File pic;
	
	//ҳ����ת
	public String addBookGet() throws Exception{
		
		return "addBook";
	}
	//���ͼ��
	public String addBook() throws Exception {
		HttpServletRequest request =ServletActionContext.getRequest();
		String pdate = request.getParameter("pubdate"); //��������
		try {
			Date pubdate =null;
			if(pdate!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				pubdate = sdf.parse(pdate);
				book.setPubdate(pubdate);
			}
			if(pic!=null){
				book.setPic(FileUtils.readFileToByteArray(pic));
			}
			BookBiz biz= new BookBiz();
			biz.addBook(book);
			request.setAttribute("msg", "��ӡ�"+book.getBkname()+"���ɹ���");
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
		return "addBook";
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

}
