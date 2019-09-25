package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddressAction extends ActionSupport{
	private String aid;
	private List<Address> list;
	private Address address;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * 查询地址
	 */
	public String selectAddress(){
		AddressService asi = new AddressServiceImpl();
		list=asi.selectAllByUser();
		address=asi.selectOne(aid);
		return Action.SUCCESS;
	}
}
