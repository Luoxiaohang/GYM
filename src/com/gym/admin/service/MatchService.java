package com.gym.admin.service;

import java.util.List;

import com.gym.model.MatchModel;

public interface MatchService {

	/**
	 * 添加赛事
	 * 
	 * @param matchModel
	 * @return
	 */
	public int addMatch(MatchModel matchModel);

	/**
	 * 删除赛事
	 * 
	 * @param mId
	 * @return
	 */
	public int delMatch(String mId);

	/**
	 * 修改赛事
	 * 
	 * @param matchModel
	 * @return
	 */
	public int alterMatch(MatchModel matchModel);

	/**
	 * 查询所有赛事
	 * 
	 * @return
	 */
	public List queryMatch();

	/**
	 * 根据id查询赛事
	 * 
	 * @return
	 */
	public MatchModel queryById(String mId);

	/**
	 * 根据name查询赛事
	 * 
	 * @return
	 */
	public MatchModel queryByName(String mName);
}
