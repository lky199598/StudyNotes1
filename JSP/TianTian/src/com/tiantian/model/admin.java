package com.tiantian.model;

public class admin {
	String Admin_id;
	String Admin_name;
	String Admin_password;
	String Admin_telephone;
	String Admin_idcard;
	String Admin_mail;
	public admin(String admin_id, String admin_name, String admin_password,
			String admin_telephone, String admin_idcard, String admin_mail) {
		super();
		Admin_id = admin_id;
		Admin_name = admin_name;
		Admin_password = admin_password;
		Admin_telephone = admin_telephone;
		Admin_idcard = admin_idcard;
		Admin_mail = admin_mail;
	}
	public admin()
	{
		
	}
	public String getAdmin_id() {
		return Admin_id;
	}
	public void setAdmin_id(String admin_id) {
		Admin_id = admin_id;
	}
	public String getAdmin_name() {
		return Admin_name;
	}
	public void setAdmin_name(String admin_name) {
		Admin_name = admin_name;
	}
	public String getAdmin_password() {
		return Admin_password;
	}
	public void setAdmin_password(String admin_password) {
		Admin_password = admin_password;
	}
	public String getAdmin_telephone() {
		return Admin_telephone;
	}
	public void setAdmin_telephone(String admin_telephone) {
		Admin_telephone = admin_telephone;
	}
	public String getAdmin_idcard() {
		return Admin_idcard;
	}
	public void setAdmin_idcard(String admin_idcard) {
		Admin_idcard = admin_idcard;
	}
	public String getAdmin_mail() {
		return Admin_mail;
	}
	public void setAdmin_mail(String admin_mail) {
		Admin_mail = admin_mail;
	}
}
