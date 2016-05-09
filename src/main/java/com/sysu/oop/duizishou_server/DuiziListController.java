package com.sysu.oop.duizishou_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DuiziListController {
	
	@RequestMapping(value = "/getDuiziList")
	public String getDuiziList() throws ClassNotFoundException, SQLException {
		JSONObject resultJson = new JSONObject();

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/duizishou";
		Connection conn = DriverManager.getConnection(url, "root", "123456");
		Statement stmt = conn.createStatement();

		String sql = "select s.id, s.sl, s.zan, u.username from shanglian s, user u where u.id=s.userid;";
		ResultSet rSet = stmt.executeQuery(sql);
		
		
		
		while (rSet.next()) {
			
			int id = rSet.getInt(1);
			String sl = rSet.getString(2);
			int zan = rSet.getInt(3);
			String username = rSet.getString(4);
			
			JSONObject duiziItem = new JSONObject();
			duiziItem.put("sl", sl);
			duiziItem.put("zan", zan);
			duiziItem.put("username", username);
			
			resultJson.put(id, duiziItem);
		}
		
		rSet.close();
		stmt.close();
		conn.close();

		return resultJson.toJSONString();
	}

}
