package com.gym.dao;

import java.util.List;

import com.gym.model.MatchModel;

public interface MatchDao {

	/**
	 * 添加比赛
	 * 
	 * @param matchModel
	 * @return
	 */
	public int addMatch(MatchModel matchModel);

	/**
	 * 删除比赛
	 * 
	 * @param mId
	 * @return
	 */
	public int delMatch(String mId);

	/**
	 * 修改比赛
	 * 
	 * @param matchModel
	 * @return
	 */
	public int alterMatch(MatchModel matchModel);

	/**
	 * 查询比赛id是否存在
	 * 
	 * @param mId
	 * @return
	 */
	public int isExist(String mId);

	/**
	 * 查询所有赛事
	 * 
	 * @return
	 */
	public List queryMatch();

	/**
	 * 根据比赛id查询比赛
	 * 
	 * @param mId
	 * @return
	 */
	public MatchModel queryById(String mId);

	/**
	 * 根据比赛名称查询比赛
	 * 
	 * @param mName
	 * @return
	 */
	public MatchModel queryByName(String mName);
}
