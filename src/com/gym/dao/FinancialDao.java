package com.gym.dao;

import java.util.List;

import com.gym.model.FinancialModel;

public interface FinancialDao {

	/**
	 * 增加记录
	 * 
	 * @param financialModel
	 * @return
	 */
	public boolean addRecord(FinancialModel financialModel);

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
