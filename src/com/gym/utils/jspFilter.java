package com.gym.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * jsp过滤器
 * 
 * @author Feng
 * 
 */
public class jspFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * 除了css js jpg png gif 其他全部过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object o = session.getAttribute("username");

		String url = req.getRequestURI();
		// 判断Session中的对象是否为空；判断请求的URI是否为不允许过滤的URI
		if (o == null
				&& !url.endsWith(".css") // 对URL地址为此结尾的文件不过滤
				&& !url.endsWith(".js") && !url.endsWith(".jpg")
				&& !url.endsWith(".png") && !url.endsWith(".gif")
				&& !url.endsWith(".html")) {
			req.getRequestDispatcher(url.substring(4, url.length())).forward(
					req, res);
		} else {
			chain.doFilter(request, response);
			res.setHeader("Cache-Control", "no-store");
			res.setDateHeader("Expires", 0);
			res.setHeader("Pragma", "no-cache");
			res.flushBuffer();
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}