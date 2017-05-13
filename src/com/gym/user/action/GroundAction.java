package com.gym.user.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.GroundBookModel;
import com.gym.model.GroundModel;
import com.gym.user.service.impl.GroundServiceImpl;
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

		String action = request.getParameter("action");
		GroundServiceImpl groundServiceImpl = new GroundServiceImpl();

		if (action == null) { // 显示所有场地

			List groundList = groundServiceImpl.queryGroundBook();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/ground/index.jsp");
			request.setAttribute("groundList", groundList);
			dispatcher.forward(request, response);

		} else if (action.equals("book")) { // 显示预约场地页面

			String gId = request.getParameter("gid");

			// 检查参数
			if (gId == null) {
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);
				return;
			}

			GroundModel groundInfo = groundServiceImpl.queryGroundById(gId);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/ground/book.jsp");
			request.setAttribute("groundId", groundInfo.getgId());
			request.setAttribute("groundTypeName", groundInfo.gettName());
			request.setAttribute("groundFee", groundInfo.getgFee());
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

		GroundServiceImpl groundServiceImpl = new GroundServiceImpl();

		if (action == null) {

		} else if (action.equals("book")) { // 执行预订场地动作

			request.setCharacterEncoding("utf-8");

			// 检查用户是否在线
			if (!CheckOnline.isUserOnline(request)) {
				response.sendRedirect("../login.html");
				return;
			}

			GroundBookModel groundBookModel = new GroundBookModel();

			groundBookModel.setgId(request.getParameter("gid"));
			groundBookModel.setbDate(DateFormat.getDateTimeInstance().format(
					new Date()));
			groundBookModel.setbStartTime(request.getParameter("begin"));
			groundBookModel.setbEndTime(request.getParameter("end"));
			groundBookModel.setuId((String) request.getSession().getAttribute(
					"uId"));
			groundBookModel.setbStatus("1");

			// 根据id查询场地信息
			GroundModel groundModel = new GroundModel();
			groundModel = groundServiceImpl.queryGroundById(groundBookModel
					.getgId());

			// 验证必填参数是否为空
			if (groundBookModel.getgId().equals("")
					|| groundBookModel.getbStartTime().equals("")
					|| groundBookModel.getbEndTime().equals("")
					|| groundBookModel.getuId().equals("")) {

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);

				return;
			}

			switch (groundServiceImpl.bookGround(groundBookModel, groundModel)) {
			case Constant.SUCCESS:
				response.sendRedirect("../success.jsp");

				break;

			case Constant.ERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.ERROR);

				break;

			case Constant.TIMEERROR:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.TIMEERROR);

				break;

			case Constant.TIMECLASH:
				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.TIMECLASH);

				break;

			default:
				break;
			}

		}

	}

}
