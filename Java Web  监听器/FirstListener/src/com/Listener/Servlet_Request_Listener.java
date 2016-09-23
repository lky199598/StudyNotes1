package com.Listener;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Servlet_Request_Listener
 *
 */
@WebListener
public class Servlet_Request_Listener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public Servlet_Request_Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	 System.out.println("requestDestroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
    	try {
			arg0.getServletRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	String name  = arg0.getServletRequest().getParameter("name");
    	
        System.out.println("requestInitialized name: "+name);
    }
	
}
