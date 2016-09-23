package com.tiantian.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.tiantian.dao.impl.jdbcDao;

public class manage_userAction {
	public String manage(){
		
		jdbcDao dao=new jdbcDao("tiantian");
		ResultSet res=dao.select_from_Table("user");
		
		
		JsonArray ja=new JsonArray();
		try {
			int i=0;
			while(res.next()){
				String id=res.getString("User_id");
				String name=res.getString("User_name");
				String sex=res.getString("User_sex");
				String telephone=res.getString("User_telephone");
				String idcard=res.getString("User_idcard");
				String birthday=res.getString("User_birthday");
				
				/*System.out.println("--------");
				System.out.println(name);*/
				
				JsonObject o=new JsonObject();
				o.addProperty("User_id" + i, id);
				o.addProperty("User_name" + i, name);
				o.addProperty("User_sex" + i, sex);
				o.addProperty("User_telephone" + i, telephone);
				o.addProperty("User_idcard" + i, idcard);
				o.addProperty("User_birthday" + i, birthday);
				
				ja.add(o);
				
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(ja.toString());
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.put("user_list", ja.toString());
		return "success";
	}
}
