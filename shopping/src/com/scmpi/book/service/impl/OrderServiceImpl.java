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
    Order o;
	public void insertOrder(Collection<OrderItem> items, User u)
			throws Exception {
		try {
			//��������
			o=new Order();
			Set<OrderItem> ois=new HashSet<OrderItem>();
			float sum=0;
			for(OrderItem oi:items){
				sum+=oi.getOrder_subtotal();	//�����ܼ�
				ois.add(oi);
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		    Date d=new Date();
		    String str=sf.format(d);
			o.setOrder_date(str);;
			o.setOrder_status("���ύ����");
			o.setUser(u);
			o.setItems(ois);
			o.setTotal_amount(sum);	
			dao.insertOrder(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public Order getOrder(User u) throws Exception {
		// TODO �Զ����ɵķ������
		//������create ֮���ܻ�ȡorder
		Order o = this.o;
		return o;
		
	}
	@Override
	public Order createOrder(Collection<OrderItem> items, User u)
			throws Exception {
		// TODO �Զ����ɵķ������
		
		
		try {
			//��������
			o=new Order();
			Set<OrderItem> ois=new HashSet<OrderItem>();
			float sum=0;
			for(OrderItem oi:items){
				sum+=oi.getOrder_subtotal();	//�����ܼ�
				ois.add(oi);
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		    Date d=new Date();
		    String str=sf.format(d);
			o.setOrder_date(str);;
			o.setOrder_status("�Ѵ�������");
			o.setUser(u);
			o.setItems(ois);
			o.setTotal_amount(sum);	
//			dao.insertOrder(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
	@Override
	public void creatInsert(Order o) throws Exception {
		// TODO �Զ����ɵķ������
		dao.insertOrder(o);
		
	}
	
	

}

