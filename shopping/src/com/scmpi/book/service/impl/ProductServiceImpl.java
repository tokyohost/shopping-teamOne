package com.scmpi.book.service.impl;

import java.util.List;

import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.dao.impl.ProductDaoImpl;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.util.DBUtil;

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

	public void updateProduct(Product p)throws Exception {
		// TODO Auto-generated method stub
		//更新商品信息
		String sql ="UPDATE `product_item` SET `pname` = "
				+ "'"+p.getPname()+"', `pclassifyid` ="
				+ p.getPclassifyid()+", `pdate` = "
				+ "'"+p.getPdate()+"', `Suppliers` = "
				+ "'"+p.getSuppliers()+"', `pnumber` = "
				+ p.getPnumber()+", `price` = "
				+ p.getPrice()+", `descw` = "
				+ "'"+p.getDescw()+"', `img` = '"
				+p.getImg()+"' WHERE `pid` = "+p.getPid()+";";
		
		DBUtil.Update(sql);
		
	}

	public List<ProductType> getProductTypes() throws Exception {
		
		return dao.getProductTypes();
	}

	public List<Product> queryPdtsById(int typeid) throws Exception {
		
		return dao.queryPdtsById(typeid);
	}


}
