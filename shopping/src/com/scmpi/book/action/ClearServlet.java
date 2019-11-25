package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.CartService;
import com.scmpi.book.service.impl.CartServiceImpl;

public class ClearServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		HttpSession session=req.getSession(true);
		Cart c=(Cart)session.getAttribute("cart");
		User u = (User)session.getAttribute("user");
		
		c.clear();
		
		CartService ca = new CartServiceImpl();
		try {
			ca.deleteAll(u);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		req.getRequestDispatcher("/cart.jsp").forward(req, res);
	}
    
}
