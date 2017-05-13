package com.gym.dao;

import java.util.List;

import com.gym.model.EquipmentRentModel;

public interface EquipmentRentDao {

	/**
	 * 租借器材
	 * 
	 * @return
	 */
	public int addEquipmentRent(EquipmentRentModel equipmentRentModel);

	/**
	 * 根据时间间隔查询场地预定
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List queryByTime(String begin, String end);

	/**
	 * 查询用户器材租借
	 * 
	 * @param uId
	 * @return
	 */
	public List queryRentByUserId(String uId);

	/**
	 * 根据租借id查询租借器材预约
	 * 
	 * @param eRentId
	 * @return
	 */
	public EquipmentRentModel queryRentByRentId(String eRentId);

	/**
	 * 租借器材
	 * 
	 * @param equipmentRentModel
	 * @return
	 */
	public int rentGet(EquipmentRentModel equipmentRentModel);

	/**
	 * 器材归还
	 * 
	 * @param equipmentRentModel
	 * @return
	 */
	public int rentReturn(EquipmentRentModel equipmentRentModel);

}
