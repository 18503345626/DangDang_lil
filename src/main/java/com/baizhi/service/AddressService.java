package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	/**
	 * 
	 * @return 查询登录用户的所有地址信息
	 */
	List<Address> selectAllByUser();
	/**
	 * 
	 * @param aid 选择已有的地址信息
	 * @return
	 */
	Address selectOne(String aid);
	
}
