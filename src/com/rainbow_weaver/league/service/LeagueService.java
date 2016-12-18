package com.rainbow_weaver.league.service;

import java.util.List;

import javax.naming.NamingException;

import com.rainbow_weaver.league.dao.LeagueDAO;
import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;

public class LeagueService {
	private static LeagueService sharedClient = new LeagueService();
	public static final String[] SEASONS = {"Spring", "Summer", "Fall", "Winter"};
	private LeagueDAO leagueDAO;
	
	private LeagueService() {
		try {
			this.leagueDAO = LeagueDAO.getLeagueDAO();
		} catch (NamingException e) {
			e.printStackTrace();
//			throw new LeagueException(e);
		}
	}
	
	public static LeagueService getLeagueSvc() {
		return sharedClient;
	}
	
	public List<League> getLeagues() throws Exception {
		try {
			return leagueDAO.getLeagues();
		} catch (LeagueException e) {
			throw new Exception(e);
		}
	}
	
	public League createLeague(int year, String season, String title) throws LeagueException {
		League result = new League(year, season, title);
		leagueDAO.insertLeagues(result);
		return result;
	}
	
	public String[] getSeasons() {
		return SEASONS;
	}
}
