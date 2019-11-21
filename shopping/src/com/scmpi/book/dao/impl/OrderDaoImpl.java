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
			
			int ids = CheckId.getOid("order_id");
			User u = o.getUser();
			int uid = u.getUid();
			String sql = "insert into cart_order(id,status,odate,cost,user_id)values("
				+ ids
				+ ",'"
				+ o.getStatus()
				+ "', '"+o.getDate()+"' ,"
				+ o.getCost() + ", 1 )";
			DBUtil.Update(sql);	
			o.setOid(ids);
			for (OrderItem oi : o.getItems()) {
				int itemid = CheckId.getOid("orderitem_id");
				int pid=oi.getP().getPid();
				String sql1 = "insert into cart_item(id,amount,cost,book_id,order_id)values("
						+ itemid + ","+oi.getNumber()+","+oi.getCost()+","+pid+","+ids+")";
				DBUtil.Update(sql1);
				oi.setOiid(itemid);
			}
			UserDao udao=new UserDaoImpl();
			udao.updateUser(u);
		} catch (Exception e) {
             e.printStackTrace();
		}

	}

}
