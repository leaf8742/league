package com.rainbow_weaver.league.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.rainbow_weaver.league.domain.Admin;
import com.rainbow_weaver.league.exception.LoginException;

@Controller
@Scope("singleton")
public class AdminDAO {
    private static final String ERROR = "���ݿ����";
    private static final String RETRIEVE_STMT = 
            "SELECT * FROM Adminuser WHERE username=? AND password=?";
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
	
    public Admin retrieve(String name, String password) 
            throws LoginException {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet results = null;

        Admin admin = null;
        try {
            connection = datasource.getConnection();
            stmt = connection.prepareStatement(RETRIEVE_STMT);

            stmt.setString(1, name);
            stmt.setString(2, password);
            results = stmt.executeQuery();

            if (!results.next()) 
                throw new LoginException("δ�ҵ�ָ���û�");
            
            if (!results.isLast())
                throw new LoginException("�û���¼�ظ�");

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
