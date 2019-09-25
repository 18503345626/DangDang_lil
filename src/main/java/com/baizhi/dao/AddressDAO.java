package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

/**
 * 
 * @author Administrator
 * @category 地址
 */
public interface AddressDAO {
	/**
	 * 
	 * @param user_id 用户id 查询所有的地址信息
	 * @return
	 */
	List<Address> selectAllByUser(String user_id);
	/**
	 * 
	 * @param address有添加一个地址
	 */
	void addOneAddress(Address address);
	/**
	 * 
	 * @param address 修改用户的已知地址
	 */
	void updateOne(Address address);

}
