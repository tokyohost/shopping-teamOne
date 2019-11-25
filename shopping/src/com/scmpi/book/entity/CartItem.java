package com.scmpi.book.entity;

public class CartItem {
	int cart_id;
	int user_id;
	int product_id;
	String cart_data;
	int pnum;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getCart_data() {
		return cart_data;
	}
	public void setCart_data(String cart_data) {
		this.cart_data = cart_data;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	

}
