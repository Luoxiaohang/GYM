package com.gym.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.user.service.impl.MatchServiceImpl;

public class IndexAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * 访问根目录默认跳转到index.jsp
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MatchServiceImpl matchServiceImpl = new MatchServiceImpl();

		List list = (List) matchServiceImpl.queryMatch();

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("index.jsp");
		request.setAttribute("matchList", list);
		dispatcher.forward(request, response);

	}

}
