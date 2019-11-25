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
		//��ȡsession �洢��Ʒ������Ϣ
		HttpSession session = req.getSession(true);
		
		//��ȡ�û���Ϣ
		User u = (User) session.getAttribute("user");	
		//��ȡ���ﳵ��Ϣ
		
		CartService ca = new CartServiceImpl();
		Cart c = new Cart();
		List<Product> oimList = null;
		OrderService ois = new OrderServiceImpl();
		
		try {
			
			oimList = ca.queryCart(u);	//��ѯ��̨���ݿ⹺�ﳵ��Ϣ
			c.addItemByDatabase(oimList, u);	//��ӽ����ﳵ
			
			session.setAttribute("cart", c);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println("��ѯ���ﳵʧ��");
			ErrorMsg em = new ErrorMsg();
			em.setMsg("��ѯ���ݿ��еĹ��ﳵ��Ϣʧ�ܣ�");
			em.setFoxurl("/queryProduct.jsp");
			req.getRequestDispatcher("/error.jsp").forward(req, res);
		}
		
		
		
		// ҳ����ת
		
		req.getRequestDispatcher("/cart.jsp").forward(req, res);
		
		
	}
}
