package com.gym.admin.service.impl;

import java.util.List;

import com.gym.admin.service.MatchService;
import com.gym.dao.impl.MatchDaoImpl;
import com.gym.model.MatchModel;
import com.gym.utils.Constant;

public class MatchServiceImpl implements MatchService {

	public int addMatch(MatchModel matchModel) {
		// TODO Auto-generated method stub

		MatchDaoImpl matchDaoImpl = new MatchDaoImpl();

		if (matchDaoImpl.addMatch(matchModel) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}

	}

	public int delMatch(String mId) {
		// TODO Auto-generated method stub

		MatchDaoImpl matchDaoImpl = new MatchDaoImpl();

		if (matchDaoImpl.delMatch(mId) == 1) {
			return Constant.SUCCESS;
		} else {
			return Constant.ERROR;
		}
	}

	public int alterMatch(MatchModel matchModel) {

		// TODO Auto-generated method stub
		return 0;
	}

	public List queryMatch() {
		// TODO Auto-generated method stub

		MatchDaoImpl matchDaoImpl = new MatchDaoImpl();

		return matchDaoImpl.queryMatch();
	}

	public MatchModel queryById(String mId) {
		// TODO Auto-generated method stub

		MatchDaoImpl matchDaoImpl = new MatchDaoImpl();

		return matchDaoImpl.queryById(mId);
	}

	public MatchModel queryByName(String mName) {
		// TODO Auto-generated method stub
		return null;
	}

}
