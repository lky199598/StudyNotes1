package com.tiantian.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class update_house_informationAction extends ActionSupport{ 

	
	private String title_textfield;
	private String address;
	private String housearea;
	private String dayprice;
	private String surrounding;
	private String othermessage;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	
	
	private String House_id;
	
	public String getHouse_id() {
		return House_id;
	}




	public void setHouse_id(String house_id) {
		House_id = house_id;
	}




	public String getTitle_textfield() {
		return title_textfield;
	}




	public void setTitle_textfield(String title_textfield) {
		this.title_textfield = title_textfield;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getHousearea() {
		return housearea;
	}




	public void setHousearea(String housearea) {
		this.housearea = housearea;
	}




	public String getDayprice() {
		return dayprice;
	}




	public void setDayprice(String dayprice) {
		this.dayprice = dayprice;
	}




	public String getSurrounding() {
		return surrounding;
	}




	public void setSurrounding(String surrounding) {
		this.surrounding = surrounding;
	}




	public String getOthermessage() {
		return othermessage;
	}




	public void setOthermessage(String othermessage) {
		this.othermessage = othermessage;
	}




	public File getPhoto() {
		return photo;
	}




	public void setPhoto(File photo) {
		this.photo = photo;
	}




	public String getPhotoFileName() {
		return photoFileName;
	}




	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}




	public String getPhotoContentType() {
		return photoContentType;
	}




	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}




	public String update_house_information(){
	
		
		System.out.println(photoFileName);
		/*System.out.println(title_textfield);
		System.out.println(photoFileName);*/
		String path= ServletActionContext.getServletContext().getRealPath("/upload");
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String str=path+"\\"+session.get("current_id").toString()+new Date().getDate()+photoFileName;
		
		String photo_path="G:\\Tiantianshortrent\\WebContent\\upload";
		String s=session.get("current_id").toString()+new Date().getDate()+photoFileName;
		str=photo_path+"\\"+s;
		
		//System.out.println("path="+path);
		
		System.out.println(str);
		
		jdbcDao dao=new jdbcDao("tiantian");
		//dao.House_insert(address, 0, Double.parseDouble(dayprice), Double.parseDouble(housearea), surrounding, othermessage, "upload\\"+s, title_textfield, session.get("current_id").toString());
		
		//System.out.println(House_id);
		dao.update_House_information(address, dayprice, housearea, surrounding, othermessage, "upload\\"+s, House_id);
		//dao.rent_list_insert(User_id, House_id, User_state, House_state, End_time)
		
		System.out.println(str);
		
		try {
			FileUtils.copyFile(photo, new File(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
/*		System.out.println(House_id);
		System.out.println(address);
		System.out.println(dayprice);
		System.out.println(photoFileName);*/
		
		
		return "success";
	}
}
