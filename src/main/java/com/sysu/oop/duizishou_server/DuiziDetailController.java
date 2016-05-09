package com.sysu.oop.duizishou_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.apache.bcel.internal.generic.RETURN;

@RestController
public class DuiziDetailController {
	
	@RequestMapping(value = "/getDuiziDetail", method = RequestMethod.POST)
	public String getDuiziDetail(@RequestBody DuiziDetailData duizi_data) throws ClassNotFoundException, SQLException { 
		int sl_id = duizi_data.getId();
		
		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/duizishou";
		String url = Config.getJdbcurl();
		Connection conn = DriverManager.getConnection(url, Config.getDbuser(), Config.getDbpasswd());
		Statement stmt = conn.createStatement();
		
		String sql = "select x.id, x.xl, u.username, x.zan from shanglian s, xialian x, user u where x.slid=" + sl_id + " and x.userid=u.id;";
		ResultSet rSet = stmt.executeQuery(sql);
		
		JSONObject resObject = new JSONObject();
		
		while (rSet.next()) {
			int id = rSet.getInt(1);
			String xl = rSet.getString(2);
			String username = rSet.getString(3);
			int zan = rSet.getInt(4);
			
			JSONObject xlItem = new JSONObject();
			xlItem.put("xl", xl);
			xlItem.put("username", username);
			xlItem.put("zan", zan);
			
			resObject.put(id, xlItem);
		}
		

		rSet.close();
		stmt.close();
		conn.close();
		
		System.out.println(resObject.toJSONString());
		return resObject.toJSONString();
	}
}
