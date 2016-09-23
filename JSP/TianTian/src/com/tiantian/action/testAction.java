package com.tiantian.action;

public class testAction {
	private String sf;

	
	
	public String getSf() {
		return sf;
	}



	public void setSf(String sf) {
		this.sf = sf;
	}



	public String test(){
		System.out.println(sf);
		System.out.println("123");
		return "success";
	}
}
