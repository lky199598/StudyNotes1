package com.tiantian.model;

import java.util.Date;

public class list {
	public list(String user_id, int house_id, int rent_rented_station,
			Date end_time) {
		super();
		User_id = user_id;
		House_id = house_id;
		Rent_rented_station = rent_rented_station;
		End_time = end_time;
	}
	public list()
	{
		
	}
	String User_id;
	int House_id;
	int Rent_rented_station;
	Date End_time;
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public int getHouse_id() {
		return House_id;
	}
	public void setHouse_id(int house_id) {
		House_id = house_id;
	}
	public int getRent_rented_station() {
		return Rent_rented_station;
	}
	public void setRent_rented_station(int rent_rented_station) {
		Rent_rented_station = rent_rented_station;
	}
	public Date getEnd_time() {
		return End_time;
	}
	public void setEnd_time(Date end_time) {
		End_time = end_time;
	}
}
