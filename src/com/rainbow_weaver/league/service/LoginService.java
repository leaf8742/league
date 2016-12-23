package com.rainbow_weaver.league.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rainbow_weaver.league.dao.AdminDAO;
import com.rainbow_weaver.league.domain.Admin;
import com.rainbow_weaver.league.exception.LoginException;

@Service
@Scope("singleton")
public class LoginService {
	@Resource
    private AdminDAO adminUserDAO;
    
    public Admin adminLogin(String username, String password) 
            throws LoginException {
        return adminUserDAO.retrieve(username, password);
    }
}
