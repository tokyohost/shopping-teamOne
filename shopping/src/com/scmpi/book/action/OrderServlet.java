package com.scmpi.book.action;

import java.io.IOException;
import java.util.*;

import com.scmpi.book.entity.*;
import com.scmpi.book.service.OrderService;
import com.scmpi.book.service.UserService;
import com.scmpi.book.service.impl.OrderServiceImpl;
import com.scmpi.book.service.impl.UserServiceImpl;

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
			//�����ۿ�
			float discountAmount = o.getTotal_amount()*(Float.valueOf(u.getDiscount()) /100);
			o.setTotal_amount(discountAmount);
			o.setOrder_status("���ύ�������ۿ�Ϊ"+(u.getDiscount()) /10 +"��");
			
			//�ж��Ƿ��ύ�ն���
			if(o.getItems().isEmpty() && o.getTotal_amount() == 0.0){
				ErrorMsg em = new ErrorMsg();
				em.setMsg("���鶩���Ƿ�Ϊ�գ��������ύ�ն���~");
				em.setFoxurl("/BackIndexServlet");//��ת��ҳ
				session.setAttribute("ErrorMsg", em);
				req.getRequestDispatcher("/error.jsp").forward(req,res);
			}else if(o.getTotal_amount() < u.getBalance()){
				oservice.creatInsert(o);			//���붩�������ݿ�
				oservice.updateIntegral(o, u);		//���»���
				UserService updateUser = new UserServiceImpl();
				session.setAttribute("user",updateUser.getUser(u.getUid()));	//�����û�����
				
				
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
