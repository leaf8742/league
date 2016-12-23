package com.rainbow_weaver.league.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;
import com.rainbow_weaver.league.jdbc.JDBCUtil;

@Repository
@Scope("singleton")
public class LeagueDAO {
	private static DataSource datasource;
	
	static {
		try {
			Context ctx;
			ctx = new InitialContext();
			datasource = (DataSource)ctx.lookup("java:comp/env/jdbc/SoccerLeagueDS");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LeagueDAO() {
	}
	
	// 1. 查询所有League
	public List<League> getLeagues() throws LeagueException {
		List<League> result = new LinkedList<League>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT lid, lyear, season, title FROM League";
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int lid = rs.getInt("lid");
				int lyear = rs.getInt("lyear");
				String season = rs.getString("season");
				String title = rs.getString("title");
				result.add(new League(lid, lyear, season, title));
			}
		} catch (SQLException e) {
			throw new LeagueException(e);
		} finally {
			JDBCUtil.release(conn, stmt, rs);
		}
		return result;
	}
	
	// 2. 插入一个League
	public void insertLeagues(League league) throws LeagueException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			String insert = "INSERT INTO League(lyear, season, title) values(?, ?, ?)";
			conn = datasource.getConnection();
			stmt = conn.prepareStatement(insert);
			stmt.setInt(1, league.getYear());
			stmt.setString(2, league.getSeason());
			stmt.setString(3, league.getTitle());
			stmt.execute();
		} catch (SQLException e) {
			throw new LeagueException(e);
		} finally {
			JDBCUtil.release(conn, stmt, null);
		}
	}
}
