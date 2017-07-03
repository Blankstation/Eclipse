package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import com.model.Book;
import java.util.Set;

/**
*********************************************
*@����   BookDao
*@ʱ��   2017��6��1�� ����11:40:42
*@����   guyan
*@����
*********************************************
*/
public class BookDao extends BaseDao{
	 //��ѯ����ͼ����Ϣ
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<Book>();
		try{
			String sql="select isbn,bname,pubdate,press,author,price from tbook";
			rs=executeQuery(sql);
			while(rs.next()){
				Book book=new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setBkname(rs.getString("bname"));
				book.setAuthor(rs.getString("author"));
				book.setPubdate(rs.getDate("pubdate"));
				book.setPress(rs.getString("press"));
				//..
				books.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return books;
	}
	public byte[] getBookPic(String isbn){
		byte[] pic=null;
		try {
			String sql="select pic from tbook where isbn =?";
			Object[] params ={isbn};
			rs=executeQuery(sql, params);
			if(rs.next()){
				pic=rs.getBytes("pic");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pic;
	}
	//����ISBN��ȡһ��ͼ��
			public Book getBookByIsbn(String isbn){
				Book book=null;
				try {
					String sql="select isbn,bname,pubdate,press,author,price from tbook where isbn=?";
					Object[] params = {isbn};
					rs = executeQuery(sql, params);
					if(rs.next()){
						book=new Book();
						book.setAuthor(rs.getString("author"));
						book.setBkname(rs.getString("bname"));
						book.setIsbn(rs.getString("isbn"));
						book.setPress(rs.getString("press"));
						book.setPrice(rs.getDouble("price"));
						book.setPubdate(rs.getDate("pubdate"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					this.closeAll();
				}
				return book;
			}
			//���ﳵ��ȡ����
			public List<Book> getBooks(Set<String> isbns){
				List<Book> books = new ArrayList<Book>();
				String isbnStr =null;
				Object[] obj = isbns.toArray();
				for (int i = 0; i < obj.length; i++) {
					if(i==0){
						isbnStr = "'"+obj[i]+"'";
					}else{
						isbnStr = isbnStr+","+"'"+obj[i]+"'";
					}
				}
				isbnStr=isbnStr.trim();   //�൱ bk001,bk002
				try {
					String sql = "select isbn,bname,pubdate,press,author,price from tbook where isbn in(" +  isbnStr + ")";
					rs = executeQuery(sql);
					while (rs.next()) {
						Book bk=new Book();
						bk.setAuthor(rs.getString("author"));
						bk.setBkname(rs.getString("bname"));
						bk.setIsbn(rs.getString("isbn"));
						bk.setPress(rs.getString("press"));
						bk.setPrice(rs.getDouble("price"));
						bk.setPubdate(rs.getDate("pubdate"));
						books.add(bk);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally{
					this.closeAll();
				}		
				return books;
			}
			/**
			 * ������Ŀ�����ٿ��
			 * @param isbn
			 * @param bkcount  ����Ϊ���ӿ�棬����Ϊ���ٿ��
			 * @throws Exception
			 */
			public void updateBookCount(String isbn,int bkcount) throws Exception{
				
				try {
					String sql = "update tbook set count=count+? where isbn=?";
					Object[] params = {bkcount,isbn};
					executeUpdate(sql, params);
				} catch (Exception e) {
					
					e.printStackTrace();
				} finally{
					this.closeAll();
				}
			}
			//���ͼ��
			public void addBook(Book book) throws Exception{
				try {
					String sql="insert into tbook(ISBN,bname,pic,pubdate,press,author,price,count) "
							+ " values (?,?,?,?,?,?,?,?)";
					Object[] params ={book.getIsbn(),book.getBkname(),book.getPic(),book.getPubdate(),book.getPress(),book.getAuthor(),book.getPrice(),100};
					
					executeUpdate(sql, params);
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					this.closeAll();
				}
				
			}
	public static void main(String[] args){
		BookDao dao=new BookDao();
		System.out.println(dao.getAllBooks().size());
	}

}
