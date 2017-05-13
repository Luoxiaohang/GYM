package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.MatchDao;
import com.gym.model.MatchModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class MatchDaoImpl implements MatchDao {

	public int addMatch(MatchModel matchModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "INSERT INTO `match` "
				+ "( mName, text, mDate, aId, status)" + "VALUES(  '"
				+ matchModel.getmName() + "', '" + matchModel.getText()
				+ "', '" + matchModel.getmDate() + "', '" + matchModel.getaId()
				+ "', '1')";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int delMatch(String mId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE `match` SET status = '0' WHERE mId = '" + mId
				+ "'";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int alterMatch(MatchModel matchModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int isExist(String mId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MatchModel queryById(String mId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `match` WHERE mId = " + mId;
		System.out.println(sql);

		MatchModel matchModel = new MatchModel();

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			while (resultSet.next()) {

				matchModel.setmDate(resultSet.getString("mDate"));
				matchModel.setmId(resultSet.getString("mId"));
				matchModel.setmName(resultSet.getString("mName"));
				matchModel.setStatus(resultSet.getString("status"));
				matchModel.setText(resultSet.getString("text"));
				matchModel.setaId(resultSet.getString("aId"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return matchModel;
	}

	public MatchModel queryByName(String mName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryMatch() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `match` WHERE status = '1' ORDER BY mId DESC";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData();

			List list = new ArrayList();
			MatchModel matchModel;
			while (resultSet.next()) {
				matchModel = new MatchModel();
				matchModel.setmDate(resultSet.getString("mDate"));
				matchModel.setmId(resultSet.getString("mId"));
				matchModel.setmName(resultSet.getString("mName"));
				matchModel.setStatus(resultSet.getString("status"));
				matchModel.setText(resultSet.getString("text"));
				matchModel.setaId(resultSet.getString("aId"));

				list.add(matchModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
