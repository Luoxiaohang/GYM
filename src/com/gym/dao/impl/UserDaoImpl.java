package com.gym.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gym.dao.UserDao;
import com.gym.model.EquipmentRentModel;
import com.gym.model.GroundBookModel;
import com.gym.model.UserModel;
import com.gym.utils.DbConnection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class UserDaoImpl implements UserDao {

	public int addUser(UserModel userModel) {
		// TODO Auto-generated method stub

		int affect = 0;

		PreparedStatement statement;
		try {
			statement = (PreparedStatement) DbConnection
					.getConn()
					.prepareStatement(
							"INSERT INTO `user` (uName, uPassword, uEmail, uIdCard, uPhone, date, status,uId) values(?,?,?,?,?,?,?,?)");
			statement.setString(1, userModel.getuName());
			statement.setString(2, userModel.getuPassword());
			statement.setString(3, userModel.getuEmail());
			statement.setString(4, userModel.getuIdCard());
			statement.setString(5, userModel.getuPhone());
			statement.setString(6, userModel.getDate());
			statement.setString(7, "1");
			statement.setString(8, userModel.getuId());
			affect = statement.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return affect;
	}

	public int delUser(String uId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE `user` SET status = '0' WHERE uId = " + uId;
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;

	}

	public int alterUser(UserModel userModel) {
		// TODO Auto-generated method stub

		int affect = 0;
		String sql = "UPDATE user SET uName = (?) , uEmail =(?) , uPhone =(?) , uIdCard = (?) WHERE uId =(?)";
		System.out.println(sql);
		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, userModel.getuName());
			statement.setString(2, userModel.getuEmail());
			statement.setString(3, userModel.getuPhone());
			statement.setString(4, userModel.getuIdCard());
			statement.setString(5, userModel.getuId());
			affect = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;
	}

	public int alterUserPwd(UserModel userModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		int affect = 0;

		String sql = "UPDATE user SET uPassword = '" + userModel.getuPassword()
				+ "' WHERE uId = " + userModel.getuId();
		System.out.println(sql);

		try {
			affect = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return affect;

	}

	public List queryUser() {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;
		UserModel userModel = null;

		List list = new ArrayList();

		String sql = "SELECT * FROM `user`";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);

			while (resultSet.next()) {
				userModel = new UserModel();
				userModel.setDate(resultSet.getString("date"));
				userModel.setStatus(resultSet.getString("status"));
				userModel.setuEmail(resultSet.getString("uEmail"));
				userModel.setuId(resultSet.getString("uId"));
				userModel.setuIdCard(resultSet.getString("uIdcard"));
				userModel.setuName(resultSet.getString("uName"));
				userModel.setuPassword(resultSet.getString("uPassword"));
				userModel.setuPhone(resultSet.getString("uPhone"));

				list.add(userModel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public UserModel queryUserByName(String uName) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;
		UserModel userModel = null;

		String sql = "SELECT * FROM `user` WHERE uName = '" + uName + "'";
		// System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);

			while (resultSet.next()) {
				userModel = new UserModel();
				userModel.setDate(resultSet.getString("date"));
				userModel.setStatus(resultSet.getString("status"));
				userModel.setuEmail(resultSet.getString("uEmail"));
				userModel.setuId(resultSet.getString("uId"));
				userModel.setuIdCard(resultSet.getString("uIdcard"));
				userModel.setuName(resultSet.getString("uName"));
				userModel.setuPassword(resultSet.getString("uPassword"));
				userModel.setuPhone(resultSet.getString("uPhone"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userModel;

	}

	public UserModel queryUserById(String uId) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;
		UserModel userModel = null;

		String sql = "SELECT * FROM `user` WHERE uId = '" + uId + "'";
		System.out.println(sql);

		try {
			resultSet = (ResultSet) statement.executeQuery(sql);

			while (resultSet.next()) {
				userModel = new UserModel();
				userModel.setDate(resultSet.getString("date"));
				userModel.setStatus(resultSet.getString("status"));
				userModel.setuEmail(resultSet.getString("uEmail"));
				userModel.setuId(resultSet.getString("uId"));
				userModel.setuIdCard(resultSet.getString("uIdcard"));
				userModel.setuName(resultSet.getString("uName"));
				userModel.setuPassword(resultSet.getString("uPassword"));
				userModel.setuPhone(resultSet.getString("uPhone"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userModel;

	}

	public boolean isExist(String uId) {
		// TODO Auto-generated method stub

		ResultSet resultSet = null;
		PreparedStatement statement;
		try {
			String sql = "SELECT * FROM `user` WHERE uId = (?)";
			statement = (PreparedStatement) DbConnection.getConn()
					.prepareStatement(sql);
			statement.setString(1, uId);
			resultSet = (ResultSet) statement.executeQuery();
		} catch (Exception e) {
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

	public boolean onUser(String uId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean offUser(String uId) {
		// TODO Auto-generated method stub
		return false;
	}

	public UserModel checkUser(UserModel userModel) {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		String sql = "SELECT * FROM `user` WHERE uId = (?)and uPassword=(?) and status=(?)";
		// System.out.println(sql);

		try {
			PreparedStatement statement = (PreparedStatement) DbConnection
					.getConn().prepareStatement(sql);
			statement.setString(1, userModel.getuId());
			statement.setString(2, userModel.getuPassword());
			statement.setString(3, "1");
			resultSet = (ResultSet) statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean resultSetRow = false;
		try {
			resultSetRow = resultSet.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (resultSetRow) {
			try {
				userModel.setDate(resultSet.getString("date"));
				userModel.setStatus(resultSet.getString("status"));
				userModel.setuEmail(resultSet.getString("uEmail"));
				userModel.setuId(resultSet.getString("uId"));
				userModel.setuIdCard(resultSet.getString("uIdCard"));
				userModel.setuName(resultSet.getString("uName"));
				userModel.setuPassword(resultSet.getString("uPassword"));
				userModel.setuPhone(resultSet.getString("uPhone"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userModel;
		} else {
			return null;
		}

	}

	public List queryMyBook(UserModel userModel) {
		// TODO Auto-generated method stub

		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `groundbook` WHERE uId = '"
				+ userModel.getuId() + "'";
		System.out.println(sql);

		List list = new ArrayList();
		GroundBookModel groundBookModel;
		try {

			resultSet = (ResultSet) statement.executeQuery(sql);

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

	public List queryMyRent(UserModel userModel) {
		// TODO Auto-generated method stub
		Statement statement = DbConnection.getStatement();
		ResultSet resultSet = null;

		String sql = "SELECT * FROM `equipmentrent` WHERE uId = '"
				+ userModel.getuId() + "'";
		System.out.println(sql);

		List list = new ArrayList();

		EquipmentRentModel equipmentRentModel;

		try {

			resultSet = (ResultSet) statement.executeQuery(sql);

			while (resultSet.next()) {

				equipmentRentModel = new EquipmentRentModel();

				equipmentRentModel = new EquipmentRentModel();

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

}
