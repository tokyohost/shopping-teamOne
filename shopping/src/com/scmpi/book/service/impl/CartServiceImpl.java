package com.scmpi.book.service.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.CartItem;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.CartService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.util.DBUtil;

public class CartServiceImpl implements CartService{

	@Override
	public void addCart(Product p,User u) throws Exception {
		// TODO �Զ����ɵķ������
		//�Ȳ�ѯ�Ƿ��д���Ʒ����������޸�������û�������
		
		String querySql= "select * from `cart` where `user_id` = "+u.getUid()+" and `product_id` = "+p.getPid()+";";
		ResultSet rs = DBUtil.queryData(querySql);
		if(rs.next()){
			
			String updateSql = "UPDATE `cart` SET `pnum` = "+(rs.getInt("pnum") + 1)+" WHERE `user_id` = "+u.getUid()+" and `product_id`="+p.getPid()+";";
			DBUtil.Update(updateSql);
			
		}else{
			/*
			 * SimpleDataFormat 
			 * ��Ҫ��ȡʱ��
			 */
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		    Date d=new Date();
		    String str=sf.format(d);
		    
		    
			String sql = "INSERT INTO `cart`(`user_id`, `product_id`, `cart_date`, `pnum`) VALUES ("+u.getUid()+", "+p.getPid()+", '"+str+"', 1)";
			System.out.println(sql);
			DBUtil.Update(sql);
			
		}
		rs.close();
		
	}

	@Override
	public void deleteCartItem(User u,int pid) throws Exception {
		// TODO �Զ����ɵķ������
		//ɾ�����ﳵ�е�ĳһ��
		String sql ="delete from `cart` where `user_id`="+u.getUid()+" and `product_id`="+pid+";";
		DBUtil.Update(sql);
		
	}

	@Override
	public List<Product> queryCart(User u) throws Exception {
		// TODO �Զ����ɵķ������
		//��ѯ���ﳵ
		//�Ȳ鹺�ﳵ���ٲ���Ʒ��
		ResultSet rs = null;
		List<Product> pList = new ArrayList<Product>();
		ProductService ps = new ProductServiceImpl();
		
		String sql = "select * from `cart` where `user_id` = "+u.getUid();
		rs = DBUtil.queryData(sql);
		List<CartItem> cList = new ArrayList<CartItem>();
		
			while(rs.next()){
				CartItem ci = new CartItem();
				ci.setCart_data(rs.getString("cart_date"));
				ci.setCart_id(rs.getInt("cart_id"));
				ci.setUser_id(rs.getInt("user_id"));
				ci.setPnum(rs.getInt("pnum"));
				ci.setProduct_id(rs.getInt("product_id"));
				
				cList.add(ci);
			}
		
		for(CartItem ci:cList){	//���δӱ���ȡ��Ʒ��Ϣ
			pList.add(ps.queryById(ci.getProduct_id()));
		}
		
		rs.close();
		return pList;
	}

	@Override
	public void updateCart(int pid,int pum,User u) throws Exception {
		// TODO �Զ����ɵķ������
		//�޸Ĺ��ﳵ����
		String sql = "UPDATE `cart` SET `pnum` = "+pum+" WHERE `product_id` = "+pid+" and `user_id`="+u.getUid()+";";
		DBUtil.Update(sql);
		
		
	}

	@Override
	public CartItem queryCartById(User u,int pid) throws Exception {
		// TODO �Զ����ɵķ������
		/*
		 * ��ѯ�û�����ĳ�����ﳵ��
		 */
		String sql = "select * from `cart` where `user_id`="+u.getUid()+" and `product_id`="+pid+";";
		CartItem ca =null;
		
		
		ResultSet rs =DBUtil.queryData(sql);
			while(rs.next()){
				ca = new CartItem();
				ca.setCart_id(rs.getInt("cart_id"));
				ca.setUser_id(rs.getInt("user_id"));
				ca.setProduct_id(rs.getInt("product_id"));
				ca.setCart_data(rs.getString("cart_date"));
				ca.setPnum(rs.getInt("pnum"));
				
			}
		return ca;
	}

	@Override
	public void deleteAll(User u) throws Exception {
		// TODO �Զ����ɵķ������
		/*
		 * ��չ��ﳵ
		 */
		
		String sql ="delete from `cart` where `user_id`="+u.getUid()+";";
		DBUtil.Update(sql);
		
	}

	

}
