package com.Listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestAttributeListener
 *
 */
@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletRequestAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	 System.out.println("ServletRequestAttributeListener__attributeAdded: "+arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
    	 System.out.println("ServletRequestAttributeListener__attributeRemoved: "+arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
    	System.out.println("ServletRequestAttributeListener__attributeReplaced: "+arg0.getName());
    }
	
}
