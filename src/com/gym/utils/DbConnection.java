package com.gym.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接类
 * 
 * @author Feng
 * 
 */
public class DbConnection {
	static Connection conn = null;
	static Statement statement = null;

	static private String dbUser = "root";
	static private String dbPassword = "root";

	/**
	 * 获取connection连接
	 * 
	 * @return
	 */
	public static Connection getConn() {

		try {
			if (conn != null && !conn.isClosed()) {
				return conn;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// String url = "jdbc:mysql://localhost:3306/gymdb?user=" + dbUser;
		String url = "jdbc:mysql://localhost:3306/gymdb?user=" + dbUser
				+ "&password=" + dbPassword + "&characterEncoding=utf-8";

		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, dbUser, dbPassword);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 获取 Statement
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Statement getStatement() {

		try {
			// 判断conn是否为空或已关闭
			if (conn == null || conn.isClosed()) { // 重新连接数据库

				// String url = "jdbc:mysql://localhost/gymdb?user=" + dbUser;
				String url = "jdbc:mysql://localhost/gymdb?user=" + dbUser
						+ "&password=" + dbPassword
						+ "&characterEncoding=utf-8";

				try {
					Class.forName("org.gjt.mm.mysql.Driver").newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					conn = DriverManager.getConnection(url, dbUser, dbPassword);
					System.out.println("数据库连接成功");
					statement = (Statement) conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return statement;
			} else {// 使用旧连接
				statement = (Statement) conn.createStatement();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return statement;

	}
}
