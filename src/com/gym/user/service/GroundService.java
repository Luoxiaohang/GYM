package com.gym.user.service;

import java.util.List;

import com.gym.model.GroundBookModel;
import com.gym.model.GroundModel;

public interface GroundService {

	/**
	 * 预定场地
	 * 
	 * @param groundModel
	 * @return
	 */
	public int bookGround(GroundBookModel groundBookModel,
			GroundModel groundModel);

	/**
	 * 查询所有场地预定
	 * 
	 * @return
	 */
	public List queryGroundBook();

	/**
	 * 根据id查询场地预定
	 * 
	 * @return
	 */
	public GroundBookModel queryById(String bId);

	/**
	 * 根据名称查询场地预定
	 * 
	 * @return
	 */
	public GroundBookModel queryByName();

	/**
	 * 查询所有场地类型
	 * 
	 * @return
	 */
	public List queryAllType();

	/**
	 * 查询所有场地
	 * 
	 * @return
	 */
	public List queryGround();

	/**
	 * 根据id查询场地
	 * 
	 * @param gId
	 * @return
	 */
	public GroundModel queryGroundById(String gId);

}
