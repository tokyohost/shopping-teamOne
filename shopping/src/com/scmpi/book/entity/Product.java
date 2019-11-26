package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.*;

public class Product implements Serializable {
	private Integer pid; //��Ʒid
	// ҵ������
	private String pname;	//��Ʒ��
	private String pclassifyid;	//��Ʒ����ID
	private float price;	//�۸�
	private String pdate;		//ʱ��
	
	private String suppliers;	//��Ӧ��
	private  int pnumber;	//����
	private String descw;	//����
	private int is_delete;//ɾ����Ϣ
	
	private String img;
	// ��ϵ����
	private Set<OrderItem> items;

	
	public int getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

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
