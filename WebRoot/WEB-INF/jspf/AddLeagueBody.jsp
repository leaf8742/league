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
<a href="index.jsp">回首页</a>
