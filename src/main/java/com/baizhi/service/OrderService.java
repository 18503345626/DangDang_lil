package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;


public interface OrderService {
	/**
	 * 
	 * @return 展示后台订单信息
	 */
	List<Order> selectBackAll();
	/**
	 * 
	 * @param address 前台订单信息传入
	 */
	void addOrder(Address address);
	/**
	 * 
	 * @param id 订单Id
	 * @return 前台详细信息
	 */
	Order orderDetail(String id);
	
}
