package com.sysu.oop.duizishou_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddXlController {
	
	@RequestMapping(value = "/addSl", method = RequestMethod.POST)
	public String addXialian(@RequestBody AddXlActionData actionData) throws ClassNotFoundException, SQLException {
		int slid = actionData.getSlid();
		int userid = actionData.getUserid();
		String xialian = actionData.getXialian();
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = Config.getJdbcurl();
		Connection conn = DriverManager.getConnection(url, Config.getDbuser(), Config.getDbpasswd());
		Statement stmt = conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("insert into shanglian values(null, ?, ?, ?, 0)");
		preparedStatement.setString(1, xialian);
		preparedStatement.setInt(2, slid);
		preparedStatement.setInt(3, userid);
		ResultSet rSet = preparedStatement.executeQuery();
		
		rSet.close();
		preparedStatement.close();
		conn.close();

		return null;
	}
}
