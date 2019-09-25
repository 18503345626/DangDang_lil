package com.baizhi.entity;

import java.io.Serializable;

/**
 * 
 * @author 大帅
 *	@category 地址实体
 */
@SuppressWarnings("serial")
public class Address implements Serializable{
	private String address_id;
	private String name;
	private String local;
	private String zip_code;
	private String phone;
	private String user_id;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", name=" + name
				+ ", local=" + local + ", zip_code=" + zip_code + ", phone="
				+ phone + ", user_id=" + user_id + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (zip_code == null) {
			if (other.zip_code != null)
				return false;
		} else if (!zip_code.equals(other.zip_code))
			return false;
		return true;
	}
	

	
	
	
}
