package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Administrator
 * @category 订单表
 */
@SuppressWarnings("serial")
public class Order implements Serializable{
	private String order_id;
	private String order_num;//订单号
	private double total;
	private Date create_date;
	private String status;
	private String user_id;
	private String address_id;
	private Address address;
	private List<Item> list;
	
	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}

	public String getOrder_id() {
		return order_id;
	}
	
	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_num=" + order_num
				+ ", total=" + total + ", create_date=" + create_date
				+ ", status=" + status + ", user_id=" + user_id
				+ ", address_id=" + address_id + ", address=" + address
				+ ", list=" + list + "]";
	}
}
