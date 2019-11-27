package com.scmpi.book.dao;
import java.util.List;

import com.scmpi.book.entity.*;
public interface OrderDao {
	public void insertOrder(Order o) throws Exception;
	public List<Order> queryOrder(User u) throws Exception;
	public List<Order> queryAllOrder() throws Exception;
	public void updateOrder(Order o) throws Exception;
}
