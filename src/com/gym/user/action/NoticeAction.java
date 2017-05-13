package com.gym.user.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gym.model.NoticeModel;
import com.gym.user.service.impl.NoticeServiceImpl;

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

		String nId = request.getParameter("nid");

		if (nId == null) {
			NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

			List noticeList = noticeServiceImpl.queryNotice();

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/notice/index.jsp");
			request.setAttribute("noticeList", noticeList);
			dispatcher.forward(request, response);
		} else {

			NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();

			NoticeModel noticeModel = noticeServiceImpl.queryById(nId);

			List list = new ArrayList();
			list.add(noticeModel);// 封装成list便于<c:forEach> 遍历

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/notice/detail.jsp");
			request.setAttribute("noticeList", list);
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

	}

}
