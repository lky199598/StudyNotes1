package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class my_rent_houseAction extends ActionSupport{
	
	
	public String my_rent_house(){
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		jdbcDao dao=new jdbcDao("tiantian");
		ResultSet rs=dao.select_from_house(session.get("current_id").toString(), "my_rent");
		
		JsonArray ja=new JsonArray();
		int i=0;
		try {
			while(rs.next()){
				JsonObject o=new JsonObject();
				o.addProperty("User_id" + i, rs.getString("User_id"));
				o.addProperty("House_id" + i, rs.getString("House_id"));
				o.addProperty("State" + i, rs.getString("State"));
				o.addProperty("Name" + i, rs.getString("Name"));
				o.addProperty("End_time" + i, rs.getString("End_time"));
				o.addProperty("Src" + i, rs.getString("Src"));
				o.addProperty("Price" + i, rs.getString("Price"));
			
				
				ja.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello, world");
		System.out.println(ja.toString());
		
		session.put("rent_house_list", ja.toString());
		
		return "success";
	}
	
}
