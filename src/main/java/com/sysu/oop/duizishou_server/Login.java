package com.sysu.oop.duizishou_server;

public class Login {
	private boolean loginStatus;
	private String token;

	public Login(boolean loginStatus, String token) {
		this.loginStatus = loginStatus;
		this.token = token;
	}

	public boolean getLoginStatus() {
		return this.loginStatus;
	}

	public String getToken() {
		return this.token;
	}

	public void setLoginStatus(boolean status) {
		this.loginStatus = status;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
