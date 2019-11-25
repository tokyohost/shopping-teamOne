package com.scmpi.book.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.CartService;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.CartServiceImpl;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class ModifyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		/*
		 * 1:�õ���Ҫ�޸ĵ���Ʒ��id 2:�õ���Ʒid��Ӧ������ 3:Cart�����õ� ���������modifyNumber(OrderItem
		 * oi)
		 */
		res.setContentType("text/html");
		// str[0]-----num[0]
		String[] str = req.getParameterValues("pid");
		String[] num = req.getParameterValues("pnum");
		try {
			HttpSession session = req.getSession(true);
			
			User u = (User) session.getAttribute("user");
			
			
			Cart c = (Cart) session.getAttribute("cart");
			ProductService ps = new ProductServiceImpl();
			for (int i = 0; i < num.length; i++) {
				OrderItem oi = new OrderItem();
				oi.setOrder_num(Integer.parseInt(num[i].trim()));
				oi.setP(ps.queryById(Integer.valueOf(str[i].trim())));
				oi.setOrder_subtotal(oi.getOrder_num()*oi.getP().getPrice());
				//tmd��ֱ��ʺɽ���ɶ��Լ��������
				c.modifyNumber(oi);
			}
			//�����������ݿ����
			CartService ca = new CartServiceImpl();
			for (int i =0 ;i<num.length;i++){
				ca.updateCart(Integer.valueOf(str[i].trim()),Integer.parseInt(num[i].trim()),u);
			}
			
			req.getRequestDispatcher("/cart.jsp").forward(req, res);
		} catch (Exception e) {
              e.printStackTrace();
		}
	}

}
