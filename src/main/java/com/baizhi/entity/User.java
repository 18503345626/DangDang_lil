package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Administrator
 * @category 用户表实体
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	private String user_id;
	private String email;
	private String password;
	private String nickname;
	private String status;
	private String salt;
	private String code;
	private Date create_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", password="
				+ password + ", nickname=" + nickname + ", status=" + status
				+ ", salt=" + salt + ", code=" + code + ", create_date="
				+ create_date + "]";
	}
	
}
