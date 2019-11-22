package com.scmpi.book.dao.impl;

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.UserDao;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.User;
import com.scmpi.book.util.*;

import java.sql.*;

public class OrderDaoImpl implements OrderDao {

	public void insertOrder(Order o) throws Exception {
		
		try {
			
//			int ids = CheckId.getOid("order_item");
			User u = o.getUser();
			int uid = u.getUid();
			Getorder_uuid gu = new  Getorder_uuid();
			String uuid = gu.getuuid();	//获取uuid作为订单唯一识别码
			String sql = "insert into `Order`(`user_id`,`Total_amount`,`order_date`,`order_status`,`uuid`)values("
				+ uid
				+ ","
				+ o.getTotal_amount()
				+ ", NOW(),'"
				+ o.getOrder_status() + "','"+uuid+"')";
			System.out.println("SQL="+sql);
			DBUtil.Update(sql);	
//			o.setOrder_id(ids);	//表中是自动递增，应该不用获取
			
			
//			
			for (OrderItem oi : o.getItems()) {
				int pid=oi.getP().getPid();
				String sql1 = "insert into `Order_item`(`Oid`,`user_id`,`product_id`,`order_num`,`order_Subtotal`,`uuid`) values(NULL,"
						+ u.getUid() + ","+oi.getP().getPid()+","+oi.getOrder_num()+","+oi.getOrder_subtotal()+",'"+uuid+"')";
				DBUtil.Update(sql1);
//				oi.setOiid(itemid);	//oid自增无需设置
				
			}
//			UserDao udao=new UserDaoImpl();
//			udao.updateUser(u);
		} catch (Exception e) {
             e.printStackTrace();
		}

	}

}
