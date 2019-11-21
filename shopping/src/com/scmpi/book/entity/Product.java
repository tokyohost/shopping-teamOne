package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.*;

public class Product implements Serializable {
	private Integer pid; //
	// 业务属性
	private String name;
	private String descw;
	private double price;

	private String img;
	// 关系属性
	private Set<OrderItem> items;

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescw() {
		return descw;
	}

	public void setDescw(String descw) {
		this.descw = descw;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
