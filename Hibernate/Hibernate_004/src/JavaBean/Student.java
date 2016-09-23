package JavaBean;

import java.sql.Blob;
import java.util.Date;

public class Student {

	private int id;
	private String name;
	private Date date;
	private Blob picture;
	
	public Student(){}

	public Student(int id, String name, Date date, Blob picture) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}


	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

/*	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", date=" + date
				+ ", picture=" + picture + "]";
	}*/



	
	
}
