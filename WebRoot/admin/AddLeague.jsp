<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rainbow_weaver.league.domain.League"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>Duke足球联赛：添加新联赛 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body bgcolor='white'>
    <table border='1' cellpadding='5' cellspacing='0' width='400'>
      <tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
        <td><h3>Duke足球联赛：添加新联赛</h3></td>
      </tr>
    </table>
    <p>本页面用于创建新联赛 </p>
    <%
      List<String> errors = (List<String>)request.getAttribute("errors");
      if (errors != null && !errors.isEmpty()) {
        out.println("<font color = \"red\">" + "请更正以下错误信息");
        out.println("<ul>");
        for (String error : errors) {
          out.println("<li>" + error + "</li>");
        }
        out.println("</ul>");
        out.println("</font>");
      }
    %>
    <form action = "admin/add_league.do" method="POST">
    <%
      String year = request.getParameter("year");
      if (year == null) {
        year = "";
      }
      
      String season = request.getParameter("season");
      if (season == null) {
        season = "UNKNOWN";
      }
      
      String title = request.getParameter("title");
      if (title == null) {
        title = "";
      }
    %>
      年份：<input type = "text" name = "year" value = "<%= year %>"/><br/><br/>
      季节：<select name = "season">
        <option value = "UNKNOWN">Select ...</option>
        <%!
          public static final String[] seasons = {"Spring", "Summer", "Fall", "Winter"};
        %>
        <%for (String season_item : seasons) {%>
            <option value = "<%= season_item %>" 
            <% if (season_item.equals(season)) { %>
            selected
            <% } %>
            >
            
            <%= season_item %>
            </option>
        <%}%>
      </select><br/><br/>
      标题：<input type = "text" name = "title" value = "<%= title %>"/><br/><br/>
      <input type = "submit" value = "添加新联赛"/><br/><br/>
    </form>
    <a href="index.html">回首页</a>
  </body>
</html>
