package com.scmpi.book.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.ErrorMsg;
import com.scmpi.book.entity.Product;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

public class DeleteProductServlet extends HttpServlet {

	/*
	 * 后台商品信息删除
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html");
		//获取session 存储商品订单信息
		HttpSession session = req.getSession(true);
		
		ProductService ps = new ProductServiceImpl();
		
		Product p =new Product();
		p.setPid(Integer.valueOf(req.getParameter("pid")));
		p.setPname(req.getParameter("pname").toString());
		p.setPclassifyid(req.getParameter("pclassifyid"));
		p.setPdate(req.getParameter("pdate"));
		p.setSuppliers(req.getParameter("suppliers"));
		p.setPnumber(Integer.valueOf(req.getParameter("pnumber")));
		p.setPrice(Float.parseFloat(req.getParameter("price")));
		p.setDescw(req.getParameter("descw"));
		p.setImg(req.getParameter("img"));
		
		
		try {
			ps.deleteProduct(p.getPid());	//删除商品信息
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			ErrorMsg em = new ErrorMsg();
			em.setMsg("删除失败");
			em.setFoxurl("/shopping/servlet/ProductAdminServlet");
			session.setAttribute("ErrorMsg", em);
			req.getRequestDispatcher("/shopping/error.jsp").forward(req, res);
		}
		
		
		//页面跳转
		req.getRequestDispatcher("/servlet/ProductAdminServlet").forward(req, res);
		
		
		
		
	}
}
