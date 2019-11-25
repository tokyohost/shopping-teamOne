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
import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.CartService;
import com.scmpi.book.service.OrderItemService;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.impl.CartServiceImpl;
import com.scmpi.book.service.impl.OrderServiceImpl;

public class QueryCartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		//获取用户信息
		User u = (User) session.getAttribute("user");	
		//获取购物车信息
		
		CartService ca = new CartServiceImpl();
		Cart c = new Cart();
		List<Product> oimList = null;
		OrderService ois = new OrderServiceImpl();
		
		try {
			
			oimList = ca.queryCart(u);	//查询后台数据库购物车信息
			c.addItemByDatabase(oimList, u);	//添加进购物车
			
			session.setAttribute("cart", c);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("查询购物车失败");
			ErrorMsg em = new ErrorMsg();
			em.setMsg("查询数据库中的购物车信息失败！");
			em.setFoxurl("/queryProduct.jsp");
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
		
		
		
		// 页面跳转
		
		req.getRequestDispatcher("/cart.jsp").forward(req, res);
		
		
	}
}
