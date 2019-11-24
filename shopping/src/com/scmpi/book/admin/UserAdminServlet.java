package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class UserAdminServlet extends HttpServlet {

	/*
	 * 后台用户管理
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		UserService user = new UserServiceImpl();
		
		try {
			session.setAttribute("userCount", user.getUserCount());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//页面跳转
		req.getRequestDispatcher("/admin/user.jsp").forward(req, res);
		
		
		
		
	}
}
