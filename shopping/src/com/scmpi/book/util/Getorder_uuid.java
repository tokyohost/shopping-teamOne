package com.scmpi.book.util;

import java.sql.ResultSet;
import java.util.UUID;

public class Getorder_uuid {
	
	DBUtil db = new DBUtil();
	String uuid;
	
	public Getorder_uuid(){
		
	}
	
	
	public String getuuid(){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		this.uuid = uuid;
		return uuid;
	}
	
	

}
