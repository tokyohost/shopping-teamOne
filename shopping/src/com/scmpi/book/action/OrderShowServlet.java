package com.scmpi.book.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.User;

/**
 * Servlet implementation class OrderShowServlet
 */
public class OrderShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		//获取用户信息
		User u = (User) session.getAttribute("user");	
		
		
		System.out.println("开始查询订单信息");
		try {
			List<Order> orderlist = OrderDaoImpl.queryOrder(u);
			session.setAttribute("Orderlist", orderlist);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			
		}
		
		
		// 页面跳转
		
//		res.sendRedirect("/shopping/ordershow.jsp");
		req.getRequestDispatcher("/ordershow.jsp").forward(req, res);
		
		
		
		
	}

}
