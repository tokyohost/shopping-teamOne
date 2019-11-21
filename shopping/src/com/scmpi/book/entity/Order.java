package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.*;

public class Order implements Serializable {
	private Integer oid;
	// 业务属性
	private String status;
	private double cost;
	private String date;
    //关系属性
	private User user;
	private Set<OrderItem> items;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Order() {
		super();
	}

}
