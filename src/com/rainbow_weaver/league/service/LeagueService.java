package com.rainbow_weaver.league.service;

import java.util.LinkedList;
import java.util.List;

import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;

public class LeagueService {
	private static LeagueService sharedClient = new LeagueService();
	
	private List<League> leagues = null;
	
	private LeagueService() {
		super();
		leagues = new LinkedList<League>();
	    leagues.add(new League(2008, "Spring", "Soccer League (Spring \"08)"));
	    leagues.add(new League(2008, "Summer", "Summer Soccer Fest 2008"));
	    leagues.add(new League(2008, "Fall", "Fall Soccer League  (2008)"));
	    leagues.add(new League(2009, "Spring", "Soccer League (Spring \"09)"));
	    leagues.add(new League(2009, "Summer", "The Summer of Soccer Love 2009"));
	    leagues.add(new League(2009, "Fall", "Fall Soccer League (2009)"));
	}
	
	public static LeagueService getLeagueSvc() {
		return sharedClient;
	}
	
	public List<League> getLeagues() {
		return leagues;
	}
	
	public void setLeagues(List<League> leagues) throws LeagueException {
		this.leagues = leagues;
	}
	
	public League createLeague(int year, String season, String title) throws LeagueException {
		League result = new League(year, season, title);
		leagues.add(result);
		return result;
	}
}
