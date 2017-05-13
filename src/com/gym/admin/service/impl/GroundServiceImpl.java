package com.gym.admin.service.impl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.gym.admin.service.GroundService;
import com.gym.dao.impl.FinancialDaoImpl;
import com.gym.dao.impl.GroundDaoImpl;
import com.gym.dao.impl.GroundbookDaoImpl;
import com.gym.model.FinancialModel;
import com.gym.model.GroundBookModel;
import com.gym.model.GroundModel;
import com.gym.utils.Constant;
import com.gym.utils.DeductMoney;

public class GroundServiceImpl implements GroundService {

	public int addGround(GroundModel groundModel) {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		if (groundDaoImpl.addGround(groundModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int delGround(String gId) {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		if (groundDaoImpl.delGround(gId) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int alterGround(GroundModel groundModel) {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		if (groundDaoImpl.alterGround(groundModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public List queryGround() {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryGround();
	}

	public GroundModel queryById(String gId) {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryById(gId);

	}

	public GroundModel queryByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryAllType() {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryAllType();

	}

	public List queryBookByUserId(String uId) {
		// TODO Auto-generated method stub

		GroundbookDaoImpl groundbookDaoImpl = new GroundbookDaoImpl();

		return groundbookDaoImpl.queryBookByUserId(uId);

	}

	public int groundUse(String uId, String gId, String bId) {
		// TODO Auto-generated method stub

		if (uId.equals("") || gId.equals("") || bId.equals("")) {
			return Constant.PARAMEMPTY;
		}

		GroundbookDaoImpl groundbookDaoImpl = new GroundbookDaoImpl();
		GroundBookModel groundBookModel = groundbookDaoImpl
				.queryBookByBookId(bId);

		if (null == groundBookModel || !groundBookModel.getgId().equals(gId)
				|| !groundBookModel.getuId().equals(uId)) { // 该用户没有预定该场地
			return Constant.HASNOTBOOK;
		}

		DeductMoney.gdouMetroCard(uId, groundBookModel.getbFee()); // 扣钱

		if (groundbookDaoImpl.groundUse(groundBookModel) == 1) {

			// 财政报表记录
			FinancialDaoImpl financialDaoImpl = new FinancialDaoImpl();
			FinancialModel financialModel = new FinancialModel();
			financialModel.setDate(DateFormat.getDateTimeInstance().format(
					new Date()));
			financialModel.setfIn(groundBookModel.getbFee());
			financialModel.setfInType("0"); // 0-场地 1-器材
			financialModel.setfOut("0");
			financialModel.setNotes(groundBookModel.getuId() + ",场地"
					+ groundBookModel.getgId());
			financialDaoImpl.addRecord(financialModel);

			return Constant.SUCCESS;

		} else {

			DeductMoney.gdouMetroCardRollback(uId, groundBookModel.getbFee()); // 回滚

			return Constant.ERROR;
		}

	}

}
