package com.baizhi.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.MybatisUtil;

public class AdminServiceImpl implements AdminService{

	@Override
	public void login(Admin admin){
		AdminDAO ad=(AdminDAO)MybatisUtil.getMapper(AdminDAO.class);
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		String cod = req.getParameter("code");
		Admin a = null;
		a=ad.login(admin.getUsername());
		String code= (String)session.getAttribute("code");
		if(!cod.equals(code))throw new RuntimeException("验证码输入错误");
		if(a==null)throw new RuntimeException("该用户还不是管理员");
		if(!a.getPassword().equals(admin.getPassword()))throw new RuntimeException("密码输入错误");
		session.setAttribute("loginAdmin", a);
		MybatisUtil.close();
	}

}
