package com.gym.user.service.impl;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.model.UserModel;
import com.gym.user.service.LoginService;
import com.gym.utils.Constant;

public class LoginServiceImpl implements LoginService {

	public int login(UserModel userModel) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		System.out.println("用户登陆  " + userModel.getuId() + " "
				+ userModel.getuPassword());
		// 查询是否已存在此用户id
		if (!userDaoImpl.isExist(userModel.getuId())) {
			return Constant.USERNOTEXIST;
		}

		userModel = userDaoImpl.checkUser(userModel);
		if (null != userModel) {
			return Constant.SUCCESS;
		} else {
			return Constant.USERPWDERROR;

		}

	}

}
