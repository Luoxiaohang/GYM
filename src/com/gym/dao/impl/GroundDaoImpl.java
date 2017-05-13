package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.GroundDao;
import com.gym.model.GroundModel;
import com.gym.model.GroundTypeModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class GroundDaoImpl implements GroundDao {

	public int addGround(GroundModel groundModel) {
		// TODO Auto-generated method stub

		int affect = 0;

		String sql = "INSERT INTO ground ( gName, tId, gFee, gStatus, gRemark) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, groundModel.getgName());
			statement.setString(2, groundModel.gettId());
			statement.setString(3, groundModel.getgFee());
			statement.setString(4, groundModel.getgStatus());
			statement.setString(5, groundModel.getgRemark());
			affect = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int delGround(String gId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE ground SET gStatus = 0 WHERE gId = " + gId;
		// System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;
	}

	public int alterGround(GroundModel groundModel) {
		// TODO Auto-generated method stub
		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE ground SET gName = '" + groundModel.getgName()
				+ "' ,tId = '" + groundModel.gettId() + "' ,gFee = '"
				+ groundModel.getgFee() + "',gStatus = '1' ,gRemark = '"
				+ groundModel.getgRemark() + "' WHERE gId = "
				+ groundModel.getgId();
		// System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;
	}

	public List queryGround() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM ground g,groundtype t WHERE g.tId=t.tId and g.gStatus = 1 ORDER BY gId ASC ";
		// System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			GroundModel groundModel;
			while (resultSet.next()) {
				groundModel = new GroundModel();
				groundModel.setgFee(resultSet.getString("gFee"));
				groundModel.setgId(resultSet.getString("gId"));
				groundModel.setgName(resultSet.getString("gName"));
				groundModel.setgRemark(resultSet.getString("gRemark"));
				groundModel.setgStatus(resultSet.getString("gStatus"));
				groundModel.settId(resultSet.getString("tId"));
				groundModel.settName(resultSet.getString("tName"));

				list.add(groundModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List queryAllType() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `groundtype`";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			GroundTypeModel groundTypeModel;
			while (resultSet.next()) {

				groundTypeModel = new GroundTypeModel();

				groundTypeModel.settId(resultSet.getString("tId"));
				groundTypeModel.settName(resultSet.getString("tName"));

				list.add(groundTypeModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public GroundModel queryById(String gId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM ground g,groundtype t WHERE g.tId=t.tId and g.gStatus = 1 AND gId = "
				+ gId;
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			GroundModel groundModel = new GroundModel();
			while (resultSet.next()) {

				groundModel.setgFee(resultSet.getString("gFee"));
				groundModel.setgId(resultSet.getString("gId"));
				groundModel.setgName(resultSet.getString("gName"));
				groundModel.setgRemark(resultSet.getString("gRemark"));
				groundModel.setgStatus(resultSet.getString("gStatus"));
				groundModel.settId(resultSet.getString("tId"));
				groundModel.settName(resultSet.getString("tName"));

			}
			return groundModel;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public GroundModel queryByName(String gName) {
		// TODO Auto-generated method stub
		return null;
	}

}
