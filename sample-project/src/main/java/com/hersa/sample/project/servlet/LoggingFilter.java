package com.hersa.sample.project.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hersa.sample.project.AccessBO;
import com.hersa.sample.project.test.Triangle;





/**
 * Servlet Filter implementation class LoggingFilter
 */

@WebFilter("/LoggingFilter")

public class LoggingFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public LoggingFilter() {
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
		   //blacklisted ips.
			List<String> blackList = new ArrayList<String>();
			blackList.add("0:0:0:0:0:0:0:1");
			
		
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			
			
			Map<String, String> map = new HashMap<String, String>();
	        Enumeration headerNames = req.getHeaderNames();
	        while (headerNames.hasMoreElements()) {
	            String key = (String) headerNames.nextElement();
	            String value = req.getHeader(key);
	            map.put(key, value);
	        }
		
		
		
		String remoteIP = request.getRemoteHost();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AccessBO accessBean = (AccessBO) context.getBean("accessBean");
		if (blackList.contains(remoteIP)) {
			System.out.println("You are on a black list: redirecting..");
			accessBean.setHeader("Your IP Address id Black Listed");
			accessBean.setMessage("Please contact an admin");
			res.sendRedirect(req.getContextPath() + "/access.xhtml");
		}
		Date accessDate = new Date();
		request.getParameter("useragent");
		 System.out.println("remote address: " + remoteIP);
		 System.out.println("access date: " + accessDate);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
