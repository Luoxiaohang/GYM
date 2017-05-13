package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.EquipmentDao;
import com.gym.model.EquipmentModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class EquipmentDaoImpl implements EquipmentDao {

	public int addEquipment(EquipmentModel equipmentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "INSERT INTO `equipment` "
				+ "( eTypeId, buyDate, buyCost, eFee, status, borrowCount)"
				+ "VALUES('" + equipmentModel.geteTypeId() + "', '"
				+ equipmentModel.getBuyDate() + "', '"
				+ equipmentModel.getBuyCost() + "', '"
				+ equipmentModel.geteFee() + "', '"
				+ equipmentModel.getStatus() + "', '"
				+ equipmentModel.getBorrowCount() + "')";
		// System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;
	}

	public int delEquipment(String eId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE equipment SET `status` = 0 WHERE eId = " + eId;
		// System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int alterEquipment(EquipmentModel equipmentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE equipment SET eTypeId = '"
				+ equipmentModel.geteTypeId() + "' ,eFee = '"
				+ equipmentModel.geteFee() + "' WHERE eId = "
				+ equipmentModel.geteId();
		// System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int addBorrowCount(EquipmentModel equipmentModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		int borrowCount = Integer.parseInt(equipmentModel.getBorrowCount());
		borrowCount++;

		String sql = "UPDATE equipment SET borrowCount = " + borrowCount
				+ " WHERE eId = '" + equipmentModel.geteId() + "'";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public List queryEquipment() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM equipment e,equipmenttype et WHERE e.eTypeId=et.eTypeId and status = 1 ORDER BY eId ASC ";
		// System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);

			List list = new ArrayList();
			EquipmentModel equipmentModel;
			while (resultSet.next()) {
				equipmentModel = new EquipmentModel();
				equipmentModel.setBorrowCount(resultSet
						.getString("borrowCount"));
				equipmentModel.setBuyCost(resultSet.getString("buyCost"));
				equipmentModel.setBuyDate(resultSet.getString("buyDate"));
				equipmentModel.seteFee(resultSet.getString("eFee"));
				equipmentModel.seteId(resultSet.getString("eId"));
				equipmentModel.seteTypeId(resultSet.getString("eTypeId"));
				equipmentModel.seteTypeName(resultSet.getString("eTypeName"));
				equipmentModel.setStatus(resultSet.getString("status"));
				list.add(equipmentModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public EquipmentModel queryById(String eId) {
		// TODO Auto-generated method stub

		ResultSet resultSet = null;

		String sql = "SELECT * FROM equipment,equipmenttype "
				+ "WHERE equipment.status = 1 AND equipment.etypeId=equipmenttype.etypeId and eId = (?)";
		System.out.println(sql);

		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, eId);
			resultSet = (ResultSet) statement.executeQuery();

			EquipmentModel equipmentModel = new EquipmentModel();

			while (resultSet.next()) {

				equipmentModel.setBorrowCount(resultSet
						.getString("borrowCount"));
				equipmentModel.setBuyCost(resultSet.getString("buyCost"));
				equipmentModel.setBuyDate(resultSet.getString("buyDate"));
				equipmentModel.seteFee(resultSet.getString("eFee"));
				equipmentModel.seteId(resultSet.getString("eId"));
				equipmentModel.seteTypeId(resultSet.getString("eTypeId"));
				equipmentModel.seteTypeName(resultSet.getString("eTypeName"));
				equipmentModel.setStatus(resultSet.getString("status"));

			}
			return equipmentModel;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public EquipmentModel queryByName(String eName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryAllType() {
		// TODO Auto-generated method stub
		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `equipmenttype`";
		// System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			EquipmentModel equipmentModel;
			while (resultSet.next()) {

				equipmentModel = new EquipmentModel();

				equipmentModel.seteTypeId(resultSet.getString("eTypeId"));
				equipmentModel.seteTypeName(resultSet.getString("eTypeName"));

				list.add(equipmentModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
