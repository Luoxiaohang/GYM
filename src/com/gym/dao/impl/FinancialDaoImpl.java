package com.gym.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.FinancialDao;
import com.gym.model.FinancialModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class FinancialDaoImpl implements FinancialDao {

	public boolean addRecord(FinancialModel financialModel) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		int affect = 0;

		String sql = "insert into `financial` "
				+ "(fOut, fIn, fInType, date, notes )" + "values('"
				+ financialModel.getfOut() + "', '" + financialModel.getfIn()
				+ "', '" + financialModel.getfInType() + "', '"
				+ financialModel.getDate() + "', '" + financialModel.getNotes()
				+ "')";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (affect == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List queryAll() {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `financial`";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			FinancialModel financialModel;
			while (resultSet.next()) {

				financialModel = new FinancialModel();

				financialModel.setDate(resultSet.getString("date"));
				financialModel.setfId(resultSet.getString("fId"));
				financialModel.setfIn(resultSet.getString("fIn"));
				financialModel.setfInType(resultSet.getString("fInType"));
				financialModel.setfOut(resultSet.getString("fOut"));
				financialModel.setNotes(resultSet.getString("notes"));

				list.add(financialModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List queryGround() {
		// TODO Auto-generated method stub
		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `financial` WHERE fInType = 0";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			FinancialModel financialModel;
			while (resultSet.next()) {

				financialModel = new FinancialModel();

				financialModel.setDate(resultSet.getString("date"));
				financialModel.setfId(resultSet.getString("fId"));
				financialModel.setfIn(resultSet.getString("fIn"));
				financialModel.setfInType(resultSet.getString("fInType"));
				financialModel.setfOut(resultSet.getString("fOut"));
				financialModel.setNotes(resultSet.getString("notes"));

				list.add(financialModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List queryEquipment() {
		// TODO Auto-generated method stub
		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `financial` WHERE fInType = 1";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			FinancialModel financialModel;
			while (resultSet.next()) {

				financialModel = new FinancialModel();

				financialModel.setDate(resultSet.getString("date"));
				financialModel.setfId(resultSet.getString("fId"));
				financialModel.setfIn(resultSet.getString("fIn"));
				financialModel.setfInType(resultSet.getString("fInType"));
				financialModel.setfOut(resultSet.getString("fOut"));
				financialModel.setNotes(resultSet.getString("notes"));

				list.add(financialModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
