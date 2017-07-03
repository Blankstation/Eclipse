package com.biz;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dao.BookDao;
import com.dao.UserDao;
import com.model.Book;
import com.model.BuyDetail;
import com.model.BuyRecord;
import com.model.User;
import com.util.Log;

/**
*********************************************
*@����   BookBiz
*@ʱ��   2017��6��2�� ����8:37:08
*@����   guyan
*@����
*********************************************
*/
public class BookBiz {
	BookDao bdao=new BookDao();
  public List<Book> getAllBooks(){
	  List<Book> books=null;
	  try{
		  books=bdao.getAllBooks();
	  }catch(Exception e){
		  Log.logger.error(e.getMessage());
	  }
	  return books;
  }
  public byte[] getPic(String isbn){
		byte[] pic=null;
		try {
			pic = bdao.getBookPic(isbn);
		} catch (Exception e) {
			Log.logger.error(e.getMessage());
		}
		return pic;
	}
//��ȡͼ��
		public Book getBookByIsbn(String isbn){
			Book book =null;
			BookDao dao=new BookDao();
			try {
				book=dao.getBookByIsbn(isbn);
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}
			return book;
		}
		public List<Book> getBooks(Set<String> isbns) {
			List<Book> books=null;
			BookDao dao = new BookDao();
			try {
				books = dao.getBooks(isbns);
			} catch (Exception e) {
				Log.logger.error(e.getMessage());
			}
			return books;
		}
		public void buyBooks(User user,double money,Map<String,Integer> books){
			if(user!=null&&books!=null){
				UserDao dao = new UserDao();
				try {
					dao.updateAccount(user,money); //��ǰ�ʺſۿ�
					BuyRecord br = new BuyRecord(); 
					br.setBuyTime(new Date());
					br.setUsid(user.getId());
					br.setAllmoney(money);
					br.setAllCount(getAllBuyCount(books));
					setBuyDetails(br, books);  //��ӹ�����ϸ
					dao.addBuyRecord(br);   //��ӹ����¼
					
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
				}
			}
		}
		 private int getAllBuyCount(Map<String,Integer> books){
			 int allCount = 0;
			 
			 Set<String> keys = books.keySet();
			 for(String key : keys){
				 allCount = allCount + books.get(key);
			 }
			 
			 return allCount;
		 }
		 private void setBuyDetails(BuyRecord br,Map<String,Integer> books){		 
			 Set<String> keys = books.keySet();
			 for(String key : keys){
				 BuyDetail detail = new BuyDetail();
				 detail.setIsbn(key);
				 detail.setCount(books.get(key));  //����û�У�
				 //detail.setBuyid(br.getBid());
				 br.getDetails().add(detail);	
			 }		 	 
		 }
		 //���ͼ��
		 public void addBook(Book book){
			 if(book!=null){
				try {
					BookDao dao = new BookDao();
					dao.addBook(book);
				} catch (Exception e) {
					Log.logger.error(e.getMessage());
					e.printStackTrace();
				}
				
			 }

}
}
