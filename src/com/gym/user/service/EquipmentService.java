package com.gym.user.service;

import java.util.List;

import com.gym.model.EquipmentModel;
import com.gym.model.EquipmentRentModel;
import com.gym.model.UserModel;

public interface EquipmentService {

	/**
	 * 查询所有器材
	 * 
	 * @return
	 */
	public List queryEquipment();

	/**
	 * 根据id查询器材
	 * 
	 * @param eId
	 * @return
	 */
	public EquipmentModel queryById(String eId);

	/**
	 * 根据名称查询器材
	 * 
	 * @param eName
	 * @return
	 */
	public EquipmentModel queryByName(String eName);

	/**
	 * 器材租借
	 * 
	 * @param eId
	 * @return
	 */
	public int rentEquipment(EquipmentRentModel equipmentRentModel,
			EquipmentModel equipmentModel, UserModel userModel);

}
