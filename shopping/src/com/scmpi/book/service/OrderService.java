package com.scmpi.book.service;
import java.util.*;

import com.scmpi.book.entity.*;
public interface OrderService {
	public void insertOrder(Collection<OrderItem> items,User u) throws Exception;

}
