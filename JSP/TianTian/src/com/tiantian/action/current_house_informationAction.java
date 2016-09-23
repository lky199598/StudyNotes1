package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class current_house_informationAction extends ActionSupport{
	
	public String House_id;

	public String getHouse_id() {
		return House_id;
	}

	public void setHouse_id(String house_id) {
		House_id = house_id;
	}
	
	
	public String current_house_information(){
		
		jdbcDao dao=new jdbcDao("tiantian");
		
		ResultSet rs=dao.select_house("select * from house where House_id="+House_id);
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		JsonArray ja=new JsonArray();
		int i=0;
		try {
			while(rs.next()){
			
				JsonObject o=new JsonObject();
				o.addProperty("Master" + i, rs.getString("Master"));
				o.addProperty("House_id" + i, rs.getString("House_id"));
				o.addProperty("Address" + i, rs.getString("Address"));
				o.addProperty("Rent_station" + i, rs.getString("Rent_station"));
				o.addProperty("Price" + i, rs.getString("Price"));
				o.addProperty("Area" + i, rs.getString("Area"));
				o.addProperty("Surrounding" + i, rs.getString("Surrounding"));
				o.addProperty("Others" + i, rs.getString("Others"));
				o.addProperty("Name" + i, rs.getString("Name"));
				o.addProperty("Src" + i, rs.getString("Src"));
				
				ja.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(House_id);
		System.out.println(ja.toString());
		
		session.put("current_house_informaton", ja.toString());
		
		return "success";
	}
	
}
