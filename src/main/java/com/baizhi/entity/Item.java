package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 * @category 订单项表中间表
 */
@SuppressWarnings("serial")
public class Item implements Serializable{
	private String item_id;
	private String book_id;
	private String order_id;
	private int count;
	private Date create_date;
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", book_id=" + book_id
				+ ", order_id=" + order_id + ", count=" + count
				+ ", create_date=" + create_date + ", book=" + book + "]";
	}

	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
}
