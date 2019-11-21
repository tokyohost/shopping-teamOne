package com.scmpi.book.action;

import java.io.IOException;
import java.util.*;

import com.scmpi.book.entity.*;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		String address=req.getParameter("uadd");
		String post=req.getParameter("upost");
		String mail=req.getParameter("umail");
		String phone=req.getParameter("uphone");
		HttpSession session=req.getSession(true);
		Cart c=(Cart)session.getAttribute("cart");
		User u=(User)session.getAttribute("user");
		u.setAddress(address);
		u.setPostCode(post);
		u.setEmail(mail);
		u.setPhone(phone);
		Collection<OrderItem> items=c.getMap().values();
		OrderService oservice=new OrderServiceImpl();
		
		try {
			oservice.insertOrder(items, u);
			req.getRequestDispatcher("/ok.jsp").forward(req,res);
		} catch (Exception e) {
			
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req,res);
		}
	}

}
