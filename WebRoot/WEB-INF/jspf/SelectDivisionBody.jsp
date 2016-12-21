<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rainbow_weaver.league.service.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%  
    pageContext.setAttribute("leagueSvc", LeagueService.getLeagueSvc());
    pageContext.setAttribute("regSvc", RegisterService.getInstance());
%>

<table border='1' cellspacing='0' cellpadding='0' width='400'>
    <tr height='30'>
        <td bgcolor='#CCCCCC' align='center' valign='middle' height='30'>
            <b>1) 输入球员信息</b>
        </td>
        <td bgcolor='#CCCCFF' align='center' valign='middle' height='30'>
            <b>2) 选择联赛和分组</b>
        </td>
    </tr>
</table>
<br/><font color='red'><s:actionerror /></font>

<form action='<c:url value="register/SelectDivision.action" />' method='POST'>
    <table>
        <tr>
            <td>年 份：<input type='text' name='year' value='${param.year}' /><br/><br/></td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>year</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
        <tr>
            <td>
                <c:set var="seasonList" value="${leagueSvc.seasons}" />
                                                    季 节：<select name='season'>
                    <c:if test="${(empty param.season) or (param.season eq 'UNKNOWN')}">
                        <option value='UNKNOWN'>select...</option>
                    </c:if>
                    <c:forEach var="season" items="${seasonList}">
                        <option value='${season}'
                            <c:if test="${season eq param.season}">
                                selected
                            </c:if>
                        >${season}</option>
                    </c:forEach>
                </select> <br/><br/>
            </td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>season</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
        <tr>
            <td>
                <c:set var="divisionList" value="${regSvc.allDivisions}" />
                                                    分 组：<select name='division'>
                    <c:if test="${(empty param.division) or (param.division eq 'UNKNOWN')}">
                        <option value='UNKNOWN'>select...</option>
                    </c:if>
                    <c:forEach var="division" items="${divisionList}">
                        <option value='${division}'
                            <c:if test="${division eq param.division}">
                                selected
                            </c:if>
                        >${division}</option>
                    </c:forEach>
                </select> <br/><br/>
            </td>
            <td>
                <font color='red' size="-1">
                    <i><s:fielderror><s:param>division</s:param></s:fielderror></i>
                </font>
            </td>
        </tr>
    </table>
    <input type='submit' value="注 册"/>
</form>
<a href="index.jsp">回首页</a>
