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
	
		
		
//		res.setContentType("text/html");
//		String address=req.getParameter("uaddress");
//		String uphone=req.getParameter("uphone");
//		String uemail=req.getParameter("umail");
////		String uphone=req.getParameter("uphone");
//		
		HttpSession session=req.getSession(true);
		
		Cart c=(Cart)session.getAttribute("cart");
		User u=(User)session.getAttribute("user");
		Collection<OrderItem> items=c.getMap().values();
		OrderService oservice=new OrderServiceImpl();
		Order o;
		
		
		try {
			
			oservice.createOrder(items, u);	//�����Դ�������
//			oservice.insertOrder(items, u);
			o = oservice.getOrder(u);//��ȡ���������ж��Ƿ񹻹��������޷������򷵻�error.jsp
			if(o.getTotal_amount() < u.getBalance()){
				oservice.creatInsert(o);//���붩�������ݿ�
				req.getRequestDispatcher("/ok.jsp").forward(req,res);
			}else{
				ErrorMsg em = new ErrorMsg();
				em.setMsg("���㣬���ֵ��");
				em.setFoxurl("/servlet/balance");//��ת��ֵҳ��
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req,res);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req,res);
		}
	}

}
