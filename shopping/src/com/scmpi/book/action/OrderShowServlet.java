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

import com.scmpi.book.dao.OrderDao;
import com.scmpi.book.dao.impl.OrderDaoImpl;
import com.scmpi.book.entity.Order;
import com.scmpi.book.entity.OrderItem;
import com.scmpi.book.entity.User;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderShowServlet
 */
public class OrderShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//��ȡsession �洢��Ʒ������Ϣ
		HttpSession session = req.getSession(true);
		
		//��ȡ�û���Ϣ
		User u = (User) session.getAttribute("user");	
		OrderDao os = new OrderDaoImpl();
		
		System.out.println("��ʼ��ѯ������Ϣ");
		try {
			List<Order> orderlist = os.queryOrder(u);
			session.setAttribute("Orderlist", orderlist);
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		// ҳ����ת
		
//		res.sendRedirect("/shopping/ordershow.jsp");
		req.getRequestDispatcher("/ordershow.jsp").forward(req, res);
		
		
	}

}
