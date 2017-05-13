package com.gym.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.GroundServiceImpl;
import com.gym.model.GroundModel;

import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

public class GroundAction extends HttpServlet {

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

		GroundServiceImpl groundServiceImpl = new GroundServiceImpl();

		if (action == null) { // 显示管理场地页面

			List groundList = groundServiceImpl.queryGround();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/index.jsp");
			request.setAttribute("groundList", groundList);
			dispatcher.forward(request, response);

		} else if (action.equals("add")) { // 显示添加场地页面

			List groundTypeList = groundServiceImpl.queryAllType();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/add.jsp");
			request.setAttribute("groundTypeList", groundTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("delete")) { // 显示删除场地页面

			List groundList = groundServiceImpl.queryGround();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/delete.jsp");
			request.setAttribute("groundList", groundList);
			dispatcher.forward(request, response);

		} else if (action.equals("reserve")) { // 显示预留场地页面

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/reserve.jsp");

			dispatcher.forward(request, response);

		} else if (action.equals("setting")) { // 显示修改场地页面

			List groundList = groundServiceImpl.queryGround();
			List groundTypeList = groundServiceImpl.queryAllType();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/setting.jsp");
			request.setAttribute("groundList", groundList);
			request.setAttribute("groundTypeList", groundTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("delbyid")) { // 转发

			doPost(request, response);

		} else if (action.equals("punchcard")) { // 显示模拟打卡页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/punchcard.jsp");

			dispatcher.forward(request, response);
		} else if (action.equals("use")) { // 转发
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

		GroundServiceImpl groundServiceImpl = new GroundServiceImpl();

		if (action == null) {

		} else if (action.equals("add")) { // 执行添加场地动作

			GroundModel groundModel = new GroundModel();
			groundModel.setgFee(request.getParameter("fee"));
			groundModel.setgName(request.getParameter("name"));
			groundModel.setgRemark(request.getParameter("remark"));
			groundModel.setgStatus("1");
			groundModel.settId(request.getParameter("type"));

			// 验证必填参数是否为空
			if (groundModel.getgFee().equals("")
					|| groundModel.getgName().equals("")
					|| groundModel.gettId().equals("")) {

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);

				return;
			}

			switch (groundServiceImpl.addGround(groundModel)) {
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

		} else if (action.equals("reserve")) { // 执行保留场地动作

		} else if (action.equals("setting")) { // 执行修改场地动作

			GroundModel groundModel = new GroundModel();

			groundModel.setgName(request.getParameter("name"));
			groundModel.setgFee(request.getParameter("fee"));
			groundModel.setgId(request.getParameter("gid"));
			groundModel.settId(request.getParameter("type"));
			groundModel.setgRemark(request.getParameter("remark"));

			switch (groundServiceImpl.alterGround(groundModel)) {
			case Constant.SUCCESS:
				response.sendRedirect("index.html?action=setting");

				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);

				break;

			default:
				break;
			}

		} else if (action.equals("delbyid")) { // 执行删除场地动作

			switch (groundServiceImpl.delGround(request.getParameter("gid"))) {
			case Constant.SUCCESS:
				response.sendRedirect("index.html?action=delete");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);

				break;

			default:
				break;
			}

		} else if (action.equals("punchcard")) { // 执行打卡动作

			List bookList = groundServiceImpl.queryBookByUserId(request
					.getParameter("uid")); // 根据读取的一卡通号查询该用户预约表

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/ground/punchcard.jsp");
			request.setAttribute("bookList", bookList);
			dispatcher.forward(request, response);

		} else if (action.equals("use")) {

			switch (groundServiceImpl.groundUse(request.getParameter("uid"),
					request.getParameter("gid"), request.getParameter("bid"))) { // 场地使用
			case Constant.SUCCESS:
				response.sendRedirect("../success.jsp?");
				break;

			case Constant.PARAMEMPTY:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);
				break;

			case Constant.HASNOTBOOK:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.HASNOTBOOK);
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
