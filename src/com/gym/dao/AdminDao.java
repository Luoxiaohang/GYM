package com.gym.dao;

import java.util.List;

import com.gym.model.AdminModel;

public interface AdminDao {

	/**
	 * 添加管理员
	 * 
	 * @return
	 */
	public int addAdmin(AdminModel adminModel);

	/**
	 * 删除管理员
	 * 
	 * @return
	 */
	public int delAdmin(String aId);

	/**
	 * 修改管理员信息
	 * 
	 * @return
	 */
	public int alterAdmin(AdminModel adminModel);

	/**
	 * 查询所有管理员
	 * 
	 * @return
	 */
	public List queryAdmin();

	/**
	 * 根据管理员名字查询管理员
	 * 
	 * @return
	 */
	public AdminModel queryAdminByName(String aName);

	/**
	 * 根据管理员id查询管理员
	 * 
	 * @return
	 */
	public AdminModel queryAdminById(String aId);

	/**
	 * 启用管理员
	 * 
	 * @return
	 */
	public boolean onAdmin(String aId);

	/**
	 * 禁用管理员
	 * 
	 * @return
	 */
	public boolean offAdmin(String aId);

	/**
	 * 查询管理员是否存在
	 * 
	 * @param aId
	 * @return
	 */
	public boolean isExist(String aId);

	/**
	 * 验证管理员名字和密码
	 * 
	 * @param adminModel
	 * @return
	 */
	public boolean checkAdmin(AdminModel adminModel);

}
