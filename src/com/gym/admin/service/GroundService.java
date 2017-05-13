package com.gym.admin.service;

import java.util.List;

import com.gym.model.GroundModel;

public interface GroundService {

	/**
	 * 添加场地
	 * 
	 * @param groundModel
	 * @return
	 */
	public int addGround(GroundModel groundModel);

	/**
	 * 删除场地
	 * 
	 * @param gId
	 * @return
	 */
	public int delGround(String gId);

	/**
	 * 修改场地
	 * 
	 * @param groundModel
	 * @return
	 */
	public int alterGround(GroundModel groundModel);

	/**
	 * 查询所有场地
	 * 
	 * @return
	 */
	public List queryGround();

	/**
	 * 根据id查询场地
	 * 
	 * @return
	 */
	public GroundModel queryById(String gId);

	/**
	 * 根据名称查询场地
	 * 
	 * @return
	 */
	public GroundModel queryByName();

	/**
	 * 查询所有场地类型
	 * 
	 * @return
	 */
	public List queryAllType();

	/**
	 * 查询用户场地预定
	 * 
	 * @param uId
	 * @return
	 */
	public List queryBookByUserId(String uId);

	/**
	 * 使用场地
	 * 
	 * @return
	 */
	public int groundUse(String uId, String gId, String bId);
}
