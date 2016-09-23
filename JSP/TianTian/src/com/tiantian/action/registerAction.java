package com.tiantian.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class registerAction extends ActionSupport{
	String account_name;
	String password;
	String repeatpassword;
	
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatpassword() {
		return repeatpassword;
	}
	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}
	public String reg(){
		System.out.println(password);
		System.out.println(repeatpassword);
		if(!password.equals(repeatpassword)){
			return "fail";
		}
		jdbcDao dao=new jdbcDao("tiantian");
		dao.User_insert(account_name, password);
		return "success";
		
	}
}
