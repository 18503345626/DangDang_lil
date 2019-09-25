package com.baizhi.action;

import com.baizhi.service.CartService;
import com.baizhi.service.impl.CartServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 
 * @author Administrator
 * @category 购物车Action
 *
 */
@SuppressWarnings("serial")
public class CartAction extends ActionSupport {
	private String bookId;
	private Integer count;
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * 添加到购物车
	 * @return
	 */
	public String addCart(){
		CartService csi = new CartServiceImpl();
		csi.addCart(bookId);
		return Action.SUCCESS;		
	}
	/**
	 * 修改购买图书数量
	 */
	public String updateCart(){
		CartService csi = new CartServiceImpl();
		csi.updateCart(bookId,count);
		return Action.SUCCESS;	
	}
	public String deleteCart(){
		CartService csi = new CartServiceImpl();
		csi.deleteCart(bookId);
		return Action.SUCCESS;	
	}
}
