package com.rainbow_weaver.league.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rainbow_weaver.league.domain.League;

public class LeagueJDBC {
	public static void main(String[] args) {
		queryPrint();
	}
	
	// 1. 查询数据表中的数据
	public static void queryPrint() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM League";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/SoccerLeague";
			con = DriverManager.getConnection(url, "root", "111111");
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
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

	
	// 3. 更新数据表中的数据
	
	// 4. 删除表中的数据
}
