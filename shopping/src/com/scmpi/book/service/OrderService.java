package com.scmpi.book.service;
import java.util.*;

import com.scmpi.book.entity.*;
public interface OrderService {
	public void insertOrder(Collection<OrderItem> items,User u) throws Exception;
	public Order getOrder(User u) throws Exception;	//返回一个已创建的Order
	public Order createOrder(Collection<OrderItem> items,User u) throws Exception;	//创建一个订单但是不插入数据库
	public void creatInsert(Order o) throws Exception;	//接受一个已创建好的订单并插入数据库
	public void updateIntegral(Order o,User u) throws Exception;	//修改积分
	public void updateStatus(Order o,String status) throws Exception;	//修改订单状态

} 
