package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class house_informationAction extends ActionSupport{
	
	private String house_id;
	private String index;
	
	
	
	public String getHouse_id() {
		return house_id;
	}



	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}



	public String getIndex() {
		return index;
	}



	public void setIndex(String index) {
		this.index = index;
	}



	public String house_information(){
		
		System.out.println("Hello, world");
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		jdbcDao dao=new jdbcDao("tiantian");
		ResultSet rs=dao.select_from_house(house_id, "rented");
		
		ResultSet rs2=dao.select_from_house(house_id, "comment");
		JsonArray ja=new JsonArray();
		JsonArray ja2=new JsonArray();
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
		
		i=0;
		
		try {
			while(rs2.next()){
			
				JsonObject o=new JsonObject();
				o.addProperty("User_id" + i, rs2.getString("User_id"));
				o.addProperty("House_id" + i, rs2.getString("House_id"));
				o.addProperty("Comment" + i, rs2.getString("Comment"));
			
				
				ja2.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello,world");
		System.out.println(ja.toString());
		System.out.println(house_id);
		System.out.println(index);
		System.out.println(ja2.toString());
		
		session.put("house_information_list", ja.toString());
		session.put("comment_list", ja2.toString());
		
		if(index.equals("display")){
			return "change1";
		}
		if(index.equals("query")){
			return "change2";
		}
		return "fail";
	}
	
}
