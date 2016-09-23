package com.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class HttpSessionListener
 *
 */
@WebListener
public class Http_Session_Listener implements javax.servlet.http.HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Http_Session_Listener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see Http_Session_Listener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         System.out.println("sessionCreated");
    }

	/**
     * @see Http_Session_Listener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("sessionDestroyed");
    }
	
}
