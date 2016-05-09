package com.sysu.oop.duizishou_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.catalina.connector.Request;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddSlController {
	
	@RequestMapping(value = "/addSl", method = RequestMethod.POST)
	public String addSl(@RequestBody AddSlActionData action_data) throws ClassNotFoundException, SQLException {
		
		int userid = action_data.getUserid();
		String shanglian = action_data.getShanglian();
		
		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/duizishou";
		String url = Config.getJdbcurl();
		Connection conn = DriverManager.getConnection(url, Config.getDbuser(), Config.getDbpasswd());
		Statement stmt = conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("insert into shanglian values(null, ?, ?, 0)");
		preparedStatement.setString(1, shanglian);
		preparedStatement.setInt(2, userid);
		ResultSet rSet = preparedStatement.executeQuery();
		
		rSet.close();
		preparedStatement.close();
		conn.close();
		
		return null;
	}
}
