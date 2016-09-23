package com.tiantian.web;

import com.opensymphony.xwork2.ActionSupport;

public class nice extends ActionSupport{
	/**
	 * 
	 */
	private String id;
	private String password;
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String wahaha(){
		System.out.println(id);
		System.out.println(password);
		return "success";
	}
}	
