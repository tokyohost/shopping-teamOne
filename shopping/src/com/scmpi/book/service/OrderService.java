package com.scmpi.book.service;
import java.util.*;

import com.scmpi.book.entity.*;
public interface OrderService {
	public void insertOrder(Collection<OrderItem> items,User u) throws Exception;
	public Order getOrder(User u) throws Exception;	//����һ���Ѵ�����Order
	public Order createOrder(Collection<OrderItem> items,User u) throws Exception;	//����һ���������ǲ��������ݿ�
	public void creatInsert(Order o) throws Exception;	//����һ���Ѵ����õĶ������������ݿ�

}
