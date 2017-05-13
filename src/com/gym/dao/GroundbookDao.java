package com.gym.dao;

import java.util.List;

import com.gym.model.GroundBookModel;

public interface GroundbookDao {

	/**
	 * 添加场地使用
	 * 
	 * @param groundModel
	 * @return
	 */
	public int addGroundbook(GroundBookModel groundBookModel);

	/**
	 * 根据时间间隔查询场地预定
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public List queryByTime(String begin, String end);

	/**
	 * 查询用户场地预定
	 * 
	 * @param uId
	 * @return
	 */
	public List queryBookByUserId(String uId);

	/**
	 * 根据预定id查询场地预定
	 * 
	 * @param bId
	 * @return
	 */
	public GroundBookModel queryBookByBookId(String bId);

	/**
	 * 使用场地
	 * 
	 * @param groundBookModel
	 * @return
	 */
	public int groundUse(GroundBookModel groundBookModel);
}
