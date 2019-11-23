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
 * @author lixuehui  ��ҪΪ��ˢ����ҳ�µ�����Ʒ����
 */

@WebServlet("/BackIndexServlet")
public class BackIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try{
			HttpSession session=req.getSession(true);
        	//��ѯ�õ�����ͼ����Ϣ
        	Cart c=new Cart();//���ﳵ
        	session.setAttribute("cart", c);
        	req.getRequestDispatcher("/servlet/PageServlet").forward(req,res);
        }catch(Exception e){
        	 //e.printStackTrace();
        
           req.getRequestDispatcher("/login.jsp").forward(req, res);	
        }
	}

}
