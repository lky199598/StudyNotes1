package com.tiantian.action;

import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class add_commentAction extends ActionSupport{
	
	private String House_id;
	private String pingjia;
	
	
	
	public String getHouse_id() {
		return House_id;
	}



	public void setHouse_id(String house_id) {
		House_id = house_id;
	}



	public String getPingjia() {
		return pingjia;
	}



	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}



	public String add_comment(){
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		
		
		jdbcDao dao=new jdbcDao("tiantian");
		dao.insert_comment(session.get("current_id").toString(), House_id, pingjia);
		
		return "success";
	}
}
