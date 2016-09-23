package entity;

import java.util.ArrayList;

import dao.Cart;
import dao.ItemsDao;

public class BuyShopping {
	private int buy_id;
	private String name;
	private String city;
	private String picture;
	private double price;
	private int number;// ¹ºÂòÊýÁ¿

	public int getBuy_id() {
		return buy_id;
	}

	public void setBuy_id(int buy_id) {
		this.buy_id = buy_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicture() {
		return picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public double TotalPrice() {
		double sum = 0.0;
		ItemsDao I = new ItemsDao();

		ArrayList<BuyShopping> list = I.Select_BuyShopping();

		if (list != null && list.size() > 0) {
			for (BuyShopping bs : list) {
			
				sum += (bs.getPrice()) * (bs.getNumber());
			}
		}
		return sum;
	}

}
