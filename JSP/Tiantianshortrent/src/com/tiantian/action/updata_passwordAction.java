package com.tiantian.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tiantian.dao.impl.jdbcDao;

public class updata_passwordAction {
	private String oldpassword;
	private String newpassword;
	private String repeatnewpassword;
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getRepeatnewpassword() {
		return repeatnewpassword;
	}
	public void setRepeatnewpassword(String repeatnewpassword) {
		this.repeatnewpassword = repeatnewpassword;
	}
	
	
	public String updata_password(){
		
		System.out.println("Hello, world");
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		
		jdbcDao dao=new jdbcDao("tiantian");
		
		if(!dao.Logging_User_or_Admin("user", session.get("current_id").toString(), oldpassword)){
			return "fail";
		}
		else{
			if(!newpassword.equals(repeatnewpassword))
				return "fail";
		}
		dao.update_User_information( session.get("current_id").toString(), newpassword);
		return "success";
		
		
	}
	
}
