package com.tiantian.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tiantian.dao.impl.jdbcDao;

public class create_houseAction extends ActionSupport{
	private String title_textfield;
	private String housearea;
	private String dayprice;
	private String loc_province;
	private String loc_city;
	private String loc_town;
	private File photo;
	private String surrounding;
	private String othermessage;
	
	
	private String sf;
	private String city;
	private String address;
	
	
	
	public String getSf() {
		return sf;
	}
	public void setSf(String sf) {
		this.sf = sf;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	private String photoFileName;
	private String photoContentType;
	public String getTitle_textfield() {
		return title_textfield;
	}
	public void setTitle_textfield(String title_textfield) {
		this.title_textfield = title_textfield;
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
	public String getLoc_province() {
		return loc_province;
	}
	public void setLoc_province(String loc_province) {
		this.loc_province = loc_province;
	}
	public String getLoc_city() {
		return loc_city;
	}
	public void setLoc_city(String loc_city) {
		this.loc_city = loc_city;
	}
	public String getLoc_town() {
		return loc_town;
	}
	public void setLoc_town(String loc_town) {
		this.loc_town = loc_town;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
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
	
	
	public String create_house(){
		//System.out.println("photoContentType="+photoContentType);
		
		String path= ServletActionContext.getServletContext().getRealPath("/upload");
		
		
		/*System.out.println(path);
		System.out.println("»¶Ó­À´µ½create_house.action");
		
		System.out.println(title_textfield);
		System.out.println(dayprice);
		System.out.println(surrounding);
		System.out.println(othermessage);
		System.out.println(photoFileName);
		System.out.println(photoContentType);
		System.out.println(loc_province + ", " + loc_city + ", " + loc_town);*/
		
		
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		String str=path+"\\"+session.get("current_id").toString()+new Date().getDate()+photoFileName;
		
		String photo_path="G:\\Tiantianshortrent\\WebContent\\upload";
		String s=session.get("current_id").toString()+new Date().getDate()+photoFileName;
		str=photo_path+"\\"+s;
		
		//System.out.println("path="+path);
		
		System.out.println(str);
		
		jdbcDao dao=new jdbcDao("tiantian");
		dao.House_insert(sf+city+address, 0, Double.parseDouble(dayprice), Double.parseDouble(housearea), surrounding, othermessage, "upload\\"+s, title_textfield, session.get("current_id").toString());
		
		
		//dao.rent_list_insert(User_id, House_id, User_state, House_state, End_time)
		
		System.out.println(str);
		
		try {
			FileUtils.copyFile(photo, new File(str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return "success";
	}
	
}
