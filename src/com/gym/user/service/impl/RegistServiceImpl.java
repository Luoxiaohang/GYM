package com.gym.user.service.impl;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.model.UserModel;
import com.gym.user.service.RegistService;
import com.gym.utils.Constant;

public class RegistServiceImpl implements RegistService {

	public int regist(UserModel userModel) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// 查询是否已存在此用户id
		if (userDaoImpl.isExist(userModel.getuId())) {
			return Constant.USEREXIST;
		}

		if (userDaoImpl.addUser(userModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;

		}

	}

}
