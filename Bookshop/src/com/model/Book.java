package com.model;

import java.util.Date;

/**
*********************************************
*@����   Book
*@ʱ��   2017��6��1�� ����10:23:12
*@����   guyan
*@����
*********************************************
*/
public class Book {
	private String isbn;
	private String bkname;
	private Date pubdate;
	private String press;
	private String author;
	private double price;
	private byte[] pic;//��ͼƬ
	private int buycount;//��������
	private int count;//��Ŀ����
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBkname() {
		return bkname;
	}
	public void setBkname(String bkname) {
		this.bkname = bkname;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public int getBuycount() {
		return buycount;
	}
	public void setBuycount(int buycount) {
		this.buycount = buycount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
