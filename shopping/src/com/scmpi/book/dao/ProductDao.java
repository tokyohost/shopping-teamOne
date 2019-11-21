package com.scmpi.book.dao;
import com.scmpi.book.entity.*;

import java.util.*;
public interface ProductDao {
   public void insert(Product p) throws Exception;
   public void deleteInsert(Product p)throws Exception;
   public void update(Product p)throws Exception;
   public Product queryById(Integer id)throws Exception;
   public Product queryByName(String name)throws Exception;
   public List<Product> queryAll()throws Exception;
   public List<ProductType> getProductTypes()throws Exception;
   public List<Product> queryPdtsById(int typeid)throws Exception;
}
