package com.gym.admin.service;

import java.util.List;

import com.gym.model.EquipmentModel;

public interface EquipmentService {

	public int addEquipment(EquipmentModel equipmentModel);

	public int delEquipment(String eId);

	public int alterEquipment(EquipmentModel equipmentModel);

	public List queryEquipment();

	public EquipmentModel queryById(String eId);

	public EquipmentModel queryByName(String eName);

	public List queryAllType();

	public List queryRentByUserId(String uId);

}
