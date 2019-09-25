package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDAO {
	/**
	 * 
	 * @return 查询所有后台订单信息
	 */
	List<Order> selectBackAll();
	/**
	 * 
	 * @param order 添加一个订单信息
	 */
	void addOneOrder(Order order);
	/**
	 * 
	 * @param id订单id后台
	 * @return 查询出相关订单的所有信息
	 */
	Order orderDetail(String id);

}
