package com.gym.user.service.impl;

import java.util.List;

import com.gym.dao.impl.MatchDaoImpl;
import com.gym.model.MatchModel;
import com.gym.user.service.MatchService;

public class MatchServiceImpl implements MatchService {

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
