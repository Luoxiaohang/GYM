package com.gym.admin.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.MatchServiceImpl;
import com.gym.model.MatchModel;
import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

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

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action"); // 获取动作

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}

		if (action == null) {

			MatchServiceImpl matchServiceImpl = new MatchServiceImpl();

			List list = (List) matchServiceImpl.queryMatch();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/match/index.jsp");
			request.setAttribute("matchList", list);
			dispatcher.forward(request, response);
		} else if (action.equals("add")) { // 显示添加赛事页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/match/add.jsp");

			dispatcher.forward(request, response);
		} else if (action.equals("delete")) {// 转发
			doPost(request, response);
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

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action"); // 获取动作

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}

		if (action == null) {

		} else if (action.equals("add")) {

			MatchModel matchModel = new MatchModel();
			matchModel.setmName(request.getParameter("title"));
			matchModel.setText(request.getParameter("content"));
			matchModel.setmDate(DateFormat.getDateTimeInstance().format(
					new Date()));

			matchModel.setaId(request.getSession().getAttribute("aId")
					.toString());

			// 验证必填参数是否为空
			if (matchModel.getmName().equals("")
					|| matchModel.getText().equals("")) {

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);
				return;
			}

			MatchServiceImpl matchServiceImpl = new MatchServiceImpl();
			RequestDispatcher dispatcher;
			switch (matchServiceImpl.addMatch(matchModel)) {
			case Constant.SUCCESS:
				response.sendRedirect("../success.jsp");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);
				break;

			default:
				break;
			}

		} else if (action.equals("delete")) {

			MatchModel matchModel = new MatchModel();

			MatchServiceImpl matchServiceImpl = new MatchServiceImpl();

			switch (matchServiceImpl.delMatch(request.getParameter("mid"))) {
			case Constant.SUCCESS:
				response.sendRedirect("index.html");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);
				break;

			default:
				break;
			}

		}

	}
}
