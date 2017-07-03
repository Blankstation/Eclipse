package com.action;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.biz.BookBiz;
import com.biz.UserBiz;
import com.model.Book;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Log;

/**
*********************************************
*��ȡͼ����Ϣ
*@����   UserAction
*@ʱ��   2017��6��1�� ����9:38:08
*@����   guyan
*@����        �û��ദ��
*********************************************
*/
public class UserAction extends ActionSupport {
	UserBiz bizuser=new UserBiz();
	BookBiz bizbook = new BookBiz();
	
	public String getAllBooks() throws Exception {
		// TODO Auto-generated method stub
		String result="error";
		HttpServletRequest request=ServletActionContext.getRequest();
		BookBiz biz=new BookBiz();
		try{
			List<Book> books=biz.getAllBooks();
			request.setAttribute("books", books);
			result="mainOK";
		}catch(Exception e){
			e.printStackTrace();
			Log.logger.error(e.getMessage());
		}
		return result;
	}
	//�õ�ͼ�����ϸ��Ϣ
		public String getBookByIsbn() throws Exception{
			String result="error";
			HttpServletRequest request = ServletActionContext.getRequest();
			String isbn=request.getParameter("isbn");
			BookBiz biz = new BookBiz();
			try {
				Book book  = biz.getBookByIsbn(isbn);
				request.setAttribute("book",book);
				result = "detailOk";
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
public String loginGet() throws Exception {
		
		return "loginGet";
	}

	public String login() throws Exception {
		String result="error";
		HttpServletRequest request = ServletActionContext.getRequest();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String msg=null; //���ڼ�¼��¼��Ϣ
		UserBiz biz = new UserBiz();
		try {
		User user = bizuser.login(uname, pwd);
		if (user!=null) {
			request.getSession().setAttribute("user", user);
			result="loginOk";
		}else{
			msg="��¼ʧ�ܣ������µ�¼";
			request.setAttribute("msg", msg);
		}
	} catch (Exception e) {
		result="nullUser";
		msg="ϵͳ�����쳣���������Ա��ϵ��";
		request.setAttribute("msg", msg);
		e.printStackTrace();
	}
		return result;
	}//�˳������µ�¼
	public String logOut() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User)request.getSession().getAttribute("user");
		if(user != null){
			request.getSession().removeAttribute("user");
		}
		return "loginOk";
	}
	//��תע��ҳ��
	public String registerGet() throws Exception{
		return "registerGet";
	}
	//ע��
	public String register() throws Exception{
		String result ="error";
		HttpServletRequest request = ServletActionContext.getRequest();
		String uname  =request.getParameter("uname");
		String pwd  =request.getParameter("pwd");
		UserBiz biz=new UserBiz();
		try {
			if(uname != null && pwd != null && !uname.equals("") && !pwd.equals("")){
				User user = new User();
				user.setUname(uname);
				user.setPwd(pwd);
				user.setRole(2);
				user.setAccount(100);
				biz.register(user);
				request.setAttribute("msg", "ע��ɹ�,���¼");
				result = "registerOK";
			}
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
			request.setAttribute("error_msg", "δ֪����,������ע��");
		}
		return result;
	}
	public String bookDetails() throws Exception {
		String result="error";
		HttpServletRequest request = ServletActionContext.getRequest();
		String isbn  =request.getParameter("isbn");
		BookBiz biz = new BookBiz();
		try {
			Book book  = biz.getBookByIsbn(isbn);
			request.setAttribute("book",book);
			result = "detailOk";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	//��ӹ��ﳵ 
		public String queryShopCar() throws Exception {
			String result = "error";
			HttpServletRequest request = ServletActionContext.getRequest();
			if(request.getSession().getAttribute("user")!=null){
				String isbn = request.getParameter("isbn");
				Object obj = request.getSession().getAttribute("bkCar");
				Map<String,Integer> bkCar; 
				if(obj == null){
					//��һ�Σ���session�н�һ�����ﳵ
					bkCar  = new HashMap<String,Integer>();				
					request.getSession().setAttribute("bkCar",bkCar);				
				}else{				
					//�ǵ�һ�ν���
					bkCar = (Map<String,Integer>)request.getSession().getAttribute("bkCar");								
				}
				if(isbn != null){			  	
					  bkCar.put(isbn, 1);
				}	
				/*if(isbn!=null){
					if(obj==null){
						bkCar = new HashMap<String, Integer>();
						request.getSession().setAttribute("bkCar", bkCar);
					}else{
						bkCar=(Map<String, Integer>) request.getSession().getAttribute("bkCar");
					}
					if(bkCar.containsKey(isbn)){
						bkCar.put(isbn, bkCar.get(isbn)+1);
					}else{
						bkCar.put(isbn, 1);
					}
				}else{
					if(obj==null){
						bkCar = new HashMap<String, Integer>();
						request.getSession().setAttribute("bkCar", bkCar);
					}else{
						bkCar=(Map<String, Integer>) request.getSession().getAttribute("bkCar");
					}
				}*/
				BookBiz biz = new BookBiz();
				try {
					if(bkCar!=null){
						List<Book> books = biz.getBooks(bkCar.keySet());
						request.setAttribute("books", books);
					}
					result = "shopCarOk";
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}
			}else{
				request.setAttribute("msg", "����û�е�¼,���¼���ܷ��ʣ�");
				result="nullUser";
			}
			
			return result;
		}
		public String checkOut() throws Exception {
			String result = "error";
			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String,Integer> bkCar =(Map<String, Integer>) request.getSession().getAttribute("bkCar");
			BookBiz biz = new BookBiz();
			try {
				if(bkCar.keySet().size()>0){
					List<Book> books = biz.getBooks(bkCar.keySet());
					double allMoney = 0;
					for(Book bk : books ){
						int bkCount = Integer.parseInt(request.getParameter(bk.getIsbn()));
						bkCar.put(bk.getIsbn(), bkCount);
						bk.setBuycount(bkCount);
						allMoney = allMoney+bk.getPrice() *bkCount;
					}
					request.setAttribute("books", books);
					DecimalFormat    df   = new DecimalFormat("0.00");
					request.setAttribute("allMoney", df.format(allMoney));
					
					result = "checkOutOk";
				}
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}
			return result;
		}
		//����
		public String payMoney() throws Exception {
			String result = "error";
			HttpServletRequest request = ServletActionContext.getRequest();
			String allMoney = request.getParameter("allMoney");
			if(allMoney!=null){
				double money = Double.parseDouble(allMoney);
				BookBiz biz = new BookBiz();
				User user = (User) request.getSession().getAttribute("user");//��õ�¼�û�����
				Map<String,Integer> books = (Map<String, Integer>) request.getSession().getAttribute("bkCar");  //��ȡ���ﳵ��Ϣ
				try {
					biz.buyBooks(user,money,books);
					//��չ��ﳵ
					request.getSession().setAttribute("bkCar", new HashMap<String,Integer>());
					result="payOk";
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}
			}
			return result;
		}
}
