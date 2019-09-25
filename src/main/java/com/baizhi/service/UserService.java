package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	/**
	 * 
	 * @param user 用户登录
	 */
	public void login(User user);
	/**
	 * 
	 * @param user,注册前台信息
	 * @param yzcode,前台验证码
	 */
	public void register(User user, String yzcode);
	/**
	 * 
	 * @param code1 添加激活码
	 */
	public void registerOk(String code1);
	/**
	 * 
	 * @return 获取所有对象
	 */
	public List<User> selectAll();
	/**
	 * 
	 * @param email 传入一个邮箱
	 */
	public void changeStatus(String email);
}
