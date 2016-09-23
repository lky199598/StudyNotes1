package com.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class FirstListener
 *
 */
@WebListener
public class FirstListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FirstListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("contextInitialized\n");
        
        String param = arg0.getServletContext().getInitParameter("Param");
        System.out.println("Param: "+param);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("contextDestroyed");
    }
	
}
