package com.scmpi.book.entity;
import java.util.*;

import com.scmpi.book.service.CartService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.CartServiceImpl;
import com.scmpi.book.service.impl.ProductServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class Cart {  
	Map<Integer,OrderItem> map=new HashMap<Integer,OrderItem>();
	private float total_amount;	//总价
	
	public float getTotal_amount() {
		return this.sumAmount();
	}
	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}
	public Map<Integer, OrderItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, OrderItem> map) {
		this.map = map;
	}
	
	/**
	 * @description 1:第一次添加时，map.put方法直接加到集合里面
	 *              2:第二次或者多次添加时需要把已经添加好的OrderItem找出来把数量进行修改
	 * @version 1.0
	 * @param oi 
	 *        添加到map集合里面
	 * @return void
	 */
	public void addItem(OrderItem oi){
		Integer pi=oi.getP().getPid();
		if(map.containsKey(pi)){
			OrderItem oim=map.get(pi);
//			oim.setNumber(oim.getNumber()+oi.getNumber());
			oim.setOrder_num(oim.getOrder_num()+oi.getOrder_num());	//添加商品
			oim.setOrder_subtotal((oim.getOrder_num()*oi.getP().getPrice())); //设置小计价格
		}else{
			map.put(pi, oi);
		}
	}
	/**
	 * 
	 * 
	 * @author lsyil 额外创建一个类添加从数据库查询到的商品
	 * @throws Exception 
	 * 
	 * 
	 */
	
	public void addItemByDatabase(List<Product> plist,User u) throws Exception{
		
		CartService ca = new CartServiceImpl();
		ProductService ps = new ProductServiceImpl();
		Product selectp;
		
		for(Product p:plist){
			if(map.containsKey(p.getPid())){
				OrderItem oim = map.get(p.getPid());
				oim.setOrder_num(oim.getOrder_num()+1);	//添加商品
				oim.setOrder_subtotal((oim.getOrder_num()*p.getPrice())); //设置小计价格
			}else{
				
				OrderItem oim = new OrderItem();
				selectp = ps.queryById(p.getPid());
				oim.setOrder_num(ca.queryCartById(u,p.getPid()).getPnum());
				oim.setP(selectp);
				oim.setOrder_subtotal(oim.getOrder_num()*p.getPrice());//设置小计价格
				map.put(p.getPid(), oim);
			}
			
		}
		
		
		
	}
	
	
	
	/**
	 * @description 修改集合map里面的orderItem的数量 
	 * @version 1.0
	 * @param oi
	 */
	public void modifyNumber(OrderItem oi){
		Integer pid=oi.getP().getPid();
		OrderItem im=map.get(pid);
//		im.setNumber(oi.getNumber());
		im.setOrder_num(oi.getOrder_num());
//		im.setCost(oi.getP().getPrice()*im.getNumber());
		im.setOrder_subtotal(oi.getP().getPrice()*im.getOrder_num()); //修改数量
	}
	/**
	 *
	 * @description 根据pid删除map集合中的对象
	 * @version 1.0
	 * @param pid
	 */
	public void removeOrderItem(Integer pid){
		map.remove(pid);
	}
	public void clear(){
		map.clear();
	}
	public float sumAmount(){
		Collection<OrderItem> its=map.values();
		float sum=0;
		for(OrderItem oi:its){
			sum+=oi.getOrder_subtotal();
		}
		return sum;
		
	}

}
