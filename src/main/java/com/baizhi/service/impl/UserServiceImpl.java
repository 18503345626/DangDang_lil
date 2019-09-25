package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.MybatisUtil;


public class UserServiceImpl implements UserService{

	@Override
	public void login(User user) {
		UserDAO ud=(UserDAO)MybatisUtil.getMapper(UserDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		User u=null;
		u=ud.login(user.getEmail());
		if(u==null)throw new RuntimeException("该用户不存在");
		String password=user.getPassword()+u.getSalt();
		String pass=MD5Utils.getPassword(password);
		if(!pass.equals(u.getPassword()))throw new RuntimeException("密码错误");
		/*if(!u.getPassword().equals(user.getPassword()))
			throw new RuntimeException("密码错误");*/
		if(u.getStatus().equals("冻结"))throw new RuntimeException("该用户被冻结");
		session.setAttribute("loginUser", u);
		MybatisUtil.close();
	}
	/**
	 * 注册
	 */
	@Override
	public void register(User user, String yzcode) {
		
		UserDAO ud=(UserDAO)MybatisUtil.getMapper(UserDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code =(String)session.getAttribute("code");
		if(!code.equals(yzcode))throw new RuntimeException("验证码输入错误");
		User u=null;
		u=ud.login(user.getEmail());
		if(u!=null)throw new RuntimeException("该用户邮箱已被注册");
		String salt=MD5Utils.getSalt();
		user.setSalt(salt);
		String password=MD5Utils.getPassword(user.getPassword()+salt);
		user.setPassword(password);
		user.setUser_id(UUID.randomUUID().toString());
		user.setStatus("正常");
		user.setCreate_date(new Date());
		try {
			ud.register(user);
			session.setAttribute("loginUser", user);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
	}
	@Override
	public void registerOk(String code1) {
		UserDAO ud=(UserDAO)MybatisUtil.getMapper(UserDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code =(String)session.getAttribute("activeCode");
		User user=(User)session.getAttribute("loginUser");
		if(!code1.equals(code))throw new RuntimeException("激活码输入错误");
		user.setCode(code1);
		try {
			ud.updateCode(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
	}
	/**
	 * 后台查询所有用户
	 */
	@Override
	public List<User> selectAll() {
		UserDAO ud=(UserDAO)MybatisUtil.getMapper(UserDAO.class);
		List<User> list=ud.selectAll();
		MybatisUtil.close();
		return list;
	}
	@Override
	public void changeStatus(String email) {
		UserDAO ud=(UserDAO)MybatisUtil.getMapper(UserDAO.class);
		User user = ud.login(email);
		if(user.getStatus().equals("正常")){
			user.setStatus("冻结");
		}else if(user.getStatus().equals("冻结")){
			user.setStatus("正常");
		}
		try {
			ud.changeStatus(user);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
		
	}
	
}
