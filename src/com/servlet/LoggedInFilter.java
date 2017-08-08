package com.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoggedInFilter
 */
@WebFilter("/LoggedInFilter")
public class LoggedInFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggedInFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		HttpServletRequest req= (HttpServletRequest) request;
		HttpSession  session = req.getSession();
		if(session.getAttribute("uType")=="Sitter"){
			System.out.println("login filter inside if");
			req.getRequestDispatcher("login.jsp").forward(request,response);
		}
	   
		else{
			System.out.println("login filter inside else");
			req.getRequestDispatcher("PerformSeeker.jsp").forward(request,response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
