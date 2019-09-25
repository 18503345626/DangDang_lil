package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport{
	private User user;
	private String message;
	private String yzcode;
	private String activeCode;
	private String code1;
	private List<User> list;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getYzcode() {
		return yzcode;
	}
	public void setYzcode(String yzcode) {
		this.yzcode = yzcode;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * @return 登录
	 */
	public String login(){
		UserService usi = new UserServiceImpl();
		try {
			usi.login(user);
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			message=e.getMessage();
			return Action.ERROR;
		}
		
	}
	/**
	 * 
	 * @return 注册用户信息
	 */
	public String register(){
		UserService usi = new UserServiceImpl();
		try {
			usi.register(user,yzcode);
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	/**
	 * 
	 * @return 获取激活码
	 */
	public String getCode(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		activeCode=MD5Utils.getNum();
		session.setAttribute("activeCode", activeCode);
		return Action.SUCCESS;
	}
	/**
	 * 
	 * @return 激活码写入代码
	 */
	public String registerOk(){
		UserService usi = new UserServiceImpl();
		try {
			usi.registerOk(code1);
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			message=e.getMessage();
			return Action.ERROR;
		}
	}
	/**
	 * 
	 * @return 退出登录
	 */
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("loginUser");
		session.removeAttribute("cart");
		return Action.SUCCESS;
	}
	/**
	 * 
	 * @return 查询所有用户
	 */
	public String selectAll(){
		UserService usi = new UserServiceImpl();
		list=usi.selectAll();
		return Action.SUCCESS;
	}
	/**
	 * 
	 * @return 修改状态
	 */
	public String changeStatus(){
		UserService usi = new UserServiceImpl();
		usi.changeStatus(email);
		return Action.SUCCESS;
	}
}
