package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class commentAction extends ActionSupport{
	
		
	private String House_id;

	
	
	
	public String getHouse_id() {
		return House_id;
	}



	public void setHouse_id(String house_id) {
		House_id = house_id;
	}



	public String comment(){
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		jdbcDao dao=new jdbcDao("tiantian");
		ResultSet rs=dao.select_from_house("", "comment");
		
		JsonArray ja=new JsonArray();
		int i=0;
		try {
			while(rs.next()){
				JsonObject o=new JsonObject();
				o.addProperty("User_id" + i, rs.getString("User_id"));
				o.addProperty("House_id" + i, rs.getString("House_id"));
				o.addProperty("Comment" + i, rs.getString("Comment"));
			
				
				ja.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(ja.toString());
		
		session.put("comment_list", ja.toString());
		
		
		return "success";
	}
	
}
