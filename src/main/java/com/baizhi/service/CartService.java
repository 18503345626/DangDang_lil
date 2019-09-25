package com.baizhi.service;


public interface CartService {
	/**
	 * 
	 * @param 添加购物车
	 */
	void addCart(String bookId);
	/**
	 * 
	 * @param 修改购物车书的数量
	 * @param count
	 */
	void updateCart(String bookId, Integer count);
	/**
	 * 
	 * @param 删除图书的Id:bookId
	 */
	void deleteCart(String bookId);
	
}
