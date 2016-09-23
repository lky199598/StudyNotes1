package com.po;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String email;
	private String gender;
	private Date birthday;
	private String[] favorite;
	private String introduce;
	private boolean isAccept;

	public User() {
	}

	public User(String username, String password, String email, String gender,
			Date birthday, String[] favorite, String introduce, boolean isAccept) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.favorite = favorite;
		this.introduce = introduce;
		this.isAccept = isAccept;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String[] getFavorite() {
		return favorite;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public void setFavorite(String[] favorite) {
		this.favorite = favorite;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}
