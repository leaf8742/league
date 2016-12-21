<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
    <head>
        <base href="<%=basePath%>">
        <title>${pageTitle}</title>
        <meta HTTP-EQUIV=Content-Type content="text/html; charset=utf-8">
    </head>
    <body bgcolor='white'>
        <table border='0' width='800' cellspacing='0' cellpadding='5' align="center">
            <tr>
                <td width="200" align='center' valign='middle'>
                    <%@include file="/WEB-INF/jspf/common/logo.jsp" %>
                </td>
                <td width="600" align='center' bgcolor='#CCCCFF' valign='middle'>
                    <jsp:include page="/WEB-INF/jspf/common/banner.jsp" />
                </td>
            </tr>

            <tr>
                <td bgcolor='#CCCCFF' align='left' valign='top' height="300">
                    <%@include file="/WEB-INF/jspf/common/navigation.jsp" %>
                </td>
                <td align='left' valign='top'>
                    <jsp:include page="/WEB-INF/jspf/${mainBody}" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align='right'>
                    <%@include file="/WEB-INF/jspf/common/footer.jsp" %>
                </td>
            </tr>
        </table>
    </body>
</html>
