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
    
     <title>Duke足球联赛：列出所有联赛</title>
    
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
        <td><h3>Duke足球联赛：列出所有联赛</h3></td>
      </tr>
    </table>
    <p>本页面是Duke足球联赛首页 </p>
    <%
     List<League> leagues = new LinkedList<League>();
     leagues.add(new League(2008, "Spring", "Soccer League (Spring \"08)"));
     leagues.add(new League(2008, "Summer", "Summer Soccer Fest 2008"));
     leagues.add(new League(2008, "Fall", "Fall Soccer League  (2008)"));
     leagues.add(new League(2009, "Spring", "Soccer League (Spring \"09)"));
     leagues.add(new League(2009, "Summer", "The Summer of Soccer Love 2009"));
     leagues.add(new League(2009, "Fall", "Fall Soccer League (2009)"));
    %>
    <ul>
      <%
        for (League league : leagues) {
          out.println("<li>" + league.getTitle() + "</li>");
        }
      %>
    </ul>
    <a href="index.html">回首页</a>
  </body>
</html>
