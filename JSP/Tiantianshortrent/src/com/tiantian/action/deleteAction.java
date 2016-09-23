package com.tiantian.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class deleteAction extends ActionSupport{
	private String id;
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public String delete(){
		System.out.println("Hello, world");
		System.out.println(id);
		jdbcDao dao=new jdbcDao("tiantian");
		dao.delete_from_table("user", id, 0);
		
		return "success";
	}
}
