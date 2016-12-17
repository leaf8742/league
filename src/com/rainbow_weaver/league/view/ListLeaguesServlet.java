package com.rainbow_weaver.league.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainbow_weaver.league.domain.League;

/**
 * Servlet implementation class ListLeaguesServlet
 */
public class ListLeaguesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<League> leagues = new LinkedList<League>();
		leagues.add(new League(2008, "Spring", "Soccer League (Spring \"08)"));
		leagues.add(new League(2008, "Summer", "Summer Soccer Fest 2008"));
		leagues.add(new League(2008, "Fall", "Fall Soccer League  (2008)"));
		leagues.add(new League(2009, "Spring", "Soccer League (Spring \"09)"));
		leagues.add(new League(2009, "Summer", "The Summer of Soccer Love 2009"));
		leagues.add(new League(2009, "Fall", "Fall Soccer League (2009)"));
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta HTTP-EQUIV=Content-Type content=\"text/html; charset=utf-8\">");
		out.println("<title>Duke足球联赛：列出所有联赛</title>");
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		out.println("<!-- Page Heading -->");
		out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
		out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
		out.println("<td><h3>Duke足球联赛：列出所有联赛</h3></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<p>本页面是Duke足球联赛首页 </p>");
		out.println("<ul>");
		for (League league : leagues) {
			out.println("<li>" + league.getTitle() + "</li>");
		}
		out.println("</ul>");
		out.println("<a href=\"index.html\">回首页</a>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
}
