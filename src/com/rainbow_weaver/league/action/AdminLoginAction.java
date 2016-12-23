package com.rainbow_weaver.league.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.rainbow_weaver.league.domain.Admin;
import com.rainbow_weaver.league.exception.LoginException;
import com.rainbow_weaver.league.service.LoginService;
import com.rainbow_weaver.league.web.LoginFilter;

@Namespace(value="/admin")
@ParentPackage(value="struts-default")
@Action(value="Login")
@Results({  
   @Result(name="success", type="redirect", location="${forwardUrl}"), 
   @Result(name="input", location="/admin/Login.jsp") 
})
@Controller
@Scope("prototype")
public class AdminLoginAction extends ActionSupport {
	private static final long serialVersionUID = -4789973751801066933L;
	private String forwardUrl;
    private String username;
    private String password;

    @Resource
    private LoginService loginService;
    
    public String getForwardUrl() {
        return forwardUrl;
    }

    @RequiredStringValidator(
        type = ValidatorType.FIELD,
        key = "error.login.username.required",
        trim = true
    )
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @RequiredStringValidator(
        type = ValidatorType.FIELD,
        key = "error.login.password.required",
        trim = true
    )
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() {
        Admin admin = null;
        try {
            admin = loginService.adminLogin(username, password);
        } catch (LoginException e) {
            this.addActionError(
                    getText("error.login.failure", new String[]{e.getMessage()}));
            return INPUT;
        }
        
        ActionContext ctx = ActionContext.getContext(); 
        HttpServletRequest request = 
                (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);  
        HttpSession session = request.getSession();
        session.setAttribute(LoginFilter.ATTR_ADMINUSER, admin);  
                
        forwardUrl = (String)session.getAttribute(LoginFilter.ATTR_NEXTURL);
        if (forwardUrl == null) forwardUrl = "/";     //when session timeout
 
        return SUCCESS;
    }
}