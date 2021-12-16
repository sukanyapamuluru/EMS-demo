package com.ciq.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connection_Util_Java {
	static Properties properties = null;
	static {
		try {
			properties = new Properties();
			properties.load(Connection_Util_Java.class.getClassLoader()
					.getResourceAsStream("com/ciq/sms/resources/db.properties"));
			Class.forName(properties.getProperty("Driver"));
		} catch (Exception e) {
		}
//			catch (ClassNotFoundException e) {
//		}
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	

	}

	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user_name"),
					properties.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
//			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Statement statement, Connection connection) {

		try {
			if (statement != null) {
				statement.close();
			}
			close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(ResultSet resultset, Statement statement, Connection connection) {

		try {
			if (resultset != null) {
				resultset.close();

			}
			close(statement, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
