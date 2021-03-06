<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rainbow_weaver.league.service.LeagueService"%>
<%@ page import="com.rainbow_weaver.league.domain.League"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<p><s:text name="message.league.listleagues.header"/></p>
<ul>
  <%
    ApplicationContext context = (ApplicationContext)application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    LeagueService leagueService = (LeagueService)context.getBean("leagueService");
    request.setAttribute("leagues", leagueService.getLeagues());
  %>
  <c:forEach items="${leagues}" var="league" >
    <li>${league.title}</li>
  </c:forEach>
</ul>
<a href="index.jsp">回首页</a>
