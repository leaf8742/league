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
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.domain.Player;
import com.rainbow_weaver.league.service.RegisterService;

@Namespace(value="/register")  
@ParentPackage(value="struts-default")
@Action(value="SelectDivision")
@Results({  
   @Result(name="success", location="/register/RegisterSucc.jsp"), 
   @Result(name="input", location="/register/SelectDivision.jsp"),
   @Result(name="error", location="/register/EnterPlayer.jsp")
})
public class SelectDivisionAction extends ActionSupport {
	private static final long serialVersionUID = -4914864814571850353L;
	private int year;
	private String season;
	private String division;
	
    @IntRangeFieldValidator(
        key = "error.yearField.range",
        min = "2008",
        max = "2020"
    )
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
    @FieldExpressionValidator(
        fieldName = "season",
        key = "error.seasonField.required",
        expression = "season != 'UNKNOWN'"
    )
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
    @FieldExpressionValidator(
        fieldName = "division",
        key = "error.divisionField.required",
        expression = "division != 'UNKNOWN'"
    )
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		Player player = (Player)session.getAttribute("player");
		
		if (player == null) {
			return ERROR;
		}
		
		RegisterService service = RegisterService.getInstance();
		League league = service.getLeague(year, season);
		service.register(league, player, division);
		
		request.setAttribute("player", player);
		request.setAttribute("league", league);
		
		return SUCCESS;
	}
}
