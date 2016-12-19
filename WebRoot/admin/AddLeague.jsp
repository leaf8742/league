<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rainbow_weaver.league.domain.League"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <c:set var="pageTitle" value="Duke足球联赛：添加新联赛"/>
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
    <p><s:text name="message.league.addleague.header"/></p>
    <font color = "red"><s:actionerror/></font>
    <form action = "admin/AddLeague.action" method="POST">
    <table>
    <tr>
    <td>
      年份：<input type = "text" name = "year" value = "${param.year}"/>
    </td>
    <td>
      <font color="red">
      <s:fielderror name="year">
        <s:param>year</s:param>
      </s:fielderror>
      </font>
    </td>
    </tr>
    <tr>
    <td>
      季节：<select name = "season">
        <option value = "UNKNOWN">Select ...</option>
        <c:forEach items="Spring, Summer, Fall, Winter" var="season_item">
          <option value="${season_item}" 
          <c:if test="${season_item == param.season}">
          selected
          </c:if>
          >
          ${season_item}
          </option>
        </c:forEach>
      </select>
    </td>
    <td>
      <font color="red">
      <s:fielderror name="year">
        <s:param>season</s:param>
      </s:fielderror>
      </font>
    </td>
    </tr>
    <tr>
    <td>
      标题：<input type = "text" name = "title" value = "${param.title}"/>
    </td>
    <td>
      <font color="red">
      <s:fielderror name="year">
        <s:param>title</s:param>
      </s:fielderror>
      </font>
    </td>
    </tr>
    </table>
      <input type = "submit" value = "添加新联赛"/>
    </form>
    <a href="index.html">回首页</a>
  </body>
</html>
