package com.rainbow_weaver.league.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class PerformenceFilter
 */
@WebFilter(filterName="PerformenceFilter", urlPatterns={"*.do"})
public class PerformenceFilter implements Filter {
    public PerformenceFilter() {
        // TODO Auto-generated constructor stub
    }
    
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long time = System.currentTimeMillis();
		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		System.out.println("uri:" + uri + ":" + (System.currentTimeMillis() - time) + "ms");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
