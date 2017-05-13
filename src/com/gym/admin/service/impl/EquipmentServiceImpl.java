package com.gym.admin.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.gym.admin.service.EquipmentService;
import com.gym.dao.impl.EquipmentDaoImpl;
import com.gym.dao.impl.EquipmentRentDaoImpl;
import com.gym.dao.impl.FinancialDaoImpl;
import com.gym.model.EquipmentModel;
import com.gym.model.EquipmentRentModel;
import com.gym.model.FinancialModel;
import com.gym.utils.Constant;
import com.gym.utils.DeductMoney;

public class EquipmentServiceImpl implements EquipmentService {

	public int addEquipment(EquipmentModel equipmentModel) {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		if (equipmentDaoImpl.addEquipment(equipmentModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int delEquipment(String eId) {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		if (equipmentDaoImpl.delEquipment(eId) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int alterEquipment(EquipmentModel equipmentModel) {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		if (equipmentDaoImpl.alterEquipment(equipmentModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public List queryEquipment() {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		return equipmentDaoImpl.queryEquipment();

	}

	public EquipmentModel queryById(String eId) {
		// TODO Auto-generated method stub
		return null;
	}

	public EquipmentModel queryByName(String eName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryAllType() {
		// TODO Auto-generated method stub

		EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();

		return equipmentDaoImpl.queryAllType();

	}

	public int rentGet(String uId, String eId, String eRentId) {
		// TODO Auto-generated method stub

		if (uId.equals("") || eId.equals("") || eRentId.equals("")) {
			return Constant.PARAMEMPTY;
		}

		EquipmentRentDaoImpl equipmentRentDaoImpl = new EquipmentRentDaoImpl();

		EquipmentRentModel equipmentRentModel = equipmentRentDaoImpl
				.queryRentByRentId(eRentId);

		if (null == equipmentRentModel
				|| !equipmentRentModel.geteId().equals(eId)
				|| !equipmentRentModel.getuId().equals(uId)) { // 该用户没有租借器材
			return Constant.HASNOTBOOK;
		}

		if (!equipmentRentModel.getStatus().equals("1")) { // 非预定状态
			return Constant.NOTBOOKSTATUS;
		}

		DeductMoney.gdouMetroCard(uId, equipmentRentModel.getBorrowFee()); // 扣钱

		if (equipmentRentDaoImpl.rentGet(equipmentRentModel) == 1) {

			// 财政报表记录
			FinancialDaoImpl financialDaoImpl = new FinancialDaoImpl();
			FinancialModel financialModel = new FinancialModel();
			financialModel.setDate(DateFormat.getDateTimeInstance().format(
					new Date()));
			financialModel.setfIn(equipmentRentModel.getBorrowFee());
			financialModel.setfInType("1"); // 0-场地 1-器材
			financialModel.setfOut("0");
			financialModel.setNotes(equipmentRentModel.getuId() + ",器材"
					+ equipmentRentModel.geteId());
			financialDaoImpl.addRecord(financialModel);

			// 器材租借次数数自增
			EquipmentDaoImpl equipmentDaoImpl = new EquipmentDaoImpl();
			EquipmentModel equipmentModel = new EquipmentModel();
			equipmentModel = equipmentDaoImpl.queryById(equipmentRentModel
					.geteId());
			equipmentDaoImpl.addBorrowCount(equipmentModel);

			return Constant.SUCCESS;

		} else {

			DeductMoney.gdouMetroCardRollback(uId,
					equipmentRentModel.getBorrowFee()); // 回滚

			return Constant.ERROR;
		}

	}

	public int rentRentrn(String uId, String eId, String eRentId) {
		// TODO Auto-generated method stub

		if (uId.equals("") || eId.equals("") || eRentId.equals("")) {
			return Constant.PARAMEMPTY;
		}

		EquipmentRentDaoImpl equipmentRentDaoImpl = new EquipmentRentDaoImpl();

		EquipmentRentModel equipmentRentModel = equipmentRentDaoImpl
				.queryRentByRentId(eRentId);

		if (null == equipmentRentModel
				|| !equipmentRentModel.geteId().equals(eId)
				|| !equipmentRentModel.getuId().equals(uId)) { // 该用户没有租借器材
			return Constant.HASNOTRENT;
		}

		if (!equipmentRentModel.getStatus().equals("2")) { // 非使用状态
			return Constant.NOTUSESTATUS;
		}

		if (equipmentRentDaoImpl.rentReturn(equipmentRentModel) == 1) {

			return Constant.SUCCESS;

		} else {

			DeductMoney.gdouMetroCardRollback(uId,
					equipmentRentModel.getBorrowFee()); // 回滚

			return Constant.ERROR;
		}

	}

	public List queryRentByUserId(String uId) {
		// TODO Auto-generated method stub

		EquipmentRentDaoImpl equipmentRentDaoImpl = new EquipmentRentDaoImpl();

		return equipmentRentDaoImpl.queryRentByUserId(uId);
	}
}
