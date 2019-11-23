package com.scmpi.book.service.impl;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.scmpi.book.dao.*;
import com.scmpi.book.dao.impl.*;
import com.scmpi.book.entity.*;
import com.scmpi.book.service.OrderService;
import java.util.*;
public class OrderServiceImpl implements OrderService {
    OrderDao dao=new OrderDaoImpl();
	public void insertOrder(Collection<OrderItem> items, User u)
			throws Exception {
		try {
			//创建订单
			Order  o=new Order();
			Set<OrderItem> ois=new HashSet<OrderItem>();
			float sum=0;
			for(OrderItem oi:items){
				sum+=oi.getOrder_subtotal();	//计算总价
				ois.add(oi);
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		    Date d=new Date();
		    String str=sf.format(d);
			o.setOrder_date(str);;
			o.setOrder_status("已提交订单");
			o.setUser(u);
			o.setItems(ois);
			o.setTotal_amount(sum);	
			dao.insertOrder(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
