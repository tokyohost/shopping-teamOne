package com.scmpi.book.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
     private Integer oid;
     //业务属性
     private int order_num;
     private float order_subtotal;
     private int product_id;
     private int user_id;
     private String uuid;
     
     //关系属性
     private Product p;
     private Order o;
     
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Order getO() {
		return o;
	}
	public void setO(Order o) {
		this.o = o;
	}
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public float getOrder_subtotal() {
		return order_subtotal;
	}
	public void setOrder_subtotal(float order_subtotal) {
		this.order_subtotal = order_subtotal;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public OrderItem() {
		super();
	}
     
}
