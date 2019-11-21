package com.scmpi.book.service.impl;

import java.util.List;

import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.dao.impl.ProductDaoImpl;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao=new ProductDaoImpl() ;
	public void deleteProduct(Integer id) throws Exception{
		// TODO Auto-generated method stub

	}

	public void insert(String name, String desc, double price)throws Exception {
		// TODO Auto-generated method stub

	}

	public List<Product> queryAll()throws Exception {
		return dao.queryAll();
	}

	public Product queryById(Integer id)throws Exception {
		return dao.queryById(id);
	}

	public Product queryByName(String name) throws Exception{
		// TODO Auto-generated method stub
		return dao.queryByName(name);
	}

	public void updateProduct(double cost, String desc, String name)throws Exception {
		// TODO Auto-generated method stub

	}

	public List<ProductType> getProductTypes() throws Exception {
		
		return dao.getProductTypes();
	}

	public List<Product> queryPdtsById(int typeid) throws Exception {
		
		return dao.queryPdtsById(typeid);
	}

}
