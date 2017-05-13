package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.GroundbookDao;
import com.gym.model.GroundBookModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class GroundbookDaoImpl implements GroundbookDao {

	public int addGroundbook(GroundBookModel groundBookModel) {
		// TODO Auto-generated method stub

		int affect = 0;

		String sql = "INSERT INTO groundbook (uId,gId,bDate,bStartTime,bEndTime,bFee,bStatus) values(?,?,?,?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, groundBookModel.getuId());
			statement.setString(2, groundBookModel.getgId());
			statement.setString(3, groundBookModel.getbDate());
			statement.setString(4, groundBookModel.getbStartTime());
			statement.setString(5, groundBookModel.getbEndTime());
			statement.setString(6, groundBookModel.getbFee());
			statement.setString(7, "1");
			affect = statement.executeUpdate();
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

		String sql = "SELECT * FROM `groundbook` WHERE bStartTime >= '" + begin
				+ "' AND bEndTime <= '" + end + "'";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			GroundBookModel groundBookModel;
			while (resultSet.next()) {

				groundBookModel = new GroundBookModel();

				groundBookModel.setbDate(resultSet.getString("bDate"));
				groundBookModel.setbEndTime(resultSet.getString("bEndTime"));
				groundBookModel.setbFee(resultSet.getString("bfee"));
				groundBookModel.setbId(resultSet.getString("bId"));
				groundBookModel
						.setbStartTime(resultSet.getString("bStartTime"));
				groundBookModel.setbStatus(resultSet.getString("bStatus"));
				groundBookModel.setgId(resultSet.getString("gId"));
				groundBookModel.setuId(resultSet.getString("uId"));

				list.add(groundBookModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List queryBookByUserId(String uId) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `groundbook` WHERE uId = '" + uId
				+ "' AND bStatus = '1' ORDER BY bStartTime ASC";
		System.out.println(sql);

		List list = new ArrayList();
		GroundBookModel groundBookModel;
		try {

			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				groundBookModel = new GroundBookModel();

				groundBookModel.setbDate(resultSet.getString("bDate"));
				groundBookModel.setbEndTime(resultSet.getString("bEndTime"));
				groundBookModel.setbFee(resultSet.getString("bfee"));
				groundBookModel.setbId(resultSet.getString("bId"));
				groundBookModel
						.setbStartTime(resultSet.getString("bStartTime"));
				groundBookModel.setbStatus(resultSet.getString("bStatus"));
				groundBookModel.setgId(resultSet.getString("gId"));
				groundBookModel.setuId(resultSet.getString("uId"));

				list.add(groundBookModel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public GroundBookModel queryBookByBookId(String bId) {
		// TODO Auto-generated method stub

		Statement statement = (Statement) DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `groundbook` WHERE bId = '" + bId + "'";
		System.out.println(sql);

		GroundBookModel groundBookModel = null;
		try {

			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			while (resultSet.next()) {

				groundBookModel = new GroundBookModel();

				groundBookModel.setbDate(resultSet.getString("bDate"));
				groundBookModel.setbEndTime(resultSet.getString("bEndTime"));
				groundBookModel.setbFee(resultSet.getString("bfee"));
				groundBookModel.setbId(resultSet.getString("bId"));
				groundBookModel
						.setbStartTime(resultSet.getString("bStartTime"));
				groundBookModel.setbStatus(resultSet.getString("bStatus"));
				groundBookModel.setgId(resultSet.getString("gId"));
				groundBookModel.setuId(resultSet.getString("uId"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return groundBookModel;

	}

	public int groundUse(GroundBookModel groundBookModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE groundbook SET bStatus = '0' WHERE bId = '"
				+ groundBookModel.getbId() + "'";
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
