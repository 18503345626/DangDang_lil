package com.baizhi.action;


import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class OrderAction extends ActionSupport{
	private List<Order> list;
	private Address address;
	private Order order;
	private String bid;
	

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public String selectBackAll(){
		OrderService osi = new OrderServiceImpl();
		list=osi.selectBackAll();
		return Action.SUCCESS;
	}
	public String addOrder(){
		OrderService osi = new OrderServiceImpl();
		osi.addOrder(address);
		return Action.SUCCESS;
	}
	public String orderDetail(){
		OrderService osi = new OrderServiceImpl();
		System.out.println(bid+"111111111111111111111111111");
		order=osi.orderDetail(bid);
		return Action.SUCCESS;
	}
}
