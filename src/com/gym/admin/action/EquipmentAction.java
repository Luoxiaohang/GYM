package com.gym.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.EquipmentServiceImpl;
import com.gym.model.EquipmentModel;
import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

public class EquipmentAction extends HttpServlet {

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

		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();

		if (action == null) {
			List equipmentList = equipmentServiceImpl.queryEquipment();
			List equipmentTypeList = equipmentServiceImpl.queryAllType();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/index.jsp");
			request.setAttribute("equipmentList", equipmentList);
			request.setAttribute("equipmentTypeList", equipmentTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("add")) {
			List equipmentTypeList = equipmentServiceImpl.queryAllType();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/add.jsp");
			request.setAttribute("equipmentTypeList", equipmentTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("delete")) {
			List equipmentList = equipmentServiceImpl.queryEquipment();
			List equipmentTypeList = equipmentServiceImpl.queryAllType();
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/delete.jsp");
			request.setAttribute("equipmentList", equipmentList);
			request.setAttribute("equipmentTypeList", equipmentTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("setting")) {

			List equipmentList = equipmentServiceImpl.queryEquipment();
			List equipmentTypeList = equipmentServiceImpl.queryAllType();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/setting.jsp");
			request.setAttribute("equipmentList", equipmentList);
			request.setAttribute("equipmentTypeList", equipmentTypeList);
			dispatcher.forward(request, response);

		} else if (action.equals("delbyid")) { // 转发
			System.out.println(111);
			doPost(request, response);
		} else if (action.equals("punchcard")) { // 显示模拟打卡页面
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/punchcard.jsp");

			dispatcher.forward(request, response);
		} else if (action.equals("rent")) { // 转发
			doPost(request, response);
		} else if (action.equals("return")) { // 转发
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

		EquipmentModel equipmentModel = new EquipmentModel();
		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();

		if (action == null) {

		} else if (action.equals("add")) { // 执行添加场地动作

			equipmentModel.seteTypeId(request.getParameter("type"));
			equipmentModel.setBorrowCount("0");
			equipmentModel.setBuyCost(request.getParameter("cost"));
			equipmentModel.setBuyDate(request.getParameter("date"));
			equipmentModel.seteFee(request.getParameter("fee"));
			equipmentModel.setStatus("1");

			// 验证必填参数是否为空
			if (equipmentModel.getBuyCost().equals("")
					|| equipmentModel.getBuyDate().equals("")
					|| equipmentModel.geteFee().equals("")) {

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);

				return;
			}

			switch (equipmentServiceImpl.addEquipment(equipmentModel)) {
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

		} else if (action.equals("setting")) { // 执行修改场地动作

			equipmentModel.seteId(request.getParameter("eid"));
			equipmentModel.seteFee(request.getParameter("fee"));
			equipmentModel.seteTypeId(request.getParameter("type"));

			switch (equipmentServiceImpl.alterEquipment(equipmentModel)) {
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
			switch (equipmentServiceImpl.delEquipment(request
					.getParameter("eid"))) {
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

			List rentList = equipmentServiceImpl.queryRentByUserId(request
					.getParameter("uid"));// 读卡器传来的参数
			// uid-一卡通卡号

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin/equipment/punchcard.jsp");

			request.setAttribute("rentList", rentList);
			dispatcher.forward(request, response);

		} else if (action.equals("rent")) {

			switch (equipmentServiceImpl.rentGet(request.getParameter("uid"),
					request.getParameter("eid"),
					request.getParameter("erentid"))) {

			case Constant.SUCCESS:
				response.sendRedirect("../success.jsp?");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);
				break;

			case Constant.PARAMEMPTY:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);
				break;

			case Constant.HASNOTBOOK:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.HASNOTBOOK);
				break;

			case Constant.NOTBOOKSTATUS:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.NOTBOOKSTATUS);
				break;

			default:
				break;
			}

		} else if (action.equals("return")) { // 执行器材归还动作

			switch (equipmentServiceImpl.rentRentrn(
					request.getParameter("uid"), request.getParameter("eid"),
					request.getParameter("erentid"))) {
			case Constant.PARAMEMPTY:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);
				break;

			case Constant.SUCCESS:
				response.sendRedirect("../success.jsp?");
				break;

			case Constant.NOTUSESTATUS:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.NOTUSESTATUS);
				break;

			case Constant.HASNOTRENT:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.HASNOTRENT);
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
