package com.gym.user.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.MatchModel;
import com.gym.user.service.impl.MatchServiceImpl;

public class MatchAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
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

		String matchId = request.getParameter("mid");

		if (matchId == null) {

			MatchServiceImpl matchServiceImpl = new MatchServiceImpl();

			List list = (List) matchServiceImpl.queryMatch();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/match/index.jsp");
			request.setAttribute("matchList", list);
			dispatcher.forward(request, response);

		} else {

			MatchServiceImpl matchServiceImpl = new MatchServiceImpl();

			MatchModel temp = matchServiceImpl.queryById(matchId);

			List list = new ArrayList();

			list.add(temp); // 封装成list便于前台<c:forEach>输出

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/match/detail.jsp");
			request.setAttribute("matchList", list);
			dispatcher.forward(request, response);
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
