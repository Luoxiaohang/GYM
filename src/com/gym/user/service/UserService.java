package com.gym.user.service;

import java.util.List;

import com.gym.model.UserModel;

public interface UserService {
	/**
	 * 根据用户id查询用户信息
	 * 
	 * @return
	 */
	public UserModel queryUserInfoById(String uId);

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @return
	 */
	public UserModel queryUserInfoByName(String uName);

	/**
	 * 修改用户信息
	 * 
	 * @param userModel
	 * @return
	 */
	public int alterUserInfo(UserModel userModel);

	/**
	 * 修改用户密码
	 * 
	 * @param userModel
	 * @return
	 */
	public int alterUserPwd(UserModel userModel, String oldPwd, String newPwd1,
			String newPwd2);

	/**
	 * 查询我的预约
	 * 
	 * @return
	 */
	public List queryMyBook(UserModel userModel);

	/**
	 * 查询我的器材租借
	 * 
	 * @param userModel
	 * @return
	 */
	public List queryMyRent(UserModel userModel);

}
