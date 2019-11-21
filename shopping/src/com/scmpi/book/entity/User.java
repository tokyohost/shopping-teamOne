package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private Integer uid;
    //业务属性
    private String name;
    private String password;
    private String address;
    private String postCode;
    private String email;
    private String phone;
    
    public User(String address, String email, String name, 
			String password, String phone, String postCode) {
		super();
		this.address = address;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.postCode = postCode;
	}
	//关系属性
    private Set<Order> orders;
    
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User() {
		super();
	}
    
}
