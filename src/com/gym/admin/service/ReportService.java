package com.gym.admin.service;

import java.util.List;

public interface ReportService {

	/**
	 * 查询所有收入
	 * 
	 * @return
	 */
	public List queryAll();

	/**
	 * 查询场地预约收入
	 * 
	 * @return
	 */
	public List queryGround();

	/**
	 * 查询器材租借收入
	 * 
	 * @return
	 */
	public List queryEquipment();

}
