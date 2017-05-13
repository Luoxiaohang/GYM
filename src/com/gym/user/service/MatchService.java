package com.gym.user.service;

import java.util.List;

import com.gym.model.MatchModel;

public interface MatchService {

	/**
	 * 查询所有赛事
	 * 
	 * @return
	 */
	public List queryMatch();

	public MatchModel queryById(String mId);

	public MatchModel queryByName(String mName);
}
