package com.scmpi.book.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scmpi.book.entity.Product;
import com.scmpi.book.entity.ProductType;
import com.scmpi.book.service.ProductService;
import com.scmpi.book.service.impl.ProductServiceImpl;

/**
 * 
 * @description 用于分页
 * @version 1.0
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 8296448683554579466L;
	public static final int PAGER_PAGESIZE = 2;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductService pservice = new ProductServiceImpl();
		HttpSession session = request.getSession(true);
		List<ProductType> ptList = new ArrayList<ProductType>();
		List<Product> proList = new ArrayList<Product>();
		String conditions = (String) session.getAttribute("condtion");
		if (null == conditions || "".equals(conditions))// 分页显示所有图书信息
		{
			try {
				ptList = pservice.getProductTypes();
				List<Product> ListCache;
				ListCache = pservice.queryAll();
				
				//删除查询结果中is_delete属性为1的商品
				for(Product p:ListCache){
					if(p.getIs_delete() == 1 || p.getPnumber() <= 0){
						continue;
					}
					proList.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else// 按图书类型进行分页查询
		{
			try {
				ptList = pservice.getProductTypes();
				proList = (List<Product>)session.getAttribute("products");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("ptlist", ptList);
		session.setAttribute("list", proList);
		int pageNo = 1;
		String pageNoStr = request.getParameter("pageNo");
		if (pageNoStr != null && !pageNoStr.equals("")) {
			pageNo = Integer.parseInt(pageNoStr);
			System.out.println("pageNo:" + pageNo);
		}
		int start = (pageNo - 1) * PAGER_PAGESIZE;
		int end = start + PAGER_PAGESIZE;
		if (end > proList.size()) {
			end = proList.size();
		}
		List<Product> subList = proList.subList(start, end);
		// request.setAttribute("datas", subList);
		// request.setAttribute("pageNo", pageNo);
		// request.setAttribute("pageSize", PAGER_PAGESIZE);
		// request.setAttribute("recordCount", proList.size());
		session.setAttribute("datas", subList);
		session.setAttribute("pageNo", pageNo);
		session.setAttribute("pageSize", PAGER_PAGESIZE);
		session.setAttribute("recordCount", proList.size());
		// 页面跳转
		response.sendRedirect("/shopping/queryProduct.jsp");
		// request.getRequestDispatcher("/queryProduct.jsp").forward(request,
		// response);
	}
}
