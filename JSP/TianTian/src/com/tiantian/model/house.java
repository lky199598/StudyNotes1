package com.tiantian.model;

public class house {
	int House_id;
	String Address;
	int Rent_station;
	double Price;
	double Area;
	String Surrounding;
	String Others;
	public house(int house_id, String address, int rent_station, double price,
			double area, String surrounding, String others) {
		super();
		House_id = house_id;
		Address = address;
		Rent_station = rent_station;
		Price = price;
		Area = area;
		Surrounding = surrounding;
		Others = others;
	}
	public house()
	{
		
	}
	public int getHouse_id() {
		return House_id;
	}
	public void setHouse_id(int house_id) {
		House_id = house_id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getRent_station() {
		return Rent_station;
	}
	public void setRent_station(int rent_station) {
		Rent_station = rent_station;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getArea() {
		return Area;
	}
	public void setArea(double area) {
		Area = area;
	}
	public String getSurrounding() {
		return Surrounding;
	}
	public void setSurrounding(String surrounding) {
		Surrounding = surrounding;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}
}
