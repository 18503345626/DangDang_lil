package com.baizhi.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.impl.AdminServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
	public Admin admin;
	public String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	/**
	 * @category 登录
	 * @return 成功或者失败
	 */
	public String login(){
		AdminService asi = new AdminServiceImpl();
		try {
			asi.login(admin);
			return Action.SUCCESS;
		} catch (Exception e) {
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	/**
	 * @category 安全退出
	 * @return 
	 */
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "logout";
	}
}
