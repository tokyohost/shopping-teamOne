package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.CartService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.CartServiceImpl;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class AddCartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	     String name=new String(req.getParameter("pname").getBytes("iso-8859-1"),"utf-8");
		HttpSession session=req.getSession(true);
		//获取购物车
		Cart c=(Cart)session.getAttribute("cart");
		ProductService pservice =new ProductServiceImpl();
		User u = (User)session.getAttribute("user");
		try{
			OrderItem oi=new OrderItem();//订单项对象
			oi.setOrder_num(1);	//第一次下单数量为1
			Product p = pservice.queryByName(name);
			oi.setP(p);
			oi.setOrder_subtotal(p.getPrice()*oi.getOrder_num());	//设置小计金额
			c.addItem(oi);//将订单项放入购物车
			
			
			CartService ca = new CartServiceImpl();	
			ca.addCart(p, u);//添加进数据库
			
			
			
			
			//req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
			req.setAttribute("datas",session.getAttribute("datas"));
			req.setAttribute("pageNo", session.getAttribute("pageNo"));
			req.setAttribute("pageSize", session.getAttribute("pageSize"));
			req.setAttribute("recordCount", session.getAttribute("recordCount"));
		    req.getRequestDispatcher("/queryProduct.jsp").forward(req,res);
		}catch(Exception e){
			
			req.getRequestDispatcher("/error.jsp").forward(req,res);
		}
		
	}
    
}
