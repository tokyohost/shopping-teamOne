package com.scmpi.book.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;

public class DeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		String[] str = req.getParameterValues("ppid");
		try {
			HttpSession session = req.getSession(true);
			Cart c = (Cart) session.getAttribute("cart");
			for (int i = 0; i < str.length; i++) {
				c.removeOrderItem(Integer.valueOf(str[i].trim()));
			}
			req.getRequestDispatcher("/cart.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
