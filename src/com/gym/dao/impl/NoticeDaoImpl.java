package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.NoticeDao;
import com.gym.model.NoticeModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

public class NoticeDaoImpl implements NoticeDao {

	public int addNotice(NoticeModel noticeModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "INSERT INTO `notice` " + "( nTitle, nText, nDate, aId)"
				+ "VALUES('" + noticeModel.getnTitle() + "', '"
				+ noticeModel.getnText() + "', '" + noticeModel.getnDate()
				+ "', '" + noticeModel.getaId() + "')";
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affect;

	}

	public int delNotice(String nId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int alterNotice(NoticeModel noticeModel) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List queryNotice() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `notice` ORDER BY nDate DESC";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			List list = new ArrayList();
			NoticeModel noticeModel;
			while (resultSet.next()) {
				noticeModel = new NoticeModel();

				noticeModel.setaId(resultSet.getString("aId"));
				noticeModel.setnDate(resultSet.getString("nDate"));
				noticeModel.setnId(resultSet.getString("nId"));
				noticeModel.setnText(resultSet.getString("nText"));
				noticeModel.setnTitle(resultSet.getString("nTitle"));

				list.add(noticeModel);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public NoticeModel queryById(String nId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `notice` WHERE nId = " + nId;
		System.out.println(sql);

		NoticeModel noticeModel = new NoticeModel();

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet
					.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等

			while (resultSet.next()) {

				noticeModel.setaId(resultSet.getString("aId"));
				noticeModel.setnDate(resultSet.getString("nDate"));
				noticeModel.setnId(resultSet.getString("nId"));
				noticeModel.setnText(resultSet.getString("nText"));
				noticeModel.setnTitle(resultSet.getString("nTitle"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noticeModel;

	}

	public NoticeModel queryByName(String nName) {
		// TODO Auto-generated method stub

		return null;
	}

}
