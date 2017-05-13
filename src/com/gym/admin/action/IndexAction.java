package com.gym.admin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.AdminServiceImpl;
import com.gym.model.AdminModel;
import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

public class IndexAction extends HttpServlet {

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
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/index.jsp");
			dispatcher.forward(request, response);
			return;
		}

		if (action == null) {
			AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

			AdminModel adminModel = adminServiceImpl.queryById((String) request
					.getSession().getAttribute("aId"));

			List adminList = new ArrayList();
			adminList.add(adminModel);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/index.jsp");
			request.setAttribute("adminList", adminList);
			dispatcher.forward(request, response);

		} else if (action.equals("logout")) {

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

		if (action == null) {

		} else if (action.equals("admin_login")) { // 执行管理员登录动作

			AdminModel adminModel = new AdminModel();

			adminModel.setaId(request.getParameter("aid"));

			adminModel.setaPassword(request.getParameter("password"));
			System.out.println("管理员登录：  账号：" + request.getParameter("aid")
					+ "  密码：" + request.getParameter("password"));
			// 验证必填参数是否为空
			if (adminModel.getaId().equals("")
					|| adminModel.getaPassword().equals("")) {

				response.sendRedirect("error.jsp?errorCode="
						+ Constant.PARAMEMPTY);

				return;
			}

			AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

			RequestDispatcher dispatcher;
			switch (adminServiceImpl.login(adminModel)) {
			case Constant.SUCCESS:
				System.out.println("管理员登陆成功");
				request.getSession().setAttribute("aId", adminModel.getaId()); // 设置session
				response.sendRedirect("index.html");
				break;
			case Constant.ADMINPWDERROR:
				System.out.println("管理员登陆失败");
				response.sendRedirect("error.jsp?errorCode="
						+ Constant.ADMINPWDERROR);
				break;
			}
		} else if (action.equals("logout")) { // 执行管理员注销动作
			request.getSession().removeAttribute("aName");// 清除session
			request.getSession().removeAttribute("aId");// 清除session
			response.sendRedirect("index.html");
		}

	}
}
