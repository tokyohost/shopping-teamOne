package com.scmpi.book.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.scmpi.book.dao.ProductDao;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	public void deleteInsert(Product p) throws Exception {

	}

	public void insert(Product p) throws Exception {

	}

	public List<Product> queryAll() throws Exception {

		List<Product> list = new ArrayList<Product>();
		try {

			String sql = "select * from cart_book";
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("id"));
				p.setDescw(rs.getString("description"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setImg(rs.getString("img"));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product queryById(Integer id) throws Exception {

		Product p = new Product();
		try {

			String sql = "select * from cart_book where id=" + id;
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {

				p.setPid(rs.getInt("id"));
				p.setDescw(rs.getString("description"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setImg(rs.getString("img"));
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Product queryByName(String name) throws Exception {

		Product p = new Product();
		try {
			String sql = "select * from cart_book where name='" + name
					+ "'";
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				p.setPid(rs.getInt("id"));
				p.setDescw(rs.getString("description"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setImg(rs.getString("img"));
			}
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void update(Product p) throws Exception {
		// TODO Auto-generated method stub

	}

	// 产品类型
	public List<ProductType> getProductTypes() throws Exception {

		List<ProductType> list = new ArrayList<ProductType>();
		try {

			String sql = "select * from book_type";
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				ProductType pt = new ProductType();
				pt.setId(rs.getInt("id"));
				pt.setTypeName(rs.getString("book_type_name"));
				list.add(pt);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Product> queryPdtsById(int typeid) throws Exception {

		List<Product> list = new ArrayList<Product>();
		try {

		 String sql="select * from cart_book where book_type_id='"+typeid+"'";
		 
			ResultSet rs = DBUtil.queryData(sql);
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("id"));
				p.setDescw(rs.getString("description"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setImg(rs.getString("img"));
				list.add(p);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
