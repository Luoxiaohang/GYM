package com.gym.admin.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class PersonnelAction extends HttpServlet {

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
		AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}

		// 验证超级管理员权限
		AdminModel checkSuperAdminModel = adminServiceImpl.queryById(request
				.getSession().getAttribute("aId").toString());
		if (!checkSuperAdminModel.getPower().equals("2")) { // 权限不足
			response.sendRedirect("../error.jsp?errorCode="
					+ Constant.PERMISSIONDENIED);
			return;
		}

		if (action == null) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/personnel/index.jsp");
			dispatcher.forward(request, response);

		} else if (action.equals("addadmin")) {
			System.out.println("addadmin");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/personnel/addadmin.jsp");
			dispatcher.forward(request, response);
		} else if (action.equals("admin")) {
			List adminList = adminServiceImpl.queryAllAdmin();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/personnel/admin.jsp");
			request.setAttribute("adminList", adminList);
			dispatcher.forward(request, response);

		} else if (action.equals("user")) {

			List userList = new ArrayList();

			userList = adminServiceImpl.queryAllUser();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/personnel/user.jsp");
			request.setAttribute("userList", userList);
			dispatcher.forward(request, response);

		} else if (action.equals("deluser")) {// 转发
			doPost(request, response);
		} else if (action.equals("deladmin")) {// 转发
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

		AdminServiceImpl adminServiceImpl = new AdminServiceImpl();

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}

		// 验证超级管理员权限
		AdminModel checkSuperAdminModel = adminServiceImpl.queryById(request
				.getSession().getAttribute("aId").toString());
		if (!checkSuperAdminModel.getPower().equals("2")) { // 权限不足
			response.sendRedirect("../error.jsp?errorCode="
					+ Constant.PERMISSIONDENIED);
			return;
		}

		if (action == null) {

		} else if (action.equals("add")) { // 执行添加管理员操作（需要超级管理员权限）

			AdminModel adminModel = new AdminModel();

			adminModel.setaEntry(DateFormat.getDateTimeInstance().format(
					new Date()));
			adminModel.setaName(request.getParameter("name"));
			adminModel.setaPassword(request.getParameter("password"));
			adminModel.setBirthdate(request.getParameter("birthdate"));
			adminModel.setEmail(request.getParameter("email"));
			adminModel.setIdCardNo(request.getParameter("idcard"));
			adminModel.setPhone(request.getParameter("phone"));
			adminModel.setPower("1"); // 1-普通管理员 2-超级管理员
			adminModel.setStatus("1");

			switch (adminServiceImpl.addAdmin(adminModel)) {
			case Constant.SUCCESS:
				System.out.println("管理员添加成功");
				request.getRequestDispatcher("../success.jsp").forward(request,
						response);
				break;
			case Constant.ERROR:
				request.getRequestDispatcher(
						"../error.jsp?errorCode=" + Constant.ERROR).forward(
						request, response);
				break;
			case Constant.PARAMEMPTY:
				request.getRequestDispatcher(
						"../error.jsp?errorCode=" + Constant.PARAMEMPTY)
						.forward(request, response);
				break;

			default:
				break;
			}

		} else if (action.equals("deluser")) {
			switch (adminServiceImpl.delUser(request.getParameter("uid"))) {
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

		} else if (action.equals("deladmin")) {
			switch (adminServiceImpl.delAdmin(request.getParameter("aId"))) {
			case Constant.SUCCESS:
				System.out.println("禁用成功");
				request.getRequestDispatcher("../success.jsp").forward(request,
						response);
				break;

			case Constant.ERROR:
				System.out.println("禁用失败");
				request.getRequestDispatcher(
						"../error.jsp?errorCode=" + Constant.ERROR).forward(
						request, response);
				break;
			default:
				break;
			}

		}

	}
}
