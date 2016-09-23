package com.Listener;

import java.io.Serializable;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Application Lifecycle Listener implementation class User
 *
 */
@WebListener
public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {

	private String username;
	private String password;
    /**
     * Default constructor. 
     */
    public User() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         System.out.println("valueUnbound Name: "+arg0.getName());
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0)  { 
        System.out.println("valueBound Name: "+arg0.getName());
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

	@Override
//活化
	public void sessionDidActivate(HttpSessionEvent arg0) {
		System.out.println("活化: sessionDidActivate: "+arg0.getSource());
		
	}

	//钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("钝化:sessionWillPassivate: "+arg0.getSource());
	}
	
}
