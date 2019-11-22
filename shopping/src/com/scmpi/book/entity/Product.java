package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.*;

public class Product implements Serializable {
	private Integer pid; //商品id
	// 业务属性
	private String pname;	//商品名
	private String pclassifyid;	//商品分类ID
	private float price;	//价格
	private String pdate;		//时间
	
	private String suppliers;	//供应商
	private  int pnumber;	//数量
	private String descw;	//描述
	
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPclassifyid() {
		return pclassifyid;
	}

	public void setPclassifyid(String pclassifyid) {
		this.pclassifyid = pclassifyid;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public String getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getDescw() {
		return descw;
	}

	public void setDescw(String descw) {
		this.descw = descw;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	

	

}
