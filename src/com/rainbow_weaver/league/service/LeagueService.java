package com.rainbow_weaver.league.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rainbow_weaver.league.dao.LeagueDAO;
import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;

@Service
@Scope("singleton")
public class LeagueService {
	public static final String[] SEASONS = {"Spring", "Summer", "Fall", "Winter"};
	
	@Resource
	private LeagueDAO leagueDAO;
	
	public LeagueService() {
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
