package com.gym.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.ReportServiceImpl;
import com.gym.utils.CheckOnline;

public class ReportAction extends HttpServlet {

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
		ReportServiceImpl reportServiceImpl = new ReportServiceImpl();
		if (action == null) {

			List reportList = reportServiceImpl.queryAll();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/report/index.jsp");
			request.setAttribute("reportList", reportList);
			dispatcher.forward(request, response);
		} else if (action.equals("ground")) {

			List reportList = reportServiceImpl.queryGround();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/report/ground.jsp");
			request.setAttribute("reportList", reportList);
			dispatcher.forward(request, response);
		} else if (action.equals("equipment")) {

			List reportList = reportServiceImpl.queryEquipment();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/report/equipment.jsp");
			request.setAttribute("reportList", reportList);
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

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action"); // 获取动作

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}
	}

}
