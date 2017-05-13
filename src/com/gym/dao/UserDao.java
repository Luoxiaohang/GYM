package com.gym.dao;

import java.util.List;

import com.gym.model.UserModel;

public interface UserDao {

	/**
	 * 添加用户
	 * 
	 * @param userModel
	 * @return
	 */
	public int addUser(UserModel userModel);

	/**
	 * 删除用户
	 * 
	 * @param aId
	 * @return
	 */
	public int delUser(String uId);

	/**
	 * 修改用户信息
	 * 
	 * @param userModel
	 * @return
	 */
	public int alterUser(UserModel userModel);

	/**
	 * 修改用户密码
	 * 
	 * @param userModel
	 * @return
	 */
	public int alterUserPwd(UserModel userModel);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List queryUser();

	/**
	 * 根据用户名字查询用户
	 * 
	 * @param aName
	 * @return
	 */
	public UserModel queryUserByName(String uName);

	/**
	 * 根据用户id查询用户
	 * 
	 * @param aId
	 * @return
	 */
	public UserModel queryUserById(String uId);

	/**
	 * 查询此用户id是否存在
	 * 
	 * @param aId
	 * @return
	 */
	public boolean isExist(String uId);

	/**
	 * 启用用户
	 * 
	 * @param aId
	 * @return
	 */
	public boolean onUser(String uId);

	/**
	 * 禁用用户
	 * 
	 * @param aId
	 * @return
	 */
	public boolean offUser(String uId);

	/**
	 * 验证用户名密码
	 * 
	 * @param userModel
	 * @return
	 */
	public UserModel checkUser(UserModel userModel);

	/**
	 * 查询我的预约
	 * 
	 * @param userModel
	 * @return
	 */
	public List queryMyBook(UserModel userModel);

	/**
	 * 查询我的租借
	 * 
	 * @param userModel
	 * @return
	 */
	public List queryMyRent(UserModel userModel);

}
