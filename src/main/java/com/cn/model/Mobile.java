package com.cn.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mobile implements Serializable{
	private Integer id;
	private String phonenumber;
	
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
