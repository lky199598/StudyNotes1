package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class rent_houseAction extends ActionSupport{
	
	
	public String rent_house(){
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		jdbcDao dao=new jdbcDao("tiantian");
		ResultSet rs=dao.select_from_house(session.get("current_id").toString(), "rent_list");
		String house_id=null;
		try {
			while(rs.next())
				house_id=rs.getString("house_id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs2=dao.select_from_house(house_id, "rented");
		
		
		JsonArray ja=new JsonArray();
		int i=0;
		try {
			while(rs.next()){
				JsonObject o=new JsonObject();
				o.addProperty("Master" + i, rs2.getString("Master"));
				o.addProperty("House_id" + i, rs2.getString("House_id"));
				o.addProperty("Address" + i, rs2.getString("Address"));
				o.addProperty("Rent_station" + i, rs2.getString("Rent_station"));
				o.addProperty("Price" + i, rs2.getString("Address"));
				o.addProperty("Area" + i, rs2.getString("Area"));
				o.addProperty("Surrounding" + i, rs2.getString("Surrounding"));
				o.addProperty("Others" + i, rs2.getString("Others"));
				o.addProperty("Name" + i, rs2.getString("Name"));
				o.addProperty("Src" + i, rs2.getString("Src"));
				
				ja.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		session.put("rent_house_list", ja.toString());
		
		return "success";
		
	
	}
}
