package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.Product;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class ChangeOrderServlet extends HttpServlet {

	/*
	 * 后台订单信息修改
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		
		HttpSession session = req.getSession(true);
		
		OrderDao od = new OrderDaoImpl();
		
		Order o = new Order();
		o.setUuid(req.getParameter("uuid"));
		o.setTotal_amount(Float.valueOf(req.getParameter("total_amount")));
		o.setOrder_status(req.getParameter("order_status"));
		
		
		
		try {
			//修改订单状态和价格
			od.updateOrder(o);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("修改失败");
			em.setFoxurl("/servlet/OrderAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
		
		//页面跳转
		req.getRequestDispatcher("/servlet/OrderAdminServlet").forward(req, res);
		
		
	}

}
