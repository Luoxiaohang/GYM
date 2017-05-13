package com.gym.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 检查是否在线
 * 
 * @author Feng
 * 
 */
public class CheckOnline {

	public static boolean isAdminOnline(HttpServletRequest request) {

		Object aIdSession = request.getSession().getAttribute("aId");
		if (aIdSession == null) {

			return false;

		} else {

			return true;

		}

	}

	public static boolean isUserOnline(HttpServletRequest request) {

		Object uIdSession = request.getSession().getAttribute("uId");
		if (uIdSession == null) {

			return false;

		} else {

			return true;

		}

	}

}
