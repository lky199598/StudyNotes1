package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class OneFilter
 */
@WebFilter("/OneFilter")
public class OneFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public OneFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("FirstFilter---destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Start...First...Filter");
		// pass the request along the filter chain
		
		//chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
	    
	/*	res.sendRedirect(req.getContextPath()+"/middle.jsp");*/
		
    /*req.getRequestDispatcher("middle.jsp").forward(request, response);*/
		
	req.getRequestDispatcher("main.jsp").include(request, response);
		
		//重定向，客户端行为
	/*res.sendRedirect(req.getContextPath()+"/main.jsp");*/
		
		/*//请求转发，服务器行为
		 req.getRequestDispatcher("main.jsp").forward(request, response);*/
		
		
		/*req.getRequestDispatcher("main.jsp").include(request, response);*/
		
		System.out.println("End...First...Filter");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init----First...Filter");
	}

}
