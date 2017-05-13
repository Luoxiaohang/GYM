package com.gym.user.service.impl;

import java.util.List;

import com.gym.dao.impl.UserDaoImpl;
import com.gym.model.UserModel;
import com.gym.user.service.UserService;
import com.gym.utils.Constant;

public class UserServiceImpl implements UserService {

	public UserModel queryUserInfoById(String uId) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		return userDaoImpl.queryUserById(uId);

	}

	public UserModel queryUserInfoByName(String uName) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		return userDaoImpl.queryUserByName(uName);

	}

	public int alterUserInfo(UserModel userModel) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		if (userDaoImpl.alterUser(userModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}
	}

	/**
	 * 修改用户密码
	 * 
	 * @param userModel
	 * @param oldPwd
	 *            旧密码
	 * @param newPwd1
	 *            新密码1
	 * @param newPwd2
	 *            新密码2
	 * @return
	 */
	public int alterUserPwd(UserModel userModel, String oldPwd, String newPwd1,
			String newPwd2) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// 验证旧密码
		if (!oldPwd.equals(userDaoImpl.queryUserById(userModel.getuId())
				.getuPassword())) {
			return Constant.USERPWDERROR;
		}

		if (!newPwd1.equals(newPwd2)) {
			return Constant.PASSWORDDIFFER;
		}

		userModel.setuPassword(newPwd1);
		if (userDaoImpl.alterUserPwd(userModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public List queryMyBook(UserModel userModel) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		return (List) userDaoImpl.queryMyBook(userModel);
	}

	public List queryMyRent(UserModel userModel) {
		// TODO Auto-generated method stub

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		return (List) userDaoImpl.queryMyRent(userModel);
	}

}
