package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.User;

public interface UserDAO {
	/**
	 * 
	 * @param 根据email查询用户
	 * @return 用户
	 */
	User login(String email);
	/**
	 * 
	 * @param user 注册传入一个对象
	 */
	void register(User user);
	/**
	 * 
	 * @param user 添加激活码
	 */
	void updateCode(User user);
	/**
	 * 
	 * @return 获取所有用户
	 */
	List<User> selectAll();
	/**
	 * 
	 * @param user 修改状态
	 */
	void changeStatus(User user);

}
