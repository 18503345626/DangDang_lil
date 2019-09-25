package com.baizhi.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDAO;
import com.baizhi.entity.*;
import com.baizhi.service.CartService;
import com.baizhi.util.MybatisUtil;

public class CartServiceImpl implements CartService {
	/**
	 * 添加购物车
	 */
	@Override
	public void addCart(String bookId) {
		BookDAO bd = (BookDAO) MybatisUtil.getMapper(BookDAO.class);
		Book book = bd.selectOneById(bookId);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String, Cartitem> map = null;
		Double total = 0.0;
		Double save = 0.0;
		map = (Map<String, Cartitem>) session.getAttribute("cart");
		if (map == null) {
			map = new HashMap<String, Cartitem>();
			Cartitem ci = new Cartitem();
			ci.setBook(book);
			ci.setCount(1);
			total = book.getDprice();
			save = book.getPrice() - book.getDprice();
			map.put(bookId, ci);
		} else {
			total = (Double) session.getAttribute("total");
			save = (Double) session.getAttribute("save");
			Cartitem ci = null;
			if (map.containsKey(bookId)) {
				ci = map.get(bookId);
				ci.setCount(ci.getCount() + 1);
			} else {
				ci = new Cartitem();
				ci.setBook(book);
				ci.setCount(1);
			}
			map.put(bookId, ci);
			total += book.getDprice();
			save += (book.getPrice() - book.getDprice());
		}
		session.setAttribute("cart", map);
		session.setAttribute("total", total);
		session.setAttribute("save", save);
		MybatisUtil.close();
	}

	/**
	 * 修改一本书
	 */
	@Override
	public void updateCart(String bookId, Integer count) {
		BookDAO bd = (BookDAO) MybatisUtil.getMapper(BookDAO.class);
		Book book = bd.selectOneById(bookId);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String, Cartitem> map = (Map<String, Cartitem>) session
				.getAttribute("cart");
		Double total = (Double) session.getAttribute("total");
		Double save = (Double) session.getAttribute("save");
		Cartitem ci = map.get(bookId);
		Integer oldCount = ci.getCount();
		ci.setCount(count);
		total = total - oldCount * book.getDprice() + count * book.getDprice();
		save = save - oldCount * (book.getPrice() - book.getDprice()) + count
				* (book.getPrice() - book.getDprice());
		map.put(bookId, ci);
		session.setAttribute("cart", map);
		session.setAttribute("total", total);
		session.setAttribute("save", save);
		MybatisUtil.close();
	}
	/**
	 * 删除图书
	 */
	@Override
	public void deleteCart(String bookId) {
		BookDAO bd = (BookDAO) MybatisUtil.getMapper(BookDAO.class);
		Book book = bd.selectOneById(bookId);
		HttpSession session = ServletActionContext.getRequest().getSession();
		Map<String, Cartitem> map = (Map<String, Cartitem>) session
				.getAttribute("cart");
		Double total = (Double) session.getAttribute("total");
		Double save = (Double) session.getAttribute("save");
		Integer oldCount=map.get(bookId).getCount();
		total = total - oldCount * book.getDprice();
		save = save - oldCount * (book.getPrice() - book.getDprice());
		map.remove(bookId);
		if(map.size()==0){
			session.removeAttribute("cart");
		}else{
			session.setAttribute("cart", map);
		}
		session.setAttribute("total", total);
		session.setAttribute("save", save);
		MybatisUtil.close();
	}

}
