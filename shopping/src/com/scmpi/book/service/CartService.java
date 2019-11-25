package com.scmpi.book.service;

import java.util.List;

import com.scmpi.book.entity.CartItem;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.User;

public interface CartService {
	public void addCart(Product p,User u) throws Exception;
	public void deleteCartItem(User u,int pid) throws Exception;
	public List<Product> queryCart(User u) throws Exception;
	public CartItem queryCartById(User u,int pid) throws Exception;
	public void updateCart(int pid,int pnum,User u) throws Exception;
	public void deleteAll(User u)throws Exception; 

}
