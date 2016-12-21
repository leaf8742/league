package com.rainbow_weaver.league.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rainbow_weaver.league.domain.Admin;

public class LoginFilter implements Filter {
    private static final String LOGIN_PREFIX = "/admin/",
                                LOGIN_KEYWORD = "Login",
                                LOGIN_PAGE = "Login.jsp";
    
    public static final String ATTR_ADMINUSER = "login.adminUser";
    public static final String ATTR_NEXTURL = "login.nextUrl";
    
    public void init(FilterConfig filterConfig) {}
    
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        
        String requestURI = req.getRequestURI();
        String uri = requestURI.substring(requestURI.indexOf(LOGIN_PREFIX));
        if (uri.indexOf(LOGIN_KEYWORD) == -1) {
            Admin admin = (Admin)session.getAttribute(ATTR_ADMINUSER);
            if (admin == null) {
                session.setAttribute(ATTR_NEXTURL, uri);
                String loginUri = req.getContextPath() + LOGIN_PREFIX + LOGIN_PAGE;
                ((HttpServletResponse)response).sendRedirect(loginUri);
                return;               
            } 
        }
        
        chain.doFilter(request, response);
    }

    public void destroy() {}
}