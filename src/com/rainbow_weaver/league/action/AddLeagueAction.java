package com.rainbow_weaver.league.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;
import com.rainbow_weaver.league.service.LeagueService;

public class AddLeagueAction extends ActionSupport {
	private static final long serialVersionUID = 7905788763617232687L;
	private int year;
	private String season;
	private String title;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
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
			league = LeagueService.getLeagueSvc().createLeague(year, season, title);
			ActionContext ctx = ActionContext.getContext();
			HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
			request.setAttribute("new_league", league);
		} catch (LeagueException e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	@Override
	public void validate() {
		if (year >= 2010 && year <= 2020) {
		} else {
			this.addFieldError("year", "年份必须在2010到2020之间");
		}
		
		if (season.equals("UNKNOWN")) {
			this.addFieldError("season", "请选择季节");
		}
		
		if (title == null || title.equals("")) {
			this.addFieldError("title", "请输入标题");
		}
	}
}
