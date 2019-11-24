package com.scmpi.book.action;

import java.io.IOException;
import java.util.*;

import com.scmpi.book.entity.*;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderServlet extends HttpServlet {
	
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	
		
		
//		res.setContentType("text/html");
//		String address=req.getParameter("uaddress");
//		String uphone=req.getParameter("uphone");
//		String uemail=req.getParameter("umail");
////		String uphone=req.getParameter("uphone");
//		
		HttpSession session=req.getSession(true);
		
		Cart c=(Cart)session.getAttribute("cart");
		User u=(User)session.getAttribute("user");
		Collection<OrderItem> items=c.getMap().values();
		OrderService oservice=new OrderServiceImpl();
		Order o;
		
		
		try {
			
			oservice.createOrder(items, u);	//仅尝试创建订单
//			oservice.insertOrder(items, u);
			o = oservice.getOrder(u);//获取订单对象，判断是否够购买，余额不够无法购买则返回error.jsp
			//计算折扣
			float discountAmount = o.getTotal_amount()*(Float.valueOf(u.getDiscount()) /100);
			o.setTotal_amount(discountAmount);
			o.setOrder_status("已提交订单，折扣为"+(u.getDiscount()) /10 +"折");
			
			//判断是否提交空订单
			if(o.getItems().isEmpty() && o.getTotal_amount() == 0.0){
				ErrorMsg em = new ErrorMsg();
				em.setMsg("请检查订单是否为空！不允许提交空订单~");
				em.setFoxurl("/BackIndexServlet");//跳转首页
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req,res);
			}else if(o.getTotal_amount() < u.getBalance()){
				oservice.creatInsert(o);			//插入订单到数据库
				oservice.updateIntegral(o, u);		//更新积分
				UserService updateUser = new UserServiceImpl();
				session.setAttribute("user",updateUser.getUser(u.getUid()));	//更新用户数据
				
				
				req.getRequestDispatcher("/ok.jsp").forward(req,res);
			}else{
				ErrorMsg em = new ErrorMsg();
				em.setMsg("余额不足，请充值！");
				em.setFoxurl("/servlet/balance");//跳转充值页面
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req,res);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req,res);
		}
	}

}
