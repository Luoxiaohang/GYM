package com.gym.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.UserModel;
import com.gym.user.service.impl.LoginServiceImpl;
import com.gym.utils.Constant;

public class LoginAction extends HttpServlet {

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

		if (null == action) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");

			dispatcher.forward(request, response);
		} else if (action.equals("logout")) {

			request.getSession().removeAttribute("uName");// 清除session
			request.getSession().removeAttribute("uId");// 清除session

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");

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

		UserModel userModel = new UserModel();

		userModel.setuId(request.getParameter("uid"));
		userModel.setuPassword(request.getParameter("password"));

		// 验证必填参数是否为空
		if (userModel.getuId().equals("")
				|| userModel.getuPassword().equals("")) {
			response.sendRedirect("error.jsp?errorCode=" + Constant.PARAMEMPTY);
			return;
		}

		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		switch (loginServiceImpl.login(userModel)) {
		case Constant.SUCCESS:
			System.out.println("用户登陆成功");
			request.getSession().setAttribute("uName", userModel.getuName()); // 设置session
			request.getSession().setAttribute("uId", userModel.getuId()); // 设置session

			response.sendRedirect("index.html");

			break;

		case Constant.USERNOTEXIST:
			response.sendRedirect("error.jsp?errorCode="
					+ Constant.USERNOTEXIST);
			break;

		case Constant.USERPWDERROR:
			response.sendRedirect("error.jsp?errorCode="
					+ Constant.USERPWDERROR);
			break;

		}

	}
}
