package com.sysu.oop.duizishou_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Login> login(@RequestBody loginData login_data) {

		System.out.println("login info: " + login_data.getUsername() + " " + login_data.getPasswd());

		Login loginData = new Login(true, "0791");

		return new ResponseEntity<Login>(loginData, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/login")
	public ResponseEntity<Login> login() {
		Login loginRes = new Login(true, "0791");

		return new ResponseEntity<Login>(loginRes, HttpStatus.OK);
	}
}
