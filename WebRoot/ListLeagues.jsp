<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rainbow_weaver.league.service.LeagueService"%>
<%@ page import="com.rainbow_weaver.league.domain.League"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <c:set var="pageTitle" value="Duke足球联赛：列出所有联赛"/>
  <head>
    <base href="<%=basePath%>">
    
    <title>${pageTitle}</title>
    
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
        <td><h3>${pageTitle}</h3></td>
      </tr>
    </table>
    <p>现有以下足球联赛</p>
    <ul>
      <%
        request.setAttribute("leagues", LeagueService.getLeagueSvc().getLeagues());
      %>
      <c:forEach items="${leagues}" var="league" >
        <li>${league.title}</li>
      </c:forEach>
    </ul>
    <a href="index.html">回首页</a>
  </body>
</html>
