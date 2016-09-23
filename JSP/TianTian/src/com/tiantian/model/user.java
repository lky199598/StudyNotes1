package com.tiantian.model;

import java.util.Date;

public class user {
	String User_id;
	String User_name;
	String User_password;
	String User_telephone;
	String User_idcard;
	String User_sex;
	String User_birthday;
	
	public user(String user_id, String user_name, String user_password,
			String user_telephone, String user_idcard, String user_sex,
			String user_birthday) {
		super();
		User_id = user_id;
		User_name = user_name;
		User_password = user_password;
		User_telephone = user_telephone;
		User_idcard = user_idcard;
		User_sex = user_sex;
		User_birthday = user_birthday;
	}
	public user(){

	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getUser_password() {
		return User_password;
	}
	public void setUser_password(String user_password) {
		User_password = user_password;
	}
	public String getUser_telephone() {
		return User_telephone;
	}
	public void setUser_telephone(String user_telephone) {
		User_telephone = user_telephone;
	}
	public String getUser_idcard() {
		return User_idcard;
	}
	public void setUser_idcard(String user_idcard) {
		User_idcard = user_idcard;
	}
	public String getUser_sex() {
		return User_sex;
	}
	public void setUser_sex(String user_sex) {
		User_sex = user_sex;
	}
	public String getUser_birthday() {
		return User_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		User_birthday = user_birthday;
	}
	
}
