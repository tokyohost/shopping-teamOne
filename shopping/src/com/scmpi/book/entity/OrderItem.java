package com.scmpi.book.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
     private Integer oiid;
     //业务属性
     private int number;
     private double cost;
     //关系属性
     private Product p;
     private Order o;
     
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public Order getO() {
		return o;
	}
	public void setO(Order o) {
		this.o = o;
	}
	public Integer getOiid() {
		return oiid;
	}
	public void setOiid(Integer oiid) {
		this.oiid = oiid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public OrderItem() {
		super();
	}
     
}
