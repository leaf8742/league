package com.rainbow_weaver.league.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.domain.Player;
import com.rainbow_weaver.league.exception.LeagueException;
import com.rainbow_weaver.league.exception.RegisterException;

@Service
@Scope("singleton")
public class RegisterService {
    private static final String[] DIVISIONS =  
        {"Amateur", "Semi-Pro", "Professional"};
    
    public RegisterService() {
    }
    
    public League getLeague(int year, String season) throws LeagueException {
        return new League(-1, year, season, "League for tested");
    }
    
    public void register(League league, Player player, String division) 
            throws RegisterException {
        //This function will be completed later!
    }

    public String[] getAllDivisions() {
        return DIVISIONS;
    }
}
