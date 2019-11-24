package com.scmpi.book.action;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Cart;

/**
 * Servlet implementation class BackIndexServlet
 * @author lixuehui  主要为了刷新主页下单后商品数量
 */

@WebServlet("/BackIndexServlet")
public class BackIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try{
			HttpSession session=req.getSession(true);
        	//查询得到所有图书信息
        	Cart c=new Cart();//购物车
        	session.setAttribute("cart", c);
        	req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
        }catch(Exception e){
        	 //e.printStackTrace();
        
           req.getRequestDispatcher("/login.jsp").forward(req, res);	
        }
	}

}
