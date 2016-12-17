package com.rainbow_weaver.league.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainbow_weaver.league.domain.League;
import com.rainbow_weaver.league.exception.LeagueException;
import com.rainbow_weaver.league.service.LeagueService;

/**
 * Servlet implementation class AddLeagueServlet
 */
@WebServlet(name="AddLeagueServlet", urlPatterns = "/admin/add_league.do")
public class AddLeagueServlet extends HttpServlet {
	private static final long serialVersionUID = -2044381377972190991L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String year = req.getParameter("year").trim();
		String season = req.getParameter("season").trim();
		String title = req.getParameter("title").trim();

		int int_year = 0;
		
		List<String> errors = new LinkedList<String>();
		try {
			int_year = Integer.parseInt(year);
			if (int_year >= 2010 && int_year <= 2020) {
			} else {
				errors.add("年份必须在2010到2020之间");
			}
		} catch (NumberFormatException e) {
			errors.add("请输入合法的年份");
		}
		
		if (season.equals("UNKNOWN")) {
			errors.add("请选择季节");
		}
		
		if (title == null || title.equals("")) {
			errors.add("请输入标题");
		}
		
		if (!errors.isEmpty()) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("/admin/AddLeague.jsp").forward(req, resp);
			return;
		}
		
		League league;
		try {
			league = LeagueService.getLeagueSvc().createLeague(int_year, season, title);
			req.setAttribute("new_league", league);
			req.getRequestDispatcher("/admin/AddLeagueSucc.jsp").forward(req, resp);
		} catch (LeagueException e) {
			errors.add(e.getMessage());
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("/admin/AddLeague.jsp").forward(req, resp);
		}
	}
}
