package com.rainbow_weaver.league.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.rainbow_weaver.league.domain.Player;

@Namespace(value="/register")  
@ParentPackage(value="struts-default")
@Action(value="EnterPlayer")
@Results({  
   @Result(name="success", location="/register/SelectDivision.jsp"), 
   @Result(name="input", location="/register/EnterPlayer.jsp") 
})
public class EnterPlayerAction extends ActionSupport {
	private static final long serialVersionUID = -3662714052655887111L;
	private String name;
	private String address;
	private String city;
	private String email;
	
	@RequiredStringValidator(
		key="error.nameField.required",
        trim = true
	)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@RequiredStringValidator(
		key="error.addressField.required",
        trim = true
	)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@RequiredStringValidator(
		key="error.cityField.required",
        trim = true
	)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@RequiredStringValidator(
		key="error.emailField.required",
        trim = true,
        shortCircuit = true
	)
	@EmailValidator(
		key="error.emailField.format"
	)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String execute() throws Exception {
		Player player = new Player(0, name, address, city, email);
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		session.setAttribute("player", player);
		return SUCCESS;
	}
	
}
