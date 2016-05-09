package com.sysu.oop.duizishou_server;

import com.mysql.jdbc.JDBC4UpdatableResultSet;

public class Config {
	public static String getJdbcurl() {
		return jdbcUrl;
	}
	public static String getDbuser() {
		return dbUser;
	}
	public static String getDbpasswd() {
		return dbPasswd;
	}
	public static final String jdbcUrl = "jdbc:mysql://localhost:3306/duizishou";
	public static final String dbUser = "root";
	public static final String dbPasswd = "123456";
}
