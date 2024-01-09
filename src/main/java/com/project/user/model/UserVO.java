package com.project.user.model;

import java.sql.Timestamp;

public class UserVO {

	//DB의 정보를 담기 위해 DB컬럼과 동일하게 변수명 선언
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_address;
	private String user_gender;
	private int user_balance;
	
	public UserVO() {
	}

	public UserVO(String id, String pw, String name, String email, String address, String gender, int balance) {
		super();
		this.user_id = id;
		this.user_pw = pw;
		this.user_name = name;
		this.user_email = email;
		this.user_address = address;
		this.user_gender = gender;
		this.user_balance = balance;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public int getUser_balance() {
		return user_balance;
	}

	public void setUser_balance(int user_balance) {
		this.user_balance = user_balance;
	}

	
}
