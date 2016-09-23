package com.tiantian.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.tiantian.dao.impl.jdbcDao;

public class updata_user_informationAction {
	
	private String name;
	private String sex;
	private String Y;
	private String M;
	private String D;
	private String telephone;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getY() {
		return Y;
	}



	public void setY(String y) {
		Y = y;
	}



	public String getM() {
		return M;
	}



	public void setM(String m) {
		M = m;
	}



	public String getD() {
		return D;
	}



	public void setD(String d) {
		D = d;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String updata_user_information(){
		
		
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		System.out.println(session.get("current_id"));
		jdbcDao dao=new jdbcDao("tiantian");
		dao.update_User_information(session.get("current_id").toString(), 
				name, telephone, sex, 
				new Date(Integer.parseInt(Y)-1900, 
						Integer.parseInt(M)-1, 
						Integer.parseInt(D)));
		return "success";
		
		
	}
}
