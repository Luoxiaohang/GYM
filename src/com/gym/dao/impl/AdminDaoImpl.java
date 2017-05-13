package com.gym.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.AdminDao;
import com.gym.model.AdminModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class AdminDaoImpl implements AdminDao {

	public int addAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		int affect = 0;
		String sql = "insert into `admin` (aName, aPassword, idCardNo, birthdate, power, email, phone, status, aEntry )values(?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, adminModel.getaName());
			statement.setString(2, adminModel.getaPassword());
			statement.setString(3, adminModel.getIdCardNo());
			statement.setString(4, adminModel.getBirthdate());
			statement.setString(5, adminModel.getPower());
			statement.setString(6, adminModel.getEmail());
			statement.setString(7, adminModel.getPhone());
			statement.setInt(8, 1);
			statement.setString(9, adminModel.getaEntry());
			affect = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("管理员成功插入" + affect + "条数据");
		return affect;
	}

	public int delAdmin(String aId) {
		// TODO Auto-generated method stub

		int affect = 0;

		String sql = "UPDATE admin SET status = (?) WHERE aId =(?) ";

		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setString(2, aId);
			System.out.println("禁用管理员:" + aId);
			affect = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;

	}

	public int alterAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryAdmin() {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;
		AdminModel adminModel = null;
		List list = new ArrayList();

		String sql = "SELECT * FROM `admin`";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				adminModel = new AdminModel();

				adminModel.setaEntry(resultSet.getString("aEntry"));
				adminModel.setaId(resultSet.getString("aId"));
				adminModel.setaName(resultSet.getString("aName"));
				adminModel.setaPassword(resultSet.getString("aPassword"));
				adminModel.setBirthdate(resultSet.getString("birthdate"));
				adminModel.setEmail(resultSet.getString("email"));
				adminModel.setIdCardNo(resultSet.getString("idCardNo"));
				adminModel.setPhone(resultSet.getString("phone"));
				adminModel.setPower(resultSet.getString("power"));
				adminModel.setStatus(resultSet.getString("status"));

				list.add(adminModel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public AdminModel queryAdminByName(String aName) {
		// TODO Auto-generated method stub
		return null;
	}

	public AdminModel queryAdminById(String aId) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;
		AdminModel adminModel = null;
		String sql = "SELECT * FROM `admin` WHERE aId = '" + aId + "'";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				adminModel = new AdminModel();

				adminModel.setaEntry(resultSet.getString("aEntry"));
				adminModel.setaId(resultSet.getString("aId"));
				adminModel.setaName(resultSet.getString("aName"));
				adminModel.setaPassword(resultSet.getString("aPassword"));
				adminModel.setBirthdate(resultSet.getString("birthdate"));
				adminModel.setEmail(resultSet.getString("email"));
				adminModel.setIdCardNo(resultSet.getString("idCardNo"));
				adminModel.setPhone(resultSet.getString("phone"));
				adminModel.setPower(resultSet.getString("power"));
				adminModel.setStatus(resultSet.getString("status"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adminModel;

	}

	public boolean onAdmin(String aId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean offAdmin(String aId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isExist(String aId) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		if (null == statement) {
			System.out.println("数据库连接失败");
			return false;
		}
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `admin` WHERE aId = " + aId;
		// System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean resultSetRow = false;

		if (resultSet != null) {
			try {
				resultSetRow = resultSet.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (resultSetRow) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub

		ResultSet resultSet = null;
		String sql = "SELECT * FROM `admin` WHERE aId =(?) AND aPassword = (?) and status=(?) ";
		PreparedStatement statement;
		try {
			statement = (PreparedStatement) DbConnection.getConn()
					.prepareStatement(sql);
			statement.setString(1, adminModel.getaId());
			statement.setString(2, adminModel.getaPassword());
			statement.setString(3, "1");
			resultSet = (ResultSet) statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean resultSetRow = false;
		if (resultSet != null) {
			try {
				resultSetRow = resultSet.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultSetRow;
	}
}
