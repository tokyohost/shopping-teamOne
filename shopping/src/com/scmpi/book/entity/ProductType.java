package com.scmpi.book.entity;

public class ProductType {
	private int cid;
	private String cName;
	private String cxinhao;
	
	public ProductType(){
		//构造方法
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getCxinhao() {
		return cxinhao;
	}
	public void setCxinhao(String cxinhao) {
		this.cxinhao = cxinhao;
	}

	

}
