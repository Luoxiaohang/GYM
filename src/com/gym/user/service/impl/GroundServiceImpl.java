package com.gym.user.service.impl;

import java.util.List;

import com.gym.dao.impl.GroundDaoImpl;
import com.gym.dao.impl.GroundbookDaoImpl;
import com.gym.model.GroundBookModel;
import com.gym.model.GroundModel;
import com.gym.user.service.GroundService;
import com.gym.utils.CalculationUitl;
import com.gym.utils.CompareUtil;
import com.gym.utils.Constant;

public class GroundServiceImpl implements GroundService {

	public int bookGround(GroundBookModel groundBookModel,
			GroundModel groundModel) {
		// TODO Auto-generated method stub

		CompareUtil compareUtil = new CompareUtil();
		// 验证起始时间是否大于结束时间
		if (compareUtil.compareDateTime(groundBookModel.getbStartTime(),
				groundBookModel.getbEndTime(), "yyyy-MM-dd HH:mm") >= 0) {

			return Constant.TIMEERROR;

		}

		// ------------------待开发（惩罚规则）--------------------

		// 判断用户是否被冻结

		// ------------------待开发（惩罚规则）--------------------

		// 检测场地是否存在并有效
		if (groundModel.getgId().equals("") || groundModel.getgStatus() == "0") {
			return Constant.GROUNDINVALID;
		}

		// 检测场地此时间段是否空闲
		GroundbookDaoImpl groundbookDaoImpl = new GroundbookDaoImpl();
		List groundBookList = groundbookDaoImpl.queryByTime(
				groundBookModel.getbStartTime(), groundBookModel.getbEndTime());

		if (groundBookList.size() != 0) {
			return Constant.TIMECLASH;
		}

		// 计算费用
		groundBookModel.setbFee(new CalculationUitl().calculaBookMoney(
				groundBookModel, groundModel) + "");

		if (groundbookDaoImpl.addGroundbook(groundBookModel) == 1) {
			return Constant.SUCCESS;

		} else {
			return Constant.ERROR;
		}

	}

	public List queryGroundBook() {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryGround();
	}

	public GroundBookModel queryById(String bId) {
		// TODO Auto-generated method stub

		return null;
	}

	public GroundBookModel queryByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryAllType() {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryAllType();

	}

	public List queryGround() {
		// TODO Auto-generated method stub

		return null;
	}

	public GroundModel queryGroundById(String gId) {
		// TODO Auto-generated method stub

		GroundDaoImpl groundDaoImpl = new GroundDaoImpl();

		return groundDaoImpl.queryById(gId);
	}

}
