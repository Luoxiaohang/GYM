package com.gym.user.service.impl;

import java.util.List;

import com.gym.dao.impl.EquipmentDaoImpl;
import com.gym.dao.impl.EquipmentRentDaoImpl;
import com.gym.model.EquipmentModel;
import com.gym.model.EquipmentRentModel;
import com.gym.model.UserModel;
import com.gym.user.service.EquipmentService;
import com.gym.utils.CalculationUitl;
import com.gym.utils.CompareUtil;
import com.gym.utils.Constant;

public class EquipmentServiceImpl implements EquipmentService {

	public List queryEquipment() {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		return equipmentDaoImpl.queryEquipment();

	}

	public EquipmentModel queryById(String eId) {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		return equipmentDaoImpl.queryById(eId);

	}

	public EquipmentModel queryByName(String eName) {
		// TODO Auto-generated method stub
		return null;
	}

	public int rentEquipment(EquipmentRentModel equipmentRentModel,
			EquipmentModel equipmentModel, UserModel userModel) {
		// TODO Auto-generated method stub

		EquipmentServiceImpl equipmentServiceImpl = new EquipmentServiceImpl();
		equipmentModel = equipmentServiceImpl.queryById(equipmentRentModel
				.geteId()); // 根据场地id查询

		if (equipmentModel == null) { // 找不到此器材
			return Constant.EQUIPMENTINVALID;
		}

		// 重新设置相关参数，防止某些参数被用户在前台篡改
		equipmentRentModel.setBorrowFee(equipmentModel.geteFee());
		equipmentRentModel.setStatus(equipmentModel.getStatus());
		equipmentRentModel.setuId(userModel.getuId());

		CompareUtil compareUtil = new CompareUtil();
		// 验证起始时间是否大于结束时间
		if (compareUtil.compareDateTime(equipmentRentModel.getBorrowBegin(),
				equipmentRentModel.getBorrowEnd(), "yyyy-MM-dd HH:mm") >= 0) {

			return Constant.TIMEERROR;

		}

		// ------------------待开发（惩罚规则）--------------------

		// 判断用户是否被冻结

		// ------------------待开发（惩罚规则）--------------------

		// 检测器材此时间段是否空闲
		EquipmentRentDaoImpl equipmentRentDaoImpl = new EquipmentRentDaoImpl();

		List groundBookList = equipmentRentDaoImpl.queryByTime(
				equipmentRentModel.getBorrowBegin(),
				equipmentRentModel.getBorrowEnd());
		if (groundBookList.size() != 0) {
			return Constant.TIMECLASH;
		}

		// 查询该用户此时间段内是否有其他预定

		// 计算费用
		equipmentRentModel.setBorrowFee(new CalculationUitl().calculaRentMoney(
				equipmentRentModel, equipmentModel) + "");

		if (equipmentRentDaoImpl.addEquipmentRent(equipmentRentModel) == 1) {

			return Constant.SUCCESS;

		} else {

			return Constant.ERROR;

		}

	}

}
