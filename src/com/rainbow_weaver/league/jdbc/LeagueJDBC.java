package com.rainbow_weaver.league.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueJDBC {
	public static void main(String[] args) {
//		queryPrint();
		insertLeague(2019, "Winter", "Winter of 2019");
	}
	
	// 1. 查询数据表中的数据
	public static void queryPrint() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM League";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/SoccerLeague";
			con = DriverManager.getConnection(url, "root", "111111");
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int year = rs.getInt("lyear");
				String season = rs.getString("season");
				String title = rs.getString("title");
				System.out.println(year + season + title);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// 2. 插入数据至数据表
	public static void insertLeague(int lyear, String season, String title) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			String insert = "INSERT INTO League(lyear, season, title) values(?, ?, ?)";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/SoccerLeague";
			con = DriverManager.getConnection(url, "root", "111111");
			stmt = con.prepareStatement(insert);
			stmt.setInt(1, lyear);
			stmt.setString(2, season);
			stmt.setString(3, title);
			stmt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// 3. 更新数据表中的数据
	
	// 4. 删除表中的数据
}
