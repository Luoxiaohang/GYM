package com.gym.dao;

import java.util.List;

import com.gym.model.NoticeModel;

public interface NoticeDao {

	/**
	 * 添加公告
	 * 
	 * @param noticeModel
	 * @return
	 */
	public int addNotice(NoticeModel noticeModel);

	/**
	 * 删除公告
	 * 
	 * @param nId
	 * @return
	 */
	public int delNotice(String nId);

	/**
	 * 修改公告
	 * 
	 * @param noticeModel
	 * @return
	 */
	public int alterNotice(NoticeModel noticeModel);

	/**
	 * 查询公告
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
	 * 根据标题查询公告
	 * 
	 * @param nName
	 * @return
	 */
	public NoticeModel queryByName(String nName);

}
