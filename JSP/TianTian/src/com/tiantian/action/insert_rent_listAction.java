package com.tiantian.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class insert_rent_listAction extends ActionSupport{
	
	
	private String House_id;
	private String inhouse;
	private String outhouse;
	
	
	
	
	public String getHouse_id() {
		return House_id;
	}




	public void setHouse_id(String house_id) {
		House_id = house_id;
	}




	public String getInhouse() {
		return inhouse;
	}




	public void setInhouse(String inhouse) {
		this.inhouse = inhouse;
	}




	public String getOuthouse() {
		return outhouse;
	}




	public void setOuthouse(String outhouse) {
		this.outhouse = outhouse;
	}




	public String insert_rent_list() {
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		Date date=null;
		try {
			date=sdf.parse(outhouse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jdbcDao dao=new jdbcDao("tiantian");
		dao.rent_list_insert(session.get("current_id").toString(), House_id, date);
		
		return "success";
	}
}
