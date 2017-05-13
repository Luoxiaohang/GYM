package com.gym.dao;

import java.util.List;

import com.gym.model.EquipmentModel;

public interface EquipmentDao {

	/**
	 * 添加器材
	 * 
	 * @param equipmentModel
	 * @return
	 */
	public int addEquipment(EquipmentModel equipmentModel);

	/**
	 * 删除器材
	 * 
	 * @param eId
	 * @return
	 */
	public int delEquipment(String eId);

	/**
	 * 修改器材
	 * 
	 * @param equipmentModel
	 * @return
	 */
	public int alterEquipment(EquipmentModel equipmentModel);

	/**
	 * 器材租借次数自增
	 * 
	 * @param equipmentModel
	 * @return
	 */
	public int addBorrowCount(EquipmentModel equipmentModel);

	/**
	 * 查询所有器材
	 * 
	 * @return
	 */
	public List queryEquipment();

	/**
	 * 根据id查询器材
	 * 
	 * @return
	 */
	public EquipmentModel queryById(String eId);

	/**
	 * 根据name查询所有器材
	 * 
	 * @return
	 */
	public EquipmentModel queryByName(String eName);

	/**
	 * 查询所有器材种类
	 * 
	 * @return
	 */
	public List queryAllType();

}
