package com.baizhi.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable{
	private String admin_Id;
	private String username;
	private String password;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(String admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [admin_Id=" + admin_Id + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
}
