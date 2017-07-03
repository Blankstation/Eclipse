package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
	public Connection getConnexction() throws Exception {
		Connection connection = null;
		String driverClass = "com.mysql.jdbc.Driver";
		String password = "000000";
		String uri = "jdbc:mysql://localhost:3306/blog";
		String name = "root";
		Class.forName(driverClass);
		connection = DriverManager.getConnection(uri, name, password);
		return connection;
	}

	public void closeDBResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
			throws Exception {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
