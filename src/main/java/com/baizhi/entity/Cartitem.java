package com.baizhi.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cartitem implements Serializable{
	private Book book;
	private Integer count;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cartitem [book=" + book + ", count=" + count + "]";
	}
	public Cartitem() {
		super();
	}	
}
