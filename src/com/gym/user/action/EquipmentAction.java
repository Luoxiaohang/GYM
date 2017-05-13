package com.gym.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.EquipmentModel;
import com.gym.model.EquipmentRentModel;
import com.gym.model.UserModel;
import com.gym.user.service.impl.EquipmentServiceImpl;
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

		String action = request.getParameter("action");

		if (action == null) { // 显示所有器材页面

			EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
			List equipmentList = equipmentServiceImpl.queryEquipment(); // 获取所有器材列表

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/equipment/index.jsp");
			request.setAttribute("equipmentList", equipmentList);
			dispatcher.forward(request, response);

		} else if (action.equals("rent")) { // 显示租借器材页面

			EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
			EquipmentModel equipmentInfo = equipmentServiceImpl
					.queryById(request.getParameter("eid")); // 获取所有器材列表

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/equipment/rent.jsp");

			request.setAttribute("equipmentId", equipmentInfo.geteId());
			request.setAttribute("equipmentTypeName",
					equipmentInfo.geteTypeName());
			request.setAttribute("equipmentFee", equipmentInfo.geteFee());

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

		String action = request.getParameter("action");

		if (action == null) {

		} else if (action.equals("rent")) { // 执行租借器材动作

			request.setCharacterEncoding("utf-8");

			// 检查用户是否在线
			if (!CheckOnline.isUserOnline(request)) {
				response.sendRedirect("../login.html");
				return;
			}

			EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();

			EquipmentRentModel equipmentRentModel = new EquipmentRentModel();
			EquipmentModel equipmentModel = new EquipmentModel();
			UserModel userModel = new UserModel();

			equipmentRentModel.seteId(request.getParameter("eid"));
			equipmentRentModel.setBorrowBegin(request.getParameter("begin"));
			equipmentRentModel.setBorrowEnd(request.getParameter("end"));

			userModel.setuId((String) request.getSession().getAttribute("uId"));
			userModel.setuName((String) request.getSession().getAttribute(
					"uName"));

			switch (equipmentServiceImpl.rentEquipment(equipmentRentModel,
					equipmentModel, userModel)) {

			case Constant.SUCCESS:

				response.sendRedirect("../success.jsp");

				break;

			case Constant.ERROR:

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);

				break;

			case Constant.TIMECLASH:

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);

				break;

			default:
				break;
			}

		}

	}
}
