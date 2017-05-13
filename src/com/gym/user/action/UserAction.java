package com.gym.user.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.UserModel;
import com.gym.user.service.impl.UserServiceImpl;
import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

public class UserAction extends HttpServlet {

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

		String action = request.getParameter("action");

		// 检查用户是否在线
		if (!CheckOnline.isUserOnline(request)) {
			response.sendRedirect("../login.html");// 不在线，跳转到登录页面
			return;
		}

		String userId = request.getSession().getAttribute("uId").toString();

		UserServiceImpl userServiceImpl = new UserServiceImpl();

		if (action == null) { // 显示个人中心首页

			UserModel userModel = userServiceImpl.queryUserInfoById(userId);
			List userList = new ArrayList();
			userList.add(userModel);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/usercenter/index.jsp");
			request.setAttribute("userList", userList);
			dispatcher.forward(request, response);
		} else if (action.equals("alterinfo")) { // 显示修改个人信息页面

			UserModel userModel = userServiceImpl.queryUserInfoById(userId);
			List userList = new ArrayList();
			userList.add(userModel);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/usercenter/alterinfo.jsp");
			request.setAttribute("userList", userList);
			dispatcher.forward(request, response);

		} else if (action.equals("resetpwd")) { // 显示修改密码页面

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/usercenter/resetpwd.jsp");

			dispatcher.forward(request, response);

		} else if (action.equals("mybook")) {

			UserModel userModel = new UserModel();
			userModel.setuId((String) request.getSession().getAttribute("uId"));

			List myGroundBookList = userServiceImpl.queryMyBook(userModel);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/usercenter/mybook.jsp");
			request.setAttribute("myGroundBookList", myGroundBookList);
			dispatcher.forward(request, response);

		} else if (action.equals("myrent")) {

			UserModel userModel = new UserModel();
			userModel.setuId((String) request.getSession().getAttribute("uId"));

			List myEquipmentRentList = userServiceImpl.queryMyRent(userModel);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/usercenter/myrent.jsp");
			request.setAttribute("myEquipmentRentList", myEquipmentRentList);
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/error.jsp");

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

		String action = request.getParameter("action");

		// 检查用户是否在线
		if (!CheckOnline.isUserOnline(request)) {
			response.sendRedirect("../login.html");
			return;
		}

		String userId = request.getSession().getAttribute("uId").toString();

		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserModel userModel = new UserModel();

		if (action == null) {

		} else if (action.equals("alter")) { // 执行修改个人信息动作

			userModel.setuId(userId);
			userModel.setuEmail(request.getParameter("email"));
			userModel.setuIdCard(request.getParameter("idcard"));
			userModel.setuPhone(request.getParameter("phone"));
			userModel.setuName(request.getParameter("name"));

			switch (userServiceImpl.alterUserInfo(userModel)) {
			case Constant.SUCCESS:
				request.getSession()
						.setAttribute("uName", userModel.getuName()); // 更新session

				response.sendRedirect("../success.jsp");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);
				break;

			default:
				break;
			}

		} else if (action.equals("resetpwd")) { // 执行修改密码动作

			userModel.setuId(userId);
			String oldPwd = request.getParameter("oldpwd");
			String newPwd1 = request.getParameter("newpwd1");
			String newPwd2 = request.getParameter("newpwd2");

			switch (userServiceImpl.alterUserPwd(userModel, oldPwd, newPwd1,
					newPwd2)) {
			case Constant.SUCCESS:
				request.getSession()
						.setAttribute("uName", userModel.getuName()); // 更新session
				request.getSession().setAttribute("uId", userModel.getuId()); // 更新session

				response.sendRedirect("../success.jsp");
				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);
				break;

			case Constant.USERPWDERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.USERPWDERROR);
				break;

			case Constant.PASSWORDDIFFER:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PASSWORDDIFFER);
				break;

			default:
				break;
			}

		}

	}
}
