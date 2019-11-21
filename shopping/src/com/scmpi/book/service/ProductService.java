package com.scmpi.book.service;
import java.util.*;

import com.scmpi.book.entity.*;
public interface ProductService {
	public void insert(String name,String desc,double price)throws Exception;
    public void deleteProduct(Integer id)throws Exception;
    public Product queryByName(String name)throws Exception;
    public Product queryById(Integer id)throws Exception;
    public List<Product> queryAll()throws Exception;
    public void updateProduct(double cost,String desc,String name )throws Exception;
    public List<ProductType> getProductTypes()throws Exception;
    public List<Product> queryPdtsById(int typeid)throws Exception;
}
