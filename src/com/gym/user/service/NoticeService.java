package com.gym.user.service;

import java.util.List;

import com.gym.model.NoticeModel;

public interface NoticeService {

	/**
	 * 查询所有公告
	 * 
	 * @return
	 */
	public List queryNotice();

	/**
	 * 根据id查询公告
	 * 
	 * @param nId
	 * @return
	 */
	public NoticeModel queryById(String nId);

	/**
	 * 根据名字查询公告
	 * 
	 * @param nName
	 * @return
	 */
	public NoticeModel queryByName(String nName);
}
