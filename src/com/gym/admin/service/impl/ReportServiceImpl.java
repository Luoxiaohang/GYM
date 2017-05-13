package com.gym.admin.service.impl;

import java.util.List;

import com.gym.admin.service.ReportService;
import com.gym.dao.impl.FinancialDaoImpl;

public class ReportServiceImpl implements ReportService {

	public List queryAll() {
		// TODO Auto-generated method stub

		FinancialDaoImpl financialDaoImpl = new FinancialDaoImpl();

		return financialDaoImpl.queryAll();
	}

	public List queryGround() {
		// TODO Auto-generated method stub
		FinancialDaoImpl financialDaoImpl = new FinancialDaoImpl();

		return financialDaoImpl.queryGround();
	}

	public List queryEquipment() {
		// TODO Auto-generated method stub
		FinancialDaoImpl financialDaoImpl = new FinancialDaoImpl();

		return financialDaoImpl.queryEquipment();
	}

}
