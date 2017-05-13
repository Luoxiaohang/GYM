package com.gym.admin.action;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.admin.service.impl.NoticeServiceImpl;
import com.gym.model.NoticeModel;
import com.gym.utils.CheckOnline;
import com.gym.utils.Constant;

public class NoticeAction extends HttpServlet {

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

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/admin/notice/index.jsp");

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
		String action = request.getParameter("action"); // 获取动作

		// 检查管理员是否在线
		if (!CheckOnline.isAdminOnline(request)) {
			response.sendRedirect("../index.html");
			return;
		}

		NoticeModel noticeModel = new NoticeModel();
		NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

		if (action == null) {

		} else if (action.equals("add")) { // 执行添加公告动作
			System.out.println(11);
			noticeModel.setnDate(DateFormat.getDateTimeInstance().format(
					new Date()));
			noticeModel.setnText(request.getParameter("content"));
			noticeModel.setnTitle(request.getParameter("title"));

			// 调试
			noticeModel.setaId("1000");

			// 验证必填参数是否为空
			if (noticeModel.getnText().equals("")
					|| noticeModel.getnTitle().equals("")) {

				response.sendRedirect("../error.jsp?errorCode="
						+ Constant.PARAMEMPTY);

				return;
			}

			switch (noticeServiceImpl.addNotice(noticeModel)) {
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
		}

	}
}
