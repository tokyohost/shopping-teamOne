package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import com.scmpi.book.service.impl.ProductServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

public class OrderAdminServlet extends HttpServlet {

	/**
	 * 后台订单管理
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		OrderDao od = new OrderDaoImpl();
		UserService os = new UserServiceImpl();
		List<Order> oList = new ArrayList<Order>();
		
		
		try {
			//获取所有订单
			oList = od.queryAllOrder();
			//获取订单数量
			int orderNum = oList.size();
			
			//查询所有用户信息
			List<User> ulist = os.queryAllUser();	
			session.setAttribute("ulist", ulist);
			session.setAttribute("olist", oList);
			session.setAttribute("orderNum", orderNum);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//页面跳转
		req.getRequestDispatcher("/admin/order.jsp").forward(req, res);
		
	}

}
