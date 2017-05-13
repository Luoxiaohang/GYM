package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.EquipmentRentDao;
import com.gym.model.EquipmentRentModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class EquipmentRentDaoImpl implements EquipmentRentDao {

	public int addEquipmentRent(EquipmentRentModel equipmentRentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "INSERT INTO `equipmentrent` "
				+ "( eId, uId, borrowBegin, borrowEnd, borrowFee, status)"
				+ "VALUES(  '" + equipmentRentModel.geteId() + "', '"
				+ equipmentRentModel.getuId() + "', '"
				+ equipmentRentModel.getBorrowBegin() + "', '"
				+ equipmentRentModel.getBorrowEnd() + "', '"
				+ equipmentRentModel.getBorrowFee() + "', '1')";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public List queryByTime(String begin, String end) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `equipmentrent` WHERE borrowBegin >= '"
				+ begin + "' AND borrowEnd <= '" + end + "'";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			EquipmentRentModel equipmentRentModel;
			while (resultSet.next()) {

				equipmentRentModel = new EquipmentRentModel();

				equipmentRentModel.seteRentId(resultSet.getString("eRentId"));
				equipmentRentModel.setBorrowBegin(resultSet
						.getString("borrowBegin"));
				equipmentRentModel.setBorrowEnd(resultSet
						.getString("borrowEnd"));
				equipmentRentModel.setBorrowFee(resultSet
						.getString("borrowFee"));
				equipmentRentModel.seteId(resultSet.getString("eId"));
				equipmentRentModel.setStatus(resultSet.getString("status"));
				equipmentRentModel.setuId(resultSet.getString("uId"));

				list.add(equipmentRentModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List queryRentByUserId(String uId) {
		// TODO Auto-generated method stub
		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `equipmentrent` WHERE uId = '" + uId
				+ "' AND status != 0";
		System.out.println(sql);

		List list = new ArrayList();

		EquipmentRentModel equipmentRentModel;

		try {

			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				equipmentRentModel = new EquipmentRentModel();

				equipmentRentModel = new EquipmentRentModel();

				equipmentRentModel.seteRentId(resultSet.getString("eRentId"));
				equipmentRentModel.setBorrowBegin(resultSet
						.getString("borrowBegin"));
				equipmentRentModel.setBorrowEnd(resultSet
						.getString("borrowEnd"));
				equipmentRentModel.setBorrowFee(resultSet
						.getString("borrowFee"));
				equipmentRentModel.seteId(resultSet.getString("eId"));
				equipmentRentModel.setStatus(resultSet.getString("status"));
				equipmentRentModel.setuId(resultSet.getString("uId"));

				list.add(equipmentRentModel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public EquipmentRentModel queryRentByRentId(String eRentId) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `equipmentrent` WHERE eRentid = '"
				+ eRentId + "' AND status != '0'";
		System.out.println(sql);

		EquipmentRentModel equipmentRentModel = null;
		try {

			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				equipmentRentModel = new EquipmentRentModel();

				equipmentRentModel.seteRentId(resultSet.getString("eRentId"));
				equipmentRentModel.setBorrowBegin(resultSet
						.getString("borrowBegin"));
				equipmentRentModel.setBorrowEnd(resultSet
						.getString("borrowEnd"));
				equipmentRentModel.setBorrowFee(resultSet
						.getString("borrowFee"));
				equipmentRentModel.seteId(resultSet.getString("eId"));
				equipmentRentModel.setStatus(resultSet.getString("status"));
				equipmentRentModel.setuId(resultSet.getString("uId"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return equipmentRentModel;

	}

	public int rentGet(EquipmentRentModel equipmentRentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE equipmentrent SET status = '2' WHERE eRentId = '"
				+ equipmentRentModel.geteRentId() + "'";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;
	}

	public int rentReturn(EquipmentRentModel equipmentRentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE equipmentrent SET status = '0' WHERE eRentId = '"
				+ equipmentRentModel.geteRentId() + "'";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;
	}

}
