package com.gym.user.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.UserModel;
import com.gym.user.service.impl.RegistServiceImpl;
import com.gym.utils.Constant;

public class RegistAction extends HttpServlet {

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

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("regist.jsp");

		dispatcher.forward(request, response);

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
		UserModel userModel = new UserModel();

		userModel.setStatus("1");
		userModel.setuEmail(request.getParameter("email"));
		userModel.setuId(request.getParameter("uid"));
		userModel.setuIdCard(request.getParameter("idcard"));
		userModel.setuName(request.getParameter("name"));
		userModel.setuPassword(request.getParameter("password"));
		userModel.setuPhone(request.getParameter("phone"));
		userModel.setDate(DateFormat.getDateTimeInstance().format(new Date()));

		// 验证必填参数是否为空
		if (userModel.getuEmail().equals("") || userModel.getuId().equals("")
				|| userModel.getuIdCard().equals("")
				|| userModel.getuName().equals("")
				|| request.getParameter("password").equals("")
				|| request.getParameter("password2").equals("")) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("errorCode", "所有必填项不可为空");
			dispatcher.forward(request, response);
			return;
		}

		// 验证两次密码是否一致
		if (!request.getParameter("password").equals(
				request.getParameter("password2"))) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("errorCode", "两次密码不一致");
			dispatcher.forward(request, response);

			return;
		}

		RegistServiceImpl registServiceImpl = new RegistServiceImpl();
		RequestDispatcher dispatcher;
		switch (registServiceImpl.regist(userModel)) {
		case Constant.SUCCESS:
			response.sendRedirect("success.jsp");
			break;

		case Constant.ERROR:
			response.sendRedirect("error.jsp?errorCode=" + Constant.ERROR);
			break;

		case Constant.USEREXIST:
			response.sendRedirect("error.jsp?errorCode=" + Constant.USEREXIST);
			break;

		default:
			break;
		}

	}
}
