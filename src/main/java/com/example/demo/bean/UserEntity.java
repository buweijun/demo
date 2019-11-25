package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class UserEntity {


	@Autowired
	private int id;

	@Autowired
	private int bindType;

	@Autowired
	private String loginName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBindType() {
		return bindType;
	}

	public void setBindType(int bindType) {
		this.bindType = bindType;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}




}
