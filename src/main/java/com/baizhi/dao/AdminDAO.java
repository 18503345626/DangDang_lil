package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Admin;

public interface AdminDAO {
	/**
	 * 后台登录查询
	 * @param username 管理员用户名
	 * @return 管理员对象
	 */
	public Admin login(@Param("username")String username);
}
