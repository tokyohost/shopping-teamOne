package com.scmpi.book.entity;

import java.io.Serializable;
import java.util.*;

//public class User implements Serializable {
//    private Integer uid;
//    //业务属性
//    private String name;
//    private String password;
//    private String address;
//    private String postCode;
//    private String email;
//    private String phone;
//    
//    public User(String address, String email, String name, 
//			String password, String phone, String postCode) {
//		super();
//		this.address = address;
//		this.email = email;
//		this.name = name;
//		this.password = password;
//		this.phone = phone;
//		this.postCode = postCode;
//	}
//	//关系属性
//    private Set<Order> orders;
//    
//	public Set<Order> getOrders() {
//		return orders;
//	}
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}
//	public Integer getUid() {
//		return uid;
//	}
//	public void setUid(Integer uid) {
//		this.uid = uid;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getPostCode() {
//		return postCode;
//	}
//	public void setPostCode(String postCode) {
//		this.postCode = postCode;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public User() {
//		super();
//	}
//    
//}

public class User implements Serializable{
	//成员信息
	int uid;	//用户id
	String uname;	//姓名
	String upasswd;	//密码
	String uemail; //邮箱
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	String usex;	//性别
	String birthday;	//生日
	String uphone;	//电话
	String uaddress;	//地址
	float balance;	//余额
	int discount;	//折扣
	int integral;	//积分
	public User(){
		//无参数构造方法
	}
	public User(String uname,String upasswd,String email,String usex,String birthday,String uphone,String uaddress,float balance,int discount,int integral){
		//构造方法
		this.uname = uname;
		this.upasswd = upasswd;
		this.uemail = uemail;
		this.usex = usex;
		this.birthday = birthday;
		this.uphone = uphone;
		this.uaddress = uaddress;
		this.balance = balance;
		this.discount = discount;
		this.integral = integral;
	}
	
	public User(int uid,String uname,String upasswd,String uemail,String usex,String birthday,String uphone,String uaddress,float balance,int discount,int integral){
		//构造方法
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.upasswd = upasswd;
		this.usex = usex;
		this.birthday = birthday;
		this.uphone = uphone;
		this.uaddress = uaddress;
		this.balance = balance;
		this.discount = discount;
		this.integral = integral;
	}
	
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpasswd() {
		return upasswd;
	}
	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	
	
	
	
	
}
