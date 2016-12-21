package com.rainbow_weaver.league.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.rainbow_weaver.league.domain.Admin;
import com.rainbow_weaver.league.exception.LoginException;

public class AdminDAO {
    private static final String ERROR = "数据库错误：";
    private static final String RETRIEVE_STMT = 
            "SELECT * FROM Adminuser WHERE username=? AND password=?";
    private static AdminDAO adminDAO = new AdminDAO();
    private DataSource ds;

    private AdminDAO() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/SoccerLeagueDS");
        } catch (NamingException e) {}
    }
    
    public static AdminDAO getInstance() {
        return adminDAO; 
    }
    
    public Admin retrieve(String name, String password) 
            throws LoginException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet results = null;

        Admin admin = null;
        try {
            connection = ds.getConnection();
            stmt = connection.prepareStatement(RETRIEVE_STMT);

            stmt.setString(1, name);
            stmt.setString(2, password);
            results = stmt.executeQuery();

            if (!results.next()) 
                throw new LoginException("未找到指定用户");
            
            if (!results.isLast())
                throw new LoginException("用户记录重复");

            admin = new Admin(results.getInt("uid"),
                              results.getString("username"),
                              results.getString("password"));

            return admin;
        } catch (SQLException e) {
            throw new LoginException(ERROR + e.getMessage());
        } finally {
            if (results != null) {
                try { results.close(); } catch (SQLException se) { }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException se) { }
            }
            if (connection != null) {
                try { connection.close(); } catch (Exception e) { }
            }
        } 
    } 
}
