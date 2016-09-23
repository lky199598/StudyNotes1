package com.tiantian.web;

public class User {
	private String name;
	private String nice;
	int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNice() {
		return nice;
	}
	public void setNice(String nice) {
		this.nice = nice;
	}
	
	public User(int age, String name, String nick){
		this.age=age;
		this.name=name;
		this.nice=nick;
	}
	public void User(){
	}
	
}
