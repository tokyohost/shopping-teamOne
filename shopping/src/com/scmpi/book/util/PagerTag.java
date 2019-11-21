package com.scmpi.book.util;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class PagerTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String url;
	private int pageSize = 10;
	private int pageNo = 1;
	private int recordCount;

	public int doStartTag() throws JspException {

		int pageCount = (recordCount + pageSize - 1) / pageSize;
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n<div class='pagination'>\r\n");
		if (recordCount == 0) {
			sb.append(" 没有可以显示的项目");
		} else {
			if (pageNo > pageCount) {
				pageNo = pageCount;
			}
			if (pageNo < 1) {
				pageNo = 1;
			}
			sb.append("<form method='post' action='' name='qPagerForm'>\r\n");

			HttpServletRequest request = (HttpServletRequest) pageContext
					.getRequest();
			Enumeration<String> enumeration = request.getParameterNames();
			String name = null;
			String value = null;
			while (enumeration.hasMoreElements()) {
				name = enumeration.nextElement();
				value = request.getParameter(name);

				if (name.equals("pageNo")) {
					if (value != null && !value.equals("")) {
						pageNo = Integer.parseInt(value);
					}
					continue;
				}
				sb.append("<input type='hidden' name='" + name + "' value='"
						+ value + "'/>\r\n");
			}

			sb.append("<input type='hidden' name='" + "pageNo" + "' value='"
					+ pageNo + "'/>\r\n");
			sb.append("&nbsp;共<strong>" + recordCount + "</strong>项，<strong>"
					+ pageCount + "</strong>页:&nbsp;\r\n");

			if (pageNo == 1) {
				sb.append("<span class='disabled'>&laquo;&nbsp;上一页</span>\r\n");
			} else {
				sb.append("<a href='javascript:turnOverPage(" + (pageNo - 1)
						+ ")'>&laquo;&nbsp上一页</a>\r\n");
			}

			int start = 1;
			if (this.pageNo > 4) {
				start = this.pageNo - 1;
				sb.append("<a href='javascript:turnOverPage(1)'>1</a>\r\n");
				sb.append("<a href='javascript:turnOverPage(2)'>2</a>\r\n");
				sb.append("&hellip;\r\n");
			}

			int end = this.pageNo + 1;
			if (end > pageCount) {
				end = pageCount;
			}
			for (int i = start; i <= end; i++) {
				if (pageNo == i) {
					sb.append("<span class='current'>" + i + "</span>\r\n");
				} else {
					sb.append("<a href='javascript:turnOverPage(" + i + ")'>"
							+ i + "</a>\r\n");
				}
			}

			if (end < pageCount - 2) {
				sb.append("&hellip;\r\n");
			}
			if (end < pageCount - 1) {
				sb.append("<a href='javascript:turnOverPage(" + (pageCount - 1)
						+ ")'>" + (pageCount - 1) + "</a>\r\n");
			}
			if (end < pageCount) {
				sb.append("<a href='javascript:turnOverPage(" + pageCount
						+ ")'>" + pageCount + "</a>\r\n");
			}

			if (pageNo == pageCount) {
				sb
						.append("<span class='disabled'>下一页&nbsp;&raquo; </span>\r\n");
			} else {
				sb.append("<a href='javascript:turnOverPage(" + (pageNo + 1)
						+ ")'>&laquo;&nbsp下一页</a>\r\n");
			}
			sb.append("</form>\r\n");
			sb.append("<script language='javascript'>\r\n");
			sb.append("function turnOverPage(no){\r\n");
			sb.append("var qForm=document.qPagerForm;\r\n");
			sb.append("if(no>" + pageCount + "){no=" + pageCount + ";}");
			sb.append("if(no<1){no=1;}");
			sb.append("qForm.pageNo.value=no;\r\n");
			sb.append("qForm.action='" + url + "'\r\n");
			sb.append("qForm.submit();\r\n}</script>\r\n");
		}
		sb.append("</div>\r\n");
		try {
			pageContext.getOut().println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	public void setUrl(String url) {

		this.url = url;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public void setPageNo(int pageNo) {

		this.pageNo = pageNo;
	}

	public void setRecordCount(int recordCount) {

		this.recordCount = recordCount;
	}
}