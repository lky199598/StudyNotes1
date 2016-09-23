package com.tiantian.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class examine_agreeAction extends ActionSupport{
	
	private String house_id;
	public String getHouse_id(){
		return house_id;
	}
	public void setHouse_id(String house_id){
		this.house_id=house_id;
	}
	
	public String examine_agree(){
		
		System.out.println("Hello, world");
		System.out.println(house_id);
		System.out.println(house_id);
		System.out.println(house_id);
		System.out.println(house_id);
		System.out.println(house_id);
		System.out.println(house_id);
		System.out.println(house_id);
		
		jdbcDao dao=new jdbcDao("tiantian");
		dao.update_from_house(Integer.parseInt(house_id));
		
		return "success";
	}
}
