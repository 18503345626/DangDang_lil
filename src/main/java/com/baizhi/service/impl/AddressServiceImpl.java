package com.baizhi.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDAO;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.util.MybatisUtil;

public class AddressServiceImpl implements AddressService{

	@Override
	public List<Address> selectAllByUser() {
		AddressDAO ad=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		User u =(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		List<Address> list=ad.selectAllByUser(u.getUser_id());
		MybatisUtil.close();
		return list;
	}

	@Override
	public Address selectOne(String aid) {
		AddressDAO ad=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		User u =(User)ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		List<Address> list=ad.selectAllByUser(u.getUser_id());
		for (Address address : list) {
			if(address.getAddress_id().equals(aid)){
				return address;
			}
		}
		return null;
	}

	
}
