package com.scmpi.book.dao.impl;

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.UserDao;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.User;
import com.scmpi.book.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderDaoImpl implements OrderDao {

	public void insertOrder(Order o) throws Exception {
		
		try {
			
//			int ids = CheckId.getOid("order_item");
			User u = o.getUser();
			int uid = u.getUid();
			Getorder_uuid gu = new  Getorder_uuid();
			String uuid = gu.getuuid();	//获取uuid作为订单唯一识别码
			String sql = "insert into `Order`(`user_id`,`Total_amount`,`order_date`,`order_status`,`uuid`)values("
				+ uid
				+ ","
				+ o.getTotal_amount()
				+ ", '"+o.getOrder_date()+"','"
				+ o.getOrder_status() + "','"+uuid+"')";
			System.out.println("SQL="+sql);
			DBUtil.Update(sql);	
//			o.setOrder_id(ids);	//表中是自动递增，应该不用获取
			
			
//			
			for (OrderItem oi : o.getItems()) {
				int pid=oi.getP().getPid();
				String sql1 = "insert into `Order_item`(`Oid`,`user_id`,`product_id`,`order_num`,`order_Subtotal`,`uuid`) values(NULL,"
						+ u.getUid() + ","+oi.getP().getPid()+","+oi.getOrder_num()+","+oi.getOrder_subtotal()+",'"+uuid+"')";
				DBUtil.Update(sql1);
//				oi.setOiid(itemid);	//oid自增无需设置
				
			}
			
			//以下对下单商品数量进行修改
			
			for (OrderItem oi : o.getItems()){
				int pid = oi.getP().getPid();	//获取需要修改的商品id
				/*
				 * (oi.getP().getPnumber()-oi.getOrder_num()) 获取之前商品数量减去下单项中小计数量
				 */
				String changeSql = "UPDATE `product_item` SET  `pnumber` = "+(oi.getP().getPnumber()-oi.getOrder_num())+" WHERE `pid` = "+pid+";";
				
				DBUtil.Update(changeSql);
			}
			
			//以下对用户余额进行修改
			float balance = u.getBalance()-o.getTotal_amount();	//计算下单后减去总价后用户余额
			String cBalanceSql = "UPDATE `user` SET `balance` = "+balance+" WHERE `uid` = "+u.getUid()+";";
			DBUtil.Update(cBalanceSql);
			
		} catch (Exception e) {
             e.printStackTrace();
		}

	}
	
	
	static public List<Order> queryOrder(User u) throws ClassNotFoundException, SQLException{
		//从数据库获取订单信息
		
		String sql = "select * from `Order` where `user_id`="+u.getUid();
		
		//获取订单结果集
		ResultSet rs = DBUtil.queryData(sql);
		
		
		List<Order> orderlist = new ArrayList<Order>();
		
			while(rs.next()){
				Order o = new Order();
				o.setOrder_id(rs.getInt("Order_id"));
				o.setUser_id(rs.getInt("user_id"));
				o.setTotal_amount(rs.getFloat("Total_amount"));
				o.setOrder_date(rs.getString("order_date"));
				o.setOrder_status(rs.getString("order_status"));
				o.setUuid(rs.getString("uuid"));
				
				
				
				orderlist.add(o);//添加到结果列表中
				
			}
			//获取关系对象订单每一项order_item
			for(Order o:orderlist){
				List<OrderItem> oid = new ArrayList<OrderItem>();
				String uuid = o.getUuid();
				//根据订单uuid查询订单项
				String sql1 = "select * from `Order_item` where `uuid`='"+uuid+"';";

				rs = DBUtil.queryData(sql1);	//查询结果集重新赋值
				
					while(rs.next()){
						OrderItem oi = new OrderItem();
						oi.setOid(rs.getInt("Oid"));
						oi.setUser_id(rs.getInt("user_id"));
						oi.setProduct_id(rs.getInt("product_id"));
						oi.setOrder_num(rs.getInt("order_num"));
						oi.setOrder_subtotal(rs.getFloat("order_Subtotal"));
						oi.setUuid(uuid);
						
						oid.add(oi);
					}
					
					//根据product_id 查询商品信息
					for(OrderItem oi:oid){
						int productid = oi.getProduct_id();	//获取product_id 查询product_item中的商品项
						
						String sql2 = "select * from `product_item` where `pid`="+productid+";";
						
						
						rs = DBUtil.queryData(sql2);	//查询结果集重新赋值
						
						
							while(rs.next()){
								Product p = new Product();
								p.setPid(productid);
								p.setPname(rs.getString("pname"));
								p.setPclassifyid(String.valueOf(rs.getInt("pclassifyid")));
								p.setPdate(rs.getString("pdate"));
								p.setSuppliers(rs.getString("Suppliers"));
								p.setPnumber(rs.getInt("pnumber"));
								p.setPrice(rs.getFloat("price"));
								
								oi.setP(p);
							}
					}
					Set<OrderItem> cache = new HashSet<OrderItem>(oid);			//List列表转  Set，真无情！
					o.setItems(cache);
			}
			
			
			return orderlist;
			
		
	}
	
	
	public static void main(String[] args) {
		User u = new User();
		u.setUid(10);
		
		try {
			List<Order> o = queryOrder(u);
			for(OrderItem or :o.get(0).getItems()){
				System.out.println(or.getP().getPname());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
