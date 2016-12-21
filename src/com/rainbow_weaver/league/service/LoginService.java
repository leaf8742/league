package com.rainbow_weaver.league.service;

import com.rainbow_weaver.league.dao.AdminDAO;
import com.rainbow_weaver.league.domain.Admin;
import com.rainbow_weaver.league.exception.LoginException;

public class LoginService {
    private static LoginService loginService = new LoginService();
    private AdminDAO adminUserDAO;
    
    private LoginService() {
        adminUserDAO = AdminDAO.getInstance();
    }

    public static LoginService getInstance() {
        return loginService; 
    }
    
    public Admin adminLogin(String username, String password) 
            throws LoginException {
        return adminUserDAO.retrieve(username, password);
    }
}
