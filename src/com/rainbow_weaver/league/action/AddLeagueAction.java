package com.rainbow_weaver.league.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;
import com.rainbow_weaver.league.service.LeagueService;

@Namespace(value="/admin")  
@ParentPackage(value="struts-default")
@Action(value="AddLeague")
@Results({  
   @Result(name="success", location="/admin/AddLeagueSucc.jsp"), 
   @Result(name="input", location="/admin/AddLeague.jsp") 
})

@Controller
@Scope(value="prototype")
public class AddLeagueAction extends ActionSupport {
	private static final long serialVersionUID = 7905788763617232687L;
	private int year;
	private String season;
	private String title;
	
	@Resource
	private LeagueService leagueService;
	
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
	@RequiredStringValidator(
        key = "error.titleField.required",
        trim = true,
        shortCircuit = true
    )
    @StringLengthFieldValidator(
        key = "error.titleField.length",
        minLength = "4",
        maxLength = "30"
    )
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String execute() throws Exception {
		League league;
		try {
			league = leagueService.createLeague(year, season, title);
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			request.setAttribute("new_league", league);
		} catch (LeagueException e) {
			this.addActionError(getText("error.league.created", new String[]{e.getMessage()}));
			return INPUT;
		}
		return SUCCESS;
	}
}
