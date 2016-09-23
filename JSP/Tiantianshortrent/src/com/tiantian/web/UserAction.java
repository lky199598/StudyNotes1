package com.tiantian.web;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	File fileTest=null;
	
	String fileTestFileName;
	String fileTestContentType;
	
	public String getFileTestFileName() {
		return fileTestFileName;
	}
	public void setFileTestFileName(String fileTestFileName) {
		this.fileTestFileName = fileTestFileName;
	}
	public String getFileTestContentType() {
		return fileTestContentType;
	}
	public void setFileTestContentType(String fileTestContentType) {
		this.fileTestContentType = fileTestContentType;
	}
	public UserAction(File fileTest) {
		super();
		this.fileTest = fileTest;
	}
	public UserAction()
	{
		
	}

	public File getFileTest() {
		return fileTest;
	}

	public void setFileTest(File fileTest) {
		this.fileTest = fileTest;
	}

	public String login() {
		System.out.println(fileTestFileName + ",                     " + fileTestContentType);
		return SUCCESS;
	}

}
