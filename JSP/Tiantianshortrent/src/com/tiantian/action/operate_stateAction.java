package com.tiantian.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class operate_stateAction extends ActionSupport{
	private String House_id;
	private String User_id;
	private String index;
	public String getHouse_id() {
		return House_id;
	}
	public void setHouse_id(String house_id) {
		House_id = house_id;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
	
	public String operate_state(){
		
		jdbcDao dao=new jdbcDao("tiantian");
		System.out.println(User_id);
		System.out.println(House_id);
		System.out.println(index);
		
		if(index.equals("xiajia")){
			dao.operate_state(House_id, "", "xiajia");
			return "xiajia_success";
		}
		if(index.equals("quxiao")){
			dao.operate_state(House_id, "", "quxiao");
			return "quxiao_success";
		}
		if(index.equals("shanchu")){
			dao.operate_state(House_id, User_id, "shanchu");
			return "shanchu_success";
		}
		if(index.equals("tongyi")){
			
			dao.rent_list_state_update(User_id, House_id);
			return "tongyi_success";
		}
		if(index.equals("jvjue")){
			
			dao.rent_list_delete(User_id, House_id);
			return "jvjue_success";
		}
		
		return "fail";
	}
}
