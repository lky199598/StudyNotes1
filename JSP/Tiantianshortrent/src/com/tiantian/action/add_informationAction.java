package com.tiantian.action;


import java.util.Map;
import java.util.Date;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class add_informationAction extends ActionSupport{
	private String name;
	private String sex;
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
	public String getOptionY() {
		return optionY;
	}
	public void setOptionY(String optionY) {
		this.optionY = optionY;
	}
	public String getOptionM() {
		return optionM;
	}
	public void setOptionM(String optionM) {
		this.optionM = optionM;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	private String optionY;
	private String optionM;
	private String optionD;
	private String id_card;
	private String telephone;
	
	public String add_information(){
		//System.out.println("name: " + name);
		//System.out.println("id_card: " + id_card);
		//System.out.println("telephone: " + telephone);
		//System.out.println(optionY + "Äê");
		//System.out.println(optionM + "ÔÂ");
		//System.out.println(optionD + "ÈÕ");
		
		ActionContext actionContext=ActionContext.getContext();
		Map session=actionContext.getSession();
		System.out.println(session.get("current_id"));
		jdbcDao dao=new jdbcDao("tiantian");
		dao.update_User_information(session.get("current_id").toString(), 
				name, telephone, id_card, sex, 
				new Date(Integer.parseInt(optionY)-1900, 
						Integer.parseInt(optionM)-1, 
						Integer.parseInt(optionD)));
		
		System.out.println("Hello");
		return "success";
		
	}
}
