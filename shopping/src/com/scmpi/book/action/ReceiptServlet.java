package com.scmpi.book.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.impl.OrderServiceImpl;

public class ReceiptServlet extends HttpServlet {

	/*
	 * 用户修改订单状态
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		//获取需要修改的订单uuid信息
//		User u = (User) session.getAttribute("user");	
		Order o = new Order();
		o.setUuid(req.getParameter("uuid"));
		
		OrderService os = new OrderServiceImpl();
		
		try {
			os.updateStatus(o, "已签收");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}
		
		
		// 页面跳转
		
//		res.sendRedirect("/shopping/ordershow.jsp");
		req.getRequestDispatcher("/OrderShowServlet").forward(req, res);
		
		
		
		
	}
	

}
