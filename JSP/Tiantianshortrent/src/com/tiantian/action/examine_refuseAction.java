package com.tiantian.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class examine_refuseAction extends ActionSupport{
	
	private String house_id;
	public String getHouse_id(){
		return house_id;
	}
	public void setHouse_id(String house_id){
		this.house_id=house_id;
	}
	
	public String examine_refuse(){
		
		jdbcDao dao=new jdbcDao("tiantian");
		dao.delete_from_house(house_id);
		
		return "success";
	}
}
